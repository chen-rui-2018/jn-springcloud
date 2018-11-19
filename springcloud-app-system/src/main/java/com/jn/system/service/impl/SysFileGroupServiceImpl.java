package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.system.dao.SysFileGroupFileMapper;
import com.jn.system.dao.SysFileGroupMapper;
import com.jn.system.dao.TbSysFileGroupMapper;
import com.jn.system.entity.TbSysFileGroup;
import com.jn.system.entity.TbSysFileGroupCriteria;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysFileGroupService;
import org.apache.shiro.SecurityUtils;
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
    public void insertSysFileGroup(SysFileGroup sysFileGroup) {
        //名称校验
        TbSysFileGroupCriteria tbSysFileGroupCriteria = new TbSysFileGroupCriteria();
        TbSysFileGroupCriteria.Criteria criteria = tbSysFileGroupCriteria.createCriteria();
        criteria.andFileGroupNameEqualTo(sysFileGroup.getFileGroupName());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());
        List<TbSysFileGroup> tbSysFileGroups = tbSysFileGroupMapper.selectByExample(tbSysFileGroupCriteria);
        if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
            throw new RuntimeException("添加失败,文件组名已存在");
        }
        sysFileGroup.setId(UUID.randomUUID().toString());
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysFileGroup.setCreator(user.getId());
        sysFileGroup.setCreateTime(new Date());
        TbSysFileGroup tbSysFileGroup = new TbSysFileGroup();
        BeanUtils.copyProperties(sysFileGroup, tbSysFileGroup);
        tbSysFileGroupMapper.insert(tbSysFileGroup);
        logger.info("message={}", "新增文件组,fileGroupName=" + sysFileGroup.getFileGroupName() + ",fileGroupId=" + sysFileGroup.getId());
    }

    /**
     * 根据id更新文件组
     *
     * @param sysFileGroup
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysFileGroupById(SysFileGroup sysFileGroup) {

        TbSysFileGroup tbSysFileGroup = new TbSysFileGroup();
        BeanUtils.copyProperties(sysFileGroup, tbSysFileGroup);
        tbSysFileGroupMapper.updateByPrimaryKeySelective(tbSysFileGroup);
        logger.info("message={}", "更新文件组,fileGroupName=" + sysFileGroup.getFileGroupName() + ",fileGroupId=" + sysFileGroup.getId());
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
        logger.info("message={}", "批量删除文件组,fileGroupIds=" + Arrays.toString(ids));
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
        logger.info("message={}", "根据Id查询文件组,fileGroupId=" + id);
        SysFileGroup sysFileGroup = new SysFileGroup();
        BeanUtils.copyProperties(tbSysFileGroup, sysFileGroup);
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
        sysFileGroupCriteria.createCriteria().andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());

        logger.info("message={}", "根据关键字分页查询文件组列表,searchKey=" + sysFileGroupPage.getFileGroupName() + ",status=" + sysFileGroupPage.getStatus());
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
    public void sysFileGroupFileAdd(SysFileGroupFileAdd sysFileGroupFileAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
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
            sysFileGroupFile.setStatus(SysStatusEnums.EFFECTIVE.getKey());

            sysFileGroupFiles.add(sysFileGroupFile);

            logger.info("message={}", "文件组添加文件，fileGroupId=" + fileGroupId + "fileId=" + Arrays.toString(fileId));
        }

        logger.info("message={}", "文件组添加文件,新增前删除该的所有该文件组的文件数据，fileId=" + Arrays.toString(fileId));

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
    public Result checkFileGroupName(String fileGroupName) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(fileGroupName)){
            TbSysFileGroupCriteria tbSysFileGroupCriteria = new TbSysFileGroupCriteria();
            TbSysFileGroupCriteria.Criteria criteria = tbSysFileGroupCriteria.createCriteria();
            criteria.andFileGroupNameEqualTo(fileGroupName);
            criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());
            List<TbSysFileGroup> tbSysFileGroups = tbSysFileGroupMapper.selectByExample(tbSysFileGroupCriteria);
            if (tbSysFileGroups != null && tbSysFileGroups.size() > 0) {
                return new Result("false");
            }
        }
        return new Result("success");
    }
}
