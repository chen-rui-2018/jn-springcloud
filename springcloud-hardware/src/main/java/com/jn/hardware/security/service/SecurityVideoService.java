package com.jn.hardware.security.service;

import com.jn.common.model.Result;
import com.jn.hardware.model.security.SecurityMonitoringPointParam;
import com.jn.hardware.model.security.SecurityMonitoringPointShow;
import com.jn.hardware.model.security.SecurityPlayBackUrlParam;
import com.jn.hardware.model.security.SecurityPlayBackUrlShow;

/**
 * @author： chenr
 * @date： Created on 2019/5/8 15:46
 * @version： v1.0
 * @modified By:
 */
public interface SecurityVideoService {
    /**
     * 查询监控点列表
     * @param securityMonitoringPointParam
     * @return
     */
    Result<SecurityMonitoringPointShow> findSecurityMonitoringPointList(SecurityMonitoringPointParam securityMonitoringPointParam);
    /**
     * 查询监控点列表
     * @param securityPlayBackUrlParam 实体类参数
     * @return
     */
    Result<SecurityPlayBackUrlShow> findSecurityPlayBackUrlList(SecurityPlayBackUrlParam securityPlayBackUrlParam);
}
