package com.jn.oa.addressBook.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.oa.addressBook.service.AddressBookService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通讯录管理
 *
 * @author： shaobao
 * @date： Created on 2019/3/8 18:18
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "通讯录管理")
@RestController
@RequestMapping("/oa/addressBook")
public class AddressBookController extends BaseController {

    @Autowired
    private AddressBookService addressBookService;

    @ControllerLog(doAction = "获取用户信息详情")
    @ApiOperation(value = "获取用户信息详情", notes = "根据用户账号获取用户信息详情")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @RequiresPermissions("/oa/addressBook/getUserInfo")
    public Result<User> getUserInfo(@RequestParam("userAccount") String userAccount) {
        Result<User> result = addressBookService.getUserInfo(userAccount);
        return result;
    }


    @ControllerLog(doAction = "获取用户列表")
    @ApiOperation(value = "获取用户列表", notes = "条件分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("/oa/addressBook/list")
    public Result list(@RequestBody UserPage userPage) {
        Result result = addressBookService.list(userPage);
        return result;
    }

    @ControllerLog(doAction = "获取部门树信息")
    @ApiOperation(value = "获取部门树信息", notes = "获取部门树信息")
    @RequestMapping(value = "/getDeptTree", method = RequestMethod.POST)
    @RequiresPermissions("/oa/addressBook/getDeptTree")
    public Result getDeptTree() {
        Result result = addressBookService.getDeptTree();
        return result;
    }

}
