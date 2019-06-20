package com.jn.oa.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.oa.common.enums.OaExceptionEnums;
import com.jn.oa.schedule.service.impl.ScheduleServiceImpl;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 延时发送接口工具类
 *
 * @author： shaobao
 * @date： Created on 2019/3/22 19:43
 * @version： v1.0
 * @modified By:
 **/
public class DelaySendMessageUtil {

    /**
     * 日子组件
     */
    private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    /**
     * 延时发送方法
     *
     * @param serviceId              系统ID
     * @param serviceUrl             回调地址
     * @param sendTime               延时发送时间
     * @param object                 发送参数
     * @param delaySendMessageClient 延时发送客户端
     */
    public static void delaySend(String serviceId, String serviceUrl, Date sendTime, Object object,
                                 DelaySendMessageClient delaySendMessageClient) {
        Delay delay = new Delay();
        delay.setServiceId(serviceId);
        delay.setServiceUrl(serviceUrl);
        String delayTime = DateUtils.formatDate(sendTime, "yyyy-MM-dd HH:mm:ss");
        delay.setDateString(delayTime);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dataString = objectMapper.writeValueAsString(object);
            delay.setDataString(dataString);
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException转换异常，定时任务调用失败。", e);
            throw new JnSpringCloudException(OaExceptionEnums.TIMING_FAILURE);
        }
        Result<Boolean> result = delaySendMessageClient.delaySend(delay);
        if (result.getData() != null && result.getData()) {
            logger.info("[定时设置] 定时设置成功");
        } else {
            logger.error("[定时设置] 定时设置失败");
            throw new JnSpringCloudException(OaExceptionEnums.TIMING_FAILURE);
        }
    }
}
