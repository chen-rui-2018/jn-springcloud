package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.ActivityQueryPaging;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 活动报名
 * @Author: yangph
 * @Date: 2018/12/6 14:03
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动报名")
@RestController
@RequestMapping(value = "/activity/activityApply")
public class ActivityApplyController extends BaseController {
    //todo:待权限系统完成添加权限注解 yangph

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityApplyController.class);

    @Autowired
    private ActivityApplyService activityApplyService;

    @ControllerLog(doAction = "快速报名")
    @ApiOperation(value = "快速报名", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/quickApply")
    public Result quickApply(@ApiParam(value = "活动id" ,required = true) @RequestParam String activityId){
        Assert.notNull(activityId,ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Result result=new Result();
        if(user ==null){
            result.setCode(ActivityExceptionEnum.NETWORK_ANOMALY.getCode());
            result.setResult(ActivityExceptionEnum.NETWORK_ANOMALY.getMessage());
            logger.info("快速报名获取用户信息失败");
            return result;
        }
        activityApplyService.quickApply(activityId,user.getAccount());
        return result;
    }

    @ControllerLog(doAction = "取消报名")
    @ApiOperation(value = "取消报名", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/cancelApply")
    public Result cancelApply(@ApiParam(value = "活动id",required = true) @RequestParam String activityId){
        Assert.notNull(activityId,ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Result result=new Result();
        if(user ==null){
            result.setCode(ActivityExceptionEnum.NETWORK_ANOMALY.getCode());
            result.setResult(ActivityExceptionEnum.NETWORK_ANOMALY.getMessage());
            logger.info("取消报名获取用户信息失败");
            return result;
        }
        activityApplyService.cancelApply(activityId,user.getAccount());
        return result;
    }
    @ControllerLog(doAction = "在线签到")
    @ApiOperation(value = "在线签到", httpMethod = "POST", response = Result.class )
    @RequestMapping(value = "/signInActivity")
    public Result signInActivity(@ApiParam(value = "活动id",required = true) @RequestParam String activityId){
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int i = activityApplyService.signInActivity(user==null?"":user.getAccount(), activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "报名人列表查看")
    @ApiOperation(value = "报名人列表查看", httpMethod = "POST", response = Result.class,
            notes = "查询条件--活动ID，关键字,分页页码及行数，不传页码行数默认查询前15条")
    @RequestMapping(value = "/activityApplyList")
    public Result activityApplyList(@RequestBody  ActivityQueryPaging activityQueryPaging){
       Assert.notNull(activityQueryPaging.getActivityId(),ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
       PaginationData activityApplyList= activityApplyService.findApplyActivityList(activityQueryPaging,Boolean.TRUE);
       return new Result(activityApplyList);
    }
}
