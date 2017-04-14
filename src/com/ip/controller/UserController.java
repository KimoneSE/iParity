package com.ip.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ip.service.UserService;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register() {
        return "common/register";
    }
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
    @ResponseBody
    public ModelAndView postRegister(HttpServletRequest request) {
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordAgain = request.getParameter("passwordAgain");
		String username = request.getParameter("username");
        Map<String, Object> map = userService.register(phone, email, password, passwordAgain, username);
        HttpSession session = request.getSession();
        
        ModelAndView modelAndView = new ModelAndView("user/viewGoods");
        ModelAndView modelAndView1 = new ModelAndView("common/register");
        if ((boolean)map.get("success")) {
            session.setAttribute("id", map.get("user_id"));
            session.setAttribute("name", map.get("user_name"));
            session.setAttribute("role", 1);
            return modelAndView;
        }
        return modelAndView1;
    }
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "common/login";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
    @ResponseBody
    public ModelAndView postLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        Map<String, Object> map = userService.login(username, password);
        HttpSession session = request.getSession();
        
        ModelAndView modelAndView = new ModelAndView("user/viewGoods");
        ModelAndView modelAndView1 = new ModelAndView("admin/website");
        ModelAndView modelAndView2 = new ModelAndView("common/login");
        if ((boolean)map.get("success")) {
            session.setAttribute("id", map.get("user_id"));
            session.setAttribute("name", map.get("user_name"));
            if ((int)map.get("role")==1) {
            	session.setAttribute("role", 1);
            	return modelAndView;
			}
            else {
            	session.setAttribute("role", 0);
            	return modelAndView1;
			}
        }
        return modelAndView2;
    }
	
}
