package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.model.QueryVo;
import com.jn.system.service.SysUserService;
import com.jn.system.vo.TbSysUser;
import com.jn.system.vo.TbSysUserDepartmentPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统用户
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 13:06
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;

    /**
     * 添加用户
     * @param sysUser
     */
    @RequestMapping("/addSysUser")
    public Result addSysUser(TbSysUser sysUser){
        sysUserService.addSysUser(sysUser);
        return new Result();
    }

    /**
     * 查询用户
     * @param userQueryVo
     * @return
     */
    @RequestMapping("/findSysUserByPage")
    public Result findSysUserByPage(QueryVo userQueryVo){
        return sysUserService.findSysUserByPage(userQueryVo);
    }

    /**
     * 根据用户id返回用户信息
     * @param id
     * @return
     */
    @RequestMapping("/findSysUserById")
    public Result findSysUserById(String id){
        return sysUserService.findSysUserById(id);
    }

    /**
     * 删除用户
     * @param ids
     * @return
     */
    @RequestMapping("/deleteSysUser")
    public Result deleteSysUser(String[] ids){
        sysUserService.deleteSysUser(ids);
        return new Result();
    }

    /**
     * 更新用户
     * @param sysUser
     * @return
     */
    @RequestMapping("/updateSysUser")
    public Result updateSysUser(TbSysUser sysUser){
        sysUserService.updateSysUser(sysUser);
        return new Result();
    }

    /**
     * 根据用户id获取用户已经存在的用户组及其他用户组
     * @return
     */
    @RequestMapping("/findSysGroupByUserId")
    public Result findSysGroupByUserId(String id){
        return sysUserService.findSysGroupByUserId(id);
    }

    /**
     * 添加用户组到用户
     * @param groupIds 用户组id
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/saveSysGroupToSysUser")
    public Result saveSysGroupToSysUser(String[] groupIds,String userId){
        sysUserService.saveSysGroupToSysUser(groupIds,userId);
        return new Result();
    }

    /**
     * 根据用户id获取用户具有角色及其他角色
     * @return
     */
    @RequestMapping("/findSysRoleByUserId")
    public Result findSysRoleByUserId(String id){
        return sysUserService.findSysRoleByUserId(id);
    }

    /**
     * 为用户添加角色权限
     * @param roleIds
     * @param userId
     * @return
     */
    @RequestMapping("/saveSysRoleToSysUser")
    public Result saveSysRoleToSysUser(String[] roleIds,String userId){
        sysUserService.saveSysRoleToSysUser(roleIds,userId);
        return new Result();
    }

    /**
     * 根据用户id查询用户已经具有的岗位及用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/findDepartmentandPostByUserId")
    public Result findDepartmentandPostByUserId(String userId){
        return sysUserService.findDepartmentandPostByUserId(userId);
    }

    /**
     * 为用户添加部门岗位
     * @param sysUserId 用户id
     * @param sysUserDepartmentPostlist 岗位,部门列表集合
     * @return
     */
    @RequestMapping("/saveDepartmentandPostOfUser")
    public Result saveDepartmentandPostOfUser(String sysUserId,
                                              List<TbSysUserDepartmentPost> sysUserDepartmentPostlist){
        sysUserService.saveDepartmentandPostOfUser(sysUserId,sysUserDepartmentPostlist);
        return new Result();
    }



}
