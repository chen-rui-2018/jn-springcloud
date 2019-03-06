package com.jn.enterprise.servicemarket.require.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.require.model.*;

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
    int userDemand(RequireParam requireParam,String account);

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
     int userDemandTechnology(RequireTechnologyParam requireTechnologyParam,String account);

    /**
     * 对他人的需求列表查询
     * @param requireOtherParam  对他人的需求查询条件
     * @param account            用户账号
     * @return
     */
     PaginationData getRequireOtherList(RequireOtherParam requireOtherParam,String account);

    /**
     * 撤销对他人的需求
     * @param reqNum 需求单号
     * @return
     */
     int cancelRequire(String reqNum);

    /**
     * 需求详情（对他人需求）
     * @param reqNum 需求单号
     * @return
     */
    RequireOtherDetails getOtherRequireDetails(String reqNum);

    /**
     * 我收到的需求列表查询
     * @param requireReceivedParam  我收到的需求查询条件
     * @param account               用户账号
     * @return
     */
    PaginationData getRequireReceivedList(RequireReceivedParam requireReceivedParam,String account);

    /**
     * 对接需求操作
     * @param reqNum        需求单号
     * @param account       用户账号
     * @param advisorName   用户姓名
     * @return
     */
    int handleOperating(String reqNum,String account,String advisorName);

    /**
     * 需求详情（我收到的需求）
     * @param reqNum 需求单号
     * @return
     */
    RequireReceivedDetails getReceivedRequireDetails(String reqNum);

    /**
     * 对接需求（我收到的需求）
     * @param handleRequireParam   对接需求入参
     * @return
     */
    int handleRequire(HandleRequireParam handleRequireParam);

    /**
     * 需求管理列表查询（后台门户管理）
     * @param requirePortalParam  需求管理列表查询入参
     * @return
     */
    PaginationData getPortalRequireInfoList( RequirePortalParam requirePortalParam);

    /**
     * 需求详情（后台门户管理）
     * @param reqNum 需求编号
     * @return
     */
    RequirePortalDetails getPortalRequireDetails(String reqNum);
}
