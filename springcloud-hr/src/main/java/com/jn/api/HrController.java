package com.jn.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.hr.api.HrClient;
import com.jn.hr.attendance.service.AttendanceManagementService;
import com.jn.hr.model.AttendanceManageApiVo;
import com.jn.hr.model.AttendanceManagement;
import com.jn.hr.model.AttendanceManagementApiVo;
import com.jn.hr.model.AttendanceOverTime;
import com.jn.hr.model.AttendanceOverTimeApiVo;
import com.jn.hr.model.VacationManagement;
import com.jn.system.log.annotation.ControllerLog;

@RestController
public class HrController extends BaseController implements HrClient{
	
	private static final Logger logger = LoggerFactory.getLogger(HrController.class);
	
	@Autowired
	private AttendanceManagementService attendanceManagementService;

        @ControllerLog(doAction = "根据用户id与考勤年月查询历史考勤列表")
		public Result<List<AttendanceManagementApiVo>> selectAttendanceManagementByUserId(@Validated @RequestBody  AttendanceManagement attendanceManagement){
	    	Assert.notNull(attendanceManagement.getUserId(),"用户ID不能为空");
			Assert.notNull(attendanceManagement.getAttendanceMonth(),"考勤月份不能为空");
	    	List<AttendanceManagementApiVo> list = attendanceManagementService.selectAttendanceManagementByUserId(attendanceManagement);
			return new Result(list);
		}
	    
	    @ControllerLog(doAction = "根据部门id与考勤年月查询历史考勤列表")
		public Result<AttendanceManageApiVo> selectAttendanceManagementByDepartmentId(@Validated @RequestBody  AttendanceManagement attendanceManagement){
	    	Assert.notNull(attendanceManagement.getAttendanceMonth(),"考勤月份不能为空");
	    	AttendanceManageApiVo attendanceManage  = attendanceManagementService.selectAttendanceManagementByDepartmentId(attendanceManagement);
			return new Result(attendanceManage);
		}
	    
	    @ControllerLog(doAction = "加班小时")
		public Result<String> insertByOverTimeVacationmanage(@Validated @RequestBody  VacationManagement vacationManage){
	    	Assert.notNull(vacationManage.getUserId(),"用户ID不能为空");
			Assert.notNull(vacationManage.getVacationType(),"请假类型不能为空");
			Assert.notNull(vacationManage.getVacationTime(),"请假时间不能为空");
	    	String str = attendanceManagementService.insertByOverTimeVacationmanage(vacationManage);
			return new Result(str);
		}

	    @ControllerLog(doAction = "请假扣除请假小时")
		public Result<String> insertByLeaveVacationmanage(@Validated @RequestBody  VacationManagement vacationManage){
	    	Assert.notNull(vacationManage.getUserId(),"用户ID不能为空");
			Assert.notNull(vacationManage.getVacationType(),"请假类型不能为空");
			Assert.notNull(vacationManage.getVacationTime(),"请假时间不能为空");
	    	String str = attendanceManagementService.insertByLeaveVacationmanage(vacationManage);
			return new Result(str);
		}
	    
	    @ControllerLog(doAction = "考勤接口")
		public Result<AttendanceOverTimeApiVo> selectByUserIdAndTime(@Validated @RequestBody  AttendanceOverTime attendanceOverTime){
	    	Assert.notNull(attendanceOverTime.getUserId(),"签到人不能为空");
	    	Assert.notNull(attendanceOverTime.getType(),"签到类型不能为空");
	    	Assert.notNull(attendanceOverTime.getAttendanceDate(),"签到时间不能为空");
	    	AttendanceOverTimeApiVo attendanceOverTimeApi= attendanceManagementService.selectByUserIdAndTime(attendanceOverTime);
			return new Result(attendanceOverTimeApi);
		}
}
