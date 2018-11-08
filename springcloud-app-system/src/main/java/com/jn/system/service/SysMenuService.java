package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.SysMenu;
import com.jn.system.model.SysMenuPage;
import com.jn.system.model.SysMenuResourcesAdd;

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
     * 新增菜单
     *
     * @param sysMenu
     */
    void insertSysMenu(SysMenu sysMenu);

    /**
     * 更新菜单信息
     *
     * @param sysMenu
     */
    void updateSysMenuById(SysMenu sysMenu);

    /**
     * 批量删除菜单（逻辑删除）
     *
     * @param menuIds
     * @return
     */
    void deleteSysMenuById(String[] menuIds);

    /**
     * 分页查询菜单功能列表信息
     *
     * @param sysMenuPage
     * @return
     */
    PaginationData selectMenuListBySearchKey(SysMenuPage sysMenuPage);

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
    void insertMenuResources(SysMenuResourcesAdd sysMenuResourcesAdd);


}
