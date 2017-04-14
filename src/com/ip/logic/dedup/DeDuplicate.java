package com.ip.logic.dedup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ip.model.Product;

public class DeDuplicate {
	
	/**
	 * 去重函数
	 * @param pro
	 * @return
	 */
	public static List<Product>  deDup(List<Product> pro) {
		
		HashMap<String, List<Product>> map = new HashMap<String, List<Product>>(pro.size()/2);
		for(Product p:pro){
			List<Product> products = map.get(p.getProduct());
			if(products==null) {
				products = new ArrayList<Product>();
				products.add(p);
				map.put(p.getProduct(), products);
			}else {
				products.add(p);
			}
		}
		return convertMapToArray(map);
	}
	
	private static List<Product> convertMapToArray(Map<String,List<Product>> map) {
		List<Product> result = new ArrayList<Product>(map.size());
		for(Map.Entry<String,List<Product>> entry : map.entrySet() ) {
			result.add(reduce(entry.getValue())); 
		}
		return result;
	}
	
	private static Product reduce(List<Product> products) {
		return null;
	}
}
