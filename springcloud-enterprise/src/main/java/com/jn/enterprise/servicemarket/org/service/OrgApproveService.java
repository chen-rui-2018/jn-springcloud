package com.jn.enterprise.servicemarket.org.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyCountVo;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyDetailVo;
import com.jn.enterprise.servicemarket.org.vo.OrgApplyVo;

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
    PaginationData<List<OrgApplyVo>> getOrgApplyList(OrgApplyParameter orgApplyParameter);

    /**
     * 查询机构入驻数据
     * @return
     */
    OrgApplyCountVo getOrgCount();

    /**
     * 查询机构审核详情
     * @param orgId
     * @return
     */
    OrgApplyDetailVo getOrgApplyDetail(String orgId);

    /**
     * 机构申请审核
     * @param orgApplyCheckData
     * @return
     */
    Boolean checkOrgApply(OrgApplyCheckData orgApplyCheckData);

}
