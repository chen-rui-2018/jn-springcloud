package org.xxpay.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.xxpay.dal.dao.mapper.PayChannelMapper;
import org.xxpay.dal.dao.model.PayChannel;
import org.xxpay.dal.dao.model.PayChannelExample;
import org.xxpay.service.service.PayChannelService;

import java.util.List;

/**
 * @ClassName：支付渠道service接口实现层
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/5 10:16
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class PayChannelServiceImpl implements PayChannelService {

    @Autowired
    private PayChannelMapper payChannelMapper;

    /**
     * 根据商户Id和渠道ID获取支付渠道信息
     * @param channelId 渠道ID
     * @param mchId 商户ID
     * */
    @Override
    public PayChannel selectPayChannel(String channelId, String mchId) {
        PayChannelExample example = new PayChannelExample();
        PayChannelExample.Criteria criteria = example.createCriteria();
        criteria.andChannelIdEqualTo(channelId);
        criteria.andMchIdEqualTo(mchId);
        List<PayChannel> payChannelList = payChannelMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(payChannelList)) return null;
        return payChannelList.get(0);
    }

}
