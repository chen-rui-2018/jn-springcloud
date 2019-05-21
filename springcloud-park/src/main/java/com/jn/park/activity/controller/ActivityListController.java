package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.activity.model.*;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台活动列表和活动类型列表
 *
 * @Author: chenr
 * @Date: 2018/12/20 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "前台活动列表和活动类型列表")
@RestController
public class ActivityListController extends BaseController {
    /**
     * 日志组件
     */

    private static Logger logger = LoggerFactory.getLogger(ActivityListController.class);

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityTypeService activityTypeService;

    @ControllerLog(doAction = "获取前台活动列表")
    @ApiOperation(value = "获取前台活动列表")
    @RequestMapping(value = "/guest/activity/activityListSlim",method = RequestMethod.POST)
    public Result<PaginationData<List<ActivitySlim> >> activityListSlim(@RequestBody ActivitySlimQuery activitySlimQuery) {
        PaginationData paginationData = activityService.activityListSlim(activitySlimQuery);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表", notes="作为活动的查询条件")
    @RequestMapping(value = "/guest/activity/findActivityTypeList",method = RequestMethod.POST)
    public Result<PaginationData<List<ActivityType>>> findActivityTypeListByState() {
        PaginationData  activityTypeList = activityTypeService.findActivityTypeListByState(new ActivityTypeParam(),Boolean.FALSE);
        return new Result(activityTypeList);
    }
    @ControllerLog(doAction = "用户中心-已报名活动列表")
    @ApiOperation(value = "用户中心-已报名活动列表" ,notes = "用户中心-已报名活动列表")
    @RequiresPermissions("/activity/findActivityRegistration")
    @RequestMapping(value = "/guest/activity/findActivityRegistration",method = RequestMethod.GET)
    public Result<PaginationData<List<ActivityListApply>>> findActivityRegistration(@Validated ActivityApplyListParam query) {
        PaginationData  activityTypeList = activityService.findActivitySuccessfulRegistration(query,Boolean.TRUE);
        return new Result(activityTypeList);

    }
    @ControllerLog(doAction = "机构详情-活动资讯(活动列表)")
    @ApiOperation(value = "机构详情-活动资讯(活动列表)" ,notes = "查询活动类型为 机构活动 的活动列表,分页中的'total'值即为活动资讯总数")
    @RequestMapping(value = "/guest/activity/findOrgActivityList",method = RequestMethod.GET)
    public Result<PaginationData<List<OrgActivityShow>>> findOrgActivityList(@Validated OrgActivityParam query) {
        String activityType ="org_activity";
        PaginationData  activityTypeList = activityService.findOrgActivityList(query,activityType,Boolean.TRUE);
        return new Result(activityTypeList);

    }

}
