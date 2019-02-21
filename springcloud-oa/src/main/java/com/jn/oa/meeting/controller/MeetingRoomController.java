package com.jn.oa.meeting.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import com.jn.oa.meeting.model.OaMeetingRoom;
import com.jn.oa.meeting.model.OaMeetingRoomPage;
import com.jn.oa.meeting.service.MeetingRoomService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * 会议室管理controller
 *
 * @author： yuanyy
 * @date： Created on 2019/1/29 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "会议室管理")
@RestController
@RequestMapping("/oa/oaMeetingRoom")
public class MeetingRoomController extends BaseController {

    @Autowired
    private MeetingRoomService meetingRoomService;


    @ControllerLog(doAction = "查询会议室列表")
    @ApiOperation(value = "查询文件列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/oa/meetingRoom/list")
    public Result list(@Validated @RequestBody OaMeetingRoomPage oaMeetingRoomPage) {
        PaginationData data = meetingRoomService.selectOaMeetingRoomListBySearchKey(oaMeetingRoomPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "新增会议室")
    @ApiOperation(value = "新增会议室", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    @RequiresPermissions("/oa/meetingRoom/add")
    public Result add(@Validated @RequestBody OaMeetingRoom oaMeetingRoom) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //为会议室实体其他属性赋值
        oaMeetingRoom.setId(UUID.randomUUID().toString());
        oaMeetingRoom.setCreatorAccount(user.getAccount());
        oaMeetingRoom.setCreatedTime(new Date());
        TbOaMeetingRoom tbOaMeetingRoom = new TbOaMeetingRoom();
        BeanUtils.copyProperties(oaMeetingRoom, tbOaMeetingRoom);
        meetingRoomService.insertOaMeetingRoom(tbOaMeetingRoom);
        return new Result();
    }

    @ControllerLog(doAction = "修改会议室")
    @ApiOperation(value = "修改会议室", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/oa/meetingRoom/update")
    public Result update(@Validated @RequestBody OaMeetingRoom oaMeetingRoom) {
        Assert.notNull(oaMeetingRoom.getId(), "会议室ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingRoomService.updateOaMeetingRoomById(oaMeetingRoom, user);
        return new Result();
    }

    @ControllerLog(doAction = "批量删除会议室")
    @ApiOperation(value = "批量删除会议室", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    @RequiresPermissions("/oa/meetingRoom/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "会议室ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingRoomService.deleteOaMeetingRoomByIds(ids, user);
        return new Result();
    }

    @ControllerLog(doAction = "根据ID查询会议室")
    @ApiOperation(value = "根据ID查询会议室", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectById")
    @RequiresPermissions("/oa/meetingRoom/selectById")
    public Result selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "会议室ID不能为空");
        OaMeetingRoom oaMeetingRoom = meetingRoomService.selectOaMeetingRoomByIds(id);
        return new Result(oaMeetingRoom);
    }

    @ControllerLog(doAction = "校验会议室名称是否存在,fail表示名称已存在,success表示可以使用")
    @ApiOperation(value = "校验会议室名称是否存在,fail表示名称已存在,success表示可以使用", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkName")
    @RequiresPermissions("/oa/meetingRoom/checkName")
    public Result checkName(String meetingRoomName) {
        String result = meetingRoomService.checkMeetingRoomName(meetingRoomName);
        return new Result(result);
    }
}
