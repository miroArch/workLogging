package com.work.action;

import java.util.Map;

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

	private String username;
	private String password;

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

		//封装登录表单
		User formUser = new User();
		formUser.setUserName(username);
		formUser.setPassword(username);
		
		String result = null;
		try {
			session.put("user", visitorService.login(username, password));
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

		//封装注册表单
		User formUser = new User();
		formUser.setUserName(username);
		formUser.setPassword(password);
		
		String result = null;
		try {
			visitorService.register(formUser);
			result = "REGISTSUCCESS";
		} catch (UserException e) {
			request.put("error", e.getMessage());//将错误信息放到request中，然后显示给用户
			result = "REGISTERROR";
		}
		return result;
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
