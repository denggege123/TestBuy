package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.ProductDao;
import com.java1234.entity.Product;
import com.java1234.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Resource
	private ProductDao productDao;
	
	public List<Product> findProductList(Map<String, Object> map) {
		return productDao.findProductList(map);
	}

	public Long getProductCount(Map<String,Object> map) {
		return productDao.getProductCount(map);
	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	public void setProductWithHot(int productId) {
		// TODO Auto-generated method stub
		
	}

	public void setProductWithSpecialPrice(int productId) {
		// TODO Auto-generated method stub
		
	}

	public boolean existProductWithSmallTypeId(int smallTypeId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
