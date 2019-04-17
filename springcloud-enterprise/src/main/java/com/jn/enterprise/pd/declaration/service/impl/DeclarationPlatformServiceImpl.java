package com.jn.enterprise.pd.declaration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationPlatformManageMapper;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationPlatformSubordinateMapper;
import com.jn.enterprise.pd.declaration.entity.*;
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

    @Autowired
    private TbPdDeclarationPlatformSubordinateMapper tbPdDeclarationPlatformSubordinateMapper;

    @Override
    public PaginationData<List<TbPdDeclarationPlatformManage>> selectByDeclarationPlatformList(String subordinatePlatformName,int page,int rows) {
        Page<Object> objects = PageHelper.startPage(page, rows);
        TbPdDeclarationPlatformManageCriteria platformManageCriteria = new TbPdDeclarationPlatformManageCriteria();
        platformManageCriteria.setOrderByClause("created_time desc");
        TbPdDeclarationPlatformManageCriteria.Criteria criteria = platformManageCriteria.createCriteria();
        Byte status = Byte.parseByte(DeclaratStatusEnums.RELEASE.getCode());
        criteria.andStatusEqualTo(status);
        criteria.andSubordinatePlatformNameEqualTo(subordinatePlatformName);
        return new PaginationData(tbPdDeclarationPlatformManageMapper.selectByExample(platformManageCriteria), objects.getTotal());
    }

    @Override
    public List<TbPdDeclarationPlatformSubordinate> selectByPlatformSubordinateList() {
        TbPdDeclarationPlatformSubordinateCriteria subordinateCriteria = new TbPdDeclarationPlatformSubordinateCriteria();
        List<TbPdDeclarationPlatformSubordinate> selectByPlatformSubordinateList = tbPdDeclarationPlatformSubordinateMapper.selectByExample(subordinateCriteria);
        return selectByPlatformSubordinateList;
    }
}
