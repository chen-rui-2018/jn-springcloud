package com.jn.enterprise.pd.talent.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.pd.declaration.entity.TbPdDeclarationNoticeManage;
import com.jn.enterprise.pd.declaration.enums.DeclaratStatusEnums;
import com.jn.enterprise.pd.talent.dao.TbPdTalentServiceNoticeMapper;
import com.jn.enterprise.pd.talent.dao.TbPdTalentServiceRangeMapper;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNotice;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNoticeCriteria;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceRange;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceRangeCriteria;
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

    @Autowired
    private TbPdTalentServiceRangeMapper tbPdTalentServiceRangeMapper;


    /**
     * 查询公告列表
     *
     * @param
     * @return
     */
    @Override
    public PaginationData<List<TbPdTalentServiceNotice>> selectByTalentNoticeList(String rangeId, String sortType,String noticeTitle,int page,int rows) {
        Page<Object> objects = PageHelper.startPage(page, rows);
        TbPdTalentServiceNoticeCriteria noticeCriteria = new TbPdTalentServiceNoticeCriteria();
        if(sortType.equals(SortEnums.RELEASETIME_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,modified_time desc");
        }else if(sortType.equals(SortEnums.TIMENODE_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,deadline desc");
        }else if(sortType.equals(SortEnums.HEAT_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,browse_times desc");
        }
        TbPdTalentServiceNoticeCriteria.Criteria criteria = noticeCriteria.createCriteria();
        Byte status = Byte.parseByte(DeclaratStatusEnums.RELEASE.getCode());
        criteria.andStatusEqualTo(status);
        if(StringUtils.isNotEmpty(rangeId)) {  criteria.andRangeIdEqualTo(rangeId);}
        if(StringUtils.isNotEmpty(noticeTitle)) {  criteria.andNoticeTitleLike('%'+noticeTitle+'%');}
        return new PaginationData(tbPdTalentServiceNoticeMapper.selectByExample(noticeCriteria), objects.getTotal());
    }

    /**
     * 根据ID查询公告详情
     *
     * @param
     * @return
     */
    @Override
    public TbPdTalentServiceNotice selectByTalentNotice(String id) {
        return tbPdTalentServiceNoticeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询公告所属类型列表
     *
     * @param
     * @return
     */
    @Override
    public List<TbPdTalentServiceRange> selectByTalentRangeList() {
        TbPdTalentServiceRangeCriteria rangeCriteria = new TbPdTalentServiceRangeCriteria();
        List<TbPdTalentServiceRange> selectByTalentRangeList = tbPdTalentServiceRangeMapper.selectByExample(rangeCriteria);
        return selectByTalentRangeList;
    }

    /**
     * 更新公告访问量（用户点击查看一次公告，访问量加 1)
     *
     * @param
     * @return
     */
    @Override
    public void updateTrafficVolume(String id) {
        TbPdTalentServiceNotice notice = new TbPdTalentServiceNotice();
        notice = tbPdTalentServiceNoticeMapper.selectByPrimaryKey(id);
        int trafficVolume = notice.getBrowseTimes() + 1;
        notice.setBrowseTimes(trafficVolume);
        tbPdTalentServiceNoticeMapper.updateByPrimaryKey(notice);
        logger.info("[人才服务-公告访问量] 访问量更新成功，公告id:{}", id);
    }

}
