package org.xxpay.web.service;

import org.xxpay.dal.dao.model.MchInfo;

/**
 * @ClassName：商户信息接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/11 15:54
 * @Version： v1.0
 * @Modified By:
 */
public interface MchInfoService {

    /**
     * 根据商户ID获取商户信息
     * @param mchId 商户ID
     * @return
    * */
    MchInfo getMchInfoById(String mchId);

    /**
     * 根据支付订单ID获取商户信息
     * @param payOrderId 商户ID
     * @return
     * */
    MchInfo getMchInfoByPayOrderId(String payOrderId);

}
