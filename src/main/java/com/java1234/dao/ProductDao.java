package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.News;
import com.java1234.entity.Product;
import com.java1234.entity.ProductSmallType;
import com.java1234.entity.Tag;

public interface ProductDao {
	
	public List<Product> findProductList(Map<String,Object> map);
	
	public Long getProductCountById(Map<String,Object> map);
	
	public List<Product> findProductListById(Map<String,Object> map);	
	
	public Long getProductCountByBigType(String bigTypeId);

	public List<Tag> findTagList(String bigTypeId);

	public List<ProductSmallType> findSmallTypeLByBigTypeID(Map<String, Object> map);

	public Long getProductCountBySmallType(String smallTypeId);

	public Product getProductById(String productId);
}
