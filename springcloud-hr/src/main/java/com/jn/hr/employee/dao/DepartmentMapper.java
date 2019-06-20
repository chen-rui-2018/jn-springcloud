package com.jn.hr.employee.dao;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.jn.hr.employee.entity.TbManpowerDepartment;

public interface DepartmentMapper {

	@MapKey("departmentName")
	Map<String,TbManpowerDepartment> selectByDepartmentName(TbManpowerDepartment records);
}
