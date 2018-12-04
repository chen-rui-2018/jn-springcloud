package com.jn.server;

import com.jn.authorization.LoginService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
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
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/system")
public class SystemController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysResourcesService sysResourcesService;

    @Autowired
    private SysFileGroupService sysFileGroupService;

    @ControllerLog(doAction = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<String> loginPost(@RequestBody @Validated UserLogin userLogin) {
        loginService.login(userLogin, Boolean.FALSE);
        return new Result(SecurityUtils.getSubject().getSession().getId());
    }

    @ControllerLog(doAction = "免密登录")
    @RequestMapping(value = "/noPasswordLogin", method = RequestMethod.POST)
    public Result<String> noPasswordLogin(@RequestBody @Validated UserNoPasswordLogin userNoPasswordLogin) {
        UserLogin userLogin = new UserLogin();
        userLogin.setAccount(userNoPasswordLogin.getAccount());
        userLogin.setPassword("");
        loginService.login(userLogin, Boolean.TRUE);
        return new Result(SecurityUtils.getSubject().getSession().getId());
    }

    @ControllerLog(doAction = "获取用户")
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public Result<User> getUser(@RequestBody @Validated User u) {
        logger.info("进入获取用户的API,用户参数：{}", u.toString());
        List<User> user = sysUserService.findTByT(u);

        if (user == null || user.size() == 0) {
            return new Result();
        }
        return new Result(user.get(0));
    }

    @ControllerLog(doAction = "获取用户权限（菜单、功能）")
    @RequestMapping(value = "/getResources", method = RequestMethod.POST)
    public Result<Set<String>> getResources(@RequestBody String id) {
        Set<String> resourcesList = sysResourcesService.findPermissionsUrlById(id);
        return new Result(resourcesList);
    }

    @ControllerLog(doAction = "获取菜单、功能资源")
    @RequestMapping(value = "/getMenuResources", method = RequestMethod.POST)
    public Result<List<MenuResources>> getMenuResources(@RequestBody String id) {
        List<MenuResources> menuResourcesList = sysResourcesService.getMenuResourcesUrlById(id);
        return new Result(menuResourcesList);
    }

    @ControllerLog(doAction = "根据用户获取文件组")
    @RequestMapping(value = "/getUserFileGroup", method = RequestMethod.POST)
    public Result<List<TbSysFileGroup>> getUserFileGroup(@RequestBody String userId) {
        List<TbSysFileGroup> userFileGruopList = sysFileGroupService.getUserFileGroupById(userId);
        return new Result(userFileGruopList);
    }

    @ControllerLog(doAction = "获取用户是否拥有该文件的下载权限")
    @RequestMapping(value = "/getUserFilePermission", method = RequestMethod.POST)
    public Result<Boolean> getUserFilePermission(@RequestBody String userId, @RequestParam("fileUrl") String fileUrl) {
        Boolean isUserFilePermission = sysFileGroupService.getUserFilePermission(userId, fileUrl);
        return new Result(isUserFilePermission);
    }
}
