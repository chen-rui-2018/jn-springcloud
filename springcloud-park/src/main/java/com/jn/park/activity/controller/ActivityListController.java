package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.model.ActivitySlimQuery;
import com.jn.park.model.ActivityTypeQuery;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = "获取前台活动列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/guest/activityListSlim")
    public Result activityListSlim(@RequestBody ActivitySlimQuery activitySlimQuery) {
        PaginationData paginationData = activityService.activityListSlim(activitySlimQuery);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表", httpMethod = "POST", response = Result.class,notes="作为活动的查询条件")
    @RequestMapping(value = "/guest/findActivityTypeList")
    public Result findActivityTypeListByState() {
        PaginationData  activityTypeList = activityTypeService.findActivityTypeListByState(new ActivityTypeQuery(),Boolean.FALSE);
        return new Result(activityTypeList);
    }


}
