package com.jn.system.service;

import com.jn.common.model.GetEasyUIData;
import com.jn.system.model.Dict;
import com.jn.system.model.DictPage;

import java.util.List;
/**
 * 字典
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface DictService {

    GetEasyUIData findTByPage(DictPage dict);

    void insertDict(Dict dict);

    void updateByPrimaryKeyDict(Dict dict);

    void deleteByPrimaryKeyDict(String[] id);

    Dict selectByPrimaryKey(String id);

    List<Dict> findTByT(Dict dict);
}
