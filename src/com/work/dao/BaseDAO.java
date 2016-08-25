package com.work.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 定义了一些通用的CRUD方法 主要用来被继承
 * @author 吴庆龙
 * @param <T>要操作的实体类
 */
public abstract class BaseDAO<T> {
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDAO() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	/**
	 * 保存一个实体
	 * @param t 要保存的实体
	 * @return 保存结束之后的实体
	 */
	public String save(T t) {
		return (String) getSession().save(t);
	}

	/**
	 * 保存或者更新一个实体
	 * @param t 要保存或者更新的实体
	 * @return 保存或者更新之后的实体
	 */
	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}
	
	/**
	 * 更新一个实体类
	 * @param t 要更新的实体
	 */
	public void update(T t){
		getSession().update(t);
	}

	/**
	 * 删除一个实体
	 * @param t 要删除的实体, 只需要ID就可以了
	 */
	public void delete(T t) {
		getSession().delete(t);
	}

	/**
	 * 获取一个实体
	 * @param id  实体在数据库中对应的ID
	 * @return 实体类
	 */
	public T get(String id) {
		return getSession().get(clazz, id);
	}

	/**
	 * 获取一个统计值
	 * @return
	 */
	protected Object getForValue(String hql, Object... args) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		return query.uniqueResult();
	}

	/**
	 * 根据传入的HQL, 有条件的查询数据
	 * @return 符合条件的数据
	 */
	@SuppressWarnings("unchecked")
	protected List<T> getByHQL(String hql, Object... args) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		return query.list();
	}


	/**
	 * 放回当前线程中的Session
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
