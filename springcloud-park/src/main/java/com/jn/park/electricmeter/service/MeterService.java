package com.jn.park.electricmeter.service;

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
     * 手动处理失败的数据
     */
    void getDataFromHardareByHandle(String code,String type,String startTime);
}
