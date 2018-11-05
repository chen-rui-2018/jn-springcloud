package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.service.SysPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO:岗位管理
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "岗位管理")
@RestController
@RequestMapping("/system/sysPost")
public class SysPostController extends BaseController{

    @Autowired
    private SysPostService sysPostService;

    /**
     * 查询所有岗位
     * @return
     */
    @ApiOperation(value = "查询所有岗位",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/findSysPostAll")
    private Result findSysPostAll(){
        return sysPostService.findSysPostAll();
    }

    /**
     * 根据部门id获取对应岗位
     * @return
     */
    @ApiOperation(value = "根据部门id获取对应岗位",httpMethod = "POST",response = Result.class)
    @RequestMapping(value = "/findSysPostByDepartmentId")
    public Result findSysPostByDepartmentId(String departmentId ){
        return sysPostService.findSysPostByDepartmentId(departmentId);
    }
}
