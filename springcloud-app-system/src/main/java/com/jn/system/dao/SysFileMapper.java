package com.jn.system.dao;

import java.util.List;
import com.jn.system.model.SysFilePage;
import com.jn.system.vo.SysFileVO;

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
     * @param id
     * @return
     */
    int deleteByIds(String[] id);

    /**
     * 根据关键字分页查询文件列表
     * @param sysFilePage
     * @return
     */
    List<SysFileVO> selectFileListBySearchKey(SysFilePage sysFilePage);
}