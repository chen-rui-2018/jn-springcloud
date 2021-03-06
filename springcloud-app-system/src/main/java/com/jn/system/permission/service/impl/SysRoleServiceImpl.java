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
 * ??????service
 *
 * @author??? shaobao
 * @date??? Created on 2018/11/1 16:23
 * @version??? v2.0
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
     * ????????????
     *
     * @param tbSysRole
     */
    @Override
    @ServiceLog(doAction = "????????????")
    @Transactional(rollbackFor = Exception.class)
    public void insertTbRole(TbSysRole tbSysRole) {
        //????????????????????????????????????
        List<TbSysRole> tbSysRoles = checkName(tbSysRole.getRoleName());
        if (tbSysRoles != null && tbSysRoles.size() > 0) {
            logger.warn("[????????????] ????????????????????????????????????????????????,roleName: {}", tbSysRole.getRoleName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        tbSysRoleMapper.insertSelective(tbSysRole);
        logger.info("[????????????] ?????????????????????,roleId: {}", tbSysRole.getId());

    }

    /**
     * ????????????????????????
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
     * ??????????????????
     *
     * @param role
     * @param user
     */
    @Override
    @ServiceLog(doAction = "??????????????????")
    @Transactional(rollbackFor = Exception.class)
    public void updateTbRole(SysRoleUpdate role, User user) {
        String roleId = role.getId();
        String roleName = role.getRoleName();
        //1.??????????????????????????????
        TbSysRole tbSysRole1 = tbSysRoleMapper.selectByPrimaryKey(roleId);
        if (tbSysRole1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysRole1.getRecordStatus().toString())) {
            logger.warn("[??????] ??????????????????,?????????????????????,roleId: {}", roleId);
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        //2.???????????????????????????,??????????????????????????????
        if (!tbSysRole1.getRoleName().equals(roleName)) {
            List<TbSysRole> tbSysRoles = checkName(roleName);
            if (tbSysRoles != null && tbSysRoles.size() > 0) {
                logger.warn("[????????????] ????????????????????????????????????????????????,roleName: {},roleId: {}", roleName, roleId);
                throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
            }
        }

        //3.??????????????????
        TbSysRole tbSysRole = new TbSysRole();
        BeanUtils.copyProperties(role, tbSysRole);
        //???????????????????????????
        tbSysRole.setModifiedTime(new Date());
        tbSysRole.setModifierAccount(user.getAccount());
        tbSysRoleMapper.updateByPrimaryKeySelective(tbSysRole);
        logger.info("[????????????] ?????????????????????,roleId: {}", role.getId());
    }

    /**
     * @param roleIds
     * @param user    ??????????????????
     */
    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    public void
    deleteTbRoleById(String[] roleIds, User user) {
        if (roleIds.length == 0) {
            return;
        }

        //???????????????????????????????????????
        for (String roleId : roleIds) {
            //????????????????????????????????????
            TbSysUserRoleCriteria tbSysUserRoleCriteria = new TbSysUserRoleCriteria();
            TbSysUserRoleCriteria.Criteria criteria = tbSysUserRoleCriteria.createCriteria();
            criteria.andRoleIdEqualTo(roleId);
            criteria.andRecordStatusEqualTo(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
            List<TbSysUserRole> tbSysUserRoles = tbSysUserRoleMapper.selectByExample(tbSysUserRoleCriteria);

            //???????????????????????????????????????
            TbSysGroupRoleCriteria tbSysGroupRoleCriteria = new TbSysGroupRoleCriteria();
            TbSysGroupRoleCriteria.Criteria criteria1 = tbSysGroupRoleCriteria.createCriteria();
            criteria1.andRoleIdEqualTo(roleId);
            criteria1.andRecordStatusEqualTo(new Byte(SysStatusEnums.EFFECTIVE.getCode()));
            List<TbSysGroupRole> tbSysGroupRoles = tbSysGroupRoleMapper.selectByExample(tbSysGroupRoleCriteria);

            //???????????????????????????????????????????????????
            Boolean flag = (tbSysUserRoles != null && tbSysUserRoles.size() > 0) ||
                    (tbSysGroupRoles != null && tbSysGroupRoles.size() > 0);
            if (flag) {
                logger.warn("[????????????] ????????????,?????????????????????,??????????????????,roleIds: {}", Arrays.toString(roleIds));
                throw new JnSpringCloudException(SysPermissionExceptionEnums.NOT_ALLOWED_DELETE_ROLE);
            }
        }

        //????????????id??????????????????
        Map<String, Object> map = getDeleteMap(user, roleIds);
        sysRoleMapper.deleteBy(map);
        logger.info("[????????????] ?????????????????????,roleIds: {}", Arrays.toString(roleIds));
        userRoleService.deleteTbUserRoleByRoleIds(map);
        logger.info("[????????????] ???????????????????????????????????????,roleIds: {}", Arrays.toString(roleIds));
        rolePermissionService.deleteTbRolePermissionByRoleIds(map);
        logger.info("[????????????] ?????????????????????????????????,roleIds: {}", Arrays.toString(roleIds));
        sysGroupRoleMapper.deleteTbSysGroupRoleByRoleIds(map);
        logger.info("[????????????] ??????????????????????????????????????????,roleIds: {}", Arrays.toString(roleIds));
    }

    /**
     * ????????????????????????????????????
     *
     * @param rolePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
    public PaginationData<List<SysRoleVO>> selectRoleListBySearchKey(SysRolePage rolePage) {
        Page<Object> objects = PageHelper.startPage(rolePage.getPage(), rolePage.getRows());
        List<SysRoleVO> sysRoleVOList = sysRoleMapper.findTByPage(rolePage);
        for (SysRoleVO sysRoleVO : sysRoleVOList) {
            //????????????id??????????????????????????????
            List<String> userNameList = sysUserRoleMapper.findUserNameByRoleId(sysRoleVO.getRoleId());
            sysRoleVO.setSysUserRoles(userNameList);
            //????????????id?????????????????????????????????
            List<String> permissionNameList = sysRolePermissionMapper.findPermissionNameByRoleId(sysRoleVO.getRoleId());
            sysRoleVO.setSysRolePermissions(permissionNameList);
        }
        return new PaginationData(sysRoleVOList, objects.getTotal());

    }

    /**
     * ??????????????????????????????
     *
     * @param sysUserRoleAdd
     */
    @Override
    @ServiceLog(doAction = "??????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    public void userRoleAuthorization(SysUserRoleAdd sysUserRoleAdd, User user) {
        String[] roleIds = {sysUserRoleAdd.getRoleId()};
        String[] userIds = sysUserRoleAdd.getUserId();
        //???????????????????????????????????????????????????
        Map<String, Object> map = getDeleteMap(user, roleIds);
        userRoleService.deleteTbUserRoleByRoleIds(map);
        logger.info("[??????????????????] ???????????????????????????????????????roleId:{}", sysUserRoleAdd.getRoleId());
        Boolean isDelete = (userIds == null || userIds.length == 0) ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }
        //??????????????????????????????
        List<SysUserRole> sysUserRoleList = new ArrayList<>();
        for (int i = 0; i < userIds.length; i++) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setId(UUID.randomUUID().toString());
            //?????????????????????
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            sysUserRole.setRecordStatus(recordStatus);
            sysUserRole.setCreatorAccount(user.getAccount());
            sysUserRole.setUserId(userIds[i]);
            sysUserRole.setRoleId(sysUserRoleAdd.getRoleId());
            sysUserRoleList.add(sysUserRole);
        }
        //??????????????????????????????
        userRoleService.insertTbUserRoleBatch(sysUserRoleList);
        logger.info("[??????] ????????????????????????,??????????????????????????????????????????????????????roleId: {}", Arrays.toString(roleIds));

    }

    /**
     * ??????????????????????????????
     *
     * @param sysRolePermissionAdd
     */
    @Override
    @ServiceLog(doAction = "??????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    public void rolePermissionAuthorization(SysRolePermissionAdd sysRolePermissionAdd, User user) {
        String[] roleIds = {sysRolePermissionAdd.getRoleId()};
        String[] permissionIds = sysRolePermissionAdd.getPermissionId();

        //???????????????????????????????????????????????????
        Map<String, Object> map = getDeleteMap(user, roleIds);
        rolePermissionService.deleteTbRolePermissionByRoleIds(map);
        logger.info("[??????????????????] ???????????????????????????????????????roleId:{}", sysRolePermissionAdd.getRoleId());
        Boolean isDelete = (permissionIds == null || permissionIds.length == 0) ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }

        //??????????????????????????????
        List<SysRolePermission> sysRolePermissionList = new ArrayList<>();
        for (int i = 0; i < permissionIds.length; i++) {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setId(UUID.randomUUID().toString());
            //?????????????????????
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            sysRolePermission.setRecordStatus(recordStatus);
            sysRolePermission.setCreatorAccount(user.getAccount());
            sysRolePermission.setPermissionId(permissionIds[i]);
            sysRolePermission.setRoleId(sysRolePermissionAdd.getRoleId());
            sysRolePermissionList.add(sysRolePermission);
        }
        //????????????????????????
        rolePermissionService.insertTbRolePermissionBatch(sysRolePermissionList);
        logger.info("[??????????????????] ????????????????????????,??????????????????????????????????????????????????????roleId: {}", Arrays.toString(roleIds));

    }

    /**
     * ??????????????????
     *
     * @param user    ????????????
     * @param roleIds ??????id??????
     * @return
     */
    private Map<String, Object> getDeleteMap(User user, String[] roleIds) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("ids", roleIds);
        map.put("account", user.getAccount());
        return map;
    }

    /**
     * ?????????????????????????????????
     *
     * @param sysUserGroupRoleAdd
     */
    @Override
    @ServiceLog(doAction = "?????????????????????????????????")
    @Transactional(rollbackFor = Exception.class)
    public void userGroupRoleAuthorization(SysUserGroupRoleAdd sysUserGroupRoleAdd, User user) {
        String[] roleIds = {sysUserGroupRoleAdd.getRoleId()};
        String[] userGroupIds = sysUserGroupRoleAdd.getUserGroupId();
        //??????????????????????????????????????????????????????
        Map<String, Object> map = getDeleteMap(user, roleIds);
        sysGroupRoleMapper.deleteTbSysGroupRoleByRoleIds(map);
        logger.info("[?????????????????????] ??????????????????????????????????????????roleId:{}", sysUserGroupRoleAdd.getRoleId());
        Boolean isDelete = (userGroupIds == null || userGroupIds.length == 0) ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }
        List<SysUserGroupRole> sysUserGroupRoleList = new ArrayList<>();
        for (int i = 0; i < userGroupIds.length; i++) {
            SysUserGroupRole sysUserGroupRole = new SysUserGroupRole();
            sysUserGroupRole.setId(UUID.randomUUID().toString());
            //?????????????????????
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            sysUserGroupRole.setRecordStatus(recordStatus);
            ;
            sysUserGroupRole.setCreatorAccount(user.getAccount());
            sysUserGroupRole.setUserGroupId(userGroupIds[i]);
            sysUserGroupRole.setRoleId(sysUserGroupRoleAdd.getRoleId());
            sysUserGroupRoleList.add(sysUserGroupRole);
        }
        //???????????????????????????
        sysUserGroupRoleService.insertTbUserGroupRoleBatch(sysUserGroupRoleList);
        logger.info("[????????????] ???????????????????????????,?????????????????????????????????????????????????????????roleId: {}", Arrays.toString(roleIds));
    }

    /**
     * ????????????????????????????????????
     *
     * @param roleName
     * @return
     */
    @Override
    @ServiceLog(doAction = "????????????????????????????????????")
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
     * ???????????????????????????????????????,??????????????????????????????????????????????????????
     *
     * @param sysRoleUserPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "???????????????????????????????????????,??????????????????????????????????????????????????????")
    public PaginationData<SysRoleUserVO> findUserOfRoleAndOtherUser(SysRoleUserPage sysRoleUserPage) {
        //????????????id???????????????????????????????????????
        List<User> userOfRoleList = sysUserRoleMapper.findUserByRoleId(sysRoleUserPage.getRoleId());
        //?????????????????????????????????????????????
        Page<Object> objects = PageHelper.startPage(sysRoleUserPage.getPage(), sysRoleUserPage.getRows());
        List<User> otherUserList = sysUserRoleMapper.findOtherUser(sysRoleUserPage);
        //??????????????????,?????????????????????????????????????????????
        otherUserList.addAll(userOfRoleList);
        SysRoleUserVO sysRoleUserVO = new SysRoleUserVO(userOfRoleList, otherUserList);
        PaginationData data = new PaginationData(sysRoleUserVO, objects.getTotal());
        return data;
    }

    /**
     * ??????????????????????????????????????????,??????????????????????????????????????????????????????
     *
     * @param sysRoleUserGroupPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "??????????????????????????????????????????,??????????????????????????????????????????????????????")
    public PaginationData<SysRoleUserGroupVO> findUserGroupOfRoleAndOtherGroup(SysRoleUserGroupPage sysRoleUserGroupPage) {
        //??????????????????????????????????????????
        List<SysGroup> userGroupOfRoleList = sysGroupRoleMapper.findUserGroupByRoleId(sysRoleUserGroupPage.getRoleId());
        //???????????????????????????????????????????????????
        Page<Object> objects = PageHelper.startPage(sysRoleUserGroupPage.getPage(), sysRoleUserGroupPage.getRows());
        List<SysGroup> otherUserGroupList = sysGroupRoleMapper.findOtherUserGroup(sysRoleUserGroupPage);
        otherUserGroupList.addAll(userGroupOfRoleList);
        SysRoleUserGroupVO sysRoleUserGroupVO = new SysRoleUserGroupVO(userGroupOfRoleList, otherUserGroupList);
        PaginationData data = new PaginationData(sysRoleUserGroupVO, objects.getTotal());
        return data;
    }

    /**
     * ???????????????????????????????????????,???????????????????????????????????????????????????
     *
     * @param sysRolePermissionPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "???????????????????????????????????????????????????????????????????????????")
    public PaginationData<SysRolePermissionVO> findPermissionOrRoleAndOtherPermission(SysRolePermissionPage sysRolePermissionPage) {
        //???????????????????????????????????????
        List<SysPermission> permissionOfRoleList =
                sysRolePermissionMapper.findPermissionByRoleId(sysRolePermissionPage.getRoleId());
        //????????????????????????????????????????????????
        Page<Object> objects = PageHelper.startPage(sysRolePermissionPage.getPage(), sysRolePermissionPage.getRows());
        List<SysPermission> otherPermissionList = sysRolePermissionMapper.findOtherUserGroup(sysRolePermissionPage);
        otherPermissionList.addAll(permissionOfRoleList);
        SysRolePermissionVO sysRolePermissionVO = new SysRolePermissionVO(permissionOfRoleList, otherPermissionList);
        PaginationData data = new PaginationData(sysRolePermissionVO, objects.getTotal());
        return data;
    }

    /**
     * ??????????????????,??????????????????
     *
     * @param roleName ????????????
     * @return
     */
    @Override
    @ServiceLog(doAction = "??????????????????,??????????????????")
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
     * ????????????id????????????????????????????????????????????????
     *
     * @param role
     * @return
     */
    @Override
    @ServiceLog(doAction = "????????????id????????????????????????????????????????????????")
    public List<User> getUserByRole(SysRole role) {
        String roleId = role.getId();
        String roleName = role.getRoleName();
        //????????????id??????,?????????????????????,????????????????????????????????????
        if (StringUtils.isBlank(roleId) && StringUtils.isNotBlank(roleName)) {
            SysRole sysRole = getRoleByName(roleName);
            if (sysRole == null || SysStatusEnums.DELETED.getCode().equals(sysRole.getRecordStatus().toString())) {
                logger.warn("[??????] ?????????????????????,roleId: {}", roleId);
                throw new JnSpringCloudException(SysExceptionEnums.ROLE_NOT_EXIST);
            }
            roleId = sysRole.getId();
        }
        Assert.notNull(roleId, SysPermissionExceptionEnums.ROLE_ID_NOT_NULL.getMessage());

        //????????????id,?????????????????????????????????
        List<User> userList = sysUserRoleMapper.findUserByRoleId(roleId);
        return userList;
    }

}
