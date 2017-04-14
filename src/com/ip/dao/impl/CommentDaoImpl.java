package com.ip.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ip.dao.CommentDao;
import com.ip.model.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Comment addComment(int uid, String pname, String content) {
		Session session = sessionFactory.getCurrentSession();
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setDatetime(new Date(System.currentTimeMillis()));
		comment.setPname(pname);
		comment.setUid(uid);
		comment.setIsSensitive((byte)2);
		session.save(comment);
		session.flush();
		return comment;
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public boolean isSensitive(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<String> list = getSensitiveList();
		Query query = session.createQuery("from Comment where id=:id");
		query.setInteger("id", id);
		Comment comment = (Comment)query.list().get(0);
		session.flush();
		String content = comment.getContent();
		for (int i = 0; i < list.size(); i++) {
			if (content.indexOf(list.get(i))!=-1) {
				Query query2 = session.createQuery("update Comment set isSensitive=1 where id=:id");
				query.setInteger("id", id);
				query2.executeUpdate();
				return true;				
			}
		}
		Query query3 = session.createQuery("update Comment set isSensitive=0 where id=:id");
		query.setInteger("id", id);
		query3.executeUpdate();		
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<String> getSensitiveList(){
		Session session = sessionFactory.getCurrentSession();
		List<String> list = new ArrayList<>();
		Query query = session.createQuery("select word from SensitiveDirectory");
		list = query.list();
		return list;
	}
	
	@Override
	public boolean isWaterArmy(int uid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public void deleteComment(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Comment where id=:id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public List<Comment> getAll(String pname) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Comment where pname=:pname and isSensitive=0");
		query.setString("pname", pname);
		List<Comment> list = query.list();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Comment> getSen() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Comment where isSensitive=1");
		
		List<Comment> list = query.list();
		return list;
	}

	@Override
	public void update(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.update(comment);
		session.flush();
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public Comment findByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Comment where where id=:id");
		query.setInteger("id", id);
		Comment comment = (Comment)query.list().get(0);
		return comment;
	}

}
