package com.jn.system.file.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.file.dao.SysFileGroupFileMapper;
import com.jn.system.file.dao.SysFileMapper;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.dao.TbSysFileMapper;
import com.jn.system.file.entity.TbSysFile;
import com.jn.system.file.entity.TbSysFileCriteria;
import com.jn.system.file.model.*;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.*;
import com.jn.system.file.service.SysFileService;
import com.jn.system.file.vo.SysFileVO;
import org.apache.commons.lang3.StringUtils;
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

    private static Logger logger = LoggerFactory.getLogger(SysFileServiceImpl.class);

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
    @ServiceLog(doAction = "新增文件")
    @Transactional(rollbackFor = Exception.class)
    public void insertSysFile(SysFile sysFile, User user) {
        //文件名称校验
        TbSysFileCriteria tbSysFileCriteria = new TbSysFileCriteria();
        TbSysFileCriteria.Criteria criteria = tbSysFileCriteria.createCriteria();
        criteria.andFileNameEqualTo(sysFile.getFileName());
        criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
        List<TbSysFile> tbSysFiles = tbSysFileMapper.selectByExample(tbSysFileCriteria);
        if (tbSysFiles != null && tbSysFiles.size() > 0) {
            logger.warn("[文件] 添加文件失败，该文件名称已存在！,fileName: {}", sysFile.getFileName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
        sysFile.setId(UUID.randomUUID().toString());

        sysFile.setCreator(user.getId());
        sysFile.setCreateTime(new Date());

        TbSysFile tbSysFile = new TbSysFile();
        BeanUtils.copyProperties(sysFile, tbSysFile);
        tbSysFileMapper.insert(tbSysFile);
        logger.info("[文件] 添加文件成功！,fileId: {}", sysFile.getId());

    }

    /**
     * 根据id更新文件
     *
     * @param sysFile
     */
    @Override
    @ServiceLog(doAction = "根据id更新文件")
    @Transactional(rollbackFor = Exception.class)
    public void updateSysFileById(SysFile sysFile) {
        TbSysFile tbSysFile = new TbSysFile();
        BeanUtils.copyProperties(sysFile, tbSysFile);
        tbSysFileMapper.updateByPrimaryKeySelective(tbSysFile);
        logger.info("[文件] 更新文件成功！,fileId: {}" ,sysFile.getId());

    }

    /**
     * 批量删除文件（逻辑删除）
     *
     * @param fileIds
     */
    @Override
    @ServiceLog(doAction = "批量删除文件（逻辑删除）")
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysFileByIds(String[] fileIds) {
        sysFileMapper.deleteByIds(fileIds);
        logger.info("[文件] 批量删除文件成功！,fileIds: {}" , Arrays.toString(fileIds));
    }

    /**
     * 根据id查询文件
     *
     * @param id
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据id查询文件")
    public SysFile selectSysFileByIds(String id) {
        TbSysFile tbSysFile = tbSysFileMapper.selectByPrimaryKey(id);
        SysFile sysFile = new SysFile();
        if (tbSysFile != null){
            BeanUtils.copyProperties(tbSysFile, sysFile);
        }
        logger.info("[文件] 根据Id查询文件成功！,fileId: {}",id);
        return sysFile;
    }

    /**
     * 根据关键字分页查询文件列表
     *
     * @param sysFilePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据关键字分页查询文件列表")
    public PaginationData selectSysFileListBySearchKey(SysFilePage sysFilePage) {
        Page<Object> objects = PageHelper.startPage(sysFilePage.getPage(), sysFilePage.getRows());
        List<SysFileVO> sysFileVOList = null;
        if (StringUtils.isNotBlank(sysFilePage.getFileGroupName())){
            //当按文件组查询时
            sysFileVOList = sysFileGroupFileMapper.findFileByFileGroupName(sysFilePage);
        }else {
            sysFileVOList = sysFileMapper.findFileByPage(sysFilePage);
            for (SysFileVO sysFileVO:sysFileVOList) {
                List<String> fileGroupNameList = sysFileGroupFileMapper.findFileGroupNameByFileId(sysFileVO.getFileId());
                sysFileVO.setFileGroupNameList(fileGroupNameList);
            }
        }
        return new PaginationData(sysFileVOList, objects.getTotal());
    }

    /**
     * 文件添加文件组
     *
     * @param sysFileAddFileGroup
     */
    @Override
    @ServiceLog(doAction = "文件添加文件组")
    @Transactional(rollbackFor = Exception.class)
    public void sysFileAddFileGroup(SysFileAddFileGroup sysFileAddFileGroup, User user) {

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
            sysFileGroupFile.setStatus(SysStatusEnums.EFFECTIVE.getCode());

            sysFileGroupFiles.add(sysFileGroupFile);
            logger.info("[文件] 文件添加文件组,fileId: {}",fileId);

        }
        logger.info("[文件] 文件添加文件组,新增前删除该的所有该文件的文件组数据成功,fileGroupId: {}",Arrays.toString(fileGroupId));

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
    @ServiceLog(doAction = "校验文件名称")
    public String checkFileName(String fileName) {
        if (StringUtils.isNotBlank(fileName)) {
            //文件名称校验
            TbSysFileCriteria tbSysFileCriteria = new TbSysFileCriteria();
            TbSysFileCriteria.Criteria criteria = tbSysFileCriteria.createCriteria();
            criteria.andFileNameEqualTo(fileName);
            criteria.andStatusNotEqualTo(SysStatusEnums.DELETED.getCode());
            List<TbSysFile> tbSysFiles = tbSysFileMapper.selectByExample(tbSysFileCriteria);
            if (tbSysFiles != null && tbSysFiles.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }
}
