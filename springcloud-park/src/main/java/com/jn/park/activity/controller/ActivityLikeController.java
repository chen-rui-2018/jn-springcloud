package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityLikeService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 活动点赞
 * @Author: yangph
 * @Date: 2018/12/7 9:23
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动点赞")
@RestController
@RequestMapping(value = "/activity/activityLike")
public class ActivityLikeController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityLikeController.class);

    @Autowired
    private ActivityLikeService activityLikeService;

    @ControllerLog(doAction = "活动点赞")
    @RequiresPermissions("/activity/activityLike/activityLike")
    @ApiOperation(value = "活动点赞")
    @RequestMapping(value = "/activityLike")
    public Result activityLike(@ApiParam(value = "活动id" ,required = true) @RequestParam(value = "activityId") String activityId){
        Assert.notNull(activityId,ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String account="";
        if(user !=null && user.getAccount()!=null){
            account=user.getAccount();
        }
        activityLikeService.activityLike(activityId,account);
        return new Result();
    }

    @ControllerLog(doAction = "取消点赞")
    @RequiresPermissions("/activity/activityLike/cancelLike")
    @ApiOperation(value = "取消点赞")
    @RequestMapping(value = "/cancelLike")
    public Result cancelLike(@ApiParam(value = "活动id" ,required = true) @RequestParam(value = "activityId") String activityId){
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String account="";
        if(user !=null && user.getAccount()!=null){
            account=user.getAccount();
        }
        activityLikeService.cancelLike(activityId,account);
        return new Result();
    }
}
