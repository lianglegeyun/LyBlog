package com.ly.blog.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ly.blog.dao.bean.dto.VistorDTO;
import com.ly.blog.dao.bean.impl.Vistor;

public interface VistorMapper {

	@Insert("insert into t_vistor (ip,userAgent,url,date) values(#{vistor.ip},#{vistor.userAgent},#{vistor.url},#{vistor.date})")
	@Options(useGeneratedKeys=true,keyProperty="vistor.id")
	public void addVistor(@Param("vistor") Vistor vistor);
	
	@Select("select * from t_vistor where date <#{endDate} and date >=#{endDate}")
	public List<Vistor> getVistorsByDate(@Param("beginDate")String beginDate, @Param("endDate")String endDate);
	
	@Select("select * from t_vistor order by date desc limit #{offset},#{pageSize}")
	public List<Vistor> getPagingVistors(@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	@Select("select count(1) from t_vistor")
	public int getVistCount();
	
	@Select("select count(1) from (select 1 from t_vistor where date <#{endDate} and date >=#{beginDate} group by ip) t")
	public int getPeriodVistorCount(@Param("beginDate")String beginDate, @Param("endDate")String endDate);
	
	@Select("select ip,count(*) as hits,address from t_vistor group by ip,address")
	public List<VistorDTO> getVistors();
	
	@Select("select id,ip from t_vistor")
	public List<Vistor> getAllVists();
	
	@Select("select id,ip from t_vistor where address is null")
	public List<Vistor> getNewVists();
	
}
