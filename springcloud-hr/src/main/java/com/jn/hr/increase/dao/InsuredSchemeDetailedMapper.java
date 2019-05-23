package com.jn.hr.increase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.increase.model.InsuredSchemeDetailed;

public interface InsuredSchemeDetailedMapper {
	
	//void updateList(List<InsuredSchemeDetailed> list);
	
	void updateBySchemeId(List<InsuredSchemeDetailed> record);
	
	void updateBystatus(@Param("schemeId") String schemeId);
	
	void deleteBySchemeId(@Param("schemeId") String schemeId);
	
	void insertBatch(List<InsuredSchemeDetailed> list);
	
	List<InsuredSchemeDetailed> selectBySchemeId(@Param("schemeId") String schemeId);
}
