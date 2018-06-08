package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Product;

public interface ProductService {

	public List<Product> findProductList(Map<String,Object> map);
	
	public Long getProductCount(Map<String,Object> map);
	
	public Product getProductById(int productId);
	
	public void saveProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public void setProductWithHot(int productId);
	
	public void setProductWithSpecialPrice(int productId);
	
	public boolean existProductWithSmallTypeId(int smallTypeId);
	
}
