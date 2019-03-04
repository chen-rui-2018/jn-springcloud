package com.jn.enterprise.servicemarket.require.dao;

import com.jn.enterprise.servicemarket.require.model.RequireInfoList;
import com.jn.enterprise.servicemarket.require.model.RequireOtherParam;
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
}
