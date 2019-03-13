package com.jn.channel;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.LoadBalancerUtil;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.enums.DelayStreamExceptionEnum;
import com.jn.send.model.Delay;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * 发送测试类
 *
 * @author： fengxh
 * @date： Created on 2019/1/7 15:17
 * @version： v1.0
 * @modified By:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DelayMessageSendTest {

    private static Logger log = LoggerFactory.getLogger(DelayMessageSendTest.class);
    @Autowired
    private DelayMessageSend delayMessageSend;

    private Delay delay;

    @Before
    public void init(){
        delay = new Delay();
        delay.setServiceId("springcloud-app-system");
        delay.setServiceUrl("/api/system/getUser");
        String object = "{\"account\":\"wangsong\"}";
        delay.setDataString(object);
    }



    @Test
    @Ignore
    public void send() throws InterruptedException {
       ProcessReceiver.latch = new CountDownLatch(2);
       //没有日期
       try{
           delayMessageSend.send(delay);
       }catch (JnSpringCloudException e){
           log.warn("没有日期，{}",e.getMsg());
           assertThat(e.getCode(),equalTo(DelayStreamExceptionEnum.DATE_NOT_NULL.getCode()));
       }
       //日期比现在少
       delay.setTtl("-1");
        try{
            delayMessageSend.send(delay);
        }catch (JnSpringCloudException e){
            log.warn("日期比当前少，{}",e.getMsg());
            assertThat(e.getCode(),equalTo(DelayStreamExceptionEnum.DATE_NOT_LETTER_NOW.getCode()));
        }
        delay.setTtl(null);
        Date date = new Date();
        try{
            Thread.sleep(1000L);
            delay.setDateString(DateUtils.formatDate(date,"yyyy-MM-dd HH:mm:ss"));
            delayMessageSend.send(delay);
        }catch (JnSpringCloudException e){
            log.warn("日期比当前少，{}",e.getMsg());
            assertThat(e.getCode(),equalTo(DelayStreamExceptionEnum.DATE_NOT_LETTER_NOW.getCode()));
        }
        //格式有误
        try{
            delay.setDateString(DateUtils.formatDate(date,"yyyy/MM/dd"));
            delayMessageSend.send(delay);
        }catch (JnSpringCloudException e){
            log.warn("格式有误，{}",e.getMsg());
            assertThat(e.getCode(),equalTo(DelayStreamExceptionEnum.DATE_FORMAT_FAIL.getCode()));
        }
        //设置正常ttl发送
        delay.setTtl("10000");
        delayMessageSend.send(delay);

        //设置日期正常发送
        delay.setTtl(null);
        delay.setDateString(DateUtils.formatDate(new Date(System.currentTimeMillis()+10000),"yyyy-MM-dd HH:mm:ss"));
        delayMessageSend.send(delay);

        Boolean isUp = loadBalancerUtil.isClientUp("springcloud-app-system");
        if(isUp){
            ProcessReceiver.latch.await();
        }else {
            log.warn("需要先启动springcloud-app-system项目");
        }
    }

    @Autowired
    private DelaySendMessageClient delaySendMessageClient;

    @Autowired
    private LoadBalancerUtil loadBalancerUtil;

    @Test
    public void sendController(){
        Boolean isUp = loadBalancerUtil.isClientUp("springcloud-app-system");
        isUp = isUp?loadBalancerUtil.isClientUp("springcloud-app-delay-stream"):isUp;
        if(isUp){
            delay.setTtl("10000");
            delaySendMessageClient.delaySend(delay);

        }else {
            log.warn("需要先启动springcloud-app-system,springcloud-app-delay-stream项目");
        }
    }
}