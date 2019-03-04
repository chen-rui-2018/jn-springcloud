package com.jn.enterprise.servicemarket.require.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.require.model.RequireOtherParam;
import com.jn.enterprise.servicemarket.require.model.RequireParam;
import com.jn.enterprise.servicemarket.require.model.RequireTechnologyParam;

/**
 * @Author: yangph
 * @Date: 2019/3/4 9:30
 * @Version v1.0
 * @modified By:
 */
public interface RequireManagementService {
    /**
     * 用户提需求(非科技金融)
     * @param requireParam 用户提需求入参
     * @param account      用户账号
     */
    void userDemand(RequireParam requireParam,String account);

    /**
     * 获取需求单号
     * @return
     */
     String getRequireNum();

    /***
     * 用户提需求(科技金融)
     * @param requireTechnologyParam 用户提需求入参
     * @param account                用户账号
     */
     void userDemandTechnology(RequireTechnologyParam requireTechnologyParam,String account);

    /**
     * 对他人的需求列表查询
     * @param requireOtherParam  对他人的需求查询条件
     * @param account            用户账号
     * @return
     */
     PaginationData getRequireOtherList(RequireOtherParam requireOtherParam,String account);
}
