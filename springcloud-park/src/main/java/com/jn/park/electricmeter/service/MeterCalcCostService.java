package com.jn.park.electricmeter.service;

import com.jn.common.model.Result;
import com.jn.park.electricmeter.entity.TbElectricErrorLog;
import com.jn.park.electricmeter.exception.ErrorLogException;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.system.model.User;

import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/23 10:55
 * @version： v1.0
 * @modified By:
 */

public interface MeterCalcCostService {

    /**
     * 计算企业每日的电费
     */
    void calcCostEverday();

    /**
     * 计算一个企业一天的电费和电量
     */
    void calcCostEverdayBySomeOneCompany(String companyId, Date dealDate, String account) throws ErrorLogException;

    /**
     * 企业手动计价
     */
    Result calcCostEverdayByHandler(User user, String companyId, Date day );

    /**
     * 设置催缴
     * @return
     */
    Result setUrgeCall(User user,String id);

    /**
     * 缴费成功后的回调接口
     * @return
     */
    Result updateBillInfo(PayCallBackNotify payCallBackNotify);
}
