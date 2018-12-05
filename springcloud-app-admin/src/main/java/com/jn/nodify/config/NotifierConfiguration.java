package com.jn.nodify.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jn.common.channel.MessageSource;
import com.jn.common.util.DateUtils;
import com.jn.nodify.SendFactory;
import com.jn.nodify.domain.NotifierProperties;
import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.notify.AbstractEventNotifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 呵呵
 *
 * @author： fengxh
 * @date： Created on 2018/12/4 17:17
 * @version： v1.0
 * @modified By:
 */
@Configuration
@EnableBinding(value = {MessageSource.class})
public class NotifierConfiguration {

    private static final Logger log = LoggerFactory.getLogger(NotifierConfiguration.class);


    @Autowired
    private NotifierProperties notifierProperties;

    @Autowired
    private MessageSource messageSource;

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier remindingNotifier = new RemindingNotifier(new AbstractEventNotifier() {
            @Override
            protected void doNotify(ClientApplicationEvent event) throws JsonProcessingException {
                if (event instanceof ClientApplicationStatusChangedEvent) {
                    ClientApplicationStatusChangedEvent changedEvent = (ClientApplicationStatusChangedEvent) event;
                    log.info("Application {} ({}) is {}", event.getApplication().getName(), event.getApplication().getId(), changedEvent.getTo().getStatus());
                    String text = String.format("应用:%s 服务ID:%s,服务ip:%s 状态改变为：[%s ---> %s]，时间：%s"
                            , changedEvent.getApplication().getName()
                            , changedEvent.getApplication().getId()
                            , changedEvent.getApplication().getHealthUrl()
                            , changedEvent.getFrom().getStatus()
                            , changedEvent.getTo().getStatus()
                            , DateUtils.formatDate(new Date(changedEvent.getTo().getTimestamp()),"yyyy-MM-dd HH:mm:ss"));

                    if (notifierProperties.getNotifier().isEnabled()){
                        log.info("开启了通知功能");
                        Boolean var = Arrays.asList(notifierProperties.getNotifier().getNotifierStatuses()).contains(changedEvent.getTo().getStatus());
                        log.info("当前通知状态为：{}，是否在监控范围：{}",changedEvent.getTo().getStatus(),var);
                        if (var) {
                            for(String endPoint : notifierProperties.getNotifier().getEndpoints()){
                                SendFactory.getInstance()
                                        .create(endPoint)
                                        .sendMessage(messageSource,text,notifierProperties);
                                log.info("进行【{}】监控通知",endPoint);
                            }
                            log.warn("监控的内容为：{}",text);
                        }
                    }
                } else {
                    log.info("Application {} ({}) {}", event.getApplication().getName(), event.getApplication().getId(), event.getType());
                }
            }
        });
        // 每X分钟就需要提醒一次
        remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(notifierProperties.getNotifier().getMillis()));
        return remindingNotifier;
    }
}