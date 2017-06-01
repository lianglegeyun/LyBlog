package com.ly.blog.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ly.blog.dao.bean.dto.VistorDTO;
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
	
	
	public static List<VistorDTO> getVistor() throws Exception{
		return baseExecution(new ICallback<List<VistorDTO>>() {

			@Override
			public List<VistorDTO> doExecute(SqlSession session) {
				VistorMapper mapper = session.getMapper(VistorMapper.class);
				return mapper.getVistors();
			}
		});
	}
	
	public static List<Vistor> getYesterdayVistors() throws Exception{
		Calendar calendar = Calendar.getInstance();
		int tyear = calendar.get(Calendar.YEAR);
		int tmonth = calendar.get(Calendar.MONTH) + 1;
		int tdate = calendar.get(Calendar.DATE);
		String endDate = tyear + "-" + tmonth + "-" + tdate;
		
		calendar.add(Calendar.DATE, -1);
		int yyear = calendar.get(Calendar.YEAR);
		int ymonth = calendar.get(Calendar.MONTH) + 1;
		int ydate = calendar.get(Calendar.DATE);
		String beginDate = yyear + "-" + ymonth + "-" + ydate;
		
		return baseExecution(new ICallback<List<Vistor>>() {
			@Override
			public List<Vistor> doExecute(SqlSession session) {
				VistorMapper mapper = session.getMapper(VistorMapper.class);
				return mapper.getVistorsByDate(beginDate, endDate);
			}
		});
	}
	
	public static List<Vistor> getPagingVistors(int page, int pageSize) throws Exception{
		int offset = (page - 1) * pageSize;
		return baseExecution(new ICallback<List<Vistor>>() {
			@Override
			public List<Vistor> doExecute(SqlSession session) {
				VistorMapper mapper = session.getMapper(VistorMapper.class);
				return mapper.getPagingVistors(offset, pageSize);
			}
		});
		
	}
	
	public static int getVistCount() throws Exception{
		return baseExecution(new ICallback<Integer>() {
			@Override
			public Integer doExecute(SqlSession session) {
				VistorMapper mapper = session.getMapper(VistorMapper.class);
				return mapper.getVistCount();
			}
		});
	}
	
	public static int getYesterdayVistorCount() throws Exception{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String endDate = df.format(calendar.getTime());
		
		calendar.add(Calendar.DATE, -1);
		String beginDate = df.format(calendar.getTime());
		
		return baseExecution(new ICallback<Integer>() {
			@Override
			public Integer doExecute(SqlSession session) {
				VistorMapper mapper = session.getMapper(VistorMapper.class);
				return mapper.getPeriodVistorCount(beginDate, endDate);
			}
		});
	}
	
}
