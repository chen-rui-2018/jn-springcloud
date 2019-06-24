package com.jn.enterprise.pd.talent.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.pd.declaration.model.DeclarationPlatformModel;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceNotice;
import com.jn.enterprise.pd.talent.entity.TbPdTalentServiceRange;
import com.jn.enterprise.pd.talent.model.TalentNoticePlatformParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 人才服务公告管理service
 *
 * @author： wzy
 * @date： Created on 2019/4/10 9:54
 * @version： v1.0
 * @modified By:
 */
public interface TalentNoticeService {

    /**
     * 查询公告列表
     *
     * @param
     * @return
     */
    PaginationData<List<TbPdTalentServiceNotice>> selectByTalentNoticeList(String rangeId, String sortType,String noticeTitle,int page,int rows);

    /**
     * 根据ID查询公告详情
     *
     * @param
     * @return
     */
    TbPdTalentServiceNotice selectByTalentNotice(String id);

    /**
     * 查询所属公告类型列表
     *
     * @param
     * @return
     */
    List<TbPdTalentServiceRange> selectByTalentRangeList();

    /**
     * 更新公告访问量（用户点击查看一次公告，访问量加 1)
     *
     * @param
     * @return
     */
    void updateTrafficVolume(String id);

    /**
     * 人才服务-首页申报平台查询
     *
     * @param
     * @return
     */
    PaginationData<List<DeclarationPlatformModel>> queryPlatformInfo(TalentNoticePlatformParam talentNoticePlatformParam);


}
