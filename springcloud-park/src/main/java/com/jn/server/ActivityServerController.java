package com.jn.server;

import com.jn.park.activity.entity.TbActivityApply;
import com.jn.park.activity.model.Activity;
import com.jn.park.activity.model.ActivityDetail;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 活动 内部使用API接口
 * @Author: jiangyl
 * @Date: 2018/12/6 10:45
 * @Version v1.0
 * @modified By:
 */

@RestController
@RequestMapping("/api/activity")
public class ActivityServerController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityServerController.class);

    @Autowired
    private ActivityService activityService;

    private ActivityApplyService activityApplyService;

    @ControllerLog(doAction = "获取活动列表")
    @ApiOperation(value = "获取活动列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectActivityList")
    public Result selectActivityList(@RequestBody Activity activity) {
        PaginationData paginationData = activityService.selectActivityList(activity);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "获取活动详情")
    @ApiOperation(value = "获取活动详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getActivityDetailsForManage")
    public Result getActivityDetailsForManage(@RequestBody String activityId) {
        ActivityDetail activityDetailsForManage = activityService.getActivityDetailsForManage(activityId);
        return new Result(activityDetailsForManage);
    }

    @ControllerLog(doAction = "活动报名管理")
    @ApiOperation(value = "活动报名管理", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateActivityApply")
    public Result updateActivityApply(@RequestBody String activityId,String state) {
        int i = activityService.updateActivityApply(activityId, state);
        return new Result(i);
    }

    @ControllerLog(doAction = "删除草稿活动")
    @ApiOperation(value = "删除草稿活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteDraftActivity")
    public Result deleteDraftActivity(@RequestBody String activityId) {
        int i = activityService.deleteDraftActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "删除活动")
    @ApiOperation(value = "删除活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteActivity")
    public Result deleteActivity(@RequestBody String activityId) {
        int i = activityService.deleteActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "取消活动")
    @ApiOperation(value = "取消活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/cancelActivity")
    public Result cancelActivity(@RequestBody String activityId) {
        int i = activityService.cancelActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "活动报名列表")
    @ApiOperation(value = "活动报名列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/applyActivityList")
    public Result applyActivityList(@RequestBody String activityId, Page page) {
        List<TbActivityApply> applies = activityApplyService.applyActivityList(activityId, page);
        return new Result(applies);
    }
}
