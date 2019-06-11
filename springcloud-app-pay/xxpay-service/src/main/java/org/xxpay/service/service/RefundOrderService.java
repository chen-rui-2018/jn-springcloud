package org.xxpay.service.service;

import com.alibaba.fastjson.JSONObject;
import org.xxpay.dal.dao.model.RefundOrder;

/**
 * @ClassName：退款业务
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/5 10:56
 * @Version： v1.0
 * @Modified By:
 */
public interface RefundOrderService {

    /**
     * 创建退款订单
     * @param refundOrder 退款对象
     * */
     int createRefundOrder(RefundOrder refundOrder);

    /**
     * 根据退款订单ID获取退款信息
     * @param RefundOrderId 退款订单号
     * */
     RefundOrder selectRefundOrder(String RefundOrderId) ;

    /**
     *修改退款订单状态为 1-退款中
     * @param refundOrderId  退款订单号
     * @param channelOrderNo 渠道订单号
     * */
     int updateStatus4Ing(String refundOrderId, String channelOrderNo) ;

    /**
     *修改退款订单状态为 2-成功   退款结果为  2-成功
     * @param refundOrderId  退款订单号
     * @param channelOrderNo 渠道订单号
     * */
     int updateStatus4Success(String refundOrderId, String channelOrderNo) ;

    /**
     *修改退款订单状态为 3-退款失败   退款结果为  3-失败
     * @param refundOrderId  退款订单号
     * @param channelErrCode 渠道错误码
     * @param channelErrMsg  渠道错误描述
     * */
     int updateStatus4Fail(String refundOrderId, String channelErrCode, String channelErrMsg) ;
    /**
     *修改退款订单状态为 4-业务处理完成
     * @param refundOrderId  退款订单号
     * */
     int updateStatus4Complete(String refundOrderId) ;

    /**
     * 处理商户退款后台服务器通知
     * @param refundOrder 退款对象
     * @param isFirst  是否第一次通知
     */
     void doNotify(RefundOrder refundOrder, boolean isFirst) ;

    /**
     * 创建通知商户
     * 如果存在http方式回调 则不用springCloud方式
     * @param refundOrder 退款订单
     * @param isFirst  是否第一次通知
     * */
     JSONObject createNotifyInfo(RefundOrder refundOrder, boolean isFirst);

    /**
     * 创建响应URL
     * @param refundOrder
     * @param backType 1：前台页面；2：后台接口
     * @return
     */
     String createNotifyUrl(RefundOrder refundOrder, String backType) ;
}
