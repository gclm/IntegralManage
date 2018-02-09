/**
 * 
 */
package org.future.ims.service.impl;

import java.util.List;

import org.future.ims.mapper.ImsClubroomMapper;
import org.future.ims.pojo.ImsClubroom;
import org.future.ims.pojo.ImsClubroomExample;
import org.future.ims.pojo.ImsClubroomExample.Criteria;
import org.future.ims.service.ClubroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 *  @Package org.future.ims.service.impl
 *  
 *  @Title: ClubroomServiceImpl.java 
 * 
 *  @author gclm
 * 
 *  @date 2017年11月8日 上午8:14:23 
 * 
 *  @Description: TODO(用一句话描述该文件做什么)   
 */
@Service("clubroomService")
public class ClubroomServiceImpl  implements ClubroomService{
    
	
	@Autowired
	private ImsClubroomMapper clubroomMapper;
	
	
	/* 
	 * 查询所有部室
	 * (non-Javadoc)
	 * @see org.future.ims.service.ClubroomService#getClubroom()
	 * 
	 */
	public List<ImsClubroom> getClubroom() {

		List<ImsClubroom> list = clubroomMapper.selectByExample(null);
		
		return list;
	}


	/* 
	 * 删除所有部室
	 * (non-Javadoc)
	 * @see org.future.ims.service.ClubroomService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return clubroomMapper.deleteByPrimaryKey(id);
		
	}


	/* (non-Javadoc)
	 * @see org.future.ims.service.ClubroomService#checkClubroom(java.lang.String)
	 */
	@Override
	public boolean checkClubroom(String clubroomName) {
		ImsClubroomExample example = new ImsClubroomExample();
		Criteria criteria = example.createCriteria();
		criteria.andClubroomNameEqualTo(clubroomName);
		long count = clubroomMapper.countByExample(example);
		return count == 0;
	}


	/* (non-Javadoc)
	 * @see org.future.ims.service.ClubroomService#saveClubroom(org.future.ims.pojo.ImsClubroom)
	 */
	
	public void saveClubroom(ImsClubroom imsclubroom) {
		clubroomMapper.insertSelective(imsclubroom);
	}


	/* (non-Javadoc)
	 * @see org.future.ims.service.ClubroomService#updateClubroom(org.future.ims.pojo.ImsClubroom)
	 */
	@Override
	public void updateClubroom(ImsClubroom imsClubroom) {
		// TODO Auto-generated method stub
		clubroomMapper.updateByPrimaryKeySelective(imsClubroom);
	}

}
