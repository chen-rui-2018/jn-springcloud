package com.jn.park.activity.controller;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.park.activity.entity.TbActivityApply;
import com.jn.park.activity.enums.ActivityExceptionEnum;
import com.jn.park.activity.model.Activity;
import com.jn.park.activity.model.ActivityDetail;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 活动 内部使用API接口
 * @Author: jiangyl
 * @Date: 2018/12/6 10:45
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动管理")
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityController.class);
    /**
     * 活动发布
     */
    private static final String ACTIVITY_STATE_PUBLISH = "2";

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityApplyService activityApplyService;

    @ControllerLog(doAction = "获取活动列表")
    @ApiOperation(value = "获取活动列表", httpMethod = "POST", response = Result.class,
            notes ="查询条件" )
    @RequestMapping(value = "/selectActivityList")
    public Result selectActivityList(@RequestBody @Validated Activity activity) {
        PaginationData paginationData = activityService.selectActivityList(activity);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "获取活动详情")
    @ApiOperation(value = "获取活动详情", httpMethod = "POST", response = Result.class,
            notes ="查询条件activityId" )
    @RequestMapping(value = "/getActivityDetailsForManage")
    public Result getActivityDetailsForManage(@RequestBody @Validated String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        ActivityDetail activityDetailsForManage = activityService.getActivityDetailsForManage(activityId);
        return new Result(activityDetailsForManage);
    }

    @ControllerLog(doAction = "修改活动可报名状态")
    @ApiOperation(value = "修改活动可报名状态", httpMethod = "POST", response = Result.class,
            notes ="修改条件：activityId,state只能传(0,1) 0代表停止报名 1开始报名" )
    @RequestMapping(value = "/updateActivityApply")
    public Result updateActivityApply(@RequestBody @Validated  String activityId,@Validated String state) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.updateActivityApply(activityId, state);
        return new Result(i);
    }

    @ControllerLog(doAction = "添加/修改活动")
    @ApiOperation(value = "添加/修改活动", httpMethod = "POST", response = Result.class,
            notes ="新增活动不需要传ID,传ID即为修改。修改只能修改活动状态state为1(草稿)的数据。" +
                    "新增活动为草稿时，必填字段只为活动名，当发布活动时，会校验所有必填字段。排序字段为空，后台自动对其排序为0(靠后排序)" )
    @RequestMapping(value = "/insterOrUpdateActivity")
    public Result insterOrUpdateActivity(@RequestBody @Validated Activity activity) {
        Assert.notNull(activity.getActiName(), ActivityExceptionEnum.ACTIVITY_TITLE_NOT_NULL.getMessage());
        if(StringUtils.equals(ACTIVITY_STATE_PUBLISH,activity.getState())){
            Assert.notNull(activity.getActiType(), ActivityExceptionEnum.ACTIVITY_TYPE_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiStartTime(), ActivityExceptionEnum.ACTIVITY_STATE_TIME_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiEndTime(), ActivityExceptionEnum.ACTIVITY_END_TIME_NOT_NULL.getMessage());
            Assert.notNull(activity.getApplyEndTime(), ActivityExceptionEnum.ACTIVITY_APPLY_END_TIME_NOT_NULL.getMessage());
            Assert.notNull(activity.getMesSendTime(), ActivityExceptionEnum.ACTIVITY_MES_SEND_TIME_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiAddress(), ActivityExceptionEnum.ACTIVITY_ADDRESS_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiCost(), ActivityExceptionEnum.ACTIVITY_COST_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiOrganizer(), ActivityExceptionEnum.ACTIVITY_ORGANIZER_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiNumber(), ActivityExceptionEnum.ACTIVITY_NUMBER_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiPosterUrl(), ActivityExceptionEnum.ACTIVITY_POSTER_URL_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiDetail(), ActivityExceptionEnum.ACTIVITY_DETAIL_NOT_NULL.getMessage());
            Assert.notNull(activity.getActiNumber(), ActivityExceptionEnum.ACTIVITY_NUMBER_NOT_NULL.getMessage());

        }
        int i = activityService.insterOrUpdateActivity(activity);
        return new Result(i);
    }



    @ControllerLog(doAction = "删除草稿活动")
    @ApiOperation(value = "删除草稿活动", httpMethod = "POST", response = Result.class,
            notes ="修改条件：activityId,只能删除草稿数据，多个Id用,拼接" )
    @RequestMapping(value = "/deleteDraftActivity")
    public Result deleteDraftActivity(@RequestBody @Validated String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.deleteDraftActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "删除非草稿活动(超级管理权限)")
    @ApiOperation(value = "删除非草稿活动(超级管理权限)", httpMethod = "POST", response = Result.class,
            notes ="修改条件：activityId,能删除任何活动数据，多个Id用,拼接" )
    @RequestMapping(value = "/deleteActivity")
    public Result deleteActivity(@RequestBody @Validated String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.deleteActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "取消活动")
    @ApiOperation(value = "取消活动", httpMethod = "POST", response = Result.class,
            notes ="取消条件：activityId，不能批量取消" )
    @RequestMapping(value = "/cancelActivity")
    public Result cancelActivity(@RequestBody @Validated String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.cancelActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "活动报名列表")
    @ApiOperation(value = "活动报名列表", httpMethod = "POST", response = Result.class,
            notes ="导出条件：activityId，分页页码及行数，不传页码行数默认查询前15条" )
    @RequestMapping(value = "/applyActivityList")
    public Result applyActivityList(@RequestBody @Validated String activityId, @Validated Page page) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        List<TbActivityApply> applies = activityApplyService.applyActivityList(activityId, page);
        return new Result(applies);
    }

    @ControllerLog(doAction = "下载签到二维码")
    @ApiOperation(value = "下载签到二维码", httpMethod = "POST", response = Result.class,
            notes ="下载条件：activityId" )
    @RequestMapping(value = "/downloadSignCodeImg")
    public void downloadSignCodeImg(HttpServletResponse httpServletResponse, @Validated String activityId){
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        httpServletResponse.reset();//清空输出流
        try{
            OutputStream outputStream = httpServletResponse.getOutputStream();
            String url = "/activity/signInActivity?activityId="+activityId;
            activityApplyService.getQrCode(outputStream,url);
        }catch (IOException e){
            logger.error("[活动二维码下载],IO异常，activityId: {},查询响应条数{}", activityId,e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_CODE_DOWN_IO_EXPEPTION);
        }
    }


}
