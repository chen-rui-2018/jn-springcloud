package com.jn.enterprise.pd.declaration.service.impl;

import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationPlatformManageMapper;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationPlatformManageCriteria;
import com.jn.enterprise.pd.declaration.enums.DeclaratStatusEnums;
import com.jn.enterprise.pd.declaration.service.DeclarationPlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 申报平台管理业务实现层
 *
 * @author： wzy
 * @date： Created on 2019/4/10 17:12
 * @version： v1.0
 * @modified By:
 */
@Service
public class DeclarationPlatformServiceImpl implements DeclarationPlatformService {

    private static Logger logger = LoggerFactory.getLogger(DeclarationPlatformServiceImpl.class);

    @Autowired
    private TbPdDeclarationPlatformManageMapper tbPdDeclarationPlatformManageMapper;

    @Override
    public List<TbPdDeclarationPlatformManage> selectByDeclarationPlatformList(String subordinatePlatformName) {
        TbPdDeclarationPlatformManageCriteria platformManageCriteria = new TbPdDeclarationPlatformManageCriteria();
        platformManageCriteria.setOrderByClause("created_time desc");
        TbPdDeclarationPlatformManageCriteria.Criteria criteria = platformManageCriteria.createCriteria();
        Byte status = Byte.parseByte(DeclaratStatusEnums.RELEASE.getCode());
        criteria.andStatusEqualTo(status);
        criteria.andSubordinatePlatformNameLike(subordinatePlatformName);
        List<TbPdDeclarationPlatformManage> selectByDeclarationPlatformList = tbPdDeclarationPlatformManageMapper.selectByExample(platformManageCriteria);
        return selectByDeclarationPlatformList;
    }
}
