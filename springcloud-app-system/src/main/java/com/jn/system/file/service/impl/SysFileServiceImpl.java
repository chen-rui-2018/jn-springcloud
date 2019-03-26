package com.jn.system.file.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.system.file.dao.SysFileGroupFileMapper;
import com.jn.system.file.dao.SysFileMapper;
import com.jn.system.file.dao.TbSysFileMapper;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.service.SysFileService;
import com.jn.system.file.vo.SysFileVO;
import com.jn.system.log.annotation.ServiceLog;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private SysFileGroupFileMapper sysFileGroupFileMapper;

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
}
