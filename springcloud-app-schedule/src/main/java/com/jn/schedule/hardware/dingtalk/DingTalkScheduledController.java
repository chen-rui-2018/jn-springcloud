package com.jn.schedule.hardware.dingtalk;

import com.jn.hardware.api.DingTalkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 钉钉：定时调度
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 14:42
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class DingTalkScheduledController {

    @Autowired
    private DingTalkClient dingTalkClient;

    /**
     * 每2时强制刷新钉钉：access_token
     */
    @Scheduled(cron = "0 0 */2 * * ?")
    public void refreshAccessToken() {
        dingTalkClient.getAccessToken();
    }

}
