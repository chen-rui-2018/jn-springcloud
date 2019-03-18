package com.jn.enterprise.pd.personnel.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
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
@Api(tags = "项目申报-人才申报-后台")
@RestController
@RequestMapping("/pd/personnel")
public class PersonnelController extends BaseController {


    @ControllerLog(doAction = "人才中心-审批人才意向申报")
    @ApiOperation(value = "人才中心-审批人才意向申报", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/flow/twoAreaPlanCounsel20")
    @RequiresPermissions("/pd/personnel/flow/twoAreaPlanCounsel20")
    public Result<PersonnelFirstStart20Model> twoAreaPlanCounsel20(){
        PersonnelFirstStart20Model model =new PersonnelFirstStart20Model(PersonnelFlowNodeEnum.TWO_AREA_PLAN_COUNSEL_20.getNodeNo());
        return new Result<>(model);
    }






}
