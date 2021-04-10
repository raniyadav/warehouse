package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodService {

	Integer saveOrderMethod(OrderMethod om);
	void updateOrderMethod(OrderMethod om);
	void deleteOrderMethod(Integer id);
	
	OrderMethod getOneOrderMethod(Integer id);
	List<OrderMethod> getAllOrderMethods();
	List<Object[]> getOrderIdAndCode(String mode);
}
