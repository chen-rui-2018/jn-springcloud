package org.xxpay.service.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.xxpay.common.constant.PayConstant;
import org.xxpay.common.util.MyLog;
import org.xxpay.dal.dao.mapper.PayOrderMapper;
import org.xxpay.dal.dao.model.PayOrder;
import org.xxpay.dal.dao.model.PayOrderExample;
import org.xxpay.service.service.PayOrderService;

import java.util.List;

/**
 * @ClassName：支付订单service接口实现层
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/5 10:31
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {

    /**
     * 日志
     * */
    private static final MyLog logger = MyLog.getLog(PayOrderServiceImpl.class);

    @Autowired
    private PayOrderMapper payOrderMapper;

    /**
     * 新增订单
     * @param payOrder
     * */
    @Override
    public int createPayOrder(PayOrder payOrder) {
        return payOrderMapper.insertSelective(payOrder);
    }
    /**
     * 根据订单ID获取订单信息
     * @param payOrderId 订单ID
     * */
    @Override
    public PayOrder selectPayOrder(String payOrderId) {
        return payOrderMapper.selectByPrimaryKey(payOrderId);
    }
    /**
     * 根据 商户ID 和 订单ID 获取订单信息
     * @param mchId 商户ID
     * @param payOrderId 订单ID
     * */
    @Override
    public PayOrder selectPayOrderByMchIdAndPayOrderId(String mchId, String payOrderId) {
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMchIdEqualTo(mchId);
        criteria.andPayOrderIdEqualTo(payOrderId);
        List<PayOrder> payOrderList = payOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(payOrderList) ? null : payOrderList.get(0);
    }
    /**
     * 根据 商户ID 和 业务订单号 获取订单信息
     * @param mchId 商户ID
     * @param mchOrderNo 业务订单号
     * */
    @Override
    public PayOrder selectPayOrderByMchIdAndMchOrderNo(String mchId, String mchOrderNo) {
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMchIdEqualTo(mchId);
        criteria.andMchOrderNoEqualTo(mchOrderNo);
        List<PayOrder> payOrderList = payOrderMapper.selectByExample(example);
        return CollectionUtils.isEmpty(payOrderList) ? null : payOrderList.get(0);
    }
    /**
     * 根据 订单ID 和 第三方支付系统订单ID 更新订单状态为：1-支付中
     * @param payOrderId 订单ID
     * @param channelOrderNo 第三方支付系统订单ID(可为空)
     * */
    @Override
    public int updateStatus4Ing(String payOrderId, String channelOrderNo) {
        PayOrder payOrder = new PayOrder();
        payOrder.setStatus(PayConstant.PAY_STATUS_PAYING);
        if(channelOrderNo != null) {
            payOrder.setChannelOrderNo(channelOrderNo);
        }
        payOrder.setPaySuccTime(System.currentTimeMillis());
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstant.PAY_STATUS_INIT);
        return payOrderMapper.updateByExampleSelective(payOrder, example);
    }

    /**
     *修改支付订单状态为支付完成
     * 并且记录相关信息
     * @param payOrderParam 支付对象
    * */
    @Override
    public int updateStatus4Success(PayOrder payOrderParam) {

        PayOrder updatePayOrder = new PayOrder();
        updatePayOrder.setPayOrderId(payOrderParam.getPayOrderId());
        //订单状态 为支付成功
        updatePayOrder.setStatus(PayConstant.PAY_STATUS_SUCCESS);
        //第三方支付单号
        if(StringUtils.isNotBlank(payOrderParam.getChannelOrderNo())){
            updatePayOrder.setChannelOrderNo(payOrderParam.getChannelOrderNo());
        }
        //商户支付费率
        if(null != payOrderParam.getPayRate()){
           updatePayOrder.setPayRate(payOrderParam.getPayRate());
        }
        //手续费
        if(null != payOrderParam.getPlatCost()){
            updatePayOrder.setPlatCost(payOrderParam.getPlatCost());
        }
        //商户实际收入
        if(null != payOrderParam.getRealIncomeAmount()){
            updatePayOrder.setRealIncomeAmount(payOrderParam.getRealIncomeAmount());
        }

        //支付成功时间
        updatePayOrder.setPaySuccTime(System.currentTimeMillis());
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderParam.getPayOrderId());
        criteria.andStatusEqualTo(PayConstant.PAY_STATUS_PAYING);
        return payOrderMapper.updateByExampleSelective(updatePayOrder, example);
    }
    /**
     * 根据订单ID更新订单状态为 ：3-业务处理完成
     * @param payOrderId 订单ID
     * */
    @Override
    public int updateStatus4Complete(String payOrderId) {
        PayOrder payOrder = new PayOrder();
        payOrder.setPayOrderId(payOrderId);
        payOrder.setStatus(PayConstant.PAY_STATUS_COMPLETE);
        PayOrderExample example = new PayOrderExample();
        PayOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPayOrderIdEqualTo(payOrderId);
        criteria.andStatusEqualTo(PayConstant.PAY_STATUS_SUCCESS);
        return payOrderMapper.updateByExampleSelective(payOrder, example);
    }
    /**
     * 根据订单ID更新订单通知次数
     * @param payOrderId 订单ID
     * @param count  通知次数
     * */
    @Override
    public int updateNotify(String payOrderId, byte count) {
        PayOrder newPayOrder = new PayOrder();
        // TODO 并发下次数问题待解决
        newPayOrder.setNotifyCount(count);
        newPayOrder.setLastNotifyTime(System.currentTimeMillis());
        newPayOrder.setPayOrderId(payOrderId);
        return payOrderMapper.updateByPrimaryKeySelective(newPayOrder);
    }

}
