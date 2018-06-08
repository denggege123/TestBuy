package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.ProductBigTypeDao;
import com.java1234.entity.PageBean;
import com.java1234.entity.ProductBigType;
import com.java1234.service.ProductBigTypeService;

@Service("productBigTypeService")
public class ProductBigTypeServiceImpl implements ProductBigTypeService{

	@Resource
	private ProductBigTypeDao productBigTypeDao;
	
	public List<ProductBigType> findAllBigTypeList() {
		return productBigTypeDao.findAllBigTypeList();
	}

	public List<ProductBigType> findProductBigTypeList(ProductBigType s_productBigType, PageBean pageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getProductBigTypeCount(ProductBigType s_productBigType) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveProductBigType(ProductBigType productBigType) {
		// TODO Auto-generated method stub
		
	}

	public void delete(ProductBigType productBigType) {
		// TODO Auto-generated method stub
		
	}

	public ProductBigType getProductBigTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
