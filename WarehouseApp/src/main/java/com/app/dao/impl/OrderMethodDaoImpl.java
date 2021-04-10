package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		return (Integer) ht.save(om);
	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		ht.update(om);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		ht.delete(new OrderMethod(id));
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getOrderIdAndCode(String mode) {
		String hql=" select id,orderCode "
				+" from com.app.model.OrderMethod "
				+" where orderMode=?0";
		
		return (List<Object[]>) ht.find(hql, mode);
	}

}


