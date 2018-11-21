package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.SysResourcesMapper;
import com.jn.system.dao.TbSysResourcesMapper;
import com.jn.system.entity.TbSysResources;
import com.jn.system.entity.TbSysResourcesCriteria;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysResourcesService;
import com.jn.system.vo.SysResourcesVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * 功能serviceImpl
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 16:03
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysResourcesServiceImpl implements SysResourcesService {

    private Logger logger = LoggerFactory.getLogger(SysResourcesServiceImpl.class);

    @Resource
    private SysResourcesMapper sysResourcesMapper;

    @Resource
    private TbSysResourcesMapper tbSysResourcesMapper;

    /**
     * 新增功能
     *
     * @param sysResources
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertResources(SysResources sysResources) {
        //添加名称校验
        List<TbSysResources> tbSysResourcesList = checkName(sysResources.getResourcesName(), sysResources.getMenuId());
        if (tbSysResourcesList != null && tbSysResourcesList.size() > 0) {
            throw new RuntimeException("添加失败,页面功能名称已存在");
        }
        sysResources.setId(UUID.randomUUID().toString());
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysResources.setCreator(user.getId());
        TbSysResources tbSysResources = new TbSysResources();
        BeanUtils.copyProperties(sysResources, tbSysResources);
        tbSysResources.setStatus(SysStatusEnums.EFFECTIVE.getKey());
        tbSysResourcesMapper.insert(tbSysResources);
        logger.info("新增功能,resourcesName={},resourcesId={}", sysResources.getResourcesName(), sysResources.getId());
    }

    /**
     * 用于页面功能做名称校验
     * @param resourcesName
     * @param menuId
     * @return
     */
    private List<TbSysResources> checkName(String resourcesName, String menuId) {
        TbSysResourcesCriteria tbSysResourcesCriteria = new TbSysResourcesCriteria();
        TbSysResourcesCriteria.Criteria criteria = tbSysResourcesCriteria.createCriteria();
        criteria.andResourcesNameEqualTo(resourcesName);
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());
        criteria.andMenuIdEqualTo(menuId);
        return tbSysResourcesMapper.selectByExample(tbSysResourcesCriteria);
    }

    /**
     * 更新功能信息
     *
     * @param sysResources
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateResourcesById(SysResources sysResources) {
        TbSysResourcesCriteria tbSysResourcesCriteria = new TbSysResourcesCriteria();
        TbSysResourcesCriteria.Criteria criteria = tbSysResourcesCriteria.createCriteria();
        criteria.andResourcesNameEqualTo(sysResources.getResourcesName());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());
        criteria.andMenuIdEqualTo(sysResources.getMenuId());
        criteria.andIdNotEqualTo(sysResources.getId());
        List<TbSysResources> tbSysResourcesList = tbSysResourcesMapper.selectByExample(tbSysResourcesCriteria);
        if (tbSysResourcesList != null && tbSysResourcesList.size() > 0) {
            throw new RuntimeException("修改失败,页面功能名称已存在");
        }
        TbSysResources tbSysResources = new TbSysResources();
        BeanUtils.copyProperties(sysResources, tbSysResources);
        tbSysResourcesMapper.updateByPrimaryKeySelective(tbSysResources);
        logger.info("message={}", "更新功能信息,resourcesName=" + sysResources.getResourcesName() + ",resourcesId=" + sysResources.getId());
    }

    /**
     * 批量删除功能（逻辑删除）
     *
     * @param resourcesIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteResourcesById(String[] resourcesIds) {
        sysResourcesMapper.deleteByIds(resourcesIds);
        logger.info("message={}", "批量删除功能,resourcesIds=" + Arrays.toString(resourcesIds));
    }

    /**
     * 分页查询功能功能列表信息
     *
     * @param sysResourcesPage
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PaginationData selectResourcesListBySearchKey(SysResourcesPage sysResourcesPage) {
        Page<Object> objects = PageHelper.startPage(sysResourcesPage.getPage(), sysResourcesPage.getRows());
        List<SysResourcesVO> sysResourcesVOList = sysResourcesMapper.findMenuResourcesByPage(sysResourcesPage);
        for (SysResourcesVO sysResourcesVO : sysResourcesVOList) {
            List<String> menuNameList = sysResourcesMapper.findMenuNameByResourcesId(sysResourcesVO.getResourcesId());
            sysResourcesVO.setMenuName(menuNameList);
        }
        return new PaginationData(sysResourcesVOList
                , objects.getTotal());
    }

    /**
     * 根据id查询功能详情
     *
     * @param id
     * @return
     */
    @Override
    public SysResources selectSysResourcesById(String id) {
        SysResources sysResources = sysResourcesMapper.findResourceById(id);
        return sysResources;
    }

    @Override
    public Set<String> findPermissionsUrlById(String id) {
        return sysResourcesMapper.findPermissionsUrlById(id);
    }

    @Override
    public List<MenuResources> getMenuResourcesUrlById(String id) {
        return sysResourcesMapper.getMenuResourcesUrlById(id);
    }

    /**
     * 校验页面功能名称是否存在
     *
     * @param sysResourceCheckName
     * @return
     */
    @Override
    public Result checkResourceName(SysResourceCheckName sysResourceCheckName) {
        if (StringUtils.isNotBlank(sysResourceCheckName.getResourceName())) {
            List<TbSysResources> tbSysResourcesList = checkName(sysResourceCheckName.getResourceName(), sysResourceCheckName.getMenuId());
            if (tbSysResourcesList != null && tbSysResourcesList.size() > 0) {
                return new Result("flase");
            }
        }
        return new Result("success");
    }

    /**
     * 根据菜单id获取菜单所有页面功能
     *
     * @param menuId
     * @return
     */
    @Override
    public Result findResourcesByMenuId(String menuId) {
        TbSysResourcesCriteria tbSysResourcesCriteria = new TbSysResourcesCriteria();
        TbSysResourcesCriteria.Criteria criteria = tbSysResourcesCriteria.createCriteria();
        criteria.andMenuIdEqualTo(menuId);
        criteria.andStatusEqualTo(SysStatusEnums.EFFECTIVE.getKey());
        List<TbSysResources> tbSysResources = tbSysResourcesMapper.selectByExample(tbSysResourcesCriteria);
        return new Result(tbSysResources);
    }
}
