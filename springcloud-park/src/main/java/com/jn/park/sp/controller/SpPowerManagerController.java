package com.jn.park.sp.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.park.sp.model.SpMessageModel;
import com.jn.park.sp.model.SpParam;
import com.jn.park.sp.service.SpPowerPortalService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
*
* @author： zhuyz
* @date： Created on 2019/4/17 15:12
* @version： v1.0
* @modified By:
*/
@Api(tags = "对外行政审批中心-后台管理")
@RestController
@RequestMapping("/sp/power")
public class SpPowerManagerController extends BaseController {
    @Autowired
    private SpPowerPortalService spPowerPortalService;



    @ControllerLog(doAction = "把行政审批指南推送给全部企业")
    @ApiOperation(value = "把行政审批指南推送给全部企业", notes = "把行政审批指南推送给全部企业")
    @RequestMapping(value = "/pushPowerBusi",method = RequestMethod.POST)
    @RequiresPermissions("/sp/power/pushPowerBusi")
    public Result pushPowerBusi(@RequestBody SpParam spParam, @ApiParam ServiceCompanyParam serviceCompanyParam){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Integer count=spPowerPortalService.pushPowerBusiBatch(spParam.getPowerBusiIds(),serviceCompanyParam,user.getId());
        return new Result("成功推送"+count+"条");
    }
}
