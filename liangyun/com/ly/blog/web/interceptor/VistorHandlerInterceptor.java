package com.ly.blog.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ly.blog.dao.bean.impl.Vistor;
import com.ly.blog.service.VistorService;
import com.ly.blog.web.interceptor.util.UserUtil;

public class VistorHandlerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
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
			Vistor vistor = new Vistor();
			String addr = getIPAddr(request);
			String userAgent =request.getHeader("User-Agent");
			String url = request.getRequestURL().toString();
			vistor.setIp(addr);
			vistor.setUserAgent(userAgent);
			vistor.setDate(new Date());
			vistor.setUrl(url);
			VistorService.addVistor(vistor);
		}
		
	}
	
	private String getIPAddr(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");  
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("Proxy-Client-IP");  
	    }  
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
         }  
         if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
	}

}
