package com.ly.blog.web.interceptor.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.ly.blog.service.LoginService;

public class UserUtil {

	public static boolean CheckIsLogined(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			return false;
		}
		String userName = null, passWord = null;
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("adminInfo")){
				String adminInfo = cookie.getValue();
				if(adminInfo.indexOf("&") == -1){
					return false;
				}
				userName = adminInfo.split("&")[0];
				passWord = adminInfo.split("&")[1];
				break;
			}
		}
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
			return false;
		}else{
			if(LoginService.checkUserAndPassword(userName, passWord)){
				return true;
			}
			return false;	
		}
	}
	
}
