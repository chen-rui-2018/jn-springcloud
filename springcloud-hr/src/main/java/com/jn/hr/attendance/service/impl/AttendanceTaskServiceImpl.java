package com.jn.hr.attendance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.hr.attendance.dao.AttendanceManagementMapper;
import com.jn.hr.attendance.dao.AttendanceSchedulMapper;
import com.jn.hr.attendance.model.AttendanceManagementAdd;
import com.jn.hr.attendance.model.AttendanceSchedulPage;
import com.jn.hr.attendance.model.AttendanceSchedulVo;
import com.jn.hr.attendance.service.AttendanceTaskService;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.oa.api.OaClient;
import com.jn.oa.model.Attendance;
import com.jn.oa.model.Leave;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.oa.vo.LeaveApiVo;

@Service
public class AttendanceTaskServiceImpl implements AttendanceTaskService {

	@Autowired
	OaClient oaClient;
	@Autowired
	AttendanceSchedulMapper attendanceSchedulMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	AttendanceManagementMapper attendanceManagementMapper;
	@Override
	public Result<Map<String, String>> summaryAttendanceInfo() {
		Result<Map<String,String>> result=new Result<Map<String,String>>();
		List<AttendanceManagementAdd> attendanceManageList = new ArrayList<AttendanceManagementAdd>();
		//获取员工基本信息
		TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		Map<String,TbManpowerEmployeeBasicInfo> basicMap = employeeBasicInfoMapper.map(tbManpowerEmployeeBasicInfo);
		//获取当月的排班情况
		AttendanceSchedulPage attendanceSchedulPage = new AttendanceSchedulPage();
		//要获取前一天的时间
		attendanceSchedulPage.setSchedulMonth(DateUtils.formatDate(new Date(),"yyyy-MM"));
		List<AttendanceSchedulVo> schedulList = attendanceSchedulMapper.list(attendanceSchedulPage);
		Map<String,Map<String,Integer>> userIdMap = new HashMap<String,Map<String,Integer>>();
		Map<String,TbManpowerEmployeeBasicInfo> jobNumberMap = new HashMap<String,TbManpowerEmployeeBasicInfo>();
		for(AttendanceSchedulVo schedul : schedulList){
			Map<String,Integer> map = new HashMap<String,Integer>();
			map = schedulMonthMap(schedul);
			TbManpowerEmployeeBasicInfo basic = new TbManpowerEmployeeBasicInfo();
			basic = basicMap.get(schedul.getJobNumber());
			if(basic == null){
				continue;
			}
			userIdMap.put(basic.getUserId(), map);
			jobNumberMap.put(basic.getUserId(), basic);
		}
		
		//获取请假明细
		Leave leave = new Leave();
		Result<List<LeaveApiVo>> leaveList = oaClient.searchLeaveListByCondition(leave);
		List<LeaveApiVo> list = leaveList.getData();
		Map<String,LeaveApiVo> leaveMap = new HashMap<String,LeaveApiVo>();
		for(LeaveApiVo leaveVo: list){
			leaveMap.put(leaveVo.getUserId(), leaveVo);
		}
		
		//获取考勤明细
		Attendance attendance = new Attendance();
		Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
		List<AttendanceApiVo> attendanceApiList = attendanceList.getData();
		for(AttendanceApiVo attendanceApi : attendanceApiList){
			AttendanceManagementAdd attendanceManagementAdd = getAttendanceManagementAdd(attendanceApi,leaveMap,userIdMap);
			if(attendanceManagementAdd == null){
				continue;
			}
			TbManpowerEmployeeBasicInfo basic = jobNumberMap.get(attendanceApi.getUserId());
			attendanceManagementAdd.setJobNumber(basic.getUserId());
			attendanceManagementAdd.setName(basic.getName());
			attendanceManageList.add(attendanceManagementAdd);
		}
		
		 try{
			 attendanceManagementMapper.insertBatch(attendanceManageList);
         }catch(DuplicateKeyException e){

         }
		
		return result;
	}

