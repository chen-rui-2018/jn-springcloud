package com.jn.hardware.server;

import com.jn.common.model.Result;
import com.jn.hardware.api.SecurityVideoClient;
import com.jn.hardware.model.security.*;
import com.jn.hardware.security.service.SecurityVideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 视频安防 内部调用接口实现
 * @author： chenr
 * @date： Created on 2019/5/9 11:00
 * @version： v1.0
 * @modified By:
 */
@RestController
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
    public Result<SecurityMonitoringPointShow> findSecurityMonitoringPointList(@RequestBody SecurityMonitoringPointParam securityMonitoringPointParam) {
        return  securityVideoService.findSecurityMonitoringPointList(securityMonitoringPointParam);
    }
    /**
     * 查询监控回放路径url列表
     * @param securityPlayBackUrlParam 实体类参数
     * @return
     */
    @Override
    public Result<SecurityPlayBackUrlShow> findSecurityPlayBackUrlList(@RequestBody SecurityPlayBackUrlParam securityPlayBackUrlParam) {
        return  securityVideoService.findSecurityPlayBackUrlList(securityPlayBackUrlParam);
    }
    /**
     * 获取海康威视的 接口凭证 token,返回 用于认证的url
     * @param securityTokenParam 实体类参数
     * @return
     */
    @Override
    public Result<String> getSecurityTokenURL(@RequestBody  SecurityTokenParam securityTokenParam) {
         return  securityVideoService.getSecurityTokenURL(securityTokenParam);
    }

}
