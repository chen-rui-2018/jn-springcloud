package com.wangsong.system.controller;

import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.Result;
import com.wangsong.system.model.User;
import com.wangsong.system.model.UserAddModel;
import com.wangsong.system.model.UserPage;
import com.wangsong.system.service.UserService;
import com.wangsong.system.vo.UserVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result add(UserAddModel user) {
        userService.insertUser(user);
        return new Result();

    }


    @RequestMapping(value = "/selectByPrimaryKey")
    public UserVO selectByPrimaryKey(String id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequiresPermissions("/system/user/update")
    @RequestMapping(value = "/update")
    public Result update(UserAddModel muser) {
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
        User tByT = userService.findTByT(user);
        return new Result(tByT);

    }

    @RequestMapping(value = "/toUpdatePassword")
    public User toUpdatePassword() {
        return userService.selectByPrimaryKey();
    }

    @RequestMapping(value = "/updatePassword")
    public Result updatePassword(UserAddModel muser) {
        userService.updatePassword(muser);
        return new Result();

    }

}
