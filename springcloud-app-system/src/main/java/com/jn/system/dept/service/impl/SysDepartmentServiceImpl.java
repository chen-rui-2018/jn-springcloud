package com.jn.system.dept.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysLevelEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.dao.SysDepartmentMapper;
import com.jn.system.dept.dao.SysUserDepartmentPostMapper;
import com.jn.system.dept.dao.TbSysDepartmentMapper;
import com.jn.system.dept.entity.TbSysDepartment;
import com.jn.system.dept.entity.TbSysDepartmentCriteria;
import com.jn.system.dept.model.SysDepartment;
import com.jn.system.dept.model.SysDepartmentAdd;
import com.jn.system.dept.model.SysDepartmentCheckName;
import com.jn.system.dept.service.SysDepartmentService;
import com.jn.system.dept.vo.SysDepartmentVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
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

    private static Logger logger = LoggerFactory.getLogger(SysDepartmentServiceImpl.class);

    @Autowired
    private TbSysDepartmentMapper tbSysDepartmentMapper;
    @Autowired
    private SysUserDepartmentPostMapper sysUserDepartmentPostMapper;
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * 根据部门id获取部门信息
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据部门id获取部门信息")
    public SysDepartment selectByPrimaryKey(String id) {
        TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(id);
        SysDepartment sysDepartment = new SysDepartment();
        if (tbSysDepartment != null) {
            BeanUtils.copyProperties(tbSysDepartment, sysDepartment);
        }
        return sysDepartment;
    }

    /**
     * 逻辑删除部门信息
     *
     * @param id
     */
    @Override
    @ServiceLog(doAction = "逻辑删除部门信息")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        List<String> ids = new ArrayList<String>();
        //获取该部门下面的子部门
        List<SysDepartmentVO> childrenDepartment = sysDepartmentMapper.findChildrenDepartment(id);
        if (childrenDepartment != null && childrenDepartment.size() > 0) {
            //递归获取子部门的子部门
            findChildrenDepartment(childrenDepartment);
            //获取子部门id
            getChildDepartmentId(ids, childrenDepartment);
        }
        ids.add(id);
        //逻辑删除部门子部门信息
        sysDepartmentMapper.deleteDepartmentBranch(ids);
        //逻辑删除部门及子部门对应的用户信息
        sysUserDepartmentPostMapper.deleteDepartmentBranch(ids);
        logger.info("[部门] 逻辑删除部门成功,departmentIds: {}", ids.toString());
    }

    /**
     * 获取子部门id
     *
     * @param ids
     * @param childrenDepartment
     */
    private void getChildDepartmentId(List<String> ids, List<SysDepartmentVO> childrenDepartment) {
        for (SysDepartmentVO sysDepartmentVO : childrenDepartment) {
            ids.add(sysDepartmentVO.getValue());
            if (sysDepartmentVO.getChildren() != null) {
                getChildDepartmentId(ids, sysDepartmentVO.getChildren());
            }
        }
    }

    /**
     * 修改部门信息
     *
     * @param sysDepartment
     */
    @Override
    @ServiceLog(doAction = "修改部门信息")
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDepartment sysDepartment) {
        String departmentName = sysDepartment.getDepartmentName();
        //判断数据库中是否存在被修改数据
        TbSysDepartment tbSysDepartment1 = tbSysDepartmentMapper.selectByPrimaryKey(sysDepartment.getId());
        if (tbSysDepartment1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysDepartment1.getStatus())) {
            logger.warn("[部门] 部门修改失败,修改信息不存在,departmentId: {}", sysDepartment.getId());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else {
            //判断部门名称有没有修改
            if (!tbSysDepartment1.getDepartmentName().equals(departmentName)) {
                //若名称修改了,判断当前部门等级中是否已经存在该名称
                SysDepartmentCheckName checkName = new SysDepartmentCheckName(sysDepartment.getParentId(), departmentName);
                String value = checkDepartmentName(checkName);
                if (SysReturnMessageEnum.FAIL.getMessage().equals(value)) {
                    logger.warn("[部门] 修改岗位类型失败，部门名称已存在！,departmentId: {}", sysDepartment.getId());
                    throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
                }
            }
        }
        TbSysDepartment tbSysDepartment = new TbSysDepartment();
        BeanUtils.copyProperties(sysDepartment, tbSysDepartment);
        tbSysDepartmentMapper.updateByPrimaryKeySelective(tbSysDepartment);
        logger.info("[部门] 修改部门信息成功,departmentId: {}", tbSysDepartment.getId());
    }

    /**
     * 添加部门
     *
     * @param sysDepartmentAdd
     */
    @Override
    @ServiceLog(doAction = "添加部门")
    @Transactional(rollbackFor = Exception.class)
    public void add(SysDepartmentAdd sysDepartmentAdd, User user) {
        String parentId = sysDepartmentAdd.getParentId();
        String departmentName = sysDepartmentAdd.getDepartmentName();
        //1.判断同级部门中,部门名称是否已经存在
        SysDepartmentCheckName checkName = new SysDepartmentCheckName(parentId, departmentName);
        String value = checkDepartmentName(checkName);
        if (SysReturnMessageEnum.FAIL.getMessage().equals(value)) {
            logger.warn("[部门] 修改岗位类型失败，部门名称已存在！,departmentName: {}", departmentName);
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }

        //2.设置部门等级
        String level;
        //根据父id查询父级部门等级,判断父id是否是1级id,若是设置等级为1
        Boolean flag = parentId
                .equals(SysLevelEnums.FIRST_LEVEL.getCode()) ? Boolean.TRUE : Boolean.FALSE;
        if (flag) {
            level = SysLevelEnums.FIRST_LEVEL.getCode();
        } else {
            //查询父级部门等级
            TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(parentId);
            level = String.valueOf(Integer.parseInt(tbSysDepartment.getLevel()) + 1);
        }

        //3.封装部门数据
        TbSysDepartment tbSysDepartment = new TbSysDepartment();
        tbSysDepartment.setId(UUID.randomUUID().toString());
        tbSysDepartment.setParentId(parentId);
        tbSysDepartment.setDepartmentName(departmentName);
        tbSysDepartment.setCreator(user.getId());
        tbSysDepartment.setCreateTime(new Date());
        tbSysDepartment.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        tbSysDepartment.setLevel(level);
        //4.插入部门数据
        tbSysDepartmentMapper.insertSelective(tbSysDepartment);
        logger.info("[部门] 添加部门信息成功,departmentId:{},父级id:{}", tbSysDepartment.getId(),
                sysDepartmentAdd.getParentId());
    }


    /**
     * 校验同级部门中部门名称是否存在
     *
     * @param sysDepartmentCheckName
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验同级部门中部门名称是否存在")
    public String checkDepartmentName(SysDepartmentCheckName sysDepartmentCheckName) {
        //设置查询条件
        TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
        TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
        criteria.andParentIdEqualTo(sysDepartmentCheckName.getParentId());
        criteria.andDepartmentNameEqualTo(sysDepartmentCheckName.getDepartmentName());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        List<TbSysDepartment> tbSysDepartments = tbSysDepartmentMapper.selectByExample(tbSysDepartmentCriteria);
        if (tbSysDepartments != null && tbSysDepartments.size() > 0) {
            return SysReturnMessageEnum.FAIL.getMessage();
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

    /**
     * 查询所有部门信息,并根据层级关系返回
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询所有部门信息,并根据层级关系返回")
    public List<SysDepartmentVO> findDepartmentAllByLevel() {
        //查询所有部门
        List<SysDepartmentVO> sysDepartmentVOList = sysDepartmentMapper.findSysDepartmentAll();
        //递归查找子部门
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
            List<SysDepartmentVO> children = sysDepartmentVO.getChildren();
            //判断部门的子部门是否为空,为空,忽略,不为空,继续查找子部门的下一级部门
            if (children != null && children.size() > 0) {
                for (SysDepartmentVO child : children) {
                    child.setParentName(sysDepartmentVO.getLabel());
                    //根据父级部门id,查询子部门集合
                    List<SysDepartmentVO> childrenDepartList =
                            sysDepartmentMapper.findChildrenDepartment(child.getValue());
                    child.setChildren(childrenDepartList);
                    //如果为查到子部门,设置子集为null
                    if (childrenDepartList == null || childrenDepartList.size() == 0) {
                        child.setChildren(null);
                        continue;
                    } else {
                        //继续查找子部门的下一级部门
                        findChildrenDepartment(childrenDepartList);
                    }
                }
            } else {
                //子集可能是长度为空,这里设置为null
                sysDepartmentVO.setChildren(null);
            }
        }
    }


}
