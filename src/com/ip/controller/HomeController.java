package com.ip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ip.model.Product;
import com.ip.service.AdManageService;
import com.ip.service.ProductService;
import com.ip.service.SearchService;

@Controller
@RequestMapping("/*")
public class HomeController {
	@Autowired
	AdManageService adService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SearchService searchService;

	@RequestMapping("/Home")
    public ModelAndView show(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List adList = adService.getAllads();
		List<Product> pros = null;
		String sortRule = req.getParameter("sortRule");
		
		if(sortRule==null){
			pros = productService.getAllProducts();
		}else{
			String keywords = (String) req.getAttribute("keywords");
			pros = searchService.searchByArray(keywords, sortRule);
		}
		
		 ModelAndView mv = new ModelAndView();  
		req.setAttribute("ads", adList);
		req.setAttribute("products", pros);
	       mv.setViewName("user/Home");  
	       
	       return mv;  
    }
	
	@RequestMapping("/search")
    public ModelAndView search(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List adList = adService.getAllads();
		String keywords = req.getParameter("keywords");
		req.setAttribute("keywords", keywords);
		
		List<Product> pros = searchService.searchByArray(keywords, "reliability");
		 ModelAndView mv = new ModelAndView();  
		req.setAttribute("ads", adList);
		req.setAttribute("products", pros);
	       mv.setViewName("user/Home");  
	       
	       return mv;  
    }
}
