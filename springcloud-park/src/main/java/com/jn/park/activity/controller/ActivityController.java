package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.*;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "获取活动列表")
    @RequestMapping(value = "/selectActivityList",method = RequestMethod.POST)
    @RequiresPermissions("/activity/selectActivityList")
    public Result<PaginationData<List<Activity>>> selectActivityList(@RequestBody @Validated ActivityParment activityParment) {
        PaginationData<List<Activity>> paginationData = activityService.selectActivityList(activityParment);
        return new Result<>(paginationData);
    }

    @ControllerLog(doAction = "获取活动详情[后台管理]")
    @ApiOperation(value = "获取活动详情[后台管理]", httpMethod = "POST",
            notes = "查询条件activityId")
    @RequestMapping(value = "/getActivityDetailsForManage")
    @RequiresPermissions("/activity/getActivityDetailsForManage")
    public Result<ActivityDetail> getActivityDetailsForManage(
            @ApiParam(name="activityId",value = "活动ID",required = true,example = "f5c95f9adf714aedab3739cbc9297178")@RequestParam(value = "activityId") String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        ActivityDetail activityDetailsForManage = activityService.getActivityDetailsForManage(activityId);
        return new Result<>(activityDetailsForManage);
    }

    @ControllerLog(doAction = "修改活动可报名状态")
    @ApiOperation(value = "修改活动可报名状态", notes = "数据响应条数，正常情况为1")
    @RequestMapping(value = "/updateActivityApply",method = RequestMethod.POST)
    @RequiresPermissions("/activity/updateActivityApply")
    public Result<Integer> updateActivityApply(@RequestBody @Validated ActivitySataus activitySataus) {
        Assert.notNull(activitySataus.getActivityId(), ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        Assert.notNull(activitySataus.getActiStatus(), ActivityExceptionEnum.ACTIVITY_APPLY_TYPE_STATE_NOT_NULL.getMessage());
        int i = activityService.updateActivityApply(activitySataus);
        return new Result<>(i);
    }

    @ControllerLog(doAction = "保存活动草稿")
    @ApiOperation(value = "保存活动草稿" ,notes = "数据响应条数，正常情况为1")
    @RequestMapping(value = "/saveActivityDraft",method = RequestMethod.POST)
    @RequiresPermissions("/activity/saveActivityDraft")
    public Result<Integer> saveActivityDraft(@RequestBody @Validated ActivityContent activityContent) {
        Assert.notNull(activityContent.getActiName(), ActivityExceptionEnum.ACTIVITY_TITLE_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.insertOrUpdateActivity(activityContent,user.getAccount());
        return new Result<>(i);
    }

    @ControllerLog(doAction = "发布活动")
    @ApiOperation(value = "发布活动",notes = "数据响应条数，正常情况为1")
    @RequestMapping(value = "/publishActivity",method = RequestMethod.POST)
    @RequiresPermissions("/activity/publishActivity")
    public Result<Integer> publishActivity(@RequestBody @Validated ActivityContent activityContent) {
        Assert.notNull(activityContent.getActiName(), ActivityExceptionEnum.ACTIVITY_TITLE_NOT_NULL.getMessage());
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
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.insertOrUpdateActivity(activityContent,user.getAccount());
        return new Result<>(i);
    }

    @ControllerLog(doAction = "删除草稿活动")
    @ApiOperation(value = "删除草稿活动", httpMethod = "POST" ,notes = "数据响应条数，正常情况为删除个数")
    @RequestMapping(value = "/deleteDraftActivity")
    @RequiresPermissions("/activity/deleteDraftActivity")
    public Result<Integer> deleteDraftActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID 数组",required = true,example = "f5c95f9adf714aedab3739cbc9297178")@RequestParam(value = "activityId") String[] activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.deleteDraftActivity(activityId,user.getAccount());
        return new Result<>(i);
    }

    @ControllerLog(doAction = "删除非草稿活动(超级管理权限)")
    @ApiOperation(value = "删除非草稿活动(超级管理权限)", httpMethod = "POST" ,notes = "数据响应条数，正常情况为删除个数")
    @RequestMapping(value = "/deleteActivity")
    @RequiresPermissions("/activity/deleteActivity")
    public Result<Integer> deleteActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID 数组",required = true,example = "f5c95f9adf714aedab3739cbc9297178")@RequestParam(value = "activityId") String[] activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.deleteActivity(activityId,user.getAccount());
        return new Result<>(i);
    }

    @ControllerLog(doAction = "取消活动")
    @ApiOperation(value = "取消活动(不能批量取消)", httpMethod = "POST" ,notes = "数据响应条数，正常情况为取消活动个数")
    @RequestMapping(value = "/cancelActivity")
    @RequiresPermissions("/activity/cancelActivity")
    public Result<Integer> cancelActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true,example = "f5c95f9adf714aedab3739cbc9297178")@RequestParam(value = "activityId") String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.cancelActivity(activityId,user.getAccount());
        return new Result<>(i);
    }

    @ControllerLog(doAction = "活动报名列表")
    @ApiOperation(value = "活动报名列表")
    @RequestMapping(value = "/applyActivityList",method = RequestMethod.POST)
    @RequiresPermissions("/activity/applyActivityList")
    public Result<PaginationData<List<ActivityApplyDetail>>> applyActivityList(@RequestBody @Validated ActivityApplyParam activityApplyParam) {
        Assert.notNull(activityApplyParam.getActivityId(), ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        PaginationData<List<ActivityApplyDetail>> paginationData = activityApplyService.applyActivityList(activityApplyParam,true);
        return new Result<>(paginationData);
    }

    @ControllerLog(doAction = "下载签到二维码")
    @ApiOperation(value = "下载签到二维码", httpMethod = "GET")
    @RequestMapping(value = "/downloadSignCodeImg")
    @RequiresPermissions("/activity/downloadSignCodeImg")
    public void downloadSignCodeImg(HttpServletResponse httpServletResponse,
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true,example = "f5c95f9adf714aedab3739cbc9297178")@RequestParam(value = "activityId") String activityId){
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
    @ApiOperation(value = "发送活动通知(只能在活动开始前24小时才能发送)", httpMethod = "POST" )
    @RequestMapping(value = "/sendMsgForActivate")
    @RequiresPermissions("/activity/sendMsgForActivate")
    public Result<Integer> sendMsgForActivate(
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true,example = "f5c95f9adf714aedab3739cbc9297178")@RequestParam(value = "activityId") String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.sendMsgForActivate(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "活动报名人数据导出")
    @ApiOperation(value = "活动报名人数据导出")
    @RequestMapping(value = "/exportDataExcel",method = RequestMethod.POST)
    @RequiresPermissions("/activity/exportDataExcel")
    public void exportDataExcel(@RequestBody  @Validated ActivityApplyParam activityApplyParam,
                                HttpServletResponse response){
        Assert.notNull(activityApplyParam.getExportColName(), ActivityExceptionEnum.EXPORT_COL_NAME_NOT_NULL.getMessage());
        Assert.notNull(activityApplyParam.getExportTitle(), ActivityExceptionEnum.EXPORT__TITLE_NOT_NULL.getMessage());
        //下载文件名
        String fileName="活动报名人";
        String sheetName = "活动报名人";
        PaginationData paginationData = activityApplyService.applyActivityList(activityApplyParam, false);
        List<ActivityApplyDetail> activityApplyDetails=(List<ActivityApplyDetail>)paginationData.getRows();
        //把数组转换为字符串，并以逗号（“,”）分隔
        String exportTitle =  StringUtils.join(activityApplyParam.getExportTitle(),",");
        String exportColName = StringUtils.join(activityApplyParam.getExportColName());
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, activityApplyDetails);
    }

    @ControllerLog(doAction = "活动结束回调方法")
    @ApiOperation(value = "活动结束回调方法")
    @RequestMapping(value = "/activityEndByTimedTask",method = RequestMethod.POST)
    public Result<Integer> activityEndByTimedTask(@RequestBody ActivityContent activity){
        int i = activityService.activityEndByTimedTask(activity);
        return new Result(i);
    }

    @ControllerLog(doAction = "活动消息自动推送回调方法")
    @ApiOperation(value = "活动消息自动推送回调方法")
    @RequestMapping(value = "/activitySendMessageByTimedTask",method = RequestMethod.POST)
    public Result<Integer> activitySendMessageByTimedTask(@RequestBody ActivityContent activity){
        int i = activityService.activitySendMessageByTimedTask(activity);
        return new Result(i);
    }

}
