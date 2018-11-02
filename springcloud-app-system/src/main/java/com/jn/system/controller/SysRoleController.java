package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色Controler
 * @author： shaobao
 * @date： Created on 2018/11/1 16:22
 * @version： v1.0
 * @modified By:
 **/
@RestController
@RequestMapping("/system/sysDepartment")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping("/findSysRoleAll")
    public Result findSysRoleAll(){
        return  sysRoleService.findSysRoleAll();
    }
}
