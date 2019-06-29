package com.jn.enterprise.pay.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.pay.dao.*;
import com.jn.enterprise.pay.entity.*;
import com.jn.enterprise.pay.enums.*;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.enterprise.pay.util.AutoOrderUtil;
import com.jn.park.api.ElectricMeterClient;
import com.jn.park.electricmeter.model.CompanyModel;
import com.jn.park.electricmeter.model.ElectricMeterInfoModel;
import com.jn.pay.model.*;
import com.jn.pay.vo.*;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxpay.common.util.JsonUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import com.jn.park.api.*;

/**
 * 我的账户(业务实现层)
 *
 * @author： wzy
 * @date： Created on 2019/5/5 11:50
 * @version： v1.0
 * @modified By:
 */
@Service
public class MyPayAccountServiceImpl implements MyPayAccountService {

    private static final Logger logger = LoggerFactory.getLogger(MyPayAccountServiceImpl.class);

    @Autowired
    private PayAccountAndAccountBookDao payAccountAndAccountBookDao;

    @Autowired
    private TbPayAccountBookMoneyRecordMapper tbPayAccountBookMoneyRecordMapper;

    @Autowired
    private TbPayAccountBookTypeMapper tbPayAccountBookTypeMapper;

    @Autowired
    private TbPayAccountMapper tbPayAccountMapper;

    @Autowired
    private TbPayAccountBookMapper tbPayAccountBookMapper;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SystemClient systemClient;

    @Autowired
    private TbPayBillMapper tbPayBillMapper;

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    @Autowired
    private ElectricMeterClient ElectricMeterClient;

    @ServiceLog(doAction = "我的账户-查询当前账户下所有账本信息")
    @Override
    public PayAccountAndAccountBookVo queryPayAccountBook(String userId) {
        //通过用户ID获取该用户账户并汇总余额查询
        PayAccountAndAccountBookVo abv = payAccountAndAccountBookDao.selectPayAccountId(userId);
        List<PayAccountBookVo> list = payAccountAndAccountBookDao.selectPayAccountBookList(abv.getAccountId());
        abv.setAccountBooksList(list);
        return abv;
    }

