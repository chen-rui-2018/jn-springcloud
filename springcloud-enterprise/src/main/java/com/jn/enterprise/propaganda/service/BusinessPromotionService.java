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
}
