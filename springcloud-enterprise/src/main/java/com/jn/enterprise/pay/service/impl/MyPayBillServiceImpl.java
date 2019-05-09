package com.jn.enterprise.pay.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.pay.dao.*;
import com.jn.enterprise.pay.entity.*;
import com.jn.enterprise.pay.enums.PaymentBillActionEnum;
import com.jn.enterprise.pay.enums.PaymentBillEnum;
import com.jn.enterprise.pay.enums.PaymentBillExceptionEnum;
import com.jn.enterprise.pay.enums.PaymentBillMethodEnum;
import com.jn.enterprise.pay.model.*;
import com.jn.enterprise.pay.util.MoneyUtils;
import com.jn.enterprise.pay.vo.PayBillVo;
import com.jn.enterprise.pd.declaration.enums.PdStatusEnums;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.enums.RspEnum;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderReq;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jn.enterprise.pay.service.MyPayBillService;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 我的账单(业务实现层)
 *
 * @author： wzy
 * @date： Created on 2019/5/2 17:16
 * @version： v1.0
 * @modified By:
 */
@Service
public class MyPayBillServiceImpl implements MyPayBillService {

    private static final Logger logger = LoggerFactory.getLogger(MyPayBillServiceImpl.class);

    @Autowired
    private TbPayBillMapper tbPayBillMapper;

    @Autowired
    private TbPayCheckReminderMapper tbPayCheckReminderMapper;

    @Autowired
    private PayBillDao payBillDao;

    @Autowired
    private TbPayBillDetailsMapper tbPayBillDetailsMapper;

    @Autowired
    private TbPayAccountBookMapper tbPayAccountBookMapper;

    @Autowired
    private TbPayAccountBookMoneyRecordMapper tbPayAccountBookMoneyRecordMapper;

    @Autowired
    private PayOrderClient payOrderClient;

    @Override
    public PaginationData<List<PayBillVo>> getBillQueryList(PayBill payBill) {
        Page<Object> objects = PageHelper.startPage(payBill.getPage(), payBill.getRows());
        List<PayBillVo> payBillVo = payBillDao.getBillQueryList(payBill);
        for (int i = 0; i < payBillVo.size(); i++) {
            TbPayBillDetailsCriteria tbPayBillDetailsCriteria = new TbPayBillDetailsCriteria();
            TbPayBillDetailsCriteria.Criteria criteria = tbPayBillDetailsCriteria.createCriteria();
            criteria.andBillIdEqualTo(payBillVo.get(i).getBillId());
            List<TbPayBillDetails> payBillDetails = tbPayBillDetailsMapper.selectByExample(tbPayBillDetailsCriteria);
            payBillVo.get(i).setPayBillDetails(payBillDetails);
        }
        return new PaginationData(payBillVo, objects.getTotal());
    }

    @Override
    public void updateBillNumber(String billId, int reminderNumber) {
        TbPayBill bill = new TbPayBill();
        bill.setBillId(billId);
        bill.setReminderNumber(reminderNumber);
        tbPayBillMapper.updateByPrimaryKeySelective(bill);
    }

