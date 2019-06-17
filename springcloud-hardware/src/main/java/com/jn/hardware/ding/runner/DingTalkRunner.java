package com.jn.hardware.ding.runner;

import com.jn.hardware.ding.service.DingTalkBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动时,执行获取钉钉access_token接口,并缓存起来
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 14:22
 * @Version： v1.0
 * @Modified By:
 */
@Component
@Order(value = 1)
public class DingTalkRunner implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(DingTalkRunner.class);
    @Autowired
    private DingTalkBaseService dingTalkBaseService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("\n服务启动后执行获取access_token开始.");
        String accessToken = dingTalkBaseService.getAccessToken();
        logger.info("\n服务启动后执行获取access_token结束,access_token:【{}】.",accessToken);
    }
}
