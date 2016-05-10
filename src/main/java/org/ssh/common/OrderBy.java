package org.ssh.common;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
* @Package : org.ssh.common
* @FileName : OrderBy
* @Description : 
* @Author : YJ
* @Date : 2015年12月31日 下午12:28:06
*/
public class OrderBy {

	private List<Order> orders = new ArrayList<Order>();

	public void add(Order order) {
		if(order!=null){
			orders.add(order);
		}
	}

	public void build(Criteria criteria) {
		if(criteria!=null){
			for(Order order : orders) {
				criteria.addOrder(order);
			}
		}
	}
}

