package com.jn.enterprise.pay.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.jn.common.channel.MessageSource;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.pay.dao.*;
import com.jn.enterprise.pay.entity.*;
import com.jn.enterprise.pay.enums.*;
import com.jn.enterprise.pay.util.AutoOrderUtil;
import com.jn.enterprise.pay.util.MoneyUtils;
import com.jn.news.vo.EmailVo;
import com.jn.news.vo.SmsTemplateVo;
import com.jn.pay.api.PayOrderClient;
import com.jn.pay.model.*;
import com.jn.pay.vo.*;
import com.jn.enterprise.pd.declaration.enums.PdStatusEnums;
import com.jn.pay.enums.MchIdEnum;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.jn.enterprise.pay.service.MyPayBillService;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.common.util.BeanToMap;
import org.xxpay.common.util.JsonUtil;
import org.xxpay.common.util.PayDigestUtil;
import org.xxpay.common.util.XXPayUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

    /**
     * 获取预缴充值支付回调的服务地址
     */
    private final static String ENT_CLIENT_CALLBOCK_FEE_SERVICE = "/api/payment/payAccount/payAccountCallBack";


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
    private TbPayAccountBookTypeMapper tbPayAccountBookTypeMapper;

    @Autowired
    private TbPayAccountBookMoneyRecordMapper tbPayAccountBookMoneyRecordMapper;

    @Autowired
    private TbPayBillMiddleMapper tbPayBillMiddleMapper;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    @Autowired
    private PayOrderClient payOrderClient;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SystemClient systemClient;
    @Autowired
    private CompanyClient companyClient;


    @ServiceLog(doAction = "我的账单-查询账单信息列表(APP端)")
    @Override
    public PaginationData<List<PayBillVo>> getBillQueryList(@Param("payBill") PayBillParams payBill, User user) {
        List<PayBillVo> pbList = new ArrayList<>();
        /**获取所有账单该用户账单*/
        PayBill pay = new PayBill();
        List<PayBillReturnParamVo> listBills = new ArrayList<>();
        BeanUtils.copyProperties(payBill, pay);
        pay.setBillReceiver(user.getAccount());
        listBills = payBillDao.getBillAppList(pay);
        //类型标识
        List<String> list = new ArrayList<>();
        if (listBills.size() > 0) {
            for (int i = 0; i < listBills.size(); i++) {
                //账单类型标识
                list.add(listBills.get(i).getAcBookType());
            }
        }
        //list去重
        HashSet<String> setList = new HashSet<String>(list);
        list.clear();
        list.addAll(setList);
        for (int i = 0; i < list.size(); i++) {
            PayBillVo payBillVo = new PayBillVo();
            String str = list.get(i);
            //相同类型催缴总次数
            int total = 0;
            List<PayBillReturnParamVo> pb = new ArrayList<>();
            for (int j = 0; j < listBills.size(); j++) {
                if (str.equals(listBills.get(j).getAcBookType())) {
                    total += listBills.get(j).getReminderNumber();
                    pb.add(listBills.get(j));
                }
            }
            payBillVo.setTotalReminderNumber(total);
            payBillVo.setPayBillReturnParamVo(pb);
            payBillVo.setType(str);
            pbList.add(payBillVo);
        }
        PaginationData paginationData = new PaginationData();
        paginationData.setRows(pbList);
        paginationData.setTotal(pbList.size());
        return paginationData;
    }

    @Override
    @ServiceLog(doAction = "我的账单-查询缴费记录")
    public PaginationData<List<PayRecordVo>> billPaymentRecord(PayRecordParam payRecordParam, User user) {

        PageHelper.startPage(payRecordParam.getPage(), payRecordParam.getRows());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        //个人账单查询条件
        TbPayBillCriteria tbPayBillCriteria = new TbPayBillCriteria();
        tbPayBillCriteria.setOrderByClause("created_time desc,payment_state desc");
        TbPayBillCriteria.Criteria criteria = tbPayBillCriteria.createCriteria();
        criteria.andPaymentStateEqualTo(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode()).andObjTypeEqualTo(PaymentBillEnum.BILL_OBJ_TYPE_IS_INDIVIDUAL.getCode()).andObjIdEqualTo(user.getAccount()).andBillExpenseGreaterThan(new BigDecimal("0"));
        if(StringUtils.isNotBlank(payRecordParam.getAcBookId())){
            criteria.andAcBookIdEqualTo(payRecordParam.getAcBookId());
        }
        //企业账单查询条件
        Result<ServiceCompany> serviceCompanyResult=companyClient.getCurCompanyInfo(user.getAccount());
        if(StringUtils.equals(serviceCompanyResult.getCode(),"0000")&&serviceCompanyResult.getData()!=null){
            logger.info("用户有对应的企业[{}-{}]，可以查到企业相关的缴费记录",serviceCompanyResult.getData().getComName(),serviceCompanyResult.getData().getId());
            TbPayBillCriteria tbPayBillCriteria2=new TbPayBillCriteria();
            TbPayBillCriteria.Criteria criteria2 = tbPayBillCriteria2.createCriteria();
            criteria2.andPaymentStateEqualTo(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode()).andObjTypeEqualTo(PaymentBillEnum.BILL_OBJ_TYPE_IS_COMPANY.getCode()).andObjIdEqualTo(serviceCompanyResult.getData().getId()).andBillExpenseGreaterThan(new BigDecimal("0"));
            if(StringUtils.isNotBlank(payRecordParam.getAcBookId())){
                criteria2.andAcBookIdEqualTo(payRecordParam.getAcBookId());
            }
            tbPayBillCriteria.or(criteria2);
        }

        List<TbPayBill> tbPayBills = tbPayBillMapper.selectByExample(tbPayBillCriteria);
        //获取每个月份，通过月份组装返回给前端
        List<PayRecordVo> voList = new ArrayList<>();
        if (tbPayBills.size() > 0) {
            List<TbPayAccountBookType> list = selectPayBillType();
            for (TbPayBill tbPayBill : tbPayBills) {
                PayRecordVo payBill = new PayRecordVo();
                payBill.setMonth(sdf.format(tbPayBill.getCreatedTime()));
                for (TbPayAccountBookType tb : list) {
                    if (tbPayBill.getAcBookType().equals(tb.getAcBookType())) {
                        tbPayBill.setAcBookType(tb.getAcBookDesc());
                    }
                }
                BeanUtils.copyProperties(tbPayBill, payBill);
                voList.add(payBill);
            }
        }
        PaginationData paginationData = new PaginationData();
        paginationData.setRows(voList);
        paginationData.setTotal(voList.size());
        return paginationData;
    }

    @ServiceLog(doAction = "查询所有账本类型")
    public List<TbPayAccountBookType> selectPayBillType() {
        TbPayAccountBookTypeCriteria tbCriteria = new TbPayAccountBookTypeCriteria();
        List<TbPayAccountBookType> tbs = tbPayAccountBookTypeMapper.selectByExample(tbCriteria);
        return tbs;
    }

    @ServiceLog(doAction = "我的账单-通过账单ID查询账单详情信息")
    @Override
    public PaginationData<List<PayBillDetailsVo>> getBillInfo(String billId) {
        PayBillDetailsVo payBillDetailsVo = new PayBillDetailsVo();
        List<PayBillDetails> list = new ArrayList<>();
        PayBillParamVo payBill = new PayBillParamVo();
        TbPayBill tbPayBill = tbPayBillMapper.selectByPrimaryKey(billId);
        BeanUtils.copyProperties(tbPayBill, payBill);
        payBill.setPayType(tbPayBill.getAcBookType());
        switch (PaymentBillEnum.getByValue(tbPayBill.getAcBookType())){
            case BILL_AC_BOOK_TYPE_1:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_2:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_2.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_3:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_3.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_4:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_4.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_5:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_5.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_6:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_6.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_7:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_7.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_8:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_8.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_9:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_9.getMessage());
                break;
            case BILL_AC_BOOK_TYPE_10:
                payBill.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_10.getMessage());
                break;
            default:
                break;
        }
        TbPayBillDetailsCriteria tbPayBillDetailsCriteria = new TbPayBillDetailsCriteria();
        tbPayBillDetailsCriteria.setOrderByClause("sort asc");
        TbPayBillDetailsCriteria.Criteria criteria = tbPayBillDetailsCriteria.createCriteria();
        criteria.andBillIdEqualTo(billId);
        List<TbPayBillDetails> tbPayBillDetails = tbPayBillDetailsMapper.selectByExample(tbPayBillDetailsCriteria);
        if (tbPayBillDetails.size() > 0) {
            for (int i = 0; i < tbPayBillDetails.size(); i++) {
                PayBillDetails payBillDetails = new PayBillDetails();
                BeanUtils.copyProperties(tbPayBillDetails.get(i), payBillDetails);
                list.add(payBillDetails);
            }
        }
        payBillDetailsVo.setPayBill(payBill);
        payBillDetailsVo.setPayBillDetails(list);
        PaginationData paginationData = new PaginationData();
        paginationData.setRows(payBillDetailsVo);
        return paginationData;
    }

    @Override
    @ServiceLog(doAction = "我的账单-通过账单ID查询账单【基础】信息(包含账单支付状态)")
    public PayBill getBillBasicInfo(String billId) {
        PayBill payBill = new PayBill();
        TbPayBill pb = tbPayBillMapper.selectByPrimaryKey(billId);
        BeanUtils.copyProperties(pb, payBill);
        return payBill;
    }


    @Override
    public Result updateBillNumber(PayCheckReminderParam payCheckReminderParam) {
        TbPayBill bill = new TbPayBill();
        BeanUtils.copyProperties(payCheckReminderParam, bill);
        tbPayBillMapper.updateByPrimaryKeySelective(bill);
        return new Result("账单催缴次数更新成功");
    }

    @ServiceLog(doAction = "我的账单-我的账单-核查提醒录入")
    @Override
    public Result billCheckReminder(PayCheckReminder payCheckReminder, User user) {
        TbPayBillCriteria billCriteria = new TbPayBillCriteria();
        List<String> strings = Arrays.asList(payCheckReminder.getBillIds());
        billCriteria.createCriteria().andBillIdIn(strings).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        List<TbPayBill> tbPayBills = tbPayBillMapper.selectByExample(billCriteria);
        if (null == tbPayBills || tbPayBills.size() == 0) {
            /**判断账单是否存在*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        if (tbPayBills.size() != payCheckReminder.getBillIds().length) {
            /**判断选择核对提醒的账单是否与实际查询有效账单一致*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT, "选择账单数: " + payCheckReminder.getBillIds().length
                    + " 条与实际有效账单数: " + tbPayBills.size() + " 条不匹配，请刷新页面再试。");
        }
        for (TbPayBill tb: tbPayBills) {
            if(!tb.getBillReceiver().equals(user.getAccount())){
                /**判断选择的账单是否是当前用户的账单*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ACCOUNT_NOT_EXIT);
            }
            if(tb.getPaymentState().equals(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode())){
                /**验证该账单是否已支付*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY_REMIND,"账单已支付，无需核对提醒,账单编号："+tb.getBillId()+",账单名称："+tb.getBillName());
            }
        }
        TbPayCheckReminderCriteria tbPayCheckReminderCriteria = new TbPayCheckReminderCriteria();
        tbPayCheckReminderCriteria.createCriteria().andBillIdIn(strings).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        List<TbPayCheckReminder> tbBooks = tbPayCheckReminderMapper.selectByExample(tbPayCheckReminderCriteria);
        for (TbPayCheckReminder tbs: tbBooks) {
            boolean bo = strings.contains(tbs.getBillId());
            if(bo){
                /**判断选择的账单是否已发送核对提醒*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_REMIND_IS_SEND_OUT,"已发送核对提醒，无需重复发送,账单编号："+tbs.getBillId());
            }
        }
        /**插入核对提醒数据开始*/
        logger.info("执行核对提醒插入信息操作,入參【{}】", payCheckReminder.toString());
        for (String tb: strings) {
            TbPayCheckReminder checkReminder = new TbPayCheckReminder();
            BeanUtils.copyProperties(payCheckReminder, checkReminder);
            checkReminder.setBillId(tb);
            checkReminder.setCreatorAccount(user.getAccount());
            checkReminder.setCreatedTime(new Date());
            checkReminder.setRecordStatus(PdStatusEnums.EFFECTIVE.getCode());
            tbPayCheckReminderMapper.insertSelective(checkReminder);
        }
        logger.info("执行核对提醒插入信息操作结束");
        return new Result("核对提醒录入成功！");
    }

    @ServiceLog(doAction = "我的账单-创建账单")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result billCreate(PayBillCreateParamVo payBillCreateParamVo) {
        /**根据用户账号/企业ID查询企业信息（用户为企业管理员） */
        logger.info("我的账单-创建账单,参数：payBillCreateParamVo={},user={}", JsonUtil.object2Json(payBillCreateParamVo));
        List<TbPayAccountBook> tbPayAccountBook = null;
        List<TbPayAccount> tbPayAccount = null;
        Result<Boolean> result = new Result<>();
        TbPayAccountBookCriteria billCriteria = new TbPayAccountBookCriteria();
        TbPayAccountCriteria accountCriteria = new TbPayAccountCriteria();
        if (payBillCreateParamVo.getObjType().equals(PaymentBillEnum.BILL_OBJ_TYPE_IS_COMPANY.getCode())) {
            /**如果是企业则去查询企业信息再通过查询的企业的管理员账户去查询账户表*/
            logger.info("如果是企业则去查询企业信息再通过查询的企业的管理员账户去查询账户表,ObjId={}",payBillCreateParamVo.getObjId());
            ServiceCompany serviceCompany = companyService.getCompanyDetailByAccountOrId(payBillCreateParamVo.getObjId());
            if (serviceCompany == null || StringUtils.isBlank(serviceCompany.getComAdmin())) {
                /**查询企业信息异常*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.QUERY_ENTERPRISE_INFO_ERROR);
            }
            /**通过企业管理员获取账户ID*/
            accountCriteria.createCriteria().andUserIdEqualTo(serviceCompany.getComAdmin()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            tbPayAccount = tbPayAccountMapper.selectByExample(accountCriteria);
        } else if (payBillCreateParamVo.getObjType().equals(PaymentBillEnum.BILL_OBJ_TYPE_IS_INDIVIDUAL.getCode())) {
            /**如果是个人则用个人对象名称去查询账户表*/
            accountCriteria.createCriteria().andUserIdEqualTo(payBillCreateParamVo.getObjId()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            tbPayAccount = tbPayAccountMapper.selectByExample(accountCriteria);
        }
        if (tbPayAccount.size() > Integer.parseInt(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode()) || tbPayAccount.size() == Integer.parseInt(PaymentBillEnum.BILL_STATE_DELETE.getCode())) {
            /**查询账户信息异常*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ACCOUNT_IS_NOT_EXIT);
        }
        /**通过账户表的账户ID查询账本信息*/
        logger.info("通过账户表的账户ID查询账本信息,账户ID={}",tbPayAccount.get(0).getAccountId());
        /**因电费账本是一个账户下有多个，所以需要单独处理查询条件*/
        if(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode().equals(payBillCreateParamVo.getAcBookType())){
            billCriteria.createCriteria().andAccountIdEqualTo(tbPayAccount.get(0).getAccountId()).andAcBookTypeEqualTo(payBillCreateParamVo.getAcBookType()).andMeterCodeEqualTo(payBillCreateParamVo.getMeterCode()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        }else{
            billCriteria.createCriteria().andAccountIdEqualTo(tbPayAccount.get(0).getAccountId()).andAcBookTypeEqualTo(payBillCreateParamVo.getAcBookType()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        }
        tbPayAccountBook = tbPayAccountBookMapper.selectByExample(billCriteria);
        if (tbPayAccountBook.size() > Integer.parseInt(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode()) || tbPayAccountBook.size() == Integer.parseInt(PaymentBillEnum.BILL_STATE_DELETE.getCode())) {
            /**查询账本信息异常*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
        }
        /** 插入账单信息*/
        logger.info("开始执行统一缴费插入账单信息操作");
        TbPayBill tb = new TbPayBill();
        BeanUtils.copyProperties(payBillCreateParamVo, tb);
        tb.setAcBookId(tbPayAccountBook.get(0).getAcBookId());
        tb.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_NOT_PAY.getCode());
        tb.setPaymentType(PaymentBillEnum.PAY_METHOD_ONLINE.getCode());
        tb.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        tb.setReminderNumber(Integer.parseInt(PaymentBillEnum.PAY_REMINDER_NUMBER.getCode()));
        tb.setPaymentAffirm(PaymentBillEnum.BILL_AC_BOOK_CHECK_2.getCode());
        tb.setBillReceiver(tbPayAccount.get(0).getUserId());
        logger.info("执行统一缴费插入账单信息操作,入參【{}】", tb.toString());
        /**判断是否有相同的账单*/
        TbPayBill tbPayBill3 = tbPayBillMapper.selectByPrimaryKey(tb.getBillId());
        logger.info("判断是否有相同的账单返回结果【{}】",JsonUtil.object2Json(tbPayBill3));
        if(tbPayBill3 == null){
            tbPayBillMapper.insertSelective(tb);
            logger.info("结束执行统一缴费插入账单信息操作");
        }
        if(tbPayBill3 != null){
            if(tbPayBill3.getRecordStatus().equals(PaymentBillEnum.BILL_STATE_DELETE.getCode())){
                tbPayBillMapper.updateByPrimaryKeySelective(tb);
                logger.info("结束执行统一缴费更新账单信息操作");
            }else if(tbPayBill3.getRecordStatus().equals(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode())){
                throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_EXIT);
            }
        }

        /** 插入账单详情信息*/
        logger.info("开始执行统一缴费插入账单详情信息操作");
        List<TbPayBillDetails> list = new ArrayList<>();
        if (payBillCreateParamVo.getPayBillDetails().size() > 0) {
            for (PayBillDetails tp : payBillCreateParamVo.getPayBillDetails()) {
                TbPayBillDetails tb2 = new TbPayBillDetails();
                tb2.setBillId(payBillCreateParamVo.getBillId());
                tb2.setCreatedTime(payBillCreateParamVo.getCreatedTime());
                tb2.setCreatorAccount(payBillCreateParamVo.getCreatorAccount());
                tb2.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                tb2.setDetailsId(AutoOrderUtil.autoOrderId());
                BeanUtils.copyProperties(tp, tb2);
                list.add(tb2);
            }
            payBillDao.insertList(list);
        }
        logger.info("结束执行统一缴费插入账单详情信息操作");
        TbPayBill tbs = tbPayBillMapper.selectByPrimaryKey(tb.getBillId());
        if (null == tbs) {
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        /**判断创建的账单费用是否为0，如果为0，直接更新账单为支付成功*/
        BigDecimal amount = new BigDecimal(0);
        if(tbs.getBillExpense().compareTo(amount) == 0){
            tbs.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
            tbs.setModifiedTime(new Date());
            tbs.setPaymentTime(new Date());
            if(StringUtils.isNotBlank(payBillCreateParamVo.getCreatorAccount())){
                tbs.setModifierAccount(payBillCreateParamVo.getCreatorAccount());
            }
            int i = tbPayBillMapper.updateByPrimaryKeySelective(tbs);
            if (i > 0){
                /**回调通知各业务测账单状态*/
                if(StringUtils.isNotBlank(tbs.getCallbackId()) && StringUtils.isNotBlank(tbs.getCallbackUrl())) {
                    PayCallBackNotify payCallBackNotify = new PayCallBackNotify();
                    payCallBackNotify.setBillId(tbs.getBillId());
                    payCallBackNotify.setPaymentState(tbs.getPaymentState());
                    result = delaySend(payCallBackNotify, tbs);
                    return result;
                }
            }
        }
        /**判断是否是电费账单，如果是电费账单，则直接扣除费用*/
        TbPayAccountBookMoneyRecord tpbmr = new TbPayAccountBookMoneyRecord();
        if (tbs.getAcBookType().equals(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode())) {
            /**比较金额大小即左边比右边数大，返回1，相等返回0，比右边小返回-1*/
            int i = tbPayAccountBook.get(0).getBalance().compareTo(tbs.getBillExpense());
            logger.info("比较金额大小结果：{}", i);
            try {
                if (i == 1 || i == 0) {
                    /**扣除账本金额，并更新账单状态和插入流水记录*/
                    BigDecimal totalAmount = new BigDecimal(tbPayAccountBook.get(0).getBalance().toString());
                    totalAmount = totalAmount.subtract(tbs.getBillExpense());
                    tbPayAccountBook.get(0).setBalance(totalAmount);
                    logger.info("开始执行统一缴费扣除账本金额操作,入參【{}】", tbPayAccountBook.get(0).toString());
                    tbPayAccountBookMapper.updateByPrimaryKeySelective(tbPayAccountBook.get(0));
                    logger.info("结束执行统一缴费扣除账本金额操作");
                    logger.info("开始执行统一缴费插入流水记录操作");
                    tpbmr.setDeductionId(AutoOrderUtil.autoOrderId());
                    tpbmr.setBillId(tbs.getBillId());
                    tpbmr.setAcBookId(tbs.getAcBookId());
                    tpbmr.setRemark(tbs.getBillSource());
                    tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_QIAN_BAO.getMessage());
                    tpbmr.setPaymentAction(PaymentBillActionEnum.BILL_STATE_AUYTO.getCode());
                    tpbmr.setNatureCode(PaymentBillEnum.BILL_ACCOUNT_BOOK_FEE.getCode());
                    tpbmr.setMoney(tbs.getBillExpense());
                    tpbmr.setBalance(totalAmount);
                    tpbmr.setCreatorAccount(payBillCreateParamVo.getCreatorAccount());
                    tpbmr.setCreatedTime(new Date());
                    tpbmr.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                    logger.info("统一缴费插入流水记录入參【{}】", tpbmr.toString());
                    tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
                    logger.info("结束执行统一缴费插入流水记录操作");
                    /**更新账单状态*/
                    logger.info("开始执行统一缴费更新账单状态操作");
                    tbs.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
                    tbs.setPaymentTime(new Date());
                    tbs.setModifiedTime(new Date());
                    if(StringUtils.isNotBlank(payBillCreateParamVo.getCreatorAccount())){
                        tbs.setModifierAccount(payBillCreateParamVo.getCreatorAccount());
                    }
                    logger.info("执行统一缴费更新账单状态操作,入參【{}】", tbs.toString());
                    tbPayBillMapper.updateByPrimaryKeySelective(tbs);
                    logger.info("结束执行统一缴费更新账单状态操作");
                    /**回调通知各业务测账单状态*/
                    if(StringUtils.isNotBlank(tbs.getCallbackId()) && StringUtils.isNotBlank(tbs.getCallbackUrl())) {
                        PayCallBackNotify payCallBackNotify = new PayCallBackNotify();
                        payCallBackNotify.setBillId(tbs.getBillId());
                        payCallBackNotify.setPaymentState(tbs.getPaymentState());
                        result = delaySend(payCallBackNotify, tbs);
                    }
                }
            } catch (Exception e) {
                throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_DEDUCTION_FEE_ERROR);
            }
        }
        logger.info("【创建账单】开始发送通知");
        TbPayBill tb3 = tbPayBillMapper.selectByPrimaryKey(tbs.getBillId());
        if (null == tb3) {
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        User user = new User();
        user.setAccount(tb3.getBillReceiver());
        logger.info("【创建账单】开始发送通知,获取用户信息入參【{}】",JsonUtil.object2Json(user));
        Result<User> user1 = systemClient.getUser(user);
        logger.info("【创建账单】开始发送通知,获取用户信息返回结果【{}】",JsonUtil.object2Json(user1));
        if(user1 != null && user1.getData() != null){
            if(tb3.getPaymentState().equals(PaymentBillEnum.BILL_ORDER_IS_NOT_PAY.getCode())){
                if (StringUtils.isNotBlank(user1.getData().getPhone())) {
                    //待支付状态，发送待缴短信通知
                    sendPaymentNotice("1020",new String[]{user1.getData().getPhone()},new String[]{});
                }
                if (StringUtils.isNotBlank(user1.getData().getEmail())) {
                    //发送待缴邮件
                    sendPaymentEmail(user1.getData().getEmail(), tb3.getBillName(), PaymentBillExceptionEnum.PAYMENT_EMAIL_CONTEXT.getMessage());
                }

            }else if(tb3.getPaymentState().equals(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //已支付状态，发送缴费成功短信通知
                if (StringUtils.isNotBlank(user1.getData().getPhone())) {
                    String[] phone = {user1.getData().getPhone()};
                    String[] str = {tpbmr.getBillId(), PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getMessage(), tpbmr.getMoney().toString(), sdf.format(tpbmr.getCreatedTime())};
                    sendPaymentNotice("1021", phone, str);
                }
                //发送缴费成功通知邮件
                if (StringUtils.isNotBlank(user1.getData().getEmail())) {
                    String email = user1.getData().getEmail();
                    String emailSubject = tb3.getBillName();
                    StringBuffer emailContent = new StringBuffer();
                    emailContent.append("【白下高新区】您好，您已缴费成功，账单号：").append(tpbmr.getBillId()).append(",").append("账单名称：").append(tb3.getBillName())
                            .append(",").append("支付金额：").append(tpbmr.getMoney().toString()).append(",").append("缴费时间：").append(sdf.format(tpbmr.getCreatedTime()));
                    sendPaymentEmail(email, emailSubject, emailContent.toString());
                }
            }
        }

        return result;
    }

    @ServiceLog(doAction = "我的账单-统一缴费回调各业务侧方法")
    public Result<Boolean> delaySend(PayCallBackNotify payCallBackNotify,TbPayBill tbs){
        logger.info("统一缴费回调各业务侧方法,入參：【{}】", JSONObject.toJSONString(payCallBackNotify),JSONObject.toJSONString(tbs));
        Result<Boolean> result = new Result<>();
        Delay delay = new Delay();
        delay.setServiceId(tbs.getCallbackId());
        delay.setServiceUrl(tbs.getCallbackUrl());
        delay.setTtl("30");
        delay.setDataString(JSONObject.toJSONString(payCallBackNotify));
        logger.info("接收到延迟消息内容：【{}】", JSONObject.toJSONString(payCallBackNotify));
        logger.info("开始回调");
        result = delaySendMessageClient.delaySend(delay);
        logger.info("结束回调,返回结果，【{}】", result.toString());
        return result;
    }

    @ServiceLog(doAction = "我的账单-统一缴费发起支付")
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Result<PayOrderRsp> startPayment(CreateOrderAndPayReqModel createOrderAndPayReqModel, User user) {
        String[] billIds = createOrderAndPayReqModel.getGoodsIdArr();
        if (null == billIds || billIds.length == 0) {
            /**判断前端传的账单ID是否为空*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ID_IS_NOT_NULL);
        }
        TbPayBillCriteria billCriteria = new TbPayBillCriteria();
        List<String> strings = Arrays.asList(billIds);
        billCriteria.createCriteria().andBillIdIn(strings).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        List<TbPayBill> tbPayBills = tbPayBillMapper.selectByExample(billCriteria);
        if (null == tbPayBills || tbPayBills.size() == 0) {
            /**判断账单是否存在*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        if (tbPayBills.size() != createOrderAndPayReqModel.getGoodsIdArr().length) {
            /**判断选择缴费的账单是否与实际有效账单一致*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT, "选择账单数: " + createOrderAndPayReqModel.getGoodsIdArr().length
                    + " 条与实际有效账单数: " + tbPayBills.size() + " 条不匹配，请刷新页面再试。");
        }

        BigDecimal totalAmount = new BigDecimal(0);
        StringBuffer sb = new StringBuffer();
        for (TbPayBill bill : tbPayBills) {
            if (StringUtils.equals(bill.getPaymentState(), PaymentBillEnum.BILL_ORDER_IS_PAY.getCode())) {
                /**判断选择缴费的账单是否都是未支付状态*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY, "账单：" + bill.getBillId() + "已支付，请刷新页面重试。");
            }
            boolean flag = Arrays.asList(billIds).contains(bill.getBillId());
            if (!flag) {
                throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_PAY_ORDER_MISMATCH, "账单编号：" + bill.getBillId() + "");
            }
            BigDecimal decimal = new BigDecimal(String.valueOf(bill.getBillExpense()));
            totalAmount = totalAmount.add(decimal);
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(bill.getBillId());
        }
        /**开始校验金额，比较金额大小即左边比右边数大，返回1，相等返回0，比右边小返回-1*/
        logger.info("统一支付校验输入金额和账单金额开始，输入金额【{}】，账单金额【{}】",createOrderAndPayReqModel.getPaySum(),totalAmount);
        int i = createOrderAndPayReqModel.getPaySum().compareTo(totalAmount);
        logger.info("统一支付校验输入金额和账单金额,比较金额大小结果,相等返回0：【{}】", i);
        if(i != 0){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.COMMIT_AMOUNT_NOT_EQUAL_BILL_AMOUNT);
        }
        Result<PayOrderRsp> result;

            /**调用支付接口发起支付*/
            logger.info("开始调用统一缴费发起支付接口操作");
            PayOrderReq payOrderReq = new PayOrderReq();
            payOrderReq.setMchOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
            payOrderReq.setChannelId(createOrderAndPayReqModel.getChannelId());
            payOrderReq.setAmount(Long.parseLong(MoneyUtils.changeY2F(String.valueOf(totalAmount))));
            payOrderReq.setParam1(sb.toString());
            payOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
            payOrderReq.setSubject("统一缴费账单");
            payOrderReq.setBody("统一缴费账单");
            payOrderReq.setServiceId(ENT_CLIENT);
            payOrderReq.setServiceUrl(ENT_CLIENT_CALLBOCK_SERVICE);
           /** 签名*/
            String sign = PayDigestUtil.getSign(BeanToMap.toMap(payOrderReq), MchIdEnum.MCH_BASE.getReqKey());
            payOrderReq.setSign(sign);
            logger.info("调用 统一支付下单接口,请求参数{}", payOrderReq);
            result = payOrderClient.createPayOrder(payOrderReq);
            logger.info("调用统一支付下单接口返回结果{}", result);
            if (!StringUtils.equals(result.getCode(), GlobalConstants.SUCCESS_CODE)) {
                logger.info("统一支付下单失败，{}", payOrderReq);
                return result;
            }
            /*******验证响应签名 ********/
            boolean verifyFlag = XXPayUtil.verifyPaySign(BeanToMap.toMap(result.getData()), MchIdEnum.MCH_BASE.getRspKey());
            if (!verifyFlag) {
                logger.info(" 支付验证响应签名失败  fail ！verifyFlag={}", verifyFlag);
                return new Result<>("-1", "支付验证响应签名失败");
            }
            if (result.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
                /**返回成功状态，更新订单号到账单表*/
                logger.info("调用统一支付下单接口，返回成功状态，更新统一订单号到账单表操作开始");
                TbPayBill tb = new TbPayBill();
                tb.setOrderNumber(payOrderReq.getMchOrderNo());
                tbPayBillMapper.updateByExampleSelective(tb, billCriteria);
                logger.info("调用统一支付下单接口，返回成功状态，更新统一订单号到账单表操作结束");
                logger.info("调用统一支付下单接口，插入账单信息到账单中间表，便于核查验证账单操作开始");
                TbPayBillMiddle tbPayBillMiddle = new TbPayBillMiddle();
                tbPayBillMiddle.setBillIds(sb.toString());
                tbPayBillMiddle.setOrderNumber(payOrderReq.getMchOrderNo());
                tbPayBillMiddle.setPayOrderId(result.getData().getPayOrderId());
                tbPayBillMiddle.setTotalMoney(totalAmount);
                tbPayBillMiddle.setStatus(PaymentBillEnum.BILL_ORDER_IS_NOT_PAY.getCode());
                tbPayBillMiddle.setCreatedTime(new Date());
                tbPayBillMiddle.setCreatorAccount(createOrderAndPayReqModel.getUserAccount());
                tbPayBillMiddle.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                logger.info("调用统一支付下单接口，插入账单信息到账单中间表，入參【{}】", tbPayBillMiddle.toString());
                tbPayBillMiddleMapper.insertSelective(tbPayBillMiddle);
                logger.info("调用统一支付下单接口，插入账单信息到账单中间表，便于核查验证账单操作结束");
            }

        return result;
    }

    @ServiceLog(doAction = "我的账单-统一缴费回调")
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Result payCallBack(PayOrderNotify callBackParam, User user) {
        logger.info("统一缴费回调接参【{}】", callBackParam.toString());
        if (StringUtils.isBlank(callBackParam.getStatus().toString())) {
            /**判断回调参数支付状态是否为空*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_CALLBACK_IS_NULL);
        }
        if (StringUtils.isBlank(callBackParam.getMchOrderNo())) {
            /**判断回调参数商户订单号是否为空*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_CALLBACK_ID_IS_NULL);
        }
        /**查询支付订单的支付状态*/
        PayOrderQueryReq req = new PayOrderQueryReq();
        req.setPayOrderId(callBackParam.getPayOrderId());
        /**签名*/
        String sign = PayDigestUtil.getSign(BeanToMap.toMap(req), MchIdEnum.MCH_BASE.getReqKey());
        req.setSign(sign);
        logger.info("调用支付查询接口，请求参数:{}", req);
        Result<PayOrderQueryRsp> rep = payOrderClient.payOrderQuery(req);
        logger.info("调用支付查询接口，返回参数:{}", rep);

        /**支付成功*/
        if (rep.getData().getStatus().toString().equals(PaymentBillCallBackEnum.BILL_CALL_BACK_OK.getCode())) {
            try {
                TbPayBillCriteria billCriteria = new TbPayBillCriteria();
                billCriteria.createCriteria().andOrderNumberEqualTo(rep.getData().getMchOrderNo()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
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
                    addAccountBookMoneyAndRecord(tbPayBills.get(i), tbPayAccountBook, callBackParam, user);
                    /**再减去账本金额*/
                    removeAccountBookMoneyAndRecord(tbPayBills.get(i), tbPayAccountBook, callBackParam, user);
                    /**更新账单状态*/
                    logger.info("调用统一支付下单接口回调，更新账单状态操作开始");
                    tbPayBills.get(i).setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
                    if(user != null && StringUtils.isNotBlank(user.getAccount())){
                        tbPayBills.get(i).setModifierAccount(user.getAccount());
                    }
                    tbPayBills.get(i).setModifiedTime(new Date());
                    tbPayBills.get(i).setPaymentTime(new Date());
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
                    delay.setDataString(JSONObject.toJSONString(payCallBackNotify));
                    logger.info("接收到延迟消息内容：【{}】", delay.toString());
                    logger.info("开始回调");
                    Result<Boolean> result2 = delaySendMessageClient.delaySend(delay);
                    logger.info("结束回调结果，【{}】", result2);
                }
                logger.info("调用统一支付下单接口回调，更新账单状态到账单中间表操作开始");
                TbPayBillMiddle tbPayBillMiddle = new TbPayBillMiddle();
                tbPayBillMiddle.setOrderNumber(tbPayBills.get(0).getOrderNumber());
                tbPayBillMiddle.setStatus(callBackParam.getStatus().toString());
                tbPayBillMiddleMapper.updateByPrimaryKeySelective(tbPayBillMiddle);
                logger.info("调用统一支付下单接口回调，更新账单状态到账单中间表入參【{}】", tbPayBillMiddle.toString());
                logger.info("调用统一支付下单接口回调，更新账单状态到账单中间表操作结束");
                logger.info("回调成功，支付状态更新为：已支付");

                /**支付成功发送短信*/
                for (int i = 0; i < tbPayBills.size(); i++) {
                    User user1 = new User();
                    user1.setAccount(tbPayBills.get(i).getBillReceiver());
                    logger.info("【支付回调成功】开始发送通知,获取用户信息入參【{}】",JsonUtil.object2Json(user1));
                    Result<User> user2 = systemClient.getUser(user1);
                    logger.info("【支付回调成功】开始发送通知,获取用户信息返回结果【{}】",JsonUtil.object2Json(user2));
                    if(user2 != null && user2.getData() != null){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        //已支付状态，发送缴费成功短信通知
                        if (StringUtils.isNotBlank(user2.getData().getPhone())) {
                            String[] phone = {user2.getData().getPhone()};
                            String[] str = {tbPayBills.get(i).getBillId(), tbPayBills.get(i).getBillName(), tbPayBills.get(i).getBillExpense().toString(), sdf.format(tbPayBills.get(i).getCreatedTime())};
                            sendPaymentNotice("1021", phone, str);
                        }
                        //发送缴费成功通知邮件
                        if (StringUtils.isNotBlank(user2.getData().getEmail())) {
                            String email = user2.getData().getEmail();
                            String emailSubject = tbPayBills.get(i).getBillName();
                            StringBuffer emailContent = new StringBuffer();
                            emailContent.append("【白下高新区】您好，您已缴费成功，账单号：").append(tbPayBills.get(i).getBillId()).append(",").append("账单名称：").append(tbPayBills.get(i).getBillName())
                                    .append(",").append("支付金额：").append(tbPayBills.get(i).getBillExpense().toString()).append(",").append("缴费时间：").append(sdf.format(tbPayBills.get(i).getCreatedTime()));
                            sendPaymentEmail(email, emailSubject, emailContent.toString());
                        }
                    }
                }
                return new Result("回调成功，支付状态更新为：已支付");
            } catch (Exception e) {
                throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_QUERY_ERROR);
            }
            /**支付中*/
        } else if (rep.getData().getStatus().toString().equals(PaymentBillCallBackEnum.BILL_CALL_BACK_WAIT.getCode())) {
            logger.info("支付状态为支付中，无需回调");
            return new Result("-1", "支付状态为支付中，无需回调");
        } else {
            logger.info("支付状态不是支付成功，无需回调");
            return new Result("-1", "支付状态不是支付成功，无需回调");
        }
    }

    @Override
    @ServiceLog(doAction = "预缴充值")
    @Transactional(rollbackFor = RuntimeException.class)
    public Result<PayOrderRsp> insertPrepaidRecharge(CreateOrderAndPayReqModel createOrderAndPayReqModel, User user) {
        //账本就是商品
        String acBookId=createOrderAndPayReqModel.getGoodsIdArr()[0];
        /**查询传的账本编号是否存在*/
        TbPayAccountBook tbPayAccountBook = tbPayAccountBookMapper.selectByPrimaryKey(acBookId);
        if (null == tbPayAccountBook) {
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
        }
        Result<PayOrderRsp> result;
        try {
            /**调用统一支付接口*/
            logger.info("开始调用发起支付接口操作");
            PayOrderReq payOrderReq = new PayOrderReq();
            payOrderReq.setMchOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
            payOrderReq.setChannelId(createOrderAndPayReqModel.getChannelId());
            payOrderReq.setAmount(Long.parseLong(MoneyUtils.changeY2F(String.valueOf(createOrderAndPayReqModel.getPaySum()))));
            payOrderReq.setMchId(MchIdEnum.MCH_BASE.getCode());
            payOrderReq.setSubject("预缴充值");
            payOrderReq.setBody("预缴充值");
            payOrderReq.setServiceId(ENT_CLIENT);
            payOrderReq.setServiceUrl(ENT_CLIENT_CALLBOCK_FEE_SERVICE);
            /**签名*/
            String sign = PayDigestUtil.getSign(BeanToMap.toMap(payOrderReq), MchIdEnum.MCH_BASE.getReqKey());
            payOrderReq.setSign(sign);
            logger.info("调用 统一支付下单接口,请求参数{}", payOrderReq);
            result = payOrderClient.createPayOrder(payOrderReq);
            logger.info("调用统一支付下单接口返回结果{}", result);
            if (!StringUtils.equals(result.getCode(), GlobalConstants.SUCCESS_CODE)) {
                logger.info("统一支付下单失败，{}", payOrderReq);
                return result;
            }
            /*******验证响应签名 ********/
            boolean verifyFlag = XXPayUtil.verifyPaySign(BeanToMap.toMap(result.getData()), MchIdEnum.MCH_BASE.getRspKey());
            if (!verifyFlag) {
                logger.info(" 支付验证响应签名失败  fail ！verifyFlag={}", verifyFlag);
                return new Result<>("-1", "支付验证响应签名失败");
            }
            if (result.getCode().equals(GlobalConstants.SUCCESS_CODE)) {
                /**返回成功状态，更新信息到账单中间表*/
                logger.info("调用统一支付下单接口，插入账单信息到账单中间表，便于核查验证账单操作开始");
                TbPayBillMiddle tbPayBillMiddle = new TbPayBillMiddle();
                tbPayBillMiddle.setBillIds(acBookId);
                tbPayBillMiddle.setOrderNumber(payOrderReq.getMchOrderNo());
                tbPayBillMiddle.setPayOrderId(result.getData().getPayOrderId());
                tbPayBillMiddle.setTotalMoney(createOrderAndPayReqModel.getPaySum());
                tbPayBillMiddle.setStatus(PaymentBillEnum.BILL_ORDER_IS_NOT_PAY.getCode());
                tbPayBillMiddle.setCreatedTime(new Date());
                tbPayBillMiddle.setCreatorAccount(createOrderAndPayReqModel.getUserAccount());
                tbPayBillMiddle.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                tbPayBillMiddleMapper.insertSelective(tbPayBillMiddle);
                logger.info("调用统一支付下单接口，插入账单信息到账单中间表，便于核查验证账单操作结束");
            }
        } catch (Exception e) {
            throw new JnSpringCloudException(PaymentBillExceptionEnum.NETWORK_ANOMALY);
        }
        return result;
    }

    @Override
    @ServiceLog(doAction = "预缴充值回调接口")
    @Transactional(rollbackFor = RuntimeException.class)
    public Result payAccountCallBack(PayOrderNotify callBackParam, User user) {
        if (StringUtils.isBlank(callBackParam.getStatus().toString())) {
            /**判断回调参数支付状态是否为空*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_CALLBACK_IS_NULL);
        }
        if (StringUtils.isBlank(callBackParam.getMchOrderNo())) {
            /**判断回调参数商户订单号是否为空*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_CALLBACK_ID_IS_NULL);
        }
        //查询支付订单的支付状态
        PayOrderQueryReq req = new PayOrderQueryReq();
        req.setPayOrderId(callBackParam.getPayOrderId());
        //签名
        String sign = PayDigestUtil.getSign(BeanToMap.toMap(req), MchIdEnum.MCH_BASE.getReqKey());
        req.setSign(sign);
        logger.info("调用支付查询接口，请求参数:{}", req);
        Result<PayOrderQueryRsp> rep = payOrderClient.payOrderQuery(req);
        logger.info("调用支付查询接口，返回参数:{}", rep);
        /**支付成功*/
        if (rep.getData().getStatus().toString().equals(PaymentBillCallBackEnum.BILL_CALL_BACK_OK.getCode())) {
            try {
                TbPayBillMiddleCriteria billCriteria = new TbPayBillMiddleCriteria();
                billCriteria.createCriteria().andOrderNumberEqualTo(rep.getData().getMchOrderNo()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                List<TbPayBillMiddle> tbPayBillMiddles = tbPayBillMiddleMapper.selectByExample(billCriteria);
                if (null == tbPayBillMiddles || tbPayBillMiddles.size() == 0) {
                    /**判断通过统一缴费下单号是否存在在支付账单中间表*/
                    throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_MIDDLE_IS_NOT_EXIT);
                }
                /**判断查询的账单状态是否为已支付*/
                if (tbPayBillMiddles.get(0).getStatus().equals(PaymentBillEnum.BILL_ORDER_IS_PAY)) {
                    throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY);
                }
                TbPayAccountBook tbPayAccountBook = tbPayAccountBookMapper.selectByPrimaryKey(tbPayBillMiddles.get(0).getBillIds());
                if (null == tbPayAccountBook) {
                    throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
                }
                /**补充账本金额*/
                TbPayBill tbPayBill = new TbPayBill();
                tbPayBill.setBillExpense(new BigDecimal(MoneyUtils.changeF2Y(callBackParam.getAmount())));
                tbPayBill.setAcBookId(tbPayAccountBook.getAcBookId());
                addAccountBookMoneyAndRecord(tbPayBill, tbPayAccountBook, callBackParam, user);
                logger.info("调用统一支付下单接口回调，更新账单状态到账单中间表操作开始");
                tbPayBillMiddles.get(0).setStatus(callBackParam.getStatus().toString());
                tbPayBillMiddleMapper.updateByPrimaryKeySelective(tbPayBillMiddles.get(0));
                logger.info("调用统一支付下单接口回调，更新账单状态到账单中间表操作结束");
                logger.info("回调成功，支付状态更新为：已支付");
                /**用户充值后，去查询是否有代缴的自动扣费账单，并进行扣费*/
                PayAutoDeduParam payAutoDeduParam = new PayAutoDeduParam();
                payAutoDeduParam.setAcBookId(tbPayAccountBook.getAcBookId());
                Delay delay = new Delay();
                delay.setServiceId("springcloud-enterprise");
                delay.setServiceUrl("/api/payment/payAccount/automaticDeduction");
                delay.setTtl("30");
                delay.setDataString(JSONObject.toJSONString(payAutoDeduParam));
                logger.info("接收到延迟消息内容：【{}】", JSONObject.toJSONString(payAutoDeduParam));
                logger.info("开始回调");
                Result<Boolean> result = delaySendMessageClient.delaySend(delay);
                logger.info("结束回调,返回结果，【{}】", result.toString());

                return new Result("回调成功，支付状态更新为：已支付");
            } catch (Exception e) {
                throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_QUERY_ERROR);
            }
            /**支付中*/
        }else if(rep.getData().getStatus().equals(PaymentBillCallBackEnum.BILL_CALL_BACK_WAIT.getCode())) {
            logger.info("支付状态为支付中，无需回调");
            return new Result("-1", "支付状态为支付中，无需回调");
        }else{
            logger.info("支付状态不是支付成功，无需回调");
            return new Result("-1", "支付状态不是支付成功，无需回调");
        }
    }

    @Override
    @ServiceLog(doAction = "插入流水记录")
    public Result insertRecord(PayAccountBookMoneyRecord payAccountBookMoneyRecord) {
        logger.info("插入流水表记录操作，入參【{}】", JsonUtil.object2Json(payAccountBookMoneyRecord));
        TbPayAccountBookMoneyRecord tb = new TbPayAccountBookMoneyRecord();
        BeanUtils.copyProperties(payAccountBookMoneyRecord,tb);
        tbPayAccountBookMoneyRecordMapper.insertSelective(tb);
        logger.info("插入流水表记录操作结束");
        return new Result("插入流水记录成功！");
    }

    @Override
    @ServiceLog(doAction = "我的账单-线下缴费确认回调各业务侧接口")
    @Transactional(rollbackFor = Exception.class)
    public Result callbackServiceSide(PayCallbackServiceSideParam payCallbackServiceSideParam, User user) {
        logger.info("进入【我的账单-线下缴费确认回调各业务侧接口】方法,入參【{}】",JsonUtil.object2Json(payCallbackServiceSideParam));
        TbPayBill tbPayBill = tbPayBillMapper.selectByPrimaryKey(payCallbackServiceSideParam.getBillId());
        /**判断账单是否存在*/
        if(tbPayBill == null){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        /**判断账单是否已支付*/
        if(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode().equals(tbPayBill.getPaymentState())){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY_CONFIRM);
        }
        /**更新账单为线下缴费*/
        tbPayBill.setPaymentAffirm(PaymentBillEnum.BILL_AC_BOOK_CHECK_1.getCode());
        tbPayBill.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
        tbPayBill.setPaymentType(PaymentBillEnum.PAY_METHOD_OFFLINE.getCode());
        tbPayBill.setAffirmPart(user.getAccount());
        tbPayBill.setAffirmTime(new Date());
        tbPayBill.setPaymentTime(new Date());
        logger.info("进入【我的账单-线下缴费确认回调各业务侧接口】方法,更新账单为线下缴费入參【{}】",JsonUtil.object2Json(tbPayBill));
        int i = tbPayBillMapper.updateByPrimaryKey(tbPayBill);
        if(i == 0){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_OFFLINE_CONFIRM_FAIL);
        }
        if(StringUtils.isNotBlank(tbPayBill.getCallbackId()) && StringUtils.isNotBlank(tbPayBill.getCallbackUrl())){
            TbPayBill tbs = tbPayBillMapper.selectByPrimaryKey(tbPayBill.getBillId());
            /**回调通知各业务测账单状态*/
            if(StringUtils.isNotBlank(tbs.getCallbackId()) && StringUtils.isNotBlank(tbs.getCallbackUrl())) {
                PayCallBackNotify payCallBackNotify = new PayCallBackNotify();
                payCallBackNotify.setBillId(tbs.getBillId());
                payCallBackNotify.setPaymentState(tbs.getPaymentState());
                Result<Boolean> result = delaySend(payCallBackNotify, tbs);
                logger.info("结束回调,返回结果，【{}】", result.toString());
            }
        }
        return new Result("线下缴费确认成功！");
    }

    @Override
    @ServiceLog(doAction = "我的账单-修改账单状态（已撤销）")
    public Result cancelBill(String billId, User user) {
        logger.info("进入【我的账单-修改账单状态（已撤销）】方法，入參【{}】",billId);
        TbPayBill tbPayBill = tbPayBillMapper.selectByPrimaryKey(billId);
        /**判断账单是否存在*/
        if(tbPayBill == null){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_IS_NOT_EXIT);
        }
        /**判断账单是否已支付*/
        if(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode().equals(tbPayBill.getPaymentState())){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_PAY_2);
        }
        /**判断账单是否已撤销*/
        if(PaymentBillEnum.BILL_ORDER_IS_RESCINDED.getCode().equals(tbPayBill.getPaymentState())){
            throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_RESCINDED);
        }
        /**修改账单状态为已撤销*/
        logger.info("进入【我的账单-修改账单状态（已撤销）】方法，修改账单状态为已撤销入參【{}】",JsonUtil.object2Json(tbPayBill));
        tbPayBill.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_RESCINDED.getCode());
        if(user != null){tbPayBill.setModifierAccount(user.getAccount());}
        tbPayBill.setModifiedTime(new Date());
        int i = tbPayBillMapper.updateByPrimaryKeySelective(tbPayBill);
        logger.info("进入【我的账单-修改账单状态（已撤销）】方法，修改账单状态为已撤销返回结果：",i);
        if (i > 0){
            return new Result("账单撤销成功");
        }
        Result result = new Result();
        result.setCode(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_RESCINDED_ERROR.getCode());
        result.setData(PaymentBillExceptionEnum.PAYMENT_STATUS_IS_RESCINDED_ERROR.getMessage());
        return result;
    }

    /**
     * 新增账本金额&插入流水记录
     *
     * @param tbPayBill,tbPayAccountBook,callBackParam
     * @return
     */
    @ServiceLog(doAction = "新增账本金额&插入流水记录")
    public void addAccountBookMoneyAndRecord(TbPayBill tbPayBill, TbPayAccountBook tbPayAccountBook, PayOrderNotify callBackParam, User user) {
        logger.info("进入新增账本金额&插入流水记录方法");
        try {
            /**先补充账本金额*/
            logger.info("调用统一支付下单接口回调，更新信息，先补充账本金额操作开始");
            TbPayAccountBook tbPay = tbPayAccountBookMapper.selectByPrimaryKey(tbPayAccountBook.getAcBookId());
            BigDecimal totalAmount = new BigDecimal(0);
            BigDecimal decimal = new BigDecimal(String.valueOf(tbPayBill.getBillExpense()));
            totalAmount = totalAmount.add(decimal).add(tbPay.getBalance());
            tbPay.setBalance(totalAmount);
            logger.info("调用统一支付下单接口回调，更新信息，先补充账本金额操作，入參【{}】", tbPay.toString());
            tbPayAccountBookMapper.updateByPrimaryKeySelective(tbPay);
            logger.info("调用统一支付下单接口回调，更新信息，先补充账本金额操作结束");
            /**插入流水表记录*/
            logger.info("调用统一支付下单接口回调，插入流水表记录操作开始");
            TbPayAccountBookMoneyRecord tpbmr = new TbPayAccountBookMoneyRecord();
            tpbmr.setDeductionId(AutoOrderUtil.autoOrderId());
            tpbmr.setBillId(tbPayBill.getBillId());
            tpbmr.setAcBookId(tbPayBill.getAcBookId());
            String[] tmp = callBackParam.getChannelId().split("_");
            if (tmp[0].equals(PaymentBillMethodEnum.BILL_STATE_WX_.getCode())) {
                tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_WX_.getMessage());
            } else if (tmp[0].equals(PaymentBillMethodEnum.BILL_STATE_ALIPAY_.getCode())) {
                tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_ALIPAY_.getMessage());
            }
            tpbmr.setPaymentAction(PaymentBillActionEnum.BILL_STATE_MANUAL.getCode());
            tpbmr.setNatureCode(PaymentBillEnum.BILL_ACCOUNT_BOOK_RECHARGE.getCode());
            tpbmr.setRemark(tbPayBill.getBillSource());
            tpbmr.setMoney(tbPayBill.getBillExpense());
            tpbmr.setBalance(totalAmount);
            tpbmr.setCreatedTime(new Date());
            if(tbPayBill.getCreatorAccount() != null){
                tpbmr.setCreatorAccount(tbPayBill.getCreatorAccount());
            }
            tpbmr.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            logger.info("调用统一支付下单接口回调，插入流水表记录操作，入參【{}】", tpbmr.toString());
            tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
            logger.info("调用统一支付下单接口回调，插入流水表记录操作结束");
            logger.info("结束新增账本金额&插入流水记录方法");
        } catch (Exception e) {
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_ADD_ERROR);
        }
    }

    /**
     * 扣除账本金额&插入流水记录
     *
     * @param tbPayBill,tbPayAccountBook,callBackParam
     * @return
     */
    @ServiceLog(doAction = "扣除账本金额&插入流水记录")
    public void removeAccountBookMoneyAndRecord(TbPayBill tbPayBill, TbPayAccountBook tbPayAccountBook, PayOrderNotify callBackParam, User user) {
        logger.info("进入扣除账本金额&插入流水记录方法");
        try {
            /**再扣除账本金额*/
            logger.info("调用统一支付下单接口回调，更新信息，再减去账本金额操作开始");
            /**查询账本最新余额*/
            TbPayAccountBook tbPay = tbPayAccountBookMapper.selectByPrimaryKey(tbPayAccountBook.getAcBookId());
            BigDecimal totalAmount = new BigDecimal(tbPay.getBalance().toString());
            totalAmount = totalAmount.subtract(tbPayBill.getBillExpense());
            tbPay.setBalance(totalAmount);
            logger.info("调用统一支付下单接口回调，更新信息，再减去账本金额操作,入參【{}】", tbPay.toString());
            tbPayAccountBookMapper.updateByPrimaryKeySelective(tbPay);
            logger.info("调用统一支付下单接口回调，更新信息，再减去账本金额操作结束");
            /**插入流水表记录*/
            logger.info("调用统一支付下单接口回调，插入流水表记录操作开始");
            TbPayAccountBookMoneyRecord tpbmr = new TbPayAccountBookMoneyRecord();
            tpbmr.setDeductionId(AutoOrderUtil.autoOrderId());
            tpbmr.setBillId(tbPayBill.getBillId());
            tpbmr.setAcBookId(tbPayBill.getAcBookId());
            String[] tmp = callBackParam.getChannelId().split("_");
            if (tmp[0].equals(PaymentBillMethodEnum.BILL_STATE_WX_.getCode())) {
                tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_WX_.getMessage());
            } else if (tmp[0].equals(PaymentBillMethodEnum.BILL_STATE_ALIPAY_.getCode())) {
                tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_ALIPAY_.getMessage());
            }
            tpbmr.setPaymentAction(PaymentBillActionEnum.BILL_STATE_MANUAL.getCode());
            tpbmr.setNatureCode(PaymentBillEnum.BILL_ACCOUNT_BOOK_FEE.getCode());
            tpbmr.setRemark(tbPayBill.getBillSource());
            tpbmr.setMoney(tbPayBill.getBillExpense());
            tpbmr.setBalance(totalAmount);
            tpbmr.setCreatedTime(new Date());
            if(tbPayBill.getCreatorAccount() != null){
                tpbmr.setCreatorAccount(tbPayBill.getCreatorAccount());
            }
            tpbmr.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            logger.info("调用统一支付下单接口回调，插入流水表记录操作,入參【{}】", tpbmr.toString());
            tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
            logger.info("调用统一支付下单接口回调，插入流水表记录操作结束");
            logger.info("结束扣除账本金额&插入流水记录方法");
        } catch (Exception e) {
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_REMOVE_ERROR);
        }
    }

    /**待缴通知提醒（短信，微信，APP，邮箱）*/
    @ServiceLog(doAction = "短信通知提醒")
    public void sendPaymentNotice(String templateId ,String[] phone,String[] message){
        logger.info("进入发送短信通知提醒方法");
        SmsTemplateVo smsTemplateVo = new SmsTemplateVo();
        smsTemplateVo.setTemplateId(templateId);
        smsTemplateVo.setMobiles(phone);
        smsTemplateVo.setContents(message);
        logger.info("短信发送参数：接收号码：{},短信内容：{}", phone, message);
        boolean sendStatus = messageSource.outputSms().send(MessageBuilder.withPayload(smsTemplateVo).build());
         if (sendStatus) {
            logger.info("[白下智慧园区]发送短信成功");
        } else {
            logger.error("[白下智慧园区]发送短信失败");
        }
    }

    @ServiceLog(doAction = "邮件通知提醒")
    public void sendPaymentEmail(String email ,String emailSubject,String emailContent){
        logger.info("进入发送邮件通知提醒方法");
        EmailVo emailVo = new EmailVo();
        emailVo.setEmail(email);
        emailVo.setEmailSubject(emailSubject);
        emailVo.setEmailContent(emailContent);
        logger.info("邮件发送参数：接收邮箱：{},邮件标题：{}，邮件内容：{}", email, emailSubject,emailContent);
        boolean sendStatus = messageSource.outputEmail().send(MessageBuilder.withPayload(emailVo).build());
        if (sendStatus) {
            logger.info("[白下智慧园区]发送邮件成功");
        } else {
            logger.error("[白下智慧园区]发送邮件失败");
        }
    }
}
