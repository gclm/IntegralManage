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

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#getUserAll()
	 */
	public List<ImsUser> getUserAll() {
		// TODO Auto-generated method stub
  	    return	userMapper.selectByExample(null);
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
	public void updateByUser(ImsUser imsUser) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(imsUser);		
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#selectUserById(java.lang.Integer)
	 */
	public ImsUser selectUserById(Integer id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#deleteUserBatch(java.util.List)
	 */
	public void deleteUserBatch(List<Integer> ids) {
		ImsUserExample example = new ImsUserExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andUserIdIn(ids);
		userMapper.deleteByExample(example);
		
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#checkUser(java.lang.String)
	 * 判断学号是否重复
	 */
	@Override
	public boolean checkUser(String studentId) {
		ImsUserExample example = new ImsUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		long count = userMapper.countByExample(example);
		return count == 0;
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#saveUser(org.future.ims.pojo.ImsUser)
	 * 
	 */
	@Override
	public void saveUser(ImsUser imsUser) {
		// TODO Auto-generated method stub
		userMapper.insertSelective(imsUser);
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#selectByEmail(java.lang.String)
	 */
	@Override
	public ImsUser selectByEmail(String email) {
		return  userMapper.selectByEmail(email);
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#checkEmail(java.lang.String)
	 */
	@Override
	public boolean checkEmail(String email) {
		ImsUserExample example = new ImsUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		long count = userMapper.countByExample(example);
		return count == 0;
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.UserService#selectUsersByStudentId(java.lang.String)
	 */
	@Override
	public List<ImsUser> selectUsersByStudentId(String studentId) {
		
		return userMapper.selectUsersByStudentId(studentId);
		
	}

	

	
	
}