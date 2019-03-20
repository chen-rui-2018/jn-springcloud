package com.jn.unionpay.payremind.service.impl;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.PayBillEntryCallbackParam;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.unionpay.paybill.dao.TbPaymentBillMapper;
import com.jn.unionpay.paybill.entity.TbPaymentBill;
import com.jn.unionpay.paybill.entity.TbPaymentBillCriteria;
import com.jn.unionpay.paybill.enums.PayBillEnum;
import com.jn.unionpay.payremind.dao.PaymentRemindMapper;
import com.jn.unionpay.payremind.dao.TbPaymentRemindMapper;
import com.jn.unionpay.payremind.entity.TbPaymentRemind;
import com.jn.unionpay.payremind.entity.TbPaymentRemindCriteria;
import com.jn.unionpay.payremind.model.PayBillEntryParam;
import com.jn.unionpay.payremind.model.PayRemindCheckParam;
import com.jn.unionpay.payremind.model.PayRemindParam;
import com.jn.unionpay.payremind.model.PayRemindVO;
import com.jn.unionpay.payremind.service.PayRemindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/15 17:07
 * @version： v1.0
 * @modified By:
 */
@Service
public class PayRemindServiceImpl implements PayRemindService {
    private static Logger logger = LoggerFactory.getLogger(PayRemindServiceImpl.class);

    @Autowired
    private TbPaymentRemindMapper tbPaymentRemindMapper;
    @Autowired
    private TbPaymentBillMapper tbPaymentBillMapper;
    @Autowired
    private PaymentRemindMapper paymentRemindMapper;

    private static final int AMOUNT_DOUBLE_FORMAT = 2;

