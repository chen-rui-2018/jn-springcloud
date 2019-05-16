package com.jn.nodify.send;

import com.jn.common.channel.MessageSource;
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
    @Ignore
    public void sendMessage() {
        AppSinkVo appSinkVo = new AppSinkVo();
        appSinkVo.setTitle("触底反弹末节23分 全票MVP三周年库里爆发");
        appSinkVo.setContent("三年前的今年，斯蒂芬-库里拿到史上唯一一次全票常规赛MVP。而看完勇士上半场的比赛，不由让人感叹巨星状态不再。下半场库里呈现截然不同的面貌，末节独得23分，几乎一己之力摧毁火箭。");
        List<String> ids = new ArrayList<>();
        ids.add("id121");
        ids.add("id122");
        ids.add("id123");
        appSinkVo.setPlatfromType("");
        messageSource.outputApp().send(MessageBuilder.withPayload(appSinkVo).build());
    }

}
