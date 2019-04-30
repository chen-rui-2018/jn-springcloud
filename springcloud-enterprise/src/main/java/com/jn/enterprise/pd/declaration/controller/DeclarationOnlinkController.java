package com.jn.enterprise.pd.declaration.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.pd.declaration.enums.ExceptionStatusEnums;
import com.jn.enterprise.pd.declaration.model.DeclarationOnlineReservationManageModel;
import com.jn.enterprise.pd.declaration.service.DeclarationOnlinkService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        declarationOnlinkService.onlineBooking(declarationOnline, user);
        return new Result();
    }

}
