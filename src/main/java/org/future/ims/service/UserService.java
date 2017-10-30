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

	//添加批量添加用户
	List<ImsUser> addUserList(ImsUser user);

	//添加管理员
	int updateUserById(ImsUser user);
     
	//添加用户
	int addUser(ImsUser user);
    
	//用户列表
    List<ImsUser>  getUserAll(ImsUserExample userExample);
    
    //修改用户
    

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
	void deleteUserBatch(List<Integer> del_ids);

	/**
	 * @param imsUser
	 */
	int updateByUser(ImsUser imsUser);
	

    
	
}
