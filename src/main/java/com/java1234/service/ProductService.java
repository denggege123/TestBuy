package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Product;
import com.java1234.entity.ProductSmallType;
import com.java1234.entity.Tag;

public interface ProductService {

	public List<Product> findProductList(Map<String,Object> map);
	
	public Long getProductCountById(Map<String,Object> map);
	
	public Product getProductById(String productId);
	
	public void saveProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public void setProductWithHot(int productId);
	
	public void setProductWithSpecialPrice(int productId);
	
	public boolean existProductWithSmallTypeId(int smallTypeId);

	/**
	 * 通过大类获取首页标签列表
	 * */
	public List<Tag> findTagList(String bigTypeId);
	/**
	 * 通过商品信息
	 * */
	public List<Product> findProductListById(Map<String, Object> map);
	/**
	 * 通过大类ID获取该大类的商品信息
	 * */
	public List<ProductSmallType> findSmallTypeLByBigTypeID(Map<String, Object> map) ;
	/**
	 * 通过子类获取该子类的商品数量
	 * */
	public Long getProductCountBySmallType(String smallTypeId);
	
}
