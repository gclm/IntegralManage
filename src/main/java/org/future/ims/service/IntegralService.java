package org.future.ims.service;

import org.future.ims.pojo.ImsIntegral;
import org.future.ims.pojo.ImsIntegralExample;
import org.future.ims.pojo.QueryVoIntegral;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Set;



/**
  *  Class Name: IntegralService.java
  *  Description:
  *  @author  zsh  DateTime 2017年11月9日 下午10:27:50
  *  @company future
  *  @email  43240825@qq.com 
  *  @version 1.0
  */
public interface IntegralService {
	//单个添加
	int insert(ImsIntegral record);
	
	//批量导入
	List<ImsIntegral> importExcelInfo(InputStream in, MultipartFile file,String semester,String name);
	
	//查询所有
	List<ImsIntegral> getAllIntegral();
	
	//删除积分
	int deleteByPrimaryKey(Integer integralId);
	
	//条件查询
	List<ImsIntegral> selectByVo(QueryVoIntegral voQueryVoIntegral);
	
	//积分查重
    List<ImsIntegral> queryRepetition(String studentName,String studentId,String grades,
    		Float score,String reason,String time,String clubroom,String intSemester);
	
    //修改
	int updateByPrimaryKey(ImsIntegral record);
}
