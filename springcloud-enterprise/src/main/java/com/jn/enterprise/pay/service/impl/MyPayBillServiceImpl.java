package com.jn.enterprise.pay.service.impl;


import com.alibaba.fastjson.JSON;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.pay.dao.*;
import com.jn.enterprise.pay.entity.*;
import com.jn.enterprise.pay.enums.PaymentBillActionEnum;
import com.jn.enterprise.pay.enums.PaymentBillEnum;
import com.jn.enterprise.pay.enums.PaymentBillExceptionEnum;
import com.jn.enterprise.pay.enums.PaymentBillMethodEnum;
import com.jn.enterprise.pay.util.MoneyUtils;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayBillReturnParamVo;
import com.jn.pay.vo.PayBillVo;
import com.jn.enterprise.pd.declaration.enums.PdStatusEnums;
import com.jn.pay.enums.ChannelIdEnum;
import com.jn.pay.enums.MchIdEnum;
import com.jn.pay.enums.RspEnum;
import com.jn.pay.utils.ResponseUtils;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jn.enterprise.pay.service.MyPayBillService;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
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

    /**
     * 获取企业的服务ID
     */
    private final static String ENT_CLIENT = "springcloud-enterprise";
    /**
     * 获取统一缴费支付回调的服务地址
     */
    private final static String ENT_CLIENT_CALLBOCK_SERVICE = "/api/payment/payBill/payCallBack";

    @Autowired
    private TbPayBillMapper tbPayBillMapper;

    @Autowired
    private TbPayCheckReminderMapper tbPayCheckReminderMapper;

    @Autowired
    private PayBillDao payBillDao;

    @Autowired
    private TbPayAccountMapper tbPayAccountMapper;

    @Autowired
    private TbPayBillDetailsMapper tbPayBillDetailsMapper;

    @Autowired
    private TbPayAccountBookMapper tbPayAccountBookMapper;

    @Autowired
    private TbPayAccountBookMoneyRecordMapper tbPayAccountBookMoneyRecordMapper;

    @Autowired
    private TbPayBillMiddleMapper tbPayBillMiddleMapper;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;



    @ServiceLog(doAction = "我的账单-查询账单信息列表(APP端)")
    @Override
    public PaginationData<List<PayBillVo>> getBillQueryList(@Param("payBill")PayBillParams payBill,User user) {
        List<PayBillVo> pbList = new ArrayList<>();
        /**获取所有账单该用户账单*/
        PayBill pay = new PayBill();
        List<PayBillReturnParamVo> listBills = new ArrayList<>();
        pay.setBillReceiver(user.getAccount());
        BeanUtils.copyProperties(payBill,pay);
        listBills = payBillDao.getBillAppList(pay);
        //类型标识
        List<String> list = new ArrayList<>();
        if(listBills.size() > 0){
            list.add(listBills.get(0).getAcBookType());
            String flag = listBills.get(0).getAcBookType();
            for (int i = 0; i <listBills.size() ; i++) {
                //账单类型标识
                if(!flag.equals(listBills.get(i).getAcBookType())){
                    list.add(listBills.get(i).getAcBookType());
                    flag = listBills.get(i).getAcBookType();
                }
            }
            for (int i = 0; i < list.size(); i++) {
                PayBillVo payBillVo = new PayBillVo();
                String str = list.get(i);
                //相同类型催缴总次数
                int total = 0;
                List<PayBillReturnParamVo> pb = new ArrayList<>();
                for (int j = 0; j < listBills.size(); j++) {
                    if(str.equals(listBills.get(j).getAcBookType())){
                        total += listBills.get(j).getReminderNumber();
                        pb.add(listBills.get(j));
                    }
                }
                payBillVo.setTotalReminderNumber(total);
                payBillVo.setPayBillReturnParamVo(pb);
                payBillVo.setType(str);
                pbList.add(payBillVo);
            }
        }
        PaginationData paginationData = new PaginationData();
        paginationData.setRows(pbList);
        paginationData.setTotal(pbList.size());
        return paginationData;
    }

    @ServiceLog(doAction = "我的账单-通过账单ID查询账单详情信息")
    @Override
    public PaginationData<List<PayBillDetails>> getBillInfo(String billId) {
        List<PayBillDetails> list = new ArrayList<>();
        TbPayBillDetailsCriteria tbPayBillDetailsCriteria = new TbPayBillDetailsCriteria();
        TbPayBillDetailsCriteria.Criteria criteria = tbPayBillDetailsCriteria.createCriteria();
        criteria.andBillIdEqualTo(billId);
        List<TbPayBillDetails> tbPayBillDetails = tbPayBillDetailsMapper.selectByExample(tbPayBillDetailsCriteria);
        for (int i = 0; i < tbPayBillDetails.size(); i++) {
            PayBillDetails payBillDetails = new PayBillDetails();
            BeanUtils.copyProperties(tbPayBillDetails.get(i),payBillDetails);
            list.add(payBillDetails);
        }
        PaginationData paginationData = new PaginationData();
        paginationData.setRows(list);
        paginationData.setTotal(list.size());
        return paginationData;
    }

    @Override
    @ServiceLog(doAction = "我的账单-通过账单ID查询账单【基础】信息(包含账单支付状态)")
    public PayBill getBillBasicInfo(String billId) {
        PayBill payBill = new PayBill();
        TbPayBill pb = tbPayBillMapper.selectByPrimaryKey(billId);
        BeanUtils.copyProperties(pb,payBill);
        return payBill;
    }


    @Override
    public void updateBillNumber(String billId, int reminderNumber) {
        TbPayBill bill = new TbPayBill();
        bill.setBillId(billId);
        bill.setReminderNumber(reminderNumber);
        tbPayBillMapper.updateByPrimaryKeySelective(bill);
    }

    @ServiceLog(doAction = "我的账单-我的账单-核查提醒录入")
    @Override
    public void billCheckReminder(PayCheckReminder payCheckReminder, User user) {
        TbPayCheckReminder checkReminder = new TbPayCheckReminder();
        payCheckReminder.setCreatorAccount(user.getAccount());
        payCheckReminder.setCreatedTime(new Date());
        payCheckReminder.setRecordStatus(PdStatusEnums.EFFECTIVE.getCode());
        BeanUtils.copyProperties(payCheckReminder, checkReminder);
        tbPayCheckReminderMapper.insertSelective(checkReminder);
    }

    @ServiceLog(doAction = "我的账单-创建账单")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result billCreate(PayBillCreateParamVo payBillCreateParamVo, User user) {
        /**根据用户账号/企业ID查询企业信息（用户为企业管理员） */
        List<TbPayAccountBook> tbPayAccountBook = null;
        List<TbPayAccount> tbPayAccount = null;
        TbPayAccountBookCriteria billCriteria = new TbPayAccountBookCriteria();
        TbPayAccountCriteria accountCriteria = new TbPayAccountCriteria();
        if(payBillCreateParamVo.getObjType().equals(PaymentBillEnum.BILL_OBJ_TYPE_IS_COMPANY.getCode())){
            /**如果是企业则去查询企业信息再通过查询的企业的管理员账户去查询账户表*/
            ServiceCompany serviceCompany = companyService.getCompanyDetailByAccountOrId(payBillCreateParamVo.getObjId());
            if(serviceCompany == null || StringUtils.isBlank(serviceCompany.getComAdmin())){
                /**查询企业信息异常*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.QUERY_ENTERPRISE_INFO_ERROR);
            }
            /**通过企业管理员获取账户ID*/
            accountCriteria.createCriteria().andUserIdEqualTo(serviceCompany.getComAdmin()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            tbPayAccount = tbPayAccountMapper.selectByExample(accountCriteria);
        }else if(payBillCreateParamVo.getObjType().equals(PaymentBillEnum.BILL_OBJ_TYPE_IS_INDIVIDUAL.getCode())){
            /**如果是个人则用个人对象名称去查询账户表*/
            accountCriteria.createCriteria().andUserIdEqualTo(payBillCreateParamVo.getObjId()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            tbPayAccount = tbPayAccountMapper.selectByExample(accountCriteria);

        }
        if(tbPayAccount.size() > Integer.parseInt(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode()) || tbPayAccount.size() == Integer.parseInt(PaymentBillEnum.BILL_STATE_DELETE.getCode())){
            /**查询账户信息异常*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ACCOUNT_IS_NOT_EXIT);
        }
        /**通过账户表的账户ID查询账本信息*/
        billCriteria.createCriteria().andAccountIdEqualTo(tbPayAccount.get(0).getAccountId()).andAcBookTypeEqualTo(payBillCreateParamVo.getAcBookType()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        tbPayAccountBook = tbPayAccountBookMapper.selectByExample(billCriteria);
        if(tbPayAccountBook.size() > Integer.parseInt(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode()) || tbPayAccountBook.size() == Integer.parseInt(PaymentBillEnum.BILL_STATE_DELETE.getCode())){
            /**查询账本信息异常*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
        }
        /** 插入账单信息*/
        logger.info("开始执行统一缴费插入账单信息操作");
        TbPayBill tb = new TbPayBill();
        BeanUtils.copyProperties(payBillCreateParamVo,tb);
        tb.setAcBookId(tbPayAccountBook.get(0).getAcBookId());
        tb.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_NOT_PAY.getCode());
        tb.setPaymentType(PaymentBillEnum.PAY_METHOD_ONLINE.getCode());
        tb.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        tb.setReminderNumber(Integer.parseInt(PaymentBillEnum.PAY_REMINDER_NUMBER.getCode()));
        tb.setPaymentAffirm(PaymentBillEnum.BILL_AC_BOOK_CHECK_2.getCode());
        tb.setBillReceiver(tbPayAccount.get(0).getUserId());
        tbPayBillMapper.insertSelective(tb);
        logger.info("结束执行统一缴费插入账单信息操作");
        /** 插入账单详情信息*/
        logger.info("开始执行统一缴费插入账单详情信息操作");
        List<TbPayBillDetails> list = new ArrayList<>();
        if(payBillCreateParamVo.getPayBillDetails().size() > 0){
            for (PayBillDetails tp : payBillCreateParamVo.getPayBillDetails()) {
                TbPayBillDetails tb2 = new TbPayBillDetails();
                tb2.setBillId(payBillCreateParamVo.getBillId());
                tb2.setCreatedTime(payBillCreateParamVo.getCreatedTime());
                tb2.setCreatorAccount(payBillCreateParamVo.getCreatorAccount());
                tb2.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                tb2.setDetailsId(UUID.randomUUID().toString().replaceAll("-", ""));
                BeanUtils.copyProperties(tp,tb2);
                list.add(tb2);
            }
            payBillDao.insertList(list);
        }
        logger.info("结束执行统一缴费插入账单详情信息操作");
        TbPayBill tbs = tbPayBillMapper.selectByPrimaryKey(tb.getBillId());
        if(null == tbs){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        /**判断是否是电费账单，如果是电费账单，则直接扣除费用*/
        if(tbs.getAcBookType().equals(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode())){
            /**比较金额大小即左边比右边数大，返回1，相等返回0，比右边小返回-1*/
            int i = tbPayAccountBook.get(0).getBalance().compareTo(tbs.getBillExpense());
            logger.info("比较金额大小结果：{}",i);
            try{
                if(i == 1 || i == 0){
                    /**扣除账本金额，并更新账单状态和插入流水记录*/
                    BigDecimal totalAmount = new BigDecimal(tbPayAccountBook.get(0).getBalance().toString());
                    totalAmount = totalAmount.subtract(tbs.getBillExpense());
                    tbPayAccountBook.get(0).setBalance(totalAmount);
                    /**扣除账本金额*/
                    logger.info("开始执行统一缴费扣除账本金额操作");
                    tbPayAccountBookMapper.updateByPrimaryKeySelective(tbPayAccountBook.get(0));
                    logger.info("结束执行统一缴费扣除账本金额操作");
                    /**插入流水表记录*/
                    logger.info("开始执行统一缴费插入流水记录操作");
                    TbPayAccountBookMoneyRecord tpbmr = new TbPayAccountBookMoneyRecord();
                    tpbmr.setDeductionId(UUID.randomUUID().toString().replaceAll("-", ""));
                    tpbmr.setBillId(tbs.getBillId());
                    tpbmr.setAcBookId(tbs.getAcBookId());
                    tpbmr.setRemark(tbs.getBillSource());
                    tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_QIAN_BAO.getMessage());
                    tpbmr.setPaymentAction(PaymentBillActionEnum.BILL_STATE_AUYTO.getCode());
                    tpbmr.setNatureCode(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode());
                    tpbmr.setMoney(tbs.getBillExpense());
                    tpbmr.setBalance(totalAmount);
                    tpbmr.setCreatorAccount(user.getAccount());
                    tpbmr.setCreatedTime(new Date());
                    tpbmr.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                    tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
                    logger.info("结束执行统一缴费插入流水记录操作");
                    /**更新账单状态*/
                    logger.info("开始执行统一缴费更新账单状态操作");
                    tbs.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
                    tbPayBillMapper.updateByPrimaryKeySelective(tbs);
                    logger.info("结束执行统一缴费更新账单状态操作");
                }
            }catch (Exception e){
                throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_DEDUCTION_FEE_ERROR);
            }
        }
        /**回调通知各业务测账单状态*/
        PayCallBackNotify payCallBackNotify = new PayCallBackNotify();
        payCallBackNotify.setBillId(tbs.getBillId());
        payCallBackNotify.setPaymentState(tbs.getPaymentState());
        Delay delay = new Delay();
        delay.setServiceId(tbs.getCallbackId());
        delay.setServiceUrl(tbs.getCallbackUrl());
        delay.setTtl("30");
        delay.setDataString(payCallBackNotify.toString());
        logger.info("接收到延迟消息内容：【{}】",delay.toString());
        logger.info("开始回调");
        Result<Boolean> result = delaySendMessageClient.delaySend(delay);
        logger.info("结束回调结果，【{}】",result.toString());
        return result;

        /**TODO 是否需要推送自动扣费的消息给企业或个人*/
    }

    @ServiceLog(doAction = "我的账单-统一缴费发起支付")
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Result startPayment(PayBIllInitiateParam payBIllInitiateParam, User user) {
        String[] billIds = payBIllInitiateParam.getBillIds();
        if(null == billIds || billIds.length == 0 ){
            /**判断前端传的账单ID是否为空*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ID_IS_NOT_NULL);
        }
        TbPayBillCriteria billCriteria = new TbPayBillCriteria();
        List<String> strings = Arrays.asList(billIds);
        billCriteria.createCriteria().andBillIdIn(strings).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        List<TbPayBill> tbPayBills = tbPayBillMapper.selectByExample(billCriteria);
        if(null == tbPayBills || tbPayBills.size() == 0){
            /**判断账单是否存在*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        if(tbPayBills.size()!=payBIllInitiateParam.getBillIds().length){
            /**判断选择缴费的账单是否与实际有效账单一致*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT,"选择账单数: "+payBIllInitiateParam.getBillIds().length
                    +" 条与实际有效账单数: "+tbPayBills.size()+" 条不匹配，请刷新页面再试。");
        }

        BigDecimal totalAmount = new BigDecimal(0);
        String title = null;
        StringBuffer sb = new StringBuffer();
        for (TbPayBill bill:tbPayBills) {
            if(StringUtils.equals(bill.getPaymentState(),PaymentBillEnum.BILL_ORDER_IS_PAY.getCode())){
                /**判断选择缴费的账单是否都是未支付状态*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY,"账单："+bill.getBillId()+"已支付，请刷新页面重试。");
            }
            BigDecimal decimal = new BigDecimal(String.valueOf(bill.getBillExpense()));
            totalAmount = totalAmount.add(decimal);
            if(sb.length() > 0){sb.append(",");}
            sb.append(bill.getBillId());
        }
        /**调用支付接口发起支付*/
        logger.info("开始调用统一缴费发起支付接口操作");
        PayOrderReq payOrderReq = new PayOrderReq();
        payOrderReq.setMchOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        payOrderReq.setChannelId(ChannelIdEnum.ALIPAY_MOBILE.getCode());
        payOrderReq.setAmount(Long.parseLong(MoneyUtils.changeY2F(String.valueOf(totalAmount))));
        payOrderReq.setParam1(sb.toString());
        payOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
        payOrderReq.setSubject("支付标题必传");
        payOrderReq.setBody("支付描述信息必传");
        payOrderReq.setNotifyUrl("http://192.168.10.63:6101/api/payment/payBill/payCallBack");
        Result<Boolean> result = null;
        try{
            /**调用统一支付接口*/
            String jsonObject = JSON.toJSONString(payOrderReq);
            logger.info("开始回调");
            Delay delay = new Delay();
            delay.setServiceId(ENT_CLIENT);
            delay.setServiceUrl(ENT_CLIENT_CALLBOCK_SERVICE);
            delay.setTtl("30");
            delay.setDataString(jsonObject);
            logger.info("接收到延迟消息内容：【{}】",delay.toString());
            result = delaySendMessageClient.delaySend(delay);
            logger.info("调用统一支付下单接口返回结果{}",result);
            if(result.getCode().equals(GlobalConstants.SUCCESS_CODE)){
                /**返回成功状态，更新订单号到账单表*/
                logger.info("调用统一支付下单接口，返回成功状态，更新统一订单号到账单表操作开始");
                TbPayBill tb = new TbPayBill();
                tb.setOrderNumber(payOrderReq.getMchOrderNo());
                tbPayBillMapper.updateByExampleSelective(tb,billCriteria);
                logger.info("调用统一支付下单接口，返回成功状态，更新统一订单号到账单表操作结束");
                logger.info("调用统一支付下单接口，插入账单信息到账单中间表，便于核查验证账单操作开始");
                TbPayBillMiddle tbPayBillMiddle = new TbPayBillMiddle();
                tbPayBillMiddle.setBillId(billIds.toString());
                tbPayBillMiddle.setOrderNumber(payOrderReq.getMchOrderNo());
                tbPayBillMiddle.setStatus(PaymentBillEnum.BILL_ORDER_IS_NOT_PAY.getCode());
                tbPayBillMiddle.setCreatedTime(new Date());
                tbPayBillMiddle.setCreatorAccount(user.getAccount());
                tbPayBillMiddle.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                tbPayBillMiddleMapper.insertSelective(tbPayBillMiddle);
                logger.info("调用统一支付下单接口，插入账单信息到账单中间表，便于核查验证账单操作结束");
            }
        }catch (Exception e){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.NETWORK_ANOMALY);
        }
        return result;
    }

    @ServiceLog(doAction = "我的账单-统一缴费回调")
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void payCallBack(HttpServletResponse response, PayOrderNotify callBackParam, User user) {
        String result = RspEnum.FAIL.getCode();
        if(StringUtils.isBlank(callBackParam.getStatus().toString())){
            /**判断回调参数支付状态是否为空*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_CALLBACK_IS_NULL);
        }
        if(StringUtils.isBlank(callBackParam.getMchOrderNo())){
            /**判断回调参数商户订单号是否为空*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_CALLBACK_ID_IS_NULL);
        }
        TbPayBillCriteria billCriteria = new TbPayBillCriteria();
        billCriteria.createCriteria().andOrderNumberEqualTo(callBackParam.getMchOrderNo()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        try{
            List<TbPayBill> tbPayBills = tbPayBillMapper.selectByExample(billCriteria);
            for (int i = 0; i < tbPayBills.size(); i++) {
                /**判断查询的账单状态是否为已支付*/
                if (tbPayBills.get(i).getPaymentState().equals(PaymentBillEnum.BILL_ORDER_IS_PAY)) {
                    throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY);
                }
                /**更新支付状态并新增流水记录
                 通过账本ID查询账本信息，进行入账出账等操作*/
                TbPayAccountBook tbPayAccountBook = tbPayAccountBookMapper.selectByPrimaryKey(tbPayBills.get(i).getAcBookId());
                if (null == tbPayAccountBook) {
                    throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
                }
                /**先补充账本金额*/
                logger.info("调用统一支付下单接口回调，更新信息，先补充账本金额操作开始");
                BigDecimal totalAmount = new BigDecimal(0);
                BigDecimal decimal = new BigDecimal(String.valueOf(tbPayBills.get(i).getBillExpense()));
                totalAmount = totalAmount.add(decimal).add(tbPayAccountBook.getBalance());
                TbPayAccountBook pb = new TbPayAccountBook();
                pb.setAcBookId(tbPayAccountBook.getAcBookId());
                pb.setBalance(totalAmount);
                tbPayAccountBookMapper.updateByPrimaryKeySelective(pb);
                logger.info("调用统一支付下单接口回调，更新信息，先补充账本金额操作结束");
                /**插入流水表记录*/
                logger.info("调用统一支付下单接口回调，插入流水表记录操作开始");
                TbPayAccountBookMoneyRecord tpbmr = new TbPayAccountBookMoneyRecord();
                tpbmr.setDeductionId(UUID.randomUUID().toString().replaceAll("-", ""));
                tpbmr.setBillId(tbPayBills.get(i).getBillId());
                tpbmr.setAcBookId(tbPayBills.get(i).getAcBookId());
                String[] tmp = callBackParam.getChannelId().split("_");
                if (tmp[0].equals(PaymentBillMethodEnum.BILL_STATE_WX_.getCode())) {
                    tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_WX_.getMessage());
                } else if (tmp[0].equals(PaymentBillMethodEnum.BILL_STATE_ALIPAY_.getCode())) {
                    tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_ALIPAY_.getMessage());
                }
                tpbmr.setPaymentAction(PaymentBillActionEnum.BILL_STATE_MANUAL.getCode());
                tpbmr.setNatureCode(tbPayBills.get(i).getAcBookType());
                tpbmr.setRemark(tbPayBills.get(i).getBillSource());
                tpbmr.setMoney(tbPayBills.get(i).getBillExpense());
                tpbmr.setBalance(totalAmount);
                tpbmr.setCreatedTime(new Date());
                tpbmr.setCreatorAccount("wangsong");
                tpbmr.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
                logger.info("调用统一支付下单接口回调，插入流水表记录操作结束");
                /**再减去账本金额*/
                logger.info("调用统一支付下单接口回调，更新信息，再减去账本金额操作开始");
                totalAmount = totalAmount.subtract(tbPayBills.get(i).getBillExpense());
                pb.setBalance(totalAmount);
                tbPayAccountBookMapper.updateByPrimaryKeySelective(pb);
                logger.info("调用统一支付下单接口回调，更新信息，再减去账本金额操作结束");
                /**插入流水表记录*/
                logger.info("调用统一支付下单接口回调，插入流水表记录操作开始");
                tpbmr.setDeductionId(UUID.randomUUID().toString().replaceAll("-", ""));
                tpbmr.setMoney(tbPayBills.get(i).getBillExpense());
                tpbmr.setBalance(totalAmount);
                tpbmr.setCreatedTime(new Date());
                tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
                logger.info("调用统一支付下单接口回调，插入流水表记录操作结束");
                /**更新账单状态*/
                logger.info("调用统一支付下单接口回调，更新账单状态操作开始");
                tbPayBills.get(i).setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
                tbPayBillMapper.updateByPrimaryKeySelective(tbPayBills.get(i));
                logger.info("调用统一支付下单接口回调，更新账单状态操作结束");
                /**回调通知各业务测账单状态*/
                PayCallBackNotify payCallBackNotify = new PayCallBackNotify();
                payCallBackNotify.setBillId(tbPayBills.get(i).getBillId());
                payCallBackNotify.setPaymentState(tbPayBills.get(i).getPaymentState());
                Delay delay = new Delay();
                delay.setServiceId(tbPayBills.get(i).getCallbackId());
                delay.setServiceUrl(tbPayBills.get(i).getCallbackUrl());
                delay.setTtl("30");
                delay.setDataString(payCallBackNotify.toString());
                logger.info("接收到延迟消息内容：【{}】", delay.toString());
                logger.info("开始回调");
                Result<Boolean> result2 = delaySendMessageClient.delaySend(delay);
                logger.info("结束回调结果，【{}】",result2);
                logger.info("调用统一支付下单接口回调，更新账单状态到账单中间表操作开始");
                TbPayBillMiddle tbPayBillMiddle = new TbPayBillMiddle();
                tbPayBillMiddle.setOrderNumber(tbPayBills.get(0).getOrderNumber());
                tbPayBillMiddle.setStatus(callBackParam.getStatus().toString());
                tbPayBillMiddleMapper.updateByPrimaryKeySelective(tbPayBillMiddle);
                result = RspEnum.SUCCESS.getCode();
            }
        }catch (Exception e){
            ResponseUtils.outResult(response,result);
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_QUERY_ERROR);
        }
        ResponseUtils.outResult(response,result);
    }
}
