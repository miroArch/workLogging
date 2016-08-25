package com.work.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.work.exception.UserException;
import com.work.model.Logging;
import com.work.model.User;
import com.work.utils.StrUtil;
import com.work.utils.TimeUtils;

/**
 * 用户Service
 * @author 张昊
 * @date 2016年8月7日
 */
@Service
public class UserService extends SuperService{

	/**
	 * 保存日志
	 * @param userId
	 * @param loggingText
	 * @author 张昊
	 * @date 2016年8月7日
	 */
	public void saveLogging(String userId,String loggingText) throws UserException{
		//1.检查参数是否正确
		if(StrUtil.isEmpty(userId)||StrUtil.isEmpty(loggingText)){
			throw new UserException("保存日志信息不全");
		}
		//2.查看用户是否存在
		User db_User = userDAO.get(userId);
		if(db_User==null)
			throw new UserException("用户不存在");
		//3.保存日志信息
		Logging logging = new Logging();
		logging.setUser(db_User);
		logging.setLoggingText(loggingText);
		logging.setDate(TimeUtils.getNow(TimeUtils.YMD));
		logging.setTime(TimeUtils.getNow(TimeUtils.HM));
		loggingDAO.save(logging);
	}
	
	/**
	 * 通过日期查看日志
	 * @param data
	 * @return
	 * @author 张昊
	 * @date 2016年8月7日
	 */
	public List<Logging> getLoggingByDate(String date){
		//0.创建一个存放数据的容器
		List<Logging> allLogging  = loggingDAO.getByDate(date);
		return allLogging;
	}
	
}
