package com.ly.blog.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ly.blog.dao.bean.impl.Article;

public interface ArticleMapper {

	@Select("select * from t_article where id=#{id}")
	public Article getArticle(int id);
	
	@Select("select * from t_article")
	public List<Article> getAllArticles();
	
	@Select("select * from t_article where status=1 order by sn desc, createTime desc")
	public List<Article> getAllPublicArticles();
	
	@Select("select count(1) from t_article where status=1")
	public int getPublicArticleCount();
	
	/*********************************/
	@Insert("insert into t_article (createTime,lastUpdateTime,content,viewedCount,title,excerpt,status) values(#{article.createTime},#{article.lastUpdateTime},#{article.content},#{article.viewedCount},#{article.title},#{article.excerpt},#{article.status})")
	@Options(useGeneratedKeys=true,keyProperty="article.id")
	public void addArticle(@Param("article") Article article);
	
	@Update("update t_article set title=#{article.title},excerpt=#{article.excerpt},status=#{article.status},content=#{article.content} where id=#{article.id}")
	public void updateArticle(@Param("article")Article article);
	
	@Delete("delete from t_article where id=#{id}")
	public void deleteArticle(String id);
	
	@Delete("delete from t_article")
	public int deleteAllArticle();
	
	@Update("update t_article set viewedCount=viewedCount+1 where id=#{id}")
	public void addViewedCount(int id);
	
}
