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
	 * ͨ�������ȡ��ҳ��ǩ�б�
	 * */
	public List<Tag> findTagList(String bigTypeId);
	/**
	 * ͨ����Ʒ��Ϣ
	 * */
	public List<Product> findProductListById(Map<String, Object> map);
	/**
	 * ͨ������ID��ȡ�ô������Ʒ��Ϣ
	 * */
	public List<ProductSmallType> findSmallTypeLByBigTypeID(Map<String, Object> map) ;
	/**
	 * ͨ�������ȡ���������Ʒ����
	 * */
	public Long getProductCountBySmallType(String smallTypeId);
	
}
