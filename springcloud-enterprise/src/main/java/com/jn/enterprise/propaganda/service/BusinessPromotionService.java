package com.jn.enterprise.propaganda.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.propaganda.model.*;

import java.util.List;

/**
 * 用户中心--企业宣传
 * @Author: yangph
 * @Date: 2019/4/18 9:44
 * @Version v1.0
 * @modified By:
 */
public interface BusinessPromotionService {
    /**
     * 企业宣传列表查询
     * @param businessPromotionListParam
     * @param loginAccount 登录用户账号
     * @return
     */
    PaginationData getBusinessPromotionList(BusinessPromotionListParam businessPromotionListParam,String loginAccount);

    /**
     * 企业宣传详情
     * @param propagandaId 宣传id
     * @return
     */
    BusinessPromotionDetailsShow getBusinessPromotionDetails(String propagandaId);

    /**
     * 发布宣传
     * @param businessPromotionDetailsParam
     * @param loginAccount 登录用户账号
     * @return
     */
    int saveBusinessPromotion(BusinessPromotionDetailsParam businessPromotionDetailsParam,String loginAccount);

    /**
     * 获取宣传费用规则
     * @return
     */
    List<PropagandaFeeRulesShow> getPropagandaFeeRulesList();

    /**
     * 获取宣传类型
     * @param loginAccount 登录用户账号
     * @return
     */
    List<PropagandaTypeShow> getPropagandaTypeList(String loginAccount);

    /**
     * 撤销申请
     * @param propagandaId    宣传id
     * @param loginAccount   登录用户账号
     * @return
     */
    int cancelApprove(String propagandaId,String loginAccount);

    /**
     * 修改企业宣传
     * @param businessPromotionDetailsParam
     * @param loginAccount 登录用户账号
     * @return
     */
    int updateBusinessPromotion(BusinessPromotionDetailsParam businessPromotionDetailsParam,String loginAccount);

    /**
     * 生成订单号
     * @return
     */
    String getOrderNumber();

    /**
     * 修改审批状态
     * @param propagandaId  宣传id
     * @param approvalStatus        审批状态 (-1：未付款  0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)
     * @param loginAccount 登录用户账号
     * @return
     */
    int updateApprovalStatus(String propagandaId,String approvalStatus,String loginAccount);

    /**
     * 创建账单
     * @param orderNum      订单号
     * @param loginAccount  登录用户账号
     * @return
     */
    String createBill(String orderNum,String loginAccount);

    /**
     * 提交审核
     * @param propagandaId 宣传id
     * @param loginAccount 登录用户账号
     */
    void submitAudit(String propagandaId,String loginAccount);

    /**
     * 获取宣传区域信息
     * @return
     */
    List<PropagandaAreaShow> getPropagandaAreaList();

    /**
     *门户各首页企业宣传列表查询
     * @param businessHomePageParam
     * @param loginAccount
     * @return
     */
    PaginationData getBusinessPromotionList(BusinessHomePageParam businessHomePageParam,String loginAccount);
}
