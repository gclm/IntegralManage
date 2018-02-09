package org.future.ims.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.log4j.chainsaw.Main;
import org.future.ims.mapper.ImsIntegralMapper;
import org.future.ims.pojo.ImsClass;
import org.future.ims.pojo.ImsClubroom;
import org.future.ims.pojo.ImsIntegral;
import org.future.ims.pojo.ImsSemester;
import org.future.ims.pojo.ImsStudent;
import org.future.ims.pojo.QueryVoIntegral;
import org.future.ims.service.ClassService;
import org.future.ims.service.ClubroomService;
import org.future.ims.service.IntegralService;
import org.future.ims.service.SemesterService;
import org.future.ims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.future.ims.utils.CharacterEncoding;
import org.future.ims.utils.ExportUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/integral")
public class IntegralController {

	@Autowired
	private IntegralService integralService;
	@Autowired
	private SemesterService semesterService;
	@Autowired
	private ClassService classService;
	@Autowired
	private ClubroomService clubroomService;
	@Autowired
	private StudentService studentService;

	public QueryVoIntegral map;

	// 积分添加中转
	@RequestMapping("/addInte.do")
	private String addInte(Model model) {
		// 加载所有的班级
		List<ImsClass> classAll = classService.getClassAll();
		model.addAttribute("allClass", classAll);
		// 加载所有的部室
		List<ImsClubroom> clubroom = clubroomService.getClubroom();
		model.addAttribute("allRoom", clubroom);
		// 加载所有学期
		List<ImsSemester> semesterAll = semesterService.getSemesterAll();
		model.addAttribute("allSemester", semesterAll);
		return "administrator/addIntegral";
	}

