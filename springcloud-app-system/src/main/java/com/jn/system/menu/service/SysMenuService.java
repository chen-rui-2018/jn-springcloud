package com.jn.system.menu.service;

import com.jn.system.menu.model.SysMenu;
import com.jn.system.menu.model.SysMenuAdd;
import com.jn.system.menu.model.SysMenuNameCheck;
import com.jn.system.menu.model.SysMenus;
import com.jn.system.menu.vo.SysMenuTreeVO;
import com.jn.system.model.User;

import java.util.List;
import java.util.Set;

/**
 * 菜单service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 11:46
 * @version： v1.0
 * @modified By:
 */
public interface SysMenuService {

    /**
     * 更新菜单信息
     *
     * @param sysMenu
     */
    void updateSysMenuById(SysMenu sysMenu);

    /**
     * 逻辑删除菜单
     *
     * @param menuIds
     * @return
     */
    void deleteSysMenuById(String menuIds);

    /**
     * 查询所有菜单信息,返回树形结构
     *
     * @return
     */
    List<SysMenuTreeVO> selectMenuList();

    /**
     * 根据id获取菜单详情
     *
     * @param id
     * @return
     */
    SysMenu selectMenuById(String id);

    /**
     * 菜单添加目录菜单
     *
     * @param sysMenuAdd
     */
    void addMenuDir(SysMenuAdd sysMenuAdd, User user);

    /**
     * 目录菜单下面添加子菜单
     *
     * @param sysMenuAdd
     */
    void addMenu(SysMenuAdd sysMenuAdd, User user);

    /**
     * 校验菜单名称
     *
     * @param sysMenuNameCheck
     * @return
     */
    String checkMenuName(SysMenuNameCheck sysMenuNameCheck);

    /**
     * 批量更新菜单
     *
     * @param sysMenus
     */
    void updateBatch(SysMenus sysMenus);

    /**
     * 根据父菜单id获取子下一级所有菜单信息
     *
     * @param parentId
     * @return
     */
    List<SysMenuTreeVO> getChildrenMenuByParentId(String parentId);

    /**
     * 根据用户权限动态获取菜单信息
     *
     * @return
     */
    Set<SysMenu> getDynamicMenu(String userId);
}
