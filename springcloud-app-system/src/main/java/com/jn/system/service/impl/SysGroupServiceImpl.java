package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.*;
import com.jn.system.entity.TbSysDepartmentCriteria;
import com.jn.system.entity.TbSysGroup;
import com.jn.system.entity.TbSysGroupCriteria;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysGroupService;
import com.jn.system.vo.SysGroupRoleVO;
import com.jn.system.vo.SysGroupUserRoleVO;
import com.jn.system.vo.SysGroupUserVO;
import com.jn.system.vo.SysGroupVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 用户组service实现
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 15:31
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysGroupServiceImpl implements SysGroupService {
    private Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    private SysGroupMapper sysGroupMapper;
    @Autowired
    private SysGroupUserMapper sysGroupUserMapper;
    @Autowired
    private SysGroupRoleMapper sysGroupRoleMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private TbSysGroupMapper tbSysGroupMapper;


    /**
     * 查询所用用户组信息
     *
     * @return
     */
    @Override
    public Result findSysGroupAll(SysGroupPage groupPage) {
        Page<Object> objects = PageHelper.startPage(groupPage.getPage(), groupPage.getRows());
        List<SysGroupUserRoleVO> sysGroupAll = sysGroupMapper.findSysGroupAll(groupPage);
        if (sysGroupAll != null && sysGroupAll.size() > 0) {
            //获取用户组对应的用户及角色
            for (SysGroupUserRoleVO sysGroupVO : sysGroupAll) {
                //获取用户信息
                List<String> sysTUserList = sysGroupUserMapper.findUsersByGroupId(sysGroupVO.getId());
                sysGroupVO.setSysTUserList(sysTUserList);
                //获取角色信息
                List<String> roleAllOfGroup = sysGroupRoleMapper.findRolesByGroupId(sysGroupVO.getId());
                sysGroupVO.setSysRoleList(roleAllOfGroup);
            }
        }
        PaginationData getEasyUIData = new PaginationData(sysGroupAll, objects.getTotal());
        return new Result(getEasyUIData);
    }

    /**
     * 用户组增加
     *
     * @param sysGroup 用户组
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addSysGroup(TbSysGroup sysGroup) {
        //判断用户组名是否存在
        TbSysGroupCriteria tbSysGroupCriteria = new TbSysGroupCriteria();
        TbSysGroupCriteria.Criteria criteria = tbSysGroupCriteria.createCriteria();
        criteria.andGroupNameEqualTo(sysGroup.getGroupName());
        List<TbSysGroup> tbSysGroups = tbSysGroupMapper.selectByExample(tbSysGroupCriteria);
        if (tbSysGroups != null && tbSysGroups.size() > 0 ){
            return new Result("用户组名已存在");
        }
        //为用户组设置信息
        sysGroup.setId(UUID.randomUUID().toString());
        sysGroup.setCreateTime(new Date());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysGroup.setCreator(user.getId());
        tbSysGroupMapper.insert(sysGroup);
        logger.info("[用户组]用户组信息增加成功,groupId:{}",sysGroup.getId());
        return new Result("添加成功");
    }

    /**
     * 逻辑删除用户组
     *
     * @param groupIds 用户组id数组
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleSysGroup(String[] groupIds) {
        sysGroupMapper.deleteGroupBranch(groupIds);
        sysGroupUserMapper.deleteGroupBranch(groupIds);
        sysGroupRoleMapper.deleteGroupBranch(groupIds);
        logger.info("[用户组]逻辑删除用户组信息,groupIds:{}",groupIds.toString());
    }

    /**
     * 修改用户组信息
     *
     * @param sysGroup 用户组对象
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysGroup(TbSysGroup sysGroup) {
        sysGroup.setCreateTime(new Date());
        TbSysGroupCriteria tbSysGroupCriteria = new TbSysGroupCriteria();
        TbSysGroupCriteria.Criteria criteria = tbSysGroupCriteria.createCriteria();
        criteria.andIdEqualTo(sysGroup.getId());
        tbSysGroupMapper.updateByExampleSelective(sysGroup, tbSysGroupCriteria);
    }

    /**
     * 根据用户组id获取用户组信息
     *
     * @param id 用户组id
     * @return
     */
    @Override
    public Result findSysGroupById(String id) {
        return new Result(tbSysGroupMapper.selectByPrimaryKey(id));
    }

    /**
     * 根据用户组id获取用户组信息及用户组具有的角色信息并返回其他所有角色信息
     *
     * @param id 用户组id
     * @return
     */
    @Override
    public Result selectGroupRoleAndOtherRole(String id) {
        SysGroupRoleVO sysGroupRoleVO = new SysGroupRoleVO();
        //获取用户组具有的角色
        List<SysRole> roleAllOfGroup = sysGroupRoleMapper.findRoleByGroupId(id);
        //获取所有用户组信息
        List<SysRole> sysRoleAll = sysRoleMapper.findSysRoleAll();
        //返回用户组已具有角色信息及其他所有角色信息
        sysGroupRoleVO.setRoleAllOfGroup(roleAllOfGroup);
        sysGroupRoleVO.setSysRoleAll(sysRoleAll);
        return new Result(sysGroupRoleVO);
    }

    /**
     * 为用户组授权角色信息
     *
     * @param sysRoleGroupAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void roleGroupAuthorization(SysRoleGroupAdd sysRoleGroupAdd) {
        //插入之前,清除该用户组下面的角色信息
        sysGroupRoleMapper.deteSysGroupRoleByGroupId(sysRoleGroupAdd.getGroupId());
        if(sysRoleGroupAdd.getRoleIds().length == 0){
            return;
        }
        String[] groupids = {sysRoleGroupAdd.getGroupId()};
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<SysGroupRole> sysGroupRoleList = new ArrayList<SysGroupRole>();
        for (String roleId : sysRoleGroupAdd.getRoleIds()) {
            SysGroupRole sysGroupRole = new SysGroupRole();
            sysGroupRole.setId(UUID.randomUUID().toString());
            sysGroupRole.setStatus(SysStatusEnums.EFFECTIVE.getKey());
            sysGroupRole.setCreateTime(new Date());
            sysGroupRole.setCreator(user.getId());
            sysGroupRole.setRoleId(roleId);
            sysGroupRole.setUserGroupId(sysRoleGroupAdd.getGroupId());
            sysGroupRoleList.add(sysGroupRole);
            logger.info("[用户组]添加用户组授权角色，groupId:{},roleId:{}",groupids.toString(),
                    roleId);
        }
        //添加新的角色信息
        sysGroupRoleMapper.insertSysGroupRoleBatch(sysGroupRoleList);
        logger.info("[用户组]用户组授权角色成功，groupId:{}", groupids.toString());
    }

    /**
     * 根据用户组id获取用户组下面所有用户
     *
     * @param groupId 用户组id
     * @return
     */
    @Override
    public Result findUserOfGroup(String groupId) {
        List<SysTUser> userAllOfGroup = sysGroupUserMapper.findUserByGroupId(groupId);
        return new Result(userAllOfGroup);
    }

    /**
     * 分页获取除用户组具有的用户以外的用户
     *
     * @param sysGroupUserPage
     * @return
     */
    @Override
    public Result findOtherUserByPage(SysGroupUserPage sysGroupUserPage) {
        Page<Object> objects = PageHelper.startPage(sysGroupUserPage.getPage(), sysGroupUserPage.getRows());
        //条件分页获取用户组未拥有用户
        List<SysTUser> userList = sysGroupUserMapper.findOtherUserByPage(sysGroupUserPage);
        //获取用户组已拥有用户
        List<SysTUser> userAllOfGroup = sysGroupUserMapper.findUserByGroupId(sysGroupUserPage.getGroupId());
        //将以用户用户放入分页查询到的集合中,方便前端解析
        userList.addAll(userAllOfGroup);
        SysGroupUserVO sysGroupUserVO = new SysGroupUserVO();
        sysGroupUserVO.setUserList(userList);
        sysGroupUserVO.setUserAllOfGroup(userAllOfGroup);
        PaginationData data = new PaginationData(sysGroupUserVO, objects.getTotal());
        return new Result(data);
    }

    /**
     * 用户组授权用户
     *
     * @param sysGroupUserAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userGroupAuthorization(SysGroupUserAdd sysGroupUserAdd) {
        //用户组添加用户之前清除用户组以前用户
        sysGroupUserMapper.deleteUserOfGroup(sysGroupUserAdd.getGroupId());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<SysGroupUser> sysGroupUserList = new ArrayList<SysGroupUser>();
        if(sysGroupUserAdd.getUserIds().length == 0){
            return;
        }
        for (String userId : sysGroupUserAdd.getUserIds()) {
            SysGroupUser sysGroupUser = new SysGroupUser();
            sysGroupUser.setId(UUID.randomUUID().toString());
            sysGroupUser.setCreateTime(new Date());
            sysGroupUser.setCreator(user.getId());
            sysGroupUser.setStatus(sysGroupUserAdd.getStatus());
            sysGroupUser.setGroupId(sysGroupUserAdd.getGroupId());
            sysGroupUser.setUserId(userId);
            sysGroupUserList.add(sysGroupUser);
            logger.info("[用户组]添加用户组授权用户，groupId:{},userId:{}",sysGroupUserAdd.getGroupId(),
                    userId);
        }
        //批量插入信息新的用户
        sysGroupUserMapper.insertSysGroupUserBatch(sysGroupUserList);
        logger.info("[用户组]用户组授权用户成功，groupId:{}",sysGroupUserAdd.getGroupId());
    }

    /**
     * 校验用户组名是否可用
     * @param groupName
     * @return
     */
    @Override
    public Result checkGroupName(String groupName) {
        if (StringUtils.isNotBlank(groupName)){
            TbSysGroupCriteria tbSysGroupCriteria = new TbSysGroupCriteria();
            TbSysGroupCriteria.Criteria criteria = tbSysGroupCriteria.createCriteria();
            criteria.andGroupNameEqualTo(groupName);
            List<TbSysGroup> tbSysGroups = tbSysGroupMapper.selectByExample(tbSysGroupCriteria);
            if (tbSysGroups != null && tbSysGroups.size() > 0){
                return new Result("false");
            }
        }
        return  new Result("success");
    }


}
