package com.jn.hr.attendance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.hr.attendance.dao.AttendanceManagementMapper;
import com.jn.hr.attendance.dao.AttendanceSchedulMapper;
import com.jn.hr.attendance.dao.AttendanceTimeSetMapper;
import com.jn.hr.attendance.model.AttendanceManagementAdd;
import com.jn.hr.attendance.model.AttendanceSchedulPage;
import com.jn.hr.attendance.model.AttendanceSchedulVo;
import com.jn.hr.attendance.model.AttendanceTimeSetPage;
import com.jn.hr.attendance.model.AttendanceTimeSetVo;
import com.jn.hr.attendance.service.AttendanceTaskService;
import com.jn.hr.common.util.HrDataUtil;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.oa.api.OaClient;
import com.jn.oa.model.Attendance;
import com.jn.oa.model.Leave;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.oa.vo.LeaveApiVo;

@Service
public class AttendanceTaskServiceImpl implements AttendanceTaskService {

	private static final Logger logger = LoggerFactory.getLogger(AttendanceTaskServiceImpl.class);
	@Autowired
	OaClient oaClient;
	@Autowired
	AttendanceSchedulMapper attendanceSchedulMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	AttendanceManagementMapper attendanceManagementMapper;
	@Autowired
	AttendanceTimeSetMapper attendanceTimeSetMapper;

	@Override
	public Result<Map<String, String>> summaryAttendanceInfo() {
		Result<Map<String, String>> result = new Result<Map<String, String>>();
		List<AttendanceManagementAdd> attendanceManageList = new ArrayList<AttendanceManagementAdd>();
		EmployeeBasicInfoPage employeeBasicInfoPage = new EmployeeBasicInfoPage();
		List<EmployeeBasicInfo> employeeBasicInfoList = employeeBasicInfoMapper.list(employeeBasicInfoPage);
		// 获取考勤班次时间
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		AttendanceTimeSetVo timeSet = attendanceTimeSetMapper.selectByAttendanceType(attendanceTimeSetPage);

		AttendanceSchedulPage attendanceSchedulPage = new AttendanceSchedulPage();
		// 获取考勤月份的排班情况（获取上一天所在月份的排班情况）
		Date date = HrDataUtil.getBeforeDay(new Date());
		String str = HrDataUtil.getDayBefore(date);
		attendanceSchedulPage.setSchedulMonth(str);
		Map<String, AttendanceSchedulVo> attendanceSchedul = attendanceSchedulMapper.obtainMap(attendanceSchedulPage);

		// 获取前一天的date时间
		Date beforeDate = HrDataUtil.getBeforeDay(new Date());
		String dateStr = DateUtils.formatDate(beforeDate, "yyyyMMdd");
		for (EmployeeBasicInfo basic : employeeBasicInfoList) {
			// 获取这个月的排班情况
			AttendanceSchedulVo schedu = new AttendanceSchedulVo();
			schedu = attendanceSchedul.get(basic.getJobNumber());
			if (schedu == null) {
				continue;
			}
			// 有排班情况才记录考勤
			Map<String, Integer> monthMap = new HashMap<String, Integer>();
			monthMap = schedulMonthMap(schedu);
			// 不在考勤日期继续下个用户
			if (monthMap.get(dateStr) == null && monthMap.get(dateStr) == 0) {
				continue;
			}

			AttendanceManagementAdd attendanceManagementAdd = new AttendanceManagementAdd();
			attendanceManagementAdd.setUserId(basic.getUserId());
			attendanceManagementAdd.setId(UUID.randomUUID().toString());
			attendanceManagementAdd.setJobNumber(basic.getJobNumber());
			attendanceManagementAdd.setName(basic.getName());
			attendanceManagementAdd.setDepartment(basic.getDepartmentName());
			attendanceManagementAdd.setAttendanceDate(DateUtils.formatDate(beforeDate, "yyyyMMdd"));
			attendanceManagementAdd.setAttendance(1);

			// 获取请假明细
			Leave leave = new Leave();
			leave.setUserId(basic.getUserId());
			leave.setStartTime(beforeDate);
			Result<List<LeaveApiVo>> leaveList = oaClient.searchLeaveListByCondition(leave);
			List<LeaveApiVo> list = leaveList.getData();
			for (LeaveApiVo leaveApiVo : list) {
				obtainLeaveInfo(leaveApiVo, attendanceManagementAdd);
			}

			// 获取考勤明细
			String key = "";
			Map<String, Integer> attendanceMap = new HashMap<String, Integer>();
			Attendance attendance = new Attendance();
			attendance.setUserId(basic.getUserId());
			attendance.setStartTime(beforeDate);
			Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
			List<AttendanceApiVo> attendanceApiList = attendanceList.getData();
			for (AttendanceApiVo attendanceApiVo : attendanceApiList) {
				obtainAttendanceInfo(attendanceApiVo, timeSet, attendanceManagementAdd);
				// 旷工
				if (attendanceApiVo.getSignInAttendanceTime() != null) {
					key = DateUtils.formatDate(attendanceApiVo.getSignInAttendanceTime(), "yyyyMMdd");
				} else if (attendanceApiVo.getSignOutAttendanceTime() != null) {
					key = DateUtils.formatDate(attendanceApiVo.getSignOutAttendanceTime(), "yyyyMMdd");
				}
				attendanceMap.put(key, 1);
			}

			if (monthMap.get(dateStr) != null && monthMap.get(dateStr) != 0 && attendanceMap.get(dateStr) == null) {
				attendanceManagementAdd.setAbsenteeism(1);
			}

			attendanceManageList.add(attendanceManagementAdd);
		}

		logger.info("[考勤定时任务]插入条数为：" + attendanceManageList.size());
		
		try {
			if(attendanceManageList.size() != 0){
				attendanceManagementMapper.insertBatch(attendanceManageList);
			}
		} catch (DuplicateKeyException e) {

		}

		return result;
	}

