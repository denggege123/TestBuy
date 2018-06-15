package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.ProductDao;
import com.java1234.entity.Product;
import com.java1234.entity.ProductSmallType;
import com.java1234.entity.Tag;
import com.java1234.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Resource
	private ProductDao productDao;
	
	public List<Product> findProductList(Map<String, Object> map) {
		return productDao.findProductList(map);
	}

	public Long getProductCountById(Map<String,Object> map){
		return productDao.getProductCountById(map);
	}

	public Product getProductById(String productId) {
		return productDao.getProductById(productId);
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
		return false;
	}

	public List<Tag> findTagList(String productId) {
		return productDao.findTagList(productId);
	}

	public List<Product> findProductListById(Map<String, Object> map) {
		return productDao.findProductListById(map);
	}

	public List<ProductSmallType> findSmallTypeLByBigTypeID(Map<String, Object> map) {
		return productDao.findSmallTypeLByBigTypeID(map);
	}

	public Long getProductCountBySmallType(String smallTypeId) {
		return productDao.getProductCountBySmallType(smallTypeId);
	}

	

}
