package org.future.ims.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.future.ims.mapper.ImsClubroomMapper;
import org.future.ims.mapper.ImsIntegralMapper;
import org.future.ims.mapper.ImsSemesterMapper;
import org.future.ims.mapper.ImsStudentMapper;
import org.future.ims.pojo.ImsClubroom;
import org.future.ims.pojo.ImsIntegral;
import org.future.ims.pojo.ImsIntegralExample;
import org.future.ims.pojo.ImsSemester;
import org.future.ims.pojo.ImsStudent;
import org.future.ims.pojo.QueryVoIntegral;
import org.future.ims.service.ClubroomService;
import org.future.ims.service.IntegralService;
import org.future.ims.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
  *  Class Name: IntegralServiceImpl.java
  *  Description:
  *  @author  zsh  DateTime 2017年11月9日 下午10:28:46
  *  @company future
  *  @email  43240825@qq.com 
  *  @version 1.0
  */
@Service("integralService")
public class IntegralServiceImpl implements IntegralService{
	@Autowired
	private ImsIntegralMapper integralMapper;
	@Autowired
	private ImsStudentMapper studentMapper;
	@Autowired
	private ImsSemesterMapper semesterMapper;
	@Autowired
	private  ClubroomService  clubroomService;
	
	/**
	  *  Description:
	  *  @author  zsh  DateTime 2017年11月10日 上午10:12:35
	  *  @param in
	  *  @param file
	  *  批量导入积分方法
	  *  @return
	  */
	@Override
	public List<ImsIntegral> importExcelInfo(InputStream in, MultipartFile file,String semester,String name) {
		List<List<Object>> listob;   
		try {
			listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
			List<ImsIntegral> integralList = new ArrayList<ImsIntegral>();
			List<ImsIntegral> repalce = new ArrayList<ImsIntegral>();
			//获取系统当前时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String time = df.format(new Date());// new Date()为获取当前系统时间
		    //遍历listob数据，把数据放到List中  
		    for (int i = 0; i < listob.size(); i++) {  
		        List<Object> ob = listob.get(i);  
		        ImsIntegral integralmanage = new ImsIntegral(); 
		        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载  
		        integralmanage.setStudentName(String.valueOf(ob.get(0)));
		        integralmanage.setStudentId(String.valueOf(ob.get(1)));
		        integralmanage.setGrades(String.valueOf(ob.get(2)));
		        integralmanage.setScore(Float.parseFloat(String.valueOf(ob.get(3))));
		        integralmanage.setReason(String.valueOf(ob.get(4)));
		        integralmanage.setTime(String.valueOf(ob.get(5)));
		        integralmanage.setClubroom(String.valueOf(ob.get(6)));
		        integralmanage.setIntSemester(semester);
		        integralmanage.setCreatime(time);
		        integralmanage.setName(name);
		        integralList.add(integralmanage);
		    }  
		    //批量插入
		    for (ImsIntegral imsIntegral : integralList) {
		    	//插入之前查询信息是否属实
		    	//1.查询有无此学生
		    	ImsStudent studentByStudentId = studentMapper.getStudentByStudentId(imsIntegral.getStudentId());
			    //2.查询有无此部室
		    	//此方法返回true表示无此部室，返回false表示有此部室
		    	boolean checkClubroom = clubroomService.checkClubroom(imsIntegral.getClubroom());
		    	//3.查询有无此学期
		    	List<ImsSemester> semesterByName = semesterMapper.getSemesterByName(imsIntegral.getIntSemester());
		    	//当同时满足一下条件时，才放行
		    	//存在此部室，存在此学生学号且姓名、班级与所录入的一致，学期存在
		    	if(!checkClubroom && studentByStudentId != null && semesterByName != null && studentByStudentId.getName().equals(imsIntegral.getStudentName())
		    			&& studentByStudentId.getGrades().equals(imsIntegral.getGrades())){
		    		//查重
		    		List<ImsIntegral> queryRepetition = integralMapper.queryRepetition(imsIntegral.getStudentName(), imsIntegral.getStudentId(), 
		    				imsIntegral.getGrades(), imsIntegral.getScore(), imsIntegral.getReason(), imsIntegral.getTime(), 
		    				imsIntegral.getClubroom(), imsIntegral.getIntSemester());
		    		if(queryRepetition.size() == 0){
		    			integralMapper.insert(imsIntegral);
		    		}else{
		    			repalce.add(imsIntegral);
		    		}
		    	}else{
		    		repalce.add(imsIntegral);
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
	public int insert(ImsIntegral record) {
		return integralMapper.insert(record);
	}


	@Override
	public List<ImsIntegral> getAllIntegral() {
		return integralMapper.selectByExample(null);
	}


	@Override
	public int deleteByPrimaryKey(Integer integralId) {
		return integralMapper.deleteByPrimaryKey(integralId);
	}


	@Override
	public List<ImsIntegral> selectByVo(QueryVoIntegral voQueryVoIntegral) {
		return integralMapper.selectByVo(voQueryVoIntegral);
	}


	@Override
	public int updateByPrimaryKey(ImsIntegral record) {
		return integralMapper.updateByPrimaryKeySelective(record);
	}


	/* (non-Javadoc)
	 * @see org.future.ims.service.IntegralService#queryRepetition(java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ImsIntegral> queryRepetition(String studentName, String studentId, String grades, Float score,
			String reason, String time, String clubroom, String intSemester) {
		return integralMapper.queryRepetition(studentName, studentId, grades, score, reason, time, clubroom, intSemester);
	}

}
