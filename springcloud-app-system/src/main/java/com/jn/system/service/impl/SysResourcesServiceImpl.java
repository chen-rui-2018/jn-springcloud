package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.system.dao.SysResourcesMapper;
import com.jn.system.dao.TbSysResourcesMapper;
import com.jn.system.entity.TbSysResources;
import com.jn.system.model.MenuResources;
import com.jn.system.model.SysResources;
import com.jn.system.model.SysResourcesPage;
import com.jn.system.model.User;
import com.jn.system.service.SysResourcesService;
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
        sysResources.setId(UUID.randomUUID().toString());
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysResources.setCreator(user.getId());
        TbSysResources tbSysResources = new TbSysResources();
        BeanUtils.copyProperties(sysResources, tbSysResources);
        tbSysResourcesMapper.insert(tbSysResources);
        logger.info("message={}", "新增功能,resourcesName=" + sysResources.getResourcesName() + ",resourcesId=" + sysResources.getId());
    }

    /**
     * 更新功能信息
     *
     * @param sysResources
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateResourcesById(SysResources sysResources) {
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
        return new PaginationData(sysResourcesMapper.findMenuResourcesByPage(sysResourcesPage)
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
        TbSysResources tbSysResources = tbSysResourcesMapper.selectByPrimaryKey(id);
        SysResources sysResources = new SysResources();
        BeanUtils.copyProperties(tbSysResources, sysResources);
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
}
