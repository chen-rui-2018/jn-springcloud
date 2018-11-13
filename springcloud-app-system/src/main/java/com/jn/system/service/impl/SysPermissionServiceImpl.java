package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.*;
import com.jn.system.entity.*;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysPermissionService;
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

    /**
     * 添加权限
     *
     * @param sysPermissionAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addPermission(SysPermissionAdd sysPermissionAdd) {
        //判断权限名称是否已经存在
        TbSysPermissionCriteria tbSysPermissionCriteria = new TbSysPermissionCriteria();
        TbSysPermissionCriteria.Criteria criteria = tbSysPermissionCriteria.createCriteria();
        criteria.andPermissionNameEqualTo(sysPermissionAdd.getPermissionName());
        List<TbSysPermission> tbSysPermissions = tbSysPermissionMapper.selectByExample(tbSysPermissionCriteria);
        if (tbSysPermissions != null && tbSysPermissions.size() > 0){
            return new Result("添加失败,权限名称已存在");
        }
        TbSysPermission tbSysPermission = new TbSysPermission();
        tbSysPermission.setId(UUID.randomUUID().toString());
        tbSysPermission.setCreateTime(new Date());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbSysPermission.setCreator(user.getId());
        tbSysPermission.setPermissionName(sysPermissionAdd.getPermissionName());
        tbSysPermission.setStatus(sysPermissionAdd.getStatus());
        tbSysPermissionMapper.insertSelective(tbSysPermission);
        logger.info("[权限]新增权限信息成功！，sysPermissionId:{}",tbSysPermission.getId());
        return new Result("添加成功");
    }

    /**
     * 修改权限
     *
     * @param sysPermission
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePermission(SysPermission sysPermission) {
        sysPermissionMapper.updatePermission(sysPermission);
        logger.info("[权限]修改权限信息成功！，sysPermissionId:{}",sysPermission.getId());
    }

    /**
     * 根据主键获取权限信息
     *
     * @param id
     * @return
     */
    @Override
    public Result selectByPrimaryKey(String id) {
        TbSysPermission tbSysPermission = tbSysPermissionMapper.selectByPrimaryKey(id);
        SysPermission sysPermission = new SysPermission();
        if (tbSysPermission != null) {
            BeanUtils.copyProperties(tbSysPermission, sysPermission);
        }
        return new Result(sysPermission);
    }

    /**
     * 条件分页查询
     *
     * @param sysPermissionPage
     * @return
     */
    @Override
    public Result findByPage(SysPermissionPage sysPermissionPage) {
        Page<Object> objects = PageHelper.startPage(sysPermissionPage.getPage(), sysPermissionPage.getRows());
        List<SysPermission> sysPermissionList = sysPermissionMapper.findByPage(sysPermissionPage);
        PaginationData data = new PaginationData(sysPermissionList, objects.getTotal());
        return new Result(data);
    }

    /**
     * 批量逻辑删除权限
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePermissionBranch(String[] ids) {
        sysPermissionMapper.deletePermissionBranch(ids);
        sysPermissionFilesMapper.deletePermissionBranch(ids);
        sysPermissionMenuMapper.deletePermissionBranch(ids);
        sysRolePermissionMapper.deletePermissionBranch(ids);
        sysPermissionResourcesMapper.deletePermissionBranch(ids);
        logger.info("[权限]批量逻辑删除权限信息成功！，sysPermissionIds:{}",ids.toString());
    }

    /**
     * 为权限添加角色
     *
     * @param sysPermissionRolesAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRoleToPermission(SysPermissionRolesAdd sysPermissionRolesAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<TbSysRolePermission> list = new ArrayList<TbSysRolePermission>();
        for (String roleId : sysPermissionRolesAdd.getRoleIds()) {
            //创建权限角色实体类
            TbSysRolePermission tbSysRolePermission = new TbSysRolePermission();
            tbSysRolePermission.setId(UUID.randomUUID().toString());
            tbSysRolePermission.setCreateTime(new Date());
            tbSysRolePermission.setCreator(user.getId());
            tbSysRolePermission.setPermissionId(sysPermissionRolesAdd.getPermissionId());
            tbSysRolePermission.setRoleId(roleId);
            tbSysRolePermission.setStatus(SysStatusEnums.EFFECTIVE.getKey());
            list.add(tbSysRolePermission);
        }
        //清除权限已经具有的角色
        sysRolePermissionMapper.deleteByPermissionId(sysPermissionRolesAdd.getPermissionId());
        //批量添加权限角色信息
        sysRolePermissionMapper.addRoleToPermissionBranch(list);
        logger.info("[权限]批量为权限添加角色信息成功！，sysPermissionId:{},roleIds:{}",sysPermissionRolesAdd.getPermissionId()
                ,sysPermissionRolesAdd.getRoleIds().toString());
    }

    /**
     * 根据权限id获取权限已经具有的角色信息
     *
     * @param id
     * @return
     */
    @Override
    public Result findRoleOfPermission(String id) {
        List<SysRole> roleList = sysRolePermissionMapper.findRoleOfPermission(id);
        return new Result(roleList);
    }

    /**
     * 根据权限id获取除权限已经具有的角色之外的角色信息
     *
     * @param id
     * @return
     */
    @Override
    public Result findOtherRoles(String id) {
        List<SysRole> roleList = sysRolePermissionMapper.findOtherRoles(id);
        return new Result(roleList);
    }

    /**
     * 根据权限id获取除权限已经具有的文件组信息
     *
     * @param id
     * @return
     */
    @Override
    public Result findFileGroupOfPermission(String id) {
        List<SysFileGroup> sysFileGroupList = sysPermissionFilesMapper.findFileGroupOfPermission(id);
        return new Result(sysFileGroupList);
    }

    /**
     * 根据权限id获取除权限已经具有的文件组之外的文件组信息
     *
     * @param id
     * @return
     */
    @Override
    public Result findOtherFileGroups(String id) {
        List<SysFileGroup> sysFileGroupList = sysPermissionFilesMapper.findOtherFileGroups(id);
        return new Result(sysFileGroupList);
    }

    /**
     * 为权限添加文件组
     *
     * @param sysPermissionFileGroupAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addFileGroupToPermission(SysPermissionFileGroupAdd sysPermissionFileGroupAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<TbSysPermissionFiles> list = new ArrayList<TbSysPermissionFiles>();
        for (String fileGroupId : sysPermissionFileGroupAdd.getFileGroupIds()) {
            //封装权限文件组实体
            TbSysPermissionFiles tbSysPermissionFiles = new TbSysPermissionFiles();
            tbSysPermissionFiles.setId(UUID.randomUUID().toString());
            tbSysPermissionFiles.setCreateTime(new Date());
            tbSysPermissionFiles.setCreator(user.getId());
            tbSysPermissionFiles.setFileGroupId(fileGroupId);
            tbSysPermissionFiles.setPermissionId(sysPermissionFileGroupAdd.getPermissionId());
            tbSysPermissionFiles.setStatus(SysStatusEnums.EFFECTIVE.getKey());
            list.add(tbSysPermissionFiles);
        }
        //逻辑删除原有权限对应文件组
        sysPermissionFilesMapper.deleteByPermissionId(sysPermissionFileGroupAdd.getPermissionId());
        //为权限添加新的文件组
        sysPermissionFilesMapper.addFileGroupToPermission(list);
        logger.info("[权限]批量为权限添加文件组信息成功！，sysPermissionId:{},roleIds:{}",
                sysPermissionFileGroupAdd.getPermissionId(),sysPermissionFileGroupAdd.getFileGroupIds().toString());
    }

    /**
     * 根据权限id获取权限已经具有的菜单
     *
     * @param id
     * @return
     */
    @Override
    public Result findMenuOfPermission(String id) {
        List<SysMenu> sysMenuList = sysPermissionMenuMapper.findMenuOfPermission(id);
        return new Result(sysMenuList);
    }

    /**
     * 根据权限id获取权限已经具有的菜单之外的其他菜单
     *
     * @param id
     * @return
     */
    @Override
    public Result findOtherMenu(String id) {
        List<SysMenu> sysMenuList = sysPermissionMenuMapper.findOtherMenu(id);
        return new Result(sysMenuList);
    }

    /**
     * 根据权限id获取权限已经具有的功能信息
     *
     * @param id
     * @return
     */
    @Override
    public Result findResourcesOfPermission(String id) {
        List<SysResources> sysResourcesList = sysPermissionResourcesMapper.findResourcesOfPermission(id);
        return new Result(sysResourcesList);
    }

    /**
     * 根据权限id获取权限已经具有的页面功能之外的页面功能
     *
     * @param permissionId
     * @return
     */
    @Override
    public Result findOtherResources(String permissionId) {
        List<SysResources> sysResourcesList = sysPermissionResourcesMapper.findOtherResources(permissionId);
        return new Result(sysResourcesList);
    }

    /**
     * 为权限添加菜单及页面功能
     *
     * @param sysPermissionMenuRecourcesAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMenuAndResourceToPermission(SysPermissionMenuRecourcesAdd sysPermissionMenuRecourcesAdd) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<TbSysPermissionMenu> tbSysPermissionMenuList = new ArrayList<TbSysPermissionMenu>();
        List<TbSysPermissionResources> tbSysPermissionResourcesList = new ArrayList<TbSysPermissionResources>();
        for (String menuId : sysPermissionMenuRecourcesAdd.getMenuIds()) {
            //生成权限菜单对象
            TbSysPermissionMenu tbSysPermissionMenu = new TbSysPermissionMenu();
            tbSysPermissionMenu.setId(UUID.randomUUID().toString());
            tbSysPermissionMenu.setCreateTime(new Date());
            tbSysPermissionMenu.setCreator(user.getId());
            tbSysPermissionMenu.setMenuId(menuId);
            tbSysPermissionMenu.setPermissionId(sysPermissionMenuRecourcesAdd.getPermissionId());
            tbSysPermissionMenu.setStatus(SysStatusEnums.EFFECTIVE.getKey());
            tbSysPermissionMenuList.add(tbSysPermissionMenu);
        }
        for (String resourceId : sysPermissionMenuRecourcesAdd.getResourcesIds()) {
            //生产权限页面菜单对象
            TbSysPermissionResources tbSysPermissionResources = new TbSysPermissionResources();
            tbSysPermissionResources.setId(UUID.randomUUID().toString());
            tbSysPermissionResources.setCreateTime(new Date());
            tbSysPermissionResources.setCreator(user.getId());
            tbSysPermissionResources.setPermissionId(sysPermissionMenuRecourcesAdd.getPermissionId());
            tbSysPermissionResources.setResourcesId(resourceId);
            tbSysPermissionResources.setStatus(SysStatusEnums.EFFECTIVE.getKey());
            tbSysPermissionResourcesList.add(tbSysPermissionResources);
        }
        //逻辑删除原权限菜单数据
        sysPermissionMenuMapper.deleteByPermissionId(sysPermissionMenuRecourcesAdd.getPermissionId());
        //逻辑删除原有权限页面功能数据
        sysPermissionResourcesMapper.deleteByPermissionId(sysPermissionMenuRecourcesAdd.getPermissionId());
        //添加新权限菜单数据
        sysPermissionMenuMapper.addMenuToPermission(tbSysPermissionMenuList);
        //添加新权限页面功能数据
        sysPermissionResourcesMapper.addResourceToPermission(tbSysPermissionResourcesList);
        logger.info("[权限]权限添加菜单及页面功能权限成功,permissionId:{},menuIds:{},resourcesIds:{}",
                sysPermissionMenuRecourcesAdd.getPermissionId(),sysPermissionMenuRecourcesAdd.getMenuIds(),
                sysPermissionMenuRecourcesAdd.getResourcesIds());
    }

    /**
     * 校验权限明显名称是否已经存在
     * @param permissionName
     * @return
     */
    @Override
    public Result checkPermissionName(String permissionName) {
        TbSysPermissionCriteria tbSysPermissionCriteria = new TbSysPermissionCriteria();
        TbSysPermissionCriteria.Criteria criteria = tbSysPermissionCriteria.createCriteria();
        criteria.andPermissionNameEqualTo(permissionName);
        List<TbSysPermission> tbSysPermissions = tbSysPermissionMapper.selectByExample(tbSysPermissionCriteria);
        if (tbSysPermissions != null && tbSysPermissions.size() > 0){
            return new Result("false");
        }
        return new Result("success");
    }
}
