package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.service.SysGroupService;
import com.jn.system.model.SysGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户组管理
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "用户组管理")
@RestController
@RequestMapping("/system/sysGroup")
public class SysGroupController extends BaseController {

    @Autowired
    private SysGroupService sysGroupService;

    /**
     * 查询所有用户组
     * @return
     */
    @ApiOperation(value = "查询所有用户组",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/findSysGroupAll")
    public Result findSysGroupAll(){
        return sysGroupService.findSysGroupAll();
    }

    /**
     * 用户组添加
     * @param sysGroup 用户组
     * @return
     */
    @ApiOperation(value = "用户组添加",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/addSysGroup")
    public Result addSysGroup(SysGroup sysGroup){
        sysGroupService.addSysGroup(sysGroup);
        return new Result();
    }

    /**
     * 逻辑删除用户组
     * @param groupIds 用户组id数组
     * @return
     */
    @ApiOperation(value = "逻辑删除用户组",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/deleSysGroup")
    public Result deleSysGroup(String[] groupIds){
        if(groupIds != null && groupIds.length > 0 ){
            sysGroupService.deleSysGroup(groupIds);
        }
        return new Result();
    }

    /**
     * 修改用户组信息
     * @param sysGroup 用户组对象
     * @return
     */
    @ApiOperation(value = "修改用户组信息",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/updateSysGroup")
    public Result updateSysGroup(SysGroup sysGroup){
        sysGroupService.updateSysGroup(sysGroup);
        return new Result();
    }

    /**
     * 根据用户组id获取用户组信息
     * @param id 用户组id
     * @return
     */
    @ApiOperation(value = "根据用户组id获取用户组信息",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/findSysGroupById")
    public Result findSysGroupById(String id){
        return sysGroupService.findSysGroupById(id);
    }

}
