package com.jn.enterprise.pay.dao;


import com.jn.pay.vo.PayBillVo;
import com.jn.pay.model.PayBill;
import com.jn.pay.model.PayBillDetails;
import com.jn.pay.model.PayBillParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 账单管理DAO
 *
 * @author： wzy
 * @date： Created on 2019/5/6 20:05
 * @version： v1.0
 * @modified By:
 */
public interface PayBillDao {

    List<PayBillVo> getBillQueryList(@Param("payBill")PayBillParams payBill);

    void insertList(@Param("list") List<PayBillDetails> list);
}
