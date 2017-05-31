package com.ly.blog.web.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class JsonUtil {

	public static void writeSuccessData(HttpServletResponse response, String jsonStr) throws IOException{
		 //…Ë÷√“≥√Ê≤ªª∫¥Ê
        response.setContentType("application/json");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        StringBuilder json = new StringBuilder();
        json.append("{\"success\":" + true);
        if( ! StringUtils.isEmpty(jsonStr)){
        	json.append("," + jsonStr);
        }
        json.append("}");
        PrintWriter out= null;
        out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
	}
	
}
