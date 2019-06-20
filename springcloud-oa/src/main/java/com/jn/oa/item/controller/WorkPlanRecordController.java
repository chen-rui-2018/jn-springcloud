package com.jn.oa.item.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.oa.item.enmus.WorkPlanExceptionEnmus;
import com.jn.oa.item.entity.TbOaWorkPlanRecord;
import com.jn.oa.item.model.WorkPlanRecord;
import com.jn.oa.item.service.WorkPlanRecordService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 工作计划工作记录控制层
 *
 * @author： shaobao
 * @date： Created on 2019/3/20 14:21
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "工作计划工作记录管理")
@RestController
@RequestMapping("/oa/workPlanRecord")
public class WorkPlanRecordController extends BaseController {

    @Autowired
    private WorkPlanRecordService workPlanRecordService;

    @ControllerLog(doAction = "记录工时")
    @RequiresPermissions("/oa/workPlanRecord/addBatch")
    @ApiOperation(value = "记录工时", notes = "记录工时")
    @RequestMapping(value = "/addBatch", method = RequestMethod.POST)
    public Result addBatch(@Validated @RequestBody List<WorkPlanRecord> workPlanRecordList) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //为工作记录添加id及创建人
        for (int i = 0; i < workPlanRecordList.size(); i++) {
            WorkPlanRecord workPlanRecord = workPlanRecordList.get(i);
            workPlanRecord.setId(UUID.randomUUID().toString());
            workPlanRecord.setCreatorAccount(user.getAccount());
            //使用i排序,方便批量添加时排序问题
            workPlanRecord.setSort(i);
        }
        workPlanRecordService.addBatch(workPlanRecordList, user);
        return new Result();
    }

    @ControllerLog(doAction = "修改工作记录")
    @RequiresPermissions("/oa/workPlanRecord/update")
    @ApiOperation(value = "修改工作记录", notes = "修改工作记录")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@Validated @RequestBody WorkPlanRecord workPlanRecord) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(workPlanRecord.getId(), WorkPlanExceptionEnmus.WORKPLANRECODE_ID_NOT_NULL.getMessage());

        workPlanRecordService.update(workPlanRecord, user);
        return new Result();
    }

    @ControllerLog(doAction = "删除工作记录")
    @RequiresPermissions("/oa/workPlanRecord/delete")
    @ApiOperation(value = "删除工作记录", notes = "删除工作记录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestParam("workPlanRecordId") String workPlanRecordId) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        workPlanRecordService.delete(workPlanRecordId, user);
        return new Result();
    }

    @ControllerLog(doAction = "查看工作记录")
    @RequiresPermissions("/oa/workPlanRecord/list")
    @ApiOperation(value = "查看工作记录", notes = "查看工作记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<WorkPlanRecord>> list(@RequestParam("workPlanId") String workPlanId) {
        List<WorkPlanRecord> workPlanRecordList = workPlanRecordService.list(workPlanId);
        return new Result(workPlanRecordList);
    }
}
