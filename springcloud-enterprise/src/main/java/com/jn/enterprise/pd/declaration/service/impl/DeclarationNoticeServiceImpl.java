package com.jn.enterprise.pd.declaration.service.impl;

import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationNoticeManageMapper;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationNoticeRangeMapper;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManage;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManageCriteria;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeRange;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeRangeCriteria;
import com.jn.enterprise.pd.declaration.enums.DeclaratStatusEnums;
import com.jn.enterprise.pd.declaration.service.DeclarationNoticeService;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceRange;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceRangeCriteria;
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

    @Autowired
    private TbPdDeclarationNoticeRangeMapper tbPdDeclarationNoticeRangeMapper;

    /**
     * 查询公告列表
     *
     * @param
     * @return
     */
    @Override
    public List<TbPdDeclarationNoticeManage> selectByDeclarationNoticeList(String rangeId,String sortType) {
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
        criteria.andRangeIdEqualTo(rangeId);
        List<TbPdDeclarationNoticeManage> selectByDeclarationNoticeList = tbPdDeclarationNoticeManageMapper.selectByExample(noticeCriteria);
        return selectByDeclarationNoticeList;
    }

    @Override
    public TbPdDeclarationNoticeManage selectByTalentNotice(String id) {
        return tbPdDeclarationNoticeManageMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询公告所属类型列表
     *
     * @param
     * @return
     */
    @Override
    public List<TbPdDeclarationNoticeRange> selectByNoticeRangeList() {
        TbPdDeclarationNoticeRangeCriteria rangeCriteria = new TbPdDeclarationNoticeRangeCriteria();
        List<TbPdDeclarationNoticeRange> selectByNoticeRangeList = tbPdDeclarationNoticeRangeMapper.selectByExample(rangeCriteria);
        return selectByNoticeRangeList;
    }

    /**
     * 用户点击查看一次公告，访问量加 1
     *
     * @param id
     * @return
     */
    @Override
    public void updateTrafficVolume(String id) {
        TbPdDeclarationNoticeManage noticeManage = new TbPdDeclarationNoticeManage();
        noticeManage = tbPdDeclarationNoticeManageMapper.selectByPrimaryKey(id);
        int trafficVolume = noticeManage.getBrowseTimes() + 1;
        noticeManage.setBrowseTimes(trafficVolume);
        tbPdDeclarationNoticeManageMapper.updateByPrimaryKey(noticeManage);
        logger.info("[申报中心公告访问量] 访问量更新成功，公告id:{}", id);
    }
}
