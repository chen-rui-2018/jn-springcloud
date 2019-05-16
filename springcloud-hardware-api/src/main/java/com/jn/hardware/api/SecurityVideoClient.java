package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.security.SecurityMonitoringPointParam;
import com.jn.hardware.model.security.SecurityMonitoringPointShow;
import com.jn.hardware.model.security.SecurityPlayBackUrlParam;
import com.jn.hardware.model.security.SecurityPlayBackUrlShow;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视频安防内部调用接口
 * @author： chenr
 * @date： Created on 2019/5/9 10:56
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-hardware")
public interface SecurityVideoClient {
    /**
     * 查询监控点列表
     * @param securityMonitoringPointParam 实体类参数
     * @return
     */
    @RequestMapping(value = "/api/hardware/security/findSecurityMonitoringPointList")
    Result<SecurityMonitoringPointShow> findSecurityMonitoringPointList(@RequestBody SecurityMonitoringPointParam securityMonitoringPointParam);
    /**
     * 查询监控回放路径url列表
     * @param securityPlayBackUrlParam 实体类参数
     * @return
     */
    @RequestMapping(value = "/api/hardware/security/findSecurityPlayBackUrlList")
    Result<SecurityPlayBackUrlShow> findSecurityPlayBackUrlList(@RequestBody SecurityPlayBackUrlParam securityPlayBackUrlParam);
}
