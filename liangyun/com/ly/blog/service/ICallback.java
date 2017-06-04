package com.ly.blog.service;

import org.apache.ibatis.session.SqlSession;

public interface ICallback<T>{

	T doExecute(SqlSession session) throws Exception;
	
}
