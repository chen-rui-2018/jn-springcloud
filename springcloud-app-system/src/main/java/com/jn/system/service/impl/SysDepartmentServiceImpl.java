package com.jn.system.service.impl;

import com.jn.common.model.Result;
import com.jn.system.dao.SysDepartmentMapper;
import com.jn.system.service.SysDepartmentService;
import com.jn.system.model.SysDepartment;
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

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public Result findSysDepartmentAll() {
        Result result = new Result();
        List<SysDepartment> sysDepartmentList = sysDepartmentMapper.findSysDepartmentAll();
        result.setData(sysDepartmentList);
        return result;
    }
}
