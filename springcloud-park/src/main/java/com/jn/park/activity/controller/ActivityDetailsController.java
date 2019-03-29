package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.activity.vo.ActivityDetailVO;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.ActivityPagingParam;
import com.jn.park.model.Comment;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 15:07
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动详情")
@RestController
public class ActivityDetailsController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityDetailsController.class);

    @Autowired
    private ActivityDetailsService activityDetailsService;

    @ControllerLog(doAction = "获取活动详情")
    @ApiOperation(value = "获取活动详情")
    @RequestMapping(value = "/guest/getActivityDetails",method = RequestMethod.POST)
    public Result<ActivityDetailVO> getActivityDetails(@ApiParam(value ="活动id",required = true,example = "f32w8***") @RequestParam(value = "activityId") String activityId){
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            Result result=new Result();
            result.setResult(ActivityExceptionEnum.NETWORK_ANOMALY.getMessage());
            result.setCode(ActivityExceptionEnum.NETWORK_ANOMALY.getCode());
            logger.warn("获取活动详情接口获取当前登录用户失败");
            return result;
        }
        ActivityDetailVO activityDetailVO=activityDetailsService.findActivityDetails(activityId,user.getAccount());
        return new Result<>(activityDetailVO);
    }

    @ControllerLog(doAction = "获取评论信息")
    @ApiOperation(value = "获取评论信息")
    @RequestMapping(value = "/guest/getCommentInfo",method = RequestMethod.POST)
    public Result<PaginationData<List<Comment>>> getCommentInfo(@RequestBody ActivityPagingParam activityPagingParam){
        //获取当前登录用户
        User loginUser=(User) SecurityUtils.getSubject().getPrincipal();
        if(loginUser==null || loginUser.getAccount()==null){
            Result result=new Result();
            result.setResult(ActivityExceptionEnum.NETWORK_ANOMALY.getMessage());
            result.setCode(ActivityExceptionEnum.NETWORK_ANOMALY.getCode());
            logger.warn("获取评论信息接口获取当前登录用户失败");
            return result;
        }
        PaginationData<List<Comment>> commentInfo = activityDetailsService.getCommentInfo(activityPagingParam,loginUser.getAccount(),Boolean.TRUE);
        return new Result<>(commentInfo);
    }
}
