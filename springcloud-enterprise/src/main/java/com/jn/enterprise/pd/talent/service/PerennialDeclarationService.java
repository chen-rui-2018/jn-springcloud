package com.jn.enterprise.pd.talent.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.pd.talent.entity.TbPdPerennialDeclaration;

import java.util.List;

/**
 * T项目申报-常年申报
 *
 * @author： wzy
 * @date： Created on 2019/4/28 11:20
 * @version： v1.0
 * @modified By:
 */
public interface PerennialDeclarationService {

    /**
     * 查询常年申报列表
     *
     * @param
     * @return
     */
    PaginationData<List<TbPdPerennialDeclaration>> selectByPerennialDeclarationList(String title,String policyType,String zoneApplication,int page,int rows);

}
