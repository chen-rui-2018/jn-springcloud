package com.jn.hr.attendance.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.hr.attendance.dao.AttendanceManagementMapper;
import com.jn.hr.attendance.dao.AttendanceSchedulMapper;
import com.jn.hr.attendance.dao.AttendanceTimeSetMapper;
import com.jn.hr.attendance.dao.TbManpowerAttendanceSchedulMapper;
import com.jn.hr.attendance.dao.TbManpowerAttendanceTimeSetMapper;
import com.jn.hr.attendance.dao.TbManpowerVacationManageMapper;
import com.jn.hr.attendance.dao.VacationManageAttanceMapper;
import com.jn.hr.attendance.entity.TbManpowerAttendanceSchedul;
import com.jn.hr.attendance.entity.TbManpowerAttendanceTimeSet;
import com.jn.hr.attendance.entity.TbManpowerVacationManage;
import com.jn.hr.attendance.enums.AttendanceManageStatusEnums;
import com.jn.hr.attendance.enums.AttendanceManageTypeEnums;
import com.jn.hr.attendance.model.AttendanceManagementPage;
import com.jn.hr.attendance.model.AttendanceManagementVo;
import com.jn.hr.attendance.model.AttendanceSchedulAdd;
import com.jn.hr.attendance.model.AttendanceSchedulPage;
import com.jn.hr.attendance.model.AttendanceSchedulVo;
import com.jn.hr.attendance.model.AttendanceTimeSetAdd;
import com.jn.hr.attendance.model.AttendanceTimeSetPage;
import com.jn.hr.attendance.model.AttendanceTimeSetVo;
import com.jn.hr.attendance.model.VacationManageVo;
import com.jn.hr.attendance.service.AttendanceManagementService;
import com.jn.hr.common.enums.HrExceptionEnums;
import com.jn.hr.common.util.ComparatorAttendance;
import com.jn.hr.common.util.HrDataUtil;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.TbManpowerDepartmentMapper;
import com.jn.hr.employee.entity.TbManpowerDepartment;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.enums.EmployeeExceptionEnums;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.hr.increase.enums.SalaryManagementExceptionEnums;
import com.jn.hr.model.AttendanceKeyValue;
import com.jn.hr.model.AttendanceManageApiVo;
import com.jn.hr.model.AttendanceManageObject;
import com.jn.hr.model.AttendanceManagement;
import com.jn.hr.model.AttendanceManagementApiVo;
import com.jn.hr.model.AttendanceOverTime;
import com.jn.hr.model.AttendanceOverTimeApiVo;
import com.jn.hr.model.VacationManagement;
import com.jn.oa.api.OaClient;
import com.jn.oa.model.Attendance;
import com.jn.oa.model.Leave;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.oa.vo.LeaveApiVo;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;

@Service
public class AttendanceManagementServiceImpl implements AttendanceManagementService {

	private static final Logger logger = LoggerFactory.getLogger(AttendanceManagementServiceImpl.class);
	@Autowired
	OaClient oaClient;
	@Autowired
	AttendanceManagementMapper attendanceManagementMapper;
	@Autowired
	AttendanceTimeSetMapper attendanceTimeSetMapper;
	@Autowired
	TbManpowerAttendanceTimeSetMapper tbManpowerAttendanceTimeSetMapper;
	@Autowired
	AttendanceSchedulMapper attendanceSchedulMapper;
	@Autowired
	TbManpowerAttendanceSchedulMapper tbManpowerAttendanceSchedulMapper;
	@Autowired
	TbManpowerDepartmentMapper tbManpowerDepartmentMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	VacationManageAttanceMapper vacationManageAttanceMapper;
	@Autowired
	TbManpowerVacationManageMapper tbManpowerVacationManageMapper;
	@Autowired
	private SystemClient systemClient;

	@Override
	@ServiceLog(doAction = "????????????????????????")
	public PaginationData<List<AttendanceManagementVo>> attendanceManagementList(
			AttendanceManagementPage attendanceManagementPage) {
		Page<Object> objects = PageHelper.startPage(attendanceManagementPage.getPage(),
				attendanceManagementPage.getRows());
		if (!StringUtils.isEmpty(attendanceManagementPage.getDepartmentId())) {
			List<String> rootList = new ArrayList<String>();
			Result result = systemClient.selectDeptByParentId(attendanceManagementPage.getDepartmentId(), true);
			if (result == null || !"0000".equals(result.getCode()) || result.getData() == null) {
				throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
			}
			HashMap<String, Object> childMap = (HashMap<String, Object>) result.getData();
			rootList.add((String) childMap.get("id"));
			if (childMap.get("children") != null) {
				List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
				getChildrenDepartment(rootList, childrenSub);
			}
			attendanceManagementPage.setDepartmentIds(rootList);
		}
		List<AttendanceManagementVo> attendanceList = attendanceManagementMapper.list(attendanceManagementPage);
		PaginationData<List<AttendanceManagementVo>> pageList = new PaginationData(attendanceList, objects.getTotal());
		return pageList;
	}
	private void getChildrenDepartment(List<String> rootList, List<HashMap<String, Object>> children) {
		for (HashMap<String, Object> childMap : children) {
			rootList.add((String) childMap.get("id"));
			if (childMap.get("children") != null) {
				List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
				getChildrenDepartment(rootList, childrenSub);
			}
		}
	}

