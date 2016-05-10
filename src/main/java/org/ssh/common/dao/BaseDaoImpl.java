package org.ssh.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.ssh.common.ConditionQuery;
import org.ssh.common.OrderBy;
import org.ssh.common.PageModel;
import org.ssh.common.entity.BasePojo;
import org.ssh.common.exception.DaoException;

/**
* @Package : org.ssh.common.dao
* @FileName : BaseDaoImpl
* @Description : 
* @Author : YJ
* @Date : 2015年12月31日 下午12:28:22
*/
public abstract class BaseDaoImpl<M extends BasePojo,PK extends Serializable> implements IBaseDao<M,PK> {

	protected static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
	@Autowired
	protected SessionFactory sessionFactory;
	private final Class<M> entityClass;
	private final String HQL_LIST_ALL;
	private final String HQL_COUNT_ALL;

//	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 构造函数
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// 获取泛型的实际类型
		this.entityClass = (Class<M>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		HQL_LIST_ALL = "from " + this.entityClass.getSimpleName();
		HQL_COUNT_ALL = " select count(*) from " + this.entityClass.getSimpleName();
	}

	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public PK save(M po) throws DaoException {
		PK id = null;
		try {
			id = (PK)sessionFactory.getCurrentSession().save(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
		return id;
	}

	public void delete(M po) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}

	}

	public void delete(PK id) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(get(id));
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}

	}

	public void update(M po) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}

	}

	public void saveOrUpdate(M po) throws DaoException {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
	}

	public void merge(M po) throws DaoException {
		try {
			sessionFactory.getCurrentSession().merge(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
	}

	@SuppressWarnings("unchecked")
	public M get(PK id) throws DaoException {
		M po = null;
		try {
			po = (M)sessionFactory.getCurrentSession().get(entityClass,id);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
		return po;
	}

	public boolean exist(PK id) throws DaoException {
		boolean flag = false;
		try {
			M po = get(id);
			if(po!=null)
				flag = true;
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}

		return flag;
	}

	public int countAll() throws DaoException {
		Long total = null;
		try{
			Query query = sessionFactory.getCurrentSession().createQuery(HQL_COUNT_ALL);
			total = (Long) query.uniqueResult();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
		return total.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<M> listAll() throws DaoException {
		List<M> list = null;
		try{
			Query query = sessionFactory.getCurrentSession().createQuery(HQL_LIST_ALL);
			list = query.list();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
    public List<M> queryByPage(int pageSize,int pageNow,ConditionQuery conditionQuery,OrderBy orderBy) throws DaoException
    {
        List<M> list = null;
        try{
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(this.entityClass);
            conditionQuery.build(criteria);
            orderBy.build(criteria);
            criteria.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
            list=criteria.list();
        }catch (Exception e) {
            throw new DaoException(this.getClass(), e);
        }
        return list;
    }
	
	@SuppressWarnings("unchecked")
	public List<M> queryByPage(PageModel pageModel, ConditionQuery conditionQuery, OrderBy orderBy) throws DaoException {
		List<M> list = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(this.entityClass);
			final int pageSize = pageModel.getLimit();
			final int pageNow = pageModel.getCurrentPage();
			conditionQuery.build(criteria);
			orderBy.build(criteria);
			// 总记录数写入pageModel
			pageModel.setTotalProperty(criteria.list().size());
			criteria.setFirstResult((pageNow - 1) * pageSize).setMaxResults(pageSize);
			list = criteria.list();
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
		return list;
	}
    
	@SuppressWarnings("unchecked")
	public List<M> query(String hql) throws DaoException {
		List<M> list = null;
		try{
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<M> query(ConditionQuery conditionQuery, OrderBy orderBy)
			throws DaoException {
		List<M> list = null;
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(this.entityClass);
			conditionQuery.build(criteria);
			orderBy.build(criteria);
			list = criteria.list();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
		return list;
	}
	
	public List<?> query(Class<?> clazz, String sql, Map<String,Object> params) throws DaoException {
		List<?> list = null;
		try {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			if (params != null) {
				for (Iterator<String> it = params.keySet().iterator(); it.hasNext();) {
					String key = (String) it.next();
					if (params.get(key) instanceof String) {
						query.setString(key, (String) params.get(key));
					} else if (params.get(key) instanceof Long) {
						query.setLong(key, (Long) params.get(key));
					}
				}
			}
			if (clazz != null) {
				list = query.addEntity(clazz).list();
			}
			list = query.list();
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
		return list;
	}

	public void flush() throws DaoException {
		try{
			sessionFactory.getCurrentSession().flush();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}

	}

	public void clear() throws DaoException {
		try {
			sessionFactory.getCurrentSession().clear();
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e);
		}
	}
}
