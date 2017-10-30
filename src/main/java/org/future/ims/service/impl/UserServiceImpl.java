package org.future.ims.service.impl;

import java.util.List;

import org.future.ims.mapper.ImsUserMapper;
import org.future.ims.pojo.ImsUser;
import org.future.ims.pojo.ImsUserExample;
import org.future.ims.pojo.ImsUserExample.Criteria;
import org.future.ims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private ImsUserMapper userMapper;
   
	//通过学号查找用户
	public ImsUser getUserByStudentId(String studentId) {
		return userMapper.selectByStudentId(studentId);  
	}

	public List<ImsUser> addUserList(ImsUser user) {
		// TODO Auto-generated method stub
		return null;
	}
    
	//批量添加用户
	public int updateUserById(ImsUser user) {
		user.setRole("admin");
		return  userMapper.updateByPrimaryKey(user);
	}

	public int addUser(ImsUser user) {
		
		return userMapper.insert(user);
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#getUserAll()
	 */
	public List<ImsUser> getUserAll(ImsUserExample userExample) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(userExample);
	}

	
	
	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#deleteUserBatch(java.util.List)
	 */
	public void deleteUserBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		ImsUserExample userExample = new ImsUserExample();
		Criteria criteria = userExample.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andUserIdIn(ids);
		userMapper.deleteByExample(userExample);
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#deleteUser(java.lang.Integer)
	 */
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(id);
	}

	
	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#updateByUser(org.future.ims.pojo.ImsUser)
	 */
	public int updateByUser(ImsUser imsUser) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(imsUser);
	}
	
	
	
}