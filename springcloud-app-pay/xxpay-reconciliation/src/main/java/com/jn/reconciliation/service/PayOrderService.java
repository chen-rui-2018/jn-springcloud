package com.jn.reconciliation.service;

import org.xxpay.dal.dao.model.PayOrder;

import java.util.List;

/**
 * @ClassName：支付订单查询接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/24 19:04
 * @Version： v1.0
 * @Modified By:
 */
public interface PayOrderService {

    /**
     * 根据日期和支付方式查询支付成功的订单
     * @param date 日期(格式： yyyy-mm-dd)
     * @param channelName 支付渠道
     * @
    * */
    List<PayOrder>  getPaySuccessOrderByDate(String date,String channelName);

    /**
     * 根据日期和支付方式查询所有订单
     * @param date 日期(格式： yyyy-mm-dd)
     *  @param channelName 支付渠道
     * */
    List<PayOrder>  getAllPayOrderByDate(String date,String channelName);
}
