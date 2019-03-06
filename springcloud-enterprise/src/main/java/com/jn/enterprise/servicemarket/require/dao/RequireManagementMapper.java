package com.jn.enterprise.servicemarket.require.dao;

import com.jn.enterprise.servicemarket.require.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/4 19:59
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface RequireManagementMapper {
    /**
     *对他人的需求列表查询
     * @param requireOtherParam
     * @param account
     * @return
     */
    List<RequireInfoList> getRequireOtherList(RequireOtherParam requireOtherParam, @Param("account")String account);

    /**
     * 我收到的需求列表查询
     * @param requireReceivedParam
     * @param account
     * @param orgId
     * @return
     */
    List<RequireInfoList>getRequireReceivedList(RequireReceivedParam requireReceivedParam,@Param("account")String account,@Param("orgId")String orgId);

    /**
     * 需求管理列表查询（后台门户管理）
     * @param requirePortalParam 需求管理列表查询入参
     * @return
     */
    List<RequirePortalInfoList>getPortalRequireInfoList(RequirePortalParam requirePortalParam);

    /**
     * 需求详情（后台门户管理）
     * @param reqNum
     * @return
     */
    RequirePortalDetails getPortalRequireDetails(@Param("reqNum") String reqNum);
}
