/**
 * 
 */
package org.future.ims.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.future.ims.service.PasswordService;
import org.future.ims.utils.IOEamilPassword;
import org.springframework.stereotype.Service;



/** 
 *  @Package org.future.ims.service.impl
 *  
 *  @Title: PasswordServiceImpl.java 
 * 
 *  @author gclm
 * 
 *  @date 2017年11月13日 下午6:35:36 
 * 
 *  @Description: TODO(用一句话描述该文件做什么)   
 */
@Service("passwordServiceImpl")
public class PasswordServiceImpl implements PasswordService {

	/* (non-Javadoc)
	 * @see org.future.ims.service.PasswordService#card()
	 */
	@Override
	public int card() {
		  
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		
	       Random rand = new Random();
	       for (int i = 10; i > 1; i--) {
	           int index = rand.nextInt(i);
	           int tmp = array[index];
	           array[index] = array[i - 1];
	           array[i - 1] = tmp;
	       }
	       int result = 0;
	       for(int i = 0; i < 6; i++){
	           result = result * 10 + array[i];
	       }
	       return result;
	}

	/* (non-Javadoc)
	 * @see org.future.ims.service.PasswordService#sendMail(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void sendMail(String from,String toMail,String mailTitle,String mailContent) throws MessagingException, UnsupportedEncodingException{
		IOEamilPassword ioEamilPassword = new IOEamilPassword();
		String fromEmail = ioEamilPassword.load().getEmailName();  //1719982754@qq.com
		String password = ioEamilPassword.load().getEamilPassword();  //ogmqdtlyhbvzdfbf
		Properties props = new Properties();//加载一个配置文件
		props.put("mail.smtp.host", "smtp.qq.com");//存储发送邮件服务器的信息,qq为例，如果是163则是smtp.163.com
		props.put("mail.transport.protocol","smtp");//使用smtp简单邮件传输协议
		props.put("mail.smtp.auth", "true");//是否需要身份验证
		props.put("mail.smtp.ssl.enable", "true");//QQ邮箱的SSL加密,不设置出现530 Error: A secure connection is requiered(such as ssl)错误
		Session session = Session.getInstance(props);
		session.setDebug(true);//开启Session的debug模式，这样就可以查看到程序发送Email的运行状态

		MimeMessage msg = new MimeMessage(session);//由邮件会话创建一个扩展信息对象，包装信息格式，可以只是简单文本
        //msg.setFrom(new InternetAddress(fromMail));//设置发件人的地址

		//自定义昵称
		String nick = MimeUtility.encodeText(from);//防止乱码
		msg.setFrom(new InternetAddress(nick+"<"+fromEmail+">"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));//设置收件人，并设置其接受类型为to
		msg.setSubject(mailTitle);//设置标题
		msg.setContent(mailContent,"text/html;charset=UTF-8");//设置为html格式，可以发送多种样式
        //msg.setSentDate(new Date());	//设置发信时间
		msg.saveChanges(); //存储邮件信息
		
		Transport tran = session.getTransport("smtp");//使用smtp协议获取session环境的Transprot对象来发送邮件 javamial使用Transport对象来管理发送邮件服务
		tran.connect(props.getProperty("mail.smtp.host"),fromEmail,password);//链接邮箱服务器，发送邮件的邮箱，以及授权码
		tran.sendMessage(msg, msg.getAllRecipients());//发送邮件，getAllRecipients()是所有已设好的收件人地址
		tran.close();
	}
	
}
