package com.work.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.work.model.User;

import sun.print.resources.serviceui;

@Repository
public class UserDAO extends BaseDAO<User>{

	/**
	 * 根据用户名查找用户
	 * @return
	 * @author 张昊
	 * @date 2016年8月7日
	 */
	public User getByUserName(String userName) {
		String hql = "FROM User WHERE userName = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userName);
		List<User> list = query.list();
		return list.size()==0?null:list.get(0);
	}

}
