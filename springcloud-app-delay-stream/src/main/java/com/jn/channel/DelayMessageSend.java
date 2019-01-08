package com.jn.channel;

import com.jn.send.model.Delay;

/**
 * 延迟时间发送
 *
 * @author： fengxh
 * @date： Created on 2019/1/7 12:03
 * @version： v1.0
 * @modified By:
 */
public interface DelayMessageSend {

    /**
     * 延迟时间发送
     * @param delay
     */
    void send(Delay delay);
}
