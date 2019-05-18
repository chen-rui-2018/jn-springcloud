package com.jn.park.electricmeter.service;

import com.jn.common.model.Result;
import com.jn.hardware.model.electricmeter.ElectricMeterDataCollectionParam;
import com.jn.hardware.model.electricmeter.ElectricMeterWaterOrElectricShow;
import com.jn.system.log.annotation.ServiceLog;

import java.util.Date;
import java.util.List;

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
     * 保存流程
     * @param dataList
     * @param dealDate
     * @param hour
     * @return
     */
    public Result saveData(List<ElectricMeterWaterOrElectricShow> dataList, Date dealDate, String hour, String taskBatch);


    /**
     * 手动处理指定的电表读数定时入库失败的数据
     * @param dealDate
     * @param dealHour
     */
    void dealSomeOneFailByHandle(Date dealDate,String dealHour);

    /**
     * 手动处理所有电表读数定时入库失败的数据
     */
    Result dealAllFailByHandle();
}
