package com.ip.dao;

import java.util.Iterator;
import java.util.List;

import com.ip.model.Product;

public interface ProductDao {

	public void saveProduct(Product product);
	
	/**
	 * 
	 * @return 返回概括信息（所有）
	 */	
	public List<Product> getGeneralInfo();
	
	/**
	 * 
	 * @param typeName 编号
	 * @return 某一个概括信息
	 */
	public Product getGeneralInfo(String id);
	
	/**
	 * 
	 * @param name produce name
	 * @return 信息概括
	 */
	public List<Product> getGeneralInfoByName(String name);
	
	/**
	 * 
	 * @param names produce name
	 * @return 信息概括列表
	 */
	public List<Product> getGeneralInfoByLikeName(List<String> names);
	
	/**
	 * 
	 * @param id 某一个概括信息id
	 * @return 某一个概括信息id下的所有商家详细商品信息
	 */
	public Iterator<Product> getSellerList(String id);
}
