package org.ssh.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.ssh.common.ConditionQuery;
import org.ssh.common.OrderBy;
import org.ssh.common.PageModel;
import org.ssh.common.entity.BasePojo;
import org.ssh.common.exception.DaoException;

/**
* @Package : org.ssh.common.dao
* @FileName : IBaseDao
* @Description : 
* @Author : YJ
* @Date : 2015年12月31日 下午12:28:33
*/
public interface IBaseDao <M extends BasePojo,PK extends Serializable> {
	
	/**
	 * 获取当前seesion
	 * 
	 * @return
	 */
	public Session getSession();
	
	/**
	 * 持久化一个对象A
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public PK save(M po) throws DaoException;

	/**
	 * 移除一个持久化对象A
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void delete(M po) throws DaoException;

	/**
	 * 移除一个持久化对象A
	 * 
	 * @param id
	 * @throws DaoException
	 */
	public void delete(PK id) throws DaoException;

	/**
	 * 使用update的时候，执行完成后，我们提供的对象A的状态变成持久化状态
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void update(M po) throws DaoException;

	/**
	 * 使用saveOrUpdate时，对象A不存在时，持久化A，存在时，修改对象属性持久化。
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void saveOrUpdate(M po) throws DaoException;

	/**
	 * 使用merge的时候，执行完成，我们提供的对象A还是脱管状态，
	 * hibernate或者new了一个B，或者检索到 一个持久对象B，
	 * 并把我们提供的对象A的所有的值拷贝到这个B，执行完成后B是持久状态，
	 * 而我们提供的A还是托管状态。
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void merge(M po) throws DaoException;

	/**
	 * 返回给定ID的实体
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public M get(PK id) throws DaoException;

	/**
	 * 判断实体是否存在
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean exist(PK id) throws DaoException;

	/**
	 * 获取某个实体的所有数量
	 * 
	 * @return
	 * @throws DaoException
	 */
	public int countAll() throws DaoException;
	
	/**
	 * 获取某个实体的所有数据
	 * 
	 * @param clz
	 * @return
	 * @throws DaoException
	 */
	public List<M> listAll() throws DaoException;

    /**
     * 根据条件分页查询
     * 
     * @param pageSize
     * @param pageNow
     * @param conditionQuery eg:Restrictions.like("name", "yinjie");Example.create(user)
     * @param orderBy eg:Order.asc("id")
     * @return
     * @throws DaoException
     */
	public List<M> queryByPage(int pageSize,int pageNow,ConditionQuery conditionQuery,OrderBy orderBy) throws DaoException;	
	
	/**
	* 根据条件分页查询(总记录数返回至PageModel)
	* 
	* @param pageModel
	* @param conditionQuery
	* @param orderBy
	* @return 
	* @throws DaoException 
	*/
	public List<M> queryByPage(PageModel pageModel,ConditionQuery conditionQuery,OrderBy orderBy) throws DaoException;	
	
	/**
	 * 通过hql语句条件查询
	 * 
	 * @param hql
	 * @return
	 * @throws DaoException
	 */
	public List<M> query(String hql) throws DaoException;

	/**
	 * 通过Criteria对象条件查询
	 * 
	 * @param conditionQuery
	 * @param orderBy
	 * @return
	 * @throws DaoException
	 */
	public List<M> query(ConditionQuery conditionQuery,OrderBy orderBy) throws DaoException;
	
	/**
	* 通过sql语句条件查询
	* 
	* @Description ：
	* @param sql
	* @param params
	* @return
	* @throws Exception 
	*/
	public List<?> query(Class<?> clazz, String sql, Map<String,Object> params) throws DaoException;
	
	/**
	 * @see org.hibernate.Session.flush()
	 * @throws DaoException
	 */
	public void flush() throws DaoException;

	/**
	 * @see org.hibernate.Session.clear()
	 * @throws DaoException
	 */
	public void clear() throws DaoException;
}

