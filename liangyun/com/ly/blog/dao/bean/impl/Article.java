package com.ly.blog.dao.bean.impl;

public class Article extends AbstractContent{
	
	private String author;
	private String content;
	private int viewedCount;
	private String url;
	private String title;
	private String excerpt;
	private int sn;
	private int status;    //0-private;1-public;2-
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExcerpt() {
		return excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewedCount() {
		return viewedCount;
	}
	public void setViewedCount(int viewedCount) {
		this.viewedCount = viewedCount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
