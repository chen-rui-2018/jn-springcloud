package com.jn.system.permission.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.Assert;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysRole;
import com.jn.system.model.User;
import com.jn.system.permission.dao.SysRoleMapper;
import com.jn.system.permission.dao.SysRolePermissionMapper;
import com.jn.system.permission.dao.TbSysRoleMapper;
import com.jn.system.permission.entity.TbSysRole;
import com.jn.system.permission.entity.TbSysRoleCriteria;
import com.jn.system.permission.enums.SysPermissionExceptionEnums;
import com.jn.system.permission.model.*;
import com.jn.system.permission.service.SysRolePermissionService;
import com.jn.system.permission.service.SysRoleService;
import com.jn.system.permission.service.SysUserGroupRoleService;
import com.jn.system.permission.service.SysUserRoleService;
import com.jn.system.permission.vo.SysRolePermissionVO;
import com.jn.system.permission.vo.SysRoleUserGroupVO;
import com.jn.system.permission.vo.SysRoleUserVO;
import com.jn.system.permission.vo.SysRoleVO;
import com.jn.system.user.dao.SysGroupRoleMapper;
import com.jn.system.user.dao.SysUserRoleMapper;
import com.jn.system.user.dao.TbSysGroupRoleMapper;
import com.jn.system.user.dao.TbSysUserRoleMapper;
import com.jn.system.user.entity.TbSysGroupRole;
import com.jn.system.user.entity.TbSysGroupRoleCriteria;
import com.jn.system.user.entity.TbSysUserRole;
import com.jn.system.user.entity.TbSysUserRoleCriteria;
import com.jn.system.user.model.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 角色service
 *
 * @author： shaobao
 * @date： Created on 2018/11/1 16:23
 * @version： v2.0
 * @modified By:yuanyy
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    private static Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    private TbSysRoleMapper tbSysRoleMapper;
    @Autowired
    private TbSysUserRoleMapper tbSysUserRoleMapper;
    @Autowired
    private TbSysGroupRoleMapper tbSysGroupRoleMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleService userRoleService;
    @Autowired
    private SysRolePermissionService rolePermissionService;
    @Autowired
    private SysUserGroupRoleService sysUserGroupRoleService;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Autowired
    private SysGroupRoleMapper sysGroupRoleMapper;


    /**
     * 新增角色
     *
     * @param tbSysRole
     */
    @Override
    @ServiceLog(doAction = "新增角色")
    @Transactional(rollbackFor = Exception.class)
    public void insertTbRole(TbSysRole tbSysRole) {
        //判断角色名称是否已经存在
        List<TbSysRole> tbSysRoles = checkName(tbSysRole.getRoleName());
        if (tbSysRoles != null && tbSysRoles.size() > 0) {
            logger.warn("[角色权限] 新增角色失败，该角色名称已存在！,roleName: {}", tbSysRole.getRoleName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        tbSysRoleMapper.insertSelective(tbSysRole);
        logger.info("[角色权限] 新增角色成功！,roleId: {}", tbSysRole.getId());

    }

    /**
     * 用于角色名称校验
     *
     * @param roleName
     * @return
     */
    private List<TbSysRole> checkName(String roleName) {
        TbSysRoleCriteria tbSysRoleCriteria = new TbSysRoleCriteria();
        TbSysRoleCriteria.Criteria criteria = tbSysRoleCriteria.createCriteria();
        criteria.andRoleNameEqualTo(roleName);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
        return tbSysRoleMapper.selectByExample(tbSysRoleCriteria);
    }

    /**
     * 更新角色信息
     *
     * @param role
     * @param user
     */
    @Override
    @ServiceLog(doAction = "更新角色信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateTbRole(SysRoleUpdate role, User user) {
        String roleId = role.getId();
        String roleName = role.getRoleName();
        //1.判断修改信息是否存在
        TbSysRole tbSysRole1 = tbSysRoleMapper.selectByPrimaryKey(roleId);
        if (tbSysRole1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysRole1.getRecordStatus().toString())) {
            logger.warn("[角色] 角色修改失败,修改信息不存在,roleId: {}", roleId);
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        //2.如果修改了角色名称,判断名称是否已经存在
        if (!tbSysRole1.getRoleName().equals(roleName)) {
            List<TbSysRole> tbSysRoles = checkName(roleName);
            if (tbSysRoles != null && tbSysRoles.size() > 0) {
                logger.warn("[角色权限] 更新角色失败，该角色名称已存在！,roleName: {},roleId: {}", roleName, roleId);
                throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
            }
        }

        //3.修改角色信息
        TbSysRole tbSysRole = new TbSysRole();
        BeanUtils.copyProperties(role, tbSysRole);
        //设置最近更新人信息
        tbSysRole.setModifiedTime(new Date());
        tbSysRole.setModifierAccount(user.getAccount());
        tbSysRoleMapper.updateByPrimaryKeySelective(tbSysRole);
        logger.info("[角色权限] 更新角色成功！,roleId: {}", role.getId());
    }

    /**
     * @param roleIds
     * @param user    当前用户信息
     */
    @Override
    @ServiceLog(doAction = "批量删除角色（逻辑删除）")
    @Transactional(rollbackFor = Exception.class)
    public void
    deleteTbRoleById(String[] roleIds, User user) {
        if (roleIds.length == 0) {
            return;
        }

        //判断删除角色是否正在被使用
        for (String roleId : roleIds) {
            //查询角色在用户中使用情况
            TbSysUserRoleCriteria tbSysUserRoleCriteria = new TbSysUserRoleCriteria();
            TbSysUserRoleCriteria.Criteria criteria = tbSysUserRoleCriteria.createCriteria();
            criteria.andRoleIdEqualTo(roleId);
            criteria.andRecordStatusEqualTo(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
            List<TbSysUserRole> tbSysUserRoles = tbSysUserRoleMapper.selectByExample(tbSysUserRoleCriteria);

            //查询角色在用户组中使用情况
            TbSysGroupRoleCriteria tbSysGroupRoleCriteria = new TbSysGroupRoleCriteria();
            TbSysGroupRoleCriteria.Criteria criteria1 = tbSysGroupRoleCriteria.createCriteria();
            criteria1.andRoleIdEqualTo(roleId);
            criteria1.andRecordStatusEqualTo(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
            List<TbSysGroupRole> tbSysGroupRoles = tbSysGroupRoleMapper.selectByExample(tbSysGroupRoleCriteria);

            //判断角色是否正在被用户或用户组使用
            Boolean flag = (tbSysUserRoles != null && tbSysUserRoles.size() > 0) ||
                    (tbSysGroupRoles != null && tbSysGroupRoles.size() > 0);
            if (flag) {
                logger.warn("[角色权限] 删除失败,角色正在被使用,不允许删除！,roleIds: {}", Arrays.toString(roleIds));
                throw new JnSpringCloudException(SysPermissionExceptionEnums.NOT_ALLOWED_DELETE_ROLE);
            }
        }

        //封装删除id及更新人信息
        Map<String, Object> map = getDeleteMap(user, roleIds);
        sysRoleMapper.deleteBy(map);
        logger.info("[角色权限] 删除角色成功！,roleIds: {}", Arrays.toString(roleIds));
        userRoleService.deleteTbUserRoleByRoleIds(map);
        logger.info("[角色权限] 删除角色关联用户信息成功！,roleIds: {}", Arrays.toString(roleIds));
        rolePermissionService.deleteTbRolePermissionByRoleIds(map);
        logger.info("[角色权限] 删除角色关联权限成功！,roleIds: {}", Arrays.toString(roleIds));
        sysGroupRoleMapper.deleteTbSysGroupRoleByRoleIds(map);
        logger.info("[角色权限] 删除角色关联用户组信息成功！,roleIds: {}", Arrays.toString(roleIds));
    }

    /**
     * 分页查询角色授权列表信息
     *
     * @param rolePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页查询角色授权列表信息")
    public PaginationData<List<SysRoleVO>> selectRoleListBySearchKey(SysRolePage rolePage) {
        Page<Object> objects = PageHelper.startPage(rolePage.getPage(), rolePage.getRows());
        List<SysRoleVO> sysRoleVOList = sysRoleMapper.findTByPage(rolePage);
        for (SysRoleVO sysRoleVO : sysRoleVOList) {
            //根据角色id获取角色对应用户名称
            List<String> userNameList = sysUserRoleMapper.findUserNameByRoleId(sysRoleVO.getRoleId());
            sysRoleVO.setSysUserRoles(userNameList);
            //根据角色id获取角色对应的权限信息
            List<String> permissionNameList = sysRolePermissionMapper.findPermissionNameByRoleId(sysRoleVO.getRoleId());
            sysRoleVO.setSysRolePermissions(permissionNameList);
        }
        return new PaginationData(sysRoleVOList, objects.getTotal());

    }

    /**
     * 添加角色授权（用户）
     *
     * @param sysUserRoleAdd
     */
    @Override
    @ServiceLog(doAction = "添加角色授权（用户）")
    @Transactional(rollbackFor = Exception.class)
    public void userRoleAuthorization(SysUserRoleAdd sysUserRoleAdd, User user) {
        String[] roleIds = {sysUserRoleAdd.getRoleId()};
        String[] userIds = sysUserRoleAdd.getUserId();
        //插入前删除该角色的所有用户角色数据
        Map<String, Object> map = getDeleteMap(user, roleIds);
        userRoleService.deleteTbUserRoleByRoleIds(map);
        logger.info("[角色授权用户] 删除该角色下用户信息成功！roleId:{}", sysUserRoleAdd.getRoleId());
        Boolean isDelete = (userIds == null || userIds.length == 0) ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }
        //批量插入用户角色信息
        List<SysUserRole> sysUserRoleList = new ArrayList<>();
        for (int i = 0; i < userIds.length; i++) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setId(UUID.randomUUID().toString());
            //状态，默认有效
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            sysUserRole.setRecordStatus(recordStatus);
            sysUserRole.setCreatorAccount(user.getAccount());
            sysUserRole.setUserId(userIds[i]);
            sysUserRole.setRoleId(sysUserRoleAdd.getRoleId());
            sysUserRoleList.add(sysUserRole);
        }
        //批量插入用户角色信息
        userRoleService.insertTbUserRoleBatch(sysUserRoleList);
        logger.info("[角色] 添加角色授权用户,插入前删除该角色的所有用户角色数据，roleId: {}", Arrays.toString(roleIds));

    }

    /**
     * 添加角色授权（权限）
     *
     * @param sysRolePermissionAdd
     */
    @Override
    @ServiceLog(doAction = "添加角色授权（权限）")
    @Transactional(rollbackFor = Exception.class)
    public void rolePermissionAuthorization(SysRolePermissionAdd sysRolePermissionAdd, User user) {
        String[] roleIds = {sysRolePermissionAdd.getRoleId()};
        String[] permissionIds = sysRolePermissionAdd.getPermissionId();

        //插入前删除该角色的所有角色权限数据
        Map<String, Object> map = getDeleteMap(user, roleIds);
        rolePermissionService.deleteTbRolePermissionByRoleIds(map);
        logger.info("[角色授权权限] 删除该角色下权限信息成功！roleId:{}", sysRolePermissionAdd.getRoleId());
        Boolean isDelete = (permissionIds == null || permissionIds.length == 0) ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }

        //批量插入角色权限信息
        List<SysRolePermission> sysRolePermissionList = new ArrayList<>();
        for (int i = 0; i < permissionIds.length; i++) {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setId(UUID.randomUUID().toString());
            //状态，默认有效
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            sysRolePermission.setRecordStatus(recordStatus);
            sysRolePermission.setCreatorAccount(user.getAccount());
            sysRolePermission.setPermissionId(permissionIds[i]);
            sysRolePermission.setRoleId(sysRolePermissionAdd.getRoleId());
            sysRolePermissionList.add(sysRolePermission);
        }
        //批量插入角色权限
        rolePermissionService.insertTbRolePermissionBatch(sysRolePermissionList);
        logger.info("[角色授权权限] 添加角色授权权限,插入前删除该角色的所有角色权限数据，roleId: {}", Arrays.toString(roleIds));

    }

    /**
     * 封装删除信息
     *
     * @param user    当前用户
     * @param roleIds 角色id数组
     * @return
     */
    private Map<String, Object> getDeleteMap(User user, String[] roleIds) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", roleIds);
        map.put("account", user.getAccount());
        return map;
    }

    /**
     * 添加角色授权（用户组）
     *
     * @param sysUserGroupRoleAdd
     */
    @Override
    @ServiceLog(doAction = "添加角色授权（用户组）")
    @Transactional(rollbackFor = Exception.class)
    public void userGroupRoleAuthorization(SysUserGroupRoleAdd sysUserGroupRoleAdd, User user) {
        String[] roleIds = {sysUserGroupRoleAdd.getRoleId()};
        String[] userGroupIds = sysUserGroupRoleAdd.getUserGroupId();
        //插入前删除该角色的所有用户组角色数据
        Map<String, Object> map = getDeleteMap(user, roleIds);
        sysGroupRoleMapper.deleteTbSysGroupRoleByRoleIds(map);
        logger.info("[角色授权用户组] 删除该角色下用户组信息成功！roleId:{}", sysUserGroupRoleAdd.getRoleId());
        Boolean isDelete = (userGroupIds == null || userGroupIds.length == 0) ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }
        List<SysUserGroupRole> sysUserGroupRoleList = new ArrayList<>();
        for (int i = 0; i < userGroupIds.length; i++) {
            SysUserGroupRole sysUserGroupRole = new SysUserGroupRole();
            sysUserGroupRole.setId(UUID.randomUUID().toString());
            //状态，默认有效
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            sysUserGroupRole.setRecordStatus(recordStatus);
            ;
            sysUserGroupRole.setCreatorAccount(user.getAccount());
            sysUserGroupRole.setUserGroupId(userGroupIds[i]);
            sysUserGroupRole.setRoleId(sysUserGroupRoleAdd.getRoleId());
            sysUserGroupRoleList.add(sysUserGroupRole);
        }
        //批量插入用户组角色
        sysUserGroupRoleService.insertTbUserGroupRoleBatch(sysUserGroupRoleList);
        logger.info("[角色权限] 添加角色授权用户组,插入前删除该角色的所有用户组角色数据，roleId: {}", Arrays.toString(roleIds));
    }

    /**
     * 校验角色名称是否已经存在
     *
     * @param roleName
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验角色名称是否已经存在")
    public String checkRoleName(String roleName) {
        if (StringUtils.isNotBlank(roleName)) {
            List<TbSysRole> tbSysRoles = checkName(roleName);
            if (tbSysRoles != null && tbSysRoles.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

    /**
     * 查询角色已经具有的用户信息,且条件分页获取为角色未拥有的用户信息
     *
     * @param sysRoleUserPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询角色已经具有的用户信息,且条件分页获取为角色未拥有的用户信息")
    public PaginationData<SysRoleUserVO> findUserOfRoleAndOtherUser(SysRoleUserPage sysRoleUserPage) {
        //根据角色id获取角色已经拥有的用户信息
        List<User> userOfRoleList = sysUserRoleMapper.findUserByRoleId(sysRoleUserPage.getRoleId());
        //条件分页获取角色未拥有用户信息
        Page<Object> objects = PageHelper.startPage(sysRoleUserPage.getPage(), sysRoleUserPage.getRows());
        List<User> otherUserList = sysUserRoleMapper.findOtherUser(sysRoleUserPage);
        //方便前端解析,将已拥有数据添加到为拥有数据中
        otherUserList.addAll(userOfRoleList);
        SysRoleUserVO sysRoleUserVO = new SysRoleUserVO(userOfRoleList, otherUserList);
        PaginationData data = new PaginationData(sysRoleUserVO, objects.getTotal());
        return data;
    }

    /**
     * 查询角色已经具有的用户组信息,且条件分页获取角色未拥有的用户组信息
     *
     * @param sysRoleUserGroupPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询角色已经具有的用户组信息,且条件分页获取角色未拥有的用户组信息")
    public PaginationData<SysRoleUserGroupVO> findUserGroupOfRoleAndOtherGroup(SysRoleUserGroupPage sysRoleUserGroupPage) {
        //获取角色已经拥有的用户组信息
        List<SysGroup> userGroupOfRoleList = sysGroupRoleMapper.findUserGroupByRoleId(sysRoleUserGroupPage.getRoleId());
        //条件分页获取角色为拥有的用户组信息
        Page<Object> objects = PageHelper.startPage(sysRoleUserGroupPage.getPage(), sysRoleUserGroupPage.getRows());
        List<SysGroup> otherUserGroupList = sysGroupRoleMapper.findOtherUserGroup(sysRoleUserGroupPage);
        otherUserGroupList.addAll(userGroupOfRoleList);
        SysRoleUserGroupVO sysRoleUserGroupVO = new SysRoleUserGroupVO(userGroupOfRoleList, otherUserGroupList);
        PaginationData data = new PaginationData(sysRoleUserGroupVO, objects.getTotal());
        return data;
    }

    /**
     * 查询角色已经具有的权限信息,且条件分页获取角色未拥有的权限信息
     *
     * @param sysRolePermissionPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询角色具有的权限信息及条件分页获取为拥有权限信息")
    public PaginationData<SysRolePermissionVO> findPermissionOrRoleAndOtherPermission(SysRolePermissionPage sysRolePermissionPage) {
        //获取角色已经拥有的权限信息
        List<SysPermission> permissionOfRoleList =
                sysRolePermissionMapper.findPermissionByRoleId(sysRolePermissionPage.getRoleId());
        //条件分页获取角色为拥有的权限信息
        Page<Object> objects = PageHelper.startPage(sysRolePermissionPage.getPage(), sysRolePermissionPage.getRows());
        List<SysPermission> otherPermissionList = sysRolePermissionMapper.findOtherUserGroup(sysRolePermissionPage);
        otherPermissionList.addAll(permissionOfRoleList);
        SysRolePermissionVO sysRolePermissionVO = new SysRolePermissionVO(permissionOfRoleList, otherPermissionList);
        PaginationData data = new PaginationData(sysRolePermissionVO, objects.getTotal());
        return data;
    }

    /**
     * 根据角色名称,获取角色信息
     *
     * @param roleName 角色名称
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据角色名称,获取角色信息")
    public SysRole getRoleByName(String roleName) {
        TbSysRoleCriteria tbSysRoleCriteria = new TbSysRoleCriteria();
        TbSysRoleCriteria.Criteria criteria = tbSysRoleCriteria.createCriteria();
        criteria.andRecordStatusEqualTo(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
        criteria.andRoleNameEqualTo(roleName);
        List<TbSysRole> tbSysRoles = tbSysRoleMapper.selectByExample(tbSysRoleCriteria);
        if (tbSysRoles != null && tbSysRoles.size() > 0) {
            SysRole sysRole = new SysRole();
            BeanUtils.copyProperties(tbSysRoles.get(0), sysRole);
            return sysRole;
        }
        return null;
    }

    /**
     * 根据角色id或角色名称获取角色拥有的用户信息
     *
     * @param role
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据角色id或角色名称获取角色拥有的用户信息")
    public List<User> getUserByRole(SysRole role) {
        String roleId = role.getId();
        String roleName = role.getRoleName();
        //如果角色id为空,角色名称不为空,根据角色名称查询角色信息
        if (StringUtils.isBlank(roleId) && StringUtils.isNotBlank(roleName)) {
            SysRole sysRole = getRoleByName(roleName);
            if (sysRole == null || SysStatusEnums.DELETED.getCode().equals(sysRole.getRecordStatus().toString())) {
                logger.warn("[角色] 角色信息不存在,roleId: {}", roleId);
                throw new JnSpringCloudException(SysExceptionEnums.ROLE_NOT_EXIST);
            }
            roleId = sysRole.getId();
        }
        Assert.notNull(roleId, SysPermissionExceptionEnums.ROLE_ID_NOT_NULL.getMessage());

        //根据角色id,获取角色具有的用户信息
        List<User> userList = sysUserRoleMapper.findUserByRoleId(roleId);
        return userList;
    }

}
