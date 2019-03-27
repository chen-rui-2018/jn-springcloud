package com.jn.oa.meeting.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.oa.meeting.model.OaMeetingAdd;
import com.jn.oa.meeting.model.OaMeetingApprove;
import com.jn.oa.meeting.model.OaMeetingPage;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.oa.meeting.vo.OaMeetingParticipantVo;
import com.jn.oa.meeting.vo.OaMeetingVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 会议管理controller
 *
 * @author： yuanyy
 * @date： Created on 2019/1/29 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "会议申请管理")
@RestController
@RequestMapping("/oa/oaMeeting")
public class MeetingController extends BaseController {

    @Autowired
    private MeetingService meetingService;


    @ControllerLog(doAction = "查询会议申请列表")
    @ApiOperation(value = "查询会议申请列表")
    @PostMapping(value = "/list")
    @RequiresPermissions("/oa/oaMeeting/list")
    public Result<PaginationData<List<OaMeetingVo>>> list(@Validated @RequestBody OaMeetingPage oaMeetingPage) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = meetingService.selectOaMeetingListBySearchKey(oaMeetingPage,user);
        return new Result(data);
    }


    @ControllerLog(doAction = "新增会议申请")
    @ApiOperation(value = "新增会议申请")
    @PostMapping(value = "/add")
    @RequiresPermissions("/oa/oaMeeting/add")
    public Result add(@Validated @RequestBody OaMeetingAdd oaMeetingAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //为会议室实体其他属性赋值
        oaMeetingAdd.setId(UUID.randomUUID().toString());
        oaMeetingAdd.setApplicant(user.getId());
        oaMeetingAdd.setCreatorAccount(user.getAccount());
        oaMeetingAdd.setApplicationTime(new Date());
        oaMeetingAdd.setCreatedTime(new Date());
        meetingService.insertOaMeeting(oaMeetingAdd);
        return new Result();
    }

    @ControllerLog(doAction = "修改会议申请")
    @ApiOperation(value = "修改会议室")
    @PostMapping(value = "/update")
    @RequiresPermissions("/oa/oaMeeting/update")
    public Result update(@Validated @RequestBody OaMeetingAdd oaMeeting) {
        Assert.notNull(oaMeeting.getId(), "会议申请ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingService.updateOaMeetingById(oaMeeting, user);
        return new Result();
    }


    @ControllerLog(doAction = "审核会议申请")
    @ApiOperation(value = "审核会议申请",notes = "审核状态（0:已取消、1:审批中、2:审批通过、3:审批不通过、4:已作废）")
    @PostMapping(value = "/approve")
    @RequiresPermissions("/oa/oaMeeting/approve")
    public Result approve(@Validated @RequestBody OaMeetingApprove oaMeetingApprove){
        Assert.notNull(oaMeetingApprove.getId(), "会议申请ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingService.approveOaMeeting(oaMeetingApprove, user);
        return new Result();
    }



    @ControllerLog(doAction = "根据ID查询会议申请")
    @ApiOperation(value = "根据ID查询会议申请")
    @PostMapping(value = "/selectById")
    @RequiresPermissions("/oa/oaMeeting/selectById")
    public Result<OaMeetingParticipantVo> selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "会议申请ID不能为空");
        OaMeetingParticipantVo oaMeeting = meetingService.selectOaMeetingById(id);
        return new Result(oaMeeting);
    }


    @ControllerLog(doAction = "根据ID结束会议申请")
    @ApiOperation(value = "根据ID结束会议申请")
    @PostMapping(value = "/finishOaMeeting")
    @RequiresPermissions("/oa/oaMeeting/finishOaMeeting")
    public Result finishOaMeeting(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "会议申请ID不能为空");
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        meetingService. finishOaMeeting(id,user);
        return new Result();
    }

    @ControllerLog(doAction = "根据ID取消会议申请")
    @ApiOperation(value = "根据ID取消会议申请")
    @PostMapping(value = "/cancelOaMeeting")
    @RequiresPermissions("/oa/oaMeeting/cancelOaMeeting")
    public Result cancelOaMeeting(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "会议申请ID不能为空");
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        meetingService.cancelOaMeeting(id,user);
        return new Result();
    }


    @ControllerLog(doAction = "校验会议室主题称是否存在,fail表示名称已存在,success表示可以使用")
    @ApiOperation(value = "校验会议室主题是否存在", notes = "fail表示名称已存在,success表示可以使用")
    @RequestMapping(value = "/checkName")
    @RequiresPermissions("/oa/oaMeeting/checkName")
    public Result<String> checkName(String meetingRoomName) {
        String result = meetingService.checkMeetingName(meetingRoomName);
        return new Result(result);
    }

    @ControllerLog(doAction = "导出会议申请信息")
    @RequestMapping(value = "/exportExcelMeeting", method = RequestMethod.GET)
    @RequiresPermissions("/oa/oaMeeting/exportExcelMeeting")
    @ApiOperation(value = "导出会议申请信息")
    public void exportExcelMeeting(OaMeetingPage oaMeetingPage, HttpServletResponse response) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        String exportTitle = "名称,会议室,日期,开始时间,结束时间,部门,组织人,预约人,状态";
        String exportColName = "title,meetingRoomName,startDate,startTime,endTime,organizationalDepartmentName,organizationalUserName,userName,meetingStatusMessage";
        oaMeetingPage.setPage(1);
        oaMeetingPage.setRows(200000);
        PaginationData data = meetingService.selectOaMeetingListBySearchKey(oaMeetingPage,user);
        List dataRows = (List) data.getRows();
        String fileName = "会议申请信息";
        String sheetName = "会议申请信息";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, dataRows);
    }



}
