package com.jn.system.permission.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dept.service.impl.SysPostServiceImpl;
import com.jn.system.file.model.SysFileGroup;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.menu.dao.SysMenuMapper;
import com.jn.system.menu.dao.SysResourcesMapper;
import com.jn.system.menu.dao.TbSysMenuMapper;
import com.jn.system.menu.entity.TbSysMenu;
import com.jn.system.menu.service.SysMenuService;
import com.jn.system.menu.vo.SysMenuTreeVO;
import com.jn.system.model.User;
import com.jn.system.permission.dao.*;
import com.jn.system.permission.entity.*;
import com.jn.system.permission.model.*;
import com.jn.system.permission.service.SysPermissionService;
import com.jn.system.permission.vo.SysMenuResourcesVO;
import com.jn.system.permission.vo.SysPermissionFileGroupVO;
import com.jn.system.permission.vo.SysPermissionRoleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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

    private static Logger logger = LoggerFactory.getLogger(SysPostServiceImpl.class);

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
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysResourcesMapper sysResourcesMapper;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 添加权限
     *
     * @param tbSysPermission
     */
    @Override
    @ServiceLog(doAction = "添加权限")
    @Transactional(rollbackFor = Exception.class)
    public void addPermission(TbSysPermission tbSysPermission) {
        //判断权限名称是否已经存在
        List<TbSysPermission> tbSysPermissions = checkName(tbSysPermission.getPermissionName());
        if (tbSysPermissions != null && tbSysPermissions.size() > 0) {
            logger.warn("[权限] 新增权限信息失败，权限名称已存在！，permissionName:{}", tbSysPermission.getPermissionName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
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
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
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
        String permissionId = sysPermission.getId();
        String permissionName = sysPermission.getPermissionName();

        //1.判断修改信息是否存在
        TbSysPermission tbSysPermission = tbSysPermissionMapper.selectByPrimaryKey(permissionId);
        if (tbSysPermission == null || SysStatusEnums.DELETED.getCode().equals(tbSysPermission.getRecordStatus().toString())) {
            logger.warn("[权限] 权限信息修改失败,修改信息不存在,permissionId: {}", permissionId);
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }

        //2.如果修改了权限名称,判断权限名称是否已经存在
        if (!tbSysPermission.getPermissionName().equals(permissionName)) {
            List<TbSysPermission> tbSysPermissions = checkName(permissionName);
            if (tbSysPermissions != null && tbSysPermissions.size() > 0) {
                logger.warn("[权限] 修改权限信息失败，权限名称已存在！，permissionName:{}", permissionName);
                throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
            }

        }

        //3.更新权限信息
        TbSysPermission tbSysPermission1 = new TbSysPermission();
        BeanUtils.copyProperties(sysPermission, tbSysPermission1);
        tbSysPermissionMapper.updateByPrimaryKeySelective(tbSysPermission1);
        logger.info("[权限] 修改权限信息成功！，sysPermissionId:{}", permissionId);
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
        logger.info("[权限] 批量逻辑删除权限信息成功！，sysPermissionIds:{}", Arrays.toString(ids));
        sysPermissionFilesMapper.deletePermissionBranch(ids);
        logger.info("[权限] 批量逻辑删除权限关联文件组信息成功！，sysPermissionIds:{}", Arrays.toString(ids));
        sysPermissionMenuMapper.deletePermissionBranch(ids);
        logger.info("[权限] 批量逻辑删除权限关联菜单信息成功！，sysPermissionIds:{}", Arrays.toString(ids));
        sysRolePermissionMapper.deletePermissionBranch(ids);
        logger.info("[权限] 批量逻辑删除权限关联角色信息成功！，sysPermissionIds:{}", Arrays.toString(ids));
        sysPermissionResourcesMapper.deletePermissionBranch(ids);
        logger.info("[权限] 批量逻辑删除权限关联功能信息成功！，sysPermissionIds:{}", Arrays.toString(ids));
    }

    /**
     * 为权限添加角色
     *
     * @param sysPermissionRolesAdd
     */
    @Override
    @ServiceLog(doAction = "为权限添加角色")
    @Transactional(rollbackFor = Exception.class)
    public void addRoleToPermission(SysPermissionRolesAdd sysPermissionRolesAdd, User user) {
        //清除权限已经具有的角色
        sysRolePermissionMapper.deleteByPermissionId(sysPermissionRolesAdd.getPermissionId());
        logger.info("[权限授权角色] 删除该权限下角色信息成功！permissionId:{}", sysPermissionRolesAdd.getPermissionId());
        Boolean isDelete = sysPermissionRolesAdd.getRoleIds().length == 0 ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }

        List<TbSysRolePermission> list = new ArrayList<TbSysRolePermission>();
        for (String roleId : sysPermissionRolesAdd.getRoleIds()) {
            //创建权限角色实体类
            TbSysRolePermission tbSysRolePermission = new TbSysRolePermission();
            tbSysRolePermission.setId(UUID.randomUUID().toString());
            tbSysRolePermission.setCreatorAccount(user.getAccount());
            tbSysRolePermission.setPermissionId(sysPermissionRolesAdd.getPermissionId());
            tbSysRolePermission.setRoleId(roleId);
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            tbSysRolePermission.setRecordStatus(recordStatus);
            list.add(tbSysRolePermission);
        }
        //批量添加权限角色信息
        sysRolePermissionMapper.addRoleToPermissionBranch(list);
        logger.info("[权限] 批量为权限添加角色信息成功！，sysPermissionId:{},roleIds:{}",
                sysPermissionRolesAdd.getPermissionId()
                , Arrays.toString(sysPermissionRolesAdd.getRoleIds()));
    }

    /**
     * 获取权限已经具有的角色信息,且条件分页获取权限未拥有的角色信息
     *
     * @param sysPermissionRolePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取权限已经具有的角色信息,且条件分页获取权限未拥有的角色信息")
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
     * 获取除权限已经具有的文件组信息,且条件分页获取权限未拥有的文件组信息
     *
     * @param sysPermissionFileGroupPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取除权限已经具有的文件组信息,且条件分页获取权限未拥有的文件组信息")
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
        logger.info("[权限授权文件组] 删除该权限下文件组信息成功！permissionId:{}",
                sysPermissionFileGroupAdd.getPermissionId());
        Boolean isDelete = sysPermissionFileGroupAdd.getFileGroupIds().length == 0 ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }

        List<TbSysPermissionFiles> list = new ArrayList<TbSysPermissionFiles>();
        for (String fileGroupId : sysPermissionFileGroupAdd.getFileGroupIds()) {
            //封装权限文件组实体
            TbSysPermissionFiles tbSysPermissionFiles = new TbSysPermissionFiles();
            tbSysPermissionFiles.setId(UUID.randomUUID().toString());
            tbSysPermissionFiles.setCreatorAccount(user.getAccount());
            tbSysPermissionFiles.setFileGroupId(fileGroupId);
            tbSysPermissionFiles.setPermissionId(sysPermissionFileGroupAdd.getPermissionId());
            Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
            tbSysPermissionFiles.setRecordStatus(recordStatus);
            list.add(tbSysPermissionFiles);
        }
        //为权限添加新的文件组
        sysPermissionFilesMapper.addFileGroupToPermission(list);
        logger.info("[权限] 批量为权限添加文件组信息成功！，sysPermissionId:{},roleIds:{}",
                sysPermissionFileGroupAdd.getPermissionId(),
                Arrays.toString(sysPermissionFileGroupAdd.getFileGroupIds()));
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
     * 权限授权功能,获取菜单及功能信息
     *
     * @param permissionId
     * @return
     */
    @Override
    @ServiceLog(doAction = "权限授权功能,获取菜单及功能信息")
    public SysMenuResourcesVO getMenuAndResources(String permissionId) {
        SysMenuResourcesVO sysMenuResourcesVO = new SysMenuResourcesVO();
        List<String> menuAndResourcesIds = sysMenuResourcesVO.getMenuAndResourcesIds();
        //获取菜单树信息
        List<SysMenuTreeVO> menuTreeVOList = sysMenuService.selectMenuList(false);
        sysMenuResourcesVO.setSysMenuTreeVOList(menuTreeVOList);
        //获取权限已有的菜单id
        List<String> menuIds = sysPermissionMenuMapper.findMenuOfPermission(permissionId);
        menuAndResourcesIds.addAll(menuIds);
        //获取权限已有功能id
        List<String> resourcesIdS = sysPermissionResourcesMapper.findResourcesOfPermission(permissionId);
        menuAndResourcesIds.addAll(resourcesIdS);
        //返回信息
        return sysMenuResourcesVO;
    }

    /**
     * 权限授权菜单及功能信息
     *
     * @param sysPermissionMenuResourcesAdd
     * @param user
     */
    @Override
    @ServiceLog(doAction = "权限授权功能,获取菜单及功能信息")
    @Transactional(rollbackFor = Exception.class)
    public void addMenuAndResourcesToPermission(SysPermissionMenuResourcesAdd sysPermissionMenuResourcesAdd, User user) {
        String permissionId = sysPermissionMenuResourcesAdd.getPermissionId();
        //逻辑删除原权限菜单数据
        sysPermissionMenuMapper.deleteByPermissionId(permissionId);
        logger.info("[权限] 删除该权限关联菜单信息成功！permissionId:{}", permissionId);
        //逻辑删除原有权限页面功能数据
        sysPermissionResourcesMapper.deleteByPermissionId(permissionId);
        logger.info("[权限] 删除该权限关联功能信息成功！permissionId:{}", permissionId);
        Boolean isDelete = sysPermissionMenuResourcesAdd.getMenuAndResourcesIds().length == 0 ? Boolean.TRUE : Boolean.FALSE;
        if (isDelete) {
            return;
        }

        List<TbSysPermissionMenu> tbSysPermissionMenuList = new ArrayList<TbSysPermissionMenu>();
        List<TbSysPermissionResources> tbSysPermissionResourcesList = new ArrayList<TbSysPermissionResources>();

        for (String id : sysPermissionMenuResourcesAdd.getMenuAndResourcesIds()) {
            //判断id是菜单id还是权限id
            TbSysMenu tbSysMenu = tbSysMenuMapper.selectByPrimaryKey(id);
            //如果是菜单id,
            if (tbSysMenu != null) {
                //生成权限菜单对象
                createPermissionMenu(user, tbSysPermissionMenuList, id, permissionId);
            } else {
                //如果是权限id,生成权限页面菜单对象
                createPermissionResources(user, tbSysPermissionResourcesList, id, permissionId);
            }
        }
        if (tbSysPermissionMenuList != null && tbSysPermissionMenuList.size() > 0) {
            //添加新权限菜单数据
            sysPermissionMenuMapper.addMenuToPermission(tbSysPermissionMenuList);
            logger.info("[权限] 权限添加菜单信息成功！permissionId:{}", permissionId);
        }
        if (tbSysPermissionResourcesList != null && tbSysPermissionResourcesList.size() > 0) {
            //添加新权限页面功能数据
            sysPermissionResourcesMapper.addResourceToPermission(tbSysPermissionResourcesList);
            logger.info("[权限] 权限添加功能信息成功！permissionId:{}", permissionId);
        }
    }

    /**
     * 生成权限功能实体类
     *
     * @param user
     * @param tbSysPermissionResourcesList
     * @param id
     * @param permissionId
     */
    private void createPermissionResources(User user, List<TbSysPermissionResources> tbSysPermissionResourcesList,
                                           String id, String permissionId) {
        TbSysPermissionResources tbSysPermissionResources = new TbSysPermissionResources();
        tbSysPermissionResources.setId(UUID.randomUUID().toString());
        tbSysPermissionResources.setCreatorAccount(user.getAccount());
        tbSysPermissionResources.setPermissionId(permissionId);
        tbSysPermissionResources.setResourcesId(id);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysPermissionResources.setRecordStatus(recordStatus);
        tbSysPermissionResourcesList.add(tbSysPermissionResources);
    }

    /**
     * 生成权限菜单实体类
     *
     * @param user
     * @param tbSysPermissionMenuList
     * @param id
     * @param permissionId
     */
    private void createPermissionMenu(User user, List<TbSysPermissionMenu> tbSysPermissionMenuList,
                                      String id, String permissionId) {
        TbSysPermissionMenu tbSysPermissionMenu = new TbSysPermissionMenu();
        tbSysPermissionMenu.setId(UUID.randomUUID().toString());
        tbSysPermissionMenu.setCreatorAccount(user.getAccount());
        tbSysPermissionMenu.setMenuId(id);
        tbSysPermissionMenu.setPermissionId(permissionId);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysPermissionMenu.setRecordStatus(recordStatus);
        tbSysPermissionMenuList.add(tbSysPermissionMenu);
    }
}
