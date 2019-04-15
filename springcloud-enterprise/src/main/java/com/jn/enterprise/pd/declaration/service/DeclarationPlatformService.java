package com.jn.enterprise.pd.declaration.service;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformManage;
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
    List<TbPdDeclarationPlatformManage> selectByDeclarationPlatformList(String subordinatePlatformName);
}
