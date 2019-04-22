package com.jn.enterprise.common.service;

import com.jn.enterprise.common.vo.CodeVO;

import java.util.List;

/**
 * 企业服务-公共Service
 * @author： huxw
 * @date： Created on 2019-4-3 14:59:07
 * @version： v1.0
 * @modified By:
 */
public interface CommonService {

    /**
     * 根据分组ID获取数据列表
     * @param groupId
     * @return
     */
    List<CodeVO> getCodeList(String groupId);

}
