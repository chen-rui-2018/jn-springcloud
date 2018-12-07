package com.jn.server;

import com.jn.activity.model.Activity;
import com.jn.activity.service.ActivityService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 活动 内部使用API接口
 * @Author: jiangyl
 * @Date: 2018/12/6 10:45
 * @Version v1.0
 * @modified By:
 */
public class ActivityController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    private ActivityService activityService;

    @ControllerLog(doAction = "获取活动列表")
    @ApiOperation(value = "获取活动列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectActivityList")
    public Result selectActivityList(@RequestBody Activity activity) {
        return activityService.selectActivityList(activity);
    }

    @ControllerLog(doAction = "获取活动详情")
    @ApiOperation(value = "获取活动详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getActivityDetailsForManage")
    public Result getActivityDetailsForManage(@RequestBody String activityId) {
        return activityService.getActivityDetailsForManage(activityId);
    }

    @ControllerLog(doAction = "活动报名管理")
    @ApiOperation(value = "活动报名管理", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateActivityApply")
    public Result updateActivityApply(@RequestBody String activityId,String state) {
        return activityService.updateActivityApply(activityId,state);
    }

    @ControllerLog(doAction = "添加/修改活动")
    @ApiOperation(value = "添加/修改活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/insterOrUpdateActivity")
    public Result insterOrUpdateActivity(@RequestBody Activity activity) {
        return activityService.insterOrUpdateActivity(activity);
    }

    @ControllerLog(doAction = "删除草稿活动")
    @ApiOperation(value = "删除草稿活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteDraftActivity")
    public Result deleteDraftActivity(@RequestBody String activityId) {
        return activityService.deleteDraftActivity(activityId);
    }

    @ControllerLog(doAction = "删除活动")
    @ApiOperation(value = "删除活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteActivity")
    public Result deleteActivity(@RequestBody String activityId) {
        return activityService.deleteActivity(activityId);
    }

    @ControllerLog(doAction = "取消活动")
    @ApiOperation(value = "取消活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/cancelActivity")
    public Result cancelActivity(@RequestBody String activityId) {
        return activityService.cancelActivity(activityId);
    }

    @ControllerLog(doAction = "取消活动")
    @ApiOperation(value = "取消活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/cancelActivity")
    public Result applyActivityList(@RequestBody String activityId, Page page) {
        return activityService.applyActivityList(activityId,page);
    }
}
