package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.*;
import com.jn.system.entity.TbSysGroup;
import com.jn.system.entity.TbSysGroupCriteria;
import com.jn.system.model.*;
import com.jn.system.service.SysGroupService;
import com.jn.system.vo.SysGroupVO;
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
        List<SysGroupVO> sysGroupAll = sysGroupMapper.findSysGroupAll(groupPage);
        if (sysGroupAll != null && sysGroupAll.size() > 0) {
            //获取用户组对应的用户及角色
            for (SysGroupVO sysGroupVO : sysGroupAll) {
                //获取用户信息
                List<SysTUser> sysTUserList = sysGroupUserMapper.findUserByGroupId(sysGroupVO.getId());
                sysGroupVO.setSysTUserList(sysTUserList);
                //获取角色信息
                List<SysRole> roleAllOfGroup = sysGroupRoleMapper.findRoleByGroupId(sysGroupVO.getId());
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
    public void addSysGroup(TbSysGroup sysGroup) {
        //为用户组设置信息
        sysGroup.setId(UUID.randomUUID().toString());
        sysGroup.setCreateTime(new Date());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysGroup.setCreator(user.getId());
        tbSysGroupMapper.insert(sysGroup);
        logger.info("message={}", "用户组信息增加成功,groupId:" + sysGroup.getId());
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
        logger.info("message={}", "逻辑删除用户组信息,groupIds:" + groupIds.toString());
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
        //获取用户组具有的角色
        List<SysRole> roleAllOfGroup = sysGroupRoleMapper.findRoleByGroupId(id);
        //获取所有用户组信息
        List<SysRole> sysRoleAll = sysRoleMapper.findSysRoleAll();
        System.out.println("所有角色" + sysRoleAll);
        //排除角色列表中用户组中已经存在的角色
        if (roleAllOfGroup != null && roleAllOfGroup.size() > 0) {
            for (SysRole sysRole : roleAllOfGroup) {
                if (sysRoleAll.contains(sysRole)) {
                    sysRoleAll.remove(sysRole);
                }
            }
        }
        //返回用户组已具有角色信息及其他所有角色信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("roleAllOfGroup", roleAllOfGroup);
        map.put("sysRoleAll", sysRoleAll);
        return new Result(map);
    }

    /**
     * 为用户组授权权限信息
     *
     * @param sysRoleGroupAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void roleGroupAuthorization(SysRoleGroupAdd sysRoleGroupAdd) {
        String[] groupids = {sysRoleGroupAdd.getGroupId()};
        User user = (User) SecurityUtils.getSubject().getPrincipals();

        List<SysGroupRole> sysGroupRoleList = new ArrayList<SysGroupRole>();
        for (String roleId : sysRoleGroupAdd.getRoleIds()) {
            SysGroupRole sysGroupRole = new SysGroupRole();
            sysGroupRole.setId(UUID.randomUUID().toString());
            sysGroupRole.setStatus(sysRoleGroupAdd.getStatus());
            sysGroupRole.setCreateTime(new Date());
            sysGroupRole.setCreator(user.getId());
            sysGroupRole.setRoleId(roleId);
            sysGroupRole.setUserGroupId(sysRoleGroupAdd.getGroupId());
            sysGroupRoleList.add(sysGroupRole);
            logger.info("message={}", "添加用户组授权角色，groupId=" + groupids.toString() + "roleId="
                    + roleId);
        }

        //插入之前,清除该用户组下面的角色信息
        sysGroupRoleMapper.deteSysGroupRoleByGroupId(sysRoleGroupAdd.getGroupId());
        //添加新的角色信息
        sysGroupRoleMapper.insertSysGroupRoleBatch(sysGroupRoleList);
        logger.info("message={}", "用户组授权角色成功，groupId=" + groupids.toString());
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
        List<SysTUser> userList = sysGroupUserMapper.findOtherUserByPage(sysGroupUserPage);
        PaginationData data = new PaginationData(userList, objects.getTotal());
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
        User user = (User) SecurityUtils.getSubject().getPrincipals();
        List<SysGroupUser> sysGroupUserList = new ArrayList<SysGroupUser>();
        for (String userId : sysGroupUserAdd.getUserIds()) {
            SysGroupUser sysGroupUser = new SysGroupUser();
            sysGroupUser.setId(UUID.randomUUID().toString());
            sysGroupUser.setCreateTime(new Date());
            sysGroupUser.setCreator(user.getId());
            sysGroupUser.setStatus(sysGroupUserAdd.getStatus());
            sysGroupUser.setGroupId(sysGroupUserAdd.getGroupId());
            sysGroupUser.setUserId(userId);
            sysGroupUserList.add(sysGroupUser);
            logger.info("message={}", "添加用户组授权用户，groupId=" + sysGroupUserAdd.getGroupId() + "userId="
                    + userId);
        }
        //用户组添加用户之前清除用户组以前用户
        sysGroupUserMapper.deleteUserOfGroup(sysGroupUserAdd.getGroupId());
        //批量插入信息新的用户
        sysGroupUserMapper.insertSysGroupUserBatch(sysGroupUserList);
        logger.info("message={}", "用户组授权用户成功，groupId=" + sysGroupUserAdd.getGroupId());
    }


}
