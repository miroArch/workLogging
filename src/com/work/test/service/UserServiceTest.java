package com.work.test.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.work.exception.UserException;
import com.work.model.Logging;
import com.work.service.UserService;

public class UserServiceTest {

	private ApplicationContext context;
	private UserService userService;
	
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		userService = context.getBean(UserService.class);
	}
	
	
	@Test
	public void testSaveLogging() {
		String userId = "285881566405820156640589400000";
		String longText = "今天完成了";
		try {
			userService.saveLogging(userId, longText);
			System.out.println("保存成功");
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testGetLoggingByDate() {
		List<Logging> loggingByDate = userService.getLoggingByDate("2016-08-07");
		for (Logging logging : loggingByDate) {
			System.out.println(logging.getUser().getUserName());
			System.out.println(logging.getLoggingText());
			System.out.println(logging.getDate());
			System.out.println(logging.getTime());
			System.out.println("=====================");
		}
	}

}
