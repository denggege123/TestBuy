package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.News;
import com.java1234.entity.Product;

public interface ProductDao {
	
	public List<Product> findProductList(Map<String,Object> map);
	
	public Long getProductCount(Map<String,Object> map);
}
