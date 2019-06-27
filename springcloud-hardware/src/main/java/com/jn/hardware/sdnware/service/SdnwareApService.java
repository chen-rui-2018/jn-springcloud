package com.jn.hardware.sdnware.service;

import com.jn.hardware.model.sdnware.heat.HeatResult;

/**
 * @ClassName：：Sdnware无线AP ：区域人数统计（热力）相关接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/26 11:44
 * @Version： v1.0
 * @Modified By:
 */
public interface SdnwareApService {

    /**
     * 获取区域人数统计（热力）Url
     */
    String GET_HEAT_URL = "http://iscenic.sdnware.com/getMapHeat/%s";

    /**
     * 获取区域人数统计（热力）
     * @return
     */
    HeatResult getMapHeat();

}
