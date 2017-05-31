package com.ly.blog.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ly.blog.dao.bean.impl.Article;
import com.ly.blog.service.BlogService;

@Controller
public class ViewController {

	@RequestMapping(value="/article/{id}")
	public ModelAndView viewAction(HttpServletRequest request, @PathVariable int id) throws Exception{
		
		ModelAndView model = new ModelAndView("viewMode");
		Article article = BlogService.getArticle(id);
		model.addObject("article", article);
		
		model.addObject("articleCount", BlogService.getPublicArticleCount());
		model.addObject("musicCount", 312);
		model.addObject("pictureCount", 5);
		
		return model;
	}
	
}
