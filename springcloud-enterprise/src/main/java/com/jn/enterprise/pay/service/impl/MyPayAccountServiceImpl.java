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
import com.jn.enterprise.pay.enums.PaymentBillEnum;
import com.jn.enterprise.pay.enums.PaymentBillExceptionEnum;
import com.jn.enterprise.pay.service.MyPayAccountService;
import com.jn.pay.model.PayAccountBook;
import com.jn.pay.model.PayAccountBookMoney;
import com.jn.pay.model.PayAccountBookMoneyRecordParam;
import com.jn.pay.model.PayAccountBookParam;
import com.jn.pay.vo.*;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.List;

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
    private TbPayAccountBookMoneyRecordMapper tbayAccountBookMoneyRecordMapper;

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
}
