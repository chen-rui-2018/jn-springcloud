package com.jn.park.activity.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.activity.model.ActivityApplyDetail;
import com.jn.park.activity.model.ActivityContentBean;
import com.jn.park.activity.model.ActivityDetail;
import com.jn.park.export.service.ExportExcelService;
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
    //todo:待权限系统完成添加权限注解
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
    private ExportExcelService exportDataExcel;

    @Autowired
    private ActivityApplyService activityApplyService;

    @ControllerLog(doAction = "获取活动列表")
    @ApiOperation(value = "获取活动列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectActivityList")
    public Result selectActivityList(
            @ApiParam(name="actiType",value = "活动分类ID",required = true)String actiType,
            @ApiParam(name="state",value = "活动状态",required = true)String state,
            @ApiParam(name="actiName",value = "活动名",required = true)String actiName,
            @ApiParam(name="isTop",value = "是否首页展示",required = true)String isIndex,
            @ApiParam(name="page",value = "当前页数。不传默认查询第一页",required = true)Integer page,
            @ApiParam(name="rows",value = "每页行数。不传默认为15条",required = true)Integer rows) {
        PaginationData paginationData = activityService.selectActivityList(actiType,state,actiName,isIndex,page,rows);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "获取活动详情")
    @ApiOperation(value = "获取活动详情", httpMethod = "POST", response = Result.class,
            notes = "查询条件activityId")
    @RequestMapping(value = "/getActivityDetailsForManage")
    public Result getActivityDetailsForManage(String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        ActivityDetail activityDetailsForManage = activityService.getActivityDetailsForManage(activityId);
        return new Result(activityDetailsForManage);
    }

    @ControllerLog(doAction = "修改活动可报名状态")
    @ApiOperation(value = "修改活动可报名状态", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateActivityApply")
    public Result updateActivityApply(
            @ApiParam(name="activityId",value = "修改条件",required = true) String activityId,
            @ApiParam(name="state",value = "state只能传(0,1) 0代表停止报名 1开始报名",required = true) String state) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        Assert.notNull(state, ActivityExceptionEnum.ACTIVITY_APPLY_TYPE_STATE_NOT_NULL.getMessage());
        int i = activityService.updateActivityApply(activityId, state);
        return new Result(i);
    }

    @ControllerLog(doAction = "添加/修改活动")
    @ApiOperation(value = "添加/修改活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/insterOrUpdateActivity")
    public Result insertOrUpdateActivity(@RequestBody @Validated ActivityContentBean activityContent) {
        Assert.notNull(activityContent.getActiName(), ActivityExceptionEnum.ACTIVITY_TITLE_NOT_NULL.getMessage());
        if (StringUtils.equals(ACTIVITY_STATE_PUBLISH, activityContent.getState())) {
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
        }
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = activityService.insertOrUpdateActivity(activityContent,user.getAccount());
        return new Result(i);
    }


    @ControllerLog(doAction = "删除草稿活动")
    @ApiOperation(value = "删除草稿活动", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteDraftActivity")
    public Result deleteDraftActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID 只能删除草稿数据，多个Id用,拼接",required = true)String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.deleteDraftActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "删除非草稿活动(超级管理权限)")
    @ApiOperation(value = "删除非草稿活动(超级管理权限)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteActivity")
    public Result deleteActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID 该接口能删除任何活动数据，多个Id用,拼接",required = true)String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.deleteActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "取消活动")
    @ApiOperation(value = "取消活动(不能批量取消)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/cancelActivity")
    public Result cancelActivity(
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true)String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.cancelActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "活动报名列表")
    @ApiOperation(value = "活动报名列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/applyActivityList")
    public Result applyActivityList(
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true)String activityId,
            @ApiParam(name="page",value = "当前页数。不传默认查询第一页",required = true)Integer page,
            @ApiParam(name="rows",value = "每页行数。不传默认为15条",required = true)Integer rows) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        PaginationData paginationData = activityApplyService.applyActivityList(activityId,true, page,rows);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "下载签到二维码")
    @ApiOperation(value = "下载签到二维码", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/downloadSignCodeImg")
    public void downloadSignCodeImg(HttpServletResponse httpServletResponse,
                                    @ApiParam(name="activityId",value = "activityId:活动ID",required = true)String activityId){
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        httpServletResponse.reset();//清空输出流
        try {
            OutputStream outputStream = httpServletResponse.getOutputStream();
            String url = "/activity/signInActivity?activityId=" + activityId;
            activityApplyService.getQrCode(outputStream, url);
        } catch (IOException e) {
            logger.error("[活动二维码下载],IO异常，activityId: {},查询响应条数{}", activityId, e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_CODE_DOWN_IO_EXPEPTION);
        }
    }


    @ControllerLog(doAction = "发送活动通知")
    @ApiOperation(value = "发送活动通知(只能在活动开始前24小时才能发送)", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/sendMsgForActivate")
    public Result sendMsgForActivate(
            @ApiParam(name="activityId",value = "activityId:活动ID",required = true)String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.sendMsgForActivate(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "数据导出")
    @ApiOperation(value = "数据导出", httpMethod = "POST", response = Result.class
                ,notes = "id:活动id    exportColName:导出excel导出的字段别名 比如：name,phone,sex ...多个字段以逗号(,)分隔" +
                "   exportTitle：excel导出字段的标题 比如：姓名,手机,性别...多个字段以逗号(,)分隔 ")
    @RequestMapping(value = "/exportDataExcel")
    public void exportDataExcel( String id,String exportColName, String exportTitle,HttpServletResponse response){
        Assert.notNull(id, "活动id不能为空");
        Assert.notNull(exportColName, "excel导出的字段别名不能为空");
        Assert.notNull(exportTitle, "excel导出字段的标题不能为空");
        //下载文件名
        String codedFileName="活动报名人";
        //导出方式  xlsx
        int exportAs=2;
        PaginationData paginationData = activityApplyService.applyActivityList(id, false,null,null);
        List<ActivityApplyDetail> activityApplyDetails=(List<ActivityApplyDetail>)paginationData.getRows();
        exportDataExcel.singleRowHeaderExport(codedFileName,exportColName,exportTitle,exportAs,activityApplyDetails,response);
    }

}
