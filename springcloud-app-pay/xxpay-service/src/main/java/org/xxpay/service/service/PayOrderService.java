package org.xxpay.service.service;

import org.xxpay.dal.dao.model.PayOrder;

/**
 * @ClassName：支付订单service层
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/5 10:31
 * @Version： v1.0
 * @Modified By:
 */
public interface PayOrderService {

    /**
     * 新增订单
     * @param payOrder
    * */
     int createPayOrder(PayOrder payOrder);
    /**
     * 根据订单ID获取订单信息
     * @param payOrderId 订单ID
     * */
     PayOrder selectPayOrder(String payOrderId);
    /**
     * 根据 商户ID 和 订单ID 获取订单信息
     * @param mchId 商户ID
     * @param payOrderId 订单ID
     * */
     PayOrder selectPayOrderByMchIdAndPayOrderId(String mchId, String payOrderId) ;
    /**
     * 根据 商户ID 和 业务订单号 获取订单信息
     * @param mchId 商户ID
     * @param mchOrderNo 业务订单号
     * */
     PayOrder selectPayOrderByMchIdAndMchOrderNo(String mchId, String mchOrderNo) ;
    /**
     * 根据 订单ID 和 第三方支付系统订单ID 更新订单状态为：1-支付中
     * @param payOrderId 订单ID
     * @param channelOrderNo 第三方支付系统订单ID(可为空)
     * */
     int updateStatus4Ing(String payOrderId, String channelOrderNo) ;

    /**
     *修改支付订单状态为支付完成
     * 并且记录相关信息
     * @param payOrderParam 支付对象
     * */
     int updateStatus4Success(PayOrder payOrderParam) ;
     /**
      * 根据订单ID更新订单状态为 ：3-业务处理完成
      * @param payOrderId 订单ID
     * */
     int updateStatus4Complete(String payOrderId) ;
     /**
      * 根据订单ID更新订单通知次数
      * @param payOrderId 订单ID
      * @param count  通知次数
     * */
     int updateNotify(String payOrderId, byte count) ;

}
