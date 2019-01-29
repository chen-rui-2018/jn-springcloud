package com.jn.system.dict.dao;

import com.jn.system.dict.entity.TbSysDict;
import com.jn.system.dict.model.SysDict;
import com.jn.system.dict.model.SysDictPage;

import java.util.List;
import java.util.Map;

/**
 * 数组字典dao层
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 10:00
 * @version： v1.0
 * @modified By:
 **/
public interface SysDictMapper {

    /**
     * 获取数据字典对应分组中排序最大值
     *
     * @param tbSysDict
     * @return
     */
    Integer getMaxSort(TbSysDict tbSysDict);

    /**
     * 数据字典分组排序
     *
     * @param map
     */
    void sortByGroup(Map<String, Object> map);

    /**
     * 条件分页查询数据字典列表
     *
     * @param sysDictPage 查询条件
     * @return
     */
    List<SysDict> getDictByPage(SysDictPage sysDictPage);
}
