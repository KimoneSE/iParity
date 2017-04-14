package com.ip.service;

import java.util.List;
import java.util.Map;

import com.ip.model.ShoppingWebsite;

public interface WebsiteService {
	public Map<String, Object> createWebsite(String name,String url);
	public Map<String, Object> delWebsite(int id);
	public Map<String, Object> updateWebsite(int id,String name,String url);
	public List<ShoppingWebsite> getAllWebsite();
}
