package com.ip.service;

import java.util.List;

import com.ip.model.Product;

public interface SearchService {

	/**
	 * 根据keys查找匹配的product， 然后根据orders按照优先级排序
	 * @param keys
	 * @param orders：volume reliability price
	 * @return
	 */
	public List<Product> searchByArray(List<String> keys, List<String> orders) ;
	
	/**
	 * keyString 使用空格分割
	 * @param keyString
	 * @param orders volume reliability price
	 * @return
	 */
	public List<Product> searchByArray(String keyString, List<String> orders);
	
	/**
	 * 
	 * @param keyString 使用空格分割关键字
	 * @param ordersString使用空格分割排序标记 volume reliability price
	 * @return
	 */
	public List<Product> searchByArray(String keyString, String ordersString);
}
