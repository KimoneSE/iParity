package com.ip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ip.model.Product;
import com.ip.model.User;
import com.ip.service.ProductService;
import com.ip.service.SearchService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public ModelAndView productDetail(HttpSession session){
		User user = (User)session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView("user/viewGoods");
		modelAndView.addObject("member",user);
		return modelAndView;
	}
	
	
	@RequestMapping(value="goodsDetail",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDetail(String name,String sort){
		
		Map<String, Object> map = new HashMap<String,Object>();
		List<Product> list = searchService.searchByArray(name, sort);
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="priceSort",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> priceSort(HttpSession session,String name){
		Map<String, Object> map = new HashMap<String,Object>();
		List<Product> list = searchService.searchByArray(name, "price:asc");
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="reSort",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> reSort(HttpSession session,String name){
		Map<String, Object> map = new HashMap<String,Object>();
		List<Product> list = searchService.searchByArray(name, "reliability:desc");
		map.put("list", list);
		return map;
	}
}
