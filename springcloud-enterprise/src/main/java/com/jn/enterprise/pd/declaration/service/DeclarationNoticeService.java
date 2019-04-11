package com.jn.enterprise.pd.declaration.service;

import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManage;

import java.util.List;

/**
 * 申报中心公告管理service
 *
 * @author： wzy
 * @date： Created on 2019/4/10 20:09
 * @version： v1.0
 * @modified By:
 */
public interface DeclarationNoticeService {

    List<TbPdDeclarationNoticeManage> selectByDeclarationNoticeList(String rangeName,String sortType);
}
