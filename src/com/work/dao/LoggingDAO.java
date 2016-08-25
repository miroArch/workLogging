package com.work.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.work.model.Logging;

@Repository
public class LoggingDAO extends BaseDAO<Logging>{

	public List<Logging> getByDate(String date) {
		String hql = "FROM Logging WHERE date = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, date);
		return query.list();
	}

}
