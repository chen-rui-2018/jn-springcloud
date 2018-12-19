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
    @ApiOperation(value = "获取活动列表", httpMethod = "POST", response = Result.class,
            notes = "查询条件[actiType:活动分类ID,state:活动状态,actiName:活动名,isTop:是否首页展示]  分页：page：1第一页 rows：每页行数。不传页码行数默认查询前15条")
    @RequestMapping(value = "/selectActivityList")
    public Result selectActivityList(@RequestBody @Validated ActivityContentBean activity) {
        PaginationData paginationData = activityService.selectActivityList(activity);
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
    @ApiOperation(value = "修改活动可报名状态", httpMethod = "POST", response = Result.class,
            notes = "修改条件：activityId,state只能传(0,1) 0代表停止报名 1开始报名")
    @RequestMapping(value = "/updateActivityApply")
    public Result updateActivityApply(String activityId,String state) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        Assert.notNull(state, ActivityExceptionEnum.ACTIVITY_APPLY_TYPE_STATE_NOT_NULL.getMessage());
        int i = activityService.updateActivityApply(activityId, state);
        return new Result(i);
    }

    @ControllerLog(doAction = "添加/修改活动")
    @ApiOperation(value = "添加/修改活动", httpMethod = "POST", response = Result.class,
            notes = "新增活动ID不传则为新增,传ID即为修改。修改只能修改活动状态state为1(草稿)的数据。" +
                    "新增活动为草稿时，必填字段只为活动名，当发布活动时，会校验所有必填字段。排序字段为空，后台自动对其排序为0(靠后排序)。时间统一格式为yyyy-MM-dd HH:mm:ss" +
                    "actiType：活动类型(传通过/findActivityTypeList查询出的活动类型值)、actiName：活动名称、actiStartTime：活动开始时间、" +
                    "actiEndTime：活动结束时间、applyEndTime：活动报名结束时间、mesSendTime：活动消息发送时间、parkId：活动园区(传通过/getParkCodeByType查询的园区列表值)、" +
                    "actiAddress：活动地址、actiCost：活动费用、actiOrganizer：活动主办方、actiNumber：活动人数、actiPosterUrl：活动海报路径、state：活动状态、" +
                    "isIndex：是否首页展示、actiOrder：排序、actiDetail：活动详情、showApplyNum：是否展示报名人-0否1是")
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
    @ApiOperation(value = "删除草稿活动", httpMethod = "POST", response = Result.class,
            notes = "修改条件：activityId,只能删除草稿数据，多个Id用,拼接")
    @RequestMapping(value = "/deleteDraftActivity")
    public Result deleteDraftActivity(String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.deleteDraftActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "删除非草稿活动(超级管理权限)")
    @ApiOperation(value = "删除非草稿活动(超级管理权限)", httpMethod = "POST", response = Result.class,
            notes = "修改条件：activityId,能删除任何活动数据，多个Id用,拼接")
    @RequestMapping(value = "/deleteActivity")
    public Result deleteActivity(String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.deleteActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "取消活动")
    @ApiOperation(value = "取消活动", httpMethod = "POST", response = Result.class,
            notes = "取消条件：activityId，不能批量取消")
    @RequestMapping(value = "/cancelActivity")
    public Result cancelActivity(String activityId) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        int i = activityService.cancelActivity(activityId);
        return new Result(i);
    }

    @ControllerLog(doAction = "活动报名列表")
    @ApiOperation(value = "活动报名列表", httpMethod = "POST", response = Result.class,
            notes = "查询条件：activityId,分页：page：1第一页 rows：每页行数。不传页码行数默认查询前15条")
    @RequestMapping(value = "/applyActivityList")
    public Result applyActivityList(String activityId, @Validated Page page) {
        Assert.notNull(activityId, ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
        PaginationData paginationData = activityApplyService.applyActivityList(activityId, page);
        return new Result(paginationData);
    }

    @ControllerLog(doAction = "下载签到二维码")
    @ApiOperation(value = "下载签到二维码", httpMethod = "POST", response = Result.class,
            notes = "下载条件：activityId")
    @RequestMapping(value = "/downloadSignCodeImg")
    public void downloadSignCodeImg(HttpServletResponse httpServletResponse, String activityId){
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
    @ApiOperation(value = "发送活动通知", httpMethod = "POST", response = Result.class,
            notes ="activityId:活动ID，只能在活动开始前24小时才能发送" )
    @RequestMapping(value = "/sendMsgForActivate")
    public Result sendMsgForActivate(String activityId) {
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
        PaginationData paginationData = activityApplyService.applyActivityList(id, null);
        List<ActivityApplyDetail> activityApplyDetails=(List<ActivityApplyDetail>)paginationData.getRows();
        exportDataExcel.singleRowHeaderExport(codedFileName,exportColName,exportTitle,exportAs,activityApplyDetails,response);
    }

}
