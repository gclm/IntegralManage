package org.future.ims.service;

import org.future.ims.pojo.ImsSemester;
import org.future.ims.pojo.ImsSemesterExample;

import java.util.List;
import java.util.Set;


/**
  *  Class Name: SemesterService.java
  *  Description:
  *  @author  zsh  DateTime 2017年11月6日 下午8:32:54
  *  @company future
  *  @email  43240825@qq.com 
  *  @version 1.0
  */
public interface SemesterService {
	
	//添加学期
	int addSemester(ImsSemester semester);
    
	//学期列表
    List<ImsSemester> getSemesterAll();
    
    //通过学期精确查询，用于修改、添加时的查重
    List<ImsSemester> getSemesterByName(String name);
    
    //删除学期
    int deleteByPrimaryKey(Integer semesterId);
    
    //修改学期
    int updateByPrimaryKeySelective(ImsSemester record);
}
