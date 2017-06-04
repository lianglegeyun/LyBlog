package com.ly.blog.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.ly.blog.dao.bean.impl.Vistor;

public class IPAddrUtil {

	@SuppressWarnings("unchecked")
	public static String getIPAddr(String ip){
		try{
			URL url = new URL( "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=" + ip);
			URLConnection conn = url.openConnection(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while((line = reader.readLine()) != null){
				result.append(line);
			}
			reader.close();
			Map<String, String> map = JSON.parseObject(result.toString(),Map.class);
			String country =  map.get("country");
			String province =  map.get("province");
			String city =  map.get("city");
			if(StringUtils.isEmpty(country) && StringUtils.isEmpty(province) && StringUtils.isEmpty(city)){
				return "æ÷”ÚÕ¯";
			}
			return country + province + city;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Map<String, String> getIPAddrMapping(List<Vistor> vistors){
		Map<String, String> map = new HashMap<String, String>();
		for(Vistor vistor : vistors){
			String ip = vistor.getIp();
			if( !map.containsKey(ip)){
				String addr = getIPAddr(ip);
				map.put(ip, addr);
			}
		}
		return map;
	}
	
}