    @Override
    public void billCheckReminder(PayCheckReminder payCheckReminder, User user) {
        TbPayCheckReminder checkReminder = new TbPayCheckReminder();
        payCheckReminder.setCreatorAccount(user.getAccount());
        payCheckReminder.setCreatedTime(new Date());
        payCheckReminder.setRecordStatus(PdStatusEnums.EFFECTIVE.getCode());
        BeanUtils.copyProperties(payCheckReminder, checkReminder);
        tbPayCheckReminderMapper.insertSelective(checkReminder);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Result startPayment(PayBIllInitiateParam payBIllInitiateParam, User user) {
        String[] billIds = payBIllInitiateParam.getBillIds();
        String[] billTypes = payBIllInitiateParam.getBillTypes();
        if(null == billIds || billIds.length == 0 ){
            //判断前端传的账单ID是否为空
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ID_IS_NOT_NULL);
        }
        TbPayBillCriteria billCriteria = new TbPayBillCriteria();
        List<String> strings = Arrays.asList(billIds);
        billCriteria.createCriteria().andBillIdIn(strings).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        List<TbPayBill> tbPayBills = tbPayBillMapper.selectByExample(billCriteria);
        if(null == tbPayBills || tbPayBills.size() == 0){
            //判断账单是否存在
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        if(tbPayBills.size()!=payBIllInitiateParam.getBillIds().length){
            //判断选择缴费的账单是否与实际有效账单一致
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT,"选择账单数: "+payBIllInitiateParam.getBillIds().length
                    +" 条与实际有效账单数: "+tbPayBills.size()+" 条不匹配，请刷新页面再试。");
        }

        BigDecimal totalAmount = new BigDecimal(0);
        String title = null;
        StringBuffer sb = new StringBuffer();
        for (TbPayBill bill:tbPayBills) {
            if(StringUtils.equals(bill.getPaymentState(),PaymentBillEnum.BILL_ORDER_IS_NOT_PAY.getCode())){
                //判断选择缴费的账单是否都是未支付状态
                throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY,"账单："+bill.getBillId()+"已支付，请刷新页面重试。");
            }
            BigDecimal decimal = new BigDecimal(String.valueOf(bill.getBillExpense()));
            totalAmount = totalAmount.add(decimal);
            if(sb.length() > 0){sb.append(",");}
            sb.append(bill.getBillId());
        }
        //调用支付接口发起支付
        PayOrderReq payOrderReq = new PayOrderReq();
        payOrderReq.setMchOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        payOrderReq.setChannelId(ChannelIdEnum.ALIPAY_MOBILE.getCode());
        payOrderReq.setAmount(Long.parseLong(MoneyUtils.changeY2F(String.valueOf(totalAmount))));
        payOrderReq.setParam1(sb.toString());
        payOrderReq.setNotifyUrl("springcloud-enterprise/api/payment/payBill/payCallBack");
        Result result = null;
        try{
            result = payOrderClient.createPayOrder(payOrderReq);
            logger.info("调用统一支付下单接口返回结果{}",result);
            if(result.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                //返回成功状态，更新订单号到账单表
                TbPayBill tb = new TbPayBill();
                tb.setOrderNumber(payOrderReq.getMchOrderNo());
                tbPayBillMapper.updateByExampleSelective(tb,billCriteria);
            }
        }catch (Exception e){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.NETWORK_ANOMALY);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public String payCallBack(PayOrderNotify callBackParam, User user) {
        String result = RspEnum.FAIL.getCode();
        if(null == callBackParam){
            //判断回调参数是否为空
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_CALLBACK_IS_NULL);
        }
        if(StringUtils.isNotBlank(callBackParam.getMchOrderNo())){
            //判断回调参数商户订单号是否为空
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_CALLBACK_ID_IS_NULL);
        }
        TbPayBillCriteria billCriteria = new TbPayBillCriteria();
        billCriteria.createCriteria().andBillIdEqualTo(callBackParam.getMchOrderNo()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        try{
            List<TbPayBill> tbPayBills = tbPayBillMapper.selectByExample(billCriteria);
            for (int i = 0; i < tbPayBills.size(); i++) {
                //判断查询的账单状态是否为已支付
                if(tbPayBills.get(i).getPaymentState().equals(PaymentBillEnum.BILL_ORDER_IS_PAY)){
                    throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY);
                }
                //更新支付状态并新增流水记录
                //通过账本ID查询账本信息，进行入账出账等操作
                TbPayAccountBook tbPayAccountBook = tbPayAccountBookMapper.selectByPrimaryKey(tbPayBills.get(i).getAcBookId());
                if(null == tbPayAccountBook){
                    throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
                }
                //先补充账本金额
                BigDecimal totalAmount = new BigDecimal(0);
                BigDecimal decimal = new BigDecimal(String.valueOf(tbPayBills.get(i).getBillExpense()));
                totalAmount = totalAmount.add(decimal).add(tbPayAccountBook.getBalance());
                TbPayAccountBook pb = new TbPayAccountBook();
                pb.setAcBookId(tbPayAccountBook.getAcBookId());
                pb.setBalance(totalAmount);
                tbPayAccountBookMapper.updateByPrimaryKeySelective(pb);
                //插入流水表记录
                TbPayAccountBookMoneyRecord tpbmr = new TbPayAccountBookMoneyRecord();
                tpbmr.setDeductionId(UUID.randomUUID().toString().replaceAll("-", ""));
                tpbmr.setBillId(tbPayBills.get(i).getBillId());
                tpbmr.setAcBookId(tbPayBills.get(i).getAcBookId());
                String[] tmp = callBackParam.getChannelId().split("_");
                if(tmp[0].equals(PaymentBillMethodEnum.BILL_STATE_WX_.getCode())){
                    tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_WX_.getMessage());
                }else if(tmp[0].equals(PaymentBillMethodEnum.BILL_STATE_ALIPAY_.getCode())){
                    tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_ALIPAY_.getMessage());
                }
                tpbmr.setPaymentAction(PaymentBillActionEnum.BILL_STATE_MANUAL.getCode());
                tpbmr.setNatureCode(tbPayBills.get(i).getBillSource());
                tpbmr.setMoney(tbPayBills.get(i).getBillExpense());
                tpbmr.setBalance(totalAmount);
                tpbmr.setCreatedTime(new Date());
                tpbmr.setCreatorAccount(user.getAccount());
                tpbmr.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
                //再减去账本金额
                totalAmount = totalAmount.subtract(tbPayBills.get(i).getBillExpense());
                pb.setBalance(totalAmount);
                tbPayAccountBookMapper.updateByPrimaryKeySelective(pb);
                //插入流水表记录
                tpbmr.setDeductionId(UUID.randomUUID().toString().replaceAll("-", ""));
                tpbmr.setMoney(tbPayBills.get(i).getBillExpense());
                tpbmr.setBalance(totalAmount);
                tpbmr.setCreatedTime(new Date());
                tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
                //更新账单状态
                tbPayBills.get(i).setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
                tbPayBillMapper.updateByPrimaryKeySelective(tbPayBills.get(i));
                result = RspEnum.SUCCESS.getCode();
            }
        }catch (Exception e){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_QUERY_ERROR);
        }
        return result;
    }
}
