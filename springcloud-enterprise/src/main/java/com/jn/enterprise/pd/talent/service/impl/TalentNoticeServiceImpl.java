package com.jn.enterprise.pd.talent.service.impl;

import com.jn.enterprise.pd.declaration.enums.DeclaratStatusEnums;
import com.jn.enterprise.pd.talent.dao.TbPdTalentServiceNoticeMapper;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNotice;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNoticeCriteria;
import com.jn.enterprise.pd.talent.enums.SortEnums;
import com.jn.enterprise.pd.talent.service.TalentNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人才服务公告管理业务层实现类
 *
 * @author： wzy
 * @date： Created on 2019/4/10 9:55
 * @version： v1.0
 * @modified By:
 */
@Service
public class TalentNoticeServiceImpl implements TalentNoticeService {

    private static Logger logger = LoggerFactory.getLogger(TalentNoticeServiceImpl.class);

    @Autowired
    private TbPdTalentServiceNoticeMapper tbPdTalentServiceNoticeMapper;


    /**
     * 查询公告列表
     *
     * @param
     * @return
     */
    @Override
    public List<TbPdTalentServiceNotice> selectByTalentNoticeList(String rangeName,String sortType) {
        TbPdTalentServiceNoticeCriteria noticeCriteria = new TbPdTalentServiceNoticeCriteria();
        if(sortType.equals(SortEnums.RELEASETIME_SORT)){
            noticeCriteria.setOrderByClause("modified_time desc");
        }else if(sortType.equals(SortEnums.TIMENODE_SORT)){
            noticeCriteria.setOrderByClause("deadline desc");
        }else if(sortType.equals(SortEnums.HEAT_SORT)){
            noticeCriteria.setOrderByClause("browse_times desc");
        }
        TbPdTalentServiceNoticeCriteria.Criteria criteria = noticeCriteria.createCriteria();
        Byte status = Byte.parseByte(DeclaratStatusEnums.RELEASE.getCode());
        criteria.andStatusEqualTo(status);
        criteria.andRangeNameEqualTo(rangeName);
        List<TbPdTalentServiceNotice> selectByTalentNoticeList = tbPdTalentServiceNoticeMapper.selectByExample(noticeCriteria);
        return selectByTalentNoticeList;
    }

}
