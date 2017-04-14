package com.ip.dao;

import java.util.List;

import com.ip.model.Ad;

public interface AdDao {
	
	public List getAll();
	
	public Ad get(int id);
	
	public void modify(Ad ad);
	
	public void add(Ad ad);
	
	public void delete(int id);
	
	public void delete(Ad ad);

}
