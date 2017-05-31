package com.ly.blog.dao.bean.impl;

public class Comment extends AbstractContent{

	private String ip;
	private Article atricle;
	private String content;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Article getAtricle() {
		return atricle;
	}
	public void setAtricle(Article atricle) {
		this.atricle = atricle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
