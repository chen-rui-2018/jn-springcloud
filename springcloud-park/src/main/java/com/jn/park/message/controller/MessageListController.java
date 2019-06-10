package com.jn.park.message.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.vo.FinanceExpendHistoryVo;
import com.jn.park.message.model.*;
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


    @ControllerLog(doAction = "获取所有未读消息")
    @ApiOperation(value = "获取所有类别的未读状态的消息",notes = "获取所有类别的未读状态的消息", httpMethod = "GET")
    @GetMapping(value = "/findAllList")
    @RequiresPermissions("/message/list/findAllList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageOneSort",value = "一级消息类别(为空查询所有消息), 0:个人动态;1:企业空间;",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "isRead",value = "是否已读(为空查询所有未读消息), 0：未读，1：已读;",dataType = "String",paramType = "query")
    })
    public Result<List<MessageListModel>> findAllList(String messageOneSort,String isRead){
        //PaginationData findAllMessageListVoList = messageListService.findAll(findAllMessageListModel,getUser());
        List<MessageListModel> getMessageOneTort=messageListService.findAllList(messageOneSort,isRead,getUser());
        return new Result(getMessageOneTort);
    }


    @ControllerLog(doAction = "获取二级消息类别")
    @ApiOperation(value = "获取二级消息类别",notes = "获取二级消息类别,查询消息列表", httpMethod = "GET")
    @GetMapping(value = "/getMessageOneTort")
    @RequiresPermissions("/message/list/getMessageOneTort")
    @ApiImplicitParam(name = "messageOneTort",value = "一级消息类别(不可为空), 0:个人动态;1:企业空间;",dataType = "String",paramType = "query")
    public Result<List<MessageTowListModel>> getMessageOneTort(String messageOneTort){

        //PaginationData findAllMessageListVoList = messageListService.findAll(findAllMessageListModel,getUser());
        List<MessageTowListModel> getMessageOneTort=messageListService.getMessageOneTort(messageOneTort,getUser());
        return new Result(getMessageOneTort);
    }


    @ControllerLog(doAction = "获取一级消息类别下所有消息(APP端)")
    @ApiOperation(value = "获取一级消息类别下所有消息(APP端)",notes = "提供给app端查询一级类别下的所有二级类别消息", httpMethod = "GET")
    @GetMapping(value = "/findAllApp")
    @RequiresPermissions("/message/list/findAllApp")

    public Result<PaginationData<List<MessageListModel>>> findAllApp(findAllAppMessageListModel findAllAppMessageListModel){

        PaginationData findAllApp =messageListService.findAllApp(findAllAppMessageListModel,getUser());

        return new Result(findAllApp);
    }

    @ControllerLog(doAction = "消息列表")
    @ApiOperation(value = "消息列表",notes = "查询消息列表", httpMethod = "GET")
    @GetMapping(value = "/findAll")
    @RequiresPermissions("/message/list/findAll")
    public Result<PaginationData<List<MessageListModel>>> findAll(findAllMessageListModel findAllMessageListModel){

        PaginationData findAllMessageListVoList = messageListService.findAll(findAllMessageListModel,getUser());
        return new Result(findAllMessageListVoList);
    }

    @ControllerLog(doAction = "是否有新的未读消息")
    @ApiOperation(value = "是否有新的未读消息",notes = "是否有已读消息", httpMethod = "GET")
    @GetMapping(value = "/getIsRead")
    @RequiresPermissions("/message/list/getIsRead")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageOneTort",value = "一级消息类别,为空时查询所有一级分类下的全部消息 0:个人动态;1:企业空间;",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "messageTowTort",value = "二级消息类别,为空时查询所有二级分类下的全部消息(（1级）1:个人动态;（2级）2:企业订单;3:信息发布动态;4:交费提醒;5:访客留言;6:数据上报提醒;7:机构邀请;8:企业邀请;9:机构邀请;10:私人订单);",dataType = "String",paramType = "query")
    })
    public Result getIsRead(String messageOneTort,String messageTowTort){
        int getIsRead=messageListService.getIsRead(messageOneTort,messageTowTort,getUser());
        return new Result(getIsRead);
    }

    @ControllerLog(doAction = "添加消息")
    @ApiOperation(value = "添加消息",notes = "添加消息", httpMethod = "POST")
    @PostMapping(value = "/addMessage")
    @RequiresPermissions("/message/list/addMessage")
    public Result addMessage(@RequestBody AddMessageModel addMessageModel){
        String message=null;
        try {
            messageListService.addMessage(addMessageModel);
            message="添加消息成功";
        }catch (Exception e){
            message="添加失败";
        }
        return new Result(message);
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


    @ControllerLog(doAction = "修改为已读状态")
    @ApiOperation(value = "修改为已读状态",notes = "将消息修改为已读状态", httpMethod = "POST")
    @PostMapping(value = "/updateIsReadStatus")
    @RequiresPermissions("/message/list/updateIsReadStatus")
    @ApiImplicitParam(name = "id",value = "消息ID",dataType = "String",paramType = "query")
    public Result<String> updateIsReadStatus(String id){
        if(StringUtils.isBlank(id)){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"请输入消息ID");
        }
        String updateIsReadStatus = messageListService.updateIsReadStatus(id);
        return new Result(updateIsReadStatus);
    }


}
