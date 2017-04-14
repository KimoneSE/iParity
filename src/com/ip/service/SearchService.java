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
	
}
