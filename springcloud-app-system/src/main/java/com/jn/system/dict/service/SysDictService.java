package com.jn.system.dict.service;

import com.jn.common.model.PaginationData;
import com.jn.system.dict.entity.TbSysDict;
import com.jn.system.dict.model.SysDictEdit;
import com.jn.system.dict.model.SysDictInvoke;
import com.jn.system.dict.model.SysDictKeyValue;
import com.jn.system.dict.model.SysDictPage;
import com.jn.system.model.User;

import java.util.List;

/**
 * 数据字典服务层接口
 *
 * @author： shaobao
 * @date： Created on 2019/1/24 16:19
 * @version： v1.0
 * @modified By:
 **/
public interface SysDictService {
    /**
     * 新增数据字典
     *
     * @param tbSysDict 数据字典对象
     */
    void add(TbSysDict tbSysDict);

    /**
     * 修改数据字典
     *
     * @param tbSysDict
     */
    void update(TbSysDict tbSysDict);

    /**
     * 逻辑删除数据字典
     *
     * @param dictId 数据字典id
     * @param user   当前用户
     */
    void delete(String dictId, User user);

    /**
     * 数据字典分组排序
     *
     * @param sysDictList 数据字典集合
     * @param user        当前用户
     */
    void sortByGroup(List<SysDictEdit> sysDictList, User user);

    /**
     * 条件分页查询数据字典列表
     *
     * @param sysDictPage 查询条件
     * @return
     */
    PaginationData getDictByPage(SysDictPage sysDictPage);

    /**
     * 数据字典调用接口
     *
     * @param sysDictInvoke
     * @return
     */
    List<SysDictKeyValue> getDict(SysDictInvoke sysDictInvoke);
}
