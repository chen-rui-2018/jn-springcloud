package com.jn.hr.attendance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.jn.hr.attendance.model.VacationManagePage;
import com.jn.hr.attendance.model.VacationManageVo;

public interface VacationManageAttanceMapper {
	List<VacationManageVo> selectByJobNumber(VacationManagePage vacationManageVo);
	
	List<VacationManageVo> selectByGroupByJobNumber(VacationManageVo vacationManageVo);
	
	VacationManageVo selectByTypeAndUserId(@Param("userId") String userId,@Param("vacationType") String vacationType);
	
	@MapKey("vacationType")
	Map<String,VacationManageVo> selectByUserId(@Param("userId") String userId);
	
	void insert(VacationManageVo vacationManageVo);
}