	// 单个录入积分
	// 单个添加用户
	@RequestMapping("/addIntegral.do")
	public String addStudent(Model model, ImsIntegral integral) {
		// 插入之前查询信息是否属实
		// 1.查询有无此学生
		ImsStudent studentByStudentId = studentService.getStudentByStudentId(integral.getStudentId());
		// 当同时满足一下条件时，才放行
		// 存在此学生学号且姓名、班级与所录入的一致
		if (studentByStudentId != null && studentByStudentId.getGrades().equals(integral.getGrades())
				&& studentByStudentId.getName().equals(integral.getStudentName())) {
			//加入了积分查重
			List<ImsIntegral> queryRepetition = integralService.queryRepetition(integral.getStudentName(), integral.getStudentId(), 
					integral.getGrades(),integral.getScore(), integral.getReason(), integral.getTime(), 
					integral.getClubroom(), integral.getIntSemester());
			if(queryRepetition.size() == 0){
				integralService.insert(integral);
				model.addAttribute("addIntegralMessage", "恭喜您，添加成功！");
			}else{
				String str = "该条积分信息录入失败！此条信息以存在\n";
				str += "学生姓名:" + integral.getName() + ",学号:" + integral.getStudentId() + ",班级" + integral.getGrades()
				+ ",积分" + integral.getScore() + ",原因" + integral.getReason() + ",时间" + integral.getTime() + ",部室"
				+ integral.getClubroom() + "\n";
				model.addAttribute("addIntegralMessage", str);
			}
		} else {
			String str = "以下积分信息录入失败！请检查学生信息是否正确\n";
			str += "学生姓名:" + integral.getName() + ",学号:" + integral.getStudentId() + ",班级" + integral.getGrades()
					+ ",积分" + integral.getScore() + ",原因" + integral.getReason() + ",时间" + integral.getTime() + ",部室"
					+ integral.getClubroom() + "\n";
			try {
				FileWriter writer = new FileWriter("D:\\error.txt");
				writer.write(str);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			model.addAttribute("addIntegralMessage", str);
		}
		// 加载所有的班级
		List<ImsClass> classAll = classService.getClassAll();
		model.addAttribute("allClass", classAll);
		// 加载所有的部室
		List<ImsClubroom> clubroom = clubroomService.getClubroom();
		model.addAttribute("allRoom", clubroom);
		// 加载所有学期
		List<ImsSemester> semesterAll = semesterService.getSemesterAll();
		model.addAttribute("allSemester", semesterAll);
		return "administrator/addIntegral";
	}

	// 批量录入积分
	@RequestMapping("/import.do")
	public String impotr(HttpServletRequest request, Model model, String semester, String name) throws Exception {
		// 获取上传的文件
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		MultipartFile file = multipart.getFile("upfile");
		InputStream in = file.getInputStream();
		if(file.isEmpty()){
			model.addAttribute("addIntegralMessage", "文件为空！");
			// 加载所有的班级
			List<ImsClass> classAll = classService.getClassAll();
			model.addAttribute("allClass", classAll);
			// 加载所有的部室
			List<ImsClubroom> clubroom = clubroomService.getClubroom();
			model.addAttribute("allRoom", clubroom);
			// 加载所有学期
			List<ImsSemester> semesterAll = semesterService.getSemesterAll();
			model.addAttribute("allSemester", semesterAll);
			return "administrator/addIntegral";
			
		}else{
			// 数据导入
			List<ImsIntegral> excelInfo = integralService.importExcelInfo(in, file, semester, name);
			in.close();
			String str = "本次录入失败信息已经导入D:error.txt文件下\r\n以下积分信息录入失败！请检查学生信息是否正确，录入部室是否存在,积分信息是否已经存在\r\n";
			if (excelInfo.size() == 0) {
				model.addAttribute("addIntegralMessage", "恭喜您,批量导入成功");
			} else {
				for (int i = 0; i < excelInfo.size(); i++) {
					str += "学生姓名:" + excelInfo.get(i).getStudentName() + ",学号:" + excelInfo.get(i).getStudentId() + ",班级"
							+ excelInfo.get(i).getGrades() + ",积分" + excelInfo.get(i).getScore() + ",原因"
							+ excelInfo.get(i).getReason() + ",时间" + excelInfo.get(i).getTime() + ",部室"
							+ excelInfo.get(i).getClubroom() + "\r\n";
					try {
						FileWriter writer = new FileWriter("D:\\error.txt");
						writer.write(str);
						writer.flush();
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					model.addAttribute("addIntegralMessage", str);
				}
			}
			// 加载所有的班级
			List<ImsClass> classAll = classService.getClassAll();
			model.addAttribute("allClass", classAll);
			// 加载所有的部室
			List<ImsClubroom> clubroom = clubroomService.getClubroom();
			model.addAttribute("allRoom", clubroom);
			// 加载所有学期
			List<ImsSemester> semesterAll = semesterService.getSemesterAll();
			model.addAttribute("allSemester", semesterAll);
			return "administrator/addIntegral";
		}
	}

	// 得到所有积分
	@RequestMapping(value = "/integralList.do")
	public String integralList(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model)
			throws UnsupportedEncodingException {
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 30);
		List<ImsIntegral> allIntegral = integralService.getAllIntegral();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(allIntegral, 5);
		model.addAttribute("pageInfo", page);
		// 加载所有的班级
		List<ImsClass> classAll = classService.getClassAll();
		model.addAttribute("allClass", classAll);
		// 传个初值，让其显示选择
		model.addAttribute("voClass", "");
		// 加载所有的部室
		List<ImsClubroom> clubroom = clubroomService.getClubroom();
		model.addAttribute("allRoom", clubroom);
		// 传个初值，让其显示选择
		model.addAttribute("voClub", "");
		// 加载所有学期
		List<ImsSemester> semesterAll = semesterService.getSemesterAll();
		model.addAttribute("allSemester", semesterAll);
		// 传个初值，让其显示选择
		model.addAttribute("voSemester", "");
		// 分页地址
		model.addAttribute("adss", "integralList.do");
		return "administrator/integralList";
	}

	// 删除二合一
	@ResponseBody
	@RequestMapping(value = "/deleteIntegral.do", method = RequestMethod.POST)
	public void deleteIntegral(@RequestParam(name = "ids") String ids) {
		if (ids != "") {
			// 批量删除
			if (ids.contains("-")) {
				List<Integer> del_ids = new ArrayList<Integer>();
				String[] str_ids = ids.split("-");
				// 组装id的集合
				for (String string : str_ids) {
					del_ids.add(Integer.parseInt(string));
				}
				for (Integer id : del_ids) {
					integralService.deleteByPrimaryKey(id);
				}
			} else {
				Integer id = Integer.parseInt(ids);
				integralService.deleteByPrimaryKey(id);
			}
		}
	}

	// 多条件的查询
	@RequestMapping(value = "/list.do")
	public String list(QueryVoIntegral voQueryVoIntegral, Model model,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) throws UnsupportedEncodingException {
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 30);
		if (voQueryVoIntegral.getVoStuIdAndName() == null && voQueryVoIntegral.getVoClass() == null
				&& voQueryVoIntegral.getVoClub() == null && voQueryVoIntegral.getVoSemester() == null) {
			voQueryVoIntegral = map;
		}
		List<ImsIntegral> selectByVo = integralService.selectByVo(voQueryVoIntegral);
		PageInfo page = new PageInfo(selectByVo, 5);
		model.addAttribute("pageInfo", page);
		// 加载所有班级
		List<ImsClass> classAll = classService.getClassAll();
		model.addAttribute("allClass", classAll);
		// 加载所有的部室
		List<ImsClubroom> clubroom = clubroomService.getClubroom();
		model.addAttribute("allRoom", clubroom);
		// 加载所有学期
		List<ImsSemester> semesterAll = semesterService.getSemesterAll();
		model.addAttribute("allSemester", semesterAll);
		// 数据回显
		model.addAttribute("voStuIdAndName", voQueryVoIntegral.getVoStuIdAndName());
		model.addAttribute("voClass", voQueryVoIntegral.getVoClass());
		model.addAttribute("voClub", voQueryVoIntegral.getVoClub());
		model.addAttribute("voSemester", voQueryVoIntegral.getVoSemester());
		map = voQueryVoIntegral;
		// 分页地址
		model.addAttribute("adss", "list.do");
		return "administrator/integralList";
	}

