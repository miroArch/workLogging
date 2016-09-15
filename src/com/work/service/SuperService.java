package com.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.dao.CommentDAO;
import com.work.dao.LoggingDAO;
import com.work.dao.UserDAO;

@Service
public class SuperService {

	@Autowired
	protected UserDAO userDAO;
	@Autowired
	protected LoggingDAO loggingDAO;
	@Autowired
	protected CommentDAO commentDAO;
	
}