	// 获取早退、迟到、缺卡
	private void obtainAttendanceInfo(AttendanceApiVo attendanceApiVo, AttendanceTimeSetVo timeSet,
			AttendanceManagementAdd attendanceManagementAdd) {
		if (attendanceApiVo.getSignInAttendanceTime() == null && attendanceApiVo.getSignOutAttendanceTime() != null) {
			attendanceManagementAdd.setStartMissCard(1);
		} else if (attendanceApiVo.getSignInAttendanceTime() != null
				&& attendanceApiVo.getSignOutAttendanceTime() == null) {
			attendanceManagementAdd.setEndMissCard(1);
		} else if (attendanceApiVo.getSignInAttendanceTime() == null
				&& attendanceApiVo.getSignOutAttendanceTime() != null && timeSet.getDutyAttendanceTime()
						.compareTo(DateUtils.formatDate(attendanceApiVo.getSignOutAttendanceTime(), "HH:mm")) > 0) {
			attendanceManagementAdd.setStartMissCard(1);
			attendanceManagementAdd.setLeaveEarly(1);
		} else if (attendanceApiVo.getSignInAttendanceTime() != null
				&& attendanceApiVo.getSignOutAttendanceTime() == null && timeSet.getWorkAttendanceTime()
						.compareTo(DateUtils.formatDate(attendanceApiVo.getSignInAttendanceTime(), "HH:mm")) < 0) {
			attendanceManagementAdd.setEndMissCard(1);
			attendanceManagementAdd.setLate(1);
		} else if (timeSet.getWorkAttendanceTime()
				.compareTo(DateUtils.formatDate(attendanceApiVo.getSignInAttendanceTime(), "HH:mm")) < 0) {
			attendanceManagementAdd.setLate(1);
		} else if (timeSet.getDutyAttendanceTime()
				.compareTo(DateUtils.formatDate(attendanceApiVo.getSignOutAttendanceTime(), "HH:mm")) > 0) {
			attendanceManagementAdd.setLeaveEarly(1);
		}
	}

	// 获取当日的请假情况
	private void obtainLeaveInfo(LeaveApiVo leaveApiVo, AttendanceManagementAdd attendanceManagementAdd) {
		if (leaveApiVo.getType().equals("1")) {
			// 年假
			attendanceManagementAdd.setAnnualLeave(Integer.valueOf(leaveApiVo.getTotalHour()));
		} else if (leaveApiVo.getType().equals("3")) {
			// 事假
			attendanceManagementAdd.setCompassionateLeave(Integer.valueOf(leaveApiVo.getTotalHour()));
		} else if (leaveApiVo.getType().equals("4")) {
			// 病假
			attendanceManagementAdd.setSickLeave(Integer.valueOf(leaveApiVo.getTotalHour()));
		} else if (leaveApiVo.getType().equals("5")) {
			// 婚嫁
			attendanceManagementAdd.setMarriageHoliday(Integer.valueOf(leaveApiVo.getTotalHour()));
		} else if (leaveApiVo.getType().equals("6")) {
			// 产假
			attendanceManagementAdd.setMaternityLeave(Integer.valueOf(leaveApiVo.getTotalHour()));
		} else if (leaveApiVo.getType().equals("9")) {
			// 丧家
			attendanceManagementAdd.setFuneralLeave(Integer.valueOf(leaveApiVo.getTotalHour()));
		}
	}

	// 设置考勤日期
	private Map<String, Integer> schedulMonthMap(AttendanceSchedulVo schedul) {
		Map<String, Integer> map = new HashMap<String, Integer>();
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
}
