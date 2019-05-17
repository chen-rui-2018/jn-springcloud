package com.jn.park.electricmeter.service;

import com.jn.common.model.Result;
import com.jn.hardware.model.electricmeter.ElectricMeterDataCollectionParam;
import com.jn.system.log.annotation.ServiceLog;

import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/15 11:26
 * @version： v1.0
 * @modified By:
 */

public interface MeterService {

    /**
     * 电表数据采集接口
     */
    void getDataFromHardare();

    /**
     * 电表采集数据，保存数据逻辑主流程
     * @return
     */
    Result dealData(Date dealDate, String hour, ElectricMeterDataCollectionParam parameter);

    /**
     * 手动处理指定的电表读数定时入库失败的数据
     * @param dealDate
     * @param dealHour
     */
    Result dealSomeOneFailByHandle(Date dealDate,String dealHour);

    /**
     * 手动处理所有电表读数定时入库失败的数据
     */
    Result dealAllFailByHandle();
}
