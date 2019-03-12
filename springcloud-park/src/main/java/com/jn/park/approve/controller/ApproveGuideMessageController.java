package com.jn.park.approve.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.approve.model.ApproveGuideMessageModel;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author： huangbq
 * @date： Created on 2019/3/12 16:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "对外行政审批中心-后台-咨询回复")
@RestController
@RequestMapping("/approve/guide/message")
public class ApproveGuideMessageController extends BaseController {

    @ControllerLog(doAction = "咨询列表")
    @ApiOperation(value = "咨询列表", httpMethod = "POST")
    @PostMapping(value = "/list")
    @RequiresPermissions("/approve/guide/message/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="title",value = "咨询名称(模糊查询)"),
            @ApiImplicitParam(name ="replyStatus",value = "回复状态(已回复,待回复)"),
            @ApiImplicitParam(name ="solutionStatus",value = "解决状态('已解决','未解决','其他')"),
            @ApiImplicitParam(name ="orderByClause",value = "排序字段",example = "create_time desc"),
            @ApiImplicitParam(name ="startDate",value = "开始咨询时间"),
            @ApiImplicitParam(name ="endDate",value = "结束咨询时间")
    })
    public Result<PaginationData<ApproveGuideMessageModel>> list(String title,String concatName,String replyStatus,String solutionStatus,String orderByClause,Date startDate,Date endDate,Page page){
        return new Result<PaginationData<ApproveGuideMessageModel>>();
    }

    @ControllerLog(doAction = "导出EXCEL")
    @ApiOperation(value = "导出EXCEL", httpMethod = "POST",notes = "返回excel下载地址")
    @PostMapping(value = "/export")
    @RequiresPermissions("/approve/guide/message/export")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="title",value = "咨询名称(模糊查询)"),
            @ApiImplicitParam(name ="replyStatus",value = "回复状态(已回复,待回复)"),
            @ApiImplicitParam(name ="solutionStatus",value = "解决状态('已解决','未解决','其他')"),
            @ApiImplicitParam(name ="orderByClause",value = "排序字段",example = "create_time desc"),
            @ApiImplicitParam(name ="startDate",value = "开始咨询时间"),
            @ApiImplicitParam(name ="endDate",value = "结束咨询时间")
    })
    public Result export(String title,String concatName,String replyStatus,String solutionStatus,String orderByClause,Date startDate,Date endDate){
        return new Result<>();
    }

    @ControllerLog(doAction = "回复留言")
    @ApiOperation(value = "回复留言", httpMethod = "POST")
    @PostMapping(value = "/reply")
    @RequiresPermissions("/approve/guide/message/reply")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageId",value = "留言ID",required = true),
            @ApiImplicitParam(name = "solutionStatus",value = "解决状态（已解决、未解决、其他）",required = true),
            @ApiImplicitParam(name = "replyMessage",value = "回复内容",required = true)
    })
    public Result reply(Integer messageId, String solutionStatus, String replyMessage){
        return new Result<>();
    }
}
