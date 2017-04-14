package com.ip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ip.model.ShoppingWebsite;
import com.ip.service.WebsiteService;


@Controller
@RequestMapping(value="/admin/*")
public class WebsiteController {
	
	@Autowired
	private WebsiteService websiteService;
	
	@RequestMapping(value="website",method=RequestMethod.GET)
	public ModelAndView manageWebsite(){
		ModelAndView modelAndView = new ModelAndView("admin/website");
		
		return modelAndView;
	}
	
	@RequestMapping(value="getWebsite",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getWebsite(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ShoppingWebsite> list =  websiteService.getAllWebsite();
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="delWebsite",method=RequestMethod.GET)
	public ModelAndView delWebsite(int id){
		websiteService.delWebsite(id);
		ModelAndView modelAndView = new ModelAndView("admin/website");
		
		return modelAndView;
	}
	
	@RequestMapping(value="modWebsite",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modifyHostel(int id,String name,String url){
		Map<String, Object> map = websiteService.updateWebsite(id, name, url);
//		System.out.println(map);
		return map;
	}
}
