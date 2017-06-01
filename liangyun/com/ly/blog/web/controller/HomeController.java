package com.ly.blog.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ly.blog.dao.bean.impl.Article;
import com.ly.blog.service.BlogService;

@Controller
public class HomeController {
	
	private static final int PAGESIZE = 6;

	@RequestMapping(value="/")
	public ModelAndView homeAction(HttpServletRequest request) throws Exception{
		
		ModelAndView model = new ModelAndView("home");
		
		String pageStr = request.getParameter("page");
		int page = StringUtils.isEmpty(pageStr) ? 1 : Integer.valueOf(pageStr);
		
		List<Article> articleList = BlogService.getPagingArticles(PAGESIZE, page);
		model.addObject("articleList", articleList);
		
		int count = BlogService.getPublicArticleCount();
		List<Integer> pager = new ArrayList<Integer>();
		for(int i = 0; i < count / PAGESIZE; i++){
			pager.add(i + 1);
		}
		if( PAGESIZE * pager.size() < count){
			pager.add(pager.size() + 1);
		}
		model.addObject("pager", pager);
		
		model.addObject("articleCount", count);
		model.addObject("musicCount", 0);
		model.addObject("pictureCount", 0);
		return model;
	}
	
	@RequestMapping(value="/",params="method=mainDiv")
	public ModelAndView mainDivAction(HttpServletRequest request) throws Exception{
		
		ModelAndView model = new ModelAndView("mainDiv");
		
		String pageStr = request.getParameter("page");
		int page = StringUtils.isEmpty(pageStr) ? 1 : Integer.valueOf(pageStr);
		
		List<Article> articleList = BlogService.getPagingArticles(PAGESIZE, page);
		model.addObject("articleList", articleList);
		
		List<Integer> pager = new ArrayList<Integer>();
		for(int i = 0; i < articleList.size() / PAGESIZE + 1; i++){
			pager.add(i + 1);
		}
		model.addObject("pager", pager);
		
		return model;
	}
	
	@RequestMapping(value="/",params="method=view")
	public ModelAndView viewAction(HttpServletRequest request) throws Exception{
		
		ModelAndView model = new ModelAndView("viewArticle");
		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			throw new Exception("id is empty");
		}
		Article article = BlogService.getArticle(Integer.valueOf(id));
		model.addObject("article", article);
		return model;
	}
	
}
