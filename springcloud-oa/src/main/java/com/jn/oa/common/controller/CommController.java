package com.jn.oa.common.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.oa.common.service.CommService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 协同办公公共控制层
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 16:27
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "协同办公公共控制层")
@RestController
@RequestMapping("/oa/commController")
public class CommController extends BaseController {

    @Autowired
    private CommService commService;

    @ControllerLog(doAction = "获取工单编码")
    @ApiOperation(value = "获取工单编码", httpMethod = "POST", response = Result.class)
    @RequestMapping("/getOrderNum")
    public Result getOrderNum() {
        String orderNum = commService.getOrderNum();
        return new Result(orderNum);
    }
}
