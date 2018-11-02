package com.jn.system.service.impl;

import com.jn.common.model.Result;
import com.jn.system.dao.SysRoleMapper;
import com.jn.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色service
 * @author： shaobao
 * @date： Created on 2018/11/1 16:23
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public Result findSysRoleAll() {
        return new Result(sysRoleMapper.findSysRoleAll());
    }
}
