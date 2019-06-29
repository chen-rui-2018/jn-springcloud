package com.jn.hardware.config;

import com.jn.hardware.environment.model.EnvironmentMonitorAttr;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 环境监测属性配置
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 15:49
 * @Version： v1.0
 * @Modified By:
 */

@Component
@ConfigurationProperties(prefix = "jn.environment")
@RefreshScope
public class EnvironmentMonitorProperties {

    /**
     * 存放设备的seckey ，设备安全验证码
     */
    private List<EnvironmentMonitorAttr> environmentMonitorAttr;

    public List<EnvironmentMonitorAttr> getEnvironmentMonitorAttr() {
        return environmentMonitorAttr;
    }

    public void setEnvironmentMonitorAttr(List<EnvironmentMonitorAttr> environmentMonitorAttr) {
        this.environmentMonitorAttr = environmentMonitorAttr;
    }

}
