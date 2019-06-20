package com.jn.enterprise.pay.dao;



import com.jn.pay.model.PayAccountBook;
import com.jn.pay.model.PayAccountBookMoneyRecordParam;
import com.jn.pay.model.PayAccountBookParam;
import com.jn.pay.vo.PayAccountAndAccountBookVo;
import com.jn.pay.vo.PayAccountBookMoneyRecordVo;
import com.jn.pay.vo.PayAccountBookRecordVo;
import com.jn.pay.vo.PayAccountBookVo;

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

    List<PayAccountBookVo> selectPayAccountBookList(String accountId);

    PayAccountBookMoneyRecordVo queryPayAccountDetails(PayAccountBookMoneyRecordParam pay);

    List<PayAccountBookRecordVo> queryPayAccountBookInfo(PayAccountBookParam payAccountBookParam);
}
