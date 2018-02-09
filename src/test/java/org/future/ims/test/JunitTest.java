package org.future.ims.test;

import java.util.List;

import org.future.ims.mapper.ImsUserMapper;
import org.future.ims.mapper.ImsIntegralMapper;
import org.future.ims.pojo.ImsUser;
import org.future.ims.pojo.ImsIntegral;
import org.future.ims.service.UserService;
import org.future.ims.service.IntegralService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTest {
    
	
	@Test
    //spring mybatis  springmvc整合测试完成	
	public void  MapperTest() throws Exception{
		
       ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	   
       ImsUserMapper userMapper = ac.getBean(ImsUserMapper.class); 
       
       ImsUser user = userMapper.selectByStudentId("20161564314");
	 
       System.out.println(user);
    	
	}
	
	 @Autowired
	 UserService us;
	
	@Test
	public void  ServiceTest(){
		/*ImsUser u=new ImsUser();
		u.setStudent_id("20161564314");
		u.setPassword("123");
		boolean userByCodePassword = us.getUserByCodePassword(u);
	    System.out.println(userByCodePassword);*/
		   
	}
	
	
	@Autowired
	IntegralService integralService;
	
	@Test
	public void aaa() {
		String studentName = "张顺海";
		String studentId = "20161544106";
		String grades = "通信161";
		float score = 0.1f;
		String reason = "招聘会服务";
		String time = "第九周";
		String clubroom = "生活部";
		String intSemester = "2015-2016学年第一学期";
		
		List<ImsIntegral> queryRepetition = integralService.queryRepetition(studentName, studentId, grades, score, reason, time, clubroom, intSemester);
		
		System.out.println(queryRepetition.size());
		
		for (ImsIntegral imsIntegral : queryRepetition) {
			System.out.println(imsIntegral.toString());
		}
	}
	
	
}
