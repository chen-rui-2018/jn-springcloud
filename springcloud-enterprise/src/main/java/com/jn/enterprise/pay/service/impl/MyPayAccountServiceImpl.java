package com.jn.enterprise.pay.service.impl;

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
import com.jn.pay.model.*;
import com.jn.pay.vo.*;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;
import com.lorne.core.framework.utils.JsonUtils;
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
                    if (tbPayBill.getAcBookType().equals(tb.getAcBookType())) {
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
    @ServiceLog(doAction = "我的账户-通过企业ID和账本类型查询账号余额")
    public PayAccountBook queryPayAccountBookMoney(PayAccountBookMoney payAccountBookMoney) {
        logger.info("【我的账户-通过企业ID和账本类型查询账号余额】 入參:{}}", payAccountBookMoney);
        List<TbPayAccountBook> tbPayAccountBook = null;
        List<TbPayAccount> tbPayAccount = null;
        TbPayAccountBookCriteria criteria = new TbPayAccountBookCriteria();
        TbPayAccountCriteria accountCriteria = new TbPayAccountCriteria();
        PayAccountBook payAccountBook = new PayAccountBook();
        if (payAccountBookMoney.getObjType().equals(PaymentBillEnum.BILL_OBJ_TYPE_IS_COMPANY.getCode())) {
            /**如果是企业则去查询企业信息再通过查询的企业的管理员账户去查询账户表*/
            logger.info("如果是企业则去查询企业信息再通过查询的企业的管理员账户去查询账户表,objId={}",payAccountBookMoney.getObjId());
            ServiceCompany serviceCompany = companyService.getCompanyDetailByAccountOrId(payAccountBookMoney.getObjId());
            if (serviceCompany == null || StringUtils.isBlank(serviceCompany.getComAdmin())) {
                /**查询企业信息异常*/
                throw new JnSpringCloudException(PaymentBillExceptionEnum.QUERY_ENTERPRISE_INFO_ERROR);
            }
            /**通过企业管理员获取账户ID*/
            accountCriteria.createCriteria().andUserIdEqualTo(serviceCompany.getComAdmin()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            tbPayAccount = tbPayAccountMapper.selectByExample(accountCriteria);
        } else if (payAccountBookMoney.getObjType().equals(PaymentBillEnum.BILL_OBJ_TYPE_IS_INDIVIDUAL.getCode())) {
            /**如果是个人则用个人对象名称去查询账户表*/
            accountCriteria.createCriteria().andUserIdEqualTo(payAccountBookMoney.getObjId()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
            tbPayAccount = tbPayAccountMapper.selectByExample(accountCriteria);
        }
        if (tbPayAccount.size() > Integer.parseInt(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode()) || tbPayAccount.size() == Integer.parseInt(PaymentBillEnum.BILL_STATE_DELETE.getCode())) {
            /**查询账户信息异常*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ACCOUNT_IS_NOT_EXIT);
        }
        /**通过账户表的账户ID查询账本信息*/
        logger.info("通过账户表的账户ID查询账本信息,账户ID={}",tbPayAccount.get(0).getAccountId());
        criteria.createCriteria().andAccountIdEqualTo(tbPayAccount.get(0).getAccountId()).andAcBookTypeEqualTo(payAccountBookMoney.getAcBookType()).andRecordStatusEqualTo(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        tbPayAccountBook = tbPayAccountBookMapper.selectByExample(criteria);
        if (tbPayAccountBook.size() > Integer.parseInt(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode()) || tbPayAccountBook.size() == Integer.parseInt(PaymentBillEnum.BILL_STATE_DELETE.getCode())) {
            /**查询账本信息异常*/
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_BOOK_IS_NOT_EXIT);
        }
        BeanUtils.copyProperties(tbPayAccountBook.get(0),payAccountBook);
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
        tpbmr.setDeductionId(UUID.randomUUID().toString().replaceAll("-", ""));
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
        return new Result("线下充值成功！");
    }

    @Override
    @ServiceLog(doAction = "创建账户和账本")
    @Transactional(rollbackFor = RuntimeException.class)
    public Result createPayAccountBook(PayAccountBookCreateParam payAccountBookCreateParam, User user) {
        logger.info("【进入创建账户和账本方法】，入參【{}】",JsonUtil.object2Json(payAccountBookCreateParam),JsonUtil.object2Json(user));
        /**1.验证该企业用户是否有统一缴费账户，不处理以后企业管理员是否变更*/
        TbPayAccount tbPayAccount1 = tbPayAccountMapper.selectByPrimaryKey(payAccountBookCreateParam.getComAdmin());
        /**查询传的账本编号是否存在*/
        if (tbPayAccount1 != null) {
            throw new JnSpringCloudException(PaymentBillExceptionEnum.BILL_ACCOUNT_EXIT);
        }
        /**2.有：则返回提示信息 无：新建统一缴费账户和账本信息*/
        TbPayAccount tbPayAccount = new TbPayAccount();
        tbPayAccount.setUserId(payAccountBookCreateParam.getComAdmin());
        tbPayAccount.setEntId(payAccountBookCreateParam.getEnterId());
        tbPayAccount.setAccountId(UUID.randomUUID().toString().replaceAll("-", ""));
        tbPayAccount.setCreatedTime(new Date());
        tbPayAccount.setCreatorAccount(user.getAccount());
        tbPayAccount.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        logger.info("【统一缴费-创建账户和账本】，创建账户开始");
        logger.info("【统一缴费-创建账户和账本】，创建账户入參【{}】",JsonUtil.object2Json(tbPayAccount));
        tbPayAccountMapper.insertSelective(tbPayAccount);
        logger.info("【统一缴费-创建账户和账本】，创建账户结束");
        /**创建该企业账本信息*/
        Map<String,String>  map = new HashMap<>();
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_2.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_2.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_2.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_3.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_3.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_3.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_4.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_4.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_4.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_5.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_5.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_5.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_6.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_6.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_6.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_7.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_7.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_7.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_8.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_8.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_8.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_9.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_9.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_9.getMessage().length()-2));
        map.put(PaymentBillEnum.BILL_AC_BOOK_TYPE_10.getCode(),PaymentBillEnum.BILL_AC_BOOK_TYPE_10.getMessage().substring(0,PaymentBillEnum.BILL_AC_BOOK_TYPE_10.getMessage().length()-2));
        TbPayAccountBook tbPayAccountBook = new TbPayAccountBook();
        tbPayAccountBook.setAccountId(tbPayAccount.getAccountId());
        tbPayAccountBook.setCreatedTime(new Date());
        tbPayAccountBook.setCreatorAccount(user.getAccount());
        tbPayAccountBook.setRecordStatus(PaymentBillEnum.BILL_STATE_NOT_DELETE.getCode());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tbPayAccountBook.setAcBookId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbPayAccountBook.setAcBookType(entry.getKey());
            tbPayAccountBook.setAcBookName(entry.getValue());
            if(entry.getKey().equals(PaymentBillEnum.BILL_AC_BOOK_TYPE_1.getCode())){
                tbPayAccountBook.setAutomaticDeductions(PayAccountBookEnum.ACCOUNT_BOOK_AUTO.getCode());
                tbPayAccountBook.setCanRecharge(PayAccountBookEnum.ACCOUNT_BOOK_RECHARGE.getCode());
                tbPayAccountBook.setIsShow(PayAccountBookEnum.ACCOUNT_BOOK_IS_SHOW.getCode());
            }else{
                tbPayAccountBook.setAutomaticDeductions(PayAccountBookEnum.ACCOUNT_BOOK_NOT_AUTO.getCode());
                tbPayAccountBook.setCanRecharge(PayAccountBookEnum.ACCOUNT_BOOK_NOT_RECHARGE.getCode());
                tbPayAccountBook.setIsShow(PayAccountBookEnum.ACCOUNT_BOOK_IS_NOT_SHOW.getCode());
            }
            logger.info("【统一缴费-创建账户和账本】，创建账本开始");
            logger.info("【统一缴费-创建账户和账本】，创建账本入參【{}】",JsonUtil.object2Json(tbPayAccountBook));
            tbPayAccountBookMapper.insertSelective(tbPayAccountBook);
            logger.info("【统一缴费-创建账户和账本】，创建账本结束");
        }
        return new Result("创建账户和账本成功");
    }
}
