package com.jn.system.file.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.system.file.dao.SysFileGroupFileMapper;
import com.jn.system.file.dao.SysFileGroupMapper;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.dao.TbSysFileGroupMapper;
import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.entity.TbSysFileGroupCriteria;
import com.jn.system.file.model.SysFileGroup;
import com.jn.system.file.model.SysFileGroupFile;
import com.jn.system.file.model.SysFileGroupFileAdd;
import com.jn.system.file.model.SysFileGroupPage;
import com.jn.system.model.*;
import com.jn.system.file.service.SysFileGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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

    private Logger logger = LoggerFactory.getLogger(SysFileGroupServiceImpl.class);
    @Resource
    private SysFileGroupMapper sysFileGroupMapper;

    @Resource
    private TbSysFileGroupMapper tbSysFileGroupMapper;

    @Resource
    private SysFileGroupFileMapper sysFileGroupFileMapper;

    /**
     * 新增文件组
     *
     * @param sysFileGroup
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSysFileGroup(SysFileGroup sysFileGroup, User user) {
        //名称校验
        List<TbSysFileGroup> tbSysFileGroups = checkName(sysFileGroup.getFileGroupName());
        if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
            logger.info("[文件组] 添加文件组失败，该用户组名称已存在！,fileGroupName: {}",sysFileGroup.getFileGroupName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        sysFileGroup.setId(UUID.randomUUID().toString());
        sysFileGroup.setCreator(user.getId());
        sysFileGroup.setCreateTime(new Date());
        TbSysFileGroup tbSysFileGroup = new TbSysFileGroup();
        BeanUtils.copyProperties(sysFileGroup, tbSysFileGroup);
        tbSysFileGroupMapper.insert(tbSysFileGroup);
        logger.info("[文件组] 添加文件组成功！,fileGroupId: {}", sysFileGroup.getId());
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
    @Transactional(rollbackFor = Exception.class)
    public void updateSysFileGroupById(SysFileGroup sysFileGroup) {
        TbSysFileGroupCriteria tbSysFileGroupCriteria = new TbSysFileGroupCriteria();
        TbSysFileGroupCriteria.Criteria criteria = tbSysFileGroupCriteria.createCriteria();
        criteria.andFileGroupNameEqualTo(sysFileGroup.getFileGroupName());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        criteria.andIdNotEqualTo(sysFileGroup.getId());
        List<TbSysFileGroup> tbSysFileGroups = tbSysFileGroupMapper.selectByExample(tbSysFileGroupCriteria);
        if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
            logger.info("[文件组] 更新文件组失败，该用户组名称已存在！,fileGroupName: {}",sysFileGroup.getFileGroupName());
            throw new JnSpringCloudException(SysExceptionEnums.UPDATEERR_NAME_EXIST);
        }
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
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysFileGroupByIds(String[] ids) {
        sysFileGroupMapper.deleteByIds(ids);
        logger.info("[文件组] 批量删除文件组成功！,fileGroupIds: {}", Arrays.toString(ids));
    }

    /**
     * 根据id查询文件组
     *
     * @param id
     * @return
     */
    @Override
    public SysFileGroup selectSysFileGroupByIds(String id) {
        TbSysFileGroup tbSysFileGroup = tbSysFileGroupMapper.selectByPrimaryKey(id);
        SysFileGroup sysFileGroup = new SysFileGroup();
        if (tbSysFileGroup != null){
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
    public PaginationData selectSysFileGroupListBySearchKey(SysFileGroupPage sysFileGroupPage) {
        Page<Object> objects = PageHelper.startPage(sysFileGroupPage.getPage(), sysFileGroupPage.getRows());
        TbSysFileGroupCriteria sysFileGroupCriteria = new TbSysFileGroupCriteria();

        if (!StringUtils.isEmpty(sysFileGroupPage.getFileGroupName())) {
            //模糊查询搜索关键字
            sysFileGroupCriteria.createCriteria().andFileGroupNameLike("%" + sysFileGroupPage.getFileGroupName() + "%");
        }
        if (!StringUtils.isEmpty(sysFileGroupPage.getId())) {
            //根据id查询
            sysFileGroupCriteria.createCriteria().andIdEqualTo(sysFileGroupPage.getId());
        }
        if (!StringUtils.isEmpty(sysFileGroupPage.getStatus())) {
            //筛选条件：状态
            sysFileGroupCriteria.createCriteria().andStatusEqualTo(sysFileGroupPage.getStatus());
        }

        //过滤已删除的数据
        sysFileGroupCriteria.createCriteria().andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());

        logger.info("[文件组] 根据关键字分页查询文件组列表成功！,searchKey: {}，status：{}", sysFileGroupPage.getFileGroupName(), sysFileGroupPage.getStatus());
        return new PaginationData(tbSysFileGroupMapper.selectByExample(sysFileGroupCriteria)
                , objects.getTotal());
    }

    /**
     * 文件组添加文件
     *
     * @param sysFileGroupFileAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sysFileGroupFileAdd(SysFileGroupFileAdd sysFileGroupFileAdd, User user) {

        //文件组
        String fileGroupId = sysFileGroupFileAdd.getFileGroupId();
        //文件
        String[] fileId = sysFileGroupFileAdd.getFileId();
        List<SysFileGroupFile> sysFileGroupFiles = new ArrayList<>();
        for (int i = 0; i < fileId.length; i++) {
            SysFileGroupFile sysFileGroupFile = new SysFileGroupFile();
            sysFileGroupFile.setId(UUID.randomUUID().toString());
            //创建人
            sysFileGroupFile.setCreator(user.getId());
            //文件
            sysFileGroupFile.setFileId(fileId[i]);
            //文件组
            sysFileGroupFile.setFileGroupId(fileGroupId);
            //状态，默认有效
            sysFileGroupFile.setStatus(SysStatusEnums.EFFECTIVE.getCode());

            sysFileGroupFiles.add(sysFileGroupFile);
            logger.info("[文件组] 文件组添加文件,fileGroupId: {}，fileId：{}", fileGroupId, Arrays.toString(fileId));

        }
        logger.info("[文件组] 文件组添加文件,新增前删除该的所有该文件组的文件数据,fileId：{}", fileGroupId, Arrays.toString(fileId));

        //新增前删除该的所有该文件组的文件数据
        String[] fileGroupIds = {fileGroupId};
        sysFileGroupFileMapper.deleteByFileGroupIds(fileGroupIds);

        //批量新增文件组文件信息
        sysFileGroupFileMapper.insertBatch(sysFileGroupFiles);
    }

    @Override
    public List<TbSysFileGroup> getUserFileGroupById(String userId) {
        return sysFileGroupFileMapper.getUserFileGroupById(userId);
    }

    @Override
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
