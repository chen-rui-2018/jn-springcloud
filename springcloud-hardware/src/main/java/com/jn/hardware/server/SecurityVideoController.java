package com.jn.hardware.server;

import com.jn.common.model.Result;
import com.jn.hardware.api.SecurityVideoClient;
import com.jn.hardware.model.security.*;
import com.jn.hardware.security.service.SecurityVideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 视频安防 内部调用接口实现
 * @author： chenr
 * @date： Created on 2019/5/9 11:00
 * @version： v1.0
 * @modified By:
 */
public class SecurityVideoController implements SecurityVideoClient {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(SecurityVideoController.this.getClass());

    @Autowired
    SecurityVideoService securityVideoService;

    /**
     * 查询监控点列表
     * @param securityMonitoringPointParam 实体类参数
     * @return
     */
    @Override
    public Result<SecurityMonitoringPointShow> findSecurityMonitoringPointList(SecurityMonitoringPointParam securityMonitoringPointParam) {
        return  securityVideoService.findSecurityMonitoringPointList(securityMonitoringPointParam);
    }
    /**
     * 查询监控点列表
     * @param securityPlayBackUrlParam 实体类参数
     * @return
     */
    @Override
    public Result<SecurityPlayBackUrlShow> findSecurityPlayBackUrlList(SecurityPlayBackUrlParam securityPlayBackUrlParam) {
        return  securityVideoService.findSecurityPlayBackUrlList(securityPlayBackUrlParam);
    }
}
