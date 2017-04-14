package com.ip.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ip.dao.WebsiteDao;
import com.ip.model.ShoppingWebsite;

@Repository
public class WebsiteDaoImpl implements WebsiteDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ShoppingWebsite createWebsite(String name, String url) {
		Session session = sessionFactory.getCurrentSession();
		ShoppingWebsite shoppingWebsite = new ShoppingWebsite();
		shoppingWebsite.setName(name);
		shoppingWebsite.setUrl(url);
		session.save(shoppingWebsite);
		session.flush();
		return shoppingWebsite;
	}

	@Override
	public ShoppingWebsite delWebsite(int id) {
		Session session = sessionFactory.getCurrentSession();
		ShoppingWebsite shoppingWebsite = this.getByID(id);
		if(shoppingWebsite!=null)
			session.delete(shoppingWebsite);
		return shoppingWebsite;
	}

	@Override
	@Transactional
	public ShoppingWebsite updateWebsite(ShoppingWebsite shoppingWebsite) {
		Session session = sessionFactory.getCurrentSession();
		session.update(shoppingWebsite);
		session.flush();
		return shoppingWebsite;
	}

	@Override
	public List<ShoppingWebsite> getAllWebsites() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ShoppingWebsite"); 
		List<ShoppingWebsite> list = (List<ShoppingWebsite>)query.list();
		return list;
	}

	@Override
	public ShoppingWebsite getByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ShoppingWebsite where id='"+id+"'");
		if(query.list()==null||query.list().size() == 0){
			return null;
		}else{
			return (ShoppingWebsite)query.list().get(0);
		}
	}
	
	
}
