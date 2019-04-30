package com.jn.enterprise.pd.declaration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationNoticeManageMapper;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationNoticeRangeMapper;
import com.jn.enterprise.pd.declaration.dao.TbPdDeclarationOnlineReservationManageMapper;
import com.jn.enterprise.pd.declaration.entity.*;
import com.jn.enterprise.pd.declaration.enums.DeclaratStatusEnums;
import com.jn.enterprise.pd.declaration.enums.PdStatusEnums;
import com.jn.enterprise.pd.declaration.model.DeclarationOnlineReservationManageModel;
import com.jn.enterprise.pd.declaration.service.DeclarationNoticeService;
import com.jn.enterprise.pd.talent.enums.SortEnums;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public PaginationData<List<TbPdDeclarationNoticeManage>> selectByDeclarationNoticeList(String rangeId, String sortType,String titleName,int page,int rows) {
        Page<Object> objects = PageHelper.startPage(page, rows);
        TbPdDeclarationNoticeManageCriteria noticeCriteria = new TbPdDeclarationNoticeManageCriteria();
        if(sortType.equals(SortEnums.RELEASETIME_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,created_time desc");
        }else if(sortType.equals(SortEnums.TIMENODE_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,deadline desc");
        }else if(sortType.equals(SortEnums.HEAT_SORT.getCode())){
            noticeCriteria.setOrderByClause("is_roof_placement asc,browse_times desc");
        }
        TbPdDeclarationNoticeManageCriteria.Criteria criteria = noticeCriteria.createCriteria();
        Byte status = Byte.parseByte(DeclaratStatusEnums.RELEASE.getCode());
        criteria.andStatusEqualTo(status);
        if(StringUtils.isNotEmpty(rangeId)) {  criteria.andRangeIdEqualTo(rangeId);}
        if(StringUtils.isNotEmpty(titleName)) {  criteria.andTitleNameLike('%'+titleName+'%');}
        return new PaginationData(tbPdDeclarationNoticeManageMapper.selectByExample(noticeCriteria), objects.getTotal());
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
