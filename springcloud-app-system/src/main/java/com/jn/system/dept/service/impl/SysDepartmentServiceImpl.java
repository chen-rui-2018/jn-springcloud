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
import com.jn.system.dept.enums.SysDepartmentExceptionEnums;
import com.jn.system.dept.model.SysDepartment;
import com.jn.system.dept.model.SysDepartmentCheckName;
import com.jn.system.dept.service.SysDepartmentService;
import com.jn.system.dept.vo.SysDepartmentVO;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
        //获取删除部门及子部门id
        String departStr = sysDepartmentMapper.getDepartmentIds(id);
        //解析查询导数据
        String[] departArr = departStr.substring(2).split(",");
        List<String> ids = new ArrayList<String>(Arrays.asList(departArr));
        //逻辑删除部门子部门信息
        sysDepartmentMapper.deleteDepartmentBranch(ids);
        logger.info("[部门] 批量逻辑删除部门成功,departmentIds: {}", ids.toString());
        //逻辑删除部门及子部门对应的用户信息
        sysUserDepartmentPostMapper.deleteDepartmentBranch(ids);
        logger.info("[部门] 批量逻辑删除部门关联用户信息成功,departmentIds: {}", ids.toString());
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
                    logger.warn("[部门] 修改部门失败，部门名称已存在！,departmentId: {}", sysDepartment.getId());
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
     * @param tbSysDepartment
     */
    @Override
    @ServiceLog(doAction = "添加部门")
    @Transactional(rollbackFor = Exception.class)
    public void add(TbSysDepartment tbSysDepartment) {
        String parentId = tbSysDepartment.getParentId();
        String departmentName = tbSysDepartment.getDepartmentName();
        //1.判断同级部门中,部门名称是否已经存在
        SysDepartmentCheckName checkName = new SysDepartmentCheckName(parentId, departmentName);
        String value = checkDepartmentName(checkName);
        if (SysReturnMessageEnum.FAIL.getMessage().equals(value)) {
            logger.warn("[部门] 修改部门失败，部门名称已存在！,departmentName: {}", departmentName);
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
            TbSysDepartment tbSysDepartment1 = tbSysDepartmentMapper.selectByPrimaryKey(parentId);
            level = String.valueOf(Integer.parseInt(tbSysDepartment1.getLevel()) + 1);
        }
        tbSysDepartment.setLevel(level);

        //3.插入部门数据
        tbSysDepartmentMapper.insertSelective(tbSysDepartment);
        logger.info("[部门] 添加部门信息成功,departmentId:{},父级id:{}", tbSysDepartment.getId(), parentId);
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
        //查询所有部门信息
        List<SysDepartmentVO> list = new ArrayList<SysDepartmentVO>(16);
        List<SysDepartmentVO> departmentVOList = sysDepartmentMapper.getDepartmentAll();
        //遍历集合,根据部门层级关系,生成菜单树
        for (SysDepartmentVO sysDepartmentVO : departmentVOList) {
            if (SysLevelEnums.FIRST_LEVEL.getCode().equals(sysDepartmentVO.getLevel())){
                list.add(sysDepartmentVO);
            }
            List<SysDepartmentVO> childrenList = new ArrayList<SysDepartmentVO>(16);
            for (SysDepartmentVO departmentVO : departmentVOList) {
                //判断部门id和部门父id关系
                if (sysDepartmentVO.getValue().equals(departmentVO.getParentId())){
                    childrenList.add(departmentVO);
                }
            }
            if (childrenList.size() > 0){
                sysDepartmentVO.setChildren(childrenList);
            }
        }
        return list;
    }

    /**
     * 批量更新部门信息
     *
     * @param sysDepartmentList
     */
    @Override
    public void addDepartmentBatch(List<SysDepartment> sysDepartmentList) {
        String parentId = null;
        HashSet<String> set = new HashSet<String>();
        //1.获取父级id,修改部门集合及添加部门集合
        for (SysDepartment sysDepartment : sysDepartmentList) {
            set.add(sysDepartment.getDepartmentName());
        }

        //2.判断部门名称中是否有重名
        if (set.size() != sysDepartmentList.size()) {
            logger.warn("[部门] 部门批量修改失败，部门名称重复！,departmentName: {}", sysDepartmentList);
            throw new JnSpringCloudException(SysDepartmentExceptionEnums.DEPARTMENT_NAME_REPEAAT);
        }

        //3.进行批量添加及批量更新
        if (sysDepartmentList.size() > 0) {
            sysDepartmentMapper.updateDepartmentBatch(sysDepartmentList);
        }
        logger.info("[部门] 批量修改部门信息成功,部门父id为parentId: {}", parentId);
    }

    /**
     * 根据父级id获取所有子部门信息
     *
     * @param parentId
     * @return
     */
    @Override
    public List<SysDepartmentVO> getChildDepartmentByParentId(String parentId) {
        List<SysDepartmentVO> departmentVOList = sysDepartmentMapper.getChildDepartmentByParentId(parentId);
        return departmentVOList;
    }
}
