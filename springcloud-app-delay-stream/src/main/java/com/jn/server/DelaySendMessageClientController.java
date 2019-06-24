package com.jn.server;

import com.jn.channel.DelayMessageSend;
import com.jn.common.model.Result;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.utils.MessageSendFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实例
 *
 * @author： fengxh
 * @date： Created on 2018/11/9 10:41
 * @version： v1.0
 * @modified By:
 */
@RestController
public class DelaySendMessageClientController implements DelaySendMessageClient {


    @Autowired
    private MessageSendFactory messageSendFactory;

    private static Logger log = LoggerFactory.getLogger(DelaySendMessageClientController.class);



    @Override
    public Result<Boolean> delaySend(@Validated @RequestBody Delay var) {
        log.info("接收到延迟消息内容：【{}】",var.toString());
        messageSendFactory.createDelayMessageSend(var).send(var);
        return new Result<>(Boolean.TRUE);
    }
}
