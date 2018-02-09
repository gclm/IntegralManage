package org.future.ims.controller;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.future.ims.pojo.ImsClass;
import org.future.ims.pojo.ImsStudent;
import org.future.ims.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.future.ims.utils.CharacterEncoding;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/class")
public class ClassController {

	@Autowired
	private ClassService classService;

	//导入班级中转
	@RequestMapping("/addCla.do")
	public String addStu(Model model) {
		return "administrator/addClass";

	}
	
	// 添加班级
	@ResponseBody
	@RequestMapping(value = "/addClass.do", method = RequestMethod.PUT)
	public String addStudent(Model model, ImsClass clas) {
		List<ImsClass> classByName = classService.getCompletelyClassByName(clas.getClassName());
		if (classByName.size() == 0) {
			int result = classService.addClass(clas);
			if (result > 0) {
				return "ok";
			}
		} else {
			return "no";
		}
		return null;
	}

	// 批量添加班级
	@RequestMapping("/import.do")
	public String impotr(HttpServletRequest request, Model model) throws Exception {
		// 获取上传的文件
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		MultipartFile file = multipart.getFile("upfile");
		InputStream in = file.getInputStream();
		if (file.isEmpty()) {
			// 批量导入,判断文件是否为空
			model.addAttribute("addClassMessage", "文件为空");
			return "administrator/addClass";
		} else {
			// 数据导入
			List<ImsClass> importExcelInfo = classService.importExcelInfo(in, file);
			in.close();
			String str = "";
			if (importExcelInfo.size() == 0) {
				model.addAttribute("addClassMessage", "恭喜您,批量导入成功");
			} else {
				for (int i = 0; i < importExcelInfo.size(); i++) {
					str += "班级:" + importExcelInfo.get(i).getClassName() + "重复\n";
					model.addAttribute("addClassMessage", str);
				}
			}
			return "administrator/addClass";
		}
	}

	// 显示班级列表
	@RequestMapping(value = "/classList.do")
	public String studentList(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model, String replace)
			throws UnsupportedEncodingException {
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 20);
		if (replace == null) {
			List<ImsClass> classes = classService.getClassAll();
			// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
			// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
			PageInfo page = new PageInfo(classes, 5);
			model.addAttribute("pageInfo", page);
			model.addAttribute("replace", replace);
		} else {
			String aaa = new CharacterEncoding().getEncoding(replace);
			if (aaa != "GB2312") {
				replace = new String(replace.getBytes("iso8859-1"), "utf-8");
			}
			List<ImsClass> sele = classService.getClassByName(replace);
			if (sele.size() == 0) {
				model.addAttribute("searchMeg", "没有你所查询的信息");
				PageInfo page = new PageInfo(sele, 5);
				model.addAttribute("pageInfo", page);
				model.addAttribute("replace", replace);
			} else {
				PageInfo page = new PageInfo(sele, 5);
				model.addAttribute("pageInfo", page);
				model.addAttribute("replace", replace);
			}
		}
		return "administrator/classList";
	}

	@ResponseBody
	@RequestMapping(value = "/deleteClass.do", method = RequestMethod.POST)
	public void deleteClass(@RequestParam(name = "ids") String ids) {
		// 批量删除
		if (ids != "") {
			if (ids.contains("-")) {
				List<Integer> del_ids = new ArrayList<Integer>();
				String[] str_ids = ids.split("-");
				// 组装id的集合
				for (String string : str_ids) {
					del_ids.add(Integer.parseInt(string));
				}
				for (Integer id : del_ids) {
					classService.deleteByPrimaryKey(id);
				}
			} else {
				Integer id = Integer.parseInt(ids);
				classService.deleteByPrimaryKey(id);
			}
		}
	}

	// 修改班级信息
	@ResponseBody
	@RequestMapping(value = "/updateClass.do", method = RequestMethod.PUT)
	public String updateClass(ImsClass imsClass, HttpServletRequest request) {
		// 1.先查重
		List<ImsClass> classByName = classService.getCompletelyClassByName(imsClass.getClassName());
		if (classByName.size() == 0) {
			classService.updateByPrimaryKeySelective(imsClass);
			return "ok";
		} else {
			return "no";
		}
	}
}
