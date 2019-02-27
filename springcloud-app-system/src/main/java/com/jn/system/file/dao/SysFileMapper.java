package com.jn.system.file.dao;

import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.vo.SysFileVO;

import java.util.List;

/**
 * 文件mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
public interface SysFileMapper {

    /**
     * 批量删除
     *
     * @param id
     * @return
     */
    int deleteByIds(String[] id);

    /**
     * 分页查询文件信息
     *
     * @param sysFilePage
     * @return
     */
    List<SysFileVO> findFileByPage(SysFilePage sysFilePage);
}