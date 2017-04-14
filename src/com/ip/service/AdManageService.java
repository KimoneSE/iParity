package com.ip.service;

import java.util.List;

import com.ip.model.Ad;

public interface AdManageService {
	
	public List getAllads();
	
	public Ad getAdById(int id);
	
	public void addAd(Ad ad);
	
	public void deleteAd(int id);
	
	public void modifyAd(Ad ad);

}
