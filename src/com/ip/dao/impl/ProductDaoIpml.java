package com.ip.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.ip.dao.ProductDao;
import com.ip.model.Product;

public class ProductDaoIpml implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		session.flush();
	}

	@Override
	public List<Product> getGeneralInfo() {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product");
		return query.list();
				
	}

	@Override
	public Product getGeneralInfo(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product where id=:id");
		query.setParameter("id", id);
		query.setMaxResults(1);
		return query.uniqueResult();
	}
	
	@Override
	public List<Product> getGeneralInfoByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product where product=:name");
		query.setParameter("name", name);
		return query.list();
	}
	
	public List<Product> getGeneralInfoByLikeName(List<String> names) {
		Session session = sessionFactory.getCurrentSession();
		if (names.size()>0) {
			StringBuilder hqlLike = new StringBuilder("like %"+names.get(0)+"%");
			for (int i=1; i<names.size(); i++) {
				hqlLike.append("OR like %" + names.get(i)+"%");
			}
			Query<Product> query = session.createQuery("from Product where product  "+hqlLike.toString());
			return query.list();
		}
		return this.getGeneralInfo();
	}

	@Override
	public Iterator<Product> getSellerList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
