/**
 * 
 */
package org.future.ims.controller;

import javax.servlet.http.HttpSession;

import org.future.ims.pojo.ImsUser;
import org.future.ims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 *  @Package org.future.ims.controller
 *  
 *  @Title: baseController.java 
 * 
 *  @author 孤城落寞
 * 
 *  @date 2017年10月28日 下午4:21:10 
 * 
 *  @Description: 登录  注销  找回密码  改密   
 */
@Controller
@RequestMapping(value="/base")
public class baseController {
  
	@Autowired
	private UserService userService;
	
	
	/**
	 * 跳转到用户登录
	 * @return
	 */
	
	@RequestMapping(value="/login_index.do")
	public String login() {
		return "login";
	}
	
	
	/**
	 * 执行登陆操作
	 * @param u
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/login.do",method=RequestMethod.POST)
	public String login(ImsUser u,Model model,HttpSession httpSesssion){
		
		ImsUser exitU = userService.getUserByStudentId(u.getStudent_id());
		//判断用户是否存在  密码是否正确
		if(exitU!=null){
			if(exitU.getPassword().equals(u.getPassword())){
                //在线状态改变
				exitU.setStatus("在线");
				//进行身份辨别
				if(exitU.getRole().equals("administrator")){
				   //传值
				   httpSesssion.setAttribute("administrator", exitU);
				   //返回的页面  
				   return "administrator/index"; 	
				   
				}else if(exitU.getRole().equals("admin")){
					//传值
					httpSesssion.setAttribute("admin", exitU);
					//返回的页面  
					return "admin/index"; 
				}else if(exitU.getRole().equals("tourists")){					
					//传值
					httpSesssion.setAttribute("tourists", exitU);
					//返回的页面  
					return "tourists/index"; 
				}else {
					//传值
					model.addAttribute("loginMessage", "用户不存在");
					//返回的页面  
					return "login"; 
				}
			}else{
				//传值
				model.addAttribute("loginMessage", "密码输入错误！");
				//返回的页面  
				return "login"; 
			}	
		}else{
			//传值
			model.addAttribute("loginMessage", "用户不存在");
			//返回的页面  
			return "login"; 
		
		}  
	}
	

	
   /**
	 * @return
	 */
	//退出登录后,防倒退再次进入	
	@RequestMapping(value = "/logOff.do")
	public String logOff(){
		return "logOff";
	}
			
			
	  /**
	 * @param httpSesssion
	 * @return
	 * @throws Exception
	 */
	//注销登录
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession httpSesssion,Model model) throws Exception {	
		 httpSesssion.invalidate();
		 model.addAttribute("logoutMessage", "注销成功,欢迎下次使用");
		 return "login";
	}
	
	
}
