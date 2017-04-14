package com.ip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ip.model.Comment;
import com.ip.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/comment",method=RequestMethod.GET)
	public ModelAndView getAllComment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String pname = (String)session.getAttribute("pname");
		List<Comment> list = commentService.getAll(pname);
		ModelAndView modelAndView = new ModelAndView("user/comment");
		modelAndView.addObject("comments", list);
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/comment",method=RequestMethod.GET)
	public ModelAndView getSenComment() {
		ModelAndView modelAndView = new ModelAndView("user/comment");
		return modelAndView;
	}
}
