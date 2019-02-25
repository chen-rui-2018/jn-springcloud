package com.jn.enterprise.servicemarket.org.dao;

import com.jn.enterprise.servicemarket.model.OrgApplyDetail;
import org.apache.ibatis.annotations.Param;

/**
 * 服务机构认证审核Mapper
 * @author： jiangyl
 * @date： Created on 2019/2/22 14:50
 * @version： v1.0
 * @modified By:
 */
public interface OrgApproveMapper {

    /**
     * 查询服务机构审核详细资料信息
     * @param orgId
     * @return
     */
    OrgApplyDetail getOrgApplyDetailById(@Param("orgId") String orgId);

}
