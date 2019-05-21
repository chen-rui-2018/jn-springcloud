package com.jn.enterprise.pay.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pay.dao.PayAccountAndAccountBookDao;
import com.jn.enterprise.pay.dao.TbPayAccountBookMoneyRecordMapper;
import com.jn.enterprise.pay.dao.TbPayAccountBookTypeMapper;
import com.jn.enterprise.pay.entity.*;
import com.jn.enterprise.pay.service.MyPayAccountService;
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
import java.util.ArrayList;
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
}
