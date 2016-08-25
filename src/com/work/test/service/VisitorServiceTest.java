package com.work.test.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.work.exception.UserException;
import com.work.model.User;
import com.work.service.VisitorService;

public class VisitorServiceTest {

	private ApplicationContext context;
	private VisitorService visitorService;
	
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		visitorService = context.getBean(VisitorService.class);
	}
	
	
	@Test
	public void testLogin() {
		try {
			User login = visitorService.login("张三", "0123456");
			System.out.println("登录成功："+login.getUserName());
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRegister() {
		User form_User = new User();
		form_User.setUserName("张三");
		form_User.setPassword("123456");
		
		try {
			visitorService.register(form_User);
			System.out.println("成功");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
	}

}
