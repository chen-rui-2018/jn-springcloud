package com.jn.system.dept.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
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
import com.jn.system.model.User;
import com.jn.system.vo.SysDepartmentPostVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
     * 根据部门id获取部门信息及所有子部门信息
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据部门id获取部门信息")
    public Result selectDeptByKey(String id, Boolean isGetChild) {
        //判断id是否为空
        if (StringUtils.isNotBlank(id)) {
            SysDepartmentVO sysDepartmentVO = sysDepartmentMapper.selectByPrimaryKey(id);
            if (isGetChild) {
                if (sysDepartmentVO != null) {
                    List<SysDepartmentVO> children = sysDepartmentMapper.getChildDept(id);
                    sysDepartmentVO.setChildren(children);
                }
            }
            return new Result(sysDepartmentVO);
        } else {
            List<SysDepartmentVO> departmentList = null;
            //如果id为空
            if (isGetChild) {
                //获取部门树信息
                departmentList = findDepartmentAllByLevel();
            } else {
                //获取所有一级部门
                departmentList = sysDepartmentMapper.getDepartmentAll(SysLevelEnums.FIRST_LEVEL.getCode());
            }
            return new Result(departmentList);
        }
    }

    /**
     * @param id
     * @param user 当前用户信息
     */
    @Override
    @ServiceLog(doAction = "逻辑删除部门信息")
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, User user) {
        //获取删除部门及子部门id
        String departStr = sysDepartmentMapper.getDepartmentIds(id);
        //解析查询导数据
        String[] departArr = departStr.substring(2).split(",");
        List<String> ids = new ArrayList<String>(Arrays.asList(departArr));
        //封装删除id及更新人信息
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", ids);
        map.put("account", user.getAccount());
        //逻辑删除部门子部门信息
        sysDepartmentMapper.deleteDepartmentBranch(map);
        logger.info("[部门] 批量逻辑删除部门成功,departmentIds: {}", ids.toString());
        //逻辑删除部门及子部门对应的用户信息
        sysUserDepartmentPostMapper.deleteDepartmentBranch(map);
        logger.info("[部门] 批量逻辑删除部门关联用户信息成功,departmentIds: {}", ids.toString());
    }

    /**
     * 修改用户信息
     *
     * @param sysDepartment
     * @param user
     */
    @Override
    @ServiceLog(doAction = "修改部门信息")
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDepartment sysDepartment, User user) {
        String departmentName = sysDepartment.getDepartmentName();
        //判断数据库中是否存在被修改数据
        TbSysDepartment tbSysDepartment1 = tbSysDepartmentMapper.selectByPrimaryKey(sysDepartment.getId());
        if (tbSysDepartment1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysDepartment1.getRecordStatus().toString())) {
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
        //设置最近更信任信息
        tbSysDepartment.setModifiedTime(new Date());
        tbSysDepartment.setModifierAccount(user.getAccount());
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
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(recordStatus);
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
        List<SysDepartmentVO> departmentVOList = sysDepartmentMapper.getDepartmentAll(null);
        //遍历集合,根据部门层级关系,生成菜单树
        for (SysDepartmentVO sysDepartmentVO : departmentVOList) {
            if (SysLevelEnums.FIRST_LEVEL.getCode().equals(sysDepartmentVO.getLevel())) {
                list.add(sysDepartmentVO);
            }
            List<SysDepartmentVO> childrenList = new ArrayList<SysDepartmentVO>(16);
            for (SysDepartmentVO departmentVO : departmentVOList) {
                //判断部门id和部门父id关系
                if (sysDepartmentVO.getValue().equals(departmentVO.getParentId())) {
                    departmentVO.setParentName(sysDepartmentVO.getLabel());
                    childrenList.add(departmentVO);
                }
            }
            if (childrenList.size() > 0) {
                sysDepartmentVO.setChildren(childrenList);
            }
        }
        return list;
    }

    /**
     * 批量更新用户信息
     *
     * @param sysDepartmentList
     * @param user              当前用户信息
     */
    @Override
    public void addDepartmentBatch(List<SysDepartment> sysDepartmentList, User user) {
        String parentId = null;
        HashSet<String> set = new HashSet<String>();
        //1.将集合中所有部门名称添加进set集合进行去重
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
            Map<String, Object> map = new HashMap<String, Object>(16);
            map.put("list", sysDepartmentList);
            map.put("account", user.getAccount());
            sysDepartmentMapper.updateDepartmentBatch(map);
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

    /**
     * 要查询的部门ID是否属于用户所属的部门或子部门
     *
     * @param userId 用户id
     * @param deptId 部门id
     * @return
     */
    @Override
    @ServiceLog(doAction = "要查询的部门ID是否属于用户所属的部门或子部门")
    public Boolean checkUserDept(String userId, String deptId) {
        //根据用户id获取用户具有的部门
        List<SysDepartmentPostVO> departmentPostVOs = sysUserDepartmentPostMapper.findDepartmentAndPostByUserId(userId);

        //根据查询的部门向上递归获取所有父部门id;
        List<TbSysDepartment> tbsysDepts = sysUserDepartmentPostMapper.findDepartmentId(deptId);

        //遍历用户具有的部门id是否和递归到的存在相等的情况
        for (TbSysDepartment tbsysDept : tbsysDepts) {
            String tbsysDeptId = tbsysDept.getId();
            for (SysDepartmentPostVO departmentPostVO : departmentPostVOs) {

                //如果相等,说明查询部门属于用户所属部门或子部门
                if (StringUtils.equals(tbsysDeptId, departmentPostVO.getDepartmentId())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据部门名称获取部门信息
     *
     * @param deptName
     * @return
     */
    @Override
    public TbSysDepartment getDept(String deptName) {
        TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
        tbSysDepartmentCriteria.setOrderByClause("level asc");
        TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
        criteria.andDepartmentNameEqualTo(deptName);
        List<TbSysDepartment> tbSysDepartments = tbSysDepartmentMapper.selectByExample(tbSysDepartmentCriteria);
        if (tbSysDepartments != null && tbSysDepartments.size() > 0){
            return tbSysDepartments.get(0);
        }
        return null;
    }
}
