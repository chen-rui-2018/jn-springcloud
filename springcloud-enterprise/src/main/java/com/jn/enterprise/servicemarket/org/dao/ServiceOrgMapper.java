package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.model.ServiceOrg;
import com.jn.enterprise.servicemarket.model.ServiceOrgDetail;
import com.jn.enterprise.servicemarket.model.ServiceOrgParment;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/13 14:58
 * @version： v1.0
 * @modified By:
 */
public interface ServiceOrgMapper {

    /**
     * 查询服务机构列表
     * @param parment
     * @return
     */
    List<ServiceOrg> selectServiceOrgList(ServiceOrgParment parment);

    /**
     * 根据机构ID查询机构详情
     * @param orgId
     * @return
     */
    ServiceOrgDetail getServiceOrgDetail(String orgId);

}
