package com.jn.park.sp.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.sp.model.SpMessageModel;
import com.jn.park.sp.service.SpPowerPortalService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
*
* @author： zhuyz
* @date： Created on 2019/4/17 15:12
* @version： v1.0
* @modified By:
*/
@Api(tags = "对外行政审批中心-门户")
@RestController
@RequestMapping("/portal/sp/power")
public class SpPowerPortalController extends BaseController {
    @Autowired
    private SpPowerPortalService spPowerPortalService;

    @ControllerLog(doAction = " 我要留言")
    @ApiOperation(value = "我要留言", notes = "进行留言")
    @RequestMapping(value = "/SpMessage",method = RequestMethod.POST)
    @RequiresPermissions("/portal/sp/power/SpMessage")
    public Result SpMessage(@RequestBody SpMessageModel spMessageModel){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        spMessageModel.setId(UUID.randomUUID().toString());
        Integer integer = spPowerPortalService.SpMessage(spMessageModel,user);
        if (integer > 0){
            return new Result(integer);
        }
        return new Result("-1","留言失败");
    }

}
