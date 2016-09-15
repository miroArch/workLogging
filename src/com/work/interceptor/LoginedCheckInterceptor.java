package com.work.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginedCheckInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// 取得请求的URL
		String url = ServletActionContext.getRequest().getRequestURL().toString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		// 对登录与注销请求直接放行,不予拦截
		if (url.indexOf("visitor-toLoginPage") != -1||url.indexOf("visitor-login") != -1 || url.indexOf("logout.action") != -1) {
			return ai.invoke();
		}
		if (ServletActionContext.getRequest().getSession().getAttribute("user") == null) {
			ServletActionContext.getContext().put("error", "请先进行登陆后再操作！");
			return "toLoginPage";
		} else {
			return ai.invoke();
		}
	}

}
