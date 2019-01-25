package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.activity.vo.ActivityDetailVO;
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
    @ApiOperation(value = "获取活动详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/guest/getActivityDetails")
    public Result getActivityDetails(@ApiParam(value ="活动id",required = true) @RequestParam String activityId){
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Result result=new Result();
        String account="";
        if(user !=null && user.getAccount()!=null){
           account=user.getAccount();
        }
        ActivityDetailVO activityDetailVO=activityDetailsService.findActivityDetails(activityId,account);
        result.setData(activityDetailVO);
        return result;
    }

    @ControllerLog(doAction = "获取评论信息")
    @ApiOperation(value = "获取评论信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/guest/getCommentInfo")
    public Result getCommentInfo(@RequestBody  ActivityQueryPaging activityQueryPaging){
        PaginationData commentInfo = activityDetailsService.getCommentInfo(activityQueryPaging,Boolean.TRUE);
        return new Result(commentInfo);
    }
}
