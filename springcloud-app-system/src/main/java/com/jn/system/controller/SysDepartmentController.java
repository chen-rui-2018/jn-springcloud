package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.entity.TbSysDepartment;
import com.jn.system.model.*;
import com.jn.system.service.SysDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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


    @ApiOperation(value = "查询所有部门",httpMethod = "POST",response = Result.class)
    @RequestMapping("/findSysDepartmentAll")
    public Result findSysDepartmentAll(){
        return sysDepartmentService.findSysDepartmentAll();
    }


    @ApiOperation(value = "根据部门id获取部门信息",httpMethod = "POST",response = Result.class)
    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id){
        return sysDepartmentService.selectByPrimaryKey(id);
    }


    @ApiOperation(value = "逻辑删除部门",httpMethod = "POST",response = Result.class)
    @RequestMapping("/delete")
    public Result delete(String[] ids){
        Assert.noNullElements(ids,"部门id不能为空");
        sysDepartmentService.delete(ids);
        return new Result();
    }


    @ApiOperation(value = "修改部门信息",httpMethod = "POST",response = Result.class)
    @RequestMapping("/update")
    public Result update(@Validated @RequestBody SysDepartment sysDepartment){
        Assert.notNull(sysDepartment.getId(),"部门id不能为空");
        sysDepartmentService.update(sysDepartment);
        return new Result();
    }


    @ApiOperation(value = "批量添加部门",httpMethod = "POST",response = Result.class)
    @RequestMapping("/add")
    public Result add(@Validated @RequestBody SysDepartmentAdd sysDepartmentAdd){
        Assert.notNull(sysDepartmentAdd.getParentId(),"父级id不能为空");
        sysDepartmentService.add(sysDepartmentAdd);
        return new Result();
    }


    @ApiOperation(value = "条件分页查询部门信息",httpMethod = "POST",response = Result.class)
    @RequestMapping("/list")
    public Result list(@Validated @RequestBody SysDepartmentPage sysDepartmentPage){
        return sysDepartmentService.findSysDepartmentByPage(sysDepartmentPage);
    }


    @ApiOperation(value = "根据部门id获取部门具有的用户",httpMethod = "POST",response = Result.class)
    @RequestMapping("/findUserOfDepartment")
    public Result findUserOfDepartment(String departmentId){
        return sysDepartmentService.findUserOfDepartment(departmentId);
    }

    @ApiOperation(value = "条件分页查询部门具有的用户以外的用户信息",httpMethod = "POST",response = Result.class)
    @RequestMapping("/fingOtherUserByPage")
    public Result fingOtherUserByPage(@Validated @RequestBody SysDepartmentUserPage sysDepartmentUserPage){
        Assert.notNull(sysDepartmentUserPage.getDepartmentId(),"部门id不能为空");
        return sysDepartmentService.fingOtherUserByPage(sysDepartmentUserPage);
    }


    @ApiOperation(value = "为部门添加用户",httpMethod = "POST",response = Result.class)
    @RequestMapping("/addUserToDepartment")
    public Result addUserToDepartment(@Validated @RequestBody SysDepartmentUserAdd sysDepartmentUserAdd){
        Assert.notNull(sysDepartmentUserAdd.getDepartmentId(),"部门id不能为空");
        sysDepartmentService.addUserToDepartment(sysDepartmentUserAdd);
        return new Result();
    }

}
