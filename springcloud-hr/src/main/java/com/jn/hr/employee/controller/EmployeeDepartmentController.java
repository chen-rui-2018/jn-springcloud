package com.jn.hr.employee.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.hr.employee.model.EmployeeDepartment;
import com.jn.hr.employee.model.EmployeeDepartmentAdd;
import com.jn.hr.employee.service.EmployeeDepartmentService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-19 上午 9:07
 */
@Api(tags = "组织架构管理")
@RestController
@RequestMapping("/hr/employeeDepartment")
public class EmployeeDepartmentController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDepartmentController.class);
    @Autowired
    private EmployeeDepartmentService employeeDepartmentService;

    @ControllerLog(doAction = "添加组织架构")
    //@RequiresPermissions("/hr/employeeDepartment/addEmployeeDepartment")
    @ApiOperation(value = "添加组织架构", notes = "添加组织架构")
    @PostMapping(value = "/addEmployeeDepartment")
    public Result addEmployeeDepartment(@Validated @RequestBody EmployeeDepartmentAdd employeeDepartmentAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        EmployeeDepartment employeeDepartment=employeeDepartmentService.addEmployeeDepartment(employeeDepartmentAdd,user);
        return new Result(employeeDepartment);
    }
    @ControllerLog(doAction = "修改组织架构")
    //@RequiresPermissions("/hr/employeeDepartment/updateEmployeeDepartment")
    @ApiOperation(value = "修改组织架构", notes = "修改组织架构")
    @PostMapping(value = "/updateEmployeeDepartment")
    public Result updateResumeData(@Validated @RequestBody EmployeeDepartmentAdd employeeDepartmentAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.hasText(employeeDepartmentAdd.getDepartmentId(),"departmentId不能为空");
        employeeDepartmentService.updateEmployeeDepartment(employeeDepartmentAdd,user);
        return new Result();
    }


    @ControllerLog(doAction = "查询组织架构列表")
    //@RequiresPermissions("/hr/employeeDepartment/getEmployeeDepartments")
    @ApiOperation(value = "查询组织架构列表", notes = "查询组织架构列表")
    @GetMapping(value = "/getEmployeeDepartments")
    public Result<List<EmployeeDepartment>> getResumeDatabaseById() {
        List<EmployeeDepartment> resumeDatabase = employeeDepartmentService.getEmployeeDepartments();
        return new Result(resumeDatabase);
    }


    @ControllerLog(doAction = "删除组织架构")
    //@RequiresPermissions("/hr/employeeDepartment/deleteEmployeeDepartment")
    @ApiOperation(value = "删除组织架构", notes = "删除组织架构")
    @GetMapping(value = "/deleteEmployeeDepartment")
    public Result delete(@RequestParam("id") String departmentId) {
        Assert.hasText(departmentId,"departmentId不能为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        employeeDepartmentService.delete(departmentId, user);
        return new Result();
    }

}
