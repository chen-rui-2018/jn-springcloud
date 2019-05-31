package com.jn.oa.attendance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.hr.model.*;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.attendance.model.AttendanceLocation;
import com.jn.oa.attendance.model.AttendancePage;
import com.jn.oa.attendance.service.AttendanceService;
import com.jn.oa.attendance.vo.AttendanceResultVo;
import com.jn.oa.attendance.vo.AttendanceVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 考勤管理controller
 *
 * @author： yuanyy
 * @date： Created on 2019/3/22 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "考勤管理")
@RestController
@RequestMapping("/oa/attendance")
public class AttendanceController extends BaseController {

    @Autowired
    private AttendanceService attendanceService;


    @ControllerLog(doAction = "考勤签到/签退")
    @ApiOperation(value = "考勤签到/签退", notes = "考勤类型：1：签到，2:签退")
    @PostMapping(value = "/attendance")
    @RequiresPermissions("/oa/attendance/attendance")
    public Result<AttendanceResultVo> attendance(@Validated @RequestBody AttendanceAdd attendance, HttpServletRequest request) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //获取客户端请求ip地址
        attendance.setAttendanceIp(request.getRemoteAddr());
        AttendanceResultVo data =attendanceService.attendance(attendance,user);
        return new Result(data);
    }

    @ControllerLog(doAction = "考勤列表")
    @ApiOperation(value = "考勤列表", notes = "分页根据条件查询考勤列表")
    @PostMapping(value = "/list")
    @RequiresPermissions("/oa/attendance/list")
    public Result<PaginationData<List<AttendanceVo>> > list(@Validated @RequestBody AttendancePage attendance) {
        PaginationData data =attendanceService.selectAttendanceListByCondition(attendance);
        return new Result(data);
    }


    @ControllerLog(doAction = "根据ID查询考勤详情")
    @ApiOperation(value = "根据ID查询考勤详情",notes = "根据ID查询考勤详情")
    @GetMapping(value = "/selectById")
    @RequiresPermissions("/oa/attendance/selectById")
    public Result<TbOaAttendance> selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "考勤ID不能为空");
        TbOaAttendance data = attendanceService.getAttendanceById(id);
        return new Result(data);
    }


    @ControllerLog(doAction = "根据用户ID查询考勤详情")
    @ApiOperation(value = "根据用户ID查询考勤详情",notes = "根据用户ID查询考勤详情")
    @GetMapping(value = "/selectByUserId")
    @RequiresPermissions("/oa/attendance/selectByUserId")
    public Result<List<AttendanceVo>> selectByUserId(@RequestParam(value = "userId") String userId) {
        Assert.notNull(userId, "用户ID不能为空");
        List<AttendanceVo> data = attendanceService.getAttendanceByUserId(userId);
        return new Result(data);
    }

    @ControllerLog(doAction = "根据用户ID查询当天考勤详情")
    @ApiOperation(value = "根据用户ID查询当天考勤详情",notes = "根据用户ID查询当天考勤详情")
    @GetMapping(value = "/selectByUserIdAndCurrentDate")
    @RequiresPermissions("/oa/attendance/selectByUserIdAndCurrentDate")
    public Result<AttendanceVo> selectByUserIdAndCurrentDate(@RequestParam(value = "userId") String userId) {
        Assert.notNull(userId, "用户ID不能为空");
        AttendanceVo data = attendanceService.selectByUserIdAndCurrentDate(userId);
        return new Result(data);
    }

    @ControllerLog(doAction = "根据用户id查询用户考勤打卡数据")
    @ApiOperation(value = "根据用户id查询用户考勤打卡数据",notes = "根据用户id查询用户考勤打卡数据")
    @PostMapping(value = "/selectAttendanceManagementByUserId")
    @RequiresPermissions("/oa/attendance/selectAttendanceManagementByUserId")
    public Result<List<AttendanceManagementApiVo>> selectAttendanceManagementByUserId(@RequestBody @Validated AttendanceManagement attendanceManagement) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        attendanceManagement.setUserId(user.getId());
        Result<List<AttendanceManagementApiVo>> data = attendanceService.selectAttendanceManagementByUserId(attendanceManagement);
        return data;
    }

    @ControllerLog(doAction = "根据部门id查询部门考勤打卡数据")
    @ApiOperation(value = "根据部门id查询部门考勤打卡数据",notes = "根据部门id查询部门考勤打卡数据")
    @PostMapping(value = "/selectAttendanceManagementByDepartmentId")
    @RequiresPermissions("/oa/attendance/selectAttendanceManagementByDepartmentId")
    public  Result<AttendanceManageApiVo> selectAttendanceManagementByDepartmentId(@RequestBody @Validated  AttendanceManagement attendanceManagement) {
        Assert.notNull(attendanceManagement.getDepartmentId(), "部门ID不能为空");
        Result<AttendanceManageApiVo>data = attendanceService.selectAttendanceManagementByDepartmentId(attendanceManagement);
        return data;
    }

    @ControllerLog(doAction = "根据用户id查询用户考勤接口")
    @ApiOperation(value = "根据用户id查询用户考勤接口",notes = "根据用户id查询用户考勤接口")
    @PostMapping(value = "/selectByUserIdAndTime")
    @RequiresPermissions("/oa/attendance/selectByUserIdAndTime")
    public  Result<AttendanceOverTimeApiVo> selectByUserIdAndTime(@RequestBody @Validated AttendanceOverTime attendanceOverTime) {
        Assert.notNull(attendanceOverTime.getType(), "用户打卡类型不能为空");
        Assert.notNull(attendanceOverTime.getAttendanceDate(), "用户打卡时间不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        attendanceOverTime.setUserId(user.getId());
        Result<AttendanceOverTimeApiVo> data = attendanceService.selectByUserIdAndTime(attendanceOverTime);
        return data;
    }
    @ControllerLog(doAction = "根据经纬度查询距离与是否能进行打卡")
    @ApiOperation(value = "根据经纬度查询距离与是否能进行打卡",notes = "根据用户id查询用户考勤接口")
    @GetMapping(value = "/selectLocation")
    @RequiresPermissions("/oa/attendance/selectLocation")
    public  Result<AttendanceLocation> selectLocation(String longitude,String latitude) {
        Assert.notNull(longitude, "经度不能为空");
        Assert.notNull(latitude, "纬度不能为空");
        AttendanceLocation data = attendanceService.selectLocation(longitude,latitude);
        return new Result(data);
    }





}
