package org.xxpay.web.service;

import org.xxpay.dal.dao.model.PayOrder;

/**
 * @ClassName：支付订单信息接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/11 15:54
 * @Version： v1.0
 * @Modified By:
 */
public interface PayOrderService {

    /**
     * 根据商户ID获取商户信息
     * @param payOrderId 支付系统订单ID
     * @return
    * */
    PayOrder getPayOrderById(String payOrderId);

}
