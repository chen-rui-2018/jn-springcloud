package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.sdnware.heat.HeatResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName：Sdnware无线AP提供的内部接口服务
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/26 11:23
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("springcloud-hardware")
public interface SdnwareApClient {

    /**
     * 获取区域人数统计（热力）
     * @return
     */
    @RequestMapping(value = "/api/hardware/sdnware/getMapHeat")
    Result<HeatResult> getMapHeat();
}