	// 修改积分信息
	@ResponseBody
	@RequestMapping(value = "updateIntegral.do", method = RequestMethod.PUT)
	public String updateIntegral(HttpServletRequest request, Model model, ImsIntegral imsIntegral) {
		int updateByPrimaryKey = integralService.updateByPrimaryKey(imsIntegral);
		if (updateByPrimaryKey > 0)
			return "ok";
		else {
			return "no";
		}
	}

	// 备份积分数据
	@RequestMapping(value="export.do")
	public String export(QueryVoIntegral voQueryVoIntegral,HttpServletResponse response) throws UnsupportedEncodingException {
		ExportUtil Export = new ExportUtil();
		if(voQueryVoIntegral.getVoStuIdAndName() == "" && voQueryVoIntegral.getVoClass() == ""
				&& voQueryVoIntegral.getVoClub() == "" && voQueryVoIntegral.getVoSemester() == ""){
			List<ImsIntegral> selectByVo = integralService.getAllIntegral();
			try {
				Export.export(selectByVo,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("导出数据有误");
			}
		}else{
			//转码
			voQueryVoIntegral.setVoStuIdAndName(new String(voQueryVoIntegral.getVoStuIdAndName().getBytes("iso8859-1"),"utf-8"));
			voQueryVoIntegral.setVoClass(new String(voQueryVoIntegral.getVoClass().getBytes("iso8859-1"),"utf-8"));
			voQueryVoIntegral.setVoClub(new String(voQueryVoIntegral.getVoClub().getBytes("iso8859-1"),"utf-8"));
			voQueryVoIntegral.setVoSemester(new String(voQueryVoIntegral.getVoSemester().getBytes("iso8859-1"),"utf-8"));
			List<ImsIntegral> selectByVo = integralService.selectByVo(voQueryVoIntegral);
			try {
				Export.export(selectByVo,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("导出数据有误");
			}
		}
		return null;
	}
}
