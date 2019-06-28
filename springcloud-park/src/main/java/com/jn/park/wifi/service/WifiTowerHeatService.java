package com.jn.park.wifi.service;

import com.jn.common.model.Result;

/**
 * WIFI热力图
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/6/28
 * </pre>
 */
public interface WifiTowerHeatService {

    /**
     * 采集wifi热力图信息
     * @return
     */
    Result collectionHeatInfo();
}
