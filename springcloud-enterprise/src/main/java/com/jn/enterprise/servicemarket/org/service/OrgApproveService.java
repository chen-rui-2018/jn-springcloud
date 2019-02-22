package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.model.OrgApply;
import com.jn.enterprise.servicemarket.model.OrgApplyCount;
import com.jn.enterprise.servicemarket.model.OrgApplyDetail;
import com.jn.enterprise.servicemarket.model.OrgApplyParameter;

import java.util.List;

/**
 * 服务机构认证审核接口
 * @author： jiangyl
 * @date： Created on 2019/2/21 15:44
 * @version： v1.0
 * @modified By:
 */
public interface OrgApproveService {

    /**
     * 查询机构审核认证列表
     * @param orgApplyParameter
     * @return
     */
    PaginationData getOrgApplyList(OrgApplyParameter orgApplyParameter);

    /**
     * 查询机构入驻数据
     * @return
     */
    OrgApplyCount getOrgCount();

    /**
     * 查询机构审核详情
     * @param orgId
     * @return
     */
    OrgApplyDetail getOrgApplyDetail(String orgId);



}
