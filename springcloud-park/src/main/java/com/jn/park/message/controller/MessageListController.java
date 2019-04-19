package com.jn.park.message.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.model.FinanceExpensesHistoryPageModel;
import com.jn.park.finance.model.FinanceExpensesPageModel;
import com.jn.park.finance.model.FinanceSelectDepartmentModel;
import com.jn.park.finance.service.FinanceExpensesService;
import com.jn.park.finance.vo.FinanceExpendFinanceTypeVo;
import com.jn.park.finance.vo.FinanceExpendFindImportDataVo;
import com.jn.park.finance.vo.FinanceExpendHistoryVo;
import com.jn.park.finance.vo.FinanceExpendImportDataVo;
import com.jn.park.message.model.addMessageModel;
import com.jn.park.message.service.MessageListService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            @ApiImplicitParam(name = "messageOneSort",value = "一级消息类别",dataType = "String",paramType = "query",example = "0"),
            @ApiImplicitParam(name = "messageTowSort",value = "二级消息类别",dataType = "String",paramType = "query",example = "0")
    })
    public Result findAll(String messageOneSort,String messageTowSort){
        // TODO: 2019/4/19
        return new Result(new Result<>());
    }

    @ControllerLog(doAction = "添加消息")
    @ApiOperation(value = "添加消息",notes = "添加消息", httpMethod = "POST")
    @PostMapping(value = "/addMessage")
    @RequiresPermissions("/message/list/addMessage")
    public Result addMessage(addMessageModel addMessageModel){
        //todo
        return new Result(new Result<>());
    }




}
