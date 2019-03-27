package com.jn.oa.attendance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.attendance.service.AttendanceService;
import com.jn.oa.attendance.vo.AttendanceResultVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    @PostMapping(value = "/list")
    @RequiresPermissions("/oa/attendance/list")
    public Result<AttendanceResultVo> list(@Validated @RequestBody AttendanceAdd attendance) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        attendance.setId(UUID.randomUUID().toString());
        AttendanceResultVo data =attendanceService.attendance(attendance,user);
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
    public Result<List<TbOaAttendance>> selectByUserId(@RequestParam(value = "userId") String userId) {
        Assert.notNull(userId, "用户ID不能为空");
        List<TbOaAttendance> data = attendanceService.getAttendanceByUserId(userId);
        return new Result(data);
    }



}
