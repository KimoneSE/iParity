package com.ip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.logic.dedup.DeDuplicate;
import com.ip.model.Product;
import com.ip.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductService productService;
	
	@Override
	public List<Product> getAllProducts() {
		return DeDuplicate.deDup(productService.getAllProducts());
	}

}
