package com.jn.hr.attendance.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
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
import com.jn.hr.attendance.enums.attendanceManageStatusEnums;
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
import com.jn.hr.common.util.ComparatorAttendance;
import com.jn.hr.common.util.HrDataUtil;
import com.jn.hr.employee.dao.DepartmentMapper;
import com.jn.hr.employee.dao.EmployeeBasicInfoMapper;
import com.jn.hr.employee.dao.TbManpowerDepartmentMapper;
import com.jn.hr.employee.entity.TbManpowerDepartment;
import com.jn.hr.employee.entity.TbManpowerEmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfo;
import com.jn.hr.employee.model.EmployeeBasicInfoPage;
import com.jn.hr.increase.enums.SalaryManagementExceptionEnums;
import com.jn.hr.model.AttendanceKeyValue;
import com.jn.hr.model.AttendanceManageApiVo;
import com.jn.hr.model.AttendanceManagement;
import com.jn.hr.model.AttendanceManagementApiVo;
import com.jn.hr.model.VacationManagement;
import com.jn.oa.api.OaClient;
import com.jn.oa.model.Attendance;
import com.jn.oa.model.Leave;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.oa.vo.LeaveApiVo;
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
	DepartmentMapper departmentMapper;
	@Autowired
	TbManpowerDepartmentMapper tbManpowerDepartmentMapper;
	@Autowired
	EmployeeBasicInfoMapper employeeBasicInfoMapper;
	@Autowired
	VacationManageAttanceMapper vacationManageAttanceMapper;
	@Autowired
	TbManpowerVacationManageMapper tbManpowerVacationManageMapper;
	
	@Override
	@ServiceLog(doAction = "考勤管理分页查询")
	public PaginationData<List<AttendanceManagementVo>> attendanceManagementList(
			AttendanceManagementPage attendanceManagementPage) {
		if(!StringUtils.isBlank(attendanceManagementPage.getDepartmentId())){
			TbManpowerDepartment department = tbManpowerDepartmentMapper.selectByPrimaryKey(attendanceManagementPage.getDepartmentId());
			attendanceManagementPage.setDepartment(department.getDepartmentName());
		}
		Page<Object> objects = PageHelper.startPage(attendanceManagementPage.getPage(),attendanceManagementPage.getRows());
		List<AttendanceManagementVo> attendanceList = attendanceManagementMapper.list(attendanceManagementPage);
		PaginationData<List<AttendanceManagementVo>> pageList = new PaginationData(attendanceList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "旷工明细")
	public List<AttendanceManagementVo> absenceDetailList(
			AttendanceManagementPage attendanceManagementPage) {
		AttendanceSchedulPage attendanceSchedulPage = new AttendanceSchedulPage();
		Date startTime = HrDataUtil.formatConversion(attendanceManagementPage.getStartTime());
		Date endTime = HrDataUtil.formatConversion(attendanceManagementPage.getEndTime());
		attendanceSchedulPage.setJobNumber(attendanceManagementPage.getJobNumber());
		attendanceSchedulPage.setStartDate(DateUtils.formatDate(startTime,"yyyyMM"));
		attendanceSchedulPage.setEndDate(DateUtils.formatDate(endTime, "yyyyMM"));
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		List<AttendanceSchedulVo> schedulList = attendanceSchedulMapper.list(attendanceSchedulPage);
		//遍历排班月份
		for(AttendanceSchedulVo schedul : schedulList){
			Map<String,Integer> monthMap = schedulMonthMap(schedul);
			Map<String,Integer> map = new HashMap<String,Integer>();
			String key = "";
			String date = "";
			//获取考勤记录
			Attendance attendance = new Attendance();
			if(StringUtils.isBlank(attendanceManagementPage.getStartTime())){
				attendanceManagementPage.setStartTime("0");
			}
			if(StringUtils.isBlank(attendanceManagementPage.getEndTime())){
				attendanceManagementPage.setEndTime("9");
			}
	        attendance.setUserId(attendanceManagementPage.getUserId());
	        Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
			List<AttendanceApiVo> list = attendanceList.getData();
			//保存打卡记录
			for(AttendanceApiVo attendanceVo : list){
				if(attendanceVo.getSignInAttendanceTime() != null){
					date = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"yyyy-MM-dd");
					key = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"yyyyMMdd");
				}else if(attendanceVo.getSignOutAttendanceTime() != null){
					date = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"yyyy-MM-dd");
					key = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"yyyyMMdd");
				}
				
				if(date.compareTo(attendanceManagementPage.getStartTime()) >= 0 && date.compareTo(attendanceManagementPage.getEndTime()) <= 0){
					map.put(key, 1);
				}
			}
			
			//根据排班明细表获取是否旷工日期
			for(String keyNumber : monthMap.keySet()){
				if(keyNumber.compareTo(DateUtils.formatDate(startTime,"yyyyMMdd")) < 0 || keyNumber.compareTo(DateUtils.formatDate(endTime, "yyyyMMdd")) > 0){
					continue;
				}
				
				if(map.get(keyNumber) == null && monthMap.get(keyNumber) != null && monthMap.get(keyNumber) == 1){
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
	@ServiceLog(doAction = "迟到明细")
	public List<AttendanceManagementVo> comeLateDetailList(
			AttendanceManagementPage attendanceManagementPage) {
		
		//获取考勤班次
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		AttendanceTimeSetVo timeSet = attendanceTimeSetMapper.selectByAttendanceType(attendanceTimeSetPage);
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		
		Attendance attendance = new Attendance();	
        if(!StringUtils.isBlank(attendanceManagementPage.getStartTime())){
        	try {
    			attendance.setStartTime(HrDataUtil.getDate(attendanceManagementPage.getStartTime()));
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        if(!StringUtils.isBlank(attendanceManagementPage.getEndTime())){
        	try {
    			attendance.setEndTime(HrDataUtil.getDate(attendanceManagementPage.getEndTime()));
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        //attendance.setDepartmentId(attendanceManagementPage.getDepartmentId());
        attendance.setUserId(attendanceManagementPage.getUserId());
        //获取考勤记录
        Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
		List<AttendanceApiVo> list = attendanceList.getData();
		if(timeSet != null){
			for(AttendanceApiVo attendanceVo : list){
				//上班时间为空
				if(attendanceVo.getSignInAttendanceTime() == null){
					continue;
				}
				String str = new String();
				str = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"HH:mm");
				//上班打卡时间大于下班考勤时间
				if(str.compareTo(timeSet.getDutyAttendanceTime()) > 0){
					continue;
				}
				
				if(str.compareTo(timeSet.getWorkAttendanceTime()) > 0){
					AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
					attendanceManage.setName(attendanceManagementPage.getName());
					attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
					attendanceManage.setSignInAttendanceTime(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"HH:mm:ss"));
					attendanceManage.setAbsenceDate(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"yyyy-MM-dd"));
					attendanceManageList.add(attendanceManage);
				}
			}
		}

		ComparatorAttendance compara = new ComparatorAttendance();
		Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "早退明细")
	public List<AttendanceManagementVo> leaveEarlyDetailList(
			AttendanceManagementPage attendanceManagementPage) {
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		//获取考勤班次时间
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		AttendanceTimeSetVo timeSet = attendanceTimeSetMapper.selectByAttendanceType(attendanceTimeSetPage);	
		Attendance attendance = new Attendance();
		 if(!StringUtils.isBlank(attendanceManagementPage.getStartTime())){
	        	try {
	    			attendance.setStartTime(HrDataUtil.getDate(attendanceManagementPage.getStartTime()));
	    		} catch (ParseException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        }
	        if(!StringUtils.isBlank(attendanceManagementPage.getEndTime())){
	        	try {
	    			attendance.setEndTime(HrDataUtil.getDate(attendanceManagementPage.getEndTime()));
	    		} catch (ParseException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        }
	        attendance.setUserId(attendanceManagementPage.getUserId());
	        //获取考勤记录
	        Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
	        List<AttendanceApiVo> list = attendanceList.getData();
	        if(timeSet != null){
				for(AttendanceApiVo attendanceVo : list){
					//下班打卡时间不存在
					if(attendanceVo.getSignOutAttendanceTime() == null){
						continue;
					}
					//下班打卡时间小于上班考勤时间
					String str = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"HH:mm");
					if(str.compareTo(timeSet.getWorkAttendanceTime()) < 0){
						continue;
					}
					if(str.compareTo(timeSet.getDutyAttendanceTime()) < 0){
						AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
						//序列号
						attendanceManage.setName(attendanceManagementPage.getName());
						attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
						attendanceManage.setSignInAttendanceTime(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"HH:mm:ss"));
						attendanceManage.setAbsenceDate(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"yyyy-MM-dd"));
						attendanceManageList.add(attendanceManage);
					}
				}
			}
	        

	    ComparatorAttendance compara = new ComparatorAttendance();
	    Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "缺卡明细")
	public List<AttendanceManagementVo> notCardDetailList(
			AttendanceManagementPage attendanceManagementPage) {
		if(StringUtils.isBlank(attendanceManagementPage.getStartTime())){
			attendanceManagementPage.setStartTime("0");
		}
		if(StringUtils.isBlank(attendanceManagementPage.getEndTime())){
			attendanceManagementPage.setEndTime("9");
		}
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		Attendance attendance = new Attendance();
        attendance.setUserId(attendanceManagementPage.getUserId());
        //获取考勤记录
        Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
		List<AttendanceApiVo> list = attendanceList.getData();
		for(AttendanceApiVo attendanceVo : list){
			if(attendanceVo.getSignInAttendanceTime() == null && attendanceVo.getSignOutAttendanceTime() != null){
				String date = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"yyyy-MM-dd");
				//根据时间范围过滤
				if(date.compareTo(attendanceManagementPage.getStartTime()) < 0 || date.compareTo(attendanceManagementPage.getEndTime()) > 0){
					continue;
				}
				AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
				//序列号
				attendanceManage.setName(attendanceManagementPage.getName());
				attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
				attendanceManage.setAbsenceDate(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"yyyy-MM-dd"));
				attendanceManage.setWorkStatus("上班缺卡");
				attendanceManageList.add(attendanceManage);
			}
			
			if(attendanceVo.getSignOutAttendanceTime() == null && attendanceVo.getSignInAttendanceTime() != null){
				String date = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"yyyy-MM-dd");
				//根据时间范围进行过滤
				if(date.compareTo(attendanceManagementPage.getStartTime()) < 0 || date.compareTo(attendanceManagementPage.getEndTime()) > 0){
					continue;
				}
				AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
				//序列号
				attendanceManage.setName(attendanceManagementPage.getName());
				attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
				attendanceManage.setAbsenceDate(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"yyyy-MM-dd"));
				attendanceManage.setWorkStatus("下班缺卡");
				attendanceManageList.add(attendanceManage);
			}
		}
	
		ComparatorAttendance compara = new ComparatorAttendance();
		Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "请假明细")
	public List<AttendanceManagementVo> leaveDetailist(
			AttendanceManagementPage attendanceManagementPage) {
		//获取考勤信息
		List<AttendanceManagementVo> attendanceManageList = new ArrayList<AttendanceManagementVo>();
		Leave leave = new Leave();
		leave.setUserId(attendanceManagementPage.getUserId());
		if(!StringUtils.isBlank(attendanceManagementPage.getStartTime())){
			try {
				leave.setStartTime(HrDataUtil.getDate(attendanceManagementPage.getStartTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!StringUtils.isBlank(attendanceManagementPage.getEndTime())){
			try {
				leave.setEndTime(HrDataUtil.getDate(attendanceManagementPage.getEndTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Result<List<LeaveApiVo>> leaveList = oaClient.searchLeaveListByCondition(leave);
		List<LeaveApiVo> list = leaveList.getData();
		for(LeaveApiVo leaveVo : list){
			AttendanceManagementVo attendanceManage = new AttendanceManagementVo();
			attendanceManage.setName(attendanceManagementPage.getName());
			attendanceManage.setDepartment(attendanceManagementPage.getDepartment());
			attendanceManage.setStartTime(DateUtils.formatDate(leaveVo.getStartTime(),"yyyy-MM-dd HH:mm"));
			attendanceManage.setEndTime(DateUtils.formatDate(leaveVo.getEndTime(),"yyyy-MM-dd HH:mm"));
			//用于排序
			attendanceManage.setAbsenceDate(DateUtils.formatDate(leaveVo.getEndTime(),"yyyy-MM-dd HH:mm"));
			attendanceManage.setReviewStatus("通过");
			attendanceManage.setTotalDay(leaveVo.getTotalHour());
			attendanceManage.setType(getLeaveType(leaveVo.getType()));
			attendanceManageList.add(attendanceManage);
		}

		ComparatorAttendance compara = new ComparatorAttendance();
		Collections.sort(attendanceManageList, compara);
		return attendanceManageList;
	}

	@Override
	@ServiceLog(doAction = "考勤时间设定(添加班次)")
	public void addAttendanceTimeSet(AttendanceTimeSetAdd recodr,User user) {
		// TODO Auto-generated method stub
		recodr.setId(UUID.randomUUID().toString());
		recodr.setCreatedTime(new Date());
		recodr.setCreatorAccount(user.getAccount());
		recodr.setModifiedTime(new Date());
		recodr.setModifierAccount(user.getAccount());
		recodr.setRecordStatus(Byte.parseByte(attendanceManageStatusEnums.SIGN_NORMAL.getCode()));
		attendanceTimeSetMapper.insertBatch(recodr);
	}

	@Override
	@ServiceLog(doAction = "考勤时间设定(修改班次)")
	public void updateAttendanceTimeSet(AttendanceTimeSetAdd record,User user) {
		TbManpowerAttendanceTimeSet tbManpowerAttendanceTimeSet = new TbManpowerAttendanceTimeSet();
		record.setModifiedTime(new Date());
		record.setModifierAccount(user.getAccount());
		BeanUtils.copyProperties(record,tbManpowerAttendanceTimeSet);
		tbManpowerAttendanceTimeSet.setWorkAttendanceTime(record.getWorkAttendanceTime());
		tbManpowerAttendanceTimeSet.setDutyAttendanceTime(record.getDutyAttendanceTime());
		tbManpowerAttendanceTimeSetMapper.updateByPrimaryKeySelective(tbManpowerAttendanceTimeSet);
	}

	@Override
	@ServiceLog(doAction = "考勤时间设定(删除班次)")
	public void deleteAttendanceTimeSet(AttendanceTimeSetAdd attendanceTimeSetAdd) {
		//tbManpowerAttendanceTimeSetMapper.deleteByPrimaryKey(attendanceTimeSetAdd.getId());
		attendanceTimeSetMapper.updateByStatus(attendanceTimeSetAdd);
	}

	@Override
	@ServiceLog(doAction = "排班管理")
	public PaginationData<List<AttendanceSchedulVo>> scheduDetailistPage(
			AttendanceSchedulPage attendanceSchedulPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(attendanceSchedulPage.getPage(),attendanceSchedulPage.getRows());
		List<AttendanceSchedulVo> attendanceList = attendanceSchedulMapper.selectBySchedulMonth(attendanceSchedulPage);
		PaginationData<List<AttendanceSchedulVo>> pageList = new PaginationData(attendanceList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "导入排班管理")
	public String importScheduDetailist(MultipartFile file, User user) {
		if(file.isEmpty()){
			logger.warn("[排班管理]文件为空，导入失败");
			throw new JnSpringCloudException(SalaryManagementExceptionEnums.FILE_EMPTY);
		}
		AttendanceSchedulAdd attendanceSchedul = new AttendanceSchedulAdd();
		List<Object> resultList=ExcelUtil.readExcel(file, attendanceSchedul, 1, 1);
		if(CollectionUtils.isEmpty(resultList)){
            return "没有数据，导入失败";
        }
		
		int i = 0;
		StringBuffer sb=new StringBuffer();
		List<AttendanceSchedulAdd> list = new ArrayList<AttendanceSchedulAdd>();
		TbManpowerDepartment tbManpowerDepartment = new TbManpowerDepartment();
		Map<String,TbManpowerDepartment> departmengtMap= departmentMapper.selectByDepartmentName(tbManpowerDepartment);
		for(Object result : resultList){
			AttendanceSchedulAdd schedul = (AttendanceSchedulAdd)result;
			String str = checkField(schedul);
			if(StringUtils.isBlank(str)){
				sb.append("第i行:"+str+";");
				i++;
                continue;
			}
			AttendanceSchedulVo record = attendanceSchedulMapper.selectByJobNumberAndMonth(schedul);
			if(record != null){
				logger.info("[排班管理]该员工本月已经存在排班记录！");
				continue;
			}
			TbManpowerDepartment department = departmengtMap.get(schedul.getDepartmentName());
			schedul.setDepartmentId(department.getDepartmentId());
			schedul.setId(UUID.randomUUID().toString());
			schedul.setRecordStatus(Byte.parseByte(attendanceManageStatusEnums.EFFECTIVE.getCode()));
			schedul.setCreatedTime(new Date());
			schedul.setCreatorAccount(user.getAccount());
			schedul.setModifiedTime(new Date());
			schedul.setModifierAccount(user.getAccount());
			list.add(schedul);
			i++;
		}
		
		if(!CollectionUtils.isEmpty(list)){
            attendanceSchedulMapper.insertBatch(list);
            logger.info("[排班管理] 成功导入{}条数据",list.size());
        }
        if(sb.length()>0){
            logger.warn("[排班管理] 导入失败:{}",sb.toString());
            return sb.toString();
        }else{
            return "导入成功";
        }
	}

	@Override
	@ServiceLog(doAction = "排班管理明细页面")
	public PaginationData<List<AttendanceSchedulVo>> scheduDetailist(AttendanceSchedulPage attendanceSchedulPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(attendanceSchedulPage.getPage(),attendanceSchedulPage.getRows());
		List<AttendanceSchedulVo> attendanceList = attendanceSchedulMapper.list(attendanceSchedulPage);
		PaginationData<List<AttendanceSchedulVo>> pageList = new PaginationData(attendanceList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "导出排班明细管理")
	public PaginationData<List<AttendanceSchedulVo>> exportScheduDetailist(
			AttendanceSchedulPage attendanceSchedulPage) {
		// TODO Auto-generated method stub
		Page<Object> objects = PageHelper.startPage(attendanceSchedulPage.getPage(),attendanceSchedulPage.getRows());
		List<AttendanceSchedulVo> attendanceList = attendanceSchedulMapper.list(attendanceSchedulPage);
		PaginationData<List<AttendanceSchedulVo>> pageList = new PaginationData(attendanceList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "更新排班管理")
	public void updateScheduDetailist(List<AttendanceSchedulPage> records,User user) {
		for(AttendanceSchedulPage attendanceSchedul : records){
			attendanceSchedul.setModifiedTime(new Date());
			attendanceSchedul.setModifierAccount(user.getAccount());
			TbManpowerAttendanceSchedul TbManpowerAttendanceSchedul = new TbManpowerAttendanceSchedul();
			BeanUtils.copyProperties(attendanceSchedul,TbManpowerAttendanceSchedul);
			attendanceSchedulMapper.updateByPrimaryKeySelective(TbManpowerAttendanceSchedul);
		}
	}

	@Override
	@ServiceLog(doAction = "导出考勤管理")
	public PaginationData<List<AttendanceManagementVo>> exportAttendanceManagement(
			AttendanceManagementPage attendanceManagementPage) {
		Page<Object> objects = PageHelper.startPage(attendanceManagementPage.getPage(),attendanceManagementPage.getRows());
		List<AttendanceManagementVo> attendanceList = attendanceManagementMapper.list(attendanceManagementPage);
		PaginationData<List<AttendanceManagementVo>> pageList = new PaginationData(attendanceList,objects.getTotal());
		return pageList;
	}

	@Override
	@ServiceLog(doAction = "考勤时间设定(查询班次)")
	public List<AttendanceTimeSetVo> AttendanceTimeSetList() {
		AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
		List<AttendanceTimeSetVo> timeSetList = attendanceTimeSetMapper.list(attendanceTimeSetPage);
		return timeSetList;
	}
	
	private String checkField(AttendanceSchedulAdd schedul){
		
		if(schedul == null){
			return "排班管理对象为空";
		}
		
		if(StringUtils.isBlank(schedul.getSchedulMonth())){
			return "排班月份不能为空";
		}
		
		if(StringUtils.isBlank(schedul.getDepartmentId())){
			return "部门ID不能为空";
		}
		
		if(StringUtils.isBlank(schedul.getDepartmentName())){
			return "部门不能为空";
		}
		
		if(StringUtils.isBlank(schedul.getJobNumber())){
			return "工号不能为空";
		}
		
		if(StringUtils.isBlank(schedul.getName())){
			return "姓名不能为空";
		}
		
		return "";
	}
	
	@Override
	@ServiceLog(doAction = "根据部门id与年月获取考勤信息")
	public List<AttendanceManageApiVo> selectAttendanceManagementByDepartmentId(AttendanceManagement attendanceManagement) {
		Assert.notNull(attendanceManagement.getAttendanceMonth(),"考勤月份不能为空");
		List<AttendanceManageApiVo> attendancemanageList = new ArrayList<AttendanceManageApiVo>();
		EmployeeBasicInfoPage employeeBasicInfoPage = new EmployeeBasicInfoPage();
		employeeBasicInfoPage.setDepartmentId(attendanceManagement.getDepartmentId());
		List<EmployeeBasicInfo> basicList = employeeBasicInfoMapper.list(employeeBasicInfoPage);
		Integer totalNumber = basicList.size();
		//integer 
		//迟到
		AttendanceManageApiVo comeLateAttendanceManage = new AttendanceManageApiVo();
		comeLateAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(comeLateAttendanceManage);
		//早退
		AttendanceManageApiVo leaveEarlyAttendanceManage = new AttendanceManageApiVo();
		leaveEarlyAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(leaveEarlyAttendanceManage);
		//缺卡
		AttendanceManageApiVo notCardAttendanceManage = new AttendanceManageApiVo();
		notCardAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(notCardAttendanceManage);
		//旷工
		AttendanceManageApiVo absenceAttendanceManage = new AttendanceManageApiVo();
		absenceAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(absenceAttendanceManage);
		//加班
		AttendanceManageApiVo overTimeAttendanceManage = new AttendanceManageApiVo();
		overTimeAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(overTimeAttendanceManage);
		//请假
		AttendanceManageApiVo leaveAttendanceManage = new AttendanceManageApiVo();
		leaveAttendanceManage.setStatusAttendanceObject(new ArrayList<AttendanceManagementApiVo>());
		attendancemanageList.add(leaveAttendanceManage);
		
		comeLateAttendanceManage.setTotalNumber(totalNumber);
		comeLateAttendanceManage.setAttendanceType("迟到");
		comeLateAttendanceManage.setNumber(comeLateAttendanceManage.getStatusAttendanceObject().size());
		
		notCardAttendanceManage.setTotalNumber(totalNumber);
		notCardAttendanceManage.setAttendanceType("缺卡");
		notCardAttendanceManage.setNumber(notCardAttendanceManage.getStatusAttendanceObject().size());
		
		absenceAttendanceManage.setTotalNumber(totalNumber);
		absenceAttendanceManage.setAttendanceType("旷工");
		absenceAttendanceManage.setNumber(absenceAttendanceManage.getStatusAttendanceObject().size());
		
		overTimeAttendanceManage.setTotalNumber(totalNumber);
		overTimeAttendanceManage.setAttendanceType("加班");
		overTimeAttendanceManage.setNumber(overTimeAttendanceManage.getStatusAttendanceObject().size());
		
		leaveAttendanceManage.setTotalNumber(totalNumber);
		leaveAttendanceManage.setAttendanceType("请假");
		leaveAttendanceManage.setNumber(leaveAttendanceManage.getStatusAttendanceObject().size());
		
		leaveEarlyAttendanceManage.setTotalNumber(totalNumber);
		leaveEarlyAttendanceManage.setAttendanceType("早退");
		leaveEarlyAttendanceManage.setNumber(leaveEarlyAttendanceManage.getStatusAttendanceObject().size());
		for(EmployeeBasicInfo basic : basicList){
			attendanceManagement.setUserId(basic.getUserId());
			List<AttendanceManagementApiVo> attendanceManagementList = selectAttendanceManagementByUserId(attendanceManagement);
			for(AttendanceManagementApiVo attendance : attendanceManagementList){
				attendance.setUserId(basic.getUserId());
				attendance.setDepartment(basic.getDepartmentName());
				if(attendance.getAttendanceType().equals("迟到") && attendance.getFrequency() != null && !attendance.getFrequency().equals("0")){
					comeLateAttendanceManage.getStatusAttendanceObject().add(attendance);
				}else if(attendance.getAttendanceType().equals("早退") && attendance.getFrequency() != null && !attendance.getFrequency().equals("0")){
					leaveEarlyAttendanceManage.getStatusAttendanceObject().add(attendance);
				}else if(attendance.getAttendanceType().equals("缺卡") && attendance.getFrequency() != null && !attendance.getFrequency().equals("0")){
					notCardAttendanceManage.getStatusAttendanceObject().add(attendance);
				}else if(attendance.getAttendanceType().equals("加班") && attendance.getFrequency() != null && !attendance.getFrequency().equals("0")){
					overTimeAttendanceManage.getStatusAttendanceObject().add(attendance);
				}else if(attendance.getAttendanceType().equals("旷工") && attendance.getFrequency() != null && !attendance.getFrequency().equals("0")){
					absenceAttendanceManage.getStatusAttendanceObject().add(attendance);
				}else if(attendance.getFrequency() != null && !attendance.getFrequency().equals("0")){
					leaveAttendanceManage.getStatusAttendanceObject().add(attendance);
				}
			}
		}
		return attendancemanageList;
	}
	
	@Override
	@ServiceLog(doAction = "根据用户id与年月获取考勤信息")
	public List<AttendanceManagementApiVo> selectAttendanceManagementByUserId(AttendanceManagement attendanceManagement) {
		// TODO Auto-generated method stub
		Assert.notNull(attendanceManagement.getUserId(),"用户ID不能为空");
		Assert.notNull(attendanceManagement.getAttendanceMonth(),"考勤月份不能为空");
		Date firstDate = null;
		Date lastDate = null;
		//获取该月份第一天的时间与最后一天的日期
		if(StringUtils.isBlank(attendanceManagement.getAttendanceMonth())){
			Map<String,Date> map = HrDataUtil.getFirstdayLastdayMonth(attendanceManagement.getAttendanceMonth());
			firstDate = map.get("first");
			lastDate = map.get("last");
		}
		//获取工号
		TbManpowerEmployeeBasicInfo basic = employeeBasicInfoMapper.selectByUserId(attendanceManagement.getUserId());
		AttendanceSchedulPage attendanceSchedulPage = new AttendanceSchedulPage();
		attendanceSchedulPage.setJobNumber(basic.getJobNumber());
		String schedulMonth = attendanceManagement.getAttendanceMonth().replace("-", "");
		attendanceSchedulPage.setSchedulMonth(schedulMonth);
		//获取用户该月份的排班情况
		List<AttendanceSchedulVo> schedulList = attendanceSchedulMapper.list(attendanceSchedulPage);
		
		//获取该月的考勤记录
		Attendance attendance = new Attendance();
		attendance.setUserId(attendanceManagement.getUserId());
		attendance.setStartTime(firstDate);
		attendance.setEndTime(lastDate);
		Result<List<AttendanceApiVo>> attendanceList = oaClient.selectAttendanceListByCondition(attendance);
        List<AttendanceApiVo> list = attendanceList.getData();
        //获取该月的请假信息
        Leave leave = new Leave();
		leave.setUserId(attendanceManagement.getUserId());
		leave.setStartTime(firstDate);
		leave.setEndTime(lastDate);
		Result<List<LeaveApiVo>> leaveList = oaClient.searchLeaveListByCondition(leave);
		List<LeaveApiVo> leaveApiList = leaveList.getData();
        List<AttendanceManagementApiVo> attendanceManagementList =  obtainAttendanceManagementList(list,schedulList.get(0),leaveApiList);
		return attendanceManagementList;
	}
	
	//获取该月的考勤信息
	private List<AttendanceManagementApiVo> obtainAttendanceManagementList(List<AttendanceApiVo> list,AttendanceSchedulVo schedul,List<LeaveApiVo> leaveApiList){
        //迟到
        List<AttendanceKeyValue> comeLateObject = new ArrayList<AttendanceKeyValue>();
        //早退
        List<AttendanceKeyValue> leaveEarlyLateObject = new ArrayList<AttendanceKeyValue>();
        //缺卡
        List<AttendanceKeyValue> notCardLateObject = new ArrayList<AttendanceKeyValue>();
        //迟到总时长
        Integer comeLateTotalTime = 0;
        //早退总时长
        Integer leaveEarlyTotalTime = 0;
        //获取考勤班次
      	AttendanceTimeSetPage attendanceTimeSetPage = new AttendanceTimeSetPage();
      	AttendanceTimeSetVo timeSet = attendanceTimeSetMapper.selectByAttendanceType(attendanceTimeSetPage);
		for(AttendanceApiVo attendanceVo : list){
			AttendanceKeyValue value = new AttendanceKeyValue();
			//缺卡统计
			if(attendanceVo.getSignInAttendanceTime() == null || attendanceVo.getSignOutAttendanceTime() != null){
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"MM-dd"));
				value.setValue("上班缺卡");
				notCardLateObject.add(value);
				continue;
			}
			
			if(attendanceVo.getSignInAttendanceTime() != null || attendanceVo.getSignOutAttendanceTime() == null){
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"MM-dd"));
				value.setValue("下班缺卡");
				notCardLateObject.add(value);
				continue;
			}
			
			if(attendanceVo.getSignInAttendanceTime() == null || attendanceVo.getSignOutAttendanceTime() == null){
				continue;
			}
			
			String inAttendanceTime = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"HH:mm");
			//上班打开时间不能大于考勤下班时间
			if(inAttendanceTime.compareTo(timeSet.getDutyAttendanceTime()) > 0){
				continue;
			}
			//迟到统计
			if(inAttendanceTime.compareTo(timeSet.getWorkAttendanceTime()) > 0){
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"MM-dd HH:mm"));
				comeLateTotalTime += Integer.valueOf(stringConversionDate(attendanceVo.getSignInAttendanceTime(),timeSet.getWorkAttendanceTime()));
				value.setValue(stringConversionDate(attendanceVo.getSignInAttendanceTime(),timeSet.getWorkAttendanceTime()));
				comeLateObject.add(value);
			}
			
			String outAttendanceTime = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"HH:mm");
			//下班打卡时间不能小于考勤上班时间
			if(outAttendanceTime.compareTo(timeSet.getWorkAttendanceTime()) < 0){
				continue;
			}
			//早退统计
			if(outAttendanceTime.compareTo(timeSet.getDutyAttendanceTime()) < 0){
				value.setTimeKey(DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"MM-dd HH:mm"));
				leaveEarlyTotalTime += Integer.valueOf(stringConversionDate(attendanceVo.getSignOutAttendanceTime(),timeSet.getDutyAttendanceTime()));
				value.setValue(stringConversionDate(attendanceVo.getSignOutAttendanceTime(),timeSet.getDutyAttendanceTime()));
				leaveEarlyLateObject.add(value);
			}			
		}
		
		List<AttendanceManagementApiVo> attendanceManagementList = new ArrayList<AttendanceManagementApiVo>();
		AttendanceManagementApiVo attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType("缺卡");
		attendanceManagementApiVo.setFrequency(String.valueOf(notCardLateObject.size()));
		attendanceManagementApiVo.setStatusDetailedList(notCardLateObject);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType("迟到");
		attendanceManagementApiVo.setFrequency(String.valueOf(notCardLateObject.size()));
		attendanceManagementApiVo.setTotalTime(String.valueOf(comeLateTotalTime));
		attendanceManagementApiVo.setStatusDetailedList(comeLateObject);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType("早退");
		attendanceManagementApiVo.setFrequency(String.valueOf(leaveEarlyLateObject.size()));
		attendanceManagementApiVo.setTotalTime(String.valueOf(leaveEarlyTotalTime));
		attendanceManagementApiVo.setStatusDetailedList(leaveEarlyLateObject);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		//旷工
		attendanceManagementApiVo = obtainAbsenceObjectList(list,schedul);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		//加班
		attendanceManagementApiVo = obtainoverTimeObjectList(list,schedul);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		//请假
		attendanceManagementApiVo = obtainleaveObjectList(leaveApiList);
		attendanceManagementList.add(attendanceManagementApiVo);
		
		return attendanceManagementList;
	}
	
	//获取当月的旷工情况
	private AttendanceManagementApiVo obtainAbsenceObjectList(List<AttendanceApiVo> list,AttendanceSchedulVo schedul){
		//旷工
        List<AttendanceKeyValue> absenceObject = new ArrayList<AttendanceKeyValue>();
        //保存考勤记录
      	Map<String,Integer> map = new HashMap<String,Integer>();
        //获取该月份每日的排班情况
        Map<String,Integer> monthMap = schedulMonthMap(schedul);
        
      	String key = "";
        for(AttendanceApiVo attendanceVo : list){
        	//考勤统计用户计算旷工日期
			if(attendanceVo.getSignInAttendanceTime() != null){
				key = DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"yyyyMMdd");
			}else if(attendanceVo.getSignOutAttendanceTime() != null){
				key = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"yyyyMMdd");
			}
			map.put(key, 1);
        }
       //根据排班明细表获取是否旷工日期
        for(String keyNumber : monthMap.keySet()){
  			if(map.get(keyNumber) == null && monthMap.get(keyNumber) != null && monthMap.get(keyNumber) == 1){
  				AttendanceKeyValue value = new AttendanceKeyValue();
  				value.setTimeKey(keyNumber);
  				value.setValue("旷工");
  				absenceObject.add(value);
  			}
  		}
        
        AttendanceManagementApiVo attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType("旷工");
		attendanceManagementApiVo.setFrequency(String.valueOf(absenceObject.size()));
		attendanceManagementApiVo.setStatusDetailedList(absenceObject);
		return attendanceManagementApiVo;
	}
	
	//获取加班记录
	private AttendanceManagementApiVo obtainoverTimeObjectList(List<AttendanceApiVo> list,AttendanceSchedulVo schedul){
		//加班
        List<AttendanceKeyValue> overTimeObject = new ArrayList<AttendanceKeyValue>();
        //保存考勤记录
      	Map<String,AttendanceApiVo> map = new HashMap<String,AttendanceApiVo>();
        //获取该月份每日的排班情况
        Map<String,Integer> monthMap = schedulMonthMap(schedul);
        //加班总时长
        Long overTotalTime = 0L;
        String key = "";
        for(AttendanceApiVo attendanceVo : list){
        	//考勤统计用户计算旷工日期
			if(attendanceVo.getSignInAttendanceTime() != null && attendanceVo.getSignOutAttendanceTime() != null){
				key = DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"yyyyMMdd");
			}else{
				continue;
			}
			//Long overHour = HrDataUtil.betweenDates(attendanceVo.getSignInAttendanceTime(),attendanceVo.getSignOutAttendanceTime()) / 3600;
			map.put(key, attendanceVo);
        }
       //根据排班明细表获取是否周末加班
        for(String keyNumber : monthMap.keySet()){
  			if(monthMap.get(keyNumber) != null && monthMap.get(keyNumber) == 0 && map.get(keyNumber) != null){
  				AttendanceKeyValue value = new AttendanceKeyValue();
  				AttendanceApiVo attendanceVo = new AttendanceApiVo();
  				attendanceVo = map.get(keyNumber);
  				//格式 加班日期 13:00-14:00
  				value.setTimeKey(keyNumber + DateUtils.formatDate(attendanceVo.getSignInAttendanceTime(),"HH:mm") + "-" + DateUtils.formatDate(attendanceVo.getSignOutAttendanceTime(),"HH:mm"));
  				Long overHour = HrDataUtil.betweenDates(attendanceVo.getSignInAttendanceTime(),attendanceVo.getSignOutAttendanceTime()) / 3600;
  				value.setValue(String.valueOf(overHour));
  				overTotalTime += overHour;
  				overTimeObject.add(value);
  			}
  		}
        AttendanceManagementApiVo attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType("加班");
		attendanceManagementApiVo.setFrequency(String.valueOf(overTimeObject.size()));
		attendanceManagementApiVo.setTotalTime(String.valueOf(overTotalTime));
		attendanceManagementApiVo.setStatusDetailedList(overTimeObject);
        return attendanceManagementApiVo;
	}
	
	//获取请假记录
	private AttendanceManagementApiVo obtainleaveObjectList(List<LeaveApiVo> list){
		//请假
        List<AttendanceKeyValue> leaveObject = new ArrayList<AttendanceKeyValue>();
        Integer leaveTotalTime = 0;
		for(LeaveApiVo leaveVo : list){
			AttendanceKeyValue attendanceKeyValue = new AttendanceKeyValue();
			attendanceKeyValue.setTimeKey(DateUtils.formatDate(leaveVo.getStartTime(),"MM-dd") + " "+ getLeaveType(leaveVo.getType()));
			attendanceKeyValue.setValue(leaveVo.getTotalHour());
			leaveTotalTime += Integer.valueOf(leaveVo.getTotalHour());
			leaveObject.add(attendanceKeyValue);
		}
		
		AttendanceManagementApiVo attendanceManagementApiVo = new AttendanceManagementApiVo();
		attendanceManagementApiVo.setAttendanceType("请假");
		attendanceManagementApiVo.setFrequency(String.valueOf(leaveObject.size()));
		attendanceManagementApiVo.setTotalTime(String.valueOf(leaveTotalTime));
		attendanceManagementApiVo.setStatusDetailedList(leaveObject);	
		return attendanceManagementApiVo;
	}
	
	//获取相差的分钟数
	private String stringConversionDate(Date date,String str){
		String strTime = DateUtils.formatDate(date,"yyyy-MM-dd") +" "+ str;
		Date attendanceTime = HrDataUtil.formatConversionMinute(strTime);
		Long minute = HrDataUtil.betweenDates(date, attendanceTime) / 60;
		String minuteStr = String.valueOf(minute);
		return minuteStr;
	}
	
	@Override
	@ServiceLog(doAction = "加班小时的接口")
	public String insertByOverTimeVacationmanage(VacationManagement vacationManage) {	
		Assert.notNull(vacationManage.getUserId(),"用户ID不能为空");
		Assert.notNull(vacationManage.getVacationType(),"请假类型不能为空");
		Assert.notNull(vacationManage.getVacationTime(),"请假时间不能为空");
		VacationManageVo vacationManageVo = vacationManageAttanceMapper.selectByTypeAndUserId(vacationManage.getUserId(),vacationManage.getVacationType());
		if(vacationManageVo != null){
			TbManpowerVacationManage tbManpowerVacationManage = new TbManpowerVacationManage();
			tbManpowerVacationManage.setId(vacationManageVo.getId());
			Integer newTime = Integer.valueOf(vacationManage.getVacationTime());
			Integer time = Integer.valueOf(vacationManageVo.getVacationTime());
			tbManpowerVacationManage.setVacationTime(String.valueOf(time + newTime));
			tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
		}else{
			vacationManageVo  = new VacationManageVo();
			TbManpowerEmployeeBasicInfo basic = employeeBasicInfoMapper.selectByUserId(vacationManage.getUserId());
			if(basic == null){
				return "请求失败-用户基本信息不存在";
			}
			vacationManageVo.setId(UUID.randomUUID().toString());
			vacationManageVo.setJobNumber(basic.getJobNumber());
			vacationManageVo.setUserId(vacationManage.getUserId());
			vacationManageVo.setVacationType(vacationManage.getVacationType());
			vacationManageVo.setVacationTime(vacationManage.getVacationTime());
			vacationManageAttanceMapper.insert(vacationManageVo);
		}
		return "请求成功";
	}

	@Override
	@ServiceLog(doAction = "请假扣除请假小时的接口")
	public String insertByLeaveVacationmanage(VacationManagement vacationManage) {
		// TODO Auto-generated method stub
		Assert.notNull(vacationManage.getUserId(),"用户ID不能为空");
		Assert.notNull(vacationManage.getVacationType(),"请假类型不能为空");
		Assert.notNull(vacationManage.getVacationTime(),"请假时间不能为空");
		VacationManageVo vacationManageVo = vacationManageAttanceMapper.selectByTypeAndUserId(vacationManage.getUserId(),vacationManage.getVacationType());
		
		TbManpowerVacationManage tbManpowerVacationManage = new TbManpowerVacationManage();
		tbManpowerVacationManage.setId(vacationManageVo.getId());
		Integer newTime = Integer.valueOf(vacationManage.getVacationTime());
		Integer time = Integer.valueOf(vacationManageVo.getVacationTime());
		tbManpowerVacationManage.setVacationTime(String.valueOf(time - newTime));
		tbManpowerVacationManageMapper.updateByPrimaryKeySelective(tbManpowerVacationManage);
		return "请求成功";
	}
	private Map<String,Integer> schedulMonthMap(AttendanceSchedulVo schedul){
		Map<String,Integer> map = new HashMap<String,Integer>();
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

	//获取请假类型
	private String getLeaveType(String type){
			
			if(type.equals("1")){
				return "年假";
			}
			
			if(type.equals("2")){
				return "补休";
			}
			
			if(type.equals("3")){
				return "事假";
			}
			
			if(type.equals("4")){
				return "病假";
			}
			
			if(type.equals("5")){
				return "婚假";
			}
			
			if(type.equals("6")){
				return "产假";
			}
			
			if(type.equals("7")){
				return "陪产假";
			}
			
			if(type.equals("8")){
				return "工伤假";
			}
			
			if(type.equals("9")){
				return "丧假";
			}
			
			return "类型获取失败";
		}
}
