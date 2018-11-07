package com.jn.system.dao;



import com.jn.system.model.SysMenu;
import com.jn.system.model.SysMenuPage;
import com.jn.system.vo.SysMenuVO;

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
     * @param id
     */
    void deleteBy(String[] id);

    /**
     * 根据主键查询菜单功能列表
     * @param sysMenuPage
     * @return
     */
    List<SysMenuVO> selectMenuListBySearchKey(SysMenuPage sysMenuPage);







}