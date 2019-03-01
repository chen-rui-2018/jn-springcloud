package com.jn.system.dict.dao;

import com.jn.system.dict.model.SysDictModule;
import com.jn.system.dict.model.SysDictModulePage;

import java.util.List;

/**
 * 模块管理持久层
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 15:21
 * @version： v1.0
 * @modified By:
 **/
public interface SysDictModuleMapper {

    /**
     * 条件分页获取模块信息
     * @param sysDictModulePage
     * @return
     */
    List<SysDictModule> getModuleByPage(SysDictModulePage sysDictModulePage);
}
