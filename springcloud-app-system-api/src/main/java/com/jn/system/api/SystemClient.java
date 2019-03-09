package com.jn.system.api;

import com.jn.common.model.Result;
import com.jn.system.model.*;
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
     * @param parentId   parentId,查询对应部门,为空时查询所以一级部门
     * @param childsFlag 是否查询所有子部门,true是,false否
     * @return
     */
    @RequestMapping(value = "/api/system/selectDeptByParentId", method = RequestMethod.POST)
    Result selectDeptByParentId(@RequestParam("parentId") String parentId, @RequestParam("childsFlag") Boolean childsFlag);

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

}