    @Override
    @ServiceLog(doAction = "保存账单核对提醒信息")
    @Transactional(rollbackFor = RuntimeException.class)
    public int saveCheckRemind(PayRemindParam payRemindParam,String account){
        if(null == payRemindParam.getBillIds() || payRemindParam.getBillIds().length == 0){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_ID_IS_NOT_NULL);
        }
        TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
        billCriteria.createCriteria().andBillIdIn(Arrays.asList(payRemindParam.getBillIds())).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        List<TbPaymentBill> tbPaymentBills = tbPaymentBillMapper.selectByExample(billCriteria);
        if(tbPaymentBills.size()!=payRemindParam.getBillIds().length){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_IS_NOT_EXIT,"选择账单数: "+payRemindParam.getBillIds().length
                    +" 与实际有效账单数: "+tbPaymentBills.size()+" 不匹配，请刷新页面再试。");
        }
        BigDecimal totalAmount = new BigDecimal(0);
        List<String> billIdList = new ArrayList<>(16);
        for (TbPaymentBill bill:tbPaymentBills) {
            totalAmount = totalAmount.add(new BigDecimal(bill.getBillAmount()));
            billIdList.add(bill.getBillId());
            if(StringUtils.equals(bill.getBillStatus(),PayBillEnum.BILL_ORDER_PAY_CHECKED.getCode())){
                throw new JnSpringCloudException(PayBillExceptionEnum.CHECK_ORDER_EXIST_CHECKED_BILL,"账单："+bill.getBillNum()+"支付已审核通过，无需再次提交。");
            }
            if(StringUtils.equals(bill.getBillPayType(),PayBillEnum.PAY_METHOD_ONLINE.getCode())&&StringUtils.equals(bill.getBillStatus(),PayBillEnum.BILL_ORDER_IS_PAY.getCode())){
                throw new JnSpringCloudException(PayBillExceptionEnum.PAYMENT_STATUS_IS_PAY_NOT_CHECK,"账单："+bill.getBillNum()+"已线下支付，无需提交审核。");
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        if(!StringUtils.equals(totalAmount.setScale(AMOUNT_DOUBLE_FORMAT).toString(),df.format(payRemindParam.getPayAmount()))){
            throw new JnSpringCloudException(PayBillExceptionEnum.COMMIT_AMOUNT_NOT_EQUAL_BILL_AMOUNT);
        }
        String remindId = UUID.randomUUID().toString().replace("-","");
        // 提交账单核对数据
        TbPaymentBillCriteria paymentBillCriteria = new TbPaymentBillCriteria();
        paymentBillCriteria.createCriteria().andBillIdIn(billIdList);
        TbPaymentBill bill = new TbPaymentBill();
        bill.setIsRemind("1");
        bill.setBillPayType(PayBillEnum.PAY_METHOD_OFFLINE.getCode());
        bill.setRemindId(remindId);
        bill.setRemindTime(new Date());
        int i = tbPaymentBillMapper.updateByExampleSelective(bill, paymentBillCriteria);
        logger.info("账单审核提醒处理成功，tb_payment_bill响应条数：{}",i);
        TbPaymentRemind tbPaymentRemind = new TbPaymentRemind();
        tbPaymentRemind.setRemindId(remindId);
        BeanUtils.copyProperties(payRemindParam,tbPaymentRemind);
        tbPaymentRemind.setRecordStatus(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        tbPaymentRemind.setCreatedTime(new Date());
        tbPaymentRemind.setCreatorAccount(account);
        int insert = tbPaymentRemindMapper.insert(tbPaymentRemind);
        logger.info("账单审核表tb_payment_remind响应条数：{}",insert);
        return insert;
    }

    @Override
    @ServiceLog(doAction = "获取账单核对单详情")
    public PayRemindVO getBillRemindDetail(String remindId){
        PayRemindVO billRemindDetail = paymentRemindMapper.getBillRemindDetail(remindId);
        if(null == billRemindDetail){
            throw new JnSpringCloudException(PayBillExceptionEnum.PAY_REMIND_IS_NOT_EXIT);
        }
        return billRemindDetail;
    }

    @Override
    @ServiceLog(doAction = "线下支付账单审核")
    @Transactional(rollbackFor = RuntimeException.class)
    public int checkBillRemind(PayRemindCheckParam payRemindCheckParam, String account,String payType){
        TbPaymentRemind tbPaymentRemind = tbPaymentRemindMapper.selectByPrimaryKey(payRemindCheckParam.getId());
        TbPaymentBill bill = new TbPaymentBill();
        bill.setBillStatus(payRemindCheckParam.getRemindStatus());
        bill.setCheckRemark(payRemindCheckParam.getCheckRemark());
        bill.setCheckAccount(account);
        bill.setCheckTime(new Date());
        int i1;
        if(null != payType){
            // 线下支付
            if(null == tbPaymentRemind){
                throw new JnSpringCloudException(PayBillExceptionEnum.PAY_REMIND_IS_NOT_EXIT);
            }
            tbPaymentRemind.setRemindStatus(payRemindCheckParam.getRemindStatus());
            tbPaymentRemind.setCheckTime(new Date());
            tbPaymentRemind.setCheckAccount(account);
            tbPaymentRemind.setCheckRemark(payRemindCheckParam.getCheckRemark());
            TbPaymentBillCriteria billCriteria = new TbPaymentBillCriteria();
            billCriteria.createCriteria().andRemindIdEqualTo(payRemindCheckParam.getId()).andRecordStatusEqualTo(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
            i1 = tbPaymentBillMapper.updateByExampleSelective(bill, billCriteria);
        }else{
            bill.setBillId(payRemindCheckParam.getId());
            i1 = tbPaymentBillMapper.updateByPrimaryKeySelective(bill);
        }
        logger.info("缴费单审核，处理账单数据{}条",i1);
        return i1;
    }

    @Override
    @ServiceLog(doAction = "后台管理员生成账单")
    public int createBillRemind(PayBillEntryParam payBillEntryParam, String account){
        TbPaymentBill paymentBill = new TbPaymentBill();
        BeanUtils.copyProperties(payBillEntryParam,paymentBill);
        try {
            paymentBill.setPayEndTime(DateUtils.parseDate(payBillEntryParam.getPayEndTime(),"yyyy-MM-dd HH:mm:ss"));
        }catch (ParseException e){
            throw new JnSpringCloudException(PayBillExceptionEnum.TIME_CONVERSION_ERROR);
        }
        paymentBill.setBillId(UUID.randomUUID().toString().replaceAll("-",""));
        paymentBill.setBillStatus(PayBillEnum.REMIND_IS_NOT_CHECK.getCode());
        paymentBill.setRecordStatus(new Byte(PayBillEnum.BILL_STATE_NOT_DELETE.getCode()));
        paymentBill.setCreatorAccount(account);
        paymentBill.setCreatedTime(new Date());
        paymentBill.setBillCreateTime(new Date());
        paymentBill.setBillCreateAccount(account);
        return tbPaymentBillMapper.insert(paymentBill);
    }

    @Override
    @ServiceLog(doAction = "审核流回调 - 账单生成业务")
    public int createBillCallback(PayBillEntryCallbackParam payBillEntryCallbackParam){
        if(StringUtils.isEmpty(payBillEntryCallbackParam.getBillId())){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_ID_IS_NOT_NULL);
        }
        if(StringUtils.isEmpty(payBillEntryCallbackParam.getBillStatus())){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_STATUS_IS_NOT_NULL);
        }
        TbPaymentBill paymentBill = tbPaymentBillMapper.selectByPrimaryKey(payBillEntryCallbackParam.getBillId());
        if(null == paymentBill){
            throw new JnSpringCloudException(PayBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        if(!StringUtils.equals(paymentBill.getBillStatus(),PayBillEnum.REMIND_IS_NOT_CHECK.getCode())){
            throw new JnSpringCloudException(PayBillExceptionEnum.PAYMENT_STATUS_IS_NOT_CHECK);
        }
        TbPaymentBill tbPaymentBill = new TbPaymentBill();
        tbPaymentBill.setBillId(payBillEntryCallbackParam.getBillId());
        tbPaymentBill.setBillStatus(payBillEntryCallbackParam.getBillStatus());
        return tbPaymentBillMapper.updateByPrimaryKeySelective(tbPaymentBill);
    }

}
