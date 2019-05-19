package org.xxpay.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.dal.dao.mapper.MchNotifyMapper;
import org.xxpay.dal.dao.model.MchNotify;
import org.xxpay.dal.dao.model.MchNotifyExample;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName：商户通知
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/4/24 17:03
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class MchNotifyService {

    @Autowired
    private MchNotifyMapper mchNotifyMapper;

    /**
     * 保存商户通知
     * @param orderId 订单ID
     * @param mchId 商户ID
     * @param mchOrderNo 商户订单号
     * @param orderType 订单类型:1-支付,2-转账,3-退款
     * @param notifyUrl 通知地址
     * */
    public int insertMchNotify(String orderId, String mchId, String mchOrderNo, String orderType, String notifyUrl) {
        MchNotify mchNotify = new MchNotify();
        mchNotify.setOrderId(orderId);
        mchNotify.setMchId(mchId);
        mchNotify.setMchOrderNo(mchOrderNo);
        mchNotify.setOrderType(orderType);
        mchNotify.setNotifyUrl(notifyUrl);
        return mchNotifyMapper.insertSelectiveOnDuplicateKeyUpdate(mchNotify);
    }

    /**
     * 修改商户通知状态为成功
     * @param orderId 订单ID
     * @param result  通知响应结果
     * @param notifyCount 通知次数
    * */
    public int updateMchNotifySuccess(String orderId, String result, byte notifyCount) {
        MchNotify mchNotify = new MchNotify();
        mchNotify.setStatus(PayConstant.MCH_NOTIFY_STATUS_SUCCESS);
        mchNotify.setResult(result);
        mchNotify.setNotifyCount(notifyCount);
        mchNotify.setLastNotifyTime(new Date());
        MchNotifyExample example = new MchNotifyExample();
        MchNotifyExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List values = new LinkedList<>();
        values.add(PayConstant.MCH_NOTIFY_STATUS_NOTIFYING);
        values.add(PayConstant.MCH_NOTIFY_STATUS_FAIL);
        criteria.andStatusIn(values);
        return mchNotifyMapper.updateByExampleSelective(mchNotify, example);
    }

    /**
     * 修改商户通知状态为失败
     * @param orderId 订单ID
     * @param result  通知响应结果
     * @param notifyCount 通知次数
     * */
    public int updateMchNotifyFail(String orderId, String result, byte notifyCount) {
        MchNotify mchNotify = new MchNotify();
        mchNotify.setStatus(PayConstant.MCH_NOTIFY_STATUS_FAIL);
        mchNotify.setResult(result);
        mchNotify.setNotifyCount(notifyCount);
        mchNotify.setLastNotifyTime(new Date());
        MchNotifyExample example = new MchNotifyExample();
        MchNotifyExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List values = new LinkedList<>();
        values.add(PayConstant.MCH_NOTIFY_STATUS_NOTIFYING);
        values.add(PayConstant.MCH_NOTIFY_STATUS_FAIL);
        return mchNotifyMapper.updateByExampleSelective(mchNotify, example);
    }
}
