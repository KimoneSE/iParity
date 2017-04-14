package com.ip.logic.dedup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ip.logic.comp.ProductComp;
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
			List<Product> products = map.get(p.getTypeName());
			if(products==null) {
				products = new ArrayList<Product>();
				products.add(p);
				map.put(p.getTypeName(), products);
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
		Product product = new Product();
		if(products.size()==0)
			return null;
		product = products.get(0);
		
		double price = 0;
		int volumn = 0;
		int count = 0;
		for(Product p : products) {
			try{
				double pPrice = Double.parseDouble(ProductComp.extractNumric( p.getPrice()));
				int pvolumn = p.getVolumn();
				
				price+=pPrice;
				volumn+=pvolumn;
				count++;
			}catch(Exception e) {
			}
		}
		if(count!=0) {
			product.setPrice(price/count+"");
			product.setVolumn(volumn);
		}
		return product;
	}
}
