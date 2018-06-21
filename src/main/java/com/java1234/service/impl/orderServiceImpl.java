package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.OrderDao;
import com.java1234.entity.Order;
import com.java1234.entity.PageBean;
import com.java1234.service.OrderService;

@Service("OrderService")
public class orderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;
	
	public void saveOrder(Order order) {
		 orderDao.saveOrder(order);		 
	}
	public void saveOrderProduct(List orderProductList){
		orderDao.saveOrderProduct(orderProductList);
	}
	
	public List<Order> getOrderByUserIdAndOrderNo(Map map) {
		return orderDao.getOrderByUserIdAndOrderNo(map);
	}
	

	public List<Order> findOrder(Order s_order, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getOrderCount(Order s_order) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateOrderStatus(Map map) {
		orderDao.updateOrderStatus(map);

	}

	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
