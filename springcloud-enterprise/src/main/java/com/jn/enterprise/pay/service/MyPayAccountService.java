package com.jn.enterprise.pay.service;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.pay.model.PayAccountBookMoneyRecord;
import com.jn.enterprise.pay.vo.PayAccountAndAccountBookVo;
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
     * @param user
     * @return
     */
    PayAccountAndAccountBookVo queryPayAccountBook(User user);

    /**
     * 查询当前账本下所有明细信息
     * @param user,payAccountBookMoneyRecord
     * @return
     */
    PaginationData<List<PayAccountBookMoneyRecord>> queryPayAccountDetails(User user,PayAccountBookMoneyRecord payAccountBookMoneyRecord);
}
