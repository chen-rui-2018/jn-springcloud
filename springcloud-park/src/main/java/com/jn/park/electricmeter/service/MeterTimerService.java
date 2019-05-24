package com.jn.park.electricmeter.service;

import com.jn.park.electricmeter.entity.TbElectricErrorLog;

import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/23 10:55
 * @version： v1.0
 * @modified By:
 */

public interface MeterTimerService {

    /**
     * 计算企业每日的电费
     */
    void calcCostEverday();

    /**
     * 计算一个企业一天的电费和电量
     */
    void calcCostEverdayBySomeOneCompany(String companyId, Date dealDate, String account) throws Exception;
}
