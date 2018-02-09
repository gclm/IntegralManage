/**
 * 
 */
package org.future.ims.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.future.ims.pojo.ImsClubroom;
import org.future.ims.pojo.ImsUser;
import org.future.ims.pojo.Messages;
import org.future.ims.service.ClubroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
 *  @Package org.future.ims.controller
 *  
 *  @Title: ClubroomController.java 
 * 
 *  @author gclm
 * 
 *  @date 2017年11月8日 上午8:11:24 
 * 
 *  @Description: 对部室进行增删改查  
 */
@Controller
@RequestMapping(value="/clubroom")
public class ClubroomController {

	@Autowired
    private  ClubroomService  clubroomService;
	
	
	/**
	 *
	 * ajax返回所有的部室信息
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value="/getClubroom.do")
	public Messages getClubroom(){
		//查出的所有部门信息
		List<ImsClubroom> list = clubroomService.getClubroom();
		
		return Messages.success().add("clubroom", list);
	}
	
	
	@RequestMapping(value="/clubroomList.do")
	public String ClubroomList(Model model){
		
		
		List<ImsClubroom> clubrooms = clubroomService.getClubroom();
		
		
		model.addAttribute("pageInfo", clubrooms);
		
		return "administrator/clubroomList";
	}
	
	
	 /**
	  * 删除二合一
	  * @param ids
	  */
	 @ResponseBody
	 @RequestMapping(value="/deleteClubroom.do",method=RequestMethod.POST)
	 public void deleteClass(String ids){
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
					clubroomService.deleteByPrimaryKey(id);
				}
			}else{
				Integer id = Integer.parseInt(ids);
				clubroomService.deleteByPrimaryKey(id);
			}
	 	}	
	}
	
	    /**
	     * 部室查重判断
	     * @param clubroomName
	     * @return
	     */
	    @ResponseBody
		@RequestMapping("/checkClubroomName.do")
		public Messages checkClubroomName(String clubroomName){
			
			//数据库用户名重复校验
			boolean b = clubroomService.checkClubroom(clubroomName);

			if(b){
				return Messages.success();
				
			}else{
				return Messages.fail().add("clubroomNameMessage", "存在该部室,无法创建该部室");
			
			}	
			
	    }
	    
	    
	   /**
	     * 添加部室
	     * 
	     * @param Imsclubroom
	     * @param result
	     * @return
	     */
	     @RequestMapping(value="/addClubroom.do",method=RequestMethod.POST)
		 @ResponseBody
		 public Messages saveUser(ImsClubroom Imsclubroom,BindingResult result){
				if(result.hasErrors()){
					//校验失败，应该返回失败，在模态框中显示校验失败的错误信息
					Map<String, Object> map = new HashMap<>();
					List<FieldError> errors = result.getFieldErrors();
					for (FieldError fieldError : errors) {
						map.put(fieldError.getField(), fieldError.getDefaultMessage());
					}
					return Messages.fail().add("errorFields", map);
				}else{
				
					clubroomService.saveClubroom(Imsclubroom);
					return Messages.success();
				}
				
			}
	    
	     
	    /**
	     * 修改部室
	     * 
	     * @param imsClubroom
	     * @return
	     */
	    @ResponseBody
		@RequestMapping(value="/updateClubroom.do",method=RequestMethod.PUT)
		public Messages updateClubroom(ImsClubroom imsClubroom){
			clubroomService.updateClubroom(imsClubroom);			
			return Messages.success();
		}
	    
}
