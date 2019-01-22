package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.model.*;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 活动 内部使用API接口
 *
 * @Author: jiangyl
 * @Date: 2018/12/6 10:45
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "活动管理")
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {
    //todo:待权限系统完成添加权限注解 jangyl
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
    @ApiOperation(value = "获取活动列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectActivityList")
    public Result selectActivityList(@RequestBody @Validated ActivityParment activityParment) {
        PaginationData paginationData = activityService.selectActivityList(activityParment);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "获取活动详情")
    @ApiOperation(value = "获取活动详情", httpMethod = "POST", response = Result.class,
            notes = "查询条件activityId")
    @RequestMapping(value = "/getActivityDetailsForManage")
    public Result getActivityDetailsForManage(
            @ApiParam(name="activityId",value = "活动ID",required = true)@RequestParam String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        ActivityDetail activityDetailsForManage = activityService.getActivityDetailsForManage(activityId);
        return new Result(activityDetailsForManage);
    }

    @ControllerLog(doAction = "修改活动可报名状态")
    @ApiOperation(value = "修改活动可报名状态", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateActivityApply")
    public Result updateActivityApply(@RequestBody @Validated ActivitySataus activitySataus) {
        Assert.notNull(activitySataus.getActivityId(), ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        Assert.notNull(activitySataus.getActiStatus(), ActivityExceptionEnum.ACTIVITY_APPLY_TYPE_STATE_NOT_NULL.getMessage());
        int i = activityService.updateActivityApply(activitySataus);
        return new Result(i);
    }

    @ControllerLog(doAction = "添加/修改活动")
    @ApiOperation(value = "添加/修改活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/insterOrUpdateActivity")
    public Result insertOrUpdateActivity(@RequestBody @Validated ActivityContent activityContent) {
        Assert.notNull(activityContent.getActiName(), ActivityExceptionEnum.ACTIVITY_TITLE_NOT_NULL.getMessage());
        if (StringUtils.equals(ACTIVITY_STATE_PUBLISH, activityContent.getActiStatus())) {
            Assert.notNull(activityContent.getActiType(), ActivityExceptionEnum.ACTIVITY_TYPE_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiStartTime(), ActivityExceptionEnum.ACTIVITY_STATE_TIME_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiEndTime(), ActivityExceptionEnum.ACTIVITY_END_TIME_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getApplyEndTime(), ActivityExceptionEnum.ACTIVITY_APPLY_END_TIME_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getMesSendTime(), ActivityExceptionEnum.ACTIVITY_MES_SEND_TIME_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiAddress(), ActivityExceptionEnum.ACTIVITY_ADDRESS_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiCost(), ActivityExceptionEnum.ACTIVITY_COST_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiOrganizer(), ActivityExceptionEnum.ACTIVITY_ORGANIZER_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiNumber(), ActivityExceptionEnum.ACTIVITY_NUMBER_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiPosterUrl(), ActivityExceptionEnum.ACTIVITY_POSTER_URL_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiDetail(), ActivityExceptionEnum.ACTIVITY_DETAIL_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getActiNumber(), ActivityExceptionEnum.ACTIVITY_NUMBER_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getParkId(), ActivityExceptionEnum.ACTIVITY_PARK_ID_NOT_NULL.getMessage());
            Assert.notNull(activityContent.getApplyCheck(), ActivityExceptionEnum.ACTIVITY_APPLY_CHECK_NOT_NULL.getMessage());
        }
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.insertOrUpdateActivity(activityContent,user.getAccount());
        return new Result(i);
    }


    @ControllerLog(doAction = "删除草稿活动")
    @ApiOperation(value = "删除草稿活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteDraftActivity")
    public Result deleteDraftActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID 只能删除草稿数据，多个Id用,拼接",required = true)@RequestParam String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.deleteDraftActivity(activityId,user.getAccount());
        return new Result(i);
    }

    @ControllerLog(doAction = "删除非草稿活动(超级管理权限)")
    @ApiOperation(value = "删除非草稿活动(超级管理权限)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteActivity")
    public Result deleteActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID 该接口能删除任何活动数据，多个Id用,拼接",required = true)@RequestParam String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.deleteActivity(activityId,user.getAccount());
        return new Result(i);
    }

    @ControllerLog(doAction = "取消活动")
    @ApiOperation(value = "取消活动(不能批量取消)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/cancelActivity")
    public Result cancelActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true)@RequestParam String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.cancelActivity(activityId,user.getAccount());
        return new Result(i);
    }

    @ControllerLog(doAction = "活动报名列表")
    @ApiOperation(value = "活动报名列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/applyActivityList")
    public Result applyActivityList(@RequestBody @Validated ActivityApplyParment activityApplyParment) {
        Assert.notNull(activityApplyParment.getActivityId(), ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        PaginationData paginationData = activityApplyService.applyActivityList(activityApplyParment,true);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "下载签到二维码")
    @ApiOperation(value = "下载签到二维码", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/downloadSignCodeImg")
    public void downloadSignCodeImg(HttpServletResponse httpServletResponse,
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true)@RequestParam String activityId){
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        httpServletResponse.reset();//清空输出流
        try {
            OutputStream outputStream = httpServletResponse.getOutputStream();
            String url = "/activity/signInActivity?activityId=" + activityId;
            activityApplyService.getQrCode(outputStream, url);
        } catch (IOException e) {
            logger.error("[活动二维码下载],IO异常，activityId: {},查询响应条数{}", activityId, e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_CODE_DOWN_IO_EXCEPTION);
        }
    }


    @ControllerLog(doAction = "发送活动通知")
    @ApiOperation(value = "发送活动通知(只能在活动开始前24小时才能发送)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/sendMsgForActivate")
    public Result sendMsgForActivate(
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true)@RequestParam String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.sendMsgForActivate(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "数据导出")
    @ApiOperation(value = "数据导出", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/exportDataExcel")
    public void exportDataExcel(@Validated ActivityApplyParment activityApplyParment,
                                HttpServletResponse response){
        Assert.notNull(activityApplyParment.getActivityId(), "活动id不能为空");
        Assert.notNull(activityApplyParment.getExportColName(), "excel导出的字段别名不能为空");
        Assert.notNull(activityApplyParment.getExportTitle(), "excel导出字段的标题不能为空");
        //下载文件名
        String fileName="活动报名人";
        String sheetName = "活动报名人";
        PaginationData paginationData = activityApplyService.applyActivityList(activityApplyParment, false);
        List<ActivityApplyDetail> activityApplyDetails=(List<ActivityApplyDetail>)paginationData.getRows();
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, activityApplyParment.getExportTitle(), activityApplyParment.getExportColName(), activityApplyDetails);
    }

    @ControllerLog(doAction = "活动结束回调方法")
    @ApiOperation(value = "活动结束回调方法", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/activityEndByTimedTask")
    public Result activityEndByTimedTask(@RequestBody ActivityContent activity){
        int i = activityService.activityEndByTimedTask(activity);
        return new Result(i);
    }

    @ControllerLog(doAction = "活动消息自动推送回调方法")
    @ApiOperation(value = "活动消息自动推送回调方法", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/activitySendMessageByTimedTask")
    public Result activitySendMessageByTimedTask(@RequestBody ActivityContent activity){
        int i = activityService.activitySendMessageByTimedTask(activity);
        return new Result(i);
    }

}
