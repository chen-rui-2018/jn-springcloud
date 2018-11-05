package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.vo.SysGroup;

/**
 * 用户组
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 13:07
 * @version： v1.0
 * @modified By:
 */
public interface SysGroupService {

    /**
     * 查询所有用户组信息
     * @return
     */
    Result findSysGroupAll();

    /**
     * 增加用户组
     * @param sysGroup 用户组
     */
    void addSysGroup(SysGroup sysGroup);

    /**
     * 逻辑删除用户组
     * @param groupIds 用户组数组id
     */
    void deleSysGroup(String[] groupIds);

    /**
     * 修改用户组信息
     * @param sysGroup 用户组对象
     * @return
     */
    void updateSysGroup(SysGroup sysGroup);

    /**
     * 根据用户组id获取用户组信息
     * @param id 用户组id
     * @return
     */
    Result findSysGroupById(String id);
}
