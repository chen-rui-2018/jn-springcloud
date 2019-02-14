package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.model.ServiceOrgDetail;
import com.jn.enterprise.servicemarket.model.ServiceOrgParment;

/**
 * 服务机构service
 * @Author: jiangyl
 * @Date: 2019/2/13 10:37
 * @Version v1.0
 * @modified By:
 */
public interface ServiceOrgService {

    /**
     * 查询服务机构列表
     * @param orgParment
     * @return
     */
    PaginationData selectServiceOrgList(ServiceOrgParment orgParment);

    /**
     * 根据机构ID查询机构详情
     * @param orgId
     * @return
     */
    ServiceOrgDetail getServiceOrgDetail(String orgId);
}
