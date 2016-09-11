package com.work.action;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.work.exception.UserException;
import com.work.model.User;
import com.work.service.VisitorService;

/**
 * 游客操作
 * 
 * @author 朱云铖
 *
 */
@Controller
@Scope("prototype")
public class VisitorAction extends ActionSupport implements RequestAware ,SessionAware{

	private static final long serialVersionUID = 1L;

	@Autowired
	private VisitorService visitorService;

	private User user;
	private String autoLogin;

	/**
	 * 自动到首页的时候才自动登陆
	 * @return
	 * @author 张昊
	 * @date 2016年9月11日
	 */
	public String autoToLoginPage(){
		//检查Cookie是否存放数据
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		//如果cookie中存放着用户名和密码，进行登陆
		for (Cookie cookie:cookies) {
			String userName = cookie.getName();
			String passWord = cookie.getValue();
			try {
				User db_User = visitorService.login(URLDecoder.decode(userName), passWord);
				session.put("user", db_User);
				request.put("msg", "自动登陆成功");
				return "LOGINSUCCESS";
			} catch (UserException e) {}
		}
		//如果不成功则去登录页面
		return "toLoginPage";
	}
	
	
	/**
	 * 前往登录页面
	 * @return
	 * @author 张昊
	 * @date 2016年8月8日
	 */
	public String toLoginPage(){
		return "toLoginPage";
	}

	/**
	 * 前往注册页面
	 * @return
	 * @author 张昊
	 * @date 2016年8月8日
	 */
	public String toRegisterPage(){
		return "toRegisterPage";
	}
	
	/**
	 * 退出登录
	 * @return
	 * @author 张昊
	 * @date 2016年8月8日
	 */
	public String logout(){
		session.remove("user");
		return "LOGOUT";
	}
	
	/**
	 * 游客登陆
	 * @author 朱云铖
	 * @return
	 */
	public String login(){
		String result = null;
		try {
			User db_User = visitorService.login(user.getUserName(),user.getPassword());
			session.put("user", db_User);
			//查看是否是自动登陆
			if(autoLogin!=null && autoLogin.equals("yes")){
				Cookie cookie = new Cookie(URLEncoder.encode(db_User.getUserName()), db_User.getPassword());
				cookie.setMaxAge(60*60*24*365);
				ServletActionContext.getResponse().addCookie(cookie);
			}
			result = "LOGINSUCCESS";
		} catch (UserException e) {
			request.put("error", e.getMessage());
			result = "LOGINERROR";
		}
		return result;
	}
	
	
	/**
	 * 游客注册
	 * @author 朱云铖
	 * @return 
	 */
	public String register() {
		String result = null;
		try {
			visitorService.register(user);
			result = "REGISTSUCCESS";
		} catch (UserException e) {
			request.put("error", e.getMessage());//将错误信息放到request中，然后显示给用户
			result = "REGISTERROR";
		}
		return result;
	}

	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}


	/*
	 * 拿到requset对象
	 */
	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;
	}

	/*
	 * 拿到session对象
	 */
	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {

		this.session = arg0;
	}

}
