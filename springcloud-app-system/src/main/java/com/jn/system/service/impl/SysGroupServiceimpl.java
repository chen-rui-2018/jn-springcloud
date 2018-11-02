package com.jn.system.service.impl;

import com.jn.common.model.Result;
import com.jn.system.dao.SysGroupMapper;
import com.jn.system.service.SysGroupService;
import com.jn.system.vo.TbSysGroup;
import com.jn.system.vo.TbSysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户组service实现
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 15:31
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysGroupServiceimpl implements SysGroupService{

    @Autowired
    private SysGroupMapper sysGroupMapper;

    /**
     * 查询所用用户组信息
     * @return
     */
    @Override
    public Result findSysGroupAll() {
        return new Result(sysGroupMapper.findSysGroupAll());
    }

    /**
     * 用户组增加
     * @param sysGroup 用户组
     */
    @Override
    @Transactional
    public void addSysGroup(TbSysGroup sysGroup) {
        //为用户组设置信息
        sysGroup.setId(UUID.randomUUID().toString());
        sysGroup.setCreateTime(new Date());
        TbSysUser tbSysUser = (TbSysUser) SecurityUtils.getSubject().getPrincipal();
        sysGroup.setCreator(tbSysUser.getId());
        sysGroupMapper.addSysGroup(sysGroup);
    }

    /**
     * 逻辑删除用户组
     * @param groupIds 用户组id数组
     */
    @Override
    @Transactional
    public void deleSysGroup(String[] groupIds) {
        for (String groupId: groupIds) {
            sysGroupMapper.deleSysGroup(groupId);
        }
    }

    /**
     * 修改用户组信息
     * @param sysGroup 用户组对象
     * @return
     */
    @Override
    @Transactional
    public void updateSysGroup(TbSysGroup sysGroup) {
        sysGroup.setCreateTime(new Date());
        sysGroupMapper.updateSysGroup(sysGroup);
    }

    /**
     * 根据用户组id获取用户组信息
     * @param id 用户组id
     * @return
     */
    @Override
    public Result findSysGroupById(String id) {
        return new Result(sysGroupMapper.findSysGroupById(id));
    }

}
