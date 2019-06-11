package org.xxpay.service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jn.pay.model.RefundOrderNotify;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.BeanToMap;
import org.xxpay.common.util.MyLog;
import org.xxpay.common.util.PayDigestUtil;
import org.xxpay.common.util.XXPayUtil;
import org.xxpay.dal.dao.mapper.MchInfoMapper;
import org.xxpay.dal.dao.mapper.MchNotifyMapper;
import org.xxpay.dal.dao.mapper.RefundOrderMapper;
import org.xxpay.dal.dao.model.MchInfo;
import org.xxpay.dal.dao.model.MchNotify;
import org.xxpay.dal.dao.model.RefundOrder;
import org.xxpay.dal.dao.model.RefundOrderExample;
import org.xxpay.service.mq.Mq4MchRefundNotify;
import org.xxpay.service.service.MchInfoService;
import org.xxpay.service.service.MchNotifyService;
import org.xxpay.service.service.RefundOrderService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName：退款订单
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/4/23 17:03
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class RefundOrderServiceImpl implements RefundOrderService {

    @Autowired
    private RefundOrderMapper refundOrderMapper;

    @Autowired
    private MchInfoMapper mchInfoMapper;

    @Autowired
    private MchNotifyService mchNotifyService;

    @Autowired
    private MchNotifyMapper mchNotifyMapper;

    @Autowired
    private Mq4MchRefundNotify mq4MchRefundNotify;

    @Autowired
    private MchInfoService mchInfoService;
    /**
     * 日志
    * */
    private static final MyLog _log = MyLog.getLog(RefundOrderServiceImpl.class);

    /**
     * 创建退款订单
     * @param refundOrder 退款对象
    * */
    @Override
    public int createRefundOrder(RefundOrder refundOrder) {
        return refundOrderMapper.insertSelective(refundOrder);
    }
    /**
     * 根据退款订单ID获取退款信息
     * @param RefundOrderId 退款订单号
     * */
    @Override
    public RefundOrder selectRefundOrder(String RefundOrderId) {
        return refundOrderMapper.selectByPrimaryKey(RefundOrderId);
    }

    /**
     *修改退款订单状态为 1-退款中
     * @param refundOrderId  退款订单号
     * @param channelOrderNo 渠道订单号
    * */
    @Override
    public int updateStatus4Ing(String refundOrderId, String channelOrderNo) {
        RefundOrder refundOrder = new RefundOrder();
        refundOrder.setStatus(PayConstant.REFUND_STATUS_REFUNDING);
        if(channelOrderNo != null) {
            refundOrder.setChannelOrderNo(channelOrderNo);
        }
        refundOrder.setRefundSuccTime(new Date());
        RefundOrderExample example = new RefundOrderExample();
        RefundOrderExample.Criteria criteria = example.createCriteria();
        criteria.andRefundOrderIdEqualTo(refundOrderId);
        criteria.andStatusEqualTo(PayConstant.REFUND_STATUS_INIT);
        return refundOrderMapper.updateByExampleSelective(refundOrder, example);
    }

    /**
     *修改退款订单状态为 2-成功   退款结果为  2-成功
     * @param refundOrderId  退款订单号
     * @param channelOrderNo 渠道订单号
     * */
    @Override
    public int updateStatus4Success(String refundOrderId, String channelOrderNo) {
        RefundOrder refundOrder = new RefundOrder();
        refundOrder.setRefundOrderId(refundOrderId);
        refundOrder.setStatus(PayConstant.REFUND_STATUS_SUCCESS);
        refundOrder.setResult(PayConstant.REFUND_RESULT_SUCCESS);
        refundOrder.setRefundSuccTime(new Date());
        if(StringUtils.isNotBlank(channelOrderNo)) {
            refundOrder.setChannelOrderNo(channelOrderNo);
        }
        RefundOrderExample example = new RefundOrderExample();
        RefundOrderExample.Criteria criteria = example.createCriteria();
        criteria.andRefundOrderIdEqualTo(refundOrderId);
        criteria.andStatusEqualTo(PayConstant.REFUND_STATUS_REFUNDING);
        return refundOrderMapper.updateByExampleSelective(refundOrder, example);
    }

    /**
     *修改退款订单状态为 3-退款失败   退款结果为  3-失败
     * @param refundOrderId  退款订单号
     * @param channelErrCode 渠道错误码
     * @param channelErrMsg  渠道错误描述
     * */
    @Override
    public int updateStatus4Fail(String refundOrderId, String channelErrCode, String channelErrMsg) {
        RefundOrder refundOrder = new RefundOrder();
        refundOrder.setStatus(PayConstant.REFUND_STATUS_FAIL);
        refundOrder.setResult(PayConstant.REFUND_RESULT_FAIL);
        if(channelErrCode != null) {
            refundOrder.setChannelErrCode(channelErrCode);
        }
        if(channelErrMsg != null) {
            refundOrder.setChannelErrMsg(channelErrMsg);
        }
        RefundOrderExample example = new RefundOrderExample();
        RefundOrderExample.Criteria criteria = example.createCriteria();
        criteria.andRefundOrderIdEqualTo(refundOrderId);
        criteria.andStatusEqualTo(PayConstant.REFUND_STATUS_REFUNDING);
        return refundOrderMapper.updateByExampleSelective(refundOrder, example);
    }
    /**
     *修改退款订单状态为 4-业务处理完成
     * @param refundOrderId  退款订单号
     * */
    @Override
    public int updateStatus4Complete(String refundOrderId) {
        RefundOrder refundOrder = new RefundOrder();
        refundOrder.setRefundOrderId(refundOrderId);
        refundOrder.setStatus(PayConstant.REFUND_STATUS_COMPLETE);
        RefundOrderExample example = new RefundOrderExample();
        RefundOrderExample.Criteria criteria = example.createCriteria();
        criteria.andRefundOrderIdEqualTo(refundOrderId);
        List values = CollectionUtils.arrayToList(new Byte[] {
                PayConstant.REFUND_STATUS_SUCCESS, PayConstant.REFUND_STATUS_FAIL
        });
        criteria.andStatusIn(values);
        return refundOrderMapper.updateByExampleSelective(refundOrder, example);
    }

    /**
     * 处理商户退款后台服务器通知
     * @param refundOrder 退款对象
     * @param isFirst  是否第一次通知
     */
    @Override
    public void doNotify(RefundOrder refundOrder, boolean isFirst) {
        _log.info(">>>>>> REFUND开始回调通知业务系统 <<<<<<");
        // 发起后台通知业务系统
        JSONObject object = createNotifyInfo(refundOrder, isFirst);
        try {
            mq4MchRefundNotify.send(object.toJSONString());
        } catch (Exception e) {
            _log.error(e, "refundOrderId=%s,sendMessage error.", ObjectUtils.defaultIfNull(refundOrder.getRefundOrderId(), ""));
        }
        _log.info(">>>>>> REFUND回调通知业务系统完成 <<<<<<");
    }

    /**
     * 创建通知商户
     * 如果存在http方式回调 则不用springCloud方式
     * @param refundOrder 退款订单
     * @param isFirst  是否第一次通知
     * */
    @Override
    public JSONObject createNotifyInfo(RefundOrder refundOrder, boolean isFirst) {
        //http回调通知地址
        String url = "";
        //springCloud 回调通知地址
        String serviceId  = "";
        String serviceUrl  = "";
        RefundOrderNotify refundOrderNotify = new RefundOrderNotify();

        //如果存在http方式回调 则不用springCloud方式
        if(StringUtils.isNotBlank(refundOrder.getNotifyUrl())){
            url = createNotifyUrl(refundOrder, PayConstant.MCH_NOTICE_BACKSTAGE);
        }else{
            //springClound回调参数
            serviceId = refundOrder.getServiceId();
            serviceUrl = refundOrder.getServiceUrl();
            //把值赋予返回对象
            BeanUtils.copyProperties(refundOrder, refundOrderNotify);
            refundOrderNotify.setBackType(PayConstant.MCH_NOTICE_BACKSTAGE);
            //生成签名
            MchInfo mchInfo = mchInfoService.selectMchInfo(refundOrderNotify.getMchId());
            String resKey = mchInfo.getResKey();
            String sign = PayDigestUtil.getSign(BeanToMap.toMap(refundOrderNotify), resKey);
            refundOrderNotify.setSign(sign);

        }

        if(isFirst) {
            int result = mchNotifyService.insertMchNotify(refundOrder.getRefundOrderId(), refundOrder.getMchId(), refundOrder.getMchRefundNo(), PayConstant.MCH_NOTIFY_TYPE_REFUND, url);
            _log.info("增加商户通知记录,orderId={},result:{}", refundOrder.getRefundOrderId(), result);
        }
        int count = 0;
        if(!isFirst) {
            MchNotify mchNotify = mchNotifyMapper.selectByPrimaryKey(refundOrder.getRefundOrderId());
            if(mchNotify != null) {
                count = mchNotify.getNotifyCount();
            }
        }
        JSONObject object = new JSONObject();
        object.put("method", "GET");
        object.put("url", url);
        object.put("orderId", refundOrder.getRefundOrderId());
        object.put("count", count);
        object.put("createTime", System.currentTimeMillis());
        object.put("serviceId", serviceId);
        object.put("serviceUrl", serviceUrl);
        object.put("payOrderJson", JSONObject.toJSON(refundOrderNotify));
        return object;
    }

    /**
     * 创建响应URL
     * @param refundOrder
     * @param backType 1：前台页面；2：后台接口
     * @return
     */
    @Override
    public String createNotifyUrl(RefundOrder refundOrder, String backType) {
        String mchId = refundOrder.getMchId();
        MchInfo mchInfo = mchInfoMapper.selectByPrimaryKey(mchId);
        String resKey = mchInfo.getResKey();
        Map<String, Object> paramMap = new HashMap<>();
        // 退款订单号
        paramMap.put("refundOrderId", ObjectUtils.defaultIfNull(refundOrder.getRefundOrderId(), ""));
        // 商户ID
        paramMap.put("mchId", ObjectUtils.defaultIfNull(refundOrder.getMchId(), ""));
        // 商户订单号
        paramMap.put("mchOrderNo", ObjectUtils.defaultIfNull(refundOrder.getMchRefundNo(), ""));
        // 渠道ID
        paramMap.put("channelId", ObjectUtils.defaultIfNull(refundOrder.getChannelId(), ""));
        // 退款金额
        paramMap.put("refundAmount", ObjectUtils.defaultIfNull(refundOrder.getRefundAmount(), ""));
        // 货币类型
        paramMap.put("currency", ObjectUtils.defaultIfNull(refundOrder.getCurrency(), ""));
        // 退款状态
        paramMap.put("status", ObjectUtils.defaultIfNull(refundOrder.getStatus(), ""));
        // 退款结果
        paramMap.put("result", ObjectUtils.defaultIfNull(refundOrder.getResult(), ""));
        // 客户端IP
        paramMap.put("clientIp", ObjectUtils.defaultIfNull(refundOrder.getClientIp(), ""));
        // 设备
        paramMap.put("device", ObjectUtils.defaultIfNull(refundOrder.getDevice(), ""));
        // 渠道订单号
        paramMap.put("channelOrderNo", ObjectUtils.defaultIfNull(refundOrder.getChannelOrderNo(), ""));
        // 扩展参数1
        paramMap.put("param1", ObjectUtils.defaultIfNull(refundOrder.getParam1(), ""));
        // 扩展参数2
        paramMap.put("param2", ObjectUtils.defaultIfNull(refundOrder.getParam2(), ""));
        // 退款成功时间
        paramMap.put("refundSuccTime", ObjectUtils.defaultIfNull(refundOrder.getRefundSuccTime().getTime(), ""));
        paramMap.put("backType", backType==null ? "" : backType);
        // 先对原文签名
        String reqSign = PayDigestUtil.getSign(paramMap, resKey);
        // 签名
        paramMap.put("sign", reqSign);
        // 签名后再对有中文参数编码
        try {
            paramMap.put("device", URLEncoder.encode(ObjectUtils.defaultIfNull(refundOrder.getDevice(), ""), PayConstant.RESP_UTF8));
            paramMap.put("param1", URLEncoder.encode(ObjectUtils.defaultIfNull(refundOrder.getParam1(), ""), PayConstant.RESP_UTF8));
            paramMap.put("param2", URLEncoder.encode(ObjectUtils.defaultIfNull(refundOrder.getParam2(), ""), PayConstant.RESP_UTF8));
        }catch (UnsupportedEncodingException e) {
            _log.error("URL Encode exception.", e);
            return null;
        }
        String param = XXPayUtil.genUrlParams(paramMap);
        StringBuffer sb = new StringBuffer();
        sb.append(refundOrder.getNotifyUrl()).append("?").append(param);
        return sb.toString();
    }
}
