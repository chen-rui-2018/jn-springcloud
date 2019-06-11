package org.xxpay.service.service;

import org.xxpay.dal.dao.model.PayChannel;

/**
 * @ClassName：支付渠道service层
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/5 10:16
 * @Version： v1.0
 * @Modified By:
 */
public interface PayChannelService {

    /**
     * 根据商户Id和渠道ID获取支付渠道信息
     * @param channelId 渠道ID
     * @param mchId 商户ID
    * */
    PayChannel selectPayChannel(String channelId, String mchId);
}
