package com.jn.system.menu.dao;


import com.jn.system.menu.model.SysMenu;
import com.jn.system.menu.model.SysMenuPage;
import com.jn.system.menu.model.SysMenuUpdate;
import com.jn.system.menu.vo.SysMenuTreeVO;
import com.jn.system.menu.vo.SysMenuVO;
import com.jn.system.permission.vo.SysMenuTreeOfPermissionVO;

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
     * 根据父菜单id,获取子菜单中等级最大的值
     *
     * @param parentId
     * @return
     */
    Integer findSortByMenuId(String parentId);

    /**
     * 等级为1的菜单信息
     *
     * @return
     */
    List<SysMenuTreeVO> findMenuByLevelOne();

    /**
     * 以菜单id作为父id,去获取菜单子集
     *
     * @param value
     * @return
     */
    List<SysMenuTreeVO> findMenuByParentId(String value);

    /**
     * 批量对菜单排序进行更新
     *
     * @param sysMenuSortList
     */
    void updateBatch(List<SysMenuUpdate> sysMenuSortList);

    /**
     * 查询一级菜单信息
     *
     * @return
     */
    List<SysMenuTreeOfPermissionVO> getMenuByLevelOne();

    /**
     * 根据菜单父级菜单id获取子菜单
     *
     * @param id
     * @return
     */
    List<SysMenuTreeOfPermissionVO> findMenuOfPermissionByParentId(String id);

    /**
     * 根据父菜单id获取子下一级所有菜单信息
     *
     * @param parentId
     * @return
     */
    List<SysMenuTreeVO> getChildrenMenuByParentId(String parentId);
}