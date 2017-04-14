package com.ip.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.dao.WebsiteDao;
import com.ip.model.ShoppingWebsite;
import com.ip.service.WebsiteService;

@Service
@Transactional
public class WebsiteServiceImpl implements WebsiteService{

	@Autowired
	private WebsiteDao websiteDao;
	
	@Override
	public Map<String, Object> createWebsite(String name, String url) {
		Map<String, Object> map = new HashMap<String, Object>();
		name = name.trim();
		url = url.trim();
		if(name.length()==0||url.length()==0){
			map.put("success", false);
			map.put("tip", "请输入完整信息");
		}else {
			ShoppingWebsite shoppingWebsite = websiteDao.createWebsite(name, url);
			map.put("success", true);
		}
		return map;
	}

	@Override
	public Map<String, Object> delWebsite(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		ShoppingWebsite shoppingWebsite = websiteDao.delWebsite(id);
		if(shoppingWebsite==null){
			map.put("success", false);
			map.put("tip", "不存在");
		}else {
			map.put("success", true);
		}
		return map;
	}

	@Override
	public Map<String, Object> updateWebsite(int id,String name,String url) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		name = name.trim();
		url = url.trim();
		
		if(name.length()==0||url.length()==0){
			map.put("success", false);
			map.put("tip", "请输入完整信息");
		}else {
			ShoppingWebsite shoppingWebsite = websiteDao.getByID(id);
			shoppingWebsite.setName(name);
			shoppingWebsite.setUrl(url);
			websiteDao.updateWebsite(shoppingWebsite);
			map.put("success", true);
		}
		
		return map;
	}

	@Override
	public List<ShoppingWebsite> getAllWebsite() {
		return websiteDao.getAllWebsites();
	}
	
}
