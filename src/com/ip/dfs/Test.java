package com.ip.dfs;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ip.model.Product;
import com.ip.service.impl.SearchServiceImpl;

public class Test {
	public static void main(String[] args){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		SearchServiceImpl searchService =
				context.getBean(SearchServiceImpl.class);
		List<Product> products = searchService.searchByArray("key", "price");
		log(products);
	}
	
	public static void log(Object o) {
		System.out.println(o);
	}
}
