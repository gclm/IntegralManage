package org.future.ims.service;

import org.future.ims.pojo.Sort;
import java.util.List;


/**
  *  Class Name: SortService.java
  *  Description:
  *  @author  zsh  DateTime 2017年11月12日 上午11:04:19
  *  @company future
  *  @email  43240825@qq.com 
  *  @version 1.0
  */
public interface SortService {
	
	//根据学号和学期查询总的积分信息
    List<Sort> selectByStudentIdAndSemester(String studentId,String intSemester);
    
    //根据班级、学期查询总的积分信息
    List<Sort> selectByClassAndSemester(String grades,String intSemester);
}
