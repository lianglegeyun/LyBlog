package com.ly.blog.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select count(1) from t_user where role=0 and userName=#{userName} and passWord=#{passWord}")
	public int checkUserAndPassword(@Param("userName") String userName, @Param("passWord") String passWord);
	
}
