package com.ip.dao;

import java.util.Iterator;

import com.ip.model.Product;

public interface ProductDao {

	public void saveProduct(Product product);
	
	/**
	 * 
	 * @return 返回概括信息（所有）
	 */	
	public Iterator<Product> getGeneralInfo();
	
	/**
	 * 
	 * @param typeName 编号
	 * @return 某一个概括信息
	 */
	public Product getGeneralInfo(String id);
	
	/**
	 * 
	 * @param id 某一个概括信息id
	 * @return 某一个概括信息id下的所有商家详细商品信息
	 */
	public Iterator<Product> getSellerList(String id);
}
