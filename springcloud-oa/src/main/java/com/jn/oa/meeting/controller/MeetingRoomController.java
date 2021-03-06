package com.jn.oa.meeting.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import com.jn.oa.meeting.model.OaMeeting;
import com.jn.oa.meeting.model.OaMeetingRoomAdd;
import com.jn.oa.meeting.model.OaMeetingRoomOrderPage;
import com.jn.oa.meeting.model.OaMeetingRoomPage;
import com.jn.oa.meeting.service.MeetingRoomService;
import com.jn.oa.meeting.vo.OaMeetingRoomOrderVo;
import com.jn.oa.meeting.vo.OaMeetingRoomVo;
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
import java.util.List;
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
    @ApiOperation(value = "查询会议室列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingRoom/list")
    public Result<PaginationData<List<OaMeetingRoomVo>>> list(@Validated @RequestBody OaMeetingRoomPage oaMeetingRoomPage) {
        PaginationData data = meetingRoomService.selectOaMeetingRoomListBySearchKey(oaMeetingRoomPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询会议室预约列表")
    @ApiOperation(value = "查询会议室预约列表")
    @RequestMapping(value = "/orderList", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingRoom/orderList")
    public Result<PaginationData<List<OaMeetingRoomOrderVo>>> orderList(@Validated @RequestBody OaMeetingRoomOrderPage oaMeetingRoomOrderPage) {
        PaginationData data = meetingRoomService.selectMeetingRoomAndMeetingOrder(oaMeetingRoomOrderPage);
        return new Result(data);
    }
    @ControllerLog(doAction = "查询会议室可用列表")
    @ApiOperation(value = "查询会议室可用列表")
    @RequestMapping(value = "/availableList", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingRoom/availableList")
    public Result<PaginationData<List<OaMeeting>>> availableList(@Validated @RequestBody OaMeetingRoomPage oaMeetingRoomPage) {
        Assert.notNull(oaMeetingRoomPage.getStartTime(), "会议开始时间不能为空");
        Assert.notNull(oaMeetingRoomPage.getEndTime(), "会议结束时间不能为空");
        PaginationData data = meetingRoomService.selectAvailableMeetingRoomList(oaMeetingRoomPage);
        return new Result(data);
    }



    @ControllerLog(doAction = "新增会议室")
    @ApiOperation(value = "新增会议室")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingRoom/add")
    public Result add(@Validated @RequestBody OaMeetingRoomAdd oaMeetingRoomAdd ) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //为会议室实体其他属性赋值
        oaMeetingRoomAdd.setId(UUID.randomUUID().toString());
        oaMeetingRoomAdd.setCreatorAccount(user.getId());
        oaMeetingRoomAdd.setCreatedTime(new Date());
        TbOaMeetingRoom tbOaMeetingRoom = new TbOaMeetingRoom();
        BeanUtils.copyProperties(oaMeetingRoomAdd, tbOaMeetingRoom);
        meetingRoomService.insertOaMeetingRoom(tbOaMeetingRoom,oaMeetingRoomAdd.getAttachmentPaths());
        return new Result();
    }

    @ControllerLog(doAction = "修改会议室")
    @ApiOperation(value = "修改会议室")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingRoom/update")
    public Result update(@Validated @RequestBody OaMeetingRoomAdd oaMeetingRoomAdd) {
        Assert.notNull(oaMeetingRoomAdd.getId(), "会议室ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingRoomService.updateOaMeetingRoomById(oaMeetingRoomAdd, user,oaMeetingRoomAdd.getAttachmentPaths());
        return new Result();
    }

    @ControllerLog(doAction = "批量删除会议室")
    @ApiOperation(value = "批量删除会议室")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingRoom/delete")
    public Result delete(String[] ids) {
        Assert.noNullElements(ids, "会议室ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingRoomService.deleteOaMeetingRoomByIds(ids, user);
        return new Result();
    }

    @ControllerLog(doAction = "根据ID查询会议室")
    @ApiOperation(value = "根据ID查询会议室")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingRoom/selectById")
    public Result<OaMeetingRoomVo> selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "会议室ID不能为空");
        OaMeetingRoomVo oaMeetingRoomVo = meetingRoomService.selectOaMeetingRoomByIds(id);
        return new Result(oaMeetingRoomVo);
    }

    @ControllerLog(doAction = "校验会议室名称是否存在,fail表示名称已存在,success表示可以使用")
    @ApiOperation(value = "校验会议室名称是否存在", notes = "fail表示名称已存在,success表示可以使用")
    @RequestMapping(value = "/checkName", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingRoom/checkName")
    public Result<String> checkName(String meetingRoomName) {
        String result = meetingRoomService.checkMeetingRoomName(meetingRoomName);
        return new Result(result);
    }
}
