package org.future.ims.filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.future.ims.pojo.ImsUser;

/**
 * Servlet Filter implementation class LoginFilter
 */

/**
 * @author q4467 登陆filter，判断当用户session为空的时候，跳转到登陆界面
 *
 */
public class LoginFilter implements Filter {

	private FilterConfig Config;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); // 转码
		HttpServletRequest hRequest = (HttpServletRequest) request;
		ImsUser administrator = (ImsUser) hRequest.getSession().getAttribute("administrator");// 获得登陆用户
		ImsUser admin = (ImsUser) hRequest.getSession().getAttribute("admin");// 获得登陆用户
		ImsUser tourists = (ImsUser) hRequest.getSession().getAttribute("tourists");// 获得登陆用户
		String returnUrl = hRequest.getContextPath() + "/index.html";
		String path = hRequest.getRequestURI();
		if (administrator != null) { //
			chain.doFilter(request, response);
		} else if (admin != null) {
			chain.doFilter(request, response);
		} else if (tourists != null) { //
			chain.doFilter(request, response);
		} else { // 当用户为登录或登录超时时提醒并跳转到登录界面
			response.getWriter().println("<script language=\"javascript\">" + "alert(\"登录失效！请重新登录\");"
					+ "if(window.opener==null){window.top.location.href=\"" + returnUrl
					+ "\";}else{window.opener.top.location.href=\"" + returnUrl + "\";window.close();}</script>");
			response.getWriter().close();
			return;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		Config = fConfig;
	}

}