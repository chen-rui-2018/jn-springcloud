package com.jn.system.menu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.menu.dao.SysResourcesMapper;
import com.jn.system.menu.dao.TbSysResourcesMapper;
import com.jn.system.menu.entity.TbSysResources;
import com.jn.system.menu.entity.TbSysResourcesCriteria;
import com.jn.system.menu.model.SysResourceCheckName;
import com.jn.system.menu.model.SysResources;
import com.jn.system.menu.model.SysResourcesPage;
import com.jn.system.menu.service.SysResourcesService;
import com.jn.system.menu.vo.SysResourcesVO;
import com.jn.system.model.MenuResources;
import com.jn.system.model.User;
import org.apache.commons.lang3.StringUtils;
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

    private static Logger logger = LoggerFactory.getLogger(SysResourcesServiceImpl.class);

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
    @ServiceLog(doAction = "新增功能")
    @Transactional(rollbackFor = Exception.class)
    public void insertResources(SysResources sysResources, User user) {
        //添加名称校验
        List<TbSysResources> tbSysResourcesList = checkName(sysResources.getResourcesName(), sysResources.getMenuId());
        if (tbSysResourcesList != null && tbSysResourcesList.size() > 0) {
            logger.warn("[[功能] 新增功能失败，该功能名称已存在！,resourcesName: {}", sysResources.getResourcesName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        sysResources.setId(UUID.randomUUID().toString());
        sysResources.setCreator(user.getId());
        TbSysResources tbSysResources = new TbSysResources();
        BeanUtils.copyProperties(sysResources, tbSysResources);
        tbSysResources.setStatus(SysStatusEnums.EFFECTIVE.getCode());
        tbSysResourcesMapper.insert(tbSysResources);
        logger.info("[功能] 新增功能成功！,resourcesName:{},resourcesId:{}", sysResources.getResourcesName(), sysResources.getId());
    }

    /**
     * 用于页面功能做名称校验
     *
     * @param resourcesName
     * @param menuId
     * @return
     */
    private List<TbSysResources> checkName(String resourcesName, String menuId) {
        TbSysResourcesCriteria tbSysResourcesCriteria = new TbSysResourcesCriteria();
        TbSysResourcesCriteria.Criteria criteria = tbSysResourcesCriteria.createCriteria();
        criteria.andResourcesNameEqualTo(resourcesName);
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        criteria.andMenuIdEqualTo(menuId);
        return tbSysResourcesMapper.selectByExample(tbSysResourcesCriteria);
    }

    /**
     * 更新功能信息
     *
     * @param sysResources
     */
    @Override
    @ServiceLog(doAction = "更新功能信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateResourcesById(SysResources sysResources) {
        //判断修改信息是否存在
        SysResources sysResources1 = sysResourcesMapper.getResourcesById(sysResources.getId());
        if (sysResources1 == null){
            logger.warn("[功能] 功能信息修改失败,修改信息不存在,resourcesId: {}", sysResources.getId());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        }
        TbSysResourcesCriteria tbSysResourcesCriteria = new TbSysResourcesCriteria();
        TbSysResourcesCriteria.Criteria criteria = tbSysResourcesCriteria.createCriteria();
        criteria.andResourcesNameEqualTo(sysResources.getResourcesName());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        criteria.andMenuIdEqualTo(sysResources.getMenuId());
        criteria.andIdNotEqualTo(sysResources.getId());
        List<TbSysResources> tbSysResourcesList = tbSysResourcesMapper.selectByExample(tbSysResourcesCriteria);
        if (tbSysResourcesList != null && tbSysResourcesList.size() > 0) {
            logger.warn("[[功能] 更新功能失败，该功能名称已存在！,resourcesName: {}", sysResources.getResourcesName());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
        }
        TbSysResources tbSysResources = new TbSysResources();
        BeanUtils.copyProperties(sysResources, tbSysResources);
        tbSysResourcesMapper.updateByPrimaryKeySelective(tbSysResources);
        logger.info("[功能] 更新功能信息成功！,resourcesId:{}", sysResources.getId());
    }

    /**
     * 批量删除功能（逻辑删除）
     *
     * @param resourcesIds
     * @return
     */
    @Override
    @ServiceLog(doAction = "批量删除功能（逻辑删除）")
    @Transactional(rollbackFor = Exception.class)
    public void deleteResourcesById(String[] resourcesIds) {
        sysResourcesMapper.deleteByIds(resourcesIds);
        logger.info("[功能] 批量删除功能成功！,resourcesIds:{}",Arrays.toString(resourcesIds));
    }

    /**
     * 分页查询功能功能列表信息
     *
     * @param sysResourcesPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "分页查询功能功能列表信息")
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
    @ServiceLog(doAction = "根据id查询功能详情")
    public SysResources selectSysResourcesById(String id) {
        SysResources sysResources = sysResourcesMapper.findResourceById(id);
        return sysResources;
    }

    /**
     * 根据id查找用户拥有权限列表
     *
     * @param id 用户ID
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id查找用户拥有权限列表")
    public Set<String> findPermissionsUrlById(String id) {
        return sysResourcesMapper.findPermissionsUrlById(id);
    }

    /**
     * 根据id查找用户拥有功能权限列表
     *
     * @param id 用户ID
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id查找用户拥有功能权限列表")
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
    @ServiceLog(doAction = "校验页面功能名称是否存在")
    public String checkResourceName(SysResourceCheckName sysResourceCheckName) {
        if (StringUtils.isNotBlank(sysResourceCheckName.getResourceName())) {
            List<TbSysResources> tbSysResourcesList = checkName(sysResourceCheckName.getResourceName(), sysResourceCheckName.getMenuId());
            if (tbSysResourcesList != null && tbSysResourcesList.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }

    /**
     * 根据菜单id获取菜单所有页面功能
     *
     * @param menuId
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据菜单id获取菜单所有页面功能")
    public List<TbSysResources> findResourcesByMenuId(String menuId) {
        TbSysResourcesCriteria tbSysResourcesCriteria = new TbSysResourcesCriteria();
        tbSysResourcesCriteria.setOrderByClause("create_time desc");
        TbSysResourcesCriteria.Criteria criteria = tbSysResourcesCriteria.createCriteria();
        criteria.andMenuIdEqualTo(menuId);
        criteria.andStatusEqualTo(SysStatusEnums.EFFECTIVE.getCode());
        List<TbSysResources> tbSysResources = tbSysResourcesMapper.selectByExample(tbSysResourcesCriteria);
        return tbSysResources;
    }
}
