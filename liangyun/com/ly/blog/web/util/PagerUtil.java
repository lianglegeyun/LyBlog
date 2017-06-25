package com.ly.blog.web.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PagerUtil {

	public static List<String> getPager(int total, int pageSize, int pagerCount, int page){
		
		//
		List<Integer> allPages = new ArrayList<Integer>();
		for(int i = 0; i < total / pageSize; i++){
			allPages.add(i + 1);
		}
		if( pageSize * allPages.size() < total){
			allPages.add(allPages.size() + 1);
		}
		LinkedList<String> pager = new LinkedList<String>();
		int frontPage = page;
		int backPage = page;
		pager.push(String.valueOf(page));
		
		int displayPageCount =  pagerCount < allPages.size() ? pagerCount : allPages.size();
		while(pager.size() < displayPageCount){
			if(allPages.contains(--frontPage)){
				pager.push(String.valueOf(frontPage));
			}
			if(allPages.contains(++backPage)){
				pager.add(String.valueOf(backPage));
			}
		}
		if( !pager.peekFirst().equals("1")){
			pager.push("...");
		}
		if( Integer.valueOf(pager.peekLast()) < allPages.size()){
			pager.add("...");
		}
		
		return pager;
	}
	
}
