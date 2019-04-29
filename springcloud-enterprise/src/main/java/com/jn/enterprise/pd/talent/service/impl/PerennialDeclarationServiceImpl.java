package com.jn.enterprise.pd.talent.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.pd.declaration.enums.PdStatusEnums;
import com.jn.enterprise.pd.talent.dao.TbPdPerennialDeclarationMapper;
import com.jn.enterprise.pd.talent.entity.TbPdPerennialDeclaration;
import com.jn.enterprise.pd.talent.entity.TbPdPerennialDeclarationCriteria;
import com.jn.enterprise.pd.talent.service.PerennialDeclarationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目申报-常年申报
 *
 * @author： wzy
 * @date： Created on 2019/4/28 11:20
 * @version： v1.0
 * @modified By:
 */
@Service
public class PerennialDeclarationServiceImpl implements PerennialDeclarationService {

    private static Logger logger = LoggerFactory.getLogger(PerennialDeclarationServiceImpl.class);

    @Autowired
    private TbPdPerennialDeclarationMapper tbPdPerennialDeclarationMapper;

    @Override
    public PaginationData<List<TbPdPerennialDeclaration>> selectByPerennialDeclarationList(String title, String policyType, String zoneApplication, int page, int rows) {
        Page<Object> objects = PageHelper.startPage(page, rows);
        TbPdPerennialDeclarationCriteria declarationCriteria = new TbPdPerennialDeclarationCriteria();
        TbPdPerennialDeclarationCriteria.Criteria criteria = declarationCriteria.createCriteria();
        Byte status = Byte.parseByte(PdStatusEnums.EFFECTIVE.getCode());
        criteria.andRecordStatusEqualTo(status);
        if(StringUtils.isNotEmpty(policyType)) {  criteria.andPolicyTypeLike('%'+policyType+'%');}
        if(StringUtils.isNotEmpty(zoneApplication)) {  criteria.andZoneApplicationLike('%'+zoneApplication+'%');}
        if(StringUtils.isNotEmpty(title)) {  criteria.andTitleLike('%'+title+'%');}
        return new PaginationData(tbPdPerennialDeclarationMapper.selectByExample(declarationCriteria), objects.getTotal());
    }
}
