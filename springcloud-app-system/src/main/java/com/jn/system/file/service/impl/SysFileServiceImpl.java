package com.jn.system.file.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysExceptionEnums;
import com.jn.system.common.enums.SysReturnMessageEnum;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.dao.SysFileGroupFileMapper;
import com.jn.system.file.dao.SysFileMapper;
import com.jn.system.file.dao.TbSysFileMapper;
import com.jn.system.file.entity.TbSysFile;
import com.jn.system.file.entity.TbSysFileCriteria;
import com.jn.system.file.model.SysFile;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.service.SysFileService;
import com.jn.system.file.vo.SysFileVO;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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
    public void insertSysFile(SysFile sysFile) {
        //文件名称校验
        TbSysFileCriteria tbSysFileCriteria = new TbSysFileCriteria();
        TbSysFileCriteria.Criteria criteria = tbSysFileCriteria.createCriteria();
        criteria.andFileNameEqualTo(sysFile.getFileName());
        Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
        criteria.andRecordStatusNotEqualTo(recordStatus);
        List<TbSysFile> tbSysFiles = tbSysFileMapper.selectByExample(tbSysFileCriteria);
        if (tbSysFiles != null && tbSysFiles.size() > 0) {
            logger.warn("[文件] 添加文件失败，该文件名称已存在！,fileName: {}", sysFile.getFileName());
            throw new JnSpringCloudException(SysExceptionEnums.ADDERR_NAME_EXIST);
        }
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
        logger.info("[文件] 更新文件成功！,fileId: {}", sysFile.getId());

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
        logger.info("[文件] 批量删除文件成功！,fileIds: {}", Arrays.toString(fileIds));
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
        if (tbSysFile != null) {
            BeanUtils.copyProperties(tbSysFile, sysFile);
        }
        logger.info("[文件] 根据Id查询文件成功！,fileId: {}", id);
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
        if (StringUtils.isNotBlank(sysFilePage.getFileGroupName())) {
            //当按文件组查询时
            sysFileVOList = sysFileGroupFileMapper.findFileByFileGroupName(sysFilePage);
        } else {
            sysFileVOList = sysFileMapper.findFileByPage(sysFilePage);
            for (SysFileVO sysFileVO : sysFileVOList) {
                List<String> fileGroupNameList = sysFileGroupFileMapper.findFileGroupNameByFileId(sysFileVO.getFileId());
                sysFileVO.setFileGroupNameList(fileGroupNameList);
            }
        }
        return new PaginationData(sysFileVOList, objects.getTotal());
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
            Byte recordStatus = Byte.parseByte(SysStatusEnums.DELETED.getCode());
            criteria.andRecordStatusNotEqualTo(recordStatus);
            List<TbSysFile> tbSysFiles = tbSysFileMapper.selectByExample(tbSysFileCriteria);
            if (tbSysFiles != null && tbSysFiles.size() > 0) {
                return SysReturnMessageEnum.FAIL.getMessage();
            }
        }
        return SysReturnMessageEnum.SUCCESS.getMessage();
    }
}
