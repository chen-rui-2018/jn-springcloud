package com.jn.system.file.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.dao.SysFileGroupFileMapper;
import com.jn.system.file.dao.SysFileGroupMapper;
import com.jn.system.file.dao.TbSysFileGroupMapper;
import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.entity.TbSysFileGroupCriteria;
import com.jn.system.file.model.SysFileGroup;
import com.jn.system.file.model.SysFileGroupPage;
import com.jn.system.file.service.SysFileGroupService;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.permission.dao.SysPermissionFilesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 文件组serviceImpl
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 20:26
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysFileGroupServiceImpl implements SysFileGroupService {

    private static Logger logger = LoggerFactory.getLogger(SysFileGroupServiceImpl.class);
    @Resource
    private SysFileGroupMapper sysFileGroupMapper;

    @Resource
    private TbSysFileGroupMapper tbSysFileGroupMapper;

    @Resource
    private SysFileGroupFileMapper sysFileGroupFileMapper;

    @Autowired
    private SysPermissionFilesMapper sysPermissionFilesMapper;

    /**
     * 新增文件组
     *
     * @param tbSysFileGroup
     */
    @Override
    @ServiceLog(doAction = "新增文件组")
    @Transactional(rollbackFor = Exception.class)
    public void insertSysFileGroup(TbSysFileGroup tbSysFileGroup) {
        //名称校验
        List<TbSysFileGroup> tbSysFileGroups = checkName(tbSysFileGroup.getFileGroupName());
        if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
            logger.warn("[文件组] 添加文件组失败，该用户组名称已存在！,fileGroupName: {}", tbSysFileGroup.getFileGroupName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        tbSysFileGroupMapper.insert(tbSysFileGroup);
        logger.info("[文件组] 添加文件组成功！,fileGroupId: {}", tbSysFileGroup.getId());
    }

    /**
     * 用于做名称校验
     *
     * @param fileGroupName
     * @return
     */
    private List<TbSysFileGroup> checkName(String fileGroupName) {
        TbSysFileGroupCriteria tbSysFileGroupCriteria = new TbSysFileGroupCriteria();
        TbSysFileGroupCriteria.Criteria criteria = tbSysFileGroupCriteria.createCriteria();
        criteria.andFileGroupNameEqualTo(fileGroupName);
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        return tbSysFileGroupMapper.selectByExample(tbSysFileGroupCriteria);
    }

    /**
     * 根据id更新文件组
     *
     * @param sysFileGroup
     */
    @Override
    @ServiceLog(doAction = "根据id更新文件组")
    @Transactional(rollbackFor = Exception.class)
    public void updateSysFileGroupById(SysFileGroup sysFileGroup) {
        String fileGroupName = sysFileGroup.getFileGroupName();
        //判断修改信息是否存在
        TbSysFileGroup tbSysFileGroup1 = tbSysFileGroupMapper.selectByPrimaryKey(sysFileGroup.getId());
        if (tbSysFileGroup1 == null || SysStatusEnums.DELETED.getCode().equals(tbSysFileGroup1.getStatus())) {
            logger.warn("[文件组] 文件组修改失败,修改信息不存在,fileGroupId: {}", sysFileGroup.getId());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEDATA_NOT_EXIST);
        } else {
            //判断名称是否修改
            if (!tbSysFileGroup1.getFileGroupName().equals(fileGroupName)) {
                //校验名称是否已经在数据库中存在
                List<TbSysFileGroup> tbSysFileGroups = checkName(fileGroupName);
                if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
                    logger.warn("[文件组] 更新文件组失败，该用户组名称已存在！,fileGroupName: {}", sysFileGroup.getFileGroupName());
                    throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
                }
            }
        }
        //对文件组信息进行修改操作
        TbSysFileGroup tbSysFileGroup = new TbSysFileGroup();
        BeanUtils.copyProperties(sysFileGroup, tbSysFileGroup);
        tbSysFileGroupMapper.updateByPrimaryKeySelective(tbSysFileGroup);
        logger.info("[文件组] 更新文件组成功！,fileGroupId: {}", sysFileGroup.getId());
    }

    /**
     * 批量删除文件组（逻辑删除）
     *
     * @param ids
     */
    @Override
    @ServiceLog(doAction = "批量删除文件组（逻辑删除）")
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysFileGroupByIds(String[] ids) {
        //删除对应文件组
        sysFileGroupMapper.deleteByIds(ids);
        logger.info("[文件组] 批量删除文件组信息成功！,fileGroupIds: {}", Arrays.toString(ids));
        //删除对应文件组文件关联信息
        sysFileGroupFileMapper.deleteByFileGroupIds(ids);
        logger.info("[文件组] 批量删除文件组关联文件信息成功！,fileGroupIds: {}", Arrays.toString(ids));
        //删除文件组对应权限信息
        sysPermissionFilesMapper.deleteByFileGroupIds(ids);
        logger.info("[文件组] 批量删除文件组关联权限信息成功！,fileGroupIds: {}", Arrays.toString(ids));
    }

    /**
     * 根据id查询文件组
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id查询文件组")
    public SysFileGroup selectSysFileGroupByIds(String id) {
        TbSysFileGroup tbSysFileGroup = tbSysFileGroupMapper.selectByPrimaryKey(id);
        SysFileGroup sysFileGroup = new SysFileGroup();
        if (tbSysFileGroup != null) {
            BeanUtils.copyProperties(tbSysFileGroup, sysFileGroup);
        }
        logger.info("[文件组] 根据Id查询文件组成功！,fileGroupId: {}", id);
        return sysFileGroup;
    }

    /**
     * 根据关键字分页查询文件组列表
     *
     * @param sysFileGroupPage
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据关键字分页查询文件组列表")
    public PaginationData selectSysFileGroupListBySearchKey(SysFileGroupPage sysFileGroupPage) {
        Page<Object> objects = PageHelper.startPage(sysFileGroupPage.getPage(), sysFileGroupPage.getRows());
        TbSysFileGroupCriteria sysFileGroupCriteria = new TbSysFileGroupCriteria();
        sysFileGroupCriteria.setOrderByClause("create_time desc,id desc");
        TbSysFileGroupCriteria.Criteria criteria = sysFileGroupCriteria.createCriteria();
        if (!StringUtils.isEmpty(sysFileGroupPage.getFileGroupName())) {
            //模糊查询搜索关键字
            criteria.andFileGroupNameLike("%" + sysFileGroupPage.getFileGroupName() + "%");
        }
        if (!StringUtils.isEmpty(sysFileGroupPage.getId())) {
            //根据id查询
            criteria.andIdEqualTo(sysFileGroupPage.getId());
        }
        if (!StringUtils.isEmpty(sysFileGroupPage.getStatus())) {
            //筛选条件：状态
            criteria.andStatusEqualTo(sysFileGroupPage.getStatus());
        }

        //过滤已删除的数据
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        return new PaginationData(tbSysFileGroupMapper.selectByExample(sysFileGroupCriteria)
                , objects.getTotal());
    }

    /**
     * 根据用户获取文件组
     *
     * @param userId 用户ID
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据用户获取文件组")
    public List<TbSysFileGroup> getUserFileGroupById(String userId) {
        return sysFileGroupFileMapper.getUserFileGroupById(userId);
    }

    /**
     * 获取用户是否拥有该文件的下载权限
     *
     * @param userId
     * @param fileUrl
     * @return
     */
    @Override
    @ServiceLog(doAction = "获取用户是否拥有该文件的下载权限")
    public Boolean getUserFilePermission(String userId, String fileUrl) {
        List<String> userFilePermissionList = sysFileGroupFileMapper.getUserFilePermission(userId, fileUrl);
        if (userFilePermissionList.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 校验文件组是否存在
     *
     * @param fileGroupName
     * @return
     */
    @Override
    @ServiceLog(doAction = "校验文件组是否存在")
    public String checkFileGroupName(String fileGroupName) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(fileGroupName)) {
            List<TbSysFileGroup> tbSysFileGroups = checkName(fileGroupName);
            if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }
}
