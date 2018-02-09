package org.future.ims.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.future.ims.mapper.ImsStudentMapper;
import org.future.ims.pojo.ImsStudent;
import org.future.ims.service.StudentService;
import org.future.ims.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private ImsStudentMapper studentMapper;

	@Override
	public int addStudent(ImsStudent student) {
		// TODO Auto-generated method stub
		return studentMapper.insert(student);
	}

	@Override
	public ImsStudent getStudentByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return studentMapper.getStudentByStudentId(studentId);
	}
	
	
	
	/**
	  *  Description:
	  *  @author  zsh  DateTime 2017年11月10日 上午10:10:33
	  *  @param in
	  *  @param file
	  *  批量导入方法
	  *  @return
	  */
	@Override
	public List<ImsStudent> importExcelInfo(InputStream in, MultipartFile file){  
	    List<List<Object>> listob;   
		try {
			listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
			List<ImsStudent> studentList = new ArrayList<ImsStudent>();
			List<ImsStudent> repalce = new ArrayList<ImsStudent>();
		    //遍历listob数据，把数据放到List中  
		    for (int i = 0; i < listob.size(); i++) {  
		        List<Object> ob = listob.get(i);  
		        ImsStudent studnetmanage = new ImsStudent();   
		        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载  
		        studnetmanage.setStudentId(String.valueOf(ob.get(0)));
		        studnetmanage.setName(String.valueOf(ob.get(1)));
		        studnetmanage.setGrades(String.valueOf(ob.get(2)));
		        studentList.add(studnetmanage);
		    }  
		    //批量插入  
		    for (ImsStudent imsStudent : studentList) {
		    	//插入之前去掉重复的数据
		    	ImsStudent studentByStudentId = studentMapper.getStudentByStudentId(imsStudent.getStudentId());
			    	
		    	if(studentByStudentId == null){
		    		studentMapper.insert(imsStudent);
		    	}else{
		    		
		    		repalce.add(imsStudent);
		    	}
			}
		    return repalce;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ImsStudent> getStudentAll() {
		// TODO Auto-generated method stub
		return studentMapper.selectByExample(null);
	}

	@Override
	public List<ImsStudent> searchByReplace(String replace) {
		// TODO Auto-generated method stub
		return studentMapper.searchByReplace(replace);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ImsStudent record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}
}