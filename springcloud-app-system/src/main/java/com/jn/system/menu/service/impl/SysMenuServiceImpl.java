package com.jn.system.menu.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysLevelEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.menu.dao.SysMenuMapper;
import com.jn.system.menu.dao.SysResourcesMapper;
import com.jn.system.menu.dao.TbSysMenuMapper;
import com.jn.system.menu.dao.TbSysResourcesMapper;
import com.jn.system.menu.entity.TbSysMenu;
import com.jn.system.menu.entity.TbSysMenuCriteria;
import com.jn.system.menu.enums.SysMenuEnums;
import com.jn.system.menu.enums.SysMenuExceptionEnums;
import com.jn.system.menu.model.*;
import com.jn.system.menu.service.SysMenuService;
import com.jn.system.menu.service.SysResourcesService;
import com.jn.system.menu.vo.SysMenuTreeVO;
import com.jn.system.model.User;
import com.jn.system.permission.dao.SysPermissionMenuMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 菜单serviceImpl
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 15:59
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    private static Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private TbSysMenuMapper tbSysMenuMapper;
    @Resource
    private TbSysResourcesMapper tbSysResourcesMapper;
    @Resource
    private SysResourcesMapper sysResourcesMapper;
    @Resource
    private SysPermissionMenuMapper sysPermissionMenuMapper;
    @Resource
    private SysResourcesService sysResourcesService;

    /**
     * 更新菜单信息
     *
     * @param sysMenu
     */
    @Override
    @ServiceLog(doAction = "更新菜单信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateSysMenuById(SysMenu sysMenu) {
        String menuId = sysMenu.getId();
        String parentId = sysMenu.getParentId();
        String menuName = sysMenu.getMenuName();
        //判断修改信息是否存在
        TbSysMenu tbSysMenu1 = tbSysMenuMapper.selectByPrimaryKey(menuId);
        if (tbSysMenu1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysMenu1.getStatus())) {
            logger.warn("[菜单] 菜单修改失败,修改信息不存在,menuId: {}", menuId);
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        //判断名称是否已经存在
        List<TbSysMenu> tbSysMenuList = checkMenusName(menuName, parentId);
        if (tbSysMenuList != null && tbSysMenuList.size() > 0) {
            logger.warn("[菜单] 菜单更新失败，菜单名称已存在！，menuName:{}", menuName);
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
        }
        //对信息进行修改操作
        sysMenu.setMenuUrl(StringUtils.trim(sysMenu.getMenuUrl()));
        TbSysMenu tbSysMenu = new TbSysMenu();
        BeanUtils.copyProperties(sysMenu, tbSysMenu);
        tbSysMenuMapper.updateByPrimaryKeySelective(tbSysMenu);
        logger.info("[菜单] 菜单更新成功，menuId:{}", menuId);
    }

    /**
     * 逻辑删除菜单
     *
     * @param menuId
     * @return
     */
    @Override
    @ServiceLog(doAction = "逻辑删除菜单")
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysMenuById(String menuId) {
        List<String> menuIds = new ArrayList<String>();
        List<String> resourcesIds = new ArrayList<String>();
        //判断菜单是否是目录菜单
        TbSysMenu tbSysMenu = tbSysMenuMapper.selectByPrimaryKey(menuId);
        Boolean flag = SysMenuEnums.MENU_ISDIR.getCode().equals(tbSysMenu.getIsDir())?Boolean.TRUE:Boolean.FALSE;
        if (flag){
            //查询菜单子菜单
            List<SysMenuTreeVO> childrenMenuList = sysMenuMapper.findMenuByParentId(menuId);
            if (childrenMenuList != null && childrenMenuList.size() > 0) {
                //递归获取子菜单下面的菜单信息
                findChildMenuList(resourcesIds,childrenMenuList);
                //获取子菜单id
                getChildMenuId(menuIds, childrenMenuList);
            }
        }else{
            //获取菜单具有的resourcesid
            getResourcesIdByMenuId(menuId, resourcesIds);
        }
        menuIds.add(menuId);
        logger.info("[菜单] 删除菜单及子菜单信息，menuIds:{}", menuIds.toString());
        sysMenuMapper.deleteBy(menuIds);
        logger.info("[菜单权限] 删除菜单及子菜单对应的权限信息，menuIds:{}", menuIds.toString());
        sysPermissionMenuMapper.deleteBy(menuIds);
        logger.info("[菜单功能] 删除菜单及子菜单的功能信息，删除功能对应权限信息,menuIds:{}", resourcesIds.toString());
        String [] ids = resourcesIds.toArray(new String[resourcesIds.size()]);
        if(ids.length > 0){
            sysResourcesService.deleteResourcesById(ids);
        }
        logger.info("[菜单] 菜单逻辑删除成功，menuIds:{}", menuIds.toString());
    }

    /**
     * 通过菜单id获取菜单具有的功能id
     * @param menuId
     * @param resourcesIds
     */
    private void getResourcesIdByMenuId(String menuId, List<String> resourcesIds) {
        List<SysResources> resourcesList = sysResourcesMapper.getResourcesByMenuId(menuId);
        for (SysResources sysResourcesOfPermission : resourcesList) {
            resourcesIds.add(sysResourcesOfPermission.getId());
        }
    }

    /**
     * 递归获取子部门id
     *
     * @param menuIds
     * @param childrenMenuList
     */
    private void getChildMenuId(List<String> menuIds, List<SysMenuTreeVO> childrenMenuList) {
        for (SysMenuTreeVO sysMenuTreeVO : childrenMenuList) {
            menuIds.add(sysMenuTreeVO.getId());
            if (sysMenuTreeVO.getChildren() != null) {
                getChildMenuId(menuIds, sysMenuTreeVO.getChildren());
            }
        }
    }

    /**
     * 递归查询菜单子菜单
     *
     * @param menuTreeVOList
     */
    public void findChildMenuList(List<String> resourcesIds,List<SysMenuTreeVO> menuTreeVOList) {
        for (SysMenuTreeVO sysMenuTreeVO : menuTreeVOList) {
            //判断菜单项是否是目录菜单,是再递归获取数据
            if (SysMenuEnums.MENU_ISDIR.getCode().equals(sysMenuTreeVO.getIsDir())) {
                //以菜单id作为父id,去获取菜单子集
                List<SysMenuTreeVO> childrenMenuList = sysMenuMapper.findMenuByParentId(sysMenuTreeVO.getId());
                sysMenuTreeVO.setChildren(childrenMenuList);
                if (childrenMenuList.size() == 0) {
                    sysMenuTreeVO.setChildren(null);
                    continue;
                } else {
                    findChildMenuList(resourcesIds,childrenMenuList);
                }
            }else{
                //不是目录菜单,采取菜单功能id
                getResourcesIdByMenuId(sysMenuTreeVO.getId(), resourcesIds);
            }
        }
    }

    /**
     * 查询所有菜单,返回树形结构
     *
     * @return
     */
    @Override
    @ServiceLog(doAction = "查询所有菜单,返回树形结构")
    public List<SysMenuTreeVO> selectMenuList() {
        //先查询等级为1的菜单信息
        List<SysMenuTreeVO> menuTreeVOList = sysMenuMapper.findMenuByLevelOne();
        getChildMenuAndResourcesList(menuTreeVOList);
        return menuTreeVOList;

    }

    /**
     * 递归查询菜单子菜单及菜单页面功能信息
     *
     * @param menuTreeVOList
     */
    public void getChildMenuAndResourcesList(List<SysMenuTreeVO> menuTreeVOList) {
        for (SysMenuTreeVO sysMenuTreeVO : menuTreeVOList) {
            //判断菜单项是否是目录菜单,是递归获取子菜单信息
            if (SysMenuEnums.MENU_ISDIR.getCode().equals(sysMenuTreeVO.getIsDir())) {
                sysMenuTreeVO.setIcon(SysMenuEnums.MENU_DIR_ICON.getCode());
                //以菜单id作为父id,去获取菜单子集
                List<SysMenuTreeVO> childrenMenuList = sysMenuMapper.findMenuByParentId(sysMenuTreeVO.getId());
                sysMenuTreeVO.setChildren(childrenMenuList);
                if (childrenMenuList.size() == 0) {
                    //设置子菜单为空
                    sysMenuTreeVO.setChildren(null);
                    continue;
                } else {
                    getChildMenuAndResourcesList(childrenMenuList);
                }
            } else {
                //不是目录菜单,查询菜单的页面功能信息
                sysMenuTreeVO.setIcon(SysMenuEnums.MENU_NOTDIR_ICON.getCode());
            }
        }
    }


    /**
     * 根据id获取菜单详情
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id获取菜单详情")
    public SysMenu selectMenuById(String id) {
        TbSysMenu tbSysMenu = tbSysMenuMapper.selectByPrimaryKey(id);
        SysMenu sysMenu = new SysMenu();
        if (tbSysMenu != null) {
            BeanUtils.copyProperties(tbSysMenu, sysMenu);
        }
        return sysMenu;
    }

    /**
     * 校验菜单名称是否存在
     *
     * @param sysMenuAdd
     */
    public void checkName(SysMenuAdd sysMenuAdd) {
        List<TbSysMenu> tbSysMenus = checkMenusName(sysMenuAdd.getMenuName(), sysMenuAdd.getParentId());
        if (tbSysMenus != null && tbSysMenus.size() > 0) {
            logger.warn("[菜单] 菜单名称已存在！，menuName:{}", sysMenuAdd.getMenuName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
    }

    /**
     * 校验菜单名称
     *
     * @param menuName
     * @param parentId
     * @return
     */
    private List<TbSysMenu> checkMenusName(String menuName, String parentId) {
        TbSysMenuCriteria tbSysMenuCriteria = new TbSysMenuCriteria();
        TbSysMenuCriteria.Criteria criteria = tbSysMenuCriteria.createCriteria();
        criteria.andStatusEqualTo(SysStatusEnums.EFFECTIVE.getCode());
        criteria.andParentIdEqualTo(parentId);
        criteria.andMenuNameEqualTo(menuName);
        return tbSysMenuMapper.selectByExample(tbSysMenuCriteria);
    }

    /**
     * 菜单添加目录菜单
     *
     * @param sysMenuAdd
     */
    @Override
    @ServiceLog(doAction = "菜单添加目录菜单")
    @Transactional(rollbackFor = Exception.class)
    public void addMenuDir(SysMenuAdd sysMenuAdd, User user) {
        //校验在该等级中菜单名称是否已经存在
        checkName(sysMenuAdd);
        TbSysMenu tbSysMenu = new TbSysMenu();
        //设置菜单等级
        menuSetLevel(sysMenuAdd, tbSysMenu);
        //设置菜单排序
        menuSetSort(sysMenuAdd, tbSysMenu);
        tbSysMenu.setIsDir(SysMenuEnums.MENU_ISDIR.getCode());
        createTbSysMenu(sysMenuAdd, user, tbSysMenu);
        logger.info("[菜单] 菜单添加成功，menuId:{}", tbSysMenu.getId());
    }

    /**
     * 设置菜单等级
     *
     * @param sysMenuAdd
     * @param tbSysMenu
     */
    private void menuSetLevel(SysMenuAdd sysMenuAdd, TbSysMenu tbSysMenu) {
        //判断参数中父级id的值,1表示一级目录
        if (SysLevelEnums.FIRST_LEVEL.getCode().equals(sysMenuAdd.getParentId())) {
            //直接添加菜单目录
            tbSysMenu.setLevel(SysLevelEnums.FIRST_LEVEL.getCode());
        } else {
            //parent_id不为1,说明是子目录,查询父级id的等级
            String parentMenuLevl = sysMenuMapper.findLevelByMenuId(sysMenuAdd.getParentId());
            if (StringUtils.isNotBlank(parentMenuLevl)) {
                tbSysMenu.setLevel(String.valueOf(Integer.parseInt(parentMenuLevl) + 1));
            }
        }
    }

    /**
     * 目录菜单下面添加子菜单
     *
     * @param sysMenuAdd
     */
    @Override
    @ServiceLog(doAction = "目录菜单下面添加子菜单")
    @Transactional(rollbackFor = Exception.class)
    public void addMenu(SysMenuAdd sysMenuAdd, User user) {
        //校验在该等级中菜单名称是否已经存在
        checkName(sysMenuAdd);
        TbSysMenu tbSysMenu = new TbSysMenu();
        //设置菜单等级
        menuSetLevel(sysMenuAdd, tbSysMenu);
        //设置菜单排序
        menuSetSort(sysMenuAdd, tbSysMenu);
        tbSysMenu.setIsDir(SysMenuEnums.MENU_ISNOTDIR.getCode());
        createTbSysMenu(sysMenuAdd, user, tbSysMenu);
        logger.info("[菜单] 菜单添加成功，menuId:{}", tbSysMenu.getId());
    }

    /**
     * 设置菜单排序
     *
     * @param sysMenuAdd
     * @param tbSysMenu
     */
    private void menuSetSort(SysMenuAdd sysMenuAdd, TbSysMenu tbSysMenu) {
        //查询文件菜单中子菜单sort的最大值
        Integer sortMax = sysMenuMapper.findSortByMenuId(sysMenuAdd.getParentId());
        if (sortMax != null) {
            tbSysMenu.setSort(sortMax + 1);
        } else {
            //如果查询不到数据,直接设置排序为1
            tbSysMenu.setSort(Integer.parseInt(SysMenuEnums.FIRST_SORT.getCode()));
        }
    }

    /**
     * 为tbSysMenu属性赋值
     *
     * @param sysMenuAdd
     * @param user
     * @param tbSysMenu
     */
    private void createTbSysMenu(SysMenuAdd sysMenuAdd, User user, TbSysMenu tbSysMenu) {
        tbSysMenu.setId(UUID.randomUUID().toString());
        tbSysMenu.setCreateTime(new Date());
        tbSysMenu.setCreator(user.getId());
        tbSysMenu.setMenuName(sysMenuAdd.getMenuName());
        tbSysMenu.setMenuUrl(StringUtils.trim(sysMenuAdd.getMenuUrl()));
        tbSysMenu.setParentId(sysMenuAdd.getParentId());
        tbSysMenu.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        tbSysMenuMapper.insertSelective(tbSysMenu);
    }

    /**
     * 校验菜单名称
     *
     * @param sysMenuNameCheck
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验菜单名称")
    public String checkMenuName(SysMenuNameCheck sysMenuNameCheck) {
        if (StringUtils.isNotBlank(sysMenuNameCheck.getMenuName())) {
            List<TbSysMenu> tbSysMenus = checkMenusName(sysMenuNameCheck.getMenuName(), sysMenuNameCheck.getParentId());
            if (tbSysMenus != null && tbSysMenus.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

    /**
     * 批量更新菜单
     *
     * @param sysMenus
     */
    @Override
    @ServiceLog(doAction = "批量更新菜单")
    @Transactional(rollbackFor = Exception.class)
    public void updateBatch(SysMenus sysMenus) {
        List<SysMenuUpdate> sysMenuSortList = sysMenus.getSysMenuSortList();
        HashSet<String> set = new HashSet<String>();
        //判断批量修改菜单中名称是否有重复的存在,使用set去重
        for (SysMenuUpdate sysMenuUpdate : sysMenuSortList) {
            set.add(sysMenuUpdate.getMenuName());
        }
        if (set.size() != sysMenuSortList.size()){
            logger.warn("[菜单] 批量更新菜单失败,菜单名称重复，更新菜单项:{}",sysMenuSortList);
            throw new JnSpringCloudException(SysMenuExceptionEnums.MENU_NAME_REPEAAT);
        }
        //如果集合长度大于0,进行批量更新
        if (sysMenuSortList != null && sysMenuSortList.size() > 0) {
            sysMenuMapper.updateBatch(sysMenuSortList);
            logger.info("[菜单] 菜单批量更新成功");
        }
    }

    /**
     * 根据父菜单id获取子下一级所有菜单信息
     *
     * @param parentId
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据父菜单id获取子下一级所有菜单信息")
    public List<SysMenuTreeVO> getChildrenMenuByParentId(String parentId) {
        List<SysMenuTreeVO> menuTreeVOList = sysMenuMapper.getChildrenMenuByParentId(parentId);
        for (SysMenuTreeVO menuTreeVO : menuTreeVOList) {
            Boolean flag = SysMenuEnums.MENU_ISDIR.getCode().equals(menuTreeVO.getIsDir())? Boolean.TRUE:Boolean.FALSE;
            if (flag){
                menuTreeVO.setIcon(SysMenuEnums.MENU_DIR_ICON.getCode());
            }else {
                menuTreeVO.setIcon(SysMenuEnums.MENU_NOTDIR_ICON.getCode());
            }
        }
        return menuTreeVOList;
    }
}
