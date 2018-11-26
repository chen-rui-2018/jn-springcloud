package com.jn.system.menu.service;

import com.jn.system.menu.model.SysMenu;
import com.jn.system.menu.model.SysMenuAdd;
import com.jn.system.menu.model.SysMenuNameCheck;
import com.jn.system.menu.model.SysMenuResourcesAdd;
import com.jn.system.model.*;
import com.jn.system.menu.vo.SysMenuTreeVO;

import java.util.List;

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
     * 菜单分配功能
     *
     * @param sysMenuResourcesAdd
     */
    void insertMenuResources(SysMenuResourcesAdd sysMenuResourcesAdd, User user);

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
    void addMenu(SysMenuAdd sysMenuAdd,User user);

    /**
     * 校验菜单名称
     *
     * @param sysMenuNameCheck
     * @return
     */
    String checkMenuName(SysMenuNameCheck sysMenuNameCheck);
}
