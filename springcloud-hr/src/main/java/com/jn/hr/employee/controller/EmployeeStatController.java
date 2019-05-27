package com.jn.hr.employee.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hr.employee.model.KeyValue;
import com.jn.hr.employee.service.EmployeeStatService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-25 上午 10:17
 */
@Api(tags = "员工统计")
@RestController
@RequestMapping("/hr/employeeStat")
public class EmployeeStatController extends BaseController {
    @Autowired
    EmployeeStatService employeeStatService;

    @ControllerLog(doAction = "在职员工类型分布")
    @RequiresPermissions("/hr/employeeStat/statByEmployeeType")
    @ApiOperation(value = "在职员工类型分布", notes = "在职员工类型分布")
    @GetMapping(value = "/statByEmployeeType")
    public Result statByEmployeeType(@RequestParam("departmentId") String departmentId) {
        List<KeyValue> list= employeeStatService.statByEmployeeType(departmentId);
        return new Result(list);
    }

    @ControllerLog(doAction = "在职员工司龄分布")
    @RequiresPermissions("/hr/employeeStat/statByEmployeeCompanyDate")
    @ApiOperation(value = "在职员工司龄分布", notes = "在职员工司龄分布")
    @GetMapping(value = "/statByEmployeeCompanyDate")
    public Result statByEmployeeCompanyDate(@RequestParam("departmentId") String departmentId) {
        List<KeyValue> list= employeeStatService.statByEmployeeCompanyDate(departmentId);
        return new Result(list);
    }

    @ControllerLog(doAction = "在职员工职级分布")
    @RequiresPermissions("/hr/employeeStat/statByEmployeePostName")
    @ApiOperation(value = "在职员工职级分布", notes = "在职员工职级分布")
    @GetMapping(value = "/statByEmployeePostName")
    public Result statByEmployeePostName(@RequestParam("departmentId") String departmentId) {
        List<KeyValue> list= employeeStatService.statByEmployeePostName(departmentId);
        return new Result(list);
    }


    @ControllerLog(doAction = "在职员工性别分布")
    @RequiresPermissions("/hr/employeeStat/statByEmployeeSex")
    @ApiOperation(value = "在职员工性别分布", notes = "在职员工性别分布")
    @GetMapping(value = "/statByEmployeeSex")
    public Result statByEmployeeSex(@RequestParam("departmentId") String departmentId) {
        List<KeyValue> list= employeeStatService.statByEmployeeSex(departmentId);
        return new Result(list);
    }

    @ControllerLog(doAction = "在职员工学历分布")
    @RequiresPermissions("/hr/employeeStat/statByEmployeeAcademic")
    @ApiOperation(value = "在职员工学历分布", notes = "在职员工学历分布")
    @GetMapping(value = "/statByEmployeeAcademic")
    public Result statByEmployeeAcademic(@RequestParam("departmentId") String departmentId) {
        List<KeyValue> list= employeeStatService.statByEmployeeAcademic(departmentId);
        return new Result(list);
    }

    @ControllerLog(doAction = "在职员工年龄分布")
    @RequiresPermissions("/hr/employeeStat/statByEmployeeAge")
    @ApiOperation(value = "在职员工年龄分布", notes = "在职员工年龄分布")
    @GetMapping(value = "/statByEmployeeAge")
    public Result statByEmployeeAge(@RequestParam("departmentId") String departmentId) {
        List<KeyValue> list= employeeStatService.statByEmployeeAge(departmentId);
        return new Result(list);
    }

    @ControllerLog(doAction = "部门人数统计排名")
    @RequiresPermissions("/hr/employeeStat/statByEmployeeDepartment")
    @ApiOperation(value = "部门人数统计排名", notes = "部门人数统计排名")
    @GetMapping(value = "/statByEmployeeDepartment")
    public Result statByEmployeeDepartment(@RequestParam("departmentId") String departmentId) {
        List<KeyValue> list= employeeStatService.statByEmployeeDepartment(departmentId);
        return new Result(list);
    }

}
