package com.ly.blog.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ly.blog.service.BlogService;
import com.ly.blog.web.interceptor.util.UserUtil;

public class ViewArticleHandlerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if( !UserUtil.CheckIsLogined(request)){
			String[] pathArr = request.getRequestURI().split("/");
			int articleId = Integer.valueOf(pathArr[pathArr.length - 1]);
			BlogService.addViewedCount(articleId);
		}
		
	}

}
