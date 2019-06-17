package com.jn.utils;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.send.enums.DelayStreamExceptionEnum;
import com.jn.send.model.Delay;

import java.text.ParseException;
import java.util.Date;

/**
 * 时间转化类
 *
 * @author： fengxh
 * @date： Created on 2019/6/15 16:04
 * @version： v1.0
 * @modified By:
 */
public  class ChangeDate {

    /**
     * 日期转化规则
     */
    public final static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 处理延迟消息的ttl
     * @param delay
     * @return
     */
    public static Long handleDate(Delay delay) {
        if(StringUtils.isBlank(delay.getDateString()) && StringUtils.isBlank(delay.getTtl())){
            throw new JnSpringCloudException(DelayStreamExceptionEnum.DATE_NOT_NULL);
        }
        Long ttl ;
        if(StringUtils.isNotBlank(delay.getTtl())){
            ttl = Long.valueOf(delay.getTtl());
        }else {
            Date startDate;
            try {
                startDate = DateUtils.parseDate(delay.getDateString(),PATTERN);
            } catch (ParseException e) {
                throw new JnSpringCloudException(DelayStreamExceptionEnum.DATE_FORMAT_FAIL);
            }
            ttl= (startDate.getTime() - System.currentTimeMillis());
        }
        if(ttl <= 0L){
            throw new JnSpringCloudException(DelayStreamExceptionEnum.DATE_NOT_LETTER_NOW);
        }

        return ttl;
    }
}
