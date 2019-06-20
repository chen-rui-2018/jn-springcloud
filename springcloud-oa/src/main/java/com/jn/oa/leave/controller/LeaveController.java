package com.jn.oa.leave.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.hr.model.VacationManagement;
import com.jn.oa.attendance.entity.TbOaAttendance;
import com.jn.oa.attendance.model.AttendanceAdd;
import com.jn.oa.attendance.model.AttendancePage;
import com.jn.oa.attendance.service.AttendanceService;
import com.jn.oa.attendance.vo.AttendanceResultVo;
import com.jn.oa.attendance.vo.AttendanceVo;
import com.jn.oa.leave.service.LeaveService;
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
 * 请假管理controller
 *
 * @author： yuanyy
 * @date： Created on 2019/5/22 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "请假管理")
@RestController
@RequestMapping("/oa/leave")
public class LeaveController extends BaseController {

    @Autowired
    private LeaveService leaveService;


    @ControllerLog(doAction = "请假记录扣除小时")
    @ApiOperation(value = "请假记录扣除小时", notes = "请假结束后，扣除请假记录小时")
    @PostMapping(value = "/insertLeave")
    @RequiresPermissions("/oa/leave/insertLeave")
    public Result<String> insertLeave(@Validated @RequestBody VacationManagement leave) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        leave.setUserId(user.getId());
        Result<String> data =leaveService.insertByLeave(leave);
        return data;
    }







}
