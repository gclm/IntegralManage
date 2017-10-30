package org.future.ims.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.future.ims.pojo.ImsUser;
import org.future.ims.pojo.ImsUserExample;
import org.future.ims.pojo.QueryVo;
import org.future.ims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
  
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
	
	    
	 //单个添加用户
	 @RequestMapping("/addUser.do")  
     public String addUser(Model model,ImsUser user){  
         
		ImsUser exitU = userService.getUserByStudentId(user.getStudent_id()); 
        
		if(exitU ==null){
   	
        	model.addAttribute("addUserMessage","存在该用户,添加用户失败！");        	
        
		}else{
   
			int result = userService.addUser(user);  
            
        	if(result>0){  
                //将提示信息存入域中，用以前台显示  
                model.addAttribute("addUserMessage","恭喜您，添加用户成功！<br>姓名："+user.getName());  
            }else{  
                model.addAttribute("addUserMessage","服务器异常，添加用户失败！");  
            }  
        }
		
        return "administrator/addUser";  
	 }  
	 
	 
	 @RequestMapping("/addUserList.do")  
     public  String addUserList() {
		/* 
		 int result = userService.addUser(user);  
	          
	      if(result>0){  
	            //将提示信息存入域中，用以前台显示  
	            model.addAttribute("addUserMessage","恭喜您，添加用户成功！<br>姓名："+user.getName());  
	        }else{  
	            model.addAttribute("addUserMessage","服务器异常，添加用户失败！");  
	        }  
	        
		 }  */
		 return "administrator/addUserList";  
		 
	 }
	 
	/**
	 *
	 * 添加管理员
	 * 
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/addAdmin.do")
	public String addAdmin(Model model,QueryVo vo) {
        
		int ids = userService.updateUserById(vo.getUser());  
   
        if(ids>0){  
            //将提示信息存入域中，用以前台显示  
        	model.addAttribute("addUserMessage","恭喜您，添加管理员成功");  
        }else{  
            model.addAttribute("addUserMessage","服务器异常，添加管理员失败！");  
        }  
        return "administrator/addUser";  
	}  
	  
	/**
	 * 
	 * 用户列表  引入PageHelper分页插件
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/userList.do")
	public String userList( @RequestParam(value = "pn", defaultValue = "1") Integer pn,
		Model model) {

	// 在查询之前只需要调用，传入页码，以及每页的大小
	PageHelper.startPage(pn, 10);
	// startPage后面紧跟的这个查询就是一个分页查询
	ImsUserExample userExample =new ImsUserExample();
	userExample.createCriteria().andRoleEqualTo("tourists");
	
	List<ImsUser> emps = userService.getUserAll(userExample);
	
	// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
	// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
	PageInfo page = new PageInfo(emps, 5);
	
	model.addAttribute("pageInfo", page);

	return "userList";
   
	}
		
	/**
	 * 单个批量二合一
	 * 批量删除：1-2-3
	 * 单个删除：1
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteUser/{ids}")
	public String deleteUser(@PathVariable("ids")String ids){
		//批量删除
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			userService.deleteUserBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			userService.deleteUser(id);
		}
		return  "userList";
	}
   
   
	/**
	 * 修改用户  
	 * @param imsUser
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update/{userId}")
	public String updateUser(ImsUser imsUser,Model model){
		
	    int updateNumber = userService.updateByUser(imsUser);
	    if(updateNumber>0){  
            //将提示信息存入域中，用以前台显示  
        	model.addAttribute("updateMessage","恭喜您，添加用户成功！<br>姓名："+imsUser.getName());  
        }else{  
            model.addAttribute("updateMessage","服务器异常，添加用户失败！");  
        }  
	    
	    return  "userList";
	} 
	
	
}
	