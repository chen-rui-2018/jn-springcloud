package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.model.CompanyActivityApplyParam;
import com.jn.park.activity.model.CompanyActivityApplyShow;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.activity.model.ActivityApplyDetail;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.model.UserExtensionInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityApplyController.class);

    @Autowired
    private ActivityApplyService activityApplyService;

    @Autowired
    private ActivityService activityService;

    @ControllerLog(doAction = "快速报名")
    @RequiresPermissions("/activity/activityApply/quickApply")
    @ApiOperation(value = "快速报名", httpMethod = "POST")
    @RequestMapping(value = "/quickApply")
    public Result quickApply(@ApiParam(value = "活动id" ,required = true,example = "f5c95f9adf714aedab3739cbc9297178") @RequestParam(value = "activityId") String activityId){
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
    @RequiresPermissions("/activity/activityApply/cancelApply")
    @ApiOperation(value = "取消报名", httpMethod = "POST")
    @RequestMapping(value = "/cancelApply")
    public Result cancelApply(@ApiParam(value = "活动id",required = true,example = "f5c95f9adf714aedab3739cbc9297178") @RequestParam(value = "activityId") String activityId){
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
    @RequiresPermissions(value = "/activity/activityApply/signInActivity")
    @ApiOperation(value = "在线签到", httpMethod = "POST" ,notes = "返回结果为数据响应条数，正常为1")
    @RequestMapping(value = "/signInActivity")
    public Result<Integer> signInActivity(@ApiParam(value = "活动id",required = true,example = "f5c95f9adf714aedab3739cbc9297178") @RequestParam(value = "activityId") String activityId){
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int i = activityApplyService.signInActivity(user==null?"":user.getAccount(), activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "报名人列表查看")
    @RequiresPermissions("/activity/activityApply/activityApplyList")
    @ApiOperation(value = "报名人列表查看",
            notes = "查询条件--活动ID，关键字,分页页码及行数，不传页码行数默认查询前15条")
    @RequestMapping(value = "/activityApplyList",method = RequestMethod.POST)
    public Result<PaginationData<List<ActivityApplyDetail>>> activityApplyList(@RequestBody ActivityPagingParam activityPagingParam){
       Assert.notNull(activityPagingParam,ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
       PaginationData activityApplyList= activityApplyService.findApplyActivityList(activityPagingParam,Boolean.TRUE);
       return new Result(activityApplyList);
    }

    @ControllerLog(doAction = "后台签到接口")
    @RequiresPermissions("/activity/activityApply/signInActivityBackend")
    @ApiOperation(value = "后台签到接口", httpMethod = "POST")
    @RequestMapping(value = "/signInActivityBackend")
    public Result<Integer> signInActivityBackend(String applyId){
        Assert.notNull(applyId, ActivityExceptionEnum.ACTIVITY_APPLY_ID_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityApplyService.signInActivityBackend(applyId,user.getAccount());
        return new Result(i);
    }

    @ControllerLog(doAction = "报名审核接口")
    @RequiresPermissions("/activity/activityApply/signInActivityCheck")
    @ApiOperation(value = "报名审核接口", httpMethod = "POST")
    @RequestMapping(value = "/signInActivityCheck")
    public Result<Integer> signInActivityCheck(@ApiParam(value = "报名id",required = true,example = "f5c95f9adf714aedab3739cbc9297178") @RequestParam(value = "applyId") String applyId){
        Assert.notNull(applyId, ActivityExceptionEnum.ACTIVITY_APPLY_ID_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityApplyService.signInActivityCheck(applyId,user.getAccount());
        return new Result(i);
    }

    @ControllerLog(doAction = "报名人资料")
    @RequiresPermissions("/activity/activityApply/activityApplyInfo")
    @ApiOperation(value = "报名人资料", httpMethod = "POST")
    @RequestMapping(value = "/activityApplyInfo")
    public Result<UserExtensionInfo> activityApplyInfo(@ApiParam(value = "用户账号",required = true,example = "wangsong") @RequestParam(value = "account") String account){
        Assert.notNull(account, ActivityExceptionEnum.ACTIVITY_APPLY_ID_NOT_NULL.getMessage());
        UserExtensionInfo user =  activityApplyService.activityApplyInfo(account);
        return new Result(user);
    }

    @ControllerLog(doAction = "获取企业报报名活动信息")
    @RequiresPermissions("/activity/activityApply/getCompanyActivityApplyInfo")
    @ApiOperation(value = "获取企业报报名活动信息", httpMethod = "POST")
    @RequestMapping(value = "/getCompanyActivityApplyInfo")
    public Result<List<CompanyActivityApplyShow>> getCompanyActivityApplyInfo(@RequestBody CompanyActivityApplyParam param) {
        logger.info("进入获取企业报报名活动信息API,入参：{}",param.toString());
        return new Result(activityService.getCompanyActivityApplyInfo(param));
    }
}
