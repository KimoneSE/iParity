package com.ip.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.dao.ProductDao;
import com.ip.logic.comp.MatchComp;
import com.ip.logic.comp.PriceComp;
import com.ip.logic.comp.ValueComp;
import com.ip.logic.comp.VolumnComp;
import com.ip.logic.dedup.DeDuplicate;
import com.ip.model.Product;
import com.ip.service.SearchService;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

	
	
	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public List<Product> searchByArray(List<String> keys, List<String> orders) {
		List<Product> products = productDao.getGeneralInfoByLikeName(keys);
		System.out.println(products);
		/**
		 * 去重
		 */
		products = DeDuplicate.deDup(products);
		System.out.println(products);

		/**
		 * 按序排序
		 */
		for(String order:orders) {
			switch (order) {
			/**
			 * volume
			 */
			case "volume":
				products.sort(new VolumnComp());
				break;
			case "volume:asc":
				products.sort(new VolumnComp(true));
				break;
			case "volume:desc":
				products.sort(new VolumnComp(false));
				break;
			
				/**
				 * reliability
				 */
			case "reliability":
				products.sort(new ValueComp());
				break;
			case "reliability:asc":
				products.sort(new ValueComp(true));
				break;
			case "reliability:desc":
				products.sort(new ValueComp(false));
				break;
			

				/**
				 * price
				 */
			case "price":
				products.sort(new PriceComp());
				break;
			case "price:asc":
				products.sort(new PriceComp(true));
				break;
			case "price:desc":
				products.sort(new PriceComp(false));
				break;
				
				/**
				 * match
				 */
			case "match":
				products.sort(new MatchComp(keys));
				break;
				
			default:
				break;
			}
		}
		return products;
	}

	public List<Product> searchByArray(String keyString, List<String> orders) {
		
		String[] keys = keyString.split(" ");
		return searchByArray(Arrays.asList(keys), orders);
	}
	
	public List<Product> searchByArray(String keyString, String ordersString) {
		
		String[] keys = keyString.split(" ");
		String[] orders = ordersString.split(" "); 
		return searchByArray(Arrays.asList(keys), Arrays.asList(orders));
	}
	
}
