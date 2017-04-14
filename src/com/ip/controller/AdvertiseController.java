package com.ip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ip.model.Ad;
import com.ip.service.AdManageService;

@Controller
@RequestMapping(value="/admin/*")
public class AdvertiseController {

	@Autowired
	private AdManageService adManageService;
	
	@RequestMapping(value="ad",method=RequestMethod.GET)
	public ModelAndView manageWebsite(){
		ModelAndView modelAndView = new ModelAndView("admin/advertise");
		
		return modelAndView;
	}
	
	@RequestMapping(value="getAd",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAd(){
		Map<String, Object> map = new HashMap<String, Object>();
		List list =  adManageService.getAllads();

		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="delAd",method=RequestMethod.GET)
	public ModelAndView delAd(int id){
		adManageService.deleteAd(id);
		ModelAndView modelAndView = new ModelAndView("admin/advertise");
		
		return modelAndView;
	}
	
	@RequestMapping(value="modifyAd",method=RequestMethod.GET)
	public ModelAndView ad(int id){
		
		ModelAndView modelAndView = new ModelAndView("admin/modAdvertise");
		Ad ad = adManageService.getAdById(id);
		modelAndView.addObject("ad",ad);
		return modelAndView;
	}
	
	@RequestMapping(value="modAd",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modAd(String idS,String imgurl,String linkurl,String content){
		Map<String, Object> map = new HashMap<String, Object>();
		int id = Integer.parseInt(idS);
		Ad ad=new Ad(id, imgurl, content, linkurl);
		adManageService.modifyAd(ad);
		map.put("success", true);
		return map;
	}
	
}
