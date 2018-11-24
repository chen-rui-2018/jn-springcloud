package com.jn.system.dept.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
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
import com.jn.system.dept.model.SysDepartmentPage;
import com.jn.system.dept.service.SysDepartmentService;
import com.jn.system.dept.vo.SysDepartmentUserVO;
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
        if (childrenDepartment != null && childrenDepartment.size() > 0){
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
     *  获取子部门id
     * @param ids
     * @param childrenDepartment
     */
    private void getChildDepartmentId(List<String> ids, List<SysDepartmentVO> childrenDepartment) {
        for (SysDepartmentVO sysDepartmentVO:childrenDepartment) {
            ids.add(sysDepartmentVO.getId());
            if (sysDepartmentVO.getChildren() != null){
                getChildDepartmentId(ids,sysDepartmentVO.getChildren());
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
        TbSysDepartment tbSysDepartment = new TbSysDepartment();
        BeanUtils.copyProperties(sysDepartment, tbSysDepartment);
        TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
        TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
        criteria.andIdEqualTo(tbSysDepartment.getId());
        tbSysDepartmentMapper.updateByExampleSelective(tbSysDepartment, tbSysDepartmentCriteria);
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
        String level;
        //根据父id查询父级部门等级,判断父id是否是1级id,若是设置等级为1
        Boolean flag = sysDepartmentAdd.getParentId()
                .equals(SysLevelEnums.FIRST_LEVEL.getCode())? Boolean.TRUE:Boolean.FALSE;
        if (flag) {
            level = SysLevelEnums.FIRST_LEVEL.getCode();
        } else {
            //查询父级部门等级
            TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(sysDepartmentAdd.getParentId());
            level = String.valueOf(Integer.parseInt(tbSysDepartment.getLevel()) + 1);
        }
        //封装数据
        TbSysDepartment tbSysDepartment = new TbSysDepartment();
        tbSysDepartment.setId(UUID.randomUUID().toString());
        tbSysDepartment.setParentId(sysDepartmentAdd.getParentId());
        tbSysDepartment.setDepartmentName(sysDepartmentAdd.getDepartmentName());
        tbSysDepartment.setCreator(user.getId());
        tbSysDepartment.setCreateTime(new Date());
        tbSysDepartment.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        tbSysDepartment.setLevel(level);
        //插入部门
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
        if (StringUtils.isNotBlank(sysDepartmentCheckName.getDepartmentName())) {
            SysDepartment sysDepartment = sysDepartmentMapper.checkDepartmentName(sysDepartmentCheckName);
            if (sysDepartment != null){
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
    @ServiceLog(doAction = "查询所有部门信息,并根据层级关系返回")
    public List<SysDepartmentVO> findDepartmentAllByLevel() {
        //查询所有部门
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
                    sysDepartmentMapper.findChildrenDepartment(sysDepartmentVO.getId());
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
