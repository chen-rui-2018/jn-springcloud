package com.jn.enterprise.pay.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pay.entity.TbPayBillDetails;
import com.jn.pay.vo.PayBillDetailsVo;
import com.jn.pay.vo.PayBillVo;
import com.jn.pay.model.*;
import com.jn.pay.vo.PayBillCreateParamVo;
import com.jn.pay.vo.PayRecordVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * 我的账单(业务层)
 *
 * @author： wzy
 * @date： Created on 2019/5/2 17:15
 * @version： v1.0
 * @modified By:
 */
public interface MyPayBillService {

    /**
     * 查询账单
     * @param payBillParams
     * @return
     */
    PaginationData<List<PayBillVo>> getBillQueryList(@Param("payBill")PayBillParams payBillParams,User user);

    /**
     * 查询缴费记录
     * @param
     * @return
     */
    PaginationData<List<PayRecordVo>> billPaymentRecord(PayRecordParam payRecordParam,User user);

    /**
     * 通过账单ID查询账单详情信息
     * @param billId
     * @return
     */
    PaginationData<List<PayBillDetailsVo>> getBillInfo(String billId);

    /**
     * 我的账单-通过账单ID查询账单【基础】信息(包含账单支付状态)
     * @param billId
     * @return
     */
    PayBill getBillBasicInfo(String billId);

    /**
     * 账单催缴次数更新
     * @param payCheckReminderParam
     * @return
     */
    Result updateBillNumber(PayCheckReminderParam payCheckReminderParam);

    /**
     * 核查提醒录入
     * @param payCheckReminder,user
     * @return
     */
    Result billCheckReminder(PayCheckReminder payCheckReminder, User user);

    /**
     * 创建账单
     * @param payBillCreateParamVo,user
     * @return
     */
    Result billCreate(PayBillCreateParamVo payBillCreateParamVo, User user);

    /**
     * 缴费单支付发起
     * @param createOrderAndPayReqModel,user
     * @param user
     * @return
     */
    Result<PayOrderRsp> startPayment(CreateOrderAndPayReqModel createOrderAndPayReqModel, User user);

    /**
     * 支付回调接口
     * @param callBackParam
     * @return
     */
    Result payCallBack(PayOrderNotify callBackParam, User user);

    /**
     * 账本预缴充值
     * @param createOrderAndPayReqModel,user
     * @param user
     * @return
     */
    Result<PayOrderRsp> insertPrepaidRecharge(CreateOrderAndPayReqModel createOrderAndPayReqModel, User user);

    /**
     * 预缴充值回调接口
     * @param callBackParam
     * @return
     */
    Result payAccountCallBack(PayOrderNotify callBackParam,User user);
}
