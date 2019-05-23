package com.jn.park.connect.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.connect.model.ServiceConnectModel;
import com.jn.park.connect.service.ServiceConnectService;
import com.jn.park.message.model.FindAllMessageListVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author： tangry
 * @date： Created on 2019/4/26
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "服务连接-管理")
@RestController
@RequestMapping("/connect/manage")
public class ServiceConnectController extends BaseController {
    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }
    @Autowired
    private ServiceConnectService serviceConnectService;

    @ControllerLog(doAction = "获取连接")
    @ApiOperation(value = "获取连接",notes = "获取连接以及图片", httpMethod = "GET")
    @GetMapping(value = "/getImgAndAddress")
    @RequiresPermissions("/connect/manage/getImgAndAddress")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entranceNameCode",value = "名称编号",dataType = "String",paramType = "query")
    })
    public Result<FindAllMessageListVo> getImgAndAddress(String entranceNameCode){
        // TODO: 2019/4/19

        ServiceConnectModel serviceConnectModel=serviceConnectService.getImgAndAddress(entranceNameCode);

        return new Result(serviceConnectModel);
    }




}
