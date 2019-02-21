package com.jn.system.dict.service;

import com.jn.common.model.PaginationData;
import com.jn.system.dict.entity.TbSysDictModule;
import com.jn.system.dict.model.SysDictModule;
import com.jn.system.dict.model.SysDictModulePage;
import com.jn.system.model.User;

import java.util.List;

/**
 * 模块管理service接口
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 14:34
 * @version： v1.0
 * @modified By:
 **/
public interface SysDictModuleService {

    /**
     * 添加模块
     *
     * @param tbSysModule
     */
    void add(TbSysDictModule tbSysModule);

    /**
     * 更新模块
     *
     * @param tbSysModule
     */
    void update(TbSysDictModule tbSysModule);

    /**
     * 逻辑模块
     *
     * @param moduleId 模块id
     * @param user     当前用户
     */
    void delete(String moduleId, User user);

    /**
     * 获取全部模块
     *
     * @return
     */
    List<SysDictModule> getAll();

    /**
     * 分页条件查询模块列表
     *
     * @param sysDictModulePage 查询条件
     * @return
     */
    PaginationData getModuleByPage(SysDictModulePage sysDictModulePage);
}
