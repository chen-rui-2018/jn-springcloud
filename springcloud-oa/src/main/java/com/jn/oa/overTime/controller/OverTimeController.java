package com.jn.oa.overTime.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hr.model.VacationManagement;
import com.jn.oa.attendance.vo.AttendanceResultVo;
import com.jn.oa.leave.service.LeaveService;
import com.jn.oa.overTime.service.OverTimeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 加班管理controller
 *
 * @author： yuanyy
 * @date： Created on 2019/5/22 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "加班管理")
@RestController
@RequestMapping("/oa/overtime")
public class OverTimeController extends BaseController {

    @Autowired
    private OverTimeService overTimeService;


    @ControllerLog(doAction = "加班记录新增小时")
    @ApiOperation(value = "加班记录新增小时", notes = "加班结束后，增加加班补休小时")
    @PostMapping(value = "/insertOverTime")
    @RequiresPermissions("/oa/overtime/insertOverTime")
    public Result<String> insertLeave(@Validated @RequestBody VacationManagement leave) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        leave.setUserId(user.getId());
        Result<String> data =overTimeService.insertOverTime(leave);
        return data;
    }







}
