package com.jn.system.menu.service;

import com.jn.system.menu.model.*;
import com.jn.system.menu.vo.SysMenuTreeVO;
import com.jn.system.model.User;

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
     * @param user    当前用户信息
     */
    void updateSysMenuById(SysMenu sysMenu, User user);

    /**
     * 删除菜单
     *
     * @param menuIds
     * @param user    当前用户信息
     */
    void deleteSysMenuById(String menuIds, User user);

    /**
     * 查询所有菜单信息,返回树形结构
     *
     * @param flag 菜单树接口权限管理也有调用,用于标记是菜单还是权限调用接口
     * @return
     */
    List<SysMenuTreeVO> selectMenuList(Boolean flag);

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
    void addMenuDir(SysMenuDirAdd sysMenuAdd, User user);

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
     * @param user     当前用户信息
     */
    void updateBatch(SysMenus sysMenus, User user);

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
    List<SysMenuTreeVO> getDynamicMenu(String userId);
}
