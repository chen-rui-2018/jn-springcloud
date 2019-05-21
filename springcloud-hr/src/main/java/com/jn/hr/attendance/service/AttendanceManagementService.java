package com.jn.hr.attendance.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jn.common.model.PaginationData;
import com.jn.hr.attendance.model.AttendanceManagementPage;
import com.jn.hr.attendance.model.AttendanceManagementVo;
import com.jn.hr.attendance.model.AttendanceSchedulPage;
import com.jn.hr.attendance.model.AttendanceSchedulVo;
import com.jn.hr.attendance.model.AttendanceTimeSetAdd;
import com.jn.hr.attendance.model.AttendanceTimeSetVo;
import com.jn.hr.attendance.model.VacationManagePage;
import com.jn.system.model.User;

@Service
public interface AttendanceManagementService {

	//考勤管理分页查询
	public PaginationData<List<AttendanceManagementVo>> attendanceManagementList(AttendanceManagementPage attendanceManagementPage);
	//导出考勤管理
	public PaginationData<List<AttendanceManagementVo>> exportAttendanceManagement(AttendanceManagementPage attendanceManagementPage);
	//旷工明细
	public List<AttendanceManagementVo> absenceDetailList(AttendanceManagementPage attendanceManagementPage);
	//迟到明细
	public List<AttendanceManagementVo> comeLateDetailList(AttendanceManagementPage attendanceManagementPage);
	//早退明细
	public List<AttendanceManagementVo> leaveEarlyDetailList(AttendanceManagementPage attendanceManagementPage);
	//缺卡明细
	public List<AttendanceManagementVo> notCardDetailList(AttendanceManagementPage attendanceManagementPage);
	//请假明细
	public List<AttendanceManagementVo> leaveDetailist(AttendanceManagementPage attendanceManagementPage);
	//考勤时间设定  添加班次
	public void addAttendanceTimeSet(AttendanceTimeSetAdd record,User user);
	//考勤时间设定  修改班次
	public void updateAttendanceTimeSet(AttendanceTimeSetAdd attendanceTimeSetAdd,User user);
	//考勤时间设定  删除班次
	public void deleteAttendanceTimeSet(AttendanceTimeSetAdd attendanceTimeSetAdd);
	//考勤时间设定  查询班次
	public List<AttendanceTimeSetVo> AttendanceTimeSetList();
	//排班管理的页面查询
	public PaginationData<List<AttendanceSchedulVo>> scheduDetailistPage(AttendanceSchedulPage attendanceSchedulPage);
	//排班管理的导入
	public String importScheduDetailist(MultipartFile file, User user);
	//排班明细的页面查询
	public PaginationData<List<AttendanceSchedulVo>> scheduDetailist(AttendanceSchedulPage attendanceSchedulPage);
    //排班明细的导出
	public PaginationData<List<AttendanceSchedulVo>> exportScheduDetailist(AttendanceSchedulPage attendanceSchedulPage);
	//排班明细的修改
	public void updateScheduDetailist(List<AttendanceSchedulPage> attendanceSchedulPage,User user);
	
}
