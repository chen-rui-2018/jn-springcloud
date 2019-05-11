package com.jn.enterprise.pay.dao;



import com.jn.pay.model.PayAccountBook;
import com.jn.pay.vo.PayAccountAndAccountBookVo;

import java.util.List;

/**
 * 账户账本DAO
 *
 * @author： wzy
 * @date： Created on 2019/5/5 14:59
 * @version： v1.0
 * @modified By:
 */
public interface PayAccountAndAccountBookDao {

    PayAccountAndAccountBookVo selectPayAccountId(String userId);

    List<PayAccountBook> selectPayAccountBookList(String accountId);
}
