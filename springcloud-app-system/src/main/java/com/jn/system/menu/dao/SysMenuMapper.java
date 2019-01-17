package com.jn.system.menu.dao;


import com.jn.system.menu.model.SysMenuUpdate;
import com.jn.system.menu.vo.SysMenuTreeVO;

import java.util.List;

/**
 * 菜单mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/05 15:31
 * @version： v1.0
 * @modified By:
 */
public interface SysMenuMapper {


    /**
     * 根据ids批量删除
     *
     * @param ids
     */
    void deleteBy(List<String> ids);

    /**
     * 根据菜单id获取菜单的等级
     *
     * @param parentId
     * @return
     */
    String findLevelByMenuId(String parentId);

    /**
     * 获取全部菜单及菜单具有的功能信息
     * @return
     */
    List<SysMenuTreeVO> getMenuAndResources();

    /**
     * 根据父菜单id,获取子菜单中等级最大的值
     *
     * @param parentId
     * @return
     */
    Integer findSortByMenuId(String parentId);

    /**
     * 批量对菜单排序进行更新
     *
     * @param sysMenuSortList
     */
    void updateBatch(List<SysMenuUpdate> sysMenuSortList);

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
     * @param userId
     * @return
     */
    List<SysMenuTreeVO> getDynamicMenu(String userId);

    /**
     * 获取菜单的所有子菜单id
     * @param menuId
     * @return
     */
    String getChildrenMenuIdS(String menuId);
}