package com.jn.hr.attendance.dao;

import java.util.List;

import com.jn.hr.attendance.model.VacationManagePage;
import com.jn.hr.attendance.model.VacationManageVo;

public interface VacationManageAttanceMapper {
	List<VacationManageVo> selectByJobNumber(VacationManagePage vacationManageVo);
	
	List<VacationManageVo> selectByGroupByJobNumber(VacationManageVo vacationManageVo);
}
