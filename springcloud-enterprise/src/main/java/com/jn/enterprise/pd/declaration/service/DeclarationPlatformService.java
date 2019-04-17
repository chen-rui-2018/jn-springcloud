package com.jn.enterprise.pd.declaration.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeRange;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformSubordinate;

import java.util.List;

/**
 * 申报平台管理service
 *
 * @author： wzy
 * @date： Created on 2019/4/10 17:12
 * @version： v1.0
 * @modified By:
 */
public interface DeclarationPlatformService {

    /**
     * 查询所有平台
     *
     * @return
     */
    PaginationData<List<TbPdDeclarationPlatformManage>> selectByDeclarationPlatformList(String subordinatePlatformName, int page, int rows);

    /**
     * 查询所有平台类型列表
     *
     * @return
     */
    List<TbPdDeclarationPlatformSubordinate> selectByPlatformSubordinateList();
}