	@Override
	@ServiceLog(doAction = "????????????")
	public List<AttendanceManagementVo> absenceDetailList(AttendanceManagementPage attendanceManagementPage) {
		AttendanceSchedulPage attendanceSchedulPage = new AttendanceSchedulPage();
		Date startTime = HrDataUtil.formatConversion(attendanceManagementPage.getStartTime());
		Date endTime = HrDataUtil.formatConversion(attendanceManagementPage.getEndTime());
		attendanceSchedulPage.setJobNumber(attendanceManagementPage.getJobNumber());
		attendanceSchedulPage.setStartDate(DateUtils.formatDate(startTime, "yyyyMM"));
		attendanceSchedulPage.setEndDate(DateUtils.formatDate(endTime, "yyyyMM"));
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		List<AttendanceSchedulVo> schedulList = attendanceSchedulMapper.list(attendanceSchedulPage);
		// ??????????????????
		for (AttendanceSchedulVo schedul : schedulList) {
			Map<String, Integer> monthMap = schedulMonthMap(schedul);
			Map<String, Integer> map = new HashMap<String, Integer>();
			String key = "";
			String date = "";
			// ??????????????????
			Attendance attendance = new Attendance();
			if (StringUtils.isBlank(attendanceManagementPage.getStartTime())) {
				attendanceManagementPage.setStartTime("0");
			}
			if (StringUtils.isBlank(attendanceManagementPage.getEndTime())) {
				attendanceManagementPage.setEndTime("9");
			}
			attendance.setUserId(attendanceManagementPage.getUserId());
			Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
			List<AttendanceApiVo> list = attendanceList.getData();
			// ??????????????????
			for (AttendanceApiVo attendanceVo : list) {
				if (attendanceVo.getSignInAttendanceTime() != null) {
					date = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "yyyy-MM-dd");
					key = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "yyyyMMdd");
				} else if (attendanceVo.getSignOutAttendanceTime() != null) {
					date = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "yyyy-MM-dd");
					key = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "yyyyMMdd");
				}

				if (date.compareTo(attendanceManagementPage.getStartTime()) >= 0
						&& date.compareTo(attendanceManagementPage.getEndTime()) <= 0) {
					map.put(key, 1);
				}
			}

			// ?????????????????????????????????????????????
			for (String keyNumber : monthMap.keySet()) {
				if (keyNumber.compareTo(DateUtils.formatDate(startTime, "yyyyMMdd")) < 0
						|| keyNumber.compareTo(DateUtils.formatDate(endTime, "yyyyMMdd")) > 0) {
					continue;
				}

				if (map.get(keyNumber) == null && monthMap.get(keyNumber) != null && monthMap.get(keyNumber) == 1) {
					AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
					attendanceManage.setName(schedul.getName());
					attendanceManage.setDepartment(schedul.getDepartmentName());
					attendanceManage.setAbsenceDate(keyNumber);
					attendanceManageList.add(attendanceManage);
				}
			}
		}
		ComparatorAttendance compara = new ComparatorAttendance();
		Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "????????????")
	public List<AttendanceManagementVo> comeLateDetailList(AttendanceManagementPage attendanceManagementPage) {

		// ??????????????????
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		AttendanceTimeSetVo timeSet = attendanceTimeSetMapper.selectByAttendanceType(attendanceTimeSetPage);
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();

		Attendance attendance = new Attendance();
		if (!StringUtils.isBlank(attendanceManagementPage.getStartTime())) {
			try {
				attendance.setStartTime(HrDataUtil.getDate(attendanceManagementPage.getStartTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!StringUtils.isBlank(attendanceManagementPage.getEndTime())) {
			try {
				attendance.setEndTime(HrDataUtil.getDate(attendanceManagementPage.getEndTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// attendance.setDepartmentId(attendanceManagementPage.getDepartmentId());
		attendance.setUserId(attendanceManagementPage.getUserId());
		// ??????????????????
		Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
		List<AttendanceApiVo> list = attendanceList.getData();
		if (timeSet != null) {
			for (AttendanceApiVo attendanceVo : list) {
				// ??????????????????
				if (attendanceVo.getSignInAttendanceTime() == null) {
					continue;
				}

				String str = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm");
				// ??????????????????????????????????????????
				if (str.compareTo(timeSet.getDutyAttendanceTime()) > 0) {
					continue;
				}

				if (str.compareTo(timeSet.getWorkAttendanceTime()) > 0) {
					AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
					attendanceManage.setName(attendanceManagementPage.getName());
					attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
					attendanceManage.setSignInAttendanceTime(
							DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm:ss"));
					attendanceManage
							.setAbsenceDate(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "yyyy-MM-dd"));
					attendanceManageList.add(attendanceManage);
				}
			}
		}

		ComparatorAttendance compara = new ComparatorAttendance();
		Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "????????????")
	public List<AttendanceManagementVo> leaveEarlyDetailList(AttendanceManagementPage attendanceManagementPage) {
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		// ????????????????????????
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		AttendanceTimeSetVo timeSet = attendanceTimeSetMapper.selectByAttendanceType(attendanceTimeSetPage);
		Attendance attendance = new Attendance();
		if (!StringUtils.isBlank(attendanceManagementPage.getStartTime())) {
			try {
				attendance.setStartTime(HrDataUtil.getDate(attendanceManagementPage.getStartTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!StringUtils.isBlank(attendanceManagementPage.getEndTime())) {
			try {
				attendance.setEndTime(HrDataUtil.getDate(attendanceManagementPage.getEndTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		attendance.setUserId(attendanceManagementPage.getUserId());
		// ??????????????????
		Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
		List<AttendanceApiVo> list = attendanceList.getData();
		if (timeSet != null) {
			for (AttendanceApiVo attendanceVo : list) {
				// ???????????????????????????
				if (attendanceVo.getSignOutAttendanceTime() == null) {
					continue;
				}
				// ??????????????????????????????????????????
				String str = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm");
				if (str.compareTo(timeSet.getWorkAttendanceTime()) < 0) {
					continue;
				}
				if (str.compareTo(timeSet.getDutyAttendanceTime()) < 0) {
					AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
					// ?????????
					attendanceManage.setName(attendanceManagementPage.getName());
					attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
					attendanceManage.setSignInAttendanceTime(
							DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm:ss"));
					attendanceManage.setAbsenceDate(
							DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "yyyy-MM-dd"));
					attendanceManageList.add(attendanceManage);
				}
			}
		}

		ComparatorAttendance compara = new ComparatorAttendance();
		Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "????????????")
	public List<AttendanceManagementVo> notCardDetailList(AttendanceManagementPage attendanceManagementPage) {
		if (StringUtils.isBlank(attendanceManagementPage.getStartTime())) {
			attendanceManagementPage.setStartTime("0");
		}
		if (StringUtils.isBlank(attendanceManagementPage.getEndTime())) {
			attendanceManagementPage.setEndTime("9");
		}
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		Attendance attendance = new Attendance();
		attendance.setUserId(attendanceManagementPage.getUserId());
		// ??????????????????
		Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
		List<AttendanceApiVo> list = attendanceList.getData();
		for (AttendanceApiVo attendanceVo : list) {
			if (attendanceVo.getSignInAttendanceTime() == null && attendanceVo.getSignOutAttendanceTime() != null) {
				String date = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "yyyy-MM-dd");
				// ????????????????????????
				if (date.compareTo(attendanceManagementPage.getStartTime()) < 0
						|| date.compareTo(attendanceManagementPage.getEndTime()) > 0) {
					continue;
				}
				AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
				// ?????????
				attendanceManage.setName(attendanceManagementPage.getName());
				attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
				attendanceManage
						.setAbsenceDate(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "yyyy-MM-dd"));
				attendanceManage.setWorkStatus("????????????");
				attendanceManageList.add(attendanceManage);
			}

			if (attendanceVo.getSignOutAttendanceTime() == null && attendanceVo.getSignInAttendanceTime() != null) {
				String date = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "yyyy-MM-dd");
				// ??????????????????????????????
				if (date.compareTo(attendanceManagementPage.getStartTime()) < 0
						|| date.compareTo(attendanceManagementPage.getEndTime()) > 0) {
					continue;
				}
				AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
				// ?????????
				attendanceManage.setName(attendanceManagementPage.getName());
				attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
				attendanceManage
						.setAbsenceDate(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "yyyy-MM-dd"));
				attendanceManage.setWorkStatus("????????????");
				attendanceManageList.add(attendanceManage);
			}
		}

		ComparatorAttendance compara = new ComparatorAttendance();
		Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "????????????")
	public List<AttendanceManagementVo> leaveDetailist(AttendanceManagementPage attendanceManagementPage) {
		// ??????????????????
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		Leave leave = new Leave();
		leave.setUserId(attendanceManagementPage.getUserId());
		if (!StringUtils.isBlank(attendanceManagementPage.getStartTime())) {
			try {
				leave.setStartTime(HrDataUtil.getDate(attendanceManagementPage.getStartTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!StringUtils.isBlank(attendanceManagementPage.getEndTime())) {
			try {
				leave.setEndTime(HrDataUtil.getDate(attendanceManagementPage.getEndTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Result<List<LeaveApiVo>> leaveList = oaClient.searchLeaveListByCondition(leave);
		List<LeaveApiVo> list = leaveList.getData();
		for (LeaveApiVo leaveVo : list) {
			AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
			attendanceManage.setName(attendanceManagementPage.getName());
			attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
			attendanceManage.setStartTime(DateUtils.formatDate(leaveVo.getStartTime(), "yyyy-MM-dd HH:mm"));
			attendanceManage.setEndTime(DateUtils.formatDate(leaveVo.getEndTime(), "yyyy-MM-dd HH:mm"));
			// ????????????
			attendanceManage.setAbsenceDate(DateUtils.formatDate(leaveVo.getEndTime(), "yyyy-MM-dd HH:mm"));
			attendanceManage.setReviewStatus("??????");
			attendanceManage.setTotalDay(leaveVo.getTotalHour());
			attendanceManage.setType(getLeaveType(leaveVo.getType()));
			attendanceManageList.add(attendanceManage);
		}

		ComparatorAttendance compara = new ComparatorAttendance();
		Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "??????????????????(????????????)")
	@Transactional(rollbackFor = Exception.class)
	public void addAttendanceTimeSet(AttendanceTimeSetAdd recodr, User user) {
		// TODO Auto-generated method stub
		recodr.setId(UUID.randomUUID().toString());
		recodr.setCreatedTime(new Date());
		recodr.setCreatorAccount(user.getAccount());
		recodr.setModifiedTime(new Date());
		recodr.setModifierAccount(user.getAccount());
		recodr.setRecordStatus(Byte.parseByte(AttendanceManageStatusEnums.SIGN_NORMAL.getCode()));
		attendanceTimeSetMapper.insertBatch(recodr);
	}

	@Override
	@ServiceLog(doAction = "??????????????????(????????????)")
	@Transactional(rollbackFor = Exception.class)
	public void updateAttendanceTimeSet(AttendanceTimeSetAdd record, User user) {
		TbManpowerAttendanceTimeSet tbManpowerAttendanceTimeSet = new TbManpowerAttendanceTimeSet();
		record.setModifiedTime(new Date());
		record.setModifierAccount(user.getAccount());
		BeanUtils.copyProperties(record, tbManpowerAttendanceTimeSet);
		tbManpowerAttendanceTimeSet.setWorkAttendanceTime(record.getWorkAttendanceTime());
		tbManpowerAttendanceTimeSet.setDutyAttendanceTime(record.getDutyAttendanceTime());
		tbManpowerAttendanceTimeSetMapper.updateByPrimaryKeySelective(tbManpowerAttendanceTimeSet);
	}

	@Override
	@ServiceLog(doAction = "??????????????????(????????????)")
	@Transactional(rollbackFor = Exception.class)
	public void deleteAttendanceTimeSet(AttendanceTimeSetAdd attendanceTimeSetAdd) {
		// tbManpowerAttendanceTimeSetMapper.deleteByPrimaryKey(attendanceTimeSetAdd.getId());
		attendanceTimeSetMapper.updateByStatus(attendanceTimeSetAdd);
	}

	@Override
	@ServiceLog(doAction = "????????????")
	public PaginationData<List<AttendanceSchedulVo>> scheduDetailistPage(AttendanceSchedulPage attendanceSchedulPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(attendanceSchedulPage.getPage(), attendanceSchedulPage.getRows());
		List<AttendanceSchedulVo> attendanceList = attendanceSchedulMapper.selectBySchedulMonth(attendanceSchedulPage);
		PaginationData<List<AttendanceSchedulVo>> pageList = new PaginationData(attendanceList, objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String importScheduDetailist(MultipartFile file, User user) {
		if (file.isEmpty()) {
			logger.warn("[????????????]???????????????????????????");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.FILE_EMPTY);
		}
		AttendanceSchedulAdd attendanceSchedul = new AttendanceSchedulAdd();
		List<Object> resultList = ExcelUtil.readExcel(file, attendanceSchedul, 1, 1);
		if (CollectionUtils.isEmpty(resultList)) {
			return "???????????????????????????";
		}

		int i = 0;
		StringBuffer sb = new StringBuffer();
		List<AttendanceSchedulAdd> list = new ArrayList<AttendanceSchedulAdd>();
		TbManpowerEmployeeBasicInfo tbManpowerEmployeeBasicInfo = new TbManpowerEmployeeBasicInfo();
		Map<String,TbManpowerEmployeeBasicInfo> basicMap = employeeBasicInfoMapper.map(tbManpowerEmployeeBasicInfo);
		AttendanceSchedulPage attendanceSchedulPage = new AttendanceSchedulPage();
		for (Object result : resultList) {
			i++;
			AttendanceSchedulAdd schedul = (AttendanceSchedulAdd) result;
			String str = checkField(schedul);
			if (StringUtils.isBlank(str)) {
				sb.append("???"+i+"???:" + str + ";");
				continue;
			}
			
			TbManpowerEmployeeBasicInfo basic = basicMap.get(schedul.getJobNumber());
			if(basic == null){
				sb.append("???" +i + "???"+"|?????????????????????,?????????" + schedul.getJobNumber() + ";");
				continue;
			}
			
			if(!basic.getName().equals(schedul.getName()) || !basic.getDepartmentName().equals(schedul.getDepartmentName())){
				sb.append("???" +i + "???"+ "|???????????????????????????,?????????" + schedul.getName() + "|?????????" + schedul.getDepartmentName() + ";");
				continue;
			}
			
			AttendanceSchedulVo record  = attendanceSchedulMapper.selectByJobNumberAndMonth(schedul);
			if (record != null) {
				logger.info("[????????????]??????????????????????????????????????????");
				sb.append("???" +i + "???"+ "|????????????????????????????????????,?????????" + schedul.getJobNumber() + ",?????????" + schedul.getName() + ";");
				continue;
			}
			
			schedul.setDepartmentId(basic.getDepartmentId());
			schedul.setId(UUID.randomUUID().toString());
			schedul.setRecordStatus(Byte.parseByte(AttendanceManageStatusEnums.EFFECTIVE.getCode()));
			schedul.setCreatedTime(new Date());
			schedul.setCreatorAccount(user.getAccount());
			schedul.setModifiedTime(new Date());
			schedul.setModifierAccount(user.getAccount());
			list.add(schedul);
			i++;
		}

		if (sb.length() > 0) {
			logger.warn("[????????????] ????????????:{}", sb.toString());
			return sb.toString();
		} else {
			if (!CollectionUtils.isEmpty(list)) {
				attendanceSchedulMapper.insertBatch(list);
				logger.info("[????????????] ????????????{}?????????", list.size());
			}
			return "????????????";
		}
	}

	@Override
	@ServiceLog(doAction = "????????????????????????")
	public PaginationData<List<AttendanceSchedulVo>> scheduDetailist(AttendanceSchedulPage attendanceSchedulPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(attendanceSchedulPage.getPage(), attendanceSchedulPage.getRows());
		if (!StringUtils.isEmpty(attendanceSchedulPage.getDepartmentId())) {
			List<String> rootList = new ArrayList<String>();
			Result result = systemClient.selectDeptByParentId(attendanceSchedulPage.getDepartmentId(), true);
			if (result == null || !"0000".equals(result.getCode()) || result.getData() == null) {
				throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
			}
			HashMap<String, Object> childMap = (HashMap<String, Object>) result.getData();
			rootList.add((String) childMap.get("id"));
			if (childMap.get("children") != null) {
				List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
				getChildrenDepartment(rootList, childrenSub);
			}
			attendanceSchedulPage.setDepartmentIds(rootList);
		}
		List<AttendanceSchedulVo> attendanceList = attendanceSchedulMapper.list(attendanceSchedulPage);
		PaginationData<List<AttendanceSchedulVo>> pageList = new PaginationData(attendanceList, objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "????????????????????????")
	public PaginationData<List<AttendanceSchedulVo>> exportScheduDetailist(
			AttendanceSchedulPage attendanceSchedulPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(attendanceSchedulPage.getPage(), attendanceSchedulPage.getRows());
		List<AttendanceSchedulVo> attendanceList = attendanceSchedulMapper.list(attendanceSchedulPage);
		PaginationData<List<AttendanceSchedulVo>> pageList = new PaginationData(attendanceList, objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	@Transactional(rollbackFor = Exception.class)
	public void updateScheduDetailist(List<AttendanceSchedulPage> records, User user) {
		for (AttendanceSchedulPage attendanceSchedul : records) {
			attendanceSchedul.setModifiedTime(new Date());
			attendanceSchedul.setModifierAccount(user.getAccount());
			TbManpowerAttendanceSchedul TbManpowerAttendanceSchedul = new TbManpowerAttendanceSchedul();
			BeanUtils.copyProperties(attendanceSchedul, TbManpowerAttendanceSchedul);
			attendanceSchedulMapper.updateByPrimaryKeySelective(TbManpowerAttendanceSchedul);
		}
	}

	@Override
	@ServiceLog(doAction = "??????????????????")
	public PaginationData<List<AttendanceManagementVo>> exportAttendanceManagement(
			AttendanceManagementPage attendanceManagementPage) {
		Page<Object> objects = PageHelper.startPage(attendanceManagementPage.getPage(),
				attendanceManagementPage.getRows());
		List<AttendanceManagementVo> attendanceList = attendanceManagementMapper.list(attendanceManagementPage);
		PaginationData<List<AttendanceManagementVo>> pageList = new PaginationData(attendanceList, objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "??????????????????(????????????)")
	public List<AttendanceTimeSetVo> AttendanceTimeSetList() {
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		List<AttendanceTimeSetVo> timeSetList = attendanceTimeSetMapper.list(attendanceTimeSetPage);
		return timeSetList;
	}

	private String checkField(AttendanceSchedulAdd schedul) {

		if (schedul == null) {
			return "????????????????????????";
		}

		if (StringUtils.isBlank(schedul.getSchedulMonth())) {
			return "????????????????????????";
		}

		if (StringUtils.isBlank(schedul.getDepartmentId())) {
			return "??????ID????????????";
		}

		if (StringUtils.isBlank(schedul.getDepartmentName())) {
			return "??????????????????";
		}

		if (StringUtils.isBlank(schedul.getJobNumber())) {
			return "??????????????????";
		}

		if (StringUtils.isBlank(schedul.getName())) {
			return "??????????????????";
		}

		return "";
	}

	@Override
	@ServiceLog(doAction = "????????????id???????????????????????????")
	public AttendanceManageApiVo selectAttendanceManagementByDepartmentId(
			AttendanceManagement attendanceManagement) {
		AttendanceManageApiVo attendanceObject = new AttendanceManageApiVo();
		List<AttendanceManageObject> attendancemanageList = new ArrayList<AttendanceManageObject>();
		EmployeeBasicInfoPage employeeBasicInfoPage = new EmployeeBasicInfoPage();
		if (!StringUtils.isEmpty(attendanceManagement.getDepartmentId())) {
			List<String> rootList = new ArrayList<String>();
			Result result = systemClient.selectDeptByParentId(attendanceManagement.getDepartmentId(), true);
			if (result == null || !"0000".equals(result.getCode()) || result.getData() == null) {
				throw new JnSpringCloudException(HrExceptionEnums.DEPARTMENT_QUERY_ERRPR);
			}
			HashMap<String, Object> childMap = (HashMap<String, Object>) result.getData();
			rootList.add((String) childMap.get("id"));
			if (childMap.get("children") != null) {
				List<HashMap<String, Object>> childrenSub = (List<HashMap<String, Object>>) childMap.get("children");
				getChildrenDepartment(rootList, childrenSub);
			}
			employeeBasicInfoPage.setDepartmentIds(rootList);
		}
		List<EmployeeBasicInfo> basicList = employeeBasicInfoMapper.list(employeeBasicInfoPage);
		attendanceObject.setTotalNumber(basicList.size());
		// integer
		// ??????
		AttendanceManageObject comeLateAttendanceManage = new AttendanceManageObject();
		comeLateAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(comeLateAttendanceManage);
		// ??????
		AttendanceManageObject leaveEarlyAttendanceManage = new AttendanceManageObject();
		leaveEarlyAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(leaveEarlyAttendanceManage);
		// ??????
		AttendanceManageObject notCardAttendanceManage = new AttendanceManageObject();
		notCardAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(notCardAttendanceManage);
		// ??????
		AttendanceManageObject absenceAttendanceManage = new AttendanceManageObject();
		absenceAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(absenceAttendanceManage);
		// ??????
		AttendanceManageObject overTimeAttendanceManage = new AttendanceManageObject();
		overTimeAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(overTimeAttendanceManage);
		// ??????
		AttendanceManageObject leaveAttendanceManage = new AttendanceManageObject();
		leaveAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(leaveAttendanceManage);

		comeLateAttendanceManage.setAttendanceType(AttendanceManageTypeEnums.COME_LATE.getCode());

		notCardAttendanceManage.setAttendanceType(AttendanceManageTypeEnums.MISS_CARD.getCode());

		absenceAttendanceManage.setAttendanceType(AttendanceManageTypeEnums.ABSENCE.getCode());

		overTimeAttendanceManage.setAttendanceType(AttendanceManageTypeEnums.OVER_TIME.getCode());

		leaveAttendanceManage.setAttendanceType(AttendanceManageTypeEnums.LEAVE.getCode());

		leaveEarlyAttendanceManage.setAttendanceType(AttendanceManageTypeEnums.LEAVE_EARLY.getCode());

		for (EmployeeBasicInfo basic : basicList) {
			attendanceManagement.setUserId(basic.getUserId());
			List<AttendanceManagementApiVo> attendanceManagementList = selectAttendanceManagementByUserId(
					attendanceManagement,basic.getUserId());
			if (attendanceManagementList.size() == 0) {
				continue;
			}
			for (AttendanceManagementApiVo attendance : attendanceManagementList) {
				attendance.setName(basic.getName());
				attendance.setDepartment(basic.getDepartmentName());
				if (attendance.getAttendanceType().equals(AttendanceManageTypeEnums.COME_LATE.getCode())
						&& attendance.getFrequency() != null && !attendance.getFrequency().equals("0")) {
					comeLateAttendanceManage.getStatusAttendanceObject().add(attendance);
				} else if (attendance.getAttendanceType().equals(AttendanceManageTypeEnums.LEAVE_EARLY.getCode())
						&& attendance.getFrequency() != null && !attendance.getFrequency().equals("0")) {
					leaveEarlyAttendanceManage.getStatusAttendanceObject().add(attendance);
				} else if (attendance.getAttendanceType().equals(AttendanceManageTypeEnums.MISS_CARD.getCode())
						&& attendance.getFrequency() != null && !attendance.getFrequency().equals("0")) {
					notCardAttendanceManage.getStatusAttendanceObject().add(attendance);
				} else if (attendance.getAttendanceType().equals(AttendanceManageTypeEnums.OVER_TIME.getCode())
						&& attendance.getFrequency() != null && !attendance.getFrequency().equals("0")) {
					overTimeAttendanceManage.getStatusAttendanceObject().add(attendance);
				} else if (attendance.getAttendanceType().equals(AttendanceManageTypeEnums.LEAVE.getCode())
						&& attendance.getFrequency() != null && !attendance.getFrequency().equals("0")) {
					leaveAttendanceManage.getStatusAttendanceObject().add(attendance);
				} else if (attendance.getAttendanceType().equals(AttendanceManageTypeEnums.ABSENCE.getCode()) 
						&& attendance.getFrequency() != null && !attendance.getFrequency().equals("0")) {
					absenceAttendanceManage.getStatusAttendanceObject().add(attendance);
				}
			}
		}

		comeLateAttendanceManage.setNumber(comeLateAttendanceManage.getStatusAttendanceObject().size());
		notCardAttendanceManage.setNumber(notCardAttendanceManage.getStatusAttendanceObject().size());
		overTimeAttendanceManage.setNumber(overTimeAttendanceManage.getStatusAttendanceObject().size());
		absenceAttendanceManage.setNumber(absenceAttendanceManage.getStatusAttendanceObject().size());
		leaveAttendanceManage.setNumber(leaveAttendanceManage.getStatusAttendanceObject().size());
		leaveEarlyAttendanceManage.setNumber(leaveEarlyAttendanceManage.getStatusAttendanceObject().size());

		attendanceObject.setAttendanceList(attendancemanageList);
		return attendanceObject;
	}

	@Override
	@ServiceLog(doAction = "????????????id???????????????????????????")
	public List<AttendanceManagementApiVo> selectAttendanceManagementByUserId(
			AttendanceManagement attendanceManagement,String userId) {
		// TODO Auto-generated method stub
		attendanceManagement.setUserId(userId);
		List<AttendanceManagementApiVo> attendanceManagementApiList = new ArrayList<AttendanceManagementApiVo>();
		Date firstDate = null;
		Date lastDate = null;
		// ?????????????????????????????????????????????????????????
		if (!StringUtils.isBlank(attendanceManagement.getAttendanceMonth())) {
			Map<String, Date> map = HrDataUtil.getFirstdayLastdayMonth(attendanceManagement.getAttendanceMonth());
			firstDate = map.get("first");
			lastDate = map.get("last");
		}
		// ????????????
		TbManpowerEmployeeBasicInfo basic = employeeBasicInfoMapper.selectByUserId(attendanceManagement.getUserId());
		if(basic == null){
			throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeBasicInfo_NOT_EXISTS);
		}
		
		AttendanceSchedulPage attendanceSchedulPage = new AttendanceSchedulPage();
		attendanceSchedulPage.setJobNumber(basic.getJobNumber());
		String schedulMonth = attendanceManagement.getAttendanceMonth().replace("-", "");
		attendanceSchedulPage.setSchedulMonth(schedulMonth);
		// ????????????????????????????????????
		List<AttendanceSchedulVo> schedulList = attendanceSchedulMapper.list(attendanceSchedulPage);
		if (schedulList == null || schedulList.size() == 0) {
			return attendanceManagementApiList;
		}
		// ???????????????????????????
		Attendance attendance = new Attendance();
		attendance.setUserId(attendanceManagement.getUserId());
		attendance.setStartTime(firstDate);
		attendance.setEndTime(lastDate);
		Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
		List<AttendanceApiVo> list = attendanceList.getData();
		if (list == null) {
			list = new ArrayList<AttendanceApiVo>();
		}
		// ???????????????????????????
		Leave leave = new Leave();
		leave.setUserId(attendanceManagement.getUserId());
		leave.setStartTime(firstDate);
		leave.setEndTime(lastDate);
		Result<List<LeaveApiVo>> leaveList = oaClient.searchLeaveListByCondition(leave);
		List<LeaveApiVo> leaveApiList = leaveList.getData();
		if (leaveApiList == null) {
			leaveApiList = new ArrayList<LeaveApiVo>();
		}
		List<AttendanceManagementApiVo> attendanceManagementList = obtainAttendanceManagementList(list,
				schedulList.get(0), leaveApiList);
		return attendanceManagementList;
	}

	// ???????????????????????????
	private List<AttendanceManagementApiVo> obtainAttendanceManagementList(List<AttendanceApiVo> list,
			AttendanceSchedulVo schedul, List<LeaveApiVo> leaveApiList) {
		// ??????
		List<AttendanceKeyValue> comeLateObject = new ArrayList<AttendanceKeyValue>();
		// ??????
		List<AttendanceKeyValue> leaveEarlyLateObject = new ArrayList<AttendanceKeyValue>();
		// ??????
		List<AttendanceKeyValue> notCardLateObject = new ArrayList<AttendanceKeyValue>();
		//????????????
		List<AttendanceKeyValue> normalLateObject = new ArrayList<AttendanceKeyValue>();
		// ???????????????
		Integer comeLateTotalTime = 0;
		// ???????????????
		Integer leaveEarlyTotalTime = 0;
		// ??????????????????
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		AttendanceTimeSetVo timeSet = attendanceTimeSetMapper.selectByAttendanceType(attendanceTimeSetPage);
		for (AttendanceApiVo attendanceVo : list) {
			AttendanceKeyValue value = new AttendanceKeyValue();
			/*???????????????????????? ????????????????????????????????????????????????*/
			if (attendanceVo.getSignInAttendanceTime() == null && attendanceVo.getSignOutAttendanceTime() != null
					&& timeSet.getWorkAttendanceTime()
							.compareTo(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm")) < 0) {
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "MM-dd") +"(" + HrDataUtil.getWeek(attendanceVo.getSignOutAttendanceTime()) + ")");
				value.setValue("????????????");
				notCardLateObject.add(value);
				continue;
			}
            /*????????????????????????  ????????????????????????????????????????????????*/
			if (attendanceVo.getSignInAttendanceTime() != null && attendanceVo.getSignOutAttendanceTime() == null
					&& timeSet.getDutyAttendanceTime()
							.compareTo(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm")) > 0) {
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "MM-dd") +"(" + HrDataUtil.getWeek(attendanceVo.getSignInAttendanceTime()) + ")");
				value.setValue("????????????");
				notCardLateObject.add(value);
				continue;
			}

			if (attendanceVo.getSignInAttendanceTime() == null || attendanceVo.getSignOutAttendanceTime() == null) {
				continue;
			}

			String inAttendanceTime = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm");
			// ????????????????????????????????????????????????
			if (inAttendanceTime.compareTo(timeSet.getDutyAttendanceTime()) > 0) {
				continue;
			}
			// ????????????
			if (inAttendanceTime.compareTo(timeSet.getWorkAttendanceTime()) > 0) {
				String outTime = "";
				if(attendanceVo.getSignOutAttendanceTime() != null){
					outTime ="-" + DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm");
				}
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "MM-dd")+"("+ HrDataUtil.getWeek(attendanceVo.getSignInAttendanceTime()) +")"+DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm") + outTime);
				comeLateTotalTime += Integer.valueOf(
						stringConversionDate(attendanceVo.getSignInAttendanceTime(), timeSet.getWorkAttendanceTime()));
				value.setValue(
						stringConversionDate(attendanceVo.getSignInAttendanceTime(), timeSet.getWorkAttendanceTime()) + "??????");
				comeLateObject.add(value);
			}

			String outAttendanceTime = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm");
			// ????????????????????????????????????????????????
			if (outAttendanceTime.compareTo(timeSet.getWorkAttendanceTime()) < 0) {
				continue;
			}
			// ????????????
			if (outAttendanceTime.compareTo(timeSet.getDutyAttendanceTime()) < 0) {
				String inTime = "";
				if(attendanceVo.getSignInAttendanceTime() != null){
					inTime = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm") + "-";
				}
				value = new AttendanceKeyValue();
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "MM-dd")+"("+HrDataUtil.getWeek(attendanceVo.getSignOutAttendanceTime()) +")"+ inTime +DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm"));
				leaveEarlyTotalTime += Integer.valueOf(
						stringConversionDate(attendanceVo.getSignOutAttendanceTime(), timeSet.getDutyAttendanceTime()));
				value.setValue(
						stringConversionDate(attendanceVo.getSignOutAttendanceTime(), timeSet.getDutyAttendanceTime()) + "??????");
				leaveEarlyLateObject.add(value);
				continue;
			}
			
			//????????????
			if(inAttendanceTime.compareTo(timeSet.getWorkAttendanceTime()) <= 0 && outAttendanceTime.compareTo(timeSet.getDutyAttendanceTime()) >= 0){
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "MM-dd")+" (" +HrDataUtil.getWeek(attendanceVo.getSignInAttendanceTime()) +")"+DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm") + "-" + DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm"));
				value.setValue("????????????");
				normalLateObject.add(value);
			}
		}

		List<AttendanceManagementApiVo> attendanceManagementList = new ArrayList<AttendanceManagementApiVo>();
		AttendanceManagementApiVo attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceSort(normalLateObject);
		attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType(AttendanceManageTypeEnums.NORMAL.getCode());
		attendanceManagementApiVo.setFrequency(String.valueOf(normalLateObject.size()));
		attendanceManagementApiVo.setTotalTime("0");
		attendanceManagementApiVo.setStatusDetailedList(normalLateObject);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		attendanceSort(comeLateObject);
		attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType(AttendanceManageTypeEnums.COME_LATE.getCode());
		attendanceManagementApiVo.setFrequency(String.valueOf(comeLateObject.size()));
		attendanceManagementApiVo.setTotalTime(String.valueOf(comeLateTotalTime) + "??????");
		attendanceManagementApiVo.setStatusDetailedList(comeLateObject);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		attendanceSort(leaveEarlyLateObject);
		attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType(AttendanceManageTypeEnums.LEAVE_EARLY.getCode());
		attendanceManagementApiVo.setFrequency(String.valueOf(leaveEarlyLateObject.size()));
		attendanceManagementApiVo.setTotalTime(String.valueOf(leaveEarlyTotalTime) + "??????");
		attendanceManagementApiVo.setStatusDetailedList(leaveEarlyLateObject);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		attendanceSort(notCardLateObject);
		attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType(AttendanceManageTypeEnums.MISS_CARD.getCode());
		attendanceManagementApiVo.setFrequency(String.valueOf(notCardLateObject.size()));
		attendanceManagementApiVo.setTotalTime("0");
		attendanceManagementApiVo.setStatusDetailedList(notCardLateObject);
		attendanceManagementList.add(attendanceManagementApiVo);

		// ??????
		attendanceManagementApiVo = obtainoverTimeObjectList(list, schedul);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		// ??????
		attendanceManagementApiVo = obtainAbsenceObjectList(list, schedul);
		attendanceManagementList.add(attendanceManagementApiVo);

		// ??????
		attendanceManagementApiVo = obtainleaveObjectList(leaveApiList);
		attendanceManagementList.add(attendanceManagementApiVo);

		return attendanceManagementList;
	}

	// ???????????????????????????
	private AttendanceManagementApiVo obtainAbsenceObjectList(List<AttendanceApiVo> list, AttendanceSchedulVo schedul) {
		// ??????
		List<AttendanceKeyValue> absenceObject = new ArrayList<AttendanceKeyValue>();
		// ??????????????????
		Map<String, Integer> map = new HashMap<String, Integer>();
		// ????????????????????????????????????
		Map<String, Integer> monthMap = schedulMonthMap(schedul);

		String key = "";
		for (AttendanceApiVo attendanceVo : list) {
			// ????????????????????????????????????
			String timeStr = "";
			if (attendanceVo.getSignInAttendanceTime() != null) {
				timeStr = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm");
				key = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "yyyyMMdd");
			} else if (attendanceVo.getSignOutAttendanceTime() != null) {
				timeStr = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm");
				key = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "yyyyMMdd");
			}
			
			map.put(key, 1);
		}
		// ?????????????????????????????????????????????
		for (String keyNumber : monthMap.keySet()) {
			if (map.get(keyNumber) == null && monthMap.get(keyNumber) != null && monthMap.get(keyNumber) == 1) {
				AttendanceKeyValue value = new AttendanceKeyValue();
				Date date = conversionDate(keyNumber);
				value.setTimeKey(DateUtils.formatDate(date, "MM-dd") + "(" +HrDataUtil.getWeek(date) + ")");
				value.setValue("??????");
				absenceObject.add(value);
			}
		}

		attendanceSort(absenceObject);
		AttendanceManagementApiVo attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType(AttendanceManageTypeEnums.ABSENCE.getCode());
		attendanceManagementApiVo.setFrequency(String.valueOf(absenceObject.size()));
		attendanceManagementApiVo.setTotalTime("0");
		attendanceManagementApiVo.setStatusDetailedList(absenceObject);
		return attendanceManagementApiVo;
	}

	
	// ??????????????????
	private AttendanceManagementApiVo obtainoverTimeObjectList(List<AttendanceApiVo> list,
			AttendanceSchedulVo schedul) {
		// ??????
		List<AttendanceKeyValue> overTimeObject = new ArrayList<AttendanceKeyValue>();
		// ??????????????????
		Map<String, AttendanceApiVo> map = new HashMap<String, AttendanceApiVo>();
		// ????????????????????????????????????
		Map<String, Integer> monthMap = schedulMonthMap(schedul);
		// ???????????????
		Long overTotalTime = 0L;
		String key = "";
		for (AttendanceApiVo attendanceVo : list) {
			// ????????????????????????????????????
			if (attendanceVo.getSignInAttendanceTime() != null && attendanceVo.getSignOutAttendanceTime() != null) {
				key = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "yyyyMMdd");
			} else {
				continue;
			}
			map.put(key, attendanceVo);
		}
		// ?????????????????????????????????????????????
		for (String keyNumber : monthMap.keySet()) {
			if (monthMap.get(keyNumber) != null && monthMap.get(keyNumber) == 0 && map.get(keyNumber) != null) {
				AttendanceKeyValue value = new AttendanceKeyValue();
				AttendanceApiVo attendanceVo = map.get(keyNumber);
				// ?????? ???????????? 13:00-14:00
				Date date = conversionDate(keyNumber);
				value.setTimeKey(DateUtils.formatDate(date, "MM-dd") + "(" + HrDataUtil.getWeek(date) + ")" + DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(), "HH:mm")
						+ "-" + DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(), "HH:mm"));
				Long overHour = HrDataUtil.betweenDates(attendanceVo.getSignInAttendanceTime(),
						attendanceVo.getSignOutAttendanceTime()) / 3600;
				value.setValue(String.valueOf(overHour) + "??????");
				overTotalTime += overHour;
				overTimeObject.add(value);
			}
		}
		
		attendanceSort(overTimeObject);
		AttendanceManagementApiVo attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType(AttendanceManageTypeEnums.OVER_TIME.getCode());
		attendanceManagementApiVo.setFrequency(String.valueOf(overTimeObject.size()));
		attendanceManagementApiVo.setTotalTime(String.valueOf(overTotalTime) + "??????");
		attendanceManagementApiVo.setStatusDetailedList(overTimeObject);
		return attendanceManagementApiVo;
	}

	// ??????????????????
	private AttendanceManagementApiVo obtainleaveObjectList(List<LeaveApiVo> list) {
		// ??????
		List<AttendanceKeyValue> leaveObject = new ArrayList<AttendanceKeyValue>();
		Double leaveTotalTime = 0.0;
		for (LeaveApiVo leaveVo : list) {
			AttendanceKeyValue attendanceKeyValue = new AttendanceKeyValue();
			attendanceKeyValue.setTimeKey(
					DateUtils.formatDate(leaveVo.getStartTime(), "yyyy-MM-dd") + "--"+ DateUtils.formatDate(leaveVo.getEndTime(), "yyyy-MM-dd")+ " " + getLeaveType(leaveVo.getType()));
			attendanceKeyValue.setValue(leaveVo.getTotalHour() + "??????");
			leaveTotalTime += Double.valueOf(leaveVo.getTotalHour());
			leaveObject.add(attendanceKeyValue);
		}

		attendanceSort(leaveObject);
		AttendanceManagementApiVo attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType(AttendanceManageTypeEnums.LEAVE.getCode());
		attendanceManagementApiVo.setFrequency(String.valueOf(leaveObject.size()));
		attendanceManagementApiVo.setTotalTime(String.valueOf(leaveTotalTime) + "??????");
		attendanceManagementApiVo.setStatusDetailedList(leaveObject);
		return attendanceManagementApiVo;
	}

	/**
	 * ??????????????????
	 *
	 */
	private void attendanceSort(List<AttendanceKeyValue> list){
		Collections.sort(list,new Comparator<AttendanceKeyValue>(){
			public int compare(AttendanceKeyValue value1,AttendanceKeyValue value2){
				int flag = value1.getTimeKey().compareTo(value2.getTimeKey());
				if(flag < 0){
					return flag;
				}else{
					return flag;
				}
			}
		});
	}
	
	@Override
	@ServiceLog(doAction = "?????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String insertByOverTimeVacationmanage(VacationManagement vacationManage) {
		VacationManageVo vacationManageVo = vacationManageAttanceMapper
				.selectByTypeAndUserId(vacationManage.getUserId(), vacationManage.getVacationType());
		if (vacationManageVo != null) {
			TbManpowerVacationManage tbManpowerVacationManage = new TbManpowerVacationManage();
			tbManpowerVacationManage.setId(vacationManageVo.getId());
			Double newTime = vacationManage.getVacationTime();
			Double time = Double.valueOf(vacationManageVo.getVacationTime());
			tbManpowerVacationManage.setVacationTime(String.valueOf(time + newTime));
			tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
		} else {
			TbManpowerVacationManage tbManpowerVacationManage = new TbManpowerVacationManage();
			TbManpowerEmployeeBasicInfo basic = employeeBasicInfoMapper.selectByUserId(vacationManage.getUserId());
			if (basic == null) {
				logger.info("?????????????????????");
				throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeBasicInfo_NOT_EXISTS);
			}
			tbManpowerVacationManage.setId(UUID.randomUUID().toString());
			tbManpowerVacationManage.setJobNumber(basic.getJobNumber());
			tbManpowerVacationManage.setUserId(vacationManage.getUserId());
			tbManpowerVacationManage.setVacationType(vacationManage.getVacationType());
			tbManpowerVacationManage.setVacationTime(String.valueOf(vacationManage.getVacationTime()));
			tbManpowerVacationManageMapper.insert(tbManpowerVacationManage);
			// vacationManageAttanceMapper.insert(vacationManageVo);
		}
		return "????????????";
	}

	@Override
	@ServiceLog(doAction = "?????????????????????????????????")
	@Transactional(rollbackFor = Exception.class)
	public String insertByLeaveVacationmanage(VacationManagement vacationManage) {
		/* ????????????????????????????????? */
		TbManpowerVacationManage tbManpowerVacationManage = new TbManpowerVacationManage();
		VacationManageVo vacationManageVo = vacationManageAttanceMapper
				.selectByTypeAndUserId(vacationManage.getUserId(), vacationManage.getVacationType());
		if (vacationManageVo == null) {
			vacationManageVo = new VacationManageVo();
			vacationManageVo.setVacationTime("0");
		}
		String timeStr = "0";
		Double newTime = Double.valueOf(vacationManage.getVacationTime());
		Double time = Double.valueOf(vacationManageVo.getVacationTime());
		if (newTime > time) {
			Map<String, VacationManageVo> map = vacationManageAttanceMapper.selectByUserId(vacationManage.getUserId());
			/* ??????????????????????????? */
			if (time != 0) {
				tbManpowerVacationManage.setId(vacationManageVo.getId());
				tbManpowerVacationManage.setVacationTime("0");
				tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
			}
			newTime -= time;
			timeStr = newTime.toString();
			/* ??????????????????????????? */
			if (!vacationManage.getVacationType().equals(AttendanceManageTypeEnums.ANNUAL_LEAVE.getCode())) {
				timeStr = updateVacationmanage(AttendanceManageTypeEnums.ANNUAL_LEAVE.getCode(), map, newTime);
				if (timeStr.equals("0")) {
					return "????????????";
				}
			}

			if (!vacationManage.getVacationType().equals(AttendanceManageTypeEnums.REVISION_REST.getCode())) {
				newTime = Double.valueOf(timeStr);
				/* ??????????????????????????? */
				timeStr = updateVacationmanage(AttendanceManageTypeEnums.REVISION_REST.getCode(), map, newTime);
				if (timeStr.equals("0")) {
					return "????????????";
				}
			}

			newTime = Double.valueOf(timeStr);
			/* ???????????? */
			tbManpowerVacationManage = new TbManpowerVacationManage();
			VacationManageVo vacation = new VacationManageVo();
			vacation = map.get(AttendanceManageTypeEnums.COMPASSIONATE_LEAVE.getCode());
			if (vacation != null) {
				tbManpowerVacationManage.setId(vacation.getId());
				tbManpowerVacationManage
						.setVacationTime(String.valueOf(Double.valueOf(vacation.getVacationTime()) + newTime));
				tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
			} else {
				TbManpowerEmployeeBasicInfo basic = employeeBasicInfoMapper.selectByUserId(vacationManage.getUserId());
				if (basic == null) {
					logger.info("?????????????????????");
					throw new JnSpringCloudException(EmployeeExceptionEnums.EmployeeBasicInfo_NOT_EXISTS);
				}
				tbManpowerVacationManage.setId(UUID.randomUUID().toString());
				tbManpowerVacationManage.setJobNumber(basic.getJobNumber());
				tbManpowerVacationManage.setUserId(vacationManage.getUserId());
				tbManpowerVacationManage.setVacationType(AttendanceManageTypeEnums.COMPASSIONATE_LEAVE.getCode());
				tbManpowerVacationManage.setVacationTime(newTime.toString());
				tbManpowerVacationManageMapper.insert(tbManpowerVacationManage);
			}

		} else {
			tbManpowerVacationManage = new TbManpowerVacationManage();
			tbManpowerVacationManage.setId(vacationManageVo.getId());
			Double vacationtime = time - newTime;
			tbManpowerVacationManage.setVacationTime(String.valueOf(vacationtime));
			tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
		}

		return "????????????";
	}

	@Override
	@ServiceLog(doAction = "????????????")
	public AttendanceOverTimeApiVo selectByUserIdAndTime(AttendanceOverTime attendanceOverTime) {
		// ??????????????????
		AttendanceOverTimeApiVo attendanceManagementApiVo = new AttendanceOverTimeApiVo();
		attendanceManagementApiVo.setUserId(attendanceOverTime.getUserId());
		attendanceManagementApiVo.setType(attendanceOverTime.getType());
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		AttendanceTimeSetVo timeSet = attendanceTimeSetMapper.selectByAttendanceType(attendanceTimeSetPage);
		String attendanceTime = DateUtils.formatDate(attendanceOverTime.getAttendanceDate(), "HH:mm");
		if (attendanceOverTime.getType().equals("1")) {
			if (attendanceTime.compareTo(timeSet.getWorkAttendanceTime()) > 0
					&& attendanceTime.compareTo(timeSet.getDutyAttendanceTime()) < 0) {
				String minute = stringConversionDate(attendanceOverTime.getAttendanceDate(),
						timeSet.getWorkAttendanceTime());
				attendanceManagementApiVo.setMinute(minute);
			} else {
				attendanceManagementApiVo.setMinute("0");
			}

		} else {
			if (attendanceTime.compareTo(timeSet.getDutyAttendanceTime()) < 0
					&& attendanceTime.compareTo(timeSet.getWorkAttendanceTime()) > 0) {
				String minute = stringConversionDate(attendanceOverTime.getAttendanceDate(),
						timeSet.getDutyAttendanceTime());
				attendanceManagementApiVo.setMinute(minute);
			} else {
				attendanceManagementApiVo.setMinute("0");
			}
		}

		return attendanceManagementApiVo;
	}

	/**
	 * ????????????????????????
	 */
	private String updateVacationmanage(String type, Map<String, VacationManageVo> map, Double newTime) {
		TbManpowerVacationManage tbManpowerVacationManage = new TbManpowerVacationManage();
		VacationManageVo vacation = new VacationManageVo();
		vacation = map.get(type);
		/* ?????????????????? ????????????0?????????????????????????????? */
		if (vacation != null) {
			tbManpowerVacationManage.setId(vacation.getId());
			Double time = Double.valueOf(vacation.getVacationTime());
			if (time >= newTime) {
				tbManpowerVacationManage.setVacationTime(String.valueOf(time - newTime));
				tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
				return "0";
			} else {
				tbManpowerVacationManage.setVacationTime("0");
				tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
				newTime -= time;
				return newTime.toString();
			}
		}
		return newTime.toString();
	}

	/**
	 * ????????????date???????????????????????????
	 */
	private String stringConversionDate(Date date, String str) {
		String strTime = DateUtils.formatDate(date, "yyyy-MM-dd") + " " + str;
		Date attendanceTime = HrDataUtil.formatConversionMinute(strTime);
		Long minute = HrDataUtil.betweenDates(date, attendanceTime) / 60;
		String minuteStr = String.valueOf(minute);
		return minuteStr;
	}

	/**
	 * ??????????????????
	 */
	private Map<String, Integer> schedulMonthMap(AttendanceSchedulVo schedul) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(schedul.getSchedulMonth() + "01", schedul.getNumber1());
		map.put(schedul.getSchedulMonth() + "02", schedul.getNumber2());
		map.put(schedul.getSchedulMonth() + "03", schedul.getNumber3());
		map.put(schedul.getSchedulMonth() + "04", schedul.getNumber4());
		map.put(schedul.getSchedulMonth() + "05", schedul.getNumber5());
		map.put(schedul.getSchedulMonth() + "06", schedul.getNumber6());
		map.put(schedul.getSchedulMonth() + "07", schedul.getNumber7());
		map.put(schedul.getSchedulMonth() + "08", schedul.getNumber8());
		map.put(schedul.getSchedulMonth() + "09", schedul.getNumber9());
		map.put(schedul.getSchedulMonth() + "10", schedul.getNumber10());
		map.put(schedul.getSchedulMonth() + "11", schedul.getNumber11());
		map.put(schedul.getSchedulMonth() + "12", schedul.getNumber12());
		map.put(schedul.getSchedulMonth() + "13", schedul.getNumber13());
		map.put(schedul.getSchedulMonth() + "14", schedul.getNumber14());
		map.put(schedul.getSchedulMonth() + "15", schedul.getNumber15());
		map.put(schedul.getSchedulMonth() + "16", schedul.getNumber16());
		map.put(schedul.getSchedulMonth() + "17", schedul.getNumber17());
		map.put(schedul.getSchedulMonth() + "18", schedul.getNumber18());
		map.put(schedul.getSchedulMonth() + "19", schedul.getNumber19());
		map.put(schedul.getSchedulMonth() + "20", schedul.getNumber20());
		map.put(schedul.getSchedulMonth() + "21", schedul.getNumber21());
		map.put(schedul.getSchedulMonth() + "22", schedul.getNumber22());
		map.put(schedul.getSchedulMonth() + "23", schedul.getNumber23());
		map.put(schedul.getSchedulMonth() + "24", schedul.getNumber24());
		map.put(schedul.getSchedulMonth() + "25", schedul.getNumber25());
		map.put(schedul.getSchedulMonth() + "26", schedul.getNumber26());
		map.put(schedul.getSchedulMonth() + "27", schedul.getNumber27());
		map.put(schedul.getSchedulMonth() + "28", schedul.getNumber28());
		map.put(schedul.getSchedulMonth() + "29", schedul.getNumber29());
		map.put(schedul.getSchedulMonth() + "30", schedul.getNumber30());
		map.put(schedul.getSchedulMonth() + "31", schedul.getNumber31());
		return map;
	}

	/**
	 * ????????????
	 */
	private String getLeaveType(String type) {

		if (type.equals("1")) {
			return "??????";
		}

		if (type.equals("2")) {
			return "??????";
		}

		if (type.equals("3")) {
			return "??????";
		}

		if (type.equals("4")) {
			return "??????";
		}

		if (type.equals("5")) {
			return "??????";
		}

		if (type.equals("6")) {
			return "??????";
		}

		if (type.equals("7")) {
			return "?????????";
		}

		if (type.equals("8")) {
			return "?????????";
		}

		if (type.equals("9")) {
			return "??????";
		}

		return "??????????????????";
	}
	
	/**
	 * ????????????
	 */
	private Date conversionDate(String dateStr){
		Date date = null;
		try {
			date = HrDataUtil.conversionDate(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
