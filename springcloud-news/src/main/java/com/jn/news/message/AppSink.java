package com.jn.news.message;

import com.jn.common.channel.MessageSink;
import com.jn.news.app.service.AppSinkService;
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
        log.info("收到App的信息:{}",appSinkVo.toString()) ;
       // throw new JnSpringCloudException(CommonExceptionEnum.UN_KNOW);
        // TODO: 2018/11/8 请陈苗按这个模式来完成异步的功能
        appSinkService.pushMessage(appSinkVo.getContent(),appSinkVo.getTitle(),appSinkVo.getIds(),appSinkVo.getPlatfromType());

    }


}
