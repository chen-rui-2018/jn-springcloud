package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.activity.service.ActivityTypeService;
import com.jn.park.activity.vo.ActivityDetailVO;
import com.jn.park.enums.ActivityExceptionEnum;
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
 * 活动相关信息展示
 * @Author: yangph
 * @Date: 2018/12/5 15:07
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动相关信息展示")
@RestController
public class ActivityInfoController extends BaseController {
    //todo:待权限系统完成添加权限注解
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityInfoController.class);

    @Autowired
    private ActivityDetailsService activityDetailsService;

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityTypeService activityTypeService;

    @ControllerLog(doAction = "获取活动详情")
    @ApiOperation(value = "获取活动详情", httpMethod = "POST", response = Result.class,notes = "activityId:活动id")
    @RequestMapping(value = "/guest/getActivityDetails")
    public Result getActivityDetails(String activityId){
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
    @ApiOperation(value = "获取评论信息", httpMethod = "POST", response = Result.class,notes = "activityId:活动id")
    @RequestMapping(value = "/guest/getCommentInfo")
    public Result getCommentInfo(String activityId,Page page){
        Assert.notNull(activityId,ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        PaginationData commentInfo = activityDetailsService.getCommentInfo(activityId, page,true);
        return new Result(commentInfo);
    }

    @ControllerLog(doAction = "前台获取简单活动列表")
    @ApiOperation(value = "前台获取简单活动列表", httpMethod = "POST", response = Result.class,
    notes = "查询条件:活动类型-选择对应活动类型id,分页参数:page-分页参数(表示第几页,不传则默认返回第一页),rows-分页参数(表示一页的数据条数,不传值则默认返回第一页,15条数据),关键字:(标题/内容/地点)")
    @RequestMapping(value = "/guest/activityListSlim")
    public Result activityListSlim(String typeId,String keyWord,Page page ) {
        PaginationData paginationData = activityService.activityListSlim(typeId,page,keyWord);
        return new Result(paginationData);
    }
    @ControllerLog(doAction = "查询活动类型列表")
    @ApiOperation(value = "查询活动类型列表", httpMethod = "POST", response = Result.class,
    notes = "分页参数:page-分页参数(表示第几页,不传则默认返回第一页),rows-分页参数(表示一页的数据条数,不传值则默认返回第一页,15条数据)")
    @RequestMapping(value = "/guest/findActivityTypeList")
    public Result findActivityTypeListByState(Page page) {
        //前台获取活动类型作为查询条件,只返回有效的活动类型;
        String state = "1";
        PaginationData activityTypeList = activityTypeService.findActivityTypeListByState(state,page);
        return new Result(activityTypeList);
    }
}
