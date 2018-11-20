package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.model.SysMenu;
import com.jn.system.model.SysMenuAdd;
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
     * 查询所有菜单信息,返回属性结构
     * @return
     */
    Result selectMenuListBySearchKey();

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

    /**
     * 菜单添加目录或子目录
     *
     * @param sysMenuAdd
     */
    void addMenuDir(SysMenuAdd sysMenuAdd);

    /**
     * 菜单目录下面添加子菜单
     *
     * @param sysMenuAdd
     */
    void addMenu(SysMenuAdd sysMenuAdd);
}
