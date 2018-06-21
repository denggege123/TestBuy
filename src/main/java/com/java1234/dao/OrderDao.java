package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Order;
import com.java1234.entity.OrderProduct;

public interface OrderDao {

	public void saveOrder(Order order);
	
	public void saveOrderProduct(List orderProductList);
	
	public List<Order> getOrders();
	
	
	public List<OrderProduct> getOrderProductByOrderId(int orderId);

	public List<Order> getOrderByUserIdAndOrderNo(Map map);

	public void updateOrderStatus(Map map);

}
