package org.xxpay.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.mapper.PayOrderMapper;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.web.service.PayOrderService;

/**
 * @ClassName：支付订单信息实现类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/16 9:39
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Override
    public PayOrder getPayOrderById(String payOrderId) {
        return payOrderMapper.selectByPrimaryKey(payOrderId);
    }
}
