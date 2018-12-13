package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityLikeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //todo:待权限系统完成添加权限注解
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityLikeController.class);

    @Autowired
    private ActivityLikeService activityLikeService;

    @ControllerLog(doAction = "活动点赞")
    @ApiOperation(value = "活动点赞", httpMethod = "POST", response = Result.class,notes = "id:活动id")
    @RequestMapping(value = "/activityLike")
    public Result activityLike(String id){
        Assert.notNull(id,"活动id不为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String account=user.getAccount();
        activityLikeService.activityLike(id,account);
        return new Result();
    }

    @ControllerLog(doAction = "取消点赞")
    @ApiOperation(value = "取消点赞", httpMethod = "POST", response = Result.class,notes = "id:活动id")
    @RequestMapping(value = "/cancelLike")
    public Result cancelLike(String id){
        Assert.notNull(id,"活动id不为空");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String account=user.getAccount();
        activityLikeService.cancelLike(id,account);
        return new Result();
    }
}
