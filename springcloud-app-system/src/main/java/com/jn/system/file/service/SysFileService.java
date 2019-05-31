package com.jn.system.file.service;

import com.jn.common.model.PaginationData;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.vo.SysFileVO;
import com.jn.system.model.SysFile;

import java.util.List;

/**
 * 文件service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 23:14
 * @version： v1.0
 * @modified By:
 */
public interface SysFileService {

    /**
     * 根据关键字分页查询文件列表
     *
     * @param sysFilePage
     * @return
     */
    PaginationData<List<SysFileVO>> selectSysFileListBySearchKey(SysFilePage sysFilePage);

    /**
     * 新增文件
     * @param sysFile
     */
    void insertSysFile(SysFile sysFile);

}