	//设置考勤日期
	private Map<String,Integer> schedulMonthMap(AttendanceSchedulVo schedul){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put(schedul.getSchedulMonth() + "-01", schedul.getNumber1());
		map.put(schedul.getSchedulMonth() + "-02", schedul.getNumber2());
		map.put(schedul.getSchedulMonth() + "-03", schedul.getNumber3());
		map.put(schedul.getSchedulMonth() + "-04", schedul.getNumber4());
		map.put(schedul.getSchedulMonth() + "-05", schedul.getNumber5());
		map.put(schedul.getSchedulMonth() + "-06", schedul.getNumber6());
		map.put(schedul.getSchedulMonth() + "-07", schedul.getNumber7());
		map.put(schedul.getSchedulMonth() + "-08", schedul.getNumber8());
		map.put(schedul.getSchedulMonth() + "-09", schedul.getNumber9());
		map.put(schedul.getSchedulMonth() + "-10", schedul.getNumber10());
		map.put(schedul.getSchedulMonth() + "-11", schedul.getNumber11());
		map.put(schedul.getSchedulMonth() + "-12", schedul.getNumber12());
		map.put(schedul.getSchedulMonth() + "-13", schedul.getNumber13());
		map.put(schedul.getSchedulMonth() + "-14", schedul.getNumber14());
		map.put(schedul.getSchedulMonth() + "-15", schedul.getNumber15());
		map.put(schedul.getSchedulMonth() + "-16", schedul.getNumber16());
		map.put(schedul.getSchedulMonth() + "-17", schedul.getNumber17());
		map.put(schedul.getSchedulMonth() + "-18", schedul.getNumber18());
		map.put(schedul.getSchedulMonth() + "-19", schedul.getNumber19());
		map.put(schedul.getSchedulMonth() + "-20", schedul.getNumber20());
		map.put(schedul.getSchedulMonth() + "-21", schedul.getNumber21());
		map.put(schedul.getSchedulMonth() + "-22", schedul.getNumber22());
		map.put(schedul.getSchedulMonth() + "-23", schedul.getNumber23());
		map.put(schedul.getSchedulMonth() + "-24", schedul.getNumber24());
		map.put(schedul.getSchedulMonth() + "-25", schedul.getNumber25());
		map.put(schedul.getSchedulMonth() + "-26", schedul.getNumber26());
		map.put(schedul.getSchedulMonth() + "-27", schedul.getNumber27());
		map.put(schedul.getSchedulMonth() + "-28", schedul.getNumber28());
		map.put(schedul.getSchedulMonth() + "-29", schedul.getNumber29());
		map.put(schedul.getSchedulMonth() + "-30", schedul.getNumber30());
		map.put(schedul.getSchedulMonth() + "-31", schedul.getNumber31());
		return map;
	}
	
	private AttendanceManagementAdd getAttendanceManagementAdd(AttendanceApiVo attendanceApi,Map<String,LeaveApiVo> leaveMap,Map<String,Map<String,Integer>> userIdMap){
		AttendanceManagementAdd AttendanceManagementAdd = null;
		//时间要获取前一天的时间   要改
		String str =  DateUtils.formatDate(new Date(),"yyyy-MM-dd");
		Map<String,Integer> map = userIdMap.get(attendanceApi.getUserId());
		Integer i = map.get(str) == null ? 0 : map.get(str);
		if(i != 0){
			AttendanceManagementAdd = new AttendanceManagementAdd();
			AttendanceManagementAdd.setId(UUID.randomUUID().toString());
			AttendanceManagementAdd.setUserId(attendanceApi.getUserId());
			AttendanceManagementAdd.setDepartment(attendanceApi.getDepartmentName());
			//if(attendanceApi)
		}
		return AttendanceManagementAdd;
	}
}
