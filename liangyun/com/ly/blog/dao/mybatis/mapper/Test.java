package com.ly.blog.dao.mybatis.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ly.blog.dao.bean.impl.Article;

public class Test {

public static void main(String[] args){
		
		try {
			String resource = "my-batis-config.xml";
			InputStream stream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			SqlSession session = sessionFactory.openSession();
			
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			List<Article> list = mapper.getAllArticles();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
