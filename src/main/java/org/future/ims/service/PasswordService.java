/**
 * 
 */
package org.future.ims.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

/** 
 *  @Package org.future.ims.service
 *  
 *  @Title: PasswordService.java 
 * 
 *  @author gclm
 * 
 *  @date 2017年11月13日 下午6:35:06 
 * 
 *  @Description: TODO(用一句话描述该文件做什么)   
 */

public interface PasswordService {
  
	//生成随机验证吗
    public  int  card();
    
    //发送邮件获取验证码
    public void sendMail(String from,String toMail,String mailTitle,String mailContent) throws MessagingException, UnsupportedEncodingException;
    
}
