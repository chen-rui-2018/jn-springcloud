package com.jn.system.permission.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.model.SysFileGroup;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.menu.dao.TbSysMenuMapper;
import com.jn.system.menu.dao.TbSysResourcesMapper;
import com.jn.system.menu.model.SysMenu;
import com.jn.system.menu.model.SysResources;
import com.jn.system.model.*;
import com.jn.system.permission.dao.*;
import com.jn.system.permission.entity.*;
import com.jn.system.permission.model.*;
import com.jn.system.permission.service.SysPermissionService;
import com.jn.system.dept.service.impl.SysPostServiceImpl;
import com.jn.system.permission.vo.SysPermissionFileGroupVO;
import com.jn.system.permission.vo.SysPermissionMenuVO;
import com.jn.system.permission.vo.SysPermissionResourcesVO;
import com.jn.system.permission.vo.SysPermissionRoleVO;
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
 * 权限服务层
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 9:18
 * @version： v1.0
 * @modified By:
 **/
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    private Logger logger = LoggerFactory.getLogger(SysPostServiceImpl.class);

    @Autowired
    private TbSysPermissionMapper tbSysPermissionMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysPermissionFilesMapper sysPermissionFilesMapper;
    @Autowired
    private SysPermissionMenuMapper sysPermissionMenuMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Autowired
    private SysPermissionResourcesMapper sysPermissionResourcesMapper;
    @Autowired
    private TbSysMenuMapper tbSysMenuMapper;
    @Autowired
    private TbSysResourcesMapper tbSysResourcesMapper;

    /**
     * 添加权限
     *
     * @param sysPermissionAdd
     */
    @Override
    @ServiceLog(doAction = "添加权限")
    @Transactional(rollbackFor = Exception.class)
    public void addPermission(SysPermissionAdd sysPermissionAdd, User user) {
        //判断权限名称是否已经存在
        List<TbSysPermission> tbSysPermissions = checkName(sysPermissionAdd.getPermissionName());
        if (tbSysPermissions != null && tbSysPermissions.size() > 0) {
            logger.info("[权限] 新增权限信息失败，权限名称已存在！，permissionName:{}", sysPermissionAdd.getPermissionName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        TbSysPermission tbSysPermission = new TbSysPermission();
        tbSysPermission.setId(UUID.randomUUID().toString());
        tbSysPermission.setCreateTime(new Date());
        tbSysPermission.setCreator(user.getId());
        tbSysPermission.setPermissionName(sysPermissionAdd.getPermissionName());
        tbSysPermission.setStatus(sysPermissionAdd.getStatus());
        tbSysPermissionMapper.insertSelective(tbSysPermission);
        logger.info("[权限] 新增权限信息成功！，sysPermissionId:{}", tbSysPermission.getId());
    }

    /**
     * 用于权限名称校验
     *
     * @param permissionName
     * @return
     */
    private List<TbSysPermission> checkName(String permissionName) {
        TbSysPermissionCriteria tbSysPermissionCriteria = new TbSysPermissionCriteria();
        TbSysPermissionCriteria.Criteria criteria = tbSysPermissionCriteria.createCriteria();
        criteria.andPermissionNameEqualTo(permissionName);
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        return tbSysPermissionMapper.selectByExample(tbSysPermissionCriteria);
    }

    /**
     * 修改权限
     *
     * @param sysPermission
     */
    @Override
    @ServiceLog(doAction = "修改权限")
    @Transactional(rollbackFor = Exception.class)
    public void updatePermission(SysPermission sysPermission) {
        TbSysPermissionCriteria tbSysPermissionCriteria = new TbSysPermissionCriteria();
        TbSysPermissionCriteria.Criteria criteria = tbSysPermissionCriteria.createCriteria();
        criteria.andPermissionNameEqualTo(sysPermission.getPermissionName());
        criteria.andIdNotEqualTo(sysPermission.getId());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        List<TbSysPermission> tbSysPermissions = tbSysPermissionMapper.selectByExample(tbSysPermissionCriteria);
        if (tbSysPermissions != null && tbSysPermissions.size() > 0) {
            logger.info("[权限] 修改权限信息失败，权限名称已存在！，permissionName:{}", sysPermission.getPermissionName());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
        }
        sysPermissionMapper.updatePermission(sysPermission);
        logger.info("[权限] 修改权限信息成功！，sysPermissionId:{}", sysPermission.getId());
    }

    /**
     * 根据主键获取权限信息
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据主键获取权限信息")
    public SysPermission selectByPrimaryKey(String id) {
        TbSysPermission tbSysPermission = tbSysPermissionMapper.selectByPrimaryKey(id);
        SysPermission sysPermission = new SysPermission();
        if (tbSysPermission != null) {
            BeanUtils.copyProperties(tbSysPermission, sysPermission);
        }
        return sysPermission;
    }

    /**
     * 条件分页查询
     *
     * @param sysPermissionPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "条件分页查询")
    public PaginationData findByPage(SysPermissionPage sysPermissionPage) {
        Page<Object> objects = PageHelper.startPage(sysPermissionPage.getPage(), sysPermissionPage.getRows());
        List<SysPermission> sysPermissionList = sysPermissionMapper.findByPage(sysPermissionPage);
        PaginationData data = new PaginationData(sysPermissionList, objects.getTotal());
        return data;
    }

    /**
     * 批量逻辑删除权限
     *
     * @param ids
     */
    @Override
    @ServiceLog(doAction = "批量逻辑删除权限")
    @Transactional(rollbackFor = Exception.class)
    public void deletePermissionBranch(String[] ids) {
        sysPermissionMapper.deletePermissionBranch(ids);
        sysPermissionFilesMapper.deletePermissionBranch(ids);
        sysPermissionMenuMapper.deletePermissionBranch(ids);
        sysRolePermissionMapper.deletePermissionBranch(ids);
        sysPermissionResourcesMapper.deletePermissionBranch(ids);
        logger.info("[权限] 批量逻辑删除权限信息成功！，sysPermissionIds:{}", ids.toString());
    }

    /**
     * 为权限添加角色
     *
     * @param sysPermissionRolesAdd
     */
    @Override
    @ServiceLog(doAction = "为权限添加角色")
    @Transactional(rollbackFor = Exception.class)
    public void addRoleToPermission(SysPermissionRolesAdd sysPermissionRolesAdd,User user) {
        //清除权限已经具有的角色
        sysRolePermissionMapper.deleteByPermissionId(sysPermissionRolesAdd.getPermissionId());
        if (sysPermissionRolesAdd.getRoleIds().length == 0) {
            return;
        }
        Boolean isDelete=sysPermissionRolesAdd.getRoleIds().length==0?Boolean.TRUE:Boolean.FALSE;
        if (isDelete) {
            logger.info("[权限授权角色] 删除该权限下角色信息成功！permissionId:{}",sysPermissionRolesAdd.getPermissionId());
            return;
        }

        List<TbSysRolePermission> list = new ArrayList<TbSysRolePermission>();
        for (String roleId : sysPermissionRolesAdd.getRoleIds()) {
            //创建权限角色实体类
            TbSysRolePermission tbSysRolePermission = new TbSysRolePermission();
            tbSysRolePermission.setId(UUID.randomUUID().toString());
            tbSysRolePermission.setCreateTime(new Date());
            tbSysRolePermission.setCreator(user.getId());
            tbSysRolePermission.setPermissionId(sysPermissionRolesAdd.getPermissionId());
            tbSysRolePermission.setRoleId(roleId);
            tbSysRolePermission.setStatus(SysStatusEnums.EFFECTIVE.getCode());
            list.add(tbSysRolePermission);
        }
        //批量添加权限角色信息
        sysRolePermissionMapper.addRoleToPermissionBranch(list);
        logger.info("[权限] 批量为权限添加角色信息成功！，sysPermissionId:{},roleIds:{}", sysPermissionRolesAdd.getPermissionId()
                , sysPermissionRolesAdd.getRoleIds().toString());
    }

    /**
     * 条件分页获取未拥有的角色信息
     *
     * @param sysPermissionRolePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "条件分页获取未拥有的角色信息")
    public PaginationData findRoleOfPermission(SysPermissionRolePage sysPermissionRolePage) {
        List<SysRole> roleOfPermissionList =
                sysRolePermissionMapper.findRoleOfPermission(sysPermissionRolePage.getPermissionId());
        //条件分页获取未拥有的角色信息
        Page<Object> objects = PageHelper.startPage(sysPermissionRolePage.getPage(), sysPermissionRolePage.getRows());
        List<SysRole> otherRoleList = sysRolePermissionMapper.findRoleByPermissionPage(sysPermissionRolePage);
        otherRoleList.addAll(roleOfPermissionList);
        SysPermissionRoleVO sysPermissionRoleVO = new SysPermissionRoleVO(roleOfPermissionList, otherRoleList);
        PaginationData data = new PaginationData(sysPermissionRoleVO, objects.getTotal());
        return data;
    }

    /**
     * 获取除权限已经具有的文件组信息及条件分页获取未拥有的文件组信息
     *
     * @param sysPermissionFileGroupPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取除权限已经具有的文件组信息及条件分页获取未拥有的文件组信息")
    public PaginationData findFileGroupOfPermission(SysPermissionFileGroupPage sysPermissionFileGroupPage) {
        //获取权限已经具有的文件组信息
        List<SysFileGroup> sysFileGroupOfPermissionList =
                sysPermissionFilesMapper.findFileGroupOfPermission(sysPermissionFileGroupPage.getPermissionId());
        //条件分页获取未拥有的文件组信息
        Page<Object> objects = PageHelper.startPage(sysPermissionFileGroupPage.getPage(), sysPermissionFileGroupPage.getRows());
        List<SysFileGroup> otherFileGroupList = sysPermissionFilesMapper.findFileGroupByPermissionPage(sysPermissionFileGroupPage);
        otherFileGroupList.addAll(sysFileGroupOfPermissionList);
        SysPermissionFileGroupVO sysPermissionFileGroupVO = new
                SysPermissionFileGroupVO(sysFileGroupOfPermissionList, otherFileGroupList);
        PaginationData data = new PaginationData(sysPermissionFileGroupVO, objects.getTotal());
        return data;
    }

    /**
     * 为权限添加文件组
     *
     * @param sysPermissionFileGroupAdd
     */
    @Override
    @ServiceLog(doAction = "为权限添加文件组")
    @Transactional(rollbackFor = Exception.class)
    public void addFileGroupToPermission(SysPermissionFileGroupAdd sysPermissionFileGroupAdd, User user) {
        //逻辑删除原有权限对应文件组
        sysPermissionFilesMapper.deleteByPermissionId(sysPermissionFileGroupAdd.getPermissionId());

        Boolean isDelete=sysPermissionFileGroupAdd.getFileGroupIds().length==0?Boolean.TRUE:Boolean.FALSE;
        if (isDelete) {
            logger.info("[权限授权文件组] 删除该权限下文件组信息成功！permissionId:{}",sysPermissionFileGroupAdd.getPermissionId());
            return;
        }

        List<TbSysPermissionFiles> list = new ArrayList<TbSysPermissionFiles>();
        for (String fileGroupId : sysPermissionFileGroupAdd.getFileGroupIds()) {
            //封装权限文件组实体
            TbSysPermissionFiles tbSysPermissionFiles = new TbSysPermissionFiles();
            tbSysPermissionFiles.setId(UUID.randomUUID().toString());
            tbSysPermissionFiles.setCreateTime(new Date());
            tbSysPermissionFiles.setCreator(user.getId());
            tbSysPermissionFiles.setFileGroupId(fileGroupId);
            tbSysPermissionFiles.setPermissionId(sysPermissionFileGroupAdd.getPermissionId());
            tbSysPermissionFiles.setStatus(SysStatusEnums.EFFECTIVE.getCode());
            list.add(tbSysPermissionFiles);
        }
        //为权限添加新的文件组
        sysPermissionFilesMapper.addFileGroupToPermission(list);
        logger.info("[权限] 批量为权限添加文件组信息成功！，sysPermissionId:{},roleIds:{}",
                sysPermissionFileGroupAdd.getPermissionId(), sysPermissionFileGroupAdd.getFileGroupIds().toString());
    }

    /**
     * 获取权限已经具有的菜单信息及条件分页查询未拥有的菜单信息
     *
     * @param sysPermissionMenuPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取权限已经具有的菜单信息及条件分页查询未拥有的菜单信息")
    public PaginationData findMenuOfPermission(SysPermissionMenuPage sysPermissionMenuPage) {
        List<SysMenu> sysMenuOfPermissionList =
                sysPermissionMenuMapper.findMenuOfPermission(sysPermissionMenuPage.getPermissionId());
        //条件分页查询未拥有的菜单信息
        Page<Object> objects = PageHelper.startPage(sysPermissionMenuPage.getPage(), sysPermissionMenuPage.getRows());
        List<SysMenu> otherMenuList = sysPermissionMenuMapper.findMenuByPermissionPage(sysPermissionMenuPage);
        otherMenuList.addAll(sysMenuOfPermissionList);
        SysPermissionMenuVO sysPermissionMenuVO = new SysPermissionMenuVO(sysMenuOfPermissionList, otherMenuList);
        PaginationData data = new PaginationData(sysPermissionMenuVO, objects.getTotal());
        return data;
    }

    /**
     * 获取权限已经具有的功能信息及条件分页获取未拥有的功能信息
     *
     * @param sysPermissionResourcePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取权限已经具有的功能信息及条件分页获取未拥有的功能信息")
    public PaginationData findResourcesOfPermission(SysPermissionResourcePage sysPermissionResourcePage) {
        List<SysResources> sysResourcesOfPermissionList =
                sysPermissionResourcesMapper.findResourcesOfPermission(sysPermissionResourcePage.getPermissionId());
        //条件分页获取未拥有的功能信息
        Page<Object> objects = PageHelper.startPage(sysPermissionResourcePage.getPage(), sysPermissionResourcePage.getRows());
        List<SysResources> otherResourceList =
                sysPermissionResourcesMapper.findResourceByPermissionPage(sysPermissionResourcePage);
        otherResourceList.addAll(sysResourcesOfPermissionList);
        SysPermissionResourcesVO sysPermissionResourcesVO = new
                SysPermissionResourcesVO(sysResourcesOfPermissionList, otherResourceList);
        PaginationData data = new PaginationData(sysPermissionResourcesVO, objects.getTotal());
        return data;
    }

    /**
     * 校验权限明显名称是否已经存在
     *
     * @param permissionName
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验权限明显名称是否已经存在")
    public String checkPermissionName(String permissionName) {
        List<TbSysPermission> tbSysPermissions = checkName(permissionName);
        if (tbSysPermissions != null && tbSysPermissions.size() > 0) {
            return SysReturnMessageEnum.FAIL.getMessage();
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

    /**
     * 为权限添加菜单
     *
     * @param sysPermissionMenuAdd
     */
    @Override
    @ServiceLog(doAction = "为权限添加菜单")
    @Transactional(rollbackFor = Exception.class)
    public void addMenuToPermission(SysPermissionMenuAdd sysPermissionMenuAdd,User user) {
        //逻辑删除原权限菜单数据
        sysPermissionMenuMapper.deleteByPermissionId(sysPermissionMenuAdd.getPermissionId());

        Boolean isDelete=sysPermissionMenuAdd.getMenuIds().length==0?Boolean.TRUE:Boolean.FALSE;
        if (isDelete) {
            logger.info("[权限授权菜单] 删除该权限下菜单信息成功！permissionId:{}",sysPermissionMenuAdd.getPermissionId());
            return;
        }

        List<TbSysPermissionMenu> tbSysPermissionMenuList = new ArrayList<TbSysPermissionMenu>();
        for (String menuId : sysPermissionMenuAdd.getMenuIds()) {
            //生成权限菜单对象
            TbSysPermissionMenu tbSysPermissionMenu = new TbSysPermissionMenu();
            tbSysPermissionMenu.setId(UUID.randomUUID().toString());
            tbSysPermissionMenu.setCreateTime(new Date());
            tbSysPermissionMenu.setCreator(user.getId());
            tbSysPermissionMenu.setMenuId(menuId);
            tbSysPermissionMenu.setPermissionId(sysPermissionMenuAdd.getPermissionId());
            tbSysPermissionMenu.setStatus(SysStatusEnums.EFFECTIVE.getCode());
            tbSysPermissionMenuList.add(tbSysPermissionMenu);
        }
        //添加新权限菜单数据
        sysPermissionMenuMapper.addMenuToPermission(tbSysPermissionMenuList);
        logger.info("[权限] 权限添加菜单权限成功,permissionId:{},menuIds:{}",
                sysPermissionMenuAdd.getPermissionId(), sysPermissionMenuAdd.getMenuIds());
    }

    /**
     * 为权限添加页面功能
     *
     * @param sysPermissionMenuAdd
     */
    @Override
    @ServiceLog(doAction = "为权限添加页面功能")
    public void addResourceToPermission(SysPermissionResourceAdd sysPermissionMenuAdd,User user) {
        //逻辑删除原有权限页面功能数据
        sysPermissionResourcesMapper.deleteByPermissionId(sysPermissionMenuAdd.getPermissionId());

        Boolean isDelete=sysPermissionMenuAdd.getResourcesIds().length==0?Boolean.TRUE:Boolean.FALSE;
        if (isDelete) {
            logger.info("[权限授权页面功能] 删除该权限下页面功能信息成功！permissionId:{}",sysPermissionMenuAdd.getPermissionId());
            return;
        }

        List<TbSysPermissionResources> tbSysPermissionResourcesList = new ArrayList<TbSysPermissionResources>();
        for (String resourceId : sysPermissionMenuAdd.getResourcesIds()) {
            //生产权限页面菜单对象
            TbSysPermissionResources tbSysPermissionResources = new TbSysPermissionResources();
            tbSysPermissionResources.setId(UUID.randomUUID().toString());
            tbSysPermissionResources.setCreateTime(new Date());
            tbSysPermissionResources.setCreator(user.getId());
            tbSysPermissionResources.setPermissionId(sysPermissionMenuAdd.getPermissionId());
            tbSysPermissionResources.setResourcesId(resourceId);
            tbSysPermissionResources.setStatus(SysStatusEnums.EFFECTIVE.getCode());
            tbSysPermissionResourcesList.add(tbSysPermissionResources);
        }
        //添加新权限页面功能数据
        sysPermissionResourcesMapper.addResourceToPermission(tbSysPermissionResourcesList);
        logger.info("[权限] 权限添加菜单及页面功能权限成功,permissionId:{},resourcesIds:{}",
                sysPermissionMenuAdd.getPermissionId(), sysPermissionMenuAdd.getResourcesIds());
    }
}
