package com.jn.api;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.hr.api.HrClient;
import com.jn.hr.attendance.service.AttendanceManagementService;
import com.jn.hr.model.AttendanceManageApiVo;
import com.jn.hr.model.AttendanceManagement;
import com.jn.hr.model.AttendanceManagementApiVo;
import com.jn.hr.model.VacationManagement;
import com.jn.system.log.annotation.ControllerLog;

import io.swagger.annotations.ApiOperation;
//@Api(tags = "考核管理")
@RestController
//@RequestMapping("/api/hr")
public class HrController implements HrClient{
	
	private static final Logger logger = LoggerFactory.getLogger(HrController.class);
	
	@Autowired
	private AttendanceManagementService attendanceManagementService;

	    @ControllerLog(doAction = "根据用户id与考勤年月查询历史考勤列表")
	    @RequiresPermissions("/api/hr/selectAttendanceManagementByUserId")
		@ApiOperation(value = "根据用户id与考勤年月查询历史考勤列表", notes = "根据用户id与考勤年月查询历史考勤列表")
	    @RequestMapping(value = "/selectAttendanceManagementByUserId", method = RequestMethod.POST)
		public Result<List<AttendanceManagementApiVo>> selectAttendanceManagementByUserId(@Validated @RequestBody  AttendanceManagement attendanceManagement){
	    	Assert.notNull(attendanceManagement.getUserId(),"用户ID不能为空");
			Assert.notNull(attendanceManagement.getAttendanceMonth(),"考勤月份不能为空");
	    	List<AttendanceManagementApiVo> list = attendanceManagementService.selectAttendanceManagementByUserId(attendanceManagement);
			return new Result(list);
		}
	    
	    @ControllerLog(doAction = "根据部门id与考勤年月查询历史考勤列表")
	    @RequiresPermissions("/api/hr/selectAttendanceManagementByDepartmentId")
		@ApiOperation(value = "根据部门id与考勤年月查询历史考勤列表", notes = "根据部门id与考勤年月查询历史考勤列表")
	    @RequestMapping(value = "/selectAttendanceManagementByDepartmentId", method = RequestMethod.POST)
		public Result<List<AttendanceManageApiVo>> selectAttendanceManagementByDepartmentId(@Validated @RequestBody  AttendanceManagement attendanceManagement){
	    	Assert.notNull(attendanceManagement.getAttendanceMonth(),"考勤月份不能为空");
	    	List<AttendanceManageApiVo> list = attendanceManagementService.selectAttendanceManagementByDepartmentId(attendanceManagement);
			return new Result(list);
		}
	    
	    @ControllerLog(doAction = "加班小时")
	    @RequiresPermissions("/api/hr/insertByOverTimeVacationmanage")
		@ApiOperation(value = "加班小时", notes = "加班小时")
	    @RequestMapping(value = "/insertByOverTimeVacationmanage", method = RequestMethod.POST)
		public Result<String> insertByOverTimeVacationmanage(@Validated @RequestBody  VacationManagement vacationManage){
	    	Assert.notNull(vacationManage.getUserId(),"用户ID不能为空");
			Assert.notNull(vacationManage.getVacationType(),"请假类型不能为空");
			Assert.notNull(vacationManage.getVacationTime(),"请假时间不能为空");
	    	String str = attendanceManagementService.insertByOverTimeVacationmanage(vacationManage);
			return new Result(str);
		}
	    
	    @ControllerLog(doAction = "请假扣除请假小时")
	    @RequiresPermissions("/api/hr/insertByLeaveVacationmanage")
		@ApiOperation(value = "请假扣除请假小时", notes = "请假扣除请假小时")
	    @RequestMapping(value = "/insertByLeaveVacationmanage", method = RequestMethod.POST)
		public Result<String> insertByLeaveVacationmanage(@Validated @RequestBody  VacationManagement vacationManage){
	    	Assert.notNull(vacationManage.getUserId(),"用户ID不能为空");
			Assert.notNull(vacationManage.getVacationType(),"请假类型不能为空");
			Assert.notNull(vacationManage.getVacationTime(),"请假时间不能为空");
	    	String str = attendanceManagementService.insertByLeaveVacationmanage(vacationManage);
			return new Result(str);
		}
	    
	    @ControllerLog(doAction = "考勤接口")
	    @RequiresPermissions("/hr/AttendanceManagement/selectByUserIdAndTime")
		@ApiOperation(value = "考勤接口", notes = "考勤接口")
	    @RequestMapping(value = "/selectByUserIdAndTime", method = RequestMethod.POST)
		public Result<AttendanceManagementApiVo> selectByUserIdAndTime(@Validated @RequestBody  AttendanceManagement attendanceManagement){
	    	Assert.notNull(attendanceManagement.getUserId(),"签到人不能为空");
	    	Assert.notNull(attendanceManagement.getType(),"签到类型不能为空");
	    	Assert.notNull(attendanceManagement.getAttendanceDate(),"签到时间不能为空");
	    	AttendanceManagementApiVo attendanceManage= attendanceManagementService.selectByUserIdAndTime(attendanceManagement);
			return new Result(attendanceManage);
		}
}
