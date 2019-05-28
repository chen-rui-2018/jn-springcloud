package com.jn.reconciliation.service.impl;

import com.jn.reconciliation.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxpay.dal.dao.mapper.PayOrderMapper;
import org.xxpay.dal.dao.model.PayOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName：支付订单查询接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/24 19:04
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {

    @Autowired
    private PayOrderMapper payOrderMapper;

    /**
     * 根据日期和支付方式查询支付成功的订单
     * @param date 日期(格式： yyyy-mm-dd)
     * @param channelName 支付渠道
     * @param channelName 支付方式(ALIPAY 或 WX)
     * */
    @Override
    public List<PayOrder> getPaySuccessOrderByDate(String date, String channelName) {
        Map<String,Object> param = new HashMap<>();
        param.put("date",date);
        param.put("channelName",channelName);
        return payOrderMapper.getPaySuccessOrderByDate(param);
    }

    /**
     * 根据日期和支付方式查询所有订单
     * @param date 日期(格式： yyyy-mm-dd)
     * @param channelName 支付方式(ALIPAY 或 WX)
     * */
    @Override
    public List<PayOrder> getAllPayOrderByDate(String date, String channelName) {
        Map<String,Object> param = new HashMap<>();
        param.put("date",date);
        param.put("channelName",channelName);
        return payOrderMapper.getAllPayOrderByDate(param);
    }
}
