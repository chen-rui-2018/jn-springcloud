package com.jn.oa.schedule.controller;

import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.oa.model.Schedule;
import com.jn.oa.schedule.model.ScheduleEdit;
import com.jn.oa.schedule.model.ScheduleQuery;
import com.jn.oa.schedule.service.ScheduleService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * 日程管理控制层
 *
 * @author： shaobao
 * @date： Created on 2019/3/22 16:05
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "日程管理")
@RestController
@RequestMapping("/oa/schedule")
public class ScheduleController implements Serializable {

    @Autowired
    private ScheduleService scheduleService;

    @ControllerLog(doAction = "添加/修改日程")
    @RequiresPermissions("/oa/schedule/addOrUpdate")
    @ApiOperation(value = "添加/修改日程", notes = "添加时不用传id,修改时必须要传id")
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public Result addOrUpdate(@Validated @RequestBody ScheduleEdit schedule) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Boolean isAdd = StringUtils.isBlank(schedule.getId());
        if (isAdd) {
            schedule.setId(UUID.randomUUID().toString());
        }
        scheduleService.addOrUpdate(schedule, isAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "(逻辑)删除日程")
    @RequiresPermissions("/oa/schedule/delete")
    @ApiOperation(value = "(逻辑)删除日程", notes = "(逻辑)删除日程")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestParam("scheduleId") String scheduleId) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        scheduleService.delete(scheduleId, user);
        return new Result();
    }

    @ControllerLog(doAction = "查询日程")
    @RequiresPermissions("/oa/schedule/list")
    @ApiOperation(value = "查询日程", notes = "查询日程")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<Schedule>> list(ScheduleQuery shceduleQuery) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        shceduleQuery.setUserAccount(user.getAccount());
        List<Schedule> scheduleList = scheduleService.list(shceduleQuery);
        return new Result(scheduleList);
    }

    @ControllerLog(doAction = "查询日程详情")
    @RequiresPermissions("/oa/schedule/getScheduleById")
    @ApiOperation(value = "查询日程详情", notes = "根据日程id查询详情")
    @RequestMapping(value = "/getScheduleById", method = RequestMethod.GET)
    public Result<Schedule> getScheduleById(String id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        return new Result(schedule);
    }
}
