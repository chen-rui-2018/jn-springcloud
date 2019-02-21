package com.jn.oa.meeting.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.oa.meeting.model.OaMeeting;
import com.jn.oa.meeting.model.OaMeetingAdd;
import com.jn.oa.meeting.model.OaMeetingApprove;
import com.jn.oa.meeting.model.OaMeetingPage;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @ApiOperation(value = "查询文件列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/oa/meeting/list")
    public Result list(@Validated @RequestBody OaMeetingPage oaMeetingPage) {
        PaginationData data = meetingService.selectOaMeetingListBySearchKey(oaMeetingPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "新增会议申请")
    @ApiOperation(value = "新增会议申请", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    @RequiresPermissions("/oa/meeting/add")
    public Result add(@Validated @RequestBody OaMeetingAdd oaMeetingAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //为会议室实体其他属性赋值
        oaMeetingAdd.setId(UUID.randomUUID().toString());
        oaMeetingAdd.setApplicant(user.getAccount());
        oaMeetingAdd.setCreatorAccount(user.getAccount());
        oaMeetingAdd.setApplicationTime(new Date());
        oaMeetingAdd.setCreatedTime(new Date());
        meetingService.insertOaMeeting(oaMeetingAdd);
        return new Result();
    }

    @ControllerLog(doAction = "修改会议申请")
    @ApiOperation(value = "修改会议室", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/oa/meeting/update")
    public Result update(@Validated @RequestBody OaMeeting oaMeeting) {
        Assert.notNull(oaMeeting.getId(), "会议申请ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingService.updateOaMeetingById(oaMeeting, user);
        return new Result();
    }

    @ControllerLog(doAction = "审核会议申请")
    @ApiOperation(value = "审核会议申请（0:已取消、1:审批中、2:审批通过、3:审批不通过、4:已作废）", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/approve")
    @RequiresPermissions("/oa/meeting/approve")
    public Result approve(@Validated @RequestBody OaMeetingApprove oaMeetingApprove) {
        Assert.notNull(oaMeetingApprove.getId(), "会议申请ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingService.approveOaMeeting(oaMeetingApprove, user);
        return new Result();
    }


    @ControllerLog(doAction = "批量删除会议申请")
    @ApiOperation(value = "批量删除会议申请", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    @RequiresPermissions("/oa/meeting/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "会议申请ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingService.deleteOaMeetingByIds(ids, user);
        return new Result();
    }

    @ControllerLog(doAction = "根据ID查询会议申请")
    @ApiOperation(value = "根据ID查询会议申请", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectById")
    @RequiresPermissions("/oa/meeting/selectById")
    public Result selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "会议申请ID不能为空");
        OaMeeting oaMeetingRoom = meetingService.selectOaMeetingByIds(id);
        return new Result(oaMeetingRoom);
    }


    @ControllerLog(doAction = "根据ID结束会议申请")
    @ApiOperation(value = "根据ID结束会议申请", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/finishOaMeeting")
    @RequiresPermissions("/oa/meeting/finishOaMeeting")
    public Result finishOaMeeting(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "会议申请ID不能为空");
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        meetingService. finishOaMeeting(id,user);
        return new Result();
    }


    @ControllerLog(doAction = "校验会议室主题称是否存在,fail表示名称已存在,success表示可以使用")
    @ApiOperation(value = "校验会议室主题是否存在,fail表示名称已存在,success表示可以使用", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkName")
    @RequiresPermissions("/oa/meeting/checkName")
    public Result checkName(String meetingRoomName) {
        String result = meetingService.checkMeetingName(meetingRoomName);
        return new Result(result);
    }



}
