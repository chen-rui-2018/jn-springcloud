package com.jn.enterprise.pd.personnel.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.personnel.model.PersonnelAppointmentCounselModel;
import com.jn.enterprise.pd.personnel.service.AppointmentCounselService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 预约辅导管理
 *
 * @author： wzy
 * @date： Created on 2019/3/18 18:50
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "预约辅导管理")
@RestController
@RequestMapping("/pd/appointmentCounsel")
public class AppointmentCounselController extends BaseController {

    @Autowired
    private AppointmentCounselService appointmentCounselService;


    @ControllerLog(doAction = "查询预约辅导列表")
    @ApiOperation(value = "查询预约辅导列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/pd/appointmentCounsel/list")
    public Result list(@Validated @RequestBody PersonnelAppointmentCounselModel pdCounselModel) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PaginationData data = appointmentCounselService.selectAppointmentCounselListBySearchKey(pdCounselModel,user);
        return new Result(data);
    }
}
