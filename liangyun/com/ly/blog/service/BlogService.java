package com.ly.blog.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ly.blog.dao.bean.impl.Article;
import com.ly.blog.dao.mybatis.mapper.ArticleMapper;

public class BlogService extends BaseService{

	/**
	 * 
	 * @return
	 */
	public static List<Article> getAllArticles(){
		try{
			return baseExecution(new ICallback<List<Article>>() {
				@Override
				public List<Article> doExecute(SqlSession session) {
					ArticleMapper mapper = session.getMapper(ArticleMapper.class);
					List<Article> articles = mapper.getAllArticles();
					return articles;
				}
			});
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Article> getAllPublicArticles(){
		try{
			return baseExecution(new ICallback<List<Article>>() {
				@Override
				public List<Article> doExecute(SqlSession session) {
					ArticleMapper mapper = session.getMapper(ArticleMapper.class);
					List<Article> articles = mapper.getAllPublicArticles();
					return articles;
				}
			});
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 
	 * @param pageSize
	 * @param page
	 * @return
	 * @throws Exception 
	 */
	public static List<Article> getPagingArticles(int pageSize, int page) throws Exception{
		
		List<Article> articles = baseExecution(new ICallback<List<Article>>() {
			@Override
			public List<Article> doExecute(SqlSession session) {
				ArticleMapper mapper = session.getMapper(ArticleMapper.class);
				List<Article> articles = mapper.getAllPublicArticles();
				return articles;
			}
		});
		List<Article> result = null;
		if(pageSize * page - 1 > articles.size()){
			result = articles.subList(pageSize * (page - 1), articles.size());
		}else{
			result = articles.subList(pageSize * (page - 1), pageSize * page);
		}
		return result;
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Article getArticle(int id){
		try{
			return baseExecution(new ICallback<Article>() {
				@Override
				public Article doExecute(SqlSession session) {
					ArticleMapper mapper = session.getMapper(ArticleMapper.class);
					Article articles = mapper.getArticle(id);
					return articles;
				}
			});
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	public static int getPublicArticleCount() throws Exception{
		return baseExecution(new ICallback<Integer>() {
			@Override
			public Integer doExecute(SqlSession session) {
				ArticleMapper mapper = session.getMapper(ArticleMapper.class);
				int articleCount = mapper.getPublicArticleCount();
				return articleCount;
			}
		});
	}
	
	/**
	 * 
	 * @param article
	 * @throws Exception 
	 */
	public static void addArticle(Article article) throws Exception{
		article.setCreateTime(new Date());
		article.setLastUpdateTime(new Date());
		article.setViewedCount(0);
		baseExecution(new ICallback<List<Article>>() {
			@Override
			public List<Article> doExecute(SqlSession session) {
				ArticleMapper mapper = session.getMapper(ArticleMapper.class);
				mapper.addArticle(article);
				session.commit();
				return null;
			}
		});
	}
	
	/**
	 * 
	 * @param article
	 * @throws Exception 
	 */
	public static void updateArticle(Article article) throws Exception{
		article.setLastUpdateTime(new Date());
		baseExecution(new ICallback<List<Article>>() {
			@Override
			public List<Article> doExecute(SqlSession session) {
				ArticleMapper mapper = session.getMapper(ArticleMapper.class);
				mapper.updateArticle(article);
				session.commit();
				return null;
			}
		});
	}
	
	/**
	 * 
	 * @param id
	 * @throws Exception 
	 */
	public static void deleteArticle(String id) throws Exception{
		baseExecution(new ICallback<List<Article>>() {
			@Override
			public List<Article> doExecute(SqlSession session) {
				ArticleMapper mapper = session.getMapper(ArticleMapper.class);
				mapper.deleteArticle(id);
				session.commit();
				return null;
			}
		});
	}
	
	/**
	 * 
	 */
	public static int deleteAllArticles(){
		return 0;
	}
	
}
