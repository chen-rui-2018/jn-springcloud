package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.SysDepartmentMapper;
import com.jn.system.dao.SysUserDepartmentPostMapper;
import com.jn.system.dao.TbSysDepartmentMapper;
import com.jn.system.entity.TbSysDepartment;
import com.jn.system.entity.TbSysDepartmentCriteria;
import com.jn.system.entity.TbSysUserDepartmentPost;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysDepartmentService;
import com.jn.system.vo.SysDepartmentUserVO;
import com.jn.system.vo.SysDepartmentVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
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
    public Result findSysDepartmentAll() {
        Result result = new Result();
        TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
        TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
        criteria.andStatusEqualTo(SysStatusEnums.EFFECTIVE.getKey());
        List<TbSysDepartment> tbSysDepartmentList = tbSysDepartmentMapper.selectByExample(tbSysDepartmentCriteria);
        List<SysDepartment> list = new ArrayList<SysDepartment>();
        for (TbSysDepartment tbSysDepartment : tbSysDepartmentList) {
            SysDepartment sysDepartment = new SysDepartment();
            BeanUtils.copyProperties(tbSysDepartment, sysDepartment);
            list.add(sysDepartment);
        }
        result.setData(list);
        return result;
    }

    /**
     * 根据部门id获取部门信息
     *
     * @param id
     * @return
     */
    @Override
    public Result selectByPrimaryKey(String id) {
        TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(id);
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(tbSysDepartment, sysDepartment);
        return new Result(sysDepartment);
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
    public void add(SysDepartmentAdd sysDepartmentAdd) {
        String level;
        //根据父id查询父级部门等级,判断父id是否是1级id,若是设置等级为1
        if ("1".equals(sysDepartmentAdd.getParentId())){
            level = "1";
        }else{
            //查询父级部门等级
            TbSysDepartment tbSysDepartment = tbSysDepartmentMapper.selectByPrimaryKey(sysDepartmentAdd.getParentId());
            level = (Integer.parseInt(tbSysDepartment.getLevel())+1)+"";
        }
        //判断部门名称中是否有数据
        if (sysDepartmentAdd.getDepartmentNames() != null &&
                sysDepartmentAdd.getDepartmentNames().length > 0) {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            List<TbSysDepartment> list = new ArrayList<TbSysDepartment>();
            for (String departmentName : sysDepartmentAdd.getDepartmentNames()) {
                //封装数据
                TbSysDepartment tbSysDepartment = new TbSysDepartment();
                tbSysDepartment.setId(UUID.randomUUID().toString());
                tbSysDepartment.setParentId(sysDepartmentAdd.getParentId());
                tbSysDepartment.setDepartmentName(departmentName);
                tbSysDepartment.setCreator(user.getId());
                tbSysDepartment.setCreateTime(new Date());
                tbSysDepartment.setStatus(SysStatusEnums.EFFECTIVE.getKey());
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
    public Result findSysDepartmentByPage(SysDepartmentPage sysDepartmentPage) {
        //分页查询所有部门
        Page<Object> objects = PageHelper.startPage(sysDepartmentPage.getPage(), sysDepartmentPage.getRows());
        List<SysDepartmentUserVO> list = sysDepartmentMapper.findSysDepartmentByPage(sysDepartmentPage);
        for (SysDepartmentUserVO sysDepartmentUserVO : list) {
            //查询该部门下所有用户
            List<SysTUser> sysTUserList = sysUserDepartmentPostMapper.fingUserOfDepartment(sysDepartmentUserVO.getId());
            sysDepartmentUserVO.setSysTUserList(sysTUserList);
        }
        PaginationData getEasyUIData = new PaginationData(list, objects.getTotal());
        return new Result(getEasyUIData);
    }

    /**
     * 根据部门id获取部门已经存在的用户信息
     *
     * @param departmentId
     * @return
     */
    @Override
    public Result findUserOfDepartment(String departmentId) {
        List<SysTUser> sysTUserList = sysUserDepartmentPostMapper.fingUserOfDepartment(departmentId);
        return new Result(sysTUserList);
    }

    /**
     * 条件分页查询部门具有的用户以外的用户信息
     *
     * @param sysDepartmentUserPage
     * @return
     */
    @Override
    public Result fingOtherUserByPage(SysDepartmentUserPage sysDepartmentUserPage) {
        Page<Object> objects = PageHelper.startPage(sysDepartmentUserPage.getPage(), sysDepartmentUserPage.getRows());
        List<SysTUser> sysTUserList = sysUserDepartmentPostMapper.fingOtherUserByPage(sysDepartmentUserPage);
        PaginationData getEasyUIData = new PaginationData(sysTUserList, objects.getTotal());
        return new Result(getEasyUIData);
    }

    /**
     * 为部门添加用户
     *
     * @param sysDepartmentUserAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserToDepartment(SysDepartmentUserAdd sysDepartmentUserAdd) {
        //清除部门已经具有的用户
        sysUserDepartmentPostMapper.deleteUserOfDepartment(sysDepartmentUserAdd.getDepartmentId());
        if (sysDepartmentUserAdd.getUserPostAddList() != null &&
                sysDepartmentUserAdd.getUserPostAddList().size() > 0) {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            List<TbSysUserDepartmentPost> list = new ArrayList<TbSysUserDepartmentPost>();
            for (SysUserPostAdd sysUserPostAdd : sysDepartmentUserAdd.getUserPostAddList()) {
                TbSysUserDepartmentPost tbSysUserDepartmentPost = new TbSysUserDepartmentPost();
                tbSysUserDepartmentPost.setId(UUID.randomUUID().toString());
                tbSysUserDepartmentPost.setCreateTime(new Date());
                tbSysUserDepartmentPost.setCreator(user.getId());
                tbSysUserDepartmentPost.setDepartmentId(sysDepartmentUserAdd.getDepartmentId());
                tbSysUserDepartmentPost.setIsDefault(SysStatusEnums.INVALID.getKey());
                tbSysUserDepartmentPost.setStatus(SysStatusEnums.EFFECTIVE.getKey());
                tbSysUserDepartmentPost.setUserId(sysUserPostAdd.getUserId());
                tbSysUserDepartmentPost.setPostId(sysUserPostAdd.getPostId());
                list.add(tbSysUserDepartmentPost);
                logger.info("[部门] 部门添加用户信息成功,departmentId:{},用户id:", sysDepartmentUserAdd.getDepartmentId(),
                        sysUserPostAdd.getUserId());
            }
            //批量为部门插入用户
            sysUserDepartmentPostMapper.insert(list);

        }
    }

    /**
     * 判断部门名称是否存在
     *
     * @param departmentName
     * @return
     */
    @Override
    public Result checkDepartmentName(String departmentName) {
        if(StringUtils.isNotBlank(departmentName)){
            TbSysDepartmentCriteria tbSysDepartmentCriteria = new TbSysDepartmentCriteria();
            TbSysDepartmentCriteria.Criteria criteria = tbSysDepartmentCriteria.createCriteria();
            criteria.andDepartmentNameEqualTo(departmentName);
            List<TbSysDepartment> tbSysDepartmentList = tbSysDepartmentMapper.selectByExample(tbSysDepartmentCriteria);
            if (tbSysDepartmentList != null && tbSysDepartmentList.size() > 0) {
                return new Result("false");
            }
        }
        return new Result("success");
    }

    /**
     * 查询所有部门信息,并根据层级关系返回
     *
     * @return
     */
    @Override
    public Result findDepartmentAllByLevel() {
        //查询所有以及部门
        List<SysDepartmentVO> sysDepartmentVOList = sysDepartmentMapper.findSysDepartmentAll();
        findChildrenDepartment(sysDepartmentVOList);
        return new Result(sysDepartmentVOList);
    }

    /**
     * 递归循环查找部门所有子部门
     *
     * @param sysDepartmentVOList
     */
    public void findChildrenDepartment(List<SysDepartmentVO> sysDepartmentVOList) {
        for (SysDepartmentVO sysDepartmentVO : sysDepartmentVOList) {
            List<SysDepartmentVO> childrenDepartList =
                    sysDepartmentMapper.findChildrenDepartment(sysDepartmentVO.getDepartmentId());
            sysDepartmentVO.setSysChildrenDepartmentList(childrenDepartList);
            findChildrenDepartment(childrenDepartList);
            if (childrenDepartList == null || childrenDepartList.size() == 0) {
                return;
            }
        }
    }


}
