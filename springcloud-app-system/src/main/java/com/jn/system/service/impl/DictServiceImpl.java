package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.GetEasyUIData;
import com.jn.system.dao.DictMapper;
import com.jn.system.model.Dict;
import com.jn.system.model.DictPage;
import com.jn.system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
/**
 * 字典
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public GetEasyUIData findTByPage(DictPage dict) {
        Page<Object> objects = PageHelper.startPage(dict.getPage(), dict.getRows());
        List<Dict> tByPage = dictMapper.findTByPage(dict);
        return new GetEasyUIData(tByPage, objects.getTotal());
    }

    @Override
    @Transactional
    public void insertDict(Dict dict) {
        dict.setId(UUID.randomUUID().toString());
        dictMapper.insert(dict);
        ;
    }

    @Override
    @Transactional
    public void updateByPrimaryKeyDict(Dict dict) {
        dictMapper.updateByPrimaryKey(dict);
    }

    @Override
    @Transactional
    public void deleteByPrimaryKeyDict(String[] id) {
        dictMapper.deleteBy(id);
    }

    @Override
    public Dict selectByPrimaryKey(String id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dict> findTByT(Dict dict) {
        return dictMapper.findTByT(dict);
    }


}
