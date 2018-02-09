package org.future.ims.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import org.future.ims.pojo.ImsIntegral;
import org.future.ims.pojo.ImsSemester;
import org.future.ims.pojo.ImsStudent;
import org.future.ims.pojo.QueryVoIntegral;
import org.future.ims.pojo.Sort;
import org.future.ims.service.IntegralService;
import org.future.ims.service.SemesterService;
import org.future.ims.service.SortService;
import org.future.ims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

 
@Controller
@RequestMapping(value="/sort")
public class SortController {
	  
	@Autowired
	private SortService sortService;
	@Autowired
	private IntegralService integralService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private SemesterService semesterService;
	
	 //打开页面时加载所有学期
	@RequestMapping(value="/sort.do")
	public String Sort(Model model){
		// 加载所有学期
		List<ImsSemester> semesterAll = semesterService.getSemesterAll();
		model.addAttribute("allSemester", semesterAll);
		return "student/index";
		
	}
	
	 //查询个人总的积分信息，用来显示自己的分数和排名
	 @RequestMapping(value="/sortList.do")
	 public String sortList(Model model,String studentId,String intSemester,Integer i) throws UnsupportedEncodingException {
		 //先查询下有无此学生
		 ImsStudent studentByStudentId2 = studentService.getStudentByStudentId(studentId);
		 if(studentByStudentId2 != null){
			 if(i == 0){  //查询个人总的积分信息，用来显示自己的分数和排名
					//积分不存在分页，只是得到个人详情
					 List<Sort> selectByStudentIdAndSemester = sortService.selectByStudentIdAndSemester(studentId, intSemester);
					 if(selectByStudentIdAndSemester.size() != 0){
						//用学号去获得学生的班级信息
						 List<Sort> selectByClassAndSemester = sortService.selectByClassAndSemester(selectByStudentIdAndSemester.get(0).getGrades(), intSemester);
						 for (int j = 0;j<selectByClassAndSemester.size();j++) {
							if(studentId.equals(selectByClassAndSemester.get(j).getStudentId())){
								model.addAttribute("sort", j+1);
							}
						}
						 //此处从数据库中取得的数据精度丢失了，所以强制四舍五入保留一位小数
						 BigDecimal b = new BigDecimal(selectByStudentIdAndSemester.get(0).getAllscore());
						 selectByStudentIdAndSemester.get(0).setAllscore(b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
						 model.addAttribute("name", selectByStudentIdAndSemester.get(0).getStudentName());
						 model.addAttribute("score", selectByStudentIdAndSemester.get(0).getAllscore());
						 model.addAttribute("studentId", studentId);
						 model.addAttribute("intSemester", intSemester);
					 }else{
						 model.addAttribute("no", 1);
						 model.addAttribute("name", studentByStudentId2.getName());
						 model.addAttribute("intSemester", intSemester);
						 model.addAttribute("studentId", studentId);
					 }
					 return "student/total";
				 }else if(i == 1) {  //查询个人本学期详情
					 //把查询封装成一个QueryVoIntegral对象
					 QueryVoIntegral voIntegral = new QueryVoIntegral();
					 voIntegral.setVoStuIdAndName("");
					 voIntegral.setVoStuIdAndName(studentId);
					 voIntegral.setVoSemester(new String(intSemester.getBytes("iso8859-1"),"utf-8"));
					 voIntegral.setVoClass("");
					 voIntegral.setVoClub("");
					 List<ImsIntegral> selectByVo = integralService.selectByVo(voIntegral);
					 model.addAttribute("pageInfo", selectByVo);
					 model.addAttribute("studentId", studentId);
					 model.addAttribute("intSemester", voIntegral.getVoSemester());
					 return "student/listOne";
				 }else if(i == 2) {
					 //查询本班本学期总的积分详情
					 ImsStudent studentByStudentId = studentService.getStudentByStudentId(studentId);
					 List<Sort> selectByClassAndSemester = sortService.selectByClassAndSemester(studentByStudentId.getGrades(), new String(intSemester.getBytes("iso8859-1"),"utf-8"));
					//此处从数据库中取得的数据精度丢失了，所以强制四舍五入保留一位小数
					 for (int k = 0 ; k < selectByClassAndSemester.size(); k ++ ) {
						 BigDecimal b = new BigDecimal(selectByClassAndSemester.get(k).getAllscore());
						 selectByClassAndSemester.get(k).setAllscore(b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
					 }
					 //model
					 model.addAttribute("pageInfo", selectByClassAndSemester);
					 model.addAttribute("studentId", studentId);
					 model.addAttribute("intSemester", new String(intSemester.getBytes("iso8859-1"),"utf-8"));
					 return "student/listTotal";
				 	}
		 }else{
				model.addAttribute("searchMeg","没有该学生！");
				// 加载所有学期
				List<ImsSemester> semesterAll = semesterService.getSemesterAll();
				model.addAttribute("allSemester", semesterAll);
				return "student/index";
			 }
		return null;
	 }
	
}
	