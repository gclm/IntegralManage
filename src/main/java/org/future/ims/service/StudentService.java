package org.future.ims.service;

import org.future.ims.pojo.ImsStudent;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.List;


/**
  *  Class Name: StudentService.java
  *  Description:
  *  @author  zsh  DateTime 2017年11月3日 下午8:34:00
  *  @company future
  *  @email  43240825@qq.com 
  *  @version 1.0
  */
public interface StudentService {
	
	//单个添加学生
	int addStudent(ImsStudent student);
	//批量导入
	List<ImsStudent> importExcelInfo(InputStream in, MultipartFile file);
	
	
    //通过学号获取学生对象
    ImsStudent getStudentByStudentId(String studentId);
    
    //模糊查询
    List<ImsStudent> searchByReplace(String replace);

    //获取所有学生对象
    List<ImsStudent>  getStudentAll();
    
    //删除学生对象
    int deleteByPrimaryKey(Integer id);
    
    //修改学生对象
    int updateByPrimaryKeySelective(ImsStudent record);
	
}
