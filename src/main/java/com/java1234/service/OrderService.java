package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Order;
import com.java1234.entity.PageBean;

public interface OrderService {

	public void saveOrder(Order order);
	
	public void saveOrderProduct(List orderProductList);
	
	public List<Order> getOrderByUserIdAndOrderNo(Map map);
	
	public List<Order> findOrder(Order s_order,PageBean pageBean);
	
	public Long getOrderCount(Order s_order);
	
	public void updateOrderStatus(Map map);
	
	public Order getOrderById(int id);

}
