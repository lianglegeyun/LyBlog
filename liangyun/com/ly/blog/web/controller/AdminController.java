package com.ly.blog.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ly.blog.dao.bean.impl.Article;
import com.ly.blog.dao.bean.impl.Vistor;
import com.ly.blog.service.BlogService;
import com.ly.blog.service.VistorService;
import com.ly.blog.web.util.JsonUtil;

@Controller
public class AdminController {
	
	private static final int VISTORPAGESIZE = 20;
	
	@RequestMapping(value="/admin")
	public ModelAndView adminAction(HttpServletRequest request) throws Exception{
		//
		ModelAndView model = new ModelAndView("admin");
		List<Article> articleList = BlogService.getAllArticles();
		model.addObject("articleList", articleList);
		
		//
		String pageStr = request.getParameter("page");
		int page = StringUtils.isEmpty(pageStr) ? 1 : Integer.valueOf(pageStr);
		List<Vistor> vistorList = VistorService.getPagingVistors(page, VISTORPAGESIZE);
		model.addObject("vistorList", vistorList);
		//
		int count = VistorService.getVistCount();
		List<Integer> pager = new ArrayList<Integer>();
		for(int i = 0; i < count / VISTORPAGESIZE; i++){
			pager.add(i + 1);
		}
		if( VISTORPAGESIZE * pager.size() < count){
			pager.add(pager.size() + 1);
		}
		model.addObject("pager", pager);
		
		//
		int yesterdayVistorCount = VistorService.getYesterdayVistorCount();
		model.addObject("yesterdayVistorCount", yesterdayVistorCount);
		
		return model;
	}
	
	@RequestMapping(value="/admin",params="method=edit")
	public ModelAndView editArticleAction(HttpServletRequest request){
		ModelAndView model = new ModelAndView("edit");
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Article article = BlogService.getArticle(Integer.valueOf(id));
			model.addObject("article", article);
		}
		return model;
	}
	
	@RequestMapping(value="/admin",params="method=backToArticleList")
	public ModelAndView backToArticleListAction(HttpServletRequest request){
		ModelAndView model = new ModelAndView("articleList");
		List<Article> articleList = BlogService.getAllArticles();
		model.addObject("articleList", articleList);
		return model;
	}
	
	@RequestMapping(value="/admin",params="method=save")
	public void saveAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String excerpt = request.getParameter("excerpt");
		String content = request.getParameter("content");
		String isPrivate = request.getParameter("isPrivate");
		
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setExcerpt(excerpt);
		article.setContent(content);
		article.setStatus( Boolean.valueOf(isPrivate) ? 0 : 1);
		article.setLastUpdateTime(new Date());
		
		if(StringUtils.isEmpty(id)){
			BlogService.addArticle(article);
		}else{
			BlogService.updateArticle(article);
		}
		JsonUtil.writeSuccessData(response, "\"id\":" + article.getId());
	}
	
	@RequestMapping(value="/admin",params="method=delete")
	public ModelAndView deleteAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			BlogService.deleteArticle(id);
			return backToArticleListAction(request);
		}else{
			throw new Exception("id is empty!");
		}
		
	}
	
	@RequestMapping(value="/admin",params="method=vistorPage")
	public ModelAndView vistorPageAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView model = new ModelAndView("systemInfo");
		int page = Integer.valueOf(request.getParameter("page"));
		List<Vistor> vistorList = VistorService.getPagingVistors(page, VISTORPAGESIZE);
		model.addObject("vistorList", vistorList);
		
		return model;
		
	}

}
