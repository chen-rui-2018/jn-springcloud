package com.jn.enterprise.data.reminder.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.data.vo.Reminder;
import com.jn.enterprise.data.vo.ReminderParam;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/4 14:39
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "数据上报-园区预警人维护")
@RestController
@RequestMapping(path = "/data/reminder")
public class ReminderController  extends BaseController {

    @ControllerLog(doAction = "数据上报-园区预警人维护-部门预警人列表")
    @GetMapping(value="/getList")
    @ApiOperation(value = "部门预警人列表", notes = "返回部门预警人列表")
    @RequiresPermissions("/finance/reminder/getList")
    public Result<PaginationData<List<Reminder>>> getList(@ModelAttribute ReminderParam reminder){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区预警人维护-预警人添加")
    @PostMapping(path="/saveReminder")
    @ApiOperation(value="预警人添加",notes = "返回成功与否")
    @ApiImplicitParams({
            @ApiImplicitParam(name="linkName",value = "预警人名称",dataType = "String",paramType = "query",example = "张三"),
            @ApiImplicitParam(name="departmentId",value = "部门ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="departmentName",value = "部门名称",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="linkAccount",value = "联系人账号",dataType = "String",paramType = "query",example = "101")
    })
    @RequiresPermissions("/finance/reminder/saveReminder")
    public Result saveReminder(String linkName,String departmentId,String linkAccount,String departmentName){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区预警人维护-作废/批量作废预警人")
    @PostMapping(path="/invalidReminder")
    @ApiOperation(value="预警人添加",notes = "返回成功与否")
    @ApiImplicitParams({
            @ApiImplicitParam(name="linkName",value = "预警人名称",dataType = "String",paramType = "query",example = "张三"),
            @ApiImplicitParam(name="departmentId",value = "部门ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="linkAccount",value = "联系人账号",dataType = "String",paramType = "query",example = "101")
    })
    @RequiresPermissions("/finance/reminder/invalidReminder")
    public Result invalidReminder(String[] linkName,String departmentId,String linkAccount){
        return new Result();
    }

}
