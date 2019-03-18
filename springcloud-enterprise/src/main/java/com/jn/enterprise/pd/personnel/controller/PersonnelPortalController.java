package com.jn.enterprise.pd.personnel.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import com.jn.enterprise.pd.personnel.model.PersonnelFirstStart10Model;
import com.jn.enterprise.pd.personnel.model.PersonnelFirstStart20Model;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author： huangbq
 * @date： Created on 2019/3/18 9:41
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "项目申报-人才申报-门户")
@RestController
@RequestMapping("/portal/pd/personnel")
public class PersonnelPortalController extends BaseController {



    @ControllerLog(doAction = "企业-人才意向申报")
    @ApiOperation(value = "企业-人才意向申报", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/flow/firstStart10")
    @RequiresPermissions("/portal/pd/personnel/flow/firstStart10")
    public Result<PersonnelFirstStart10Model> firstStart10(){
        PersonnelFirstStart10Model startModel =new PersonnelFirstStart10Model(PersonnelFlowNodeEnum.FIRST_START_10.getNodeNo());
        return new Result<>(startModel);
    }

    @ControllerLog(doAction = "查看")
    @ApiOperation(value = "查看", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/flow/detail")
    @RequiresPermissions("/portal/pd/personnel/flow/detail")
    public Result flow(){
        PersonnelFirstStart10Model startModel =new PersonnelFirstStart10Model(PersonnelFlowNodeEnum.FIRST_START_10.getNodeNo());
        return new Result<>(startModel);
    }
}
