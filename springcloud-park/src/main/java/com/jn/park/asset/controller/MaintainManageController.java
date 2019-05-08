package com.jn.park.asset.controller;

import com.jn.common.model.Result;
import com.jn.park.asset.model.MaintainManageModel;
import com.jn.park.asset.service.MaintainManageService;
import com.jn.park.asset.service.MaintainRecordService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author： zhuyz
* @date： Created on 2019/5/5 16:29
* @version： v1.0
* @modified By:
*/
@Api(tags = "维保管理(APP)")
@RestController
@RequestMapping(value = "/asset/maintain")
public class MaintainManageController {

    @Autowired
    private MaintainManageService maintainManageService;
    @Autowired
    private MaintainRecordService maintainRecordService;

    @ControllerLog(doAction = "获取维保信息")
    @ApiOperation(value = "获取维保信息",notes = "获取维保信息")
    @GetMapping(value = "/getMaintain")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "维保信息id",example = "571720004983062528")
    })
    public Result<MaintainManageModel> getMaintain(String id){
       MaintainManageModel maintainManageModel =  maintainManageService.getMaintain(id);
        return new Result(maintainManageModel);
    }

    @ControllerLog(doAction = "维保录入")
    @ApiOperation(value = "维保信息录入",notes = "维保信息录入")
    @PostMapping(value = "/updateMaintain")
    public Result updateMaintain(MaintainManageModel maintainManageModel){
        Integer integer = maintainManageService.updateMaintain(maintainManageModel);
        if (integer > 0){
            return new Result();
        }
        return new Result("-1","维保信息录入失败");
    }

    @ControllerLog(doAction = "维保记录")
    @ApiOperation(value = "维保记录",notes = "维保记录")
    @PostMapping(value = "/addRecord")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "maintainId",value = "维保信息id",example = "571720004983062528"),
            @ApiImplicitParam(name = "message",value = "备注",example = "加了雪种"),
            @ApiImplicitParam(name = "imgUrl",value = "登记照片",example = "url")
    })
    public Result addRecord(String maintainId,String message,String imgUrl){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Integer integer = maintainRecordService.addRecord(user,maintainId,message,imgUrl);
        if (integer > 0){
            return new Result();
        }
        return new Result("-1","维保登记失败");
    }




}
