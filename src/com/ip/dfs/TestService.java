package com.ip.dfs;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ip.model.Product;
import com.ip.service.SearchService;

public class TestService {
	public static void main(String[] args){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		SearchService searchService =
				context.getBean(SearchService.class);
		List<Product> products = searchService.searchByArray("key java", "price volume");
		log("=========products========");
		log(products);
		for(Product p:products) {
			log(p.getProduct() +" "+ p.getPrice());
		}
	}
	
	public static void log(Object o) {
		System.out.println(o);
	}
}
