package com.jn.enterprise.company.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.company.entity.TbServiceRecruit;
import com.jn.enterprise.company.model.ServiceRecruitEditParam;
import com.jn.enterprise.company.model.ServiceRecruitParam;
import com.jn.enterprise.company.model.ServiceRecruitPublishParam;
import com.jn.enterprise.company.model.ServiceRecruitUnderParam;
import com.jn.enterprise.company.vo.RecruitVO;

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
    RecruitVO getRecruitDetailsById(String id, String curAccount);

    /**
     * 根据编号获取招聘详情
     * @param no
     * @return
     */
    TbServiceRecruit getRecruitByNo(String no);

    /**
     * 查询企业招聘信息列表
     * @param recruitParam
     * @return
     */
    PaginationData<List<RecruitVO>> getRecruitList(ServiceRecruitParam recruitParam, String approvalStatus);

    /**
     * 发布企业招聘信息
     * @param serviceRecruitPublishParam
     * @param curAccount 当前账号
     * @return
     */
    Integer publishRecruitInfo(ServiceRecruitPublishParam serviceRecruitPublishParam, String curAccount);

    /**
     * 编辑企业招聘信息
     * @param serviceRecruitEditParam
     * @return
     */
    Integer editRecruitInfo(ServiceRecruitEditParam serviceRecruitEditParam, String curAccount);

    /**
     * 上/下架企业招聘信息
     * @param serviceRecruitUnderParam
     * @return
     */
    Integer underRecruit(ServiceRecruitUnderParam serviceRecruitUnderParam, String curAccount);

    /**
     * 根据ID删除企业招聘信息
     * @param id
     * @return
     */
    Integer delRecruitById(String id, String curAccount);

}
