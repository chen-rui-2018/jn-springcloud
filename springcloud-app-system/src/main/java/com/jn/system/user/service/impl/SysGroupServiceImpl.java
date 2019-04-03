package com.jn.system.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.permission.model.SysRoleGroupAdd;
import com.jn.system.permission.service.impl.SysRoleServiceImpl;
import com.jn.system.user.dao.*;
import com.jn.system.user.enmus.SysUserExceptionEnums;
import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.entity.TbSysGroupCriteria;
import com.jn.system.user.entity.TbSysUserGroup;
import com.jn.system.user.entity.TbSysUserGroupCriteria;
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
    @Autowired
    private TbSysUserGroupMapper tbSysUserGroupMapper;


    /**
     * 查询所用用户组信息
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询所用用户组信息")
    public PaginationData<List<SysGroupUserRoleVO>> findSysGroupAll(SysGroupPage groupPage) {
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
     * @param tbSysGroup 用户组
     */
    @Override
    @ServiceLog(doAction = "用户组增加")
    @Transactional(rollbackFor = Exception.class)
    public void addSysGroup(TbSysGroup tbSysGroup) {
        //判断用户组名是否存在
        List<TbSysGroup> tbSysGroups = checkName(tbSysGroup.getGroupName());
        if (tbSysGroups != null && tbSysGroups.size() > 0) {
            logger.warn("[用户组] 添加用户组信息失败，该用户组名称已存在！,groupName: {}", tbSysGroup.getGroupName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
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
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
        return tbSysGroupMapper.selectByExample(tbSysGroupCriteria);
    }

    /**
     * 逻辑删除用户组
     *
     * @param groupIds
     * @param user
     */
    @Override
    @ServiceLog(doAction = "逻辑删除用户组")
    @Transactional(rollbackFor = Exception.class)
    public void deleSysGroup(String[] groupIds, User user) {
        if (groupIds.length == 0) {
            return;
        }

        //删除之前,判断用户组下面是否具有用户,有不允许删除
        for (String groupId : groupIds) {
            TbSysUserGroupCriteria tbSysUserGroupCriteria = new TbSysUserGroupCriteria();
            TbSysUserGroupCriteria.Criteria criteria = tbSysUserGroupCriteria.createCriteria();
            criteria.andGroupIdEqualTo(groupId);
            criteria.andRecordStatusEqualTo(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
            List<TbSysUserGroup> tbSysUserGroups = tbSysUserGroupMapper.selectByExample(tbSysUserGroupCriteria);
            if (tbSysUserGroups != null && tbSysUserGroups.size() > 0) {
                logger.warn("[用户组] 删除失败,用户组正在被使用,不允许删除！,groupId: {}", groupId);
                throw new JnSpringCloudException(SysUserExceptionEnums.NOT_ALLOWED_DELETE_GROUP);
            }
        }

        //封装用户组id及最近更新人信息
        Map<String, Object> map = getDeleteMap(user, groupIds);
        sysGroupMapper.deleteGroupBranch(map);
        logger.info("[用户组] 逻辑删除用户组信息成功,groupIds:{}", Arrays.toString(groupIds));
        sysGroupUserMapper.deleteGroupBranch(map);
        logger.info("[用户组] 逻辑删除用户组关联用户信息成功,groupIds:{}", Arrays.toString(groupIds));
        sysGroupRoleMapper.deleteGroupBranch(map);
        logger.info("[用户组] 逻辑删除用户组关联角色信息成功,groupIds:{}", Arrays.toString(groupIds));
    }

    /**
     * 修改用户组信息
     *
     * @param sysGroup
     * @param user     当时用户信息
     */
    @Override
    @ServiceLog(doAction = "修改用户组信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateSysGroup(SysGroupUpdate sysGroup, User user) {
        String groupName = sysGroup.getGroupName();
        String groupId = sysGroup.getId();

        //1.判断用户组信息是否存在
        TbSysGroup tbSysGroup1 = tbSysGroupMapper.selectByPrimaryKey(groupId);
        if (tbSysGroup1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysGroup1.getRecordStatus().toString())) {
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
        //设置最近修改人信息
        tbSysGroup.setModifiedTime(new Date());
        tbSysGroup.setModifierAccount(user.getAccount());
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
    public PaginationData<SysGroupRoleVO> selectGroupRoleAndOtherRole(SysGroupRolePage sysGroupRolePage) {
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
        String[] ids = {sysRoleGroupAdd.getGroupId()};
        String[] roleIds = sysRoleGroupAdd.getRoleIds();

        //封装删除id及更新人信息
        Map<String, Object> map = getDeleteMap(user, ids);
        sysGroupRoleMapper.deleteGroupBranch(map);
        logger.info("[用户组授权角色] 删除该用户组下角色信息成功！groupId:{}", sysRoleGroupAdd.getGroupId());
        Boolean isDelete = (roleIds == null || roleIds.length == 0) ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }
        String[] groupIds = {sysRoleGroupAdd.getGroupId()};
        List<SysGroupRole> sysGroupRoleList = new ArrayList<SysGroupRole>();
        for (String roleId : roleIds) {
            SysGroupRole sysGroupRole = new SysGroupRole();
            sysGroupRole.setId(UUID.randomUUID().toString());
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            sysGroupRole.setRecordStatus(recordStatus);
            ;
            sysGroupRole.setCreatorAccount(user.getAccount());
            sysGroupRole.setRoleId(roleId);
            sysGroupRole.setUserGroupId(sysRoleGroupAdd.getGroupId());
            sysGroupRoleList.add(sysGroupRole);
        }
        //添加新的角色信息
        sysGroupRoleMapper.insertSysGroupRoleBatch(sysGroupRoleList);
        logger.info("[用户组] 用户组授权角色成功，groupId:{}", Arrays.toString(groupIds));
    }

    /**
     * 封装删除信息
     *
     * @param user 当前用户
     * @param ids  用户组id数组
     * @return
     */
    private Map<String, Object> getDeleteMap(User user, String[] ids) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", ids);
        map.put("account", user.getAccount());
        return map;
    }

    /**
     * 查询用户组已经具有的用户信息,且条件分页获取用户组未拥有的用户信息
     *
     * @param sysGroupUserPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询用户组已经具有的用户信息,且条件分页获取用户组未拥有的用户信息")
    public PaginationData<SysGroupUserVO> findOtherUserByPage(SysGroupUserPage sysGroupUserPage) {
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
        String[] ids = {sysGroupUserAdd.getGroupId()};
        String[] userIds = sysGroupUserAdd.getUserIds();

        Map<String, Object> map = getDeleteMap(user, ids);
        sysGroupUserMapper.deleteGroupBranch(map);
        logger.info("[用户组授权用户] 删除该用户组下用户信息成功！groupId:{}", sysGroupUserAdd.getGroupId());
        Boolean isDelete = (userIds == null || userIds.length == 0) ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }
        List<SysGroupUser> sysGroupUserList = new ArrayList<SysGroupUser>();
        for (String userId : userIds) {
            SysGroupUser sysGroupUser = new SysGroupUser();
            sysGroupUser.setId(UUID.randomUUID().toString());
            sysGroupUser.setCreatorAccount(user.getAccount());
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            sysGroupUser.setRecordStatus(recordStatus);
            sysGroupUser.setGroupId(sysGroupUserAdd.getGroupId());
            sysGroupUser.setUserId(userId);
            sysGroupUserList.add(sysGroupUser);
        }
        //批量插入
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
