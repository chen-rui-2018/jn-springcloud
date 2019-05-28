package com.jn.enterprise.pay.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.pay.vo.PayAccountBookMoneyRecordVo;
import com.jn.pay.vo.PayAccountBookRecordVo;
import com.jn.system.model.SysDictInvoke;
import com.jn.system.model.User;

import java.util.List;


/**
 * 我的账户(业务层)
 *
 * @author： wzy
 * @date： Created on 2019/5/5 11:49
 * @version： v1.0
 * @modified By:
 */
public interface MyPayAccountService {

    /**
     * 查询当前账户下所有账本信息
     * @param userId
     * @return
     */
    PayAccountAndAccountBookVo queryPayAccountBook(String userId);

    /**
     * 账本明细查询
     * @param payAccountBookParam
     * @return
     */
    PaginationData<List<PayAccountBookRecordVo>> queryPayAccountBookInfo(PayAccountBookParam payAccountBookParam);
    /**
     * 账本明细详情查询
     * @param user,payAccountBookMoneyRecord
     * @return
     */
    PaginationData<PayAccountBookMoneyRecordVo> queryPayAccountDetails(String deductionId, User user);

    /**
     * 获取费用预缴协议
     * @param sysDictInvoke,user
     * @return
     */
    Result<String> getFeeAdvanceAgreement(SysDictInvoke sysDictInvoke, User user);

    /**
     * 我的账户-通过企业ID和账本类型查询账号余额
     * @param payAccountBookMoney
     * @return
     */
    PayAccountBook queryPayAccountBookMoney(PayAccountBookMoney payAccountBookMoney);
}
