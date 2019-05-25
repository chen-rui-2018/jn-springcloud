package com.jn.hr.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jn.common.model.Result;
import com.jn.hr.model.AttendanceManageApiVo;
import com.jn.hr.model.AttendanceManagement;
import com.jn.hr.model.AttendanceManagementApiVo;
import com.jn.hr.model.VacationManagement;

/**
 * oa系统客户端
 *
 * @author： yuanyy
 * @date： Created on 2019/3/7 18:04
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-hr")
public interface HrClient {

   /* @RequestMapping(value = "/api/hr/notices", method = RequestMethod.POST)
    Result<String> noticesApplicationMeeting();*/
	@RequestMapping(value={"/api/hr/insertByLeaveVacationmanage"}, method={RequestMethod.POST})
    public  Result<String> insertByLeaveVacationmanage(@RequestBody  VacationManagement vacationManagement);
	
	@RequestMapping(value={"/api/hr/insertByOverTimeVacationmanage"}, method={RequestMethod.POST})
    public  Result<String> insertByOverTimeVacationmanage(@RequestBody  VacationManagement vacationManagement);
	
	@RequestMapping(value={"/api/hr/selectAttendanceManagementByUserId"}, method={RequestMethod.POST})
	public Result<List<AttendanceManagementApiVo>> selectAttendanceManagementByUserId(@RequestBody  AttendanceManagement attendanceManagement);
	
	@RequestMapping(value={"/api/hr/selectAttendanceManagementByDepartmentId"}, method={RequestMethod.POST})
    public  Result<List<AttendanceManageApiVo>> selectAttendanceManagementByDepartmentId(@RequestBody  AttendanceManagement attendanceManagement);
	
	@RequestMapping(value={"/api/hr/selectByUserIdAndTime"}, method={RequestMethod.POST})
	public Result<AttendanceManagementApiVo> selectByUserIdAndTime(@RequestBody  AttendanceManagement attendanceManagement);
}
