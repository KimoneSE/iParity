package com.ip.dao;

import java.util.List;

import com.ip.model.ShoppingWebsite;

public interface WebsiteDao {
	public ShoppingWebsite createWebsite(String name,String url);
	public ShoppingWebsite delWebsite(int id);
	public ShoppingWebsite updateWebsite(ShoppingWebsite shoppingWebsite);
	public List<ShoppingWebsite> getAllWebsites();
	public ShoppingWebsite getByID(int id);
}
