package com.jn.hr.archives.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.hr.archives.model.EmployeeFileClass;
import com.jn.hr.archives.model.EmployeeFileClassAdd;
import com.jn.hr.archives.model.TreeModel;
import com.jn.hr.archives.service.EmployeeFileClassService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-17 上午 10:26
 */
@Api(tags = "员工档案分类管理")
@RestController
@RequestMapping("/hr/employeeFileClass")
public class EmployeeFileClassController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFileClassController.class);
    @Autowired
    private EmployeeFileClassService employeeFileClassService;

    @ControllerLog(doAction = "添加员工档案分类")
    @RequiresPermissions("/hr/employeeFileClass/addEmployeeFileClass")
    @ApiOperation(value = "添加员工档案分类", notes = "添加员工档案分类")
    @PostMapping(value = "/addEmployeeFileClass")
    public Result addEmployeeFileClass(@Validated @RequestBody EmployeeFileClassAdd employeeFileClassAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        EmployeeFileClass fileClass=employeeFileClassService.addEmployeeFileClass(employeeFileClassAdd,user);
        return new Result(fileClass);
    }
    @ControllerLog(doAction = "修改员工档案分类")
    @RequiresPermissions("/hr/employeeFileClass/updateEmployeeFileClass")
    @ApiOperation(value = "修改员工档案分类", notes = "修改员工档案分类")
    @PostMapping(value = "/updateEmployeeFileClass")
    public Result updateResumeData(@Validated @RequestBody EmployeeFileClassAdd employeeFileClassAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.hasText(employeeFileClassAdd.getClassId(),"classId不能为空");
        employeeFileClassService.updateEmployeeFileClass(employeeFileClassAdd,user);
        return new Result();
    }


    @ControllerLog(doAction = "根据父ID查询员工档案分类")
    @RequiresPermissions("/hr/employeeFileClass/getEmployeeFileClass")
    @ApiOperation(value = "根据父ID查询员工档案分类", notes = "根据父ID查询员工档案分类")
    @GetMapping(value = "/getEmployeeFileClass")
    public Result<List<TreeModel>> getEmployeeFileClass(@RequestParam("id") String parentId) {
        Assert.hasText(parentId,"parentId不能为空");
        List<TreeModel> resumeDatabase = employeeFileClassService.getEmployeeFileClassByParentId(parentId);
        return new Result(resumeDatabase);
    }


    @ControllerLog(doAction = "删除员工档案分类")
    @RequiresPermissions("/hr/employeeFileClass/deleteEmployeeFileClass")
    @ApiOperation(value = "删除员工档案分类", notes = "删除员工档案分类")
    @GetMapping(value = "/deleteEmployeeFileClass")
    public Result delete(@RequestParam("id") String classId) {
        Assert.hasText(classId,"classId");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        employeeFileClassService.delete(classId, user);
        return new Result();
    }

    @ControllerLog(doAction = "查询员工档案分类树")
    @RequiresPermissions("/hr/employeeFileClass/getTreeList")
    @ApiOperation(value = "查询员工档案分类树", notes = "查询员工档案分类树")
    @GetMapping(value = "/getTreeList")
    public Result<List<EmployeeFileClass>> getTreeList() {
        List<TreeModel> resumeDatabase = employeeFileClassService.getAllEmployeeFileClass();
        return new Result(resumeDatabase);
    }

}
