package org.future.ims.test;

import java.util.List;

import org.future.ims.mapper.ImsUserMapper;
import org.future.ims.pojo.ImsUser;
import org.future.ims.service.UserService;
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
	
	
}
