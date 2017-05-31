package com.ly.blog.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ly.blog.dao.bean.impl.Vistor;
import com.ly.blog.dao.mybatis.mapper.VistorMapper;

public class VistorService extends BaseService{

	public static void addVistor(Vistor vistor) throws Exception{
		
		baseExecution(new ICallback<Vistor>() {
			@Override
			public Vistor doExecute(SqlSession session) {
				VistorMapper mapper = session.getMapper(VistorMapper.class);
				mapper.addVistor(vistor);
				session.commit();
				return null;
			}
		});
		
	}
	
	
	public static List<Vistor> getVistor(){
		return new ArrayList<Vistor>();
	}
	
	public static List<Vistor> getVistorByDate(Calendar calendar){
		//calendar.
		return null;
	}
	
	
}
