package com.jn.hr.increase.dao;

import java.util.List;

import com.jn.hr.increase.model.IncreaseDetailed;

public interface IncreaseDetailedMapper {	
	
	List<IncreaseDetailed> selectByMonth(IncreaseDetailed increaseDetailed);
}
