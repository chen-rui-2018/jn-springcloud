package com.jn.hr.increase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.increase.model.IncreaseDetailed;

public interface IncreaseDetailedMapper {	
	
	List<IncreaseDetailed> selectByJobNumberAndSchemeId(@Param("jobNumber")String jobNumber,@Param("schemeName") String schemeName);
	
	void insertBatch(List<IncreaseDetailed> records);
}
