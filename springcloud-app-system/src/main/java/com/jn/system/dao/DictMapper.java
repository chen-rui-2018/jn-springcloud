package com.jn.system.dao;

import com.jn.system.model.Dict;
import com.jn.system.model.DictPage;

import java.util.List;
/**
 * 字典接口
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface DictMapper {
    /**
     * 删除字典by主键
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(Dict record);

    /**
     * 通过主键查找字典
     * @param id
     * @return
     */
    Dict selectByPrimaryKey(String id);

    /**
     * 查询全部
     * @return
     */
    List<Dict> selectAll();

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Dict record);

    List<Dict> findTByPage(DictPage dict);

    int findTCountByT(DictPage dict);

    void deleteBy(String[] id);

    List<Dict> findTByT(Dict dict);
}