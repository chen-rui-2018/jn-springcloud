package com.jn.system.file.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.file.dao.SysFileGroupFileMapper;
import com.jn.system.file.dao.SysFileMapper;
import com.jn.system.file.dao.TbSysFileGroupFileMapper;
import com.jn.system.file.dao.TbSysFileMapper;
import com.jn.system.file.entity.TbSysFile;
import com.jn.system.file.entity.TbSysFileGroupFile;
import com.jn.system.file.enums.SysFileExceptionEnums;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.service.SysFileService;
import com.jn.system.file.vo.SysFileVO;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysFile;
import com.jn.system.model.User;
import com.jn.system.user.dao.TbSysUserGroupMapper;
import com.jn.system.user.entity.TbSysUserGroup;
import com.jn.system.user.entity.TbSysUserGroupCriteria;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    private SysFileGroupFileMapper sysFileGroupFileMapper;

    @Resource
    private TbSysFileMapper tbSysFileMapper;

    @Resource
    private TbSysFileGroupFileMapper tbSysFileGroupFileMapper;

   /**
     * 根据关键字分页查询文件列表
     *
     * @param sysFilePage
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据关键字分页查询文件列表")
    public PaginationData<List<SysFileVO>> selectSysFileListBySearchKey(SysFilePage sysFilePage) {
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
     * 新增文件
     *
     * @param sysFile
     */
    @Override
    @ServiceLog(doAction = "新增文件明细与文件与文件组")
    @Transactional(rollbackFor = Exception.class)
    public void insertSysFile(SysFile sysFile) {

        TbSysFile tbSysFile=new TbSysFile();
        BeanUtils.copyProperties(sysFile, tbSysFile);
        tbSysFile.setCreatedTime(new Date());

        //判断用户是否有权限操作该文件组
        if(StringUtils.isNotBlank(sysFile.getUserId())){
           List<String> tbSysUserGroupList= sysFileGroupFileMapper.getUserFileGroupPermission(sysFile.getUserId(),sysFile.getFileGroupId());
            if(tbSysUserGroupList==null||tbSysUserGroupList.size()==0){
                logger.warn("[文件管理] 新增文件失败，该用户没有权限操作该用户组,,userId: {}，fileGroupId：{}",sysFile.getUserId(),sysFile.getFileGroupId());
                throw new JnSpringCloudException(SysFileExceptionEnums.AUTHENTICATION_FAIL);
            }
        }
        //设置文件有效
        tbSysFile.setRecordStatus(Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode()));
        tbSysFileMapper.insert(tbSysFile);
        logger.info("[文件管理] 新增文件成功,fileId: {}", sysFile.getId());

        TbSysFileGroupFile tbSysFileGroupFile=new TbSysFileGroupFile();
        tbSysFileGroupFile.setId(UUID.randomUUID().toString());
        tbSysFileGroupFile.setCreatedTime(new Date());
        tbSysFileGroupFile.setCreatorAccount(tbSysFile.getCreatorAccount());
        tbSysFileGroupFile.setFileGroupId(sysFile.getFileGroupId());
        tbSysFileGroupFile.setFileId(tbSysFile.getId());
        tbSysFileGroupFile.setRecordStatus(Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode()));
        tbSysFileGroupFileMapper.insert(tbSysFileGroupFile);
        logger.info("[文件管理] 新增文件组与文件关系数据成功,fileId: {}，fileGroupId：{}", sysFile.getId(),sysFile.getFileGroupId());

    }
}
