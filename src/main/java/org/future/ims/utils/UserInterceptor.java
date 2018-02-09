package org.future.ims.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.future.ims.pojo.ImsUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName:     UserInterceptor.java
 *  
 * @author         孤城落寞
 *
 * @Date           2017年10月22日 下午4:30:37
 *
 * @Description:   user行为拦截  
 */
public class UserInterceptor implements HandlerInterceptor{

	/**
	 * 	 判断用户是否登录     如果没有登录    就重定向到登录界面   不放行    如果登录了  就放行
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @return
	 * @throws Exception
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		/*String requestURI = request.getRequestURI();
		
		if(!requestURI.contains("/login")) {
			ImsUser user = (ImsUser) request.getSession().getAttribute("User");
			if(user==null){
				response.sendRedirect(request.getContextPath()+"/base/login.do");
				return false;
			}     			
		}*/
		
	    return  true;
   }
	
	
	

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mav)
			throws Exception {
		
	/*	request.setCharacterEncoding("UTF-8");
		// 转码
		response.setContentType("text/html; charset=UTF-8");
		
		HttpServletRequest HRequest = (HttpServletRequest) request;		
		// 获得登陆用户
		ImsUser admin = (ImsUser) HRequest.getSession().getAttribute("admin");
		// 获得登陆用户
        ImsUser administrator = (ImsUser) HRequest.getSession().getAttribute("administrator");
		
        ImsUser tourists = (ImsUser) HRequest.getSession().getAttribute("tourists");
		String returnUrl = request.getContextPath()+"/login.do";
		String path = HRequest.getRequestURI();
		//进行登录判断
		if(admin!=null){
			response.sendRedirect(request.getContextPath()+"/login.do");
		} else if(administrator!=null){
			response.sendRedirect(request.getContextPath()+"/login.do");
		}else if(tourists!=null){
			response.sendRedirect(request.getContextPath()+"/login.do");			
		} else {		
			//当用户为登录或登录超时时提醒并跳转到登录界面
			response.getWriter()
					.println("<script language=\"javascript\">" +"alert(\"登录失效！请重新登录\");"+ "if(window.opener==null){window.top.location.href=\""
							+ returnUrl + "\";}else{window.opener.top.location.href=\"" + returnUrl
							+ "\";window.close();}</script>");
			return;
		}  	*/
	}		
		

	/**
	 * @param request
	 * @param response
	 * @param arg2
	 * @param arg3
	 * @throws Exception
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
	}


     
}
