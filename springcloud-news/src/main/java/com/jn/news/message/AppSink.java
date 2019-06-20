package com.jn.news.message;

import cn.jpush.api.push.PushResult;
import com.jn.common.channel.MessageSink;
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.news.app.model.JPushResult;
import com.jn.news.app.service.AppSinkService;
import com.jn.news.enums.NewsExceptionEnum;
import com.jn.news.vo.AppSinkVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 消息处理
 *
 * @author： cm
 * @date： Created on 2018/11/8 16:53
 * @version： v1.0
 * @modified By:
 */
@EnableBinding({MessageSink.class })
public class AppSink {

    private static Logger log = LoggerFactory.getLogger(AppSink.class);

    @Autowired
    AppSinkService appSinkService;

    @StreamListener(MessageSink.APP)
    public void listenApp(AppSinkVo appSinkVo) {
        if (appSinkVo == null) {
            throw new JnSpringCloudException(CommonExceptionEnum.ARGS_ERROR);
        }
        log.info("\n收到极光推送的信息:{}",appSinkVo.toString()) ;
        PushResult pushResult = appSinkService.pushMessage(appSinkVo.getTitle(), appSinkVo.getContent(), appSinkVo.getIds(),
                appSinkVo.getPushType(), appSinkVo.getPlatFromType(), appSinkVo.getNoticeType(),
                appSinkVo.getMessage());

        log.info("\n极光推送返回信息：{}", pushResult.toString());
    }

}
