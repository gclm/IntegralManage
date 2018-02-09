package org.future.ims.pojo;

import java.util.HashMap;
import java.util.Map;

/** 
 *  @Package org.future.ims.pojo
 *  
 *  @Title: Message.java 
 * 
 *  @author gclm
 * 
 *  @date 2017年11月6日 下午9:55:18 
 * 
 *  @Description: 通用的返回类  
 */
public class Messages {
    
	    //状态码   100-失败   200-成功
		private int code;
		
		//提示信息
		private String message;
		
		//用户要返回给浏览器的数据
		private Map<String, Object> extend = new HashMap<String, Object>();

		public static Messages success(){
			Messages result = new Messages();
			result.setCode(200);
			result.setMessage("处理成功！");
			return result;
		}
		
		public static Messages fail(){
			Messages result = new Messages();
			result.setCode(100);
			result.setMessage("处理失败！");
			return result;
		}
		
		public Messages add(String key,Object value){
			this.getExtend().put(key, value);
			return this;
		}
		
		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Map<String, Object> getExtend() {
			return extend;
		}

		public void setExtend(Map<String, Object> extend) {
			this.extend = extend;
		}
		
		
	
	 
}
