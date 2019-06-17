package com.jn.enterprise.pd.declaration.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManage;
import com.jn.enterprise.pd.declaration.enums.ExceptionStatusEnums;
import com.jn.enterprise.pd.declaration.model.DeclarationOnlineModel;
import com.jn.enterprise.pd.declaration.model.DeclarationOnlineReservationManageModel;
import com.jn.enterprise.pd.declaration.service.DeclarationOnlinkService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 预约申报
 *
 * @author： wzy
 * @date： Created on 2019/4/17 19:23
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "申报中心-预约申报")
@RestController
@RequestMapping("/pd/online")
public class DeclarationOnlinkController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeclarationOnlinkController.class);

    @Autowired
    private DeclarationOnlinkService declarationOnlinkService;

    @ControllerLog(doAction = "申报中心预约申报")
    @ApiOperation(value = "申报中心预约申报", notes = "申报中心预约申报")
    @RequestMapping(value = "/onlineBooking" ,method = RequestMethod.POST)
    @RequiresPermissions("/pd/online/onlineBooking")
    public Result onlineBooking(@Validated @RequestBody DeclarationOnlineReservationManageModel declarationOnline){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(declarationOnline.getAppointmentItemId(),ExceptionStatusEnums.ITEMID_NOT_NULL.getMessage());
        Assert.notNull(declarationOnline.getAppointmentItemName(),ExceptionStatusEnums.ITEMNAME_NOT_NULL.getMessage());
        Assert.notNull(declarationOnline.getContactName(),ExceptionStatusEnums.CONTACTNAME_NOT_NULL.getMessage());
        Assert.notNull(declarationOnline.getContactPhone(),ExceptionStatusEnums.CONTACTPHONE_NOT_NULL.getMessage());
        Assert.notNull(declarationOnline.getEmail(),ExceptionStatusEnums.EMAIL_NOT_NULL.getMessage());
        Assert.notNull(declarationOnline.getDeclareEnterprise(),ExceptionStatusEnums.DECLAREENTERPRISE_NOT_NULL.getMessage());
        Assert.notNull(declarationOnline.getDeclareItem(),ExceptionStatusEnums.DECLAREITEM_NOT_NULL.getMessage());
        return declarationOnlinkService.onlineBooking(declarationOnline, user);
    }

    @ControllerLog(doAction = "通过公告ID和登录人查询预约信息")
    @ApiOperation(value = "通过公告ID和登录人查询预约信息", notes = "通过公告ID和登录人查询预约信息")
    @RequestMapping(value = "/queryOnlineInfo" ,method = RequestMethod.GET)
    @RequiresPermissions("/pd/online/queryOnlineInfo")
    public Result<DeclarationOnlineModel> queryOnlineInfo(@ApiParam(value = "预约项ID（即公告ID）",example = "572004159012732928") @RequestParam(name = "appointmentItemId") String appointmentItemId){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(appointmentItemId,"公告ID不能为空！");
        return declarationOnlinkService.queryOnlineInfo(appointmentItemId,user);
    }

}
