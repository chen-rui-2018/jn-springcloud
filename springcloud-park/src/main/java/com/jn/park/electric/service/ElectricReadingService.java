package com.jn.park.electric.service;/**
 * @author： huangbq
 * @date： Created on 2019/5/15 12:44
 * @version： v1.0
 * @modified By:
 */

import com.jn.common.model.Result;

import java.util.Date;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/15
 *</pre>
 */
public interface ElectricReadingService {

    /**
     * 电表读数采集
     * @param dealDate
     * @param dealHour
     * @param meterCode
     * @return
     */
    Result meterDataCollection(Date dealDate,Integer dealHour,String meterCode);
}
