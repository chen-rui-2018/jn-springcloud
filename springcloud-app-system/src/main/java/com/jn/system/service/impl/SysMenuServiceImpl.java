package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.system.dao.SysMenuMapper;
import com.jn.system.dao.TbSysMenuMapper;
import com.jn.system.dao.TbSysResourcesMapper;
import com.jn.system.entity.TbSysMenu;
import com.jn.system.entity.TbSysResources;
import com.jn.system.model.SysMenu;
import com.jn.system.model.SysMenuPage;
import com.jn.system.model.SysMenuResourcesAdd;
import com.jn.system.model.User;
import com.jn.system.service.SysMenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

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

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private TbSysMenuMapper tbSysMenuMapper;

    @Resource
    private TbSysResourcesMapper tbSysResourcesMapper;


    /**
     * 新增菜单
     *
     * @param sysMenu
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSysMenu(SysMenu sysMenu) {
        sysMenu.setId(UUID.randomUUID().toString());
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenu.setCreator(user.getId());
        sysMenu.setCreateTime(new Date());
        TbSysMenu tbSysMenu = new TbSysMenu();
        BeanUtils.copyProperties(sysMenu, tbSysMenu);
        tbSysMenuMapper.insert(tbSysMenu);

    }

    /**
     * 更新菜单信息
     *
     * @param sysMenu
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysMenuById(SysMenu sysMenu) {
        TbSysMenu tbSysMenu = new TbSysMenu();
        BeanUtils.copyProperties(sysMenu, tbSysMenu);
        tbSysMenuMapper.updateByPrimaryKeySelective(tbSysMenu);
    }

    /**
     * 批量删除菜单（逻辑删除）
     *
     * @param menuIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysMenuById(String[] menuIds) {
        sysMenuMapper.deleteBy(menuIds);
    }

    /**
     * 分页查询菜单功能列表信息
     *
     * @param sysMenuPage
     * @return
     */
    @Override
    public PaginationData selectMenuListBySearchKey(SysMenuPage sysMenuPage) {
        Page<Object> objects = PageHelper.startPage(sysMenuPage.getPage(), sysMenuPage.getRows());
        return new PaginationData(sysMenuMapper.selectMenuListBySearchKey(sysMenuPage)
                , objects.getTotal());

    }

    /**
     * 根据id获取菜单详情
     *
     * @param id
     * @return
     */
    @Override
    public SysMenu selectMenuById(String id) {
        TbSysMenu tbSysMenu = tbSysMenuMapper.selectByPrimaryKey(id);
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(tbSysMenu, sysMenu);
        return sysMenu;
    }

    /**
     * 菜单分配功能
     *
     * @param sysMenuResourcesAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertMenuResources(SysMenuResourcesAdd sysMenuResourcesAdd) {
        //功能
        String[] resourcesId = sysMenuResourcesAdd.getResourcesId();
        //菜单
        String menuId = sysMenuResourcesAdd.getMenuId();
        if (resourcesId.length == 0) {
            //获取当前登录用户信息
            TbSysResources tbSysResources = new TbSysResources();
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            tbSysResources.setCreator(user.getId());
            tbSysResources.setId(UUID.randomUUID().toString());
            tbSysResources.setCreateTime(new Date());
            tbSysResources.setResourcesName(sysMenuResourcesAdd.getResourcesName());
            tbSysResources.setResourcesUrl(sysMenuResourcesAdd.getResourcesUrl());
            tbSysResources.setStatus(sysMenuResourcesAdd.getStatus());
            tbSysResources.setMenuId(menuId);
            tbSysResourcesMapper.insert(tbSysResources);
            return;
        }

        for (int i = 0; i < resourcesId.length; i++) {
            //根据id查询当前功能
            TbSysResources tbSysResources = tbSysResourcesMapper.selectByPrimaryKey(resourcesId[i]);
            if (tbSysResources == null) {
                //获取当前登录用户信息
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                tbSysResources.setCreator(user.getId());
                tbSysResources.setId(UUID.randomUUID().toString());
                tbSysResources.setCreateTime(new Date());
                tbSysResources.setResourcesName(sysMenuResourcesAdd.getResourcesName());
                tbSysResources.setResourcesUrl(sysMenuResourcesAdd.getResourcesUrl());
                tbSysResources.setStatus(sysMenuResourcesAdd.getStatus());
                tbSysResources.setMenuId(menuId);
                tbSysResourcesMapper.insert(tbSysResources);
            } else {
                //设置当前菜单
                tbSysResources.setMenuId(menuId);
                //更新功能中的菜单
                tbSysResourcesMapper.updateByPrimaryKey(tbSysResources);
            }

        }


    }
}
