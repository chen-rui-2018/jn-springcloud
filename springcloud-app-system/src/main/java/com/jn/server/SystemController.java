package com.jn.server;

import com.jn.authorization.LoginService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.api.SystemClient;
import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.service.SysFileGroupService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.menu.service.SysResourcesService;
import com.jn.system.model.MenuResources;
import com.jn.system.model.User;
import com.jn.system.model.UserLogin;
import com.jn.system.model.UserNoPasswordLogin;
import com.jn.system.user.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 提供内部使用的API接口
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By: shenph
 */
@RestController
public class SystemController extends BaseController implements SystemClient {

    private static Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysResourcesService sysResourcesService;

    @Autowired
    private SysFileGroupService sysFileGroupService;

    @Override
    @ControllerLog(doAction = "免密登录")
    public Result<String> login(@RequestBody @Validated UserLogin userLogin) {
        loginService.login(userLogin, Boolean.FALSE);
        return new Result(SecurityUtils.getSubject().getSession().getId());
    }


    @Override
    @ControllerLog(doAction = "免密登录")
    public Result<String> noPasswordLogin(@RequestBody @Validated UserNoPasswordLogin userNoPasswordLogin) {
        UserLogin userLogin = new UserLogin();
        userLogin.setAccount(userNoPasswordLogin.getAccount());
        userLogin.setPassword("");
        loginService.login(userLogin, Boolean.TRUE);
        return new Result(SecurityUtils.getSubject().getSession().getId());
    }


    @Override
    @ControllerLog(doAction = "获取用户")
    public Result<User> getUser(@RequestBody @Validated User u) {
        logger.info("进入获取用户的API,用户参数：{}", u.toString());
        List<User> user = sysUserService.findTByT(u);
        if (user == null || user.size() == 0) {
            return new Result();
        }
        return new Result(user.get(0));
    }

    @Override
    @ControllerLog(doAction = "获取用户权限（菜单、功能）")
    public Result<Set<String>> getResources(@RequestBody String id) {
        Set<String> resourcesList = sysResourcesService.findPermissionsUrlById(id);
        return new Result(resourcesList);
    }

    @Override
    @ControllerLog(doAction = "获取菜单、功能资源")
    public Result<List<MenuResources>> getMenuResources(@RequestBody String id) {
        List<MenuResources> menuResourcesList = sysResourcesService.getMenuResourcesUrlById(id);
        return new Result(menuResourcesList);
    }

    @Override
    @ControllerLog(doAction = "根据用户获取文件组")
    public Result getUserFileGroup(@RequestBody String userId) {
        List<TbSysFileGroup> userFileGruopList = sysFileGroupService.getUserFileGroupById(userId);
        return new Result(userFileGruopList);
    }

    @Override
    @ControllerLog(doAction = "获取用户是否拥有该文件的下载权限")
    public Result<Boolean> getUserFilePermission(@RequestBody String userId, @RequestParam("fileUrl") String fileUrl) {
        Boolean isUserFilePermission = sysFileGroupService.getUserFilePermission(userId, fileUrl);
        return new Result(isUserFilePermission);
    }


    @Override
    @ControllerLog(doAction = "获取所有有效用户信息")
    public Result getUserAll() {
        List<User> userList = sysUserService.getUserAll();
        return new Result(userList);
    }

}
