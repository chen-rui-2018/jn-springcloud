package com.jn.system.api;

import com.jn.common.model.Result;
import com.jn.system.model.*;
import com.jn.system.vo.SysDictKeyValue;
import com.jn.system.vo.SysUserRoleVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * 系统客户端
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By: shenph
 */
@FeignClient("springcloud-app-system")
public interface SystemClient {

    /**
     * 用户登录
     *
     * @param u
     * @return
     */
    @RequestMapping(value = "/api/system/login", method = RequestMethod.POST)
    Result<String> login(@RequestBody UserLogin u);

    /**
     * 免密登录
     *
     * @param u
     * @return
     */
    @RequestMapping(value = "/api/system/noPasswordLogin", method = RequestMethod.POST)
    Result<String> noPasswordLogin(@RequestBody UserNoPasswordLogin u);

    /**
     * 获取用户信息
     *
     * @param u
     * @return
     */
    @RequestMapping(value = "/api/system/getUser", method = RequestMethod.POST)
    Result<User> getUser(@RequestBody User u);

    /**
     * 获取资源列表
     *
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/api/system/getResources", method = RequestMethod.POST)
    Result<Set<String>> getResources(@RequestBody String userId);

    /**
     * 获取菜单功能URL列表
     *
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/api/system/getMenuResources", method = RequestMethod.POST)
    Result<List<MenuResources>> getMenuResources(@RequestBody String userId);

    /**
     * 获取用户文件组
     *
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/api/system/getUserFileGroup", method = RequestMethod.POST)
    Result getUserFileGroup(@RequestBody String userId);

    /**
     * 获取用户是否拥有该文件的下载权限
     *
     * @param userId  用户ID
     * @param fileUrl 文件URL
     * @return
     */
    @RequestMapping(value = "/api/system/getUserFilePermission", method = RequestMethod.POST)
    Result<Boolean> getUserFilePermission(@RequestBody String userId, @RequestParam("fileUrl") String fileUrl);

    /**
     * 获取所有有效用户信息
     *
     * @return
     */
    @RequestMapping(value = "/api/system/getUserAll", method = RequestMethod.POST)
    Result getUserAll();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/api/system/addSysUser", method = RequestMethod.POST)
    Result addSysUser(@RequestBody User user);

    /**
     * 根据用户ID或者账号，更新用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/api/system/updateSysUser", method = RequestMethod.POST)
    Result updateSysUser(@RequestBody User user);

    /**
     * 查询所有部门信息,并根据层级关系返回数据
     *
     * @param parentId  parentId,查询对应部门,为空时查询所以一级部门
     * @param childFlag 是否查询所有子部门,true是,false否
     * @return
     */
    @RequestMapping(value = "/api/system/selectDeptByParentId", method = RequestMethod.POST)
    Result selectDeptByParentId(@RequestParam(value = "parentId", required = false) String parentId,
                                @RequestParam(value = "childFlag", required = false) Boolean childFlag);

    /**
     * 条件分页查询用户信息
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/api/system/getUserByPage", method = RequestMethod.POST)
    Result getUserByPage(@RequestBody UserPage page);


    /**
     * 要查询的部门ID是否属于用户所属的部门或子部门
     *
     * @param userId 用户id
     * @param deptId 部门id
     * @return
     */
    @RequestMapping(value = "/api/system/checkUserDept", method = RequestMethod.POST)
    Result checkUserDept(@RequestParam("userId") String userId, @RequestParam("deptId") String deptId);

    /**
     * 根据部门名称,获取部门信息
     *
     * @param deptName 部门名称
     * @return
     */
    @RequestMapping(value = "/api/system/getDept", method = RequestMethod.POST)
    Result getDept(@RequestParam("deptName") String deptName);

    /**
     * 通过用户账号获取用户信息,传多账号,返回多个用户信息
     *
     * @param accountList 账号集合
     * @return
     */
    @RequestMapping(value = "/api/system/getUserInfoByAccount", method = RequestMethod.POST)
    Result<List<User>> getUserInfoByAccount(@RequestBody List<String> accountList);

    /**
     * 通过用户id获取用户信息,传多id,返回多个用户信息
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/api/system/getUserInfoByIds", method = RequestMethod.POST)
    Result<List<User>> getUserInfoByIds(@RequestBody List<String> ids);

    /**
     * 修改用户角色信息
     *
     * @param sysUserRoleVO
     * @return
     */
    @RequestMapping(value = "/api/system/updateUserRole", method = RequestMethod.POST)
    Result<Boolean> updateUserRole(@RequestBody SysUserRoleVO sysUserRoleVO);

    /**
     * 根据角色名称获取角色信息
     *
     * @param roleName 角色名称
     * @return
     */
    @RequestMapping(value = "/api/system/getRoleByName", method = RequestMethod.GET)
    Result<SysRole> getRoleByName(@RequestParam("roleName") String roleName);


    /**
     * 新增文件明细
     *
     * @param sysFile
     * @return
     */
    @RequestMapping(value = "/api/system/insertSysFile", method = RequestMethod.POST)
    Result insertSysFile(@RequestBody SysFile sysFile);

    /**
     * 根据条件查询数据字典的值
     *
     * @param sysDictInvoke
     * @return
     */
    @RequestMapping(value = "/api/system/selectDictValueByCondition", method = RequestMethod.POST)
    Result<String> selectDictValueByCondition(@RequestBody SysDictInvoke sysDictInvoke);

    /**
     * 调用数据字典
     *
     * @return
     */
    @RequestMapping(value = "/api/system/getDict", method = RequestMethod.POST)
    Result<List<SysDictKeyValue>> getDict(@RequestBody SysDictInvoke sysDictInvoke);

    /**
     * 根据角色id或角色名称获取角色拥有的用户信息
     * 当id和角色名称同时存在时,优先使用id信息
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/api/system/getUserByRole", method = RequestMethod.POST)
    Result<List<User>> getUserByRole(@RequestBody SysRole role);

    /**
     * 获取所有岗位信息
     *
     * @return
     */
    @RequestMapping(value = "/api/system/getPostAll", method = RequestMethod.POST)
    Result<List<SysPost>> getPostAll();


    /**
     * 校验用户账号是否存在
     *
     * @param account 用户账号
     * @return success:账号不存在; fail:账号存在
     */
    @RequestMapping(value = "/api/system/checkUserAccount", method = RequestMethod.POST)
    Result<String> checkUserAccount(@RequestParam("account") String account);

}