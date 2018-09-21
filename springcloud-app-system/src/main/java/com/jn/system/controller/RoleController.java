package com.jn.system.controller;


import com.jn.common.controller.BaseController;
import com.jn.common.model.GetEasyUIData;
import com.jn.common.model.Result;
import com.jn.system.model.Role;
import com.jn.system.model.RoleAddModel;
import com.jn.system.model.RolePage;
import com.jn.system.service.RoleService;
import com.jn.system.vo.RoleVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;


    @RequiresPermissions("/system/role/list")
    @RequestMapping(value = "/list")
    public GetEasyUIData list(HttpServletRequest request, RolePage role) {
        return roleService.findTByPage(role);
    }


    @RequiresPermissions("/system/role/add")
    @RequestMapping(value = "/add")
    public Result add(RoleAddModel role) {
        roleService.insertRole(role);
        return new Result();

    }

    @RequiresPermissions("/system/role/delete")
    @RequestMapping(value = "/delete")
    public Result delete(String[] id) {
        roleService.deleteRole(id);
        return new Result();
    }

    @RequiresPermissions("/system/role/update")
    @RequestMapping(value = "/update")
    public Result update(RoleAddModel mrole) {
        Assert.notNull(mrole.getId(),"不能传空值");
        roleService.updateRole(mrole);
        return new Result();
    }

    @RequestMapping(value = "/listAll")
    public List<Role> listAll() {
        return roleService.selectAll();
    }

    @RequestMapping(value = "/selectByPrimaryKey")
    public RoleVO selectByPrimaryKey(String id) {
        return roleService.selectByPrimaryKey(id);
    }

}
