package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.service.SysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： shaobao
 * @date： Created on 2018/10/31 16:19
 * @version： v1.0
 * @modified By:
 **/
@RestController
@RequestMapping("/system/sysPost")
public class SysPostController extends BaseController{

    @Autowired
    private SysPostService sysPostService;

    /**
     * 查询所有岗位
     * @return
     */
    @RequestMapping("/findSysPostAll")
    private Result findSysPostAll(){
        return sysPostService.findSysPostAll();
    }

    /**
     * 根据部门id获取对应岗位
     * @return
     */
    @RequestMapping("/findSysPostByDepartmentId")
    public Result findSysPostByDepartmentId(String departmentId ){
        return sysPostService.findSysPostByDepartmentId(departmentId);
    }
}
