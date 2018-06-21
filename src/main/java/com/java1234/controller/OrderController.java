package com.java1234.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.Order;
import com.java1234.entity.OrderProduct;
import com.java1234.entity.Product;
import com.java1234.entity.ShoppingCart;
import com.java1234.entity.ShoppingCartItem;
import com.java1234.entity.User;
import com.java1234.service.OrderService;
import com.java1234.util.DateUtil;
import com.java1234.util.NavUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;
	
	/**
	 * 点击结算，生成订单；清空购物车
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("buy")
	public ModelAndView buyGoods(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		ShoppingCart shoppingCart=(ShoppingCart) request.getSession().getAttribute("shoppingCart");
		//生成订单
		Order order=new Order();
		User currentUsre=(User)request.getSession().getAttribute("currentUser");
		order.setUserId(currentUsre.getId());
		order.setCreateTime(new Date());
		order.setOrderNo(DateUtil.getCurrentDateStr());
		order.setStatus(1);
		
		List<ShoppingCartItem> shoppingCartItemList=shoppingCart.getShoppingCartItems();
		
		float cost=0;
		List<OrderProduct> orderProductList=new LinkedList<OrderProduct>();
		for(ShoppingCartItem shoppingCartItem:shoppingCartItemList){
			Product product=shoppingCartItem.getProduct();
			OrderProduct orderProduct=new OrderProduct();
			orderProduct.setNum(shoppingCartItem.getCount());			
			orderProduct.setProduct(product);
			cost+=product.getPrice()*shoppingCartItem.getCount();
			orderProductList.add(orderProduct);
		}
		order.setCost(cost);
		
		 //保存订单信息
		orderService.saveOrder(order);   
		for(OrderProduct orderProduct:orderProductList){
			orderProduct.setOrderId(order.getId());
		}
		order.setOrderProductList(orderProductList);
		
		 //保存订单商品信息
		orderService.saveOrderProduct(orderProductList);
		
		//清空购物车
		shoppingCart.setShoppingCartItems(null);
		request.getSession().setAttribute("shoppingCart", shoppingCart);
		
		mav.addObject("mainPage","shopping/shopping-result.jsp");
		mav.addObject("navCode", NavUtil.genNavCode("购物",request));
		mav.setViewName("shoppingMain");
		return mav;
	}
	
	/**
	 * 根据订单编号查询订单
	 * @param orderNo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getOrderByOrderNo")
	public ModelAndView getOrderByOrderNo(String orderNo,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();	

		User user = (User) request.getSession().getAttribute("currentUser");
		int userId = user.getId();
		Map paramMap = new HashMap();
		paramMap.put("orderNo", orderNo);
		paramMap.put("userId", userId);
		//获取订单信息
		List<Order> orderList = orderService.getOrderByUserIdAndOrderNo(paramMap);
		mav.addObject("orderList", orderList);
		mav.addObject("mainPage", "userCenter/orderList.jsp");		
		mav.setViewName("userCenter");		
		return mav;
	}
	
	/**
	 * 更改订单状态通过订单编号
	 * @param orderNo
	 * @param status
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("updateStatusByOrderNo")
	public void updateStatusByOrderNo(String orderNo,int status,HttpServletRequest request,HttpServletResponse response) throws IOException{
		boolean result = false;
		Map paramMap = new HashMap();
		paramMap.put("status", status);
		paramMap.put("orderNo", orderNo);
		orderService.updateOrderStatus(paramMap);
		result = true;
		JSONObject json = new JSONObject();
		json.put("success", result);
		response.getWriter().write(json.toString());
	}
	
}
