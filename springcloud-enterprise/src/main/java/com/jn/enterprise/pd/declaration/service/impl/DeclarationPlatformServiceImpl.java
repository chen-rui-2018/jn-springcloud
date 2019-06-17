package com.jn.enterprise.pd.declaration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationPlatformManageDao;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationPlatformManageMapper;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationPlatformMemorandumMapper;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationPlatformSubordinateMapper;
import com.jn.enterprise.pd.declaration.entity.*;
import com.jn.enterprise.pd.declaration.enums.DeclaratStatusEnums;
import com.jn.enterprise.pd.declaration.model.DeclarationPlatformModel;
import com.jn.enterprise.pd.declaration.service.DeclarationPlatformService;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private TbPdDeclarationPlatformMemorandumMapper tbPdDeclarationPlatformMmorandumMapper;

    @Autowired
    private TbPdDeclarationPlatformManageDao tbPdDeclarationPlatformManageDao;



    @Override
    public PaginationData<List<DeclarationPlatformModel>> selectByDeclarationPlatformList(String subordinatePlatformName, String platformTitle, int page, int rows,User user) {
        DeclarationPlatformModel pm = new DeclarationPlatformModel();
        Page<Object> objects = PageHelper.startPage(page, rows);
        pm.setPlatformTitle(platformTitle);
        pm.setSubordinatePlatformName(subordinatePlatformName);
        pm.setCreatorAccount(user.getAccount());
        return new PaginationData(tbPdDeclarationPlatformManageDao.selectByExample(pm), objects.getTotal());
    }

    @Override
    public List<TbPdDeclarationPlatformSubordinate> selectByPlatformSubordinateList() {
        TbPdDeclarationPlatformSubordinateCriteria subordinateCriteria = new TbPdDeclarationPlatformSubordinateCriteria();
        List<TbPdDeclarationPlatformSubordinate> selectByPlatformSubordinateList = tbPdDeclarationPlatformSubordinateMapper.selectByExample(subordinateCriteria);
        return selectByPlatformSubordinateList;
    }

    @Override
    public void addOrEditMemorandum(String platformId, String accountAndPassword, User user) {
        TbPdDeclarationPlatformMemorandumCriteria memorandumCriteria = new TbPdDeclarationPlatformMemorandumCriteria();
        TbPdDeclarationPlatformMemorandumCriteria.Criteria criteria = memorandumCriteria.createCriteria();
        criteria.andPlatformIdEqualTo(platformId);
        criteria.andCreatorAccountEqualTo(user.getAccount());
        List<TbPdDeclarationPlatformMemorandum> data = tbPdDeclarationPlatformMmorandumMapper.selectByExample(memorandumCriteria);
        if(data.size() >0){
            //修改
            TbPdDeclarationPlatformMemorandum memorandum = data.get(0);
            memorandum.setAccountAndPassword(accountAndPassword);
            memorandum.setModifierAccount(user.getAccount());
            memorandum.setModifiedTime(new Date());
            tbPdDeclarationPlatformMmorandumMapper.updateByPrimaryKeySelective(memorandum);
        }else{
            //新增
            TbPdDeclarationPlatformMemorandum pm = new TbPdDeclarationPlatformMemorandum();
            pm.setId(UUID.randomUUID().toString());
            pm.setPlatformId(platformId);
            pm.setAccountAndPassword(accountAndPassword);
            pm.setCreatorAccount(user.getAccount());
            pm.setCreatedTime(new Date());
            tbPdDeclarationPlatformMmorandumMapper.insertSelective(pm);
        }

    }
}
