package com.jn.park.asset.controller;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.asset.enums.PageExceptionEnums;
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

import java.util.List;

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

    @ControllerLog(doAction = "维保设备列表")
    @ApiOperation(value = "维保设备列表",notes = "返回维保设备列表")
    @GetMapping(value = "/maintainList")
    public Result<PaginationData<List<MaintainManageModel>>> getMaintainList(Page page){
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<MaintainManageModel>> data = maintainManageService.getMaintainList(page);
            return new Result(data);
        }else{
            throw new JnSpringCloudException(PageExceptionEnums.PAGE_NOT_NULL);
        }
    }

    @ControllerLog(doAction = "获取维保信息")
    @ApiOperation(value = "获取维保信息",notes = "获取维保信息")
    @GetMapping(value = "/getMaintain")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetNumber",value = "资产编号",example = "572058527984517120")
    })
    public Result<MaintainManageModel> getMaintain(String assetNumber){
       MaintainManageModel maintainManageModel =  maintainManageService.getMaintain(assetNumber);
        return new Result(maintainManageModel);
    }


    @ControllerLog(doAction = "维保登记")
    @ApiOperation(value = "维保登记",notes = "维保登记")
    @PostMapping(value = "/addRecord")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetNumber",value = "资产编号",example = "572058527984517120"),
            @ApiImplicitParam(name = "message",value = "备注",example = "加了雪种"),
            @ApiImplicitParam(name = "imgUrl",value = "登记照片",example = "url")
    })
    public Result addRecord(String assetNumber,String message,String imgUrl){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Integer integer = maintainRecordService.addRecord(user,assetNumber,message,imgUrl);
        if (integer > 0){
            return new Result();
        }
        return new Result("-1","维保登记失败");
    }




}
