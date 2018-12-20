package com.jn.system.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.system.permission.model.SysRole;
import com.jn.system.permission.model.SysRoleGroupAdd;
import com.jn.system.permission.service.impl.SysRoleServiceImpl;
import com.jn.system.user.dao.SysGroupMapper;
import com.jn.system.user.dao.SysGroupRoleMapper;
import com.jn.system.user.dao.SysGroupUserMapper;
import com.jn.system.user.dao.TbSysGroupMapper;
import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.entity.TbSysGroupCriteria;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysGroupService;
import com.jn.system.user.vo.SysGroupRoleVO;
import com.jn.system.user.vo.SysGroupUserRoleVO;
import com.jn.system.user.vo.SysGroupUserVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    private static Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    private SysGroupMapper sysGroupMapper;
    @Autowired
    private SysGroupUserMapper sysGroupUserMapper;
    @Autowired
    private SysGroupRoleMapper sysGroupRoleMapper;
    @Autowired
    private TbSysGroupMapper tbSysGroupMapper;


    /**
     * 查询所用用户组信息
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询所用用户组信息")
    public PaginationData findSysGroupAll(SysGroupPage groupPage) {
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
        PaginationData data = new PaginationData(sysGroupAll, objects.getTotal());
        return data;
    }

    /**
     * 用户组增加
     *
     * @param sysGroup 用户组
     */
    @Override
    @ServiceLog(doAction = "用户组增加")
    @Transactional(rollbackFor = Exception.class)
    public void addSysGroup(SysGroupAdd sysGroup, User user) {
        //判断用户组名是否存在
        List<TbSysGroup> tbSysGroups = checkName(sysGroup.getGroupName());
        if (tbSysGroups != null && tbSysGroups.size() > 0) {
            logger.warn("[用户组] 添加用户组信息失败，该用户组名称已存在！,groupName: {}", sysGroup.getGroupName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        //为用户组设置信息
        TbSysGroup tbSysGroup = new TbSysGroup();
        BeanUtils.copyProperties(sysGroup, tbSysGroup);
        tbSysGroup.setId(UUID.randomUUID().toString());
        tbSysGroup.setCreateTime(new Date());
        tbSysGroup.setCreator(user.getId());
        tbSysGroupMapper.insert(tbSysGroup);
        logger.info("[用户组] 添加用户组信息成功,groupId:{}", tbSysGroup.getId());
    }

    /**
     * 用于名称校验
     *
     * @param groupName
     * @return
     */
    private List<TbSysGroup> checkName(String groupName) {
        TbSysGroupCriteria tbSysGroupCriteria = new TbSysGroupCriteria();
        TbSysGroupCriteria.Criteria criteria = tbSysGroupCriteria.createCriteria();
        criteria.andGroupNameEqualTo(groupName);
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        return tbSysGroupMapper.selectByExample(tbSysGroupCriteria);
    }

    /**
     * 逻辑删除用户组
     *
     * @param groupIds 用户组id数组
     */
    @Override
    @ServiceLog(doAction = "逻辑删除用户组")
    @Transactional(rollbackFor = Exception.class)
    public void deleSysGroup(String[] groupIds) {
        sysGroupMapper.deleteGroupBranch(groupIds);
        logger.info("[用户组] 逻辑删除用户组信息成功,groupIds:{}", Arrays.toString(groupIds));
        sysGroupUserMapper.deleteGroupBranch(groupIds);
        logger.info("[用户组] 逻辑删除用户组关联用户信息成功,groupIds:{}", Arrays.toString(groupIds));
        sysGroupRoleMapper.deleteGroupBranch(groupIds);
        logger.info("[用户组] 逻辑删除用户组关联角色信息成功,groupIds:{}", Arrays.toString(groupIds));
    }

    /**
     * 修改用户组信息
     *
     * @param sysGroup 用户组对象
     * @return
     */
    @Override
    @ServiceLog(doAction = "修改用户组信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateSysGroup(SysGroupUpdate sysGroup) {
        String groupName = sysGroup.getGroupName();
        String groupId = sysGroup.getId();

        //1.判断用户组信息是否存在
        TbSysGroup tbSysGroup1 = tbSysGroupMapper.selectByPrimaryKey(groupId);
        if (tbSysGroup1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysGroup1.getStatus())) {
            logger.warn("[用户组] 用户组修改失败,修改信息不存在,groupId: {}", sysGroup.getId());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }

        //2.如果修改了用户组,判断名称是否已经存在
        if (!tbSysGroup1.getGroupName().equals(groupName)) {
            List<TbSysGroup> tbSysGroups = checkName(groupName);
            if (tbSysGroups != null && tbSysGroups.size() > 0) {
                logger.warn("[用户组] 更新用户组信息失败，该用户组名称已存在！,groupName: {}", sysGroup.getGroupName());
                throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
            }
        }

        //3.修改用户组信息
        TbSysGroup tbSysGroup = new TbSysGroup();
        BeanUtils.copyProperties(sysGroup, tbSysGroup);
        tbSysGroupMapper.updateByPrimaryKeySelective(tbSysGroup);
        logger.info("[用户组] 更新用户组信息成功！,groupName: {}", sysGroup.getGroupName());
    }

    /**
     * 根据用户组id获取用户组信息
     *
     * @param id 用户组id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据用户组id获取用户组信息")
    public TbSysGroup findSysGroupById(String id) {
        TbSysGroup tbSysGroup = tbSysGroupMapper.selectByPrimaryKey(id);
        return tbSysGroup;
    }

    /**
     * 根据用户组id获取用户组信息及用户组具有的角色信息及条件分页查询用户组为拥有的角色信息
     *
     * @param sysGroupRolePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询用户组已经具有的角色信息,且条件分页获取用户组未拥有的角色信息")
    public PaginationData selectGroupRoleAndOtherRole(SysGroupRolePage sysGroupRolePage) {
        //获取用户组具有的角色
        List<SysRole> roleOfGroupList = sysGroupRoleMapper.findRoleByGroupId(sysGroupRolePage.getGroupId());
        //条件分页查询用户组为拥有的角色信息
        Page<Object> objects = PageHelper.startPage(sysGroupRolePage.getPage(), sysGroupRolePage.getRows());
        List<SysRole> otherRoleList = sysGroupRoleMapper.findRoleByGroupPage(sysGroupRolePage);
        otherRoleList.addAll(roleOfGroupList);
        SysGroupRoleVO sysGroupRoleVO = new SysGroupRoleVO(roleOfGroupList, otherRoleList);
        PaginationData data = new PaginationData(sysGroupRoleVO, objects.getTotal());
        return data;
    }

    /**
     * 为用户组授权角色信息
     *
     * @param sysRoleGroupAdd
     */
    @Override
    @ServiceLog(doAction = "为用户组授权角色信息")
    @Transactional(rollbackFor = Exception.class)
    public void roleGroupAuthorization(SysRoleGroupAdd sysRoleGroupAdd, User user) {
        //插入之前,清除该用户组下面的角色信息
        sysGroupRoleMapper.deteSysGroupRoleByGroupId(sysRoleGroupAdd.getGroupId());
        Boolean isDelete = sysRoleGroupAdd.getRoleIds().length == 0 ? Boolean.TRUE : Boolean.FALSE;
        logger.info("[用户组授权角色] 删除该用户组下角色信息成功！groupId:{}", sysRoleGroupAdd.getGroupId());
        if (isDelete) {
            return;
        }
        String[] groupIds = {sysRoleGroupAdd.getGroupId()};
        List<SysGroupRole> sysGroupRoleList = new ArrayList<SysGroupRole>();
        for (String roleId : sysRoleGroupAdd.getRoleIds()) {
            SysGroupRole sysGroupRole = new SysGroupRole();
            sysGroupRole.setId(UUID.randomUUID().toString());
            sysGroupRole.setStatus(SysStatusEnums.EFFECTIVE.getCode());
            sysGroupRole.setCreator(user.getId());
            sysGroupRole.setRoleId(roleId);
            sysGroupRole.setUserGroupId(sysRoleGroupAdd.getGroupId());
            sysGroupRoleList.add(sysGroupRole);
        }
        //添加新的角色信息
        sysGroupRoleMapper.insertSysGroupRoleBatch(sysGroupRoleList);
        logger.info("[用户组] 用户组授权角色成功，groupId:{}", Arrays.toString(groupIds));
    }

    /**
     * 查询用户组已经具有的用户信息,且条件分页获取用户组未拥有的用户信息
     *
     * @param sysGroupUserPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询用户组已经具有的用户信息,且条件分页获取用户组未拥有的用户信息")
    public PaginationData findOtherUserByPage(SysGroupUserPage sysGroupUserPage) {
        //获取用户组已拥有用户
        List<SysTUser> userAllOfGroup = sysGroupUserMapper.findUserByGroupId(sysGroupUserPage.getGroupId());
        Page<Object> objects = PageHelper.startPage(sysGroupUserPage.getPage(), sysGroupUserPage.getRows());
        //条件分页获取用户组未拥有用户
        List<SysTUser> userList = sysGroupUserMapper.findOtherUserByPage(sysGroupUserPage);
        //将以用户用户放入分页查询到的集合中,方便前端解析
        userList.addAll(userAllOfGroup);
        SysGroupUserVO sysGroupUserVO = new SysGroupUserVO();
        sysGroupUserVO.setUserList(userList);
        sysGroupUserVO.setUserAllOfGroup(userAllOfGroup);
        PaginationData data = new PaginationData(sysGroupUserVO, objects.getTotal());
        return data;
    }

    /**
     * 用户组授权用户
     *
     * @param sysGroupUserAdd
     */
    @Override
    @ServiceLog(doAction = "用户组授权用户")
    @Transactional(rollbackFor = Exception.class)
    public void userGroupAuthorization(SysGroupUserAdd sysGroupUserAdd, User user) {
        //用户组添加用户之前清除用户组以前用户
        sysGroupUserMapper.deleteUserOfGroup(sysGroupUserAdd.getGroupId());
        logger.info("[用户组授权用户] 删除该用户组下用户信息成功！groupId:{}", sysGroupUserAdd.getGroupId());
        Boolean isDelete = sysGroupUserAdd.getUserIds().length == 0 ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }
        List<SysGroupUser> sysGroupUserList = new ArrayList<SysGroupUser>();
        for (String userId : sysGroupUserAdd.getUserIds()) {
            SysGroupUser sysGroupUser = new SysGroupUser();
            sysGroupUser.setId(UUID.randomUUID().toString());
            sysGroupUser.setCreator(user.getId());
            sysGroupUser.setStatus(sysGroupUserAdd.getStatus());
            sysGroupUser.setGroupId(sysGroupUserAdd.getGroupId());
            sysGroupUser.setUserId(userId);
            sysGroupUserList.add(sysGroupUser);
        }
        //批量插入信息新的用户
        sysGroupUserMapper.insertSysGroupUserBatch(sysGroupUserList);
        logger.info("[用户组] 用户组授权用户成功，groupId:{}", sysGroupUserAdd.getGroupId());
    }

    /**
     * 校验用户组名是否可用
     *
     * @param groupName
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验用户组名是否可用")
    public String checkGroupName(String groupName) {
        if (StringUtils.isNotBlank(groupName)) {
            List<TbSysGroup> tbSysGroups = checkName(groupName);
            if (tbSysGroups != null && tbSysGroups.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }
}
