package com.ip.service;

import java.util.List;
import java.util.Map;

import com.ip.model.Comment;

public interface CommentService {

	public Map<String, Object> submit(int uid, String pname, String content);
	
	public List<Comment> getAll(String pname);
	
	public void delete(int id);
}
