package com.ip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ip.model.Comment;
import com.ip.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/comment",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllComment(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		String pname = (String)session.getAttribute("pname");
		List<Comment> list = commentService.getAll(pname);
		map.put("comments", list);
		return map;
	}
	
	@RequestMapping(value="/addComment",method=RequestMethod.POST)
	public Map<String, Object> addComment(HttpServletRequest request){
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		String pname = (String)session.getAttribute("pname");
		String content = request.getParameter("content");
		Map<String, Object> map = commentService.submit(uid, pname, content);
		return map;
	}
	
	@RequestMapping(value="/admin/comment",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getSenComment() {
		Map<String, Object> map = new HashMap<>();
		List<Comment> list = commentService.getSen();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="/admin/delComment",method=RequestMethod.GET)
	public void delete(int id){
		commentService.delete(id);
	}
	
	@RequestMapping(value="/admin/modComment",method=RequestMethod.GET)
	public ModelAndView modify(int id){
		ModelAndView modelAndView = new ModelAndView("admin/modComment");
		Comment comment = commentService.getByID(id);
		modelAndView.addObject("commentSen", comment);
		return modelAndView;
	}
	@RequestMapping(value="/admin/modify",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modComment(int id,String content){
		Map<String, Object> map = new HashMap<>();
		map = commentService.modify(id, content);
		return map;
	}
}
