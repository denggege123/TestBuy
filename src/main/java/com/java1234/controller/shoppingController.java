package com.java1234.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.Product;
import com.java1234.entity.ShoppingCart;
import com.java1234.entity.ShoppingCartItem;
import com.java1234.entity.User;
import com.java1234.service.ProductService;
import com.java1234.util.NavUtil;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/shopping")
public class shoppingController {
	
	@Resource
	private ProductService productService;
	
	/**
	 * ����Ʒ��ӵ����ﳵ��
	 * @param productId
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/addShoppingCartItem")
	public void addShoppingCartItem(String productId,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		Product product=productService.getProductById(productId);
		//��ȡԭ�ȵĹ��ﳵ��Ϣ
		ShoppingCart shoppingCart=(ShoppingCart) request.getSession().getAttribute("shoppingCart");
		if(shoppingCart==null){
			shoppingCart=new ShoppingCart();
			User currentUser=(User) request.getSession().getAttribute("currentUser");
			shoppingCart.setUserId(currentUser.getId());
		}
		//��ȡԭ�ȹ��ﳵ����Ʒ��Ϣ
		List<ShoppingCartItem> shoppingCartItemList=shoppingCart.getShoppingCartItems();
		
		boolean flag=true;
		for(ShoppingCartItem scI:shoppingCartItemList){
			//�ж�Ҫ��ӵ���Ʒ�Ƿ��ﳵ�Ѵ��ڣ�������ڣ�����+1,����������ڣ��������
			if(scI.getProduct().getId()==product.getId()){
				scI.setCount(scI.getCount()+1);
				flag=false;
				break;
			}
		}
		ShoppingCartItem shoppingCartItem=new ShoppingCartItem();
		if(flag){
			shoppingCartItem.setProduct(product);
			shoppingCartItem.setCount(1);
			shoppingCartItemList.add(shoppingCartItem);
		}
		request.getSession().setAttribute("shoppingCart", shoppingCart);
		
		JSONObject result=new JSONObject();
		result.put("success", true);
		response.getWriter().write(result.toString());
	}
	
	/**
	 * ���¹��ﳵ����Ʒ������Ϣ
	 * @param productId
	 * @param count
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/updateShoppingCartItem")
	public void updateShoppingCartItem(String productId,int count,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		Product product=productService.getProductById(productId);
		ShoppingCart shoppingCart=(ShoppingCart) request.getSession().getAttribute("shoppingCart");
		List<ShoppingCartItem> shoppingCartItemList=shoppingCart.getShoppingCartItems();
		for(ShoppingCartItem scI:shoppingCartItemList){
			if(scI.getProduct().getId()==product.getId()){
				scI.setCount(count);
				break;
			}
		}
		request.getSession().setAttribute("shoppingCart", shoppingCart);
		
		JSONObject result=new JSONObject();
		result.put("success", true);	
		response.getWriter().write(result.toString());
	}
	/**
	 * ����Ʒ�Ƴ����ﳵ
	 * @param productId
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/removeShoppingCartItem")
	public ModelAndView removeShoppingCartItem(String productId,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		Product product=productService.getProductById(productId);
		ShoppingCart shoppingCart=(ShoppingCart) request.getSession().getAttribute("shoppingCart");
		List<ShoppingCartItem> shoppingCartItemList=shoppingCart.getShoppingCartItems();
		
		for(int i=0;i<shoppingCartItemList.size();i++){
			if(shoppingCartItemList.get(i).getProduct().getId()==product.getId()){
				shoppingCartItemList.remove(i);
				break;
			}
		}
		shoppingCart.setShoppingCartItems(shoppingCartItemList);
		request.getSession().setAttribute("shoppingCart", shoppingCart);
		
		mav.addObject("mainPage","shopping/shopping.jsp");
		mav.addObject("navCode", NavUtil.genNavCode("���ﳵ",request));
		mav.setViewName("shoppingMain");
		return mav;
	}
	
	@RequestMapping("/getShopList")
	public ModelAndView  getShopList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.addObject("mainPage","shopping/shopping.jsp");
		mav.addObject("navCode", NavUtil.genNavCode("���ﳵ",request));
		mav.setViewName("shoppingMain");
		return mav;
	}
	
	@RequestMapping("/settleAccount")
	public ModelAndView  settleAccount(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		ShoppingCart shoppingCart=(ShoppingCart) request.getSession().getAttribute("shoppingCart");
		shoppingCart.setShoppingCartItems(null);
		request.getSession().setAttribute("shoppingCart", shoppingCart);
		
		mav.addObject("mainPage","shopping/shopping-result.jsp");
		mav.addObject("navCode", NavUtil.genNavCode("���ﳵ",request));
		mav.setViewName("shoppingMain");
		return mav;
	}
	

}
