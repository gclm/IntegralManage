package org.future.ims.controller;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.future.ims.pojo.ImsClass;
import org.future.ims.pojo.ImsStudent;
import org.future.ims.service.ClassService;
import org.future.ims.service.StudentService;
import org.future.ims.utils.CharacterEncoding;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

 
@Controller
@RequestMapping(value="/student")
public class StudentController {
	  
	@Autowired
	private StudentService stduentService;
	@Autowired
	private ClassService classService;
	
	//用户添加中转
	@RequestMapping("/addStu.do")
	public String addStu(Model model) {
		//获得所有的班级信息
		List<ImsClass> classAll = classService.getClassAll();
		model.addAttribute("allClass", classAll);
		return "administrator/addStudent";

	}
	
	 //单个添加学生
	 @RequestMapping("/addStudent.do")  
     public String addStudent(Model model,ImsStudent student){
		 
		 ImsStudent exit = stduentService.getStudentByStudentId(student.getStudentId());
		 	 
		 if(exit == null){
			 int result = stduentService.addStudent(student);
			 if(result > 0 ){
				 model.addAttribute("addStudentMessage","恭喜您，添加学生"+student.getName()+"成功！");
			 }
		 }else{
			 model.addAttribute("addStudentMessage","学号重复，添加失败！");
		 }
		List<ImsClass> classAll = classService.getClassAll();
		model.addAttribute("allClass", classAll);
        return "administrator/addStudent";  
	 } 
	 
	 //批量添加学生
	 @RequestMapping("/import.do")  
	 public String impotr(HttpServletRequest request, Model model) throws Exception { 
		 //获取上传的文件  
	      MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;  
	      MultipartFile file = multipart.getFile("upfile");
	      InputStream in = file.getInputStream();
	      if(file.isEmpty()){
	    	//批量导入之后，获得所有的班级信息
	    	  	model.addAttribute("addStudentMessage","文件为空");
				List<ImsClass> classAll = classService.getClassAll();
				model.addAttribute("allClass", classAll);
		      return "administrator/addStudent";
	      }else{
	    	//数据导入  
		      List<ImsStudent> excelInfo = stduentService.importExcelInfo(in, file);  
		      in.close();  
		      String str = "";
		      if(excelInfo.size() == 0){
		    	  model.addAttribute("addStudentMessage","恭喜您,批量导入成功");
		      }else{
		    	  for(int i = 0; i<excelInfo.size();i++){
		    		  str +="学生:"+excelInfo.get(i).getName()+",学号:"+excelInfo.get(i).getStudentId()+"重复\n";
		    		  model.addAttribute("addStudentMessage",str);
		    	  }
		      }
		      List<ImsClass> classAll = classService.getClassAll();
				model.addAttribute("allClass", classAll);
		      return "administrator/addStudent";
	      }
	 }
	 
	 //显示学生列表，模糊查询
	 @RequestMapping(value="/studentList.do")
	 public String studentList(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
		Model model,String replace) throws UnsupportedEncodingException{
		 //显示学生列表之前，先加载下所有的班级信息，备修改使用
		 List<ImsClass> classAll = classService.getClassAll();
		 model.addAttribute("allClass", classAll);
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 30);
		 	if(replace == null){
			 List<ImsStudent> students = stduentService.getStudentAll();
			// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
				// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
				 PageInfo page = new PageInfo(students, 5); 
				 model.addAttribute("pageInfo", page);
				 model.addAttribute("replace",replace);
		 	}
		 else{
			 	String aaa = new CharacterEncoding().getEncoding(replace);
			 	if(aaa != "GB2312"){
			 		replace =new String(replace.getBytes("iso8859-1"),"utf-8");
			 	}
			 	List<ImsStudent> sele = stduentService.searchByReplace(replace);
			 	if(sele.size() == 0){
					model.addAttribute("searchMeg","没有你所查询的信息");
					PageInfo page = new PageInfo(sele, 5);
					model.addAttribute("pageInfo", page);
					model.addAttribute("replace",replace);
				}else{
					PageInfo page = new PageInfo(sele, 5);
					model.addAttribute("pageInfo", page);
					model.addAttribute("replace",replace);
				}
		 }
			return "administrator/studentList";
	 }
	 
	 //删除二合一
	 @ResponseBody
	 @RequestMapping(value="/deleteStudent.do",method=RequestMethod.POST)
		public void deleteClass(
				@RequestParam(name="ids") String ids){
		 if(ids != ""){
			//批量删除
				if(ids.contains("-")){
					List<Integer> del_ids = new ArrayList<Integer>();
					String[] str_ids = ids.split("-");
					//组装id的集合
					for (String string : str_ids) {
						del_ids.add(Integer.parseInt(string));
					}
					for (Integer id : del_ids) {
						stduentService.deleteByPrimaryKey(id);
					}
				}else{
					Integer id = Integer.parseInt(ids);
					stduentService.deleteByPrimaryKey(id);
				}
		 	}	
		}
	
	 	//修改学生信息
		 @ResponseBody
		 @RequestMapping(value="/updateStudent.do",method=RequestMethod.PUT)
			public String updateStudent(ImsStudent imsStudent,HttpServletRequest request){
			 //1.先查重
			 	ImsStudent studentByStudentId = stduentService.getStudentByStudentId(imsStudent.getStudentId());
				if(studentByStudentId == null){
					stduentService.updateByPrimaryKeySelective(imsStudent);
					return "ok";
				}else{
					//查重查到数据库中存在自己时，放行
					if(studentByStudentId.getName().equals(imsStudent.getName())){
						stduentService.updateByPrimaryKeySelective(imsStudent);
						return "ok";
					}else{
						return "no";
					}
				}
			}
	 
}
	