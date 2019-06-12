package com.jn.nodify.send;

import com.jn.common.channel.MessageSource;
import com.jn.common.util.DateUtils;
import com.jn.news.vo.AppSinkVo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/11 17:50
 * @version： v1.0
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {MessageSource.class})
public class AppSendTest {

    @Autowired
    MessageSource messageSource;

    @Test
    public void sendMessage() {
        AppSinkVo appSinkVo = new AppSinkVo();
        appSinkVo.setTitle("springcloud消息接口最新测试推送" + DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        appSinkVo.setContent("springcloud消息接口最新测试推送内容" + DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        List<String> ids = new ArrayList<>();
//        ids.add("140fe1da9ee30f8212f");
        ids.add("160a3797c877a89b4f6");
        ids.add("140fe1da9ee7485a439");

        // 推送方式（DEVICE：设备 TAG：标签）
        String pushType = "DEVICE";
        // 平台类型 ANDROID/IOS/null  如果为null 则发送给所有平台
        String platFromType = null;
        // 推送通知类型（ALL：全部 NOTICE：通知 MESSAGE：透传消息）
        String noticeType = "ALL";
        // 透传消息内容
        String message = "透传消息1";
        appSinkVo.setIds(ids);
        appSinkVo.setPushType(pushType);
        appSinkVo.setNoticeType(noticeType);
        appSinkVo.setPlatFromType(platFromType);
        appSinkVo.setMessage(message);
        messageSource.outputApp().send(MessageBuilder.withPayload(appSinkVo).build());
    }

}
