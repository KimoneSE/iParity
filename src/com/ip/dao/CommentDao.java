package com.ip.dao;

import java.util.List;

import com.ip.model.Comment;


public interface CommentDao {

	public Comment addComment(int uid,String pname,String content);
	
	public boolean isSensitive(int id);
	
	public boolean isWaterArmy(int uid);
	
	public void deleteComment(int id);
	
	public List<Comment> getAll(String pname);
	
	public List<Comment> getSen();
	
	public void update(Comment comment);
	
	public Comment findByID(int id);
}
