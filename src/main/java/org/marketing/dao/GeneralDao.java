package org.marketing.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

/**
 * 类名称：GeneralDaoImpl 类描述：实现generalDao,用于dao继承 创建人： 创建时间：2015-11-30 上午11:50:22
 * 修改人： 修改时间： 修改备注：
 */
public class GeneralDao<T> {
	@Resource
	private SessionFactory sf;

	private Class<T> clazz;

	public Session getSession() {
		return sf.getCurrentSession();
	}

	/**
	 * 初始化clazz,获取父类泛型
	 */
	@SuppressWarnings("unchecked")
	public GeneralDao() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	public Serializable save(T o) {
		return sf.getCurrentSession().save(o);
	}

	public void delete(T o) {
		sf.getCurrentSession().delete(o);
	}

	public void update(T o) {
		sf.getCurrentSession().update(o);
	}

	public void saveOrUpdate(T o) {
		sf.getCurrentSession().saveOrUpdate(o);
	}

	@SuppressWarnings("unchecked")
	public T getById(Class<T> c, Serializable id) {
		return (T) getSession().get(c, id);
	}

	/**
	 * 方法：findPageListByHQL 描述：hql语句分页查询 参数：Object
	 */
	public List<T> findPageListByHQL(String hql, int page, int rows,
			Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		q.setFirstResult((page - 1) * rows);
		q.setMaxResults(rows);
		return q.list();
	}

	/**
	 * 方法：findPageWithMapParamByHQL 描述：hql语句分页查询 参数：Map
	 */
	@SuppressWarnings("unchecked")
	public List<T> findPageWithMapParamByHQL(String hql,
			Map<String, Object> params, int page, int rows) {
		Query q = sf.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/**
	 * 方法：findPageBySQL 描述：sql语句分页查询 返回实体类 参数：Object
	 */
	public List findPageBySQL(String sql, Class clazz, int page, int rows,
			Object... objects) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		if (clazz != null) {
			q.addEntity(clazz);
		}
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		q.setFirstResult((page - 1) * rows);
		q.setMaxResults(rows);
		return q.list();
	}

	/**
	 * 方法：findPageWithMapParamBySQL 描述：sql语句分页查询 参数：Map
	 */
	@SuppressWarnings("unchecked")
	public List<Map> findPageWithMapParamBySQL(String sql,
			Map<String, Object> params, int page, int rows) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	/**
	 * 方法：findListBySQL 描述：sql语句查询实体集合 参数：Object
	 */
	public List findListBySQL(String sql, Class clazz, Object... objects) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		if (clazz != null) {
			q.addEntity(clazz);
		}
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}

	/**
	 * 方法：findListByHQL 描述：hql语句查询实体集合 参数：Object
	 */
	@SuppressWarnings("unchecked")
	public List<T> findListByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}

	/**
	 * 方法：find 描述：hql语句查询实体集合 参数：Map
	 */
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	/**
	 * 方法：findListWithMapParamBySQL 描述：sql语句查询listMap 参数：Map
	 */
	@SuppressWarnings("unchecked")
	public List<Map> findListWithMapParamBySQL(String sql,
			Map<String, Object> params) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public List<Map> findListMapBySql(String sql, Object... objects) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}
	
	public List<Object> listObj_sql_objs(String sql, Object... objects) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				q.setParameter(i, objects[i]);
			}
		}
		return q.list();
	}

	/**
	 * 方法：findBySqlList 描述：sql语句查询list 参数：Map
	 */
	public List findBySqlList(String sql, Map<String, Object> params) {
		Query q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	/**
	 * 方法：findBeanByHQL 描述：hql语句查询实体类 参数：Object
	 */
	public T findBeanByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return (T) q.uniqueResult();
	}

	/**
	 * 方法：findMapBySql 描述：sql语句查询map 参数：Object
	 */
	public Map findMapBySql(String sql, Object... objects) {
		SQLQuery q = getSession().createSQLQuery(sql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return (Map) q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
				.uniqueResult();
	}

	/**
	 * 方法：findUniqueMapBySql 描述：sql语句查询map 参数：Map
	 */
	public Map findUniqueMapBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Map) q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
				.uniqueResult();
	}

	/**
	 * 方法：findUniqueResultByHQL 描述：hql语句查询Object 参数：Object
	 */
	public Object findUniqueResultByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.uniqueResult();
	}

	/**
	 * 方法：findUniqueResultWithMapParamByHQL 描述：hql语句查询Object 参数：Map
	 */
	public Object findUniqueResultWithMapParamByHQL(String hql,
			Map<String, Object> params) {
		Query q = sf.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.uniqueResult();
	}

	/**
	 * 方法：findUniqueResultBySQL 描述：sql语句查询Object 参数：Object
	 */
	public Object findUniqueResultBySQL(String sql, Object... objects) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.uniqueResult();
	}

	/**
	 * 方法：findUniqueMapBySql 描述：sql语句查询map 参数：Map
	 */
	public Object findUniqueResultBySQL(String sql, Map<String, Object> params) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.uniqueResult();
	}

	/**
	 * 方法：findBySqlUniqueResult 描述：sql语句查询Object 参数：Map
	 */
	public Object findBySqlUniqueResult(String sql, Map<String, Object> params) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.uniqueResult();
	}

	/**
	 * 方法：count 描述：hql查询count 参数：Map
	 */
	public Long count(String hql, Map<String, Object> params) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 * 方法：countBySql 描述：sql查询count 参数：Map
	 */
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (BigInteger) q.uniqueResult();
	}

	/**
	 * 方法：countBySql_o 描述：sql查询count 参数：Object
	 */
	public int countBySql_o(String sql, Object... objects) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				q.setParameter(i, objects[i]);
			}
		}
		Object o = q.uniqueResult();
		return Integer.parseInt(o.toString());
	}

	/**
	 * 方法：updateByHQL 描述：hql修改 参数：Object
	 */
	public int updateByHQL(String hql, Object... objects) {
		Query q = sf.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.executeUpdate();
	}

	/**
	 * 方法：executeHql 描述：hql修改 参数：Map
	 */
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	/**
	 * 方法：updateBySQL 描述：sql修改 参数：Object
	 */
	public int updateBySQL(String sql, Object... objects) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		for (int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.executeUpdate();
	}

	/**
	 * 方法：executeSql 描述：sql修改 参数：Map
	 */
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	/**
	 * 方法：executeSql 描述：sql修改
	 */
	public int executeSql(String sql) {
		SQLQuery q = sf.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return this.getSession();
	}

}
