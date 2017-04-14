package com.ip.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ip.dao.AdDao;
import com.ip.model.Ad;

@Repository
public class AdDaoImpl implements AdDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		List list = null;
		Session session = sessionFactory.getCurrentSession();	
        Query query = session.createQuery("from Ad");
        list = query.list();
		return list;
	}

	@Override
	public Ad get(int id) {
		// TODO Auto-generated method stub
		Ad ad = null;
		
		Session session = sessionFactory.getCurrentSession();	
        Query query = session.createQuery("from Ad where id="+id);
        List list = query.list();
        if(list!=null&&(list.size()>0)){
        	ad = (Ad) list.get(0);
        }
		return ad;
	}

	@Override
	public void modify(Ad ad) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.update(ad);
	}

	@Override
	public void add(Ad ad) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.save(ad);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		 Query query = session.createQuery("delete Ad where id="+id);
		 query.executeUpdate();		
	}

	@Override
	public void delete(Ad ad) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		session.delete(ad);
	}

}
