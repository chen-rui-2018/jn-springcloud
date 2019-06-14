package org.xxpay.service.service;

/**
 * @ClassName：商户通知service层
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/5 10:10
 * @Version： v1.0
 * @Modified By:
 */
public interface MchNotifyService {

    /**
     * 保存商户通知
     * @param orderId 订单ID
     * @param mchId 商户ID
     * @param mchOrderNo 商户订单号
     * @param orderType 订单类型:1-支付,2-转账,3-退款
     * @param notifyUrl 通知地址
     * */
     int insertMchNotify(String orderId, String mchId, String mchOrderNo, String orderType, String notifyUrl) ;

    /**
     * 修改商户通知状态为成功
     * @param orderId 订单ID
     * @param result  通知响应结果
     * @param notifyCount 通知次数
     * */
     int updateMchNotifySuccess(String orderId, String result, byte notifyCount);

    /**
     * 修改商户通知状态为失败
     * @param orderId 订单ID
     * @param result  通知响应结果
     * @param notifyCount 通知次数
     * */
     int updateMchNotifyFail(String orderId, String result, byte notifyCount) ;
}
