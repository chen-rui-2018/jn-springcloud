package com.jn.park.policy.service;

import com.jn.common.model.PaginationData;
import com.jn.park.policy.model.*;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/29 10:52
 * @Version v1.0
 * @modified By:
 */
public interface PolicyGuideService {
    /**
     * 政策管理
     * @param policyManagementParam
     * @return
     */
    PaginationData getPolicyManagementList(PolicyManagementParam policyManagementParam);

    /**
     * 政策管理编辑（新增/修改）
     * @param policyInfoEditParam
     * @param account 当前登录用户账号
     * @return
     */
    int saveOrUpdatePolicyInfo(PolicyInfoEditParam policyInfoEditParam,String account);

    /**
     * 获取政策编号
     * @return
     */
    String getPolicyCode();

    /**
     *  关联图解政策信息/关联政策原文信息
     * @param policyType  政策类型  0:普通政策/政策原文   1：图解政策
     * @return
     */
    List<PolicyInfoShow> getPolicyInfo(String policyType);

    /**
     * 政策上架/下架上架/下架
     * @param policyId 政策id
     * @param status  状态值，0：下架   1：上架
     * @param account 登录用户账号
     * @return
     */
    int shelfOrObtained(String policyId,String status,String account);

    /**
     * 获取普通政策详情
     * @param policyId 政策id
     * @return
     */
    PolicyGuideDetailsShow getPolicyGuidDetails(String policyId);

    /**
     * 图解政策管理
     * @param policyManagementParam
     * @return
     */
    PaginationData getDiagramPolicyManagementList(PolicyManagementParam policyManagementParam);

    /**
     * 图解政策管理编辑（新增/修改）
     * @param policyDiagramInfoEditParam
     * @param account   当前登录用户账号
     * @return
     */
    int saveOrUpdateDiagramPolicyInfo(PolicyDiagramInfoEditParam policyDiagramInfoEditParam,String account);

    /**
     * 获取图解政策详情
     * @param policyId 政策id
     * @return
     */
    PolicyGuideDiagramDetailsShow getPolicyGuidDiagramDetails(String policyId);
}
