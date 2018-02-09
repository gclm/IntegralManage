package org.future.ims.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.future.ims.mapper.ImsClassMapper;
import org.future.ims.pojo.ImsClass;
import org.future.ims.pojo.ImsClassExample;
import org.future.ims.pojo.ImsStudent;
import org.future.ims.service.ClassService;
import org.future.ims.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service("classService")
public class ClassServiceImpl implements ClassService{

	@Autowired
	private ImsClassMapper classMapper;

	@Override
	public int addClass(ImsClass clas) {
		// TODO Auto-generated method stub
		return classMapper.insert(clas);
	}

	@Override
	public List<ImsClass> getClassAll() {
		// TODO Auto-generated method stub
		ImsClassExample imsClassExample = new ImsClassExample();
		imsClassExample.setOrderByClause("class_id");
		return classMapper.selectByExample(imsClassExample);
	}

	@Override
	public List<ImsClass> getClassByName(String name) {
		return classMapper.getClassByName(name);
	}

	@Override
	public int deleteByPrimaryKey(Integer classId) {
		return classMapper.deleteByPrimaryKey(classId);
	}

	@Override
	public int updateByPrimaryKeySelective(ImsClass record) {
		return classMapper.updateByPrimaryKey(record);
	}

	
	
	/**
	  *  Description:
	  *  @author  zsh  DateTime 2017年11月6日 下午4:51:48
	  *  @param 对班级名称的精准查询，用于添加、修改时查重
	  *  @return
	  */
	@Override
	public List<ImsClass> getCompletelyClassByName(String name) {
		return classMapper.getCompletelyClassByName(name);
	}

	/**
	 * 批量导入班级方法
	 */
	@Override
	public List<ImsClass> importExcelInfo(InputStream in, MultipartFile file) {
		List<List<Object>> listob;   
		try {
			listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
			List<ImsClass> classList = new ArrayList<ImsClass>();
			List<ImsClass> repalce = new ArrayList<ImsClass>();
		    //遍历listob数据，把数据放到List中  
		    for (int i = 0; i < listob.size(); i++) {  
		        List<Object> ob = listob.get(i);  
		        ImsClass classmanage = new ImsClass();   
		        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载  
		        classmanage.setClassName(String.valueOf(ob.get(0)));
		        classList.add(classmanage);
		    }  
		    //批量插入  
		    for (ImsClass imsClass : classList) {
		    	//插入之前去掉重复的数据
		    	List<ImsClass> completelyClassByName = classMapper.getCompletelyClassByName(imsClass.getClassName());
			    
		    	if(completelyClassByName.size() == 0){
		    		
		    		classMapper.insert(imsClass);
		    		
		    	}else{
		    		
		    		repalce.add(imsClass);
		    	}
			}
		    return repalce;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}