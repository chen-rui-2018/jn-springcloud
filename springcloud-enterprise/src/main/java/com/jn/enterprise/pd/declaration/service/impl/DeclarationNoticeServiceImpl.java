package com.jn.enterprise.pd.declaration.service.impl;

import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationNoticeManageMapper;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManageCriteria;
import com.jn.enterprise.pd.declaration.enums.DeclaratStatusEnums;
import com.jn.enterprise.pd.declaration.service.DeclarationNoticeService;
import com.jn.enterprise.pd.talent.enums.SortEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 申报中心公告管理业务实现层
 *
 * @author： wzy
 * @date： Created on 2019/4/10 20:09
 * @version： v1.0
 * @modified By:
 */
@Service
public class DeclarationNoticeServiceImpl implements DeclarationNoticeService {

    private static Logger logger = LoggerFactory.getLogger(DeclarationNoticeServiceImpl.class);

    @Autowired
    private TbPdDeclarationNoticeManageMapper tbPdDeclarationNoticeManageMapper;

    /**
     * 查询公告列表
     *
     * @param
     * @return
     */
    @Override
    public List<TbPdDeclarationNoticeManage> selectByDeclarationNoticeList(String rangeName,String sortType) {
        TbPdDeclarationNoticeManageCriteria noticeCriteria = new TbPdDeclarationNoticeManageCriteria();
        if(sortType.equals(SortEnums.RELEASETIME_SORT)){
            noticeCriteria.setOrderByClause("modified_time desc");
        }else if(sortType.equals(SortEnums.TIMENODE_SORT)){
            noticeCriteria.setOrderByClause("deadline desc");
        }else if(sortType.equals(SortEnums.HEAT_SORT)){
            noticeCriteria.setOrderByClause("browse_times desc");
        }
        TbPdDeclarationNoticeManageCriteria.Criteria criteria = noticeCriteria.createCriteria();
        Byte status = Byte.parseByte(DeclaratStatusEnums.RELEASE.getCode());
        criteria.andStatusEqualTo(status);
        criteria.andRangeNameEqualTo(rangeName);
        List<TbPdDeclarationNoticeManage> selectByDeclarationNoticeList = tbPdDeclarationNoticeManageMapper.selectByExample(noticeCriteria);
        return selectByDeclarationNoticeList;
    }
}
