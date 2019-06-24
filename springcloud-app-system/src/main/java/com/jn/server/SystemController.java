package com.jn.server;

import com.jn.authorization.LoginService;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.encryption.EncryptUtil;
import com.jn.system.api.SystemClient;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.service.SysDepartmentService;
import com.jn.system.dept.service.SysPostService;
import com.jn.system.dict.service.SysDictService;
import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.service.SysFileGroupService;
import com.jn.system.file.service.SysFileService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.menu.service.SysResourcesService;
import com.jn.system.model.*;
import com.jn.system.permission.service.SysRoleService;
import com.jn.system.user.model.SysUser;
import com.jn.system.user.model.SysUserAdd;
import com.jn.system.user.service.SysUserService;
import com.jn.system.vo.SysDictKeyValue;
import com.jn.system.vo.SysUserRoleVO;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.schema.Collections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysFileService sysFileService;

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private SysPostService sysPostService;

    @Override
    @ControllerLog(doAction = "用户登录")
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

    @Override
    @ControllerLog(doAction = "添加用户")
    public Result<User> addSysUser(@Validated @RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        user.setPassword(EncryptUtil.encryptSha256(user.getPassword()));
        user.setRecordStatus(Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode()));
        SysUserAdd SysUserAdd = new SysUserAdd();
        BeanUtils.copyProperties(user, SysUserAdd);
        sysUserService.addSysUser(SysUserAdd, new User());
        return new Result(user);
    }

    @Override
    @ControllerLog(doAction = "获取部门信息")
    public Result selectDeptByParentId(@RequestParam(value = "parentId", required = false) String parentId,
                                       @RequestParam(value = "childFlag", required = false) Boolean childFlag) {
        Result result = sysDepartmentService.selectDeptByKey(parentId, childFlag);
        return result;
    }

    @Override
    @ControllerLog(doAction = "条件分页查询用户")
    public Result getUserByPage(@RequestBody UserPage page) {
        PaginationData data = sysUserService.findSysUserByPage(page);
        return new Result(data);
    }

    @Override
    @ControllerLog(doAction = "要查询的部门ID是否属于用户所属的部门或子部门")
    public Result checkUserDept(@RequestParam("userId") String userId, @RequestParam("deptId") String deptId) {
        Boolean result = sysDepartmentService.checkUserDept(userId, deptId);
        return new Result(result);
    }

    @Override
    @ControllerLog(doAction = "根据部门名称获取部门信息")
    public Result getDept(@RequestParam("deptName") String deptName) {
        TbSysDepartment tbSysDepartment = sysDepartmentService.getDept(deptName);
        return new Result(tbSysDepartment);
    }

    /**
     * 通过用户账号,获取用户信息,多个账号,返回多个用户信息
     *
     * @param accountList 账号集合
     * @return
     */
    @Override
    @ControllerLog(doAction = "通过用户账号,获取用户信息")
    public Result<List<User>> getUserInfoByAccount(@RequestBody List<String> accountList) {
        List<User> userList = sysUserService.getUserInfoByAccount(accountList);
        return new Result<>(userList);
    }

    /**
     * 通过用户id获取用户信息,传多id,返回多个用户信息
     *
     * @param ids 用户id集合
     * @return
     */
    @Override
    @ControllerLog(doAction = "通过用户id获取用户信息,传多id,返回多个用户信息")
    public Result<List<User>> getUserInfoByIds(@RequestBody List<String> ids) {
        List<User> userList = sysUserService.selectUserByIds(ids.toArray(new String[ids.size()]));
        return new Result<>(userList);
    }

    /**
     * 修改用户角色信息
     *
     * @param sysUserRoleVO
     * @return
     */
    @Override
    @ControllerLog(doAction = "修改用户角色信息")
    public Result<Boolean> updateUserRole(@RequestBody SysUserRoleVO sysUserRoleVO) {
        User user = sysUserRoleVO.getUser();
        Set<String> deleRoleIds = sysUserRoleVO.getDeleRoleIds();
        Set<String> addRoleId = sysUserRoleVO.getAddRoleId();
        Boolean result = sysUserService.updateUserRole(user, deleRoleIds, addRoleId);
        return new Result(result);
    }

    /**
     * 根据角色名称,获取角色信息
     *
     * @param roleName 角色名称
     * @return
     */
    @Override
    @ControllerLog(doAction = "根据角色名称,获取角色信息")
    public Result<SysRole> getRoleByName(@RequestParam("roleName") String roleName) {
        SysRole sysRole = sysRoleService.getRoleByName(roleName);
        return new Result<SysRole>(sysRole);
    }

    /**
     * 新增文件明细
     *
     * @param sysFile
     * @return
     */
    @Override
    @ControllerLog(doAction = "更新用户")
    public Result insertSysFile(@RequestBody SysFile sysFile) {
        sysFile.setId(UUID.randomUUID().toString());
        sysFileService.insertSysFile(sysFile);
        return new Result();
    }

    @Override
    @ControllerLog(doAction = "调用数据字典")
    public Result<List<SysDictKeyValue>> getDict(@RequestBody SysDictInvoke sysDictInvoke) {
        List<SysDictKeyValue> dictList = sysDictService.getDict(sysDictInvoke);
        return new Result(dictList);
    }

    @Override
    @ControllerLog(doAction = "根据角色id或角色名称获取角色拥有的用户信息")
    public Result<List<User>> getUserByRole(@RequestBody SysRole role) {
        List<User> userList = sysRoleService.getUserByRole(role);
        return new Result<List<User>>(userList);
    }

    @Override
    @ControllerLog(doAction = "获取所有岗位信息")
    public Result<List<SysPost>> getPostAll() {
        List<SysPost> sysPostAll = sysPostService.findSysPostAll();
        return new Result<>(sysPostAll);
    }

    @Override
    @ControllerLog(doAction = "校验用户账号是否存在")
    public Result<String> checkUserAccount(@RequestParam("account") String account) {
        String result = sysUserService.checkUserName(account);
        return new Result<>(result);
    }

    @Override
    @ControllerLog(doAction = "更新用户")
    public Result updateSysUser(@Validated @RequestBody User user) {
        if (StringUtils.isNotBlank(user.getAccount())) {
            List<User> u = sysUserService.findTByT(user);
            if (u == null || u.size() == 0) {
                throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
            }
            user.setId(u.get(0).getId());
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        sysUserService.updateSysUser(sysUser, new User());
        return new Result();
    }

    /**
     * 根据条件查询数据字典的值
     *
     * @param sysDictInvoke
     * @return
     */
    @Override
    @ControllerLog(doAction = "根据条件查询数据字典的值")
    public Result<String> selectDictValueByCondition(@RequestBody SysDictInvoke sysDictInvoke) {
        String data = sysDictService.selectDictValueByCondition(sysDictInvoke);
        return new Result(data);
    }


}
