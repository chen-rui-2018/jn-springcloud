package com.jn.hr.increase.dao;

import java.util.List;

import com.jn.hr.increase.model.InsuredScheme;
import com.jn.hr.increase.model.InsuredSchemePage;

public interface InsuredSchemeMapper {

	/*@MapKey("schemeId")
	Map<String,InsuredScheme> getInsuredSchemeMap(InsuredSchemePage insuredSchemePage);*/
	
	List<InsuredScheme> list(InsuredSchemePage insuredSchemePage);
}
