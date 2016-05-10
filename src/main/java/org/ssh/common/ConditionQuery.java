package org.ssh.common;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import java.util.ArrayList;
import java.util.List;

/**
* @Package : org.ssh.common
* @FileName : ConditionQuery
* @Description : 
* @Author : YJ
* @Date : 2015年12月31日 下午12:27:50
*/
public class ConditionQuery {

	private List<Criterion> criterions = new ArrayList<Criterion>();

	/*
	 * the original eg:
	 * Criteria cr = session.createCriteria(Student.class);
	 * cr.add(Restrictions.like("name", "t%”))
	 * cr.add(Restrictions.gt("age", "10"))
	 * cr.addOrder(Order.asc("name"));
	 * List list = cr.list();
	 * Student stu = (Student)list.get(0);
	 * 
	 * how to use this class ConditionQuery or OrderBy?
	 * 
	 * Criteria cr = session.createCriteria(Student.class);
	 * ConditionQuery cq = new ConditionQuery();
	 * OrderBy ob = new OrderBy();
	 * cq.add(Restrictions.like("name", "t%”));
	 * cq.add(Restrictions.gt("age", "10"));
	 * cq.build(cr);
	 * ob.addOrder(Order.asc("name"));
	 * ob.build(cr);
	 * 
	 */
	public void add(Criterion criterion) {
		if(criterion!=null)
		{
			criterions.add(criterion);
		}
	}

	public void build(Criteria criteria) {
		if(criteria!=null){
			for(Criterion criterion : criterions) {
				criteria.add(criterion);
			}
		}
	}

}
