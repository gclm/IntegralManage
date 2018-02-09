package org.future.ims.service;

import org.future.ims.pojo.ImsUser;
import org.future.ims.pojo.ImsUserExample;

import java.util.List;
import java.util.Set;

/**
 * @ClassName:     UserService.java
 *  
 * @author         孤城落寞
 *
 * @Date           2017年10月22日 上午10:20:15
 *
 * @Description:   TODO(用一句话描述该文件做什么)  
 */
public interface UserService {
	
	/**
	* @param studentId
	* @return
	*/
	 //登录
	ImsUser getUserByStudentId(String studentId);


	//用户列表
    List<ImsUser>  getUserAll();
    
    
	/** 
	 * 删除用户
	 * 
	 * @param id
	 */
	void deleteUser(Integer id);
    
    /**
     * 批量删除用户    
     * 
	 * @param del_ids
	 */
	void deleteUserBatch(List<Integer> ids);

	/**
	 * @param imsUser
	 */
	void updateByUser(ImsUser imsUser);

	/**
	 * @param id
	 * @return
	 */
	ImsUser selectUserById(Integer id);

	/**
	 * @param studentId
	 * @return
	 */
	boolean checkUser(String studentId);

	/**
	 * @param imsUser
	 */
	public void saveUser(ImsUser imsUser);
    
    /**
     * @param email
     * @return
     */
    ImsUser  selectByEmail(String email);


	/**
	 * @param email
	 * @return
	 */
	boolean checkEmail(String email);
	

	List<ImsUser> selectUsersByStudentId(String  studentId);
}
