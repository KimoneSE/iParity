package com.ip.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ip.dao.ProductDao;
import com.ip.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Iterator<Product> getGeneralInfo() {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Product where parent is null");
		session.close();
		if (query.list() == null || query.list().size() == 0) {
			return null;
		} else {
			List<Product> list = query.list();
			return list.iterator();
		}
	}

	@Override
	public Product getGeneralInfo(String id) {
		Session session = sessionFactory.openSession();

		Product product = session.find(Product.class, id);
		session.close();
		return product;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Iterator<Product> getSellerList(String id) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Product where parent='" + id + "'");
		session.close();
		if (query.list() == null || query.list().size() == 0) {
			return null;
		} else {
			List<Product> list = query.list();
			return list.iterator();
		}
	}

}