    @Override
    @ServiceLog(doAction = "我的账户-查询当前账户下所有账本缴费明细")
    public PaginationData<List<PayAccountBookRecordVo>> queryPayAccountBookInfo(PayAccountBookParam payAccountBookParam) {
        PageHelper.startPage(payAccountBookParam.getPage(), payAccountBookParam.getRows());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        List<PayAccountBookRecordVo> voList = payAccountAndAccountBookDao.queryPayAccountBookInfo(payAccountBookParam);
        //获取每个月份，通过月份组装返回给前端
        if (voList.size() > 0) {
            List<TbPayAccountBookType> list = selectPayBillType();
            for (PayAccountBookRecordVo tbPayBill : voList) {
                tbPayBill.setMonth(sdf.format(tbPayBill.getCreatedTime()));
                for (TbPayAccountBookType tb : list) {
                    if (StringUtils.isNotBlank(tbPayBill.getAcBookType()) && tbPayBill.getAcBookType().equals(tb.getAcBookType())) {
                        tbPayBill.setAcBookType(tb.getAcBookDesc());
                    }
                }
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

    @ServiceLog(doAction = "我的账本-账本明细详情查询")
    @Override
    public PaginationData<PayAccountBookMoneyRecordVo> queryPayAccountDetails(String deductionId, User user) {
        PayAccountBookMoneyRecordParam pay = new PayAccountBookMoneyRecordParam();
        pay.setDeductionId(deductionId);
        PayAccountBookMoneyRecordVo data = payAccountAndAccountBookDao.queryPayAccountDetails(pay);
        PaginationData paginationData = new PaginationData();
        paginationData.setRows(data);
        return paginationData;
    }

    @ServiceLog(doAction = "我的账本-获取费用预缴协议")
    @Override
    public Result<String> getFeeAdvanceAgreement(SysDictInvoke sysDictInvoke, User user) {
            Result<String> data= systemClient.selectDictValueByCondition(sysDictInvoke);
            logger.info("【获取费用预缴协议】 字典ID:{},字典值:{}}", sysDictInvoke.getKey(),data);
            return data;
    }

    @Override
    @ServiceLog(doAction = "我的账户-通过账本ID查询账本余额")
    public PayAccountBook queryPayAccountBookMoney(PayAccountBookMoney payAccountBookMoney) {
        logger.info("【我的账户-通过账本ID查询账本余额】 入參:{}}", JsonUtil.object2Json(payAccountBookMoney));
        PayAccountBook payAccountBook = new PayAccountBook();
        TbPayAccountBook tbPayAccountBook = tbPayAccountBookMapper.selectByPrimaryKey(payAccountBookMoney.getAcBookId());
        if (tbPayAccountBook == null) {
            /**查询账本信息异常*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
        }
        BeanUtils.copyProperties(tbPayAccountBook,payAccountBook);
        return payAccountBook;
    }

    @Override
    @ServiceLog(doAction = "线下预缴充值")
    @Transactional(rollbackFor = RuntimeException.class)
    public Result underAdvancePayment(PayUnderAdvancePaymentParam payUnderAdvancePaymentParam, User user) {
        TbPayAccountBook tbPayAccountBook = tbPayAccountBookMapper.selectByPrimaryKey(payUnderAdvancePaymentParam.getAcBookId());
        /**查询传的账本编号是否存在*/
        if (null == tbPayAccountBook) {
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
        }
        /**补充账本金额*/
        logger.info("【线下预缴充值】补充账本金额操作开始");
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal decimal = new BigDecimal(String.valueOf(payUnderAdvancePaymentParam.getRechargeAmount()));
        totalAmount = totalAmount.add(decimal).add(tbPayAccountBook.getBalance());
        tbPayAccountBook.setBalance(totalAmount);
        logger.info("【线下预缴充值】补充账本金额操作，入參【{}】", JsonUtil.object2Json(tbPayAccountBook));
        tbPayAccountBookMapper.updateByPrimaryKeySelective(tbPayAccountBook);
        logger.info("【线下预缴充值】补充账本金额操作结束");
        /**插入流水表记录*/
        logger.info("【线下预缴充值】插入流水表记录操作开始");
        TbPayAccountBookMoneyRecord tpbmr = new TbPayAccountBookMoneyRecord();
        tpbmr.setDeductionId(AutoOrderUtil.autoOrderId());
        tpbmr.setAcBookId(tbPayAccountBook.getAcBookId());
        tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_UNDER.getCode());
        tpbmr.setPaymentAction(PaymentBillActionEnum.BILL_STATE_MANUAL.getCode());
        tpbmr.setNatureCode(PaymentBillEnum.BILL_ACCOUNT_BOOK_RECHARGE.getCode());
        tpbmr.setMoney(payUnderAdvancePaymentParam.getRechargeAmount());
        tpbmr.setBalance(totalAmount);
        tpbmr.setCreatedTime(new Date());
        tpbmr.setCreatorAccount(user.getAccount());
        tpbmr.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        logger.info("【线下预缴充值】插入流水表记录操作，入參【{}】", JsonUtil.object2Json(tpbmr));
        tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
        logger.info("【线下预缴充值】插入流水表记录操作结束");
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
        return new Result("线下充值成功！");
    }

    @Override
    @ServiceLog(doAction = "创建账户和账本")
    @Transactional(rollbackFor = Exception.class)
    public Result createPayAccountBook(PayAccountBookCreateParam payAccountBookCreateParam, User user) {
        logger.info("【进入创建账户和账本方法】，入參【{}】",JsonUtil.object2Json(payAccountBookCreateParam),JsonUtil.object2Json(user));
        /**1.验证该企业用户是否有统一缴费账户，不处理以后企业管理员是否变更*/
        TbPayAccount tbPayAccount1 = tbPayAccountMapper.selectByPrimaryKey(payAccountBookCreateParam.getComAdmin());
        /**调用内部接口电费点位接口,获取电表数据*/
        CompanyModel companyModel = new CompanyModel();
        companyModel.setCompanyId(payAccountBookCreateParam.getEnterId());
        logger.info("【统一缴费-创建账户和账本】，调用电费点位接口入參【{}】",JsonUtil.object2Json(companyModel));
        Result meterInfos = ElectricMeterClient.getMeterInfosByCompanyId(companyModel);
        logger.info("【统一缴费-创建账户和账本】，调用电费点位接口返回参数【{}】",JsonUtil.object2Json(meterInfos));
        List<ElectricMeterInfoModel> els = new ArrayList<>();
        if(meterInfos.getData() != null){
            els = (List<ElectricMeterInfoModel>) meterInfos.getData();
        }
        /**存储点位电表编码*/
        List<String> list = new ArrayList<>();
        /**存储电费账本电表编码*/
        List<String> list2 = new ArrayList<>();
        TbPayAccountBook tbPayAccountBook = new TbPayAccountBook();
        /**如果账本存在，需查询该账户下的电费账本是否存在*/
        List<TbPayAccountBook> tbPayAccountBooks = null;
        if (tbPayAccount1 != null) {
            /**1.查询该账户下电费账本信息*/
            TbPayAccountBookCriteria criteria = new TbPayAccountBookCriteria();
            TbPayAccountBookCriteria.Criteria criteriaCriteria = criteria.createCriteria();
            criteriaCriteria.andAccountIdEqualTo(tbPayAccount1.getAccountId());
            criteriaCriteria.andAcBookTypeEqualTo(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode());
            logger.info("【统一缴费-创建账户和账本】，查询该账户下电费账本信息入參【{}】",JsonUtil.object2Json(criteria));
            tbPayAccountBooks = tbPayAccountBookMapper.selectByExample(criteria);
            logger.info("【统一缴费-创建账户和账本】，查询该账户下电费账本信息返回参数【{}】",JsonUtil.object2Json(tbPayAccountBooks));

            /**如果账本存在且有电费账本信息，则需与电表点位接口进行对比*/
            /**遍历点位接口数据*/
            if(els.size() > 0){
                for (int i = 0; i < els.size(); i++) {
                    ElectricMeterInfoModel model = JSON.parseObject(JSON.toJSONString(els.get(i)),ElectricMeterInfoModel.class);
                    if(StringUtils.isNotBlank(model.getMeterCode())){
                        list.add(model.getMeterCode());
                    }
                }
            }
            /**遍历电费账本*/
            if(tbPayAccountBooks.size() > 0){
                for (TbPayAccountBook tb: tbPayAccountBooks) {
                    if(StringUtils.isNotBlank(tb.getMeterCode())) {
                        list2.add(tb.getMeterCode());
                    }
                }
            }
            /**获取电表点位接口中不包含的电费账本编码*/
            Collection<String> exists=new ArrayList<String>(list);
            exists.removeAll(list2);
            /**如果exists等于0，代表无需新增，则提示信息;如果大于0则新增电费账本*/
            if(exists.size() == 0){
                throw new JnSpringCloudException(PaymentBillExceptionEnum.PAYMENT_ACCOUNT_BOOK_EXIT);
            }else{
                /**新增当前账户下没有的电费账本*/
                for (String str : exists) {
                    tbPayAccountBook.setAccountId(tbPayAccount1.getAccountId());
                    tbPayAccountBook.setEntId(tbPayAccount1.getEntId());
                    tbPayAccountBook.setCreatedTime(new Date());
                    if(user != null) {
                        tbPayAccountBook.setCreatorAccount(user.getAccount());
                    }
                    tbPayAccountBook.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                    tbPayAccountBook.setAcBookId(AutoOrderUtil.autoOrderId());
                    tbPayAccountBook.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode());
                    tbPayAccountBook.setAcBookName("电费账本["+str+"]");
                    tbPayAccountBook.setAutomaticDeductions(PayAccountBookEnum.ACCOUNT_BOOK_AUTO.getCode());
                    tbPayAccountBook.setCanRecharge(PayAccountBookEnum.ACCOUNT_BOOK_RECHARGE.getCode());
                    tbPayAccountBook.setIsShow(PayAccountBookEnum.ACCOUNT_BOOK_IS_SHOW.getCode());
                    tbPayAccountBook.setMeterCode(str);
                    logger.info("【统一缴费-创建账户和账本】，新增当前账户下没有的电费账本入參【{}】",JsonUtil.object2Json(tbPayAccountBook));
                    tbPayAccountBookMapper.insertSelective(tbPayAccountBook);
                }
                return new Result("新增电费账本成功");
            }
        }


        /**2.无：新建统一缴费账户和账本信息*/
        TbPayAccount tbPayAccount = new TbPayAccount();
        tbPayAccount.setUserId(payAccountBookCreateParam.getComAdmin());
        tbPayAccount.setEntId(payAccountBookCreateParam.getEnterId());
        tbPayAccount.setAccountId(AutoOrderUtil.autoOrderId());
        tbPayAccount.setCreatedTime(new Date());
        if(user != null){
            tbPayAccount.setCreatorAccount(user.getAccount());
        }
        tbPayAccount.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        logger.info("【统一缴费-创建账户和账本】，创建账户开始");
        logger.info("【统一缴费-创建账户和账本】，创建账户入參【{}】",JsonUtil.object2Json(tbPayAccount));
        tbPayAccountMapper.insertSelective(tbPayAccount);
        logger.info("【统一缴费-创建账户和账本】，创建账户结束");
        /**创建该企业账本信息*/
        Map<String,String>  map = new HashMap<>();
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_2.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_2.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_2.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_3.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_3.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_3.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_4.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_4.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_4.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_5.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_5.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_5.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_6.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_6.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_6.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_7.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_7.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_7.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_8.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_8.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_8.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_9.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_9.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_9.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_10.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_10.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_10.getMessage().length()-2));
        tbPayAccountBook.setAccountId(tbPayAccount.getAccountId());
        tbPayAccountBook.setEntId(tbPayAccount.getEntId());
        tbPayAccountBook.setCreatedTime(new Date());
        if(user != null) {
            tbPayAccountBook.setCreatorAccount(user.getAccount());
        }
        tbPayAccountBook.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tbPayAccountBook.setAcBookId(AutoOrderUtil.autoOrderId());
            tbPayAccountBook.setAcBookType(entry.getKey());
            tbPayAccountBook.setAcBookName(entry.getValue());
            tbPayAccountBook.setAutomaticDeductions(PayAccountBookEnum.ACCOUNT_BOOK_NOT_AUTO.getCode());
            tbPayAccountBook.setCanRecharge(PayAccountBookEnum.ACCOUNT_BOOK_NOT_RECHARGE.getCode());
            tbPayAccountBook.setIsShow(PayAccountBookEnum.ACCOUNT_BOOK_IS_NOT_SHOW.getCode());
            logger.info("【统一缴费-创建账户和账本】，创建账本开始");
            logger.info("【统一缴费-创建账户和账本】，创建账本入參【{}】",JsonUtil.object2Json(tbPayAccountBook));
            tbPayAccountBookMapper.insertSelective(tbPayAccountBook);
            logger.info("【统一缴费-创建账户和账本】，创建账本结束");
        }
        /**因电费账本是一对多，单独创建*/
        if(els.size() > 0){
            for (int i = 0; i < els.size(); i++) {
                ElectricMeterInfoModel model = JSON.parseObject(JSON.toJSONString(els.get(i)),ElectricMeterInfoModel.class);
                tbPayAccountBook.setAcBookId(AutoOrderUtil.autoOrderId());
                tbPayAccountBook.setAcBookType(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode());
                tbPayAccountBook.setAcBookName("电费账本["+model.getMeterCode()+"]");
                tbPayAccountBook.setAutomaticDeductions(PayAccountBookEnum.ACCOUNT_BOOK_AUTO.getCode());
                tbPayAccountBook.setCanRecharge(PayAccountBookEnum.ACCOUNT_BOOK_RECHARGE.getCode());
                tbPayAccountBook.setIsShow(PayAccountBookEnum.ACCOUNT_BOOK_IS_SHOW.getCode());
                tbPayAccountBook.setMeterCode(model.getMeterCode());
                tbPayAccountBook.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                logger.info("【统一缴费-创建账户和账本】，创建电费账本入參【{}】",JsonUtil.object2Json(tbPayAccountBook));
                tbPayAccountBookMapper.insertSelective(tbPayAccountBook);
                logger.info("【统一缴费-创建账户和账本】，创建电费账本结束");
            }
        }
        return new Result("创建账户和账本成功");
    }

    @Override
    @ServiceLog(doAction = "自动扣费")
    @Transactional(rollbackFor = RuntimeException.class)
    public Result automaticDeduction(PayAutoDeduParam payAutoDeduParam, User user) {
        //查询该账本ID下的所有待缴且自动扣费的账单
        TbPayBillCriteria billCriteria = new TbPayBillCriteria();
        billCriteria.createCriteria().andAcBookIdEqualTo(payAutoDeduParam.getAcBookId())
                .andPaymentStateEqualTo(PaymentBillEnum.BILL_ORDER_IS_NOT_PAY.getCode())
                .andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        List<TbPayBill> tbPayBills = tbPayBillMapper.selectByExample(billCriteria);
        for (TbPayBill tb: tbPayBills) {
            TbPayAccountBook tbPayAccountBook = tbPayAccountBookMapper.selectByPrimaryKey(payAutoDeduParam.getAcBookId());
            /**查询传的账本编号是否存在*/
            if (null == tbPayAccountBook) {
                throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
            }
            /**比较金额大小即左边比右边数大，返回1，相等返回0，比右边小返回-1*/
            if(tbPayAccountBook.getBalance().compareTo(tb.getBillExpense()) == 1){
                /**扣除账本金额，并更新账单状态和插入流水记录*/
                BigDecimal totalAmount = new BigDecimal(tbPayAccountBook.getBalance().toString());
                totalAmount = totalAmount.subtract(tb.getBillExpense());
                tbPayAccountBook.setBalance(totalAmount);
                logger.info("开始执行统一缴费扣除账本金额操作,入參【{}】", tbPayAccountBook.toString());
                tbPayAccountBookMapper.updateByPrimaryKeySelective(tbPayAccountBook);
                logger.info("结束执行统一缴费扣除账本金额操作");
                logger.info("开始执行统一缴费插入流水记录操作");
                TbPayAccountBookMoneyRecord tpbmr = new TbPayAccountBookMoneyRecord();
                tpbmr.setDeductionId(AutoOrderUtil.autoOrderId());
                tpbmr.setBillId(tb.getBillId());
                tpbmr.setAcBookId(tb.getAcBookId());
                tpbmr.setRemark(tb.getBillSource());
                tpbmr.setPaymentMethod(PaymentBillMethodEnum.BILL_STATE_QIAN_BAO.getMessage());
                tpbmr.setPaymentAction(PaymentBillActionEnum.BILL_STATE_AUYTO.getCode());
                tpbmr.setNatureCode(PaymentBillEnum.BILL_ACCOUNT_BOOK_FEE.getCode());
                tpbmr.setMoney(tb.getBillExpense());
                tpbmr.setBalance(totalAmount);
                if(user != null){
                    if(StringUtils.isNotBlank(user.getAccount())){
                        tpbmr.setCreatorAccount(user.getAccount());
                    }else {
                        tpbmr.setCreatorAccount(tb.getCreatorAccount());
                    }
                }
                tpbmr.setCreatedTime(new Date());
                tpbmr.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
                logger.info("统一缴费插入流水记录入參【{}】", tpbmr.toString());
                tbPayAccountBookMoneyRecordMapper.insertSelective(tpbmr);
                logger.info("结束执行统一缴费插入流水记录操作");
                /**更新账单状态*/
                logger.info("开始执行统一缴费更新账单状态操作");
                tb.setPaymentState(PaymentBillEnum.BILL_ORDER_IS_PAY.getCode());
                logger.info("执行统一缴费更新账单状态操作,入參【{}】", tb.toString());
                tbPayBillMapper.updateByPrimaryKeySelective(tb);
                logger.info("结束执行统一缴费更新账单状态操作");
            }
        }
        return new Result("执行自动扣费成功！");
    }

    @Override
    @ServiceLog(doAction = "通过企业或用户ID查询账户下账本信息")
    public Result queryAccountBook(PayAccountBookEntIdOrUserIdParam payAccountBookEntIdOrUserIdParam) {
        /**根据用户账号/企业ID查询企业信息（用户为企业管理员） */
        logger.info("通过企业或用户ID查询账户下账本信息,参数：payAccountBookEntIdOrUserIdParam={}", JsonUtil.object2Json(payAccountBookEntIdOrUserIdParam));
        List<TbPayAccountBook> tbPayAccountBook = null;
        List<PayAccountBook> list = new ArrayList<>();
        List<TbPayAccount> tbPayAccount = null;
        TbPayAccountBookCriteria billCriteria = new TbPayAccountBookCriteria();
        TbPayAccountCriteria accountCriteria = new TbPayAccountCriteria();
        if (payAccountBookEntIdOrUserIdParam.getObjType().equals(PaymentBillEnum.BILL_OBJ_TYPE_IS_COMPANY.getCode())) {
            /**如果是企业则去查询企业信息再通过查询的企业的管理员账户去查询账户表*/
            logger.info("如果是企业则去查询企业信息再通过查询的企业的管理员账户去查询账户表,ObjId={}",payAccountBookEntIdOrUserIdParam.getObjId());
            ServiceCompany serviceCompany = companyService.getCompanyDetailByAccountOrId(payAccountBookEntIdOrUserIdParam.getObjId());
            if (serviceCompany == null || StringUtils.isBlank(serviceCompany.getComAdmin())) {
                /**查询企业信息异常*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.QUERY_ENTERPRISE_INFO_ERROR);
            }
            /**通过企业管理员获取账户ID*/
            accountCriteria.createCriteria().andUserIdEqualTo(serviceCompany.getComAdmin()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            tbPayAccount = tbPayAccountMapper.selectByExample(accountCriteria);
        } else if (payAccountBookEntIdOrUserIdParam.getObjType().equals(PaymentBillEnum.BILL_OBJ_TYPE_IS_INDIVIDUAL.getCode())) {
            /**如果是个人则用个人对象名称去查询账户表*/
            accountCriteria.createCriteria().andUserIdEqualTo(payAccountBookEntIdOrUserIdParam.getObjId()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            tbPayAccount = tbPayAccountMapper.selectByExample(accountCriteria);
        }
        if (tbPayAccount.size() > Integer.parseInt(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode()) || tbPayAccount.size() == Integer.parseInt(PaymentBillEnum.BILL_STATE_DELETE.getCode())) {
            /**查询账户信息异常*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ACCOUNT_IS_NOT_EXIT);
        }
        /**通过账户表的账户ID查询账本信息*/
        logger.info("通过账户表的账户ID查询账本信息,账户ID={}",tbPayAccount.get(0).getAccountId());
        /**因电费账本是一个账户下有多个，所以需要单独处理查询条件*/
        billCriteria.createCriteria().andAccountIdEqualTo(tbPayAccount.get(0).getAccountId()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        tbPayAccountBook = tbPayAccountBookMapper.selectByExample(billCriteria);
        if(tbPayAccountBook.size() > 0){
            for (int i = 0; i < tbPayAccountBook.size(); i++) {
                PayAccountBook payAccountBook = new PayAccountBook();
                BeanUtils.copyProperties(tbPayAccountBook.get(i),payAccountBook);
                list.add(payAccountBook);
            }
        }
        return new Result(list);
    }
}
