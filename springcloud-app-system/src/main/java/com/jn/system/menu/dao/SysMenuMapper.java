package com.jn.system.menu.dao;


import com.jn.system.menu.model.SysMenu;
import com.jn.system.menu.model.SysMenuPage;
import com.jn.system.menu.model.SysMenuUpdate;
import com.jn.system.menu.vo.SysMenuTreeVO;
import com.jn.system.menu.vo.SysMenuVO;
import io.swagger.models.auth.In;

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
     * 根据主键查询菜单功能列表
     *
     * @param sysMenuPage
     * @return
     */
    List<SysMenuVO> selectMenuListBySearchKey(SysMenuPage sysMenuPage);

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
     * 根据菜单id获取菜单信息
     *
     * @param id
     * @return
     */
    SysMenu getMenuById(String id);

    /**
     * 批量对菜单排序进行更新
     *
     * @param sysMenuSortList
     */
    void updateBatch(List<SysMenuUpdate> sysMenuSortList);
}