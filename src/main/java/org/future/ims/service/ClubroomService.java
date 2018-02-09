/**
 * 
 */
package org.future.ims.service;

import java.util.List;

import org.future.ims.pojo.ImsClubroom;

/** 
 *  @Package org.future.ims.service
 *  
 *  @Title: ClubroomService.java 
 * 
 *  @author gclm
 * 
 *  @date 2017年11月8日 上午8:13:56 
 * 
 *  @Description: TODO(用一句话描述该文件做什么)   
 */

public interface ClubroomService {

	/**
	 * @return
	 */
	List<ImsClubroom> getClubroom();

	/**
	 * @param id
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * @param clubroomName
	 * @return
	 */
	boolean checkClubroom(String clubroomName);

	/**
	 * @param imsclubroom
	 */
	void saveClubroom(ImsClubroom imsclubroom);

	/**
	 * @param imsClubroom
	 */
	void updateClubroom(ImsClubroom imsClubroom);

}
