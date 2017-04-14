package com.ip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.dao.AdDao;
import com.ip.model.Ad;
import com.ip.service.AdManageService;

@Service
public class AdManageServiceImpl implements AdManageService{

	@Autowired
	private AdDao adDao;
	
	@Override
	public List getAllads() {
		// TODO Auto-generated method stub
		return adDao.getAll();
	}

	@Override
	public Ad getAdById(int id) {
		// TODO Auto-generated method stub
		return adDao.get(id);
	}

	@Override
	public void addAd(Ad ad) {
		// TODO Auto-generated method stub
		adDao.add(ad);
	}

	@Override
	public void deleteAd(int id) {
		// TODO Auto-generated method stub
		adDao.delete(id);
	}

	@Override
	public void modifyAd(Ad ad) {
		// TODO Auto-generated method stub
		adDao.modify(ad);
	}

}
