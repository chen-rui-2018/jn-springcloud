package com.jn.hr.increase.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.jn.hr.increase.model.InsuredScheme;
import com.jn.hr.increase.model.InsuredSchemePage;

public interface InsuredSchemeMapper {

	@MapKey("schemeName")
	Map<String,InsuredScheme> getInsuredSchemeMap(InsuredSchemePage insuredSchemePage);
	
	int selectBySchemeName(@Param("schemeName") String schemeName);
	
	List<InsuredScheme> list(InsuredSchemePage insuredSchemePage);
}
