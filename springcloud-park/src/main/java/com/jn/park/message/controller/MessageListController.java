package com.jn.park.message.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.message.model.AddMessageModel;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.park.message.model.MessageListModel;
import com.jn.park.message.service.MessageListService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author： tangry
 * @date： Created on 2019/4/19
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "消息中心-消息列表")
@RestController
@RequestMapping("/message/list")
public class MessageListController extends BaseController {
    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }
    @Autowired
    private MessageListService messageListService;

    @ControllerLog(doAction = "消息列表")
    @ApiOperation(value = "消息列表",notes = "查询消息列表", httpMethod = "GET")
    @GetMapping(value = "/findAll")
    @RequiresPermissions("/message/list/findAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageOneTort",value = "一级消息类别,0:个人动态;1:企业空间;(必填)",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "messageTowTort",value = "二级消息类别(为空时查询一级分类下的全部消息)(（1级）1:个人动态;（2级）2:企业订单;3:信息发布动态;4:交费提醒;5:访客留言;6:数据上报提醒;7:机构邀请;8:企业邀请;9:机构邀请;10:私人订单);",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "isRead",value = "消息是否已读(0:未读;1:已读);为空时查询全部",dataType = "Integer",paramType = "query")
    })
    public Result<FindAllMessageListVo> findAll(Integer messageOneTort,Integer messageTowTort,Integer isRead){
        if(messageOneTort == null){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请输入一级消息类别");
        }
        List<FindAllMessageListVo> findAllMessageListVoList = messageListService.findAll(messageOneTort,messageTowTort,isRead,getUser());
        return new Result(findAllMessageListVoList);
    }

    @ControllerLog(doAction = "添加消息")
    @ApiOperation(value = "添加消息",notes = "添加消息", httpMethod = "POST")
    @PostMapping(value = "/addMessage")
    @RequiresPermissions("/message/list/addMessage")
    public Result addMessage(@RequestBody AddMessageModel addMessageModel){
        messageListService.addMessage(addMessageModel);
        return new Result(new Result<>());
    }


    @ControllerLog(doAction = "根据ID查询消息")
    @ApiOperation(value = "根据ID查询消息",notes = "根据ID查询消息", httpMethod = "POST")
    @PostMapping(value = "/findByMessage")
    @RequiresPermissions("/message/list/findByMessage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "消息ID",dataType = "String",paramType = "query")
    })
    public Result<MessageListModel> findByMessage(String id){

        MessageListModel findByMessage= messageListService.findByMessage(id);
        return new Result(findByMessage);
    }


    @ControllerLog(doAction = "修改消息")
    @ApiOperation(value = "修改消息",notes = "修改消息", httpMethod = "POST")
    @PostMapping(value = "/updateMessage")
    @RequiresPermissions("/message/list/updateMessage")
    public Result updateMessage(@RequestBody  MessageListModel MessageListModel){

        messageListService.updateMessage(MessageListModel);
        return new Result(new Result<>());
    }


    @ControllerLog(doAction = "删除消息")
    @ApiOperation(value = "删除消息",notes = "删除消息", httpMethod = "POST")
    @PostMapping(value = "/deleteMessage")
    @RequiresPermissions("/message/list/deleteMessage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "消息ID",dataType = "String",paramType = "query")
    })
    public Result deleteMessage(String id){

        messageListService.deleteMessage(id);
        return new Result(new Result<>());
    }


    @ControllerLog(doAction = "修改已读状态")
    @ApiOperation(value = "修改已读状态",notes = "修改已读状态", httpMethod = "POST")
    @PostMapping(value = "/updateIsReadStatus")
    @RequiresPermissions("/message/list/updateIsReadStatus")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "消息ID",dataType = "String",paramType = "query")
    })
    public Result updateIsReadStatus(String id){

        messageListService.updateIsReadStatus(id);
        return new Result(new Result<>());
    }


}
