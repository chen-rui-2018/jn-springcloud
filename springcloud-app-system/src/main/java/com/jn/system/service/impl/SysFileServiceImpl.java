package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.dao.SysFileGroupFileMapper;
import com.jn.system.dao.SysFileMapper;
import com.jn.system.dao.TbSysFileMapper;
import com.jn.system.entity.TbSysFile;
import com.jn.system.entity.TbSysFileCriteria;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.*;
import com.jn.system.service.SysFileService;
import com.jn.system.vo.SysFileVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 文件serviceImpl
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 20:25
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysFileServiceImpl implements SysFileService {

    private Logger logger = LoggerFactory.getLogger(SysFileServiceImpl.class);

    @Resource
    private SysFileMapper sysFileMapper;

    @Resource
    private TbSysFileMapper tbSysFileMapper;

    @Resource
    private SysFileGroupFileMapper sysFileGroupFileMapper;

    /**
     * 新增文件
     *
     * @param sysFile
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSysFile(SysFile sysFile) {
        //文件名称校验
        TbSysFileCriteria tbSysFileCriteria = new TbSysFileCriteria();
        TbSysFileCriteria.Criteria criteria = tbSysFileCriteria.createCriteria();
        criteria.andFileNameEqualTo(sysFile.getFileName());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());
        List<TbSysFile> tbSysFiles = tbSysFileMapper.selectByExample(tbSysFileCriteria);
        if (tbSysFiles != null && tbSysFiles.size() > 0) {
            throw new RuntimeException("添加失败,文件名称已存在");
        }
        sysFile.setId(UUID.randomUUID().toString());
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysFile.setCreator(user.getId());
        sysFile.setCreateTime(new Date());

        TbSysFile tbSysFile = new TbSysFile();
        BeanUtils.copyProperties(sysFile, tbSysFile);
        tbSysFileMapper.insert(tbSysFile);
        logger.info("message={}", "新增文件,fileName=" + sysFile.getFileName() + ",fileId=" + sysFile.getId());

    }

    /**
     * 根据id更新文件
     *
     * @param sysFile
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysFileById(SysFile sysFile) {
        TbSysFile tbSysFile = new TbSysFile();
        BeanUtils.copyProperties(sysFile, tbSysFile);
        tbSysFileMapper.updateByPrimaryKeySelective(tbSysFile);
        logger.info("message={}", "更新文件,fileName=" + sysFile.getFileName() + ",fileId=" + sysFile.getId());

    }

    /**
     * 批量删除文件（逻辑删除）
     *
     * @param fileIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysFileByIds(String[] fileIds) {
        sysFileMapper.deleteByIds(fileIds);
        logger.info("message={}", "批量删除文件,fileIds=" + Arrays.toString(fileIds));
    }

    /**
     * 根据id查询文件
     *
     * @param id
     * @return
     */
    @Override
    public SysFile selectSysFileByIds(String id) {
        TbSysFile tbSysFile = tbSysFileMapper.selectByPrimaryKey(id);
        SysFile sysFile = new SysFile();
        BeanUtils.copyProperties(tbSysFile, sysFile);
        logger.info("message={}", "根据Id查询文件,fileId=" + id);
        return sysFile;
    }

    /**
     * 根据关键字分页查询文件列表
     *
     * @param sysFilePage
     * @return
     */
    @Override
    public PaginationData selectSysFileListBySearchKey(SysFilePage sysFilePage) {
        Page<Object> objects = PageHelper.startPage(sysFilePage.getPage(), sysFilePage.getRows());
        //分页查询文件信息
        List<SysFileVO> sysFileVOList = sysFileMapper.findFileByPage(sysFilePage);
        for (SysFileVO sysFileVO:sysFileVOList) {
            List<String> fileGroupNameList = sysFileGroupFileMapper.findFileGroupNameByFileId(sysFileVO.getFileId());
            sysFileVO.setFileGroupNameList(fileGroupNameList);
        }
        return new PaginationData(sysFileVOList, objects.getTotal());
    }

    /**
     * 文件添加文件组
     *
     * @param sysFileAddFileGroup
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sysFileAddFileGroup(SysFileAddFileGroup sysFileAddFileGroup) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //文件
        String fileId = sysFileAddFileGroup.getFileId();
        //文件组
        String[] fileGroupId = sysFileAddFileGroup.getFileGroupId();
        List<SysFileGroupFile> sysFileGroupFiles = new ArrayList<>();
        for (int i = 0; i < fileGroupId.length; i++) {
            SysFileGroupFile sysFileGroupFile = new SysFileGroupFile();
            sysFileGroupFile.setId(UUID.randomUUID().toString());
            //创建人
            sysFileGroupFile.setCreator(user.getId());
            //文件组
            sysFileGroupFile.setFileGroupId(fileGroupId[i]);
            //文件
            sysFileGroupFile.setFileId(fileId);
            //状态，默认有效
            sysFileGroupFile.setStatus(SysStatusEnums.EFFECTIVE.getKey());

            sysFileGroupFiles.add(sysFileGroupFile);

            logger.info("message={}", "文件添加文件组，fileGroupId=" + Arrays.toString(fileGroupId) + "fileId=" + fileId);
        }

        logger.info("message={}", "文件添加文件组,新增前删除该的所有该文件的文件组数据，fileGroupId=" + Arrays.toString(fileGroupId));

        //新增前删除该的所有该文件的文件组数据
        String[] fileIds = {fileId};
        sysFileGroupFileMapper.deleteByFileIds(fileIds);

        //批量新增文件组文件信息
        sysFileGroupFileMapper.insertBatch(sysFileGroupFiles);


    }

    /**
     * 校验文件名称
     *
     * @param fileName
     * @return
     */
    @Override
    public Result checkFileName(String fileName) {
        if (StringUtils.isNotBlank(fileName)){
            //文件名称校验
            TbSysFileCriteria tbSysFileCriteria = new TbSysFileCriteria();
            TbSysFileCriteria.Criteria criteria = tbSysFileCriteria.createCriteria();
            criteria.andFileNameEqualTo(fileName);
            criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getKey());
            List<TbSysFile> tbSysFiles = tbSysFileMapper.selectByExample(tbSysFileCriteria);
            if (tbSysFiles != null && tbSysFiles.size() > 0) {
                return new Result("false");
            }
        }
        return new Result("success");
    }
}
