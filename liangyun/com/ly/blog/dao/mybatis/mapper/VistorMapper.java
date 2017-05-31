package com.ly.blog.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ly.blog.dao.bean.impl.Vistor;

public interface VistorMapper {

	@Insert("insert into t_vistor (ip,userAgent,url,date) values(#{vistor.ip},#{vistor.userAgent},#{vistor.url},#{vistor.date})")
	@Options(useGeneratedKeys=true,keyProperty="vistor.id")
	public void addVistor(@Param("vistor") Vistor vistor);
	
	@Select("select * from t_vistor where date <#{endDate} and date >=#{endDate}")
	public List<Vistor> getVistorsByDate(String beginDate, String endDate);
	
	
}
