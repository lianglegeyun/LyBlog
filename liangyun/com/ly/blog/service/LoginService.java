package com.ly.blog.service;

import org.apache.ibatis.session.SqlSession;

import com.ly.blog.dao.mybatis.mapper.UserMapper;

public class LoginService extends BaseService{

	
	public static boolean checkUserAndPassword(String userName, String passWord){
		try{
			int count = baseExecution(new ICallback<Integer>() {
				@Override
				public Integer doExecute(SqlSession session) {
					UserMapper mapper = session.getMapper(UserMapper.class);
					return mapper.checkUserAndPassword(userName, passWord);
				}
			});
			if(count == 1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}
