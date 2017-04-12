package com.ip.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.ip.dao.UserDao;
import com.ip.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public User createUser(String username, String password,String phone,String email) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = new User();		
		user.setName(username);
		user.setPassword(password);
		user.setTelephone(phone);
		user.setEmail(email);
		user.setRole(1);
		
		session.save(user);
		session.flush();
		
		return user;
	}
	
	public User createAdmin(String adminname, String password) {
		Session session = sessionFactory.getCurrentSession();
		
		User admin = new User();		
		admin.setName(adminname);
		admin.setPassword(password);
		admin.setTelephone(null);
		admin.setEmail(null);
		admin.setRole(0);
		
		session.save(admin);
		session.flush();
		
		return admin;
	}
	
	public User findByName(String username) {
		Session session = sessionFactory.getCurrentSession();
		
        Query query = session.createQuery("from User where name=username");
        if (query.list() == null || query.list().size() == 0) {
            return null;
        } else {
            return (User)query.list().get(0);
        }
	}
	
	public void delete(String username) {
		Session session = sessionFactory.getCurrentSession();
		
        Query query = session.createQuery("delete User where name=:username");
        query.executeUpdate();		
	}
	
}
