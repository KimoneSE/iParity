package com.ip.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ip.dao.CommentDao;
import com.ip.model.Comment;
import com.ip.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public Map<String, Object> submit(int uid, String pname, String content) {
		Map<String, Object> map = new HashMap<>();
		Comment comment = commentDao.addComment(uid, pname, content);
		boolean isSen = commentDao.isSensitive(comment.getId());
		map.put("success1", isSen);
		boolean isWA = commentDao.isWaterArmy(uid);
		map.put("success2", isWA);
		return map;
	}

	@Override
	public List<Comment> getAll(String pname) {
		
		return commentDao.getAll(pname);
	}

	@Override
	public void delete(int id) {
		commentDao.deleteComment(id);

	}

}
