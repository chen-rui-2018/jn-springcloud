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
import com.jn.system.vo.SysPermissionFileGroupVO;
import com.jn.system.vo.SysPermissionMenuVO;
import com.jn.system.vo.SysPermissionResourcesVO;
import com.jn.system.vo.SysPermissionRoleVO;
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
    @Transactional(rollbackFor = Exception.class)
    public Result addPermission(SysPermissionAdd sysPermissionAdd) {
        //判断权限名称是否已经存在
        TbSysPermissionCriteria tbSysPermissionCriteria = new TbSysPermissionCriteria();
        TbSysPermissionCriteria.Criteria criteria = tbSysPermissionCriteria.createCriteria();
        criteria.andPermissionNameEqualTo(sysPermissionAdd.getPermissionName());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());
        List<TbSysPermission> tbSysPermissions = tbSysPermissionMapper.selectByExample(tbSysPermissionCriteria);
        if (tbSysPermissions != null && tbSysPermissions.size() > 0) {
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
        logger.info("[权限]新增权限信息成功！，sysPermissionId:{}", tbSysPermission.getId());
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
        logger.info("[权限]修改权限信息成功！，sysPermissionId:{}", sysPermission.getId());
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
        logger.info("[权限]批量逻辑删除权限信息成功！，sysPermissionIds:{}", ids.toString());
    }

    /**
     * 为权限添加角色
     *
     * @param sysPermissionRolesAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRoleToPermission(SysPermissionRolesAdd sysPermissionRolesAdd) {
        //清除权限已经具有的角色
        sysRolePermissionMapper.deleteByPermissionId(sysPermissionRolesAdd.getPermissionId());
        if (sysPermissionRolesAdd.getRoleIds().length == 0) {
            return;
        }
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
        //批量添加权限角色信息
        sysRolePermissionMapper.addRoleToPermissionBranch(list);
        logger.info("[权限]批量为权限添加角色信息成功！，sysPermissionId:{},roleIds:{}", sysPermissionRolesAdd.getPermissionId()
                , sysPermissionRolesAdd.getRoleIds().toString());
    }

    /**
     * 条件分页获取未拥有的角色信息
     *
     * @param sysPermissionRolePage
     * @return
     */
    @Override
    public Result findRoleOfPermission(SysPermissionRolePage sysPermissionRolePage) {
        List<SysRole> roleOfPermissionList =
                sysRolePermissionMapper.findRoleOfPermission(sysPermissionRolePage.getPermissionId());
        //条件分页获取未拥有的角色信息
        Page<Object> objects = PageHelper.startPage(sysPermissionRolePage.getPage(), sysPermissionRolePage.getRows());
        List<SysRole> otherRoleList = sysRolePermissionMapper.findRoleByPermissionPage(sysPermissionRolePage);
        otherRoleList.addAll(roleOfPermissionList);
        SysPermissionRoleVO sysPermissionRoleVO = new SysPermissionRoleVO(roleOfPermissionList, otherRoleList);
        PaginationData data = new PaginationData(sysPermissionRoleVO, objects.getTotal());
        return new Result(data);
    }

    /**
     * 获取除权限已经具有的文件组信息及条件分页获取未拥有的文件组信息
     *
     * @param sysPermissionFileGroupPage
     * @return
     */
    @Override
    public Result findFileGroupOfPermission(SysPermissionFileGroupPage sysPermissionFileGroupPage) {
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
        return new Result(data);
    }

    /**
     * 为权限添加文件组
     *
     * @param sysPermissionFileGroupAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addFileGroupToPermission(SysPermissionFileGroupAdd sysPermissionFileGroupAdd) {
        //逻辑删除原有权限对应文件组
        sysPermissionFilesMapper.deleteByPermissionId(sysPermissionFileGroupAdd.getPermissionId());
        if (sysPermissionFileGroupAdd.getFileGroupIds().length == 0) {
            return;
        }
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
        //为权限添加新的文件组
        sysPermissionFilesMapper.addFileGroupToPermission(list);
        logger.info("[权限]批量为权限添加文件组信息成功！，sysPermissionId:{},roleIds:{}",
                sysPermissionFileGroupAdd.getPermissionId(), sysPermissionFileGroupAdd.getFileGroupIds().toString());
    }

    /**
     * 获取权限已经具有的菜单信息及条件分页查询未拥有的菜单信息
     *
     * @param sysPermissionMenuPage
     * @return
     */
    @Override
    public Result findMenuOfPermission(SysPermissionMenuPage sysPermissionMenuPage) {
        List<SysMenu> sysMenuOfPermissionList =
                sysPermissionMenuMapper.findMenuOfPermission(sysPermissionMenuPage.getPermissionId());
        //条件分页查询未拥有的菜单信息
        Page<Object> objects = PageHelper.startPage(sysPermissionMenuPage.getPage(), sysPermissionMenuPage.getRows());
        List<SysMenu> otherMenuList = sysPermissionMenuMapper.findMenuByPermissionPage(sysPermissionMenuPage);
        otherMenuList.addAll(sysMenuOfPermissionList);
        SysPermissionMenuVO sysPermissionMenuVO = new SysPermissionMenuVO(sysMenuOfPermissionList, otherMenuList);
        PaginationData data = new PaginationData(sysPermissionMenuVO, objects.getTotal());
        return new Result(data);
    }

    /**
     * 获取权限已经具有的功能信息及条件分页获取未拥有的功能信息
     *
     * @param sysPermissionResourcePage
     * @return
     */
    @Override
    public Result findResourcesOfPermission(SysPermissionResourcePage sysPermissionResourcePage) {
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
        return new Result(data);
    }

    /**
     * 校验权限明显名称是否已经存在
     *
     * @param permissionName
     * @return
     */
    @Override
    public Result checkPermissionName(String permissionName) {
        TbSysPermissionCriteria tbSysPermissionCriteria = new TbSysPermissionCriteria();
        TbSysPermissionCriteria.Criteria criteria = tbSysPermissionCriteria.createCriteria();
        criteria.andPermissionNameEqualTo(permissionName);
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());
        List<TbSysPermission> tbSysPermissions = tbSysPermissionMapper.selectByExample(tbSysPermissionCriteria);
        if (tbSysPermissions != null && tbSysPermissions.size() > 0) {
            return new Result("false");
        }
        return new Result("success");
    }

    /**
     * 为权限添加菜单
     *
     * @param sysPermissionMenuAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMenuToPermission(SysPermissionMenuAdd sysPermissionMenuAdd) {
        //逻辑删除原权限菜单数据
        sysPermissionMenuMapper.deleteByPermissionId(sysPermissionMenuAdd.getPermissionId());
        if (sysPermissionMenuAdd.getMenuIds().length <= 0) {
            return;
        }
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<TbSysPermissionMenu> tbSysPermissionMenuList = new ArrayList<TbSysPermissionMenu>();
        for (String menuId : sysPermissionMenuAdd.getMenuIds()) {
            //生成权限菜单对象
            TbSysPermissionMenu tbSysPermissionMenu = new TbSysPermissionMenu();
            tbSysPermissionMenu.setId(UUID.randomUUID().toString());
            tbSysPermissionMenu.setCreateTime(new Date());
            tbSysPermissionMenu.setCreator(user.getId());
            tbSysPermissionMenu.setMenuId(menuId);
            tbSysPermissionMenu.setPermissionId(sysPermissionMenuAdd.getPermissionId());
            tbSysPermissionMenu.setStatus(SysStatusEnums.EFFECTIVE.getKey());
            tbSysPermissionMenuList.add(tbSysPermissionMenu);
        }
        //添加新权限菜单数据
        sysPermissionMenuMapper.addMenuToPermission(tbSysPermissionMenuList);
        logger.info("[权限]权限添加菜单权限成功,permissionId:{},menuIds:{}",
                sysPermissionMenuAdd.getPermissionId(), sysPermissionMenuAdd.getMenuIds());
    }

    /**
     * 为权限添加页面功能
     *
     * @param sysPermissionMenuAdd
     */
    @Override
    public void addResounceToPermission(SysPermissionResourceAdd sysPermissionMenuAdd) {
        //逻辑删除原有权限页面功能数据
        sysPermissionResourcesMapper.deleteByPermissionId(sysPermissionMenuAdd.getPermissionId());
        if (sysPermissionMenuAdd.getResourcesIds().length <= 0){
            return;
        }
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<TbSysPermissionResources> tbSysPermissionResourcesList = new ArrayList<TbSysPermissionResources>();
        for (String resourceId : sysPermissionMenuAdd.getResourcesIds()) {
            //生产权限页面菜单对象
            TbSysPermissionResources tbSysPermissionResources = new TbSysPermissionResources();
            tbSysPermissionResources.setId(UUID.randomUUID().toString());
            tbSysPermissionResources.setCreateTime(new Date());
            tbSysPermissionResources.setCreator(user.getId());
            tbSysPermissionResources.setPermissionId(sysPermissionMenuAdd.getPermissionId());
            tbSysPermissionResources.setResourcesId(resourceId);
            tbSysPermissionResources.setStatus(SysStatusEnums.EFFECTIVE.getKey());
            tbSysPermissionResourcesList.add(tbSysPermissionResources);
        }
        //添加新权限页面功能数据
        sysPermissionResourcesMapper.addResourceToPermission(tbSysPermissionResourcesList);
        logger.info("[权限]权限添加菜单及页面功能权限成功,permissionId:{},resourcesIds:{}",
                sysPermissionMenuAdd.getPermissionId(), sysPermissionMenuAdd.getResourcesIds());
    }
}
