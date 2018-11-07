package com.jn.system.service.impl;

import com.jn.common.model.Result;
import com.jn.system.dao.TbSysDepartmentMapper;
import com.jn.system.entity.TbSysDepartment;
import com.jn.system.entity.TbSysDepartmentCriteria;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 根据部门id获取部门信息
     * @param id
     * @return
     */
    @Override
    public Result selectByPrimaryKey(String id) {
        TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(id);
        return new Result(tbSysDepartment);
    }

    /**
     * 逻辑删除部门信息
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        for (String id:ids) {
            TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(id);
            tbSysDepartment.setStatus(SysStatusEnums.DELETED.getKey());
            TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
            TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
            criteria.andIdEqualTo(id);
            tbSysDepartmentMapper.updateByExampleSelective(tbSysDepartment,tbSysDepartmentCriteria);
        }
    }

    /**
     * 修改部门信息
     * @param tbSysDepartment
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TbSysDepartment tbSysDepartment) {
        TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
        TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
        criteria.andIdEqualTo(tbSysDepartment.getId());
        tbSysDepartmentMapper.updateByExampleSelective(tbSysDepartment,tbSysDepartmentCriteria);
    }
}
