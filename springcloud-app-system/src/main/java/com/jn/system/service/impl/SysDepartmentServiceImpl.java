package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.system.dao.SysDepartmentMapper;
import com.jn.system.dao.SysUserDepartmentPostMapper;
import com.jn.system.dao.TbSysDepartmentMapper;
import com.jn.system.entity.TbSysDepartment;
import com.jn.system.entity.TbSysDepartmentCriteria;
import com.jn.system.enums.SysLevelEnums;
import com.jn.system.enums.SysReturnMessageEnum;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.SysDepartment;
import com.jn.system.model.SysDepartmentAdd;
import com.jn.system.model.SysDepartmentPage;
import com.jn.system.model.User;
import com.jn.system.service.SysDepartmentService;
import com.jn.system.vo.SysDepartmentUserVO;
import com.jn.system.vo.SysDepartmentVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 部门service实现
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 17:08
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {

    private Logger logger = LoggerFactory.getLogger(SysDepartmentServiceImpl.class);

    @Autowired
    private TbSysDepartmentMapper tbSysDepartmentMapper;
    @Autowired
    private SysUserDepartmentPostMapper sysUserDepartmentPostMapper;
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * 查询所有部门
     *
     * @return
     */
    @Override
    public List<SysDepartment> findSysDepartmentAll() {
        TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
        TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
        criteria.andStatusEqualTo(SysStatusEnums.EFFECTIVE.getCode());
        List<TbSysDepartment> tbSysDepartmentList = tbSysDepartmentMapper.selectByExample(tbSysDepartmentCriteria);
        List<SysDepartment> list = new ArrayList<SysDepartment>();
        for (TbSysDepartment tbSysDepartment : tbSysDepartmentList) {
            SysDepartment sysDepartment = new SysDepartment();
            BeanUtils.copyProperties(tbSysDepartment, sysDepartment);
            list.add(sysDepartment);
        }
        return list;
    }

    /**
     * 根据部门id获取部门信息
     *
     * @param id
     * @return
     */
    @Override
    public SysDepartment selectByPrimaryKey(String id) {
        TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(id);
        SysDepartment sysDepartment = new SysDepartment();
        if (tbSysDepartment != null){
            BeanUtils.copyProperties(tbSysDepartment, sysDepartment);
        }
        return sysDepartment;
    }

    /**
     * 逻辑删除部门信息
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        sysDepartmentMapper.deleteDepartmentBranch(ids);
        sysUserDepartmentPostMapper.deleteDepartmentBranch(ids);
        logger.info("[部门] 逻辑删除部门成功,departmentIds: {}", ids.toString());
    }

    /**
     * 修改部门信息
     *
     * @param sysDepartment
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDepartment sysDepartment) {
        TbSysDepartment tbSysDepartment = new TbSysDepartment();
        BeanUtils.copyProperties(sysDepartment, tbSysDepartment);
        TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
        TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
        criteria.andIdEqualTo(tbSysDepartment.getId());
        tbSysDepartmentMapper.updateByExampleSelective(tbSysDepartment, tbSysDepartmentCriteria);
        logger.info("[部门] 修改部门信息成功,departmentId: {}", tbSysDepartment.getId());
    }

    /**
     * 批量添加部门
     *
     * @param sysDepartmentAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysDepartmentAdd sysDepartmentAdd,User user) {
        String level;
        //根据父id查询父级部门等级,判断父id是否是1级id,若是设置等级为1
        if (SysLevelEnums.FIRST_LEVEL.getCode().equals(sysDepartmentAdd.getParentId())) {
            level = SysLevelEnums.FIRST_LEVEL.getCode();
        } else {
            //查询父级部门等级
            TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(sysDepartmentAdd.getParentId());
            level = String.valueOf(Integer.parseInt(tbSysDepartment.getLevel()) + 1);
        }
        //判断部门名称中是否有数据
        if (sysDepartmentAdd.getDepartmentNames() != null &&
                sysDepartmentAdd.getDepartmentNames().length > 0) {

            for (String departmentName : sysDepartmentAdd.getDepartmentNames()) {
                //封装数据
                TbSysDepartment tbSysDepartment = new TbSysDepartment();
                tbSysDepartment.setId(UUID.randomUUID().toString());
                tbSysDepartment.setParentId(sysDepartmentAdd.getParentId());
                tbSysDepartment.setDepartmentName(departmentName);
                tbSysDepartment.setCreator(user.getId());
                tbSysDepartment.setCreateTime(new Date());
                tbSysDepartment.setStatus(SysStatusEnums.EFFECTIVE.getCode());
                tbSysDepartment.setLevel(level);
                //插入部门
                tbSysDepartmentMapper.insertSelective(tbSysDepartment);
                logger.info("[部门] 添加部门信息成功,departmentId:{},父级id:{}", tbSysDepartment.getId(),
                        sysDepartmentAdd.getParentId());
            }
        }
    }

    /**
     * 条件分页查询部门信息
     *
     * @param sysDepartmentPage
     * @return
     */
    @Override
    public PaginationData findSysDepartmentByPage(SysDepartmentPage sysDepartmentPage) {
        //分页查询所有部门
        Page<Object> objects = PageHelper.startPage(sysDepartmentPage.getPage(), sysDepartmentPage.getRows());
        List<SysDepartmentUserVO> list = sysDepartmentMapper.findSysDepartmentByPage(sysDepartmentPage);
        PaginationData data = new PaginationData(list, objects.getTotal());
        return data;
    }


    /**
     * 判断部门名称是否存在
     *
     * @param departmentName
     * @return
     */
    @Override
    public String checkDepartmentName(String departmentName) {
        if (StringUtils.isNotBlank(departmentName)) {
            TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
            TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
            criteria.andDepartmentNameEqualTo(departmentName);
            criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
            List<TbSysDepartment> tbSysDepartmentList = tbSysDepartmentMapper.selectByExample(tbSysDepartmentCriteria);
            if (tbSysDepartmentList != null && tbSysDepartmentList.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

    /**
     * 查询所有部门信息,并根据层级关系返回
     *
     * @return
     */
    @Override
    public List<SysDepartmentVO> findDepartmentAllByLevel() {
        //查询所有以及部门
        List<SysDepartmentVO> sysDepartmentVOList = sysDepartmentMapper.findSysDepartmentAll();
        findChildrenDepartment(sysDepartmentVOList);
        return sysDepartmentVOList;
    }

    /**
     * 递归循环查找部门所有子部门
     *
     * @param sysDepartmentVOList
     */
    public void findChildrenDepartment(List<SysDepartmentVO> sysDepartmentVOList) {
        for (SysDepartmentVO sysDepartmentVO : sysDepartmentVOList) {
            List<SysDepartmentVO> childrenDepartList =
                    sysDepartmentMapper.findChildrenDepartment(sysDepartmentVO.getValue());
            sysDepartmentVO.setChildren(childrenDepartList);
            if (childrenDepartList.size() == 0) {
                sysDepartmentVO.setChildren(null);
                continue;
            } else {
                findChildrenDepartment(childrenDepartList);
            }
        }
    }


}
