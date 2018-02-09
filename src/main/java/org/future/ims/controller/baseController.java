/**
 * 
 */
package org.future.ims.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.future.ims.pojo.EamilPassword;
import org.future.ims.pojo.ImsUser;
import org.future.ims.pojo.Messages;
import org.future.ims.service.PasswordService;
import org.future.ims.service.UserService;
import org.future.ims.utils.IOEamilPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package org.future.ims.controller
 * 
 * @Title: baseController.java
 * 
 * @author 孤城落寞
 * 
 * @date 2017年10月28日 下午4:21:10
 * 
 * @Description: 登录 注销 找回密码 改密
 */
@Controller
@RequestMapping(value = "/base")
public class baseController {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordService passwordService;

	/**
	 * 跳转到用户登录
	 * 
	 * @return
	 */

	@RequestMapping(value = "/login_index.do")
	public String login() {
		return "login";
	}

	/**
	 * 执行登陆操作
	 * 
	 * @param u
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/login.do")
	public String login(ImsUser u, Model model, HttpSession httpSesssion) {
		// 复制登陆成功后的地址，此时get请求，账号密码都是空
		if (u.getUserId() == null && u.getPassword() == null) {
			model.addAttribute("loginMessage", "您还没有登陆呢");
			return "login";
		} else {
			ImsUser exitU = userService.getUserByStudentId(u.getStudentId());
			// 判断用户是否存在 密码是否正确
			if (exitU != null) {
				if (exitU.getPassword().equals(u.getPassword())) {
					httpSesssion.setAttribute("user", exitU);
					// 进行身份辨别
					if (exitU.getRole().equals("administrator")) {
						// 传值
						httpSesssion.setAttribute("administrator", exitU);
						// 返回的页面
						return "administrator/index";

					} else if (exitU.getRole().equals("admin")) {
						// 传值
						httpSesssion.setAttribute("admin", exitU);
						// 返回的页面
						return "admin/index";
					} else if (exitU.getRole().equals("tourists")) {
						// 传值
						httpSesssion.setAttribute("tourists", exitU);
						// 返回的页面
						return "tourists/index";
					}
				} else {
					// 传值
					model.addAttribute("loginMessage", "密码输入错误！");
					// 返回的页面
					return "login";
				}
			} else {
				// 传值
				model.addAttribute("loginMessage", "用户不存在");
				// 返回的页面
				return "login";
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	// 退出登录后,防倒退再次进入
	@RequestMapping(value = "/logOff.do")
	public String logOff(Model model, String role) {
		model.addAttribute("role", role);
		return "logOff";
	}

	/**
	 * 注销登录
	 * 
	 * @param session
	 * @param model
	 * @param role
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session, Model model, String role) throws Exception {
		// 清除session中的user信息
		session.removeAttribute("user");
		if (role.equals("admin")) {

			session.removeAttribute("admin");

		} else if (role.equals("administrator")) {

			session.removeAttribute("administrator");

		} else if (role.equals("tourists")) {
			session.removeAttribute("tourists");

		}

		model.addAttribute("logoutMessage", "注销成功,欢迎下次使用");

		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "/addPassword.do", method = RequestMethod.PUT)
	public void addPassword(HttpServletRequest request, EamilPassword eamilPassword) {
		// 调用util工具包，在通过IO读写eamilPassword.txt文件
		new IOEamilPassword().save(eamilPassword);
	}

	/**
	 * 找回密码跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/passWord.do")
	public String passWord() {
		return "findPass";
	}

	int card;

	/**
	 * 找回密码-发送邮箱验证码
	 * 
	 * @param toMail
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws MessagingException
	 */
	@ResponseBody
	@RequestMapping(value = "/retrievePassword.do", method = RequestMethod.POST)
	public Messages retrievePassword(String toMail, Model model)
			throws UnsupportedEncodingException, MessagingException {

		ImsUser selectByEmail = userService.selectByEmail(toMail);

		if (selectByEmail != null) {
			card = passwordService.card();
			passwordService.sendMail("信工院积分验证码", toMail, "信工院积分管理系统-邮箱验证码",
					"<span style='color:red;'>" + card + "</span>");
			return Messages.success();
		} else {
			return Messages.fail().add("emailMessages", "邮件发送错误，未注册该邮箱");
		}
	}

	/**
	 * 找回密码-验证码验证
	 * 
	 * @param verifyCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/emailVerify.do", method = RequestMethod.POST)
	public Messages emailVerify(int verifyCode) {

		if (verifyCode == card) {
			return Messages.success();
		} else {
			return Messages.fail();
		}
	}

	/**
	 * 找回密码-修改密码
	 * 
	 * @param password
	 * @param toMail
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
	public Messages updatePassword(String password, String toMail) {
		// 通过邮箱查找用户
		ImsUser selectByEmail = userService.selectByEmail(toMail);
		// 修改密码
		selectByEmail.setPassword(password);
		userService.updateByUser(selectByEmail);
		return Messages.success();
	}
}
