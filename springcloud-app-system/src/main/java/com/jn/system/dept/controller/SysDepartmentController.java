package com.jn.system.dept.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.model.SysDepartment;
import com.jn.system.dept.model.SysDepartmentAdd;
import com.jn.system.dept.model.SysDepartmentCheckName;
import com.jn.system.dept.service.SysDepartmentService;
import com.jn.system.dept.vo.SysDepartmentVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @ControllerLog(doAction = "根据部门id获取部门信息及所有子部门信息")
    @RequiresPermissions("/system/sysDepartment/selectDeptByKey")
    @ApiOperation(value = "根据部门id获取部门信息及所有子部门信息",
            notes = "id为空,查所有一级部门,不为空,精确查询,flag为true查询所有子部门,false不查子部门")
    @RequestMapping(value = "/selectDeptByKey",method = RequestMethod.POST)
    public Result selectDeptByKey(@RequestParam("id")String id, @RequestParam("flag")Boolean flag) {
        Result result = sysDepartmentService.selectDeptByKey(id, flag);
        return result;
    }

    @ControllerLog(doAction = "逻辑删除部门")
    @RequiresPermissions("/system/sysDepartment/delete")
    @ApiOperation(value = "逻辑删除部门", notes = "逻辑删除部门")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(String departmentId) {
        Assert.notNull(departmentId, "部门id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysDepartmentService.delete(departmentId, user);
        return new Result();
    }

    @ControllerLog(doAction = "修改部门信息")
    @RequiresPermissions("/system/sysDepartment/update")
    @ApiOperation(value = "修改部门信息", notes = "修改部门信息")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@Validated @RequestBody SysDepartment sysDepartment) {
        Assert.notNull(sysDepartment.getId(), "部门id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysDepartmentService.update(sysDepartment, user);
        return new Result();
    }

    @ControllerLog(doAction = "添加部门")
    @RequiresPermissions("/system/sysDepartment/add")
    @ApiOperation(value = "添加部门",  notes = "添加部门")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@Validated @RequestBody SysDepartmentAdd sysDepartmentAdd) {
        Assert.notNull(sysDepartmentAdd.getParentId(), "父级id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //封装部门对象
        TbSysDepartment tbSysDepartment = new TbSysDepartment();
        BeanUtils.copyProperties(sysDepartmentAdd, tbSysDepartment);
        tbSysDepartment.setId(UUID.randomUUID().toString());
        tbSysDepartment.setCreatorAccount(user.getAccount());
        tbSysDepartment.setCreatedTime(new Date());
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysDepartment.setRecordStatus(recordStatus);
        sysDepartmentService.add(tbSysDepartment);
        return new Result();
    }

    @ControllerLog(doAction = "校验部门名称是否存在")
    @ApiOperation(value = "校验部门名称是否存在", notes = "fail表示部门名称已存在,success表示可以使用")
    @RequiresPermissions("/system/sysDepartment/checkDepartmentName")
    @RequestMapping(value = "/checkDepartmentName",method = RequestMethod.POST)
    public Result<String> checkDepartmentName(@Validated @RequestBody SysDepartmentCheckName sysDepartmentCheckName) {
        String result = sysDepartmentService.checkDepartmentName(sysDepartmentCheckName);
        return new Result(result);
    }

    @ControllerLog(doAction = "查询所有部门信息,并根据层级关系返回数据")
    @RequiresPermissions("/system/sysDepartment/findDepartmentAllByLevel")
    @ApiOperation(value = "查询所有部门信息,并根据层级关系返回数据", notes = "查询所有部门信息,并根据层级关系返回数据")
    @RequestMapping(value = "/findDepartmentAllByLevel",method = RequestMethod.POST)
    public Result<List<SysDepartmentVO>> findDepartmentAllByLevel() {
        List<SysDepartmentVO> sysDepartmentVOList = sysDepartmentService.findDepartmentAllByLevel();
        return new Result(sysDepartmentVOList);
    }

    @ControllerLog(doAction = "批量修改部门信息")
    @RequiresPermissions("/system/sysDepartment/updateDepartmentBatch")
    @ApiOperation(value = "批量更新部门信息", notes = "批量修改部门信息")
    @RequestMapping(value = "/addDepartmentBatch",method = RequestMethod.POST)
    public Result addDepartmentBatch(@Validated @RequestBody List<SysDepartment> sysDepartmentList) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysDepartmentService.addDepartmentBatch(sysDepartmentList, user);
        return new Result();
    }

    @ControllerLog(doAction = "根据父级id获取所有子部门信息")
    @RequiresPermissions("/system/sysDepartment/getChild")
    @ApiOperation(value = "根据父级id获取所有子部门信息", notes = "根据父级id获取所有子部门信息")
    @RequestMapping(value = "/getChildDepartmentByParentId",method = RequestMethod.POST)
    public Result<List<SysDepartmentVO>> getChildDepartmentByParentId(String parentId) {
        List<SysDepartmentVO> sysDepartmentVOList = sysDepartmentService.getChildDepartmentByParentId(parentId);
        return new Result(sysDepartmentVOList);
    }

}
