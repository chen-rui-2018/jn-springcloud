package com.jn.hr.employee.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.hr.employee.model.EmployeeRelationsConfirmParam;
import com.jn.hr.employee.model.EmployeeRelationsPositiveParam;
import com.jn.hr.employee.model.EmployeeRelationsQuitParam;
import com.jn.hr.employee.model.EmployeeRelationsRetireParam;
import com.jn.hr.employee.service.EmployeeRelationsService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工关系视图层
 *
 * @author： wzy
 * @date： Created on 2019/6/11 20:14
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "人力资源-员工关系")
@RestController
@RequestMapping("/hr/employeeRelations")
public class EmployeeRelationsController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRelationsController.class);

    @Autowired
    private EmployeeRelationsService employeeRelationsService;

    @ControllerLog(doAction = "员工关系-转正管理（更新员工为正式员工）")
    @ApiOperation(value = "员工关系-转正管理（更新员工为正式员工）",notes = "员工关系-转正管理（更新员工为正式员工）")
    @RequestMapping(value = "/updateBecomeStatus",method = RequestMethod.POST)
    @RequiresPermissions("/hr/employeeRelations/updateBecomeStatus")
    public Result updateBecomeStatus(@RequestBody @Validated EmployeeRelationsPositiveParam employeeRelationsPositiveParam){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(employeeRelationsPositiveParam.getId(),"员工ID不能为空");
        return employeeRelationsService.updateBecomeStatus(employeeRelationsPositiveParam,user);
    }

    @ControllerLog(doAction = "员工关系-退休管理（更新员工状态为退休）")
    @ApiOperation(value = "员工关系-退休管理（更新员工状态为退休）",notes = "员工关系-退休管理（更新员工状态为退休）")
    @RequestMapping(value = "/updateRetireStatus",method = RequestMethod.POST)
    @RequiresPermissions("/hr/employeeRelations/updateRetireStatus")
    public Result updateRetireStatus(@RequestBody @Validated EmployeeRelationsRetireParam employeeRelationsRetireParam){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(employeeRelationsRetireParam.getId(),"员工ID不能为空");
        return employeeRelationsService.updateRetireStatus(employeeRelationsRetireParam,user);
    }

    @ControllerLog(doAction = "员工关系-离职管理（更新员工状态为离职）")
    @ApiOperation(value = "员工关系-离职管理（更新员工状态为离职）",notes = "员工关系-离职管理（更新员工状态为离职）")
    @RequestMapping(value = "/updateQuitStatus",method = RequestMethod.POST)
    @RequiresPermissions("/hr/employeeRelations/updateQuitStatus")
    public Result updateQuitStatus(@RequestBody @Validated EmployeeRelationsQuitParam employeeRelationsQuitParam){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(employeeRelationsQuitParam.getId(),"员工ID不能为空");
        return employeeRelationsService.updateQuitStatus(employeeRelationsQuitParam,user);
    }

    @ControllerLog(doAction = "员工关系-入职管理（确认入职&发送邀请）")
    @ApiOperation(value = "员工关系-入职管理（确认入职&发送邀请）",notes = "员工关系-入职管理（确认入职&发送邀请）")
    @RequestMapping(value = "/confirmationAdmis",method = RequestMethod.POST)
    @RequiresPermissions("/hr/employeeRelations/confirmationAdmis")
    public Result confirmationAdmis(@RequestBody @Validated EmployeeRelationsConfirmParam employeeRelationsConfirmParam){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(employeeRelationsConfirmParam.getId(),"员工ID不能为空");
        return employeeRelationsService.confirmationAdmis(employeeRelationsConfirmParam,user);
    }



}
