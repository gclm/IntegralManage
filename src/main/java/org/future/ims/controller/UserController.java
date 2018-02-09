package org.future.ims.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.bridge.Message;
import org.future.ims.pojo.ImsClubroom;
import org.future.ims.pojo.ImsUser;
import org.future.ims.pojo.ImsUserExample;
import org.future.ims.pojo.Messages;
import org.future.ims.pojo.QueryVo;
import org.future.ims.service.ClubroomService;
import org.future.ims.service.PasswordService;
import org.future.ims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jayway.jsonpath.internal.Path;

import net.sf.jsqlparser.schema.Server;

  
/** 
 *  @Package org.future.ims.controller
 *  
 *  @Title: UserController.java 
 * 
 *  @author 孤城落寞
 * 
 *  @date 2017年10月28日 下午3:21:09 
 * 
 *  @Description: TODO(用一句话描述该文件做什么)   
 */
 
@Controller
@RequestMapping(value="/user")
public class UserController {
	  
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private ClubroomService clubroomService;
	    
	/**
	 * 进行学号查重，判断是否可用
	 * 
	 * @param studentId
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkStudentId.do")
	public Messages checkStudentId(String studentId){
		//数据库用户名重复校验
		boolean b = userService.checkUser(studentId);
		if(b){
			return Messages.success();
		}else{
			return Messages.fail().add("studentIdMessage", "学号不可用");
		}	
		
    }
	
	/**
	 * 进行邮箱查重，判断是否可用
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkEmail.do")
	public Messages checkEmail(String email){
		//数据库用户名重复校验
		boolean b = userService.checkEmail(email);
		if(b){
			return Messages.success();
		}else{
			return Messages.fail().add("emailMessage", "该邮箱已被注册不可用");
		}	
		
	}
	
	@ResponseBody
	@RequestMapping(value="/addPric.do",method=RequestMethod.POST)  
    public Messages addPric(MultipartFile pric, HttpServletRequest request,Model model) throws IllegalStateException, IOException {  
            
		    System.out.println(pric);
            // 获取图片原始文件名  
            String originalFilename = pric.getOriginalFilename();  
            System.out.println(originalFilename);  
          
            // 文件名使用当前时间  
            String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());  
          
            // 获取上传图片的扩展名(jpg/png/...)  
            String extension = FilenameUtils.getExtension(originalFilename);  
              
            // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）  
            String path = "/static/pic/" + name + "." + extension;  
  
            // 图片上传的绝对路径  
            String url = request.getSession().getServletContext().getRealPath("") + path;  
          
            File dir = new File(url);  
            
            if(!dir.exists()) {  
               dir.mkdirs();  
            }  
              
            // 上传图片  
            pric.transferTo(new File(url));  
            
           return Messages.success().add("pictureFile", name + "." + extension);
    }  
	
	
	
	 /**
	  *  添加用户   
	  * 
	  * @param imsUser
	  * @param result
	  * @return
	  */
	 @RequestMapping(value="/addUser.do",method=RequestMethod.POST)
	 @ResponseBody
	 public Messages saveUser(ImsUser imsUser,BindingResult result) throws Exception{
		  
			if(result.hasErrors()){
				//校验失败，应该返回失败，在模态框中显示校验失败的错误信息
				Map<String, Object> map = new HashMap<>();
				List<FieldError> errors = result.getFieldErrors();
				for (FieldError fieldError : errors) {
					System.out.println("错误的字段名："+fieldError.getField());
					System.out.println("错误信息："+fieldError.getDefaultMessage());
					map.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
				return Messages.fail().add("errorFields", map);
			}else{
				
				userService.saveUser(imsUser);
				
				return Messages.success();
			}
			
		}
	   
	/**
	 * 
	 * 用户列表  引入PageHelper分页插件
	 *  使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userList.do")
	public String userList(@RequestParam(value = "pn", defaultValue = "1") Integer pn,String studentId,
		Model model) {
         
		if(studentId!=null){
			List<ImsUser> users = userService.selectUsersByStudentId(studentId);
			PageInfo page = new PageInfo(users, 5);	
			model.addAttribute("pageInfo", page);
			model.addAttribute("studentId", studentId);		
		}else{
            List<ImsUser> users = userService.getUserAll();
			PageInfo page = new PageInfo(users, 5);	
			model.addAttribute("pageInfo", page);
		}
		//加载所有部室
		List<ImsClubroom> clubroom = clubroomService.getClubroom();
		model.addAttribute("allRoom", clubroom);
		PageHelper.startPage(pn, 10);
		return "administrator/userList";
   
	}
		
	
	/**
	 * 单个批量二合一
	 * 批量删除：1-2-3
	 * 单个删除：1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteUser.do",method=RequestMethod.POST)
	public String deleteUser(String ids,String adminId,Model model){
		//批量删除
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				if(string.equals(adminId)){
			      model.addAttribute("deleteMessages", "不能删除自己");	
				}else{
					del_ids.add(Integer.parseInt(string));
				}
				
			}
			userService.deleteUserBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			userService.deleteUser(id);
		}
		return  "userList";
	}
   
    	
	/**
	 * 
	 * 修改用户
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateUser.do",method=RequestMethod.PUT)
	public Messages updateByUser(ImsUser user) {
		userService.updateByUser(user);		
		return Messages.success();
	}
	
}
	