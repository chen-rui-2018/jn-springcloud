package com.jn.enterprise.recruit.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.recruit.model.ServiceRecruitEditParam;
import com.jn.enterprise.recruit.model.ServiceRecruitParam;
import com.jn.enterprise.recruit.model.ServiceRecruitPublishParam;
import com.jn.enterprise.recruit.vo.RecruitDetailsVO;
import com.jn.enterprise.recruit.vo.RecruitVO;

import java.util.List;

/**
 * 企业招聘Service
 * @author： huxw
 * @date： Created on 2019-3-29 15:22:54
 * @version： v1.0
 * @modified By:
 */
public interface RecruitService {

    /**
     * 根据ID获取招聘详情
     * @param id
     * @return
     */
    RecruitDetailsVO getRecruitDetailsById(String id);

    /**
     * 查询企业招聘信息列表
     * @param recruitParam
     * @return
     */
    PaginationData<List<RecruitVO>> getRecruitList(ServiceRecruitParam recruitParam);

    /**
     * 发布企业招聘信息
     * @param serviceRecruitPublishParam
     * @param comId 企业ID
     * @return
     */
    Integer publishRecruitInfo(ServiceRecruitPublishParam serviceRecruitPublishParam, String comId);

    /**
     * 编辑/下架 企业招聘信息
     * @param serviceRecruitEditParam
     * @return
     */
    Integer editRecruitInfo(ServiceRecruitEditParam serviceRecruitEditParam);

    /**
     * 根据ID删除企业招聘信息
     * @param id
     * @return
     */
    Integer delRecruitById(String id);

}
