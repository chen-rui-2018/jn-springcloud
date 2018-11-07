package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.model.User;
import com.jn.system.model.UserAdd;
import com.jn.system.model.UserPage;
import com.jn.system.service.UserService;
import com.jn.system.vo.UserVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiIgnore()
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;


    @RequiresPermissions("/system/user/list")
    @RequestMapping(value = "/list")
    public Object list(UserPage user) {
        return userService.findTByPage(user);
    }

    @RequiresPermissions("/system/user/add")
    @RequestMapping(value = "/add")
    public Result add(UserAdd user) {
        userService.insertUser(user);
        return new Result();

    }

    @RequestMapping(value = "/genertor/test")
    public Result<User> test(User user) {
        Assert.isNull(user.getPassword(),"不允许使用密码进行查询");
        return new Result(userService.findTByT(user));
    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public UserVO selectByPrimaryKey(String id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequiresPermissions("/system/user/update")
    @RequestMapping(value = "/update")
    public Result update(UserAdd muser) {
        Assert.notNull(muser.getId(),"用户ID不能为空");
        userService.updateUser(muser);
        return new Result();

    }

    @RequiresPermissions("/system/user/delete")
    @RequestMapping(value = "/delete")
    public Result delete(String[] id) {
        userService.deleteUser(id);
        return new Result();

    }

    @RequestMapping(value = "/findUserByUser")
    public Result findUserByUser(User user) {
        User tByT = userService.findTByT(user).get(0);
        return new Result(tByT);

    }

    @RequestMapping(value = "/toUpdatePassword")
    public User toUpdatePassword() {
        return userService.selectByPrimaryKey();
    }

    @RequestMapping(value = "/updatePassword")
    public Result updatePassword(UserAdd muser) {
        userService.updatePassword(muser);
        return new Result();

    }

}
