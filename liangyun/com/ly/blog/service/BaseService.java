package com.ly.blog.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseService {

	public static <T> T baseExecution(ICallback<T> callback) throws Exception{
		String resource = "my-batis-config.xml";
		InputStream stream = null;
		SqlSession session = null;
		try {
			stream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			session = sessionFactory.openSession();
			/*ArticleMapper mapper = session.getMapper();
			List<Article> list = mapper.getAllArticles();*/
			return callback.doExecute(session);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			session.close();
			stream.close();
		}
	}
	
}

