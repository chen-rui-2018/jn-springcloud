package com.jn.user.point.service;

import com.jn.common.model.PaginationData;
import com.jn.user.model.PointDeductionParam;
import com.jn.user.model.PointDeductionVO;
import com.jn.user.model.PointIncomeParam;
import com.jn.user.model.PointOrderPayParam;
import com.jn.user.point.entity.TbUserPointDetail;
import com.jn.user.point.model.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 用户积分
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:10
 * @version： v1.0
 * @modified By:
 */
public interface UserPointService {

    /**
     * 根据用户账号获取用户积分
     * @param account
     * @return
     */
    UserPointVO getUserPoint(String account);

    /**
     * 查询用户积分余额列表[后台管理员使用]
     * @param userPointParam
     * @return
     */
    PaginationData<List<UserPointVO>> getUserPointList(UserPointParam userPointParam);

    /**
     * 根据用户账号查询积分明细列表
     * @param userPointDetailParam
     * @return
     */
    PaginationData<List<UserPointDetailVO>> getUserPointDetail(UserPointDetailParam userPointDetailParam);

    /**
     * 获取用户某个功能周期内完成情况
     * @param ruleCode
     * @param account
     * @return
     */
    UserFunctionPointVO getFunctionPointState(String ruleCode, String account);

    /**
     * 用户积分收入
     * @param pointIncomeParam
     * @return
     */
    Boolean userPointIncome(PointIncomeParam pointIncomeParam);

    /**
     * 获取订单抵扣积分数
     * @param pointDeductionParam
     * @return
     */
    PointDeductionVO orderPointDeduction(PointDeductionParam pointDeductionParam);

    /**
     * 账单发起支付，积分预扣除接口
     * @param pointOrderPayParam
     * @return
     */
    Boolean pointPreDeduction(PointOrderPayParam pointOrderPayParam);

    /**
     * 支付成功，积分扣除接口
     * @param orderId
     * @return
     */
    Boolean orderPaySuccessPointDeduction(String orderId);

    /**
     * 支付失败/取消支付，积分退回（回滚）接口
     * @param orderId
     * @return
     */
    Boolean orderPayErrorPointReturn(String orderId);


}
