package com.jn.hr.attendance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.attendance.model.VacationManagePage;
import com.jn.hr.attendance.model.VacationManageVo;

public interface VacationManageAttanceMapper {
	List<VacationManageVo> selectByJobNumber(VacationManagePage vacationManageVo);
	
	List<VacationManageVo> selectByGroupByJobNumber(VacationManageVo vacationManageVo);
	
	VacationManageVo selectByTypeAndUserId(@Param("userId") String userId,@Param("vacationType") String vacationType);
	
	void insert(VacationManageVo vacationManageVo);
}
