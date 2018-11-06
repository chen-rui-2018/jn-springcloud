package com.jn.system.service.impl;

import com.jn.common.model.Result;
import com.jn.system.dao.SysDepartmentMapper;
import com.jn.system.dao.TbSysDepartmentMapper;
import com.jn.system.entity.TbSysDepartment;
import com.jn.system.entity.TbSysDepartmentCriteria;
import com.jn.system.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门service实现
 * @author： shaobao
 * @date： Created on 2018/10/31 17:08
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;
    @Autowired
    private TbSysDepartmentMapper tbSysDepartmentMapper;

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public Result findSysDepartmentAll() {
        Result result = new Result();
        TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
        TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
        criteria.andStatusEqualTo("1");
        List<TbSysDepartment> tbSysDepartmentList = tbSysDepartmentMapper.selectByExample(tbSysDepartmentCriteria);
        result.setData(tbSysDepartmentList);
        return result;
    }
}
