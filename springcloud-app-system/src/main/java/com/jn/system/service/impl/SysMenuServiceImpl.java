package com.jn.system.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.system.dao.SysMenuMapper;
import com.jn.system.dao.TbSysMenuMapper;
import com.jn.system.dao.TbSysResourcesMapper;
import com.jn.system.entity.TbSysMenu;
import com.jn.system.entity.TbSysMenuCriteria;
import com.jn.system.entity.TbSysResources;
import com.jn.system.enums.SysExceptionEnums;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysMenuService;
import com.jn.system.vo.SysMenuTreeVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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

    private Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private TbSysMenuMapper tbSysMenuMapper;

    @Resource
    private TbSysResourcesMapper tbSysResourcesMapper;

    /**
     * 更新菜单信息
     *
     * @param sysMenu
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysMenuById(SysMenu sysMenu) {
        TbSysMenuCriteria tbSysMenuCriteria = new TbSysMenuCriteria();
        TbSysMenuCriteria.Criteria criteria = tbSysMenuCriteria.createCriteria();
        criteria.andSortNotEqualTo(SysStatusEnums.DELETED.getKey());
        criteria.andParentIdEqualTo(sysMenu.getParentId());
        criteria.andMenuNameEqualTo(sysMenu.getMenuName());
        criteria.andIdNotEqualTo(sysMenu.getId());
        List<TbSysMenu> tbSysMenus = tbSysMenuMapper.selectByExample(tbSysMenuCriteria);
        if (tbSysMenus != null && tbSysMenus.size() > 0) {
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
        }
        TbSysMenu tbSysMenu = new TbSysMenu();
        BeanUtils.copyProperties(sysMenu, tbSysMenu);
        tbSysMenuMapper.updateByPrimaryKeySelective(tbSysMenu);
        logger.info("[菜单] 菜单更新成功，menuId:{}", sysMenu.getId());
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
        logger.info("[菜单] 菜单逻辑删除成功，menuIds:{}", menuIds.toString());
    }

    /**
     * 查询所有菜单,返回树形结构
     *
     * @return
     */
    @Override
    public List<SysMenuTreeVO> selectMenuListBySearchKey() {
        //先查询等级为1的菜单信息
        List<SysMenuTreeVO> menuTreeVOList = sysMenuMapper.findMenuByLevelOne();
        findChildMenuList(menuTreeVOList);
        return menuTreeVOList;

    }

    /**
     * 递归查询菜单子菜单
     *
     * @param menuTreeVOList
     */
    public void findChildMenuList(List<SysMenuTreeVO> menuTreeVOList) {
        for (SysMenuTreeVO sysMenuTreeVO : menuTreeVOList) {
            //判断菜单项是否是文件夹,是再递归获取数据
            if ("1".equals(sysMenuTreeVO.getIsDir())) {
                //以菜单id作为父id,去获取菜单子集
                List<SysMenuTreeVO> childrenMenuList = sysMenuMapper.findMenuByParentId(sysMenuTreeVO.getValue());
                sysMenuTreeVO.setChildren(childrenMenuList);
                if (childrenMenuList.size() == 0) {
                    sysMenuTreeVO.setChildren(null);
                    continue;
                } else {
                    findChildMenuList(childrenMenuList);
                }
            }
        }
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
        if (tbSysMenu != null){
            BeanUtils.copyProperties(tbSysMenu, sysMenu);
        }
        return sysMenu;
    }

    /**
     * 菜单分配功能
     *
     * @param sysMenuResourcesAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertMenuResources(SysMenuResourcesAdd sysMenuResourcesAdd,User user) {
        //功能
        String[] resourcesId = sysMenuResourcesAdd.getResourcesId();
        //菜单
        String menuId = sysMenuResourcesAdd.getMenuId();
        if (resourcesId.length == 0) {
            //获取当前登录用户信息
            TbSysResources tbSysResources = new TbSysResources();
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

    /**
     * 校验菜单名称是否存在
     *
     * @param sysMenuAdd
     */
    public void checkName(SysMenuAdd sysMenuAdd) {
        List<TbSysMenu> tbSysMenus = checkMenusName(sysMenuAdd.getMenuName(), sysMenuAdd.getParentId());
        if (tbSysMenus != null && tbSysMenus.size() > 0) {
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
    }

    /**
     * 校验菜单名称
     * @param menuName
     * @param parentId
     * @return
     */
    private List<TbSysMenu> checkMenusName(String menuName, String parentId) {
        TbSysMenuCriteria tbSysMenuCriteria = new TbSysMenuCriteria();
        TbSysMenuCriteria.Criteria criteria = tbSysMenuCriteria.createCriteria();
        criteria.andSortNotEqualTo(SysStatusEnums.DELETED.getKey());
        criteria.andParentIdEqualTo(parentId);
        criteria.andMenuNameEqualTo(menuName);
        return tbSysMenuMapper.selectByExample(tbSysMenuCriteria);
    }

    /**
     * 菜单添加目录或子目录
     *
     * @param sysMenuAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMenuDir(SysMenuAdd sysMenuAdd,User user) {
        //校验在该等级中菜单名称是否已经存在
        checkName(sysMenuAdd);
        TbSysMenu tbSysMenu = new TbSysMenu();
        //判断参数中父级id的值,1表示一级目录
        if ("1".equals(sysMenuAdd.getParentId())) {
            //直接添加菜单目录
            tbSysMenu.setLevel("1");
        } else {
            //parent_id不为1,说明是子目录,查询父级id的等级
            String parentMenuLevl = sysMenuMapper.findLevelByMenuId(sysMenuAdd.getParentId());
            if (StringUtils.isNotBlank(parentMenuLevl)) {
                tbSysMenu.setLevel((Integer.parseInt(parentMenuLevl) + 1) + "");
            }
        }
        tbSysMenu.setId(UUID.randomUUID().toString());
        tbSysMenu.setCreateTime(new Date());
        tbSysMenu.setCreator(user.getId());
        tbSysMenu.setMenuName(sysMenuAdd.getMenuName());
        tbSysMenu.setMenuUrl(sysMenuAdd.getMenuUrl());
        tbSysMenu.setParentId(sysMenuAdd.getParentId());
        tbSysMenu.setSort("0");
        tbSysMenu.setIsDir("1");
        tbSysMenu.setStatus(SysStatusEnums.EFFECTIVE.getKey());
        tbSysMenuMapper.insertSelective(tbSysMenu);
        logger.info("[菜单] 菜单添加成功，menuId:{}", tbSysMenu.getId());
    }

    /**
     * 菜单目录下面添加子菜单
     *
     * @param sysMenuAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMenu(SysMenuAdd sysMenuAdd,User user) {
        //校验在该等级中菜单名称是否已经存在
        checkName(sysMenuAdd);
        TbSysMenu tbSysMenu = new TbSysMenu();
        //查询父级id的等级
        String parentMenuLevl = sysMenuMapper.findLevelByMenuId(sysMenuAdd.getParentId());
        if (StringUtils.isNotBlank(parentMenuLevl)) {
            tbSysMenu.setLevel((Integer.parseInt(parentMenuLevl) + 1) + "");
        }
        //查询文件菜单中子菜单sort的最大值
        String sortMax = sysMenuMapper.findSortByMenuId(sysMenuAdd.getParentId());
        if (StringUtils.isNotBlank(sortMax)) {
            tbSysMenu.setSort((Integer.parseInt(sortMax) + 1) + "");
        } else {
            //如果查询不到数据,直接设置排序为1
            tbSysMenu.setSort("1");
        }
        tbSysMenu.setId(UUID.randomUUID().toString());
        tbSysMenu.setCreateTime(new Date());
        tbSysMenu.setCreator(user.getId());
        tbSysMenu.setMenuName(sysMenuAdd.getMenuName());
        tbSysMenu.setMenuUrl(sysMenuAdd.getMenuUrl());
        tbSysMenu.setParentId(sysMenuAdd.getParentId());
        tbSysMenu.setIsDir("0");
        tbSysMenu.setStatus(SysStatusEnums.EFFECTIVE.getKey());
        tbSysMenuMapper.insertSelective(tbSysMenu);
        logger.info("[菜单] 菜单添加成功，menuId:{}", tbSysMenu.getId());
    }

    /**
     * 校验菜单名称
     *
     * @param sysMenuNameCheck
     * @return
     */
    @Override
    public String checkMenuName(SysMenuNameCheck sysMenuNameCheck) {
        if (StringUtils.isNotBlank(sysMenuNameCheck.getMenuName())) {
            List<TbSysMenu> tbSysMenus = checkMenusName(sysMenuNameCheck.getMenuName(), sysMenuNameCheck.getParentId());
            if (tbSysMenus != null && tbSysMenus.size() > 0) {
                return "false";
            }
        }
        return "success";
    }
}
