package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门
 * @author： shaobao
 * @date： Created on 2018/10/31 17:05
 * @version： v1.0
 * @modified By:
 **/
@RestController
@RequestMapping("/system/sysDepartment")
public class SysDepartmentController extends BaseController {

    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping("/findSysDepartmentAll")
    public Result findSysDepartmentAll(){
        return sysDepartmentService.findSysDepartmentAll();
    }

}
