package com.jn.hr.common.util;

import java.io.Serializable;
import java.util.Comparator;

import com.jn.hr.attendance.model.AttendanceManagementVo;

public class ComparatorAttendance implements Comparator<Object>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4857933817409567136L;

	@Override
	public int compare(Object obj0, Object obj1) {
		AttendanceManagementVo record1 = (AttendanceManagementVo)obj0;
		AttendanceManagementVo record2 = (AttendanceManagementVo)obj1;
		int flag = record2.getAbsenceDate().compareTo(record1.getAbsenceDate());
		if(flag >= 0){
			return flag;
		}else{
			return flag;
		}
	}
}
