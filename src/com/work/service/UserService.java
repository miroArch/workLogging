package com.work.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.work.exception.UserException;
import com.work.model.Comment;
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

	/**
	 * 根据日志记事的ID查看其评论
	 * @param id
	 * @return
	 */
	public List<Comment> getCommentsByLoggingId(String loggingId) {
		return commentDAO.getCommentsByLoggingId(loggingId);
	}

	/**
	 * 根据日志ID返回日志对象
	 * @param id
	 * @return
	 */
	public Logging getLoggingById(String id) {
		return loggingDAO.get(id);
	}

	/**
	 * 添加评论
	 * @param session_User
	 * @param comment
	 * @throws UserException 
	 */
	public void addComment(User session_User, Comment comment) throws UserException {
		//1.检查参数
		if(session_User==null||comment==null||comment.getContent()==null||comment.getLogging()==null){
			throw new UserException("评论参数不全");
		}
		//2.进行计算时间
		String now = TimeUtils.getNow(TimeUtils.YMDHM);
		comment.setCreateTime(now);
		comment.setUser(session_User);
		//3.进行保存
		commentDAO.save(comment);
	}

	/**
	 * 为某个评论点赞
	 */
	public void addLikeComment(String id) {
		Comment comment = commentDAO.get(id);
		int like = comment.getLikeCount() == null ? 0 :comment.getLikeCount();
		comment.setLikeCount(like+1);
		commentDAO.update(comment);
	}
	
}
