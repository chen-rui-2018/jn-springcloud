package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.model.*;
import com.jn.system.service.SysDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门管理
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "部门管理")
@RestController
@RequestMapping("/system/sysDepartment")
public class SysDepartmentController extends BaseController {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @RequiresPermissions("/system/sysDepartment/findSysDepartmentAll")
    @ApiOperation(value = "查询所有部门", httpMethod = "POST", response = Result.class)
    @RequestMapping("/findSysDepartmentAll")
    public Result findSysDepartmentAll() {
        return sysDepartmentService.findSysDepartmentAll();
    }

    @RequiresPermissions("/system/sysDepartment/selectByPrimaryKey")
    @ApiOperation(value = "根据部门id获取部门信息", httpMethod = "POST", response = Result.class)
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        return sysDepartmentService.selectByPrimaryKey(id);
    }

    @RequiresPermissions("/system/sysDepartment/delete")
    @ApiOperation(value = "逻辑删除部门", httpMethod = "POST", response = Result.class)
    @RequestMapping("/delete")
    public Result delete(@Validated @RequestBody SysDepaetmentDelete sysDepaetmentDelete) {
        Assert.noNullElements(sysDepaetmentDelete.getDepartmentIds(), "部门id不能为空");
        sysDepartmentService.delete(sysDepaetmentDelete.getDepartmentIds());
        return new Result();
    }

    @RequiresPermissions("/system/sysDepartment/update")
    @ApiOperation(value = "修改部门信息", httpMethod = "POST", response = Result.class)
    @RequestMapping("/update")
    public Result update(@Validated @RequestBody SysDepartment sysDepartment) {
        Assert.notNull(sysDepartment.getId(), "部门id不能为空");
        sysDepartmentService.update(sysDepartment);
        return new Result();
    }

    @RequiresPermissions("/system/sysDepartment/add")
    @ApiOperation(value = "批量添加部门", httpMethod = "POST", response = Result.class)
    @RequestMapping("/add")
    public Result add(@Validated @RequestBody SysDepartmentAdd sysDepartmentAdd) {
        Assert.notNull(sysDepartmentAdd.getParentId(), "父级id不能为空");
        sysDepartmentService.add(sysDepartmentAdd);
        return new Result();
    }

    @RequiresPermissions("/system/sysDepartment/list")
    @ApiOperation(value = "条件分页查询部门信息", httpMethod = "POST", response = Result.class)
    @RequestMapping("/list")
    public Result list(@Validated @RequestBody SysDepartmentPage sysDepartmentPage) {
        return sysDepartmentService.findSysDepartmentByPage(sysDepartmentPage);
    }


    @RequiresPermissions("/system/sysDepartment/checkDepartmentName")
    @ApiOperation(value = "校验部门名称是否存在,false表示部门名称已存在,success表示可以使用",
            httpMethod = "POST", response = Result.class)
    @RequestMapping("/checkDepartmentName")
    public Result checkDepartmentName(String departmentName) {
        return sysDepartmentService.checkDepartmentName(departmentName);
    }


    @RequiresPermissions("/system/sysDepartment/findDepartmentAllByLevel")
    @ApiOperation(value = "查询所有部门信息,并根据层级关系返回数据", httpMethod = "POST", response = Result.class)
    @RequestMapping("/findDepartmentAllByLevel")
    public Result findDepartmentAllByLevel() {
        return sysDepartmentService.findDepartmentAllByLevel();
    }

}
