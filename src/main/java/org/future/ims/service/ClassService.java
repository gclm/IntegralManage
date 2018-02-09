package org.future.ims.service;

import org.future.ims.pojo.ImsClass;
import org.future.ims.pojo.ImsClassExample;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
  *  Class Name: ClassService.java
  *  Description:
  *  @author  zsh  DateTime 2017年11月4日 下午8:33:41
  *  @company future
  *  @email  43240825@qq.com 
  *  @version 1.0
  */
public interface ClassService {
	
	//添加班级
	int addClass(ImsClass clas);
	
	//批量导入
	List<ImsClass> importExcelInfo(InputStream in, MultipartFile file);
    
	//班级列表
    List<ImsClass> getClassAll();
    
    //通过班级名称查询
    List<ImsClass> getClassByName(String name);
    
    //通过名称精确查询班级，用于修改、添加时的查重
    List<ImsClass> getCompletelyClassByName(String name);
    
    //删除班级
    int deleteByPrimaryKey(Integer classId);
    
    //修改班级
    int updateByPrimaryKeySelective(ImsClass record);
}
