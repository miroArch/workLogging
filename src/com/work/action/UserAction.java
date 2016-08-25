package com.work.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.work.exception.UserException;
import com.work.model.Logging;
import com.work.model.User;
import com.work.service.UserService;
import com.work.utils.StrUtil;
import com.work.utils.TimeUtils;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements RequestAware ,SessionAware{
	private static final long serialVersionUID = -351137905648141528L;
	
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	@Autowired
	private UserService userService;
	
	private Logging logging;
	private String date;
	
	
	
	public String toAddLoggingPage(){
		return "TOADDLOGGINGPAGE";
	}
	
	/**
	 * 保存日志
	 * @return
	 * @author 张昊
	 * @date 2016年8月7日
	 */
	public String saveLogging(){
		User user = (User)session.get("user");
		try {
			userService.saveLogging(user.getId(), logging.getLoggingText());
			request.put("msg", "保存成功！再来一发？");
			return "SAVESUCCESS";
		} catch (UserException e) {
			request.put("msg", e.getMessage());
			return "SAVEERROR";
		}
	}
	
	/**
	 * 根据日期查看日志数据
	 * @return
	 * @author 张昊
	 * @date 2016年8月8日
	 */
	public String viewLoggingByDate(){
		//1.如果日志为空，则返回今天的数据
		if(date == null || StrUtil.isEmpty(date))
			date = TimeUtils.getNow(TimeUtils.YMD);
		//2.获取数据
		List<Logging> loggingByNowList = userService.getLoggingByDate(date);
		//3.将日期放入request中
		request.put("loggingList", loggingByNowList);
		request.put("pageDate", date);
		return "VIEWSUCCESS";
	}
	
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}


	public Logging getLogging() {
		return logging;
	}


	public void setLogging(Logging logging) {
		this.logging = logging;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}

