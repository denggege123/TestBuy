package com.java1234.controller;


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

import com.java1234.entity.PageBean;
import com.java1234.entity.Product;
import com.java1234.entity.ProductSmallType;
import com.java1234.service.ProductService;
import com.java1234.util.NavUtil;
import com.java1234.util.PageUtil;
import com.java1234.util.StringUtil;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Resource
	private ProductService productService;
	
	private String pageCode;
	private String navCode;
	
	/**
	 * 选择大类后，获取该类下的商品信息；
	 * 获取该大类的子类列表
	 * @param productId
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(String page,String bigTypeId,String smallTypeId,String typeName,String productName,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
								
		
		Map<String,Object> map=new HashMap<String,Object>();
		StringBuffer param = new StringBuffer();
		
		//设置页面参数
		if(page == null || "".equals(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),10); 
		param.append("bigTypeId=").append(bigTypeId);
		
		map.put("bigTypeId", bigTypeId);		
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		if(StringUtil.isEmpty(productName)){
			productName="";
		}
		//判断小类ID是否有值，如果无值，说明大类查询商品ID，则需要查询小类列表
		if(StringUtil.isEmpty(smallTypeId)){
			smallTypeId = null;
		} else{
			param.append("&smallTypeId=").append(smallTypeId);
		}
		
		map.put("productName", productName);
		map.put("smallTypeId", smallTypeId);
		String prjName = request.getContextPath().substring(1);
		
		List<Product> productList=productService.findProductListById(map);	
		List<ProductSmallType> smallTypeList = productService.findSmallTypeLByBigTypeID(map);
		Long total=productService.getProductCountById(map);
		
		if(StringUtil.isEmpty(typeName)){
			typeName = "商品列表";
		}
		navCode=NavUtil.genNavCode(typeName);	
		pageCode=PageUtil.genPagination("Buy/product/list.do", total, pageBean.getPage(), pageBean.getPageSize(), param.toString());
		mav.addObject("smallTypeList", smallTypeList);
		mav.addObject("pageCode", pageCode);
		mav.addObject("navCode", navCode);
		mav.addObject("productList", productList);
		mav.addObject("mainPage", "product/productList.jsp");
		mav.setViewName("productMain");

		return mav;
	}
	/**
	 * 根据商品ID获取商品详细信息
	 * @param productId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getProductDetail")
	public ModelAndView getProductDetail(String productId,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		if(productId == null || "".equals(productId)){
			
		} else{
			Product product=productService.getProductById(productId);
			saveCurrentBrowse(request,product);
			mav.addObject("product", product);
			mav.addObject("mainPage", "product/productDetails.jsp");
		}
		mav.setViewName("productMain");
		return mav;
	}
	
	private void saveCurrentBrowse(HttpServletRequest request,Product product){
		List<Product> currentBrowseProduct=(List<Product>) request.getSession().getAttribute("currentBrowse");
		if(currentBrowseProduct==null){
			currentBrowseProduct=new LinkedList<Product>();
		}
		
		boolean flag=true;
		for(Product p:currentBrowseProduct){
			if(p.getId()==product.getId()){
				flag=false;
				break;
			}
		}
		
		if(flag){
			currentBrowseProduct.add(0,product);
		}
		
		if(currentBrowseProduct.size()==5){
			currentBrowseProduct.remove(4);
		}
		
		request.getSession().setAttribute("currentBrowse", currentBrowseProduct);
	}
	
	
	
}
