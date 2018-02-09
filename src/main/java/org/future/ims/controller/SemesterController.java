package org.future.ims.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.future.ims.pojo.ImsSemester;
import org.future.ims.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "/semester")
public class SemesterController {

	@Autowired
	private SemesterService semesterService;

	// 添加学期
	@RequestMapping(value = "/addSemester.do", method = RequestMethod.POST)
	public String addStudent(Model model, String start, String end, String seme) {
		int star = Integer.parseInt(start);
		int en = Integer.parseInt(end);
		if (seme == "") {
			model.addAttribute("addSemesterMeg", "学期未选择！");
		} else {
			if ((en - star) == 1) {
				String semesterName = start + "-" + end + "学年"+seme;
				ImsSemester imsSemester = new ImsSemester();
				imsSemester.setSemesterName(semesterName);
				List<ImsSemester> semesterByName = semesterService.getSemesterByName(semesterName);
				if (semesterByName.size() == 0) {
					// 查重通过，放行
					semesterService.addSemester(imsSemester);
					model.addAttribute("addSemesterMeg", "添加学期成功！");
				} else {
					// 查重不通过
					model.addAttribute("addSemesterMeg", "学期已经存在！");
				}

			} else {
				model.addAttribute("addSemesterMeg", "学期格式不符合要求");
			}
		}
		// 得到学期列表
		List<ImsSemester> semesterAll = semesterService.getSemesterAll();
		model.addAttribute("pageInfo", semesterAll);
		return "administrator/semesterList";
	}

	// 显示学期列表
	@RequestMapping(value = "/semesterList.do")
	public String studentList(Model model) {
		// 学期列表不分页
		List<ImsSemester> semesterAll = semesterService.getSemesterAll();
		model.addAttribute("pageInfo", semesterAll);
		return "administrator/semesterList";
	}

	// 删除学期信息
	@ResponseBody
	@RequestMapping(value = "/deleteSemester.do", method = RequestMethod.POST)
	public void deleteClass(@RequestParam(name = "ids") String ids,Model model) {
		Integer id = Integer.parseInt(ids);
		semesterService.deleteByPrimaryKey(id);
		// 得到学期列表
		List<ImsSemester> semesterAll = semesterService.getSemesterAll();
		model.addAttribute("pageInfo", semesterAll);
	}

	// 修改学期信息
	@ResponseBody
	@RequestMapping(value = "/updateSemester.do", method = RequestMethod.POST)
	public String updateSemester(String start, String end, String seme, String semesterId,HttpServletRequest request,Model model) {
		int star = Integer.parseInt(start);
		int en = Integer.parseInt(end);
		Integer id = Integer.parseInt(semesterId);
			if ((en - star) == 1) {
				String semesterName = start + "-" + end +"学年"+seme;
				ImsSemester imsSemester = new ImsSemester();
				imsSemester.setSemesterName(semesterName);
				imsSemester.setSemesterId(id);
				List<ImsSemester> semesterByName = semesterService.getSemesterByName(semesterName);
				if (semesterByName.size() == 0) {
					// 查重通过，放行
					semesterService.updateByPrimaryKeySelective(imsSemester);
					// 得到学期列表
					List<ImsSemester> semesterAll = semesterService.getSemesterAll();
					model.addAttribute("pageInfo", semesterAll);
					return "ok";
				} else {
					// 查重不通过
					return "no";
				}
			} else {
				//学期格式不符合要求
				return "no2";
			}
	}
}
