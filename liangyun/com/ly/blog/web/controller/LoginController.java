package com.ly.blog.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ly.blog.service.LoginService;

@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public ModelAndView redirect2LoginAction(HttpServletRequest request) throws Exception{
		
		ModelAndView model = new ModelAndView("login");
		return model;
		
	}
	
	@RequestMapping(value="/login/login.do")
	public void loginAction(HttpServletResponse response, HttpServletRequest request, 
			@RequestParam("username") String userName, @RequestParam("password") String password) throws Exception{
		
		if(LoginService.checkUserAndPassword(userName, password)){
			
			Cookie cookie = new Cookie("adminInfo", userName + "&" + password);
			cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			response.sendRedirect(request.getContextPath() + "/admin");
			//request.getRequestDispatcher("/admin").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
	}
	
	@RequestMapping(value="/login/logout.do")
	public void logoutAction(HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		Cookie cookie = new Cookie("adminInfo", null);
		cookie.setMaxAge(0);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		response.sendRedirect(request.getContextPath() + "/login");
	}
	
	
	
}
