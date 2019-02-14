package com.jn.enterprise.servicemarket.advisor.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorInquiryInfo;

/**
 * 服务顾问
 * @Author: yangph
 * @Date: 2019/2/12 16:37
 * @Version v1.0
 * @modified By:
 */
public interface AdvisorService {
    /**
     * 服务顾问列表查询
     * @param advisorInquiryInfo 查询条件
     * @param needPage           是否需要分页
     * @return
     */
    PaginationData getServiceConsultantList(AdvisorInquiryInfo advisorInquiryInfo ,Boolean needPage);
}
