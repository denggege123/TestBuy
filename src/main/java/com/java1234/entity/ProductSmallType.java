package com.java1234.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * 商品小类实体类
 * @author yuyang
 *
 */
public class ProductSmallType {

	private int id;
	private String name;
	private String remarks;
	
	private String bigTypeId;
	private List<Product> productList=new ArrayList<Product>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getBigTypeId() {
		return bigTypeId;
	}
	public void setBigTypeId(String bigTypeId) {
		this.bigTypeId = bigTypeId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
}
