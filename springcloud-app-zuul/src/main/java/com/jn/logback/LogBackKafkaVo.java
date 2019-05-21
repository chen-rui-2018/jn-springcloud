package com.jn.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.util.ZuulUtils;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Date;

/**
 * Kafka的日志对象模型
 *
 * @author： fengxh
 * @date： Created on 2019/5/13 14:26
 * @version： v1.0
 * @modified By:
 */
public class LogBackKafkaVo {

    private String projectName;

    private String dateTime;

    private String threadName ;

    private String className;

    private String message;

    private String level;

    private Long timestamp;

    private String host;

    private String remoteIp;

    public static LogBackKafkaVo build (ILoggingEvent eventObject,String sysName) {
        LogBackKafkaVo logBackKafkaVo = new LogBackKafkaVo() ;
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            logBackKafkaVo.setProjectName(sysName);
            logBackKafkaVo.setLevel(eventObject.getLevel().levelStr);
            logBackKafkaVo.setClassName(eventObject.getLoggerName());
            logBackKafkaVo.setDateTime(DateFormatUtils.format(new Date(eventObject.getTimeStamp()),"yyyy-MM-dd HH:mm:ss:SSS"));
            logBackKafkaVo.setThreadName(eventObject.getThreadName());
            logBackKafkaVo.setMessage(eventObject.getFormattedMessage());
            logBackKafkaVo.setTimestamp(eventObject.getTimeStamp());
            logBackKafkaVo.setHost(InetAddress.getLocalHost().getHostAddress());
            logBackKafkaVo.setRemoteIp(ZuulUtils.getIpAddr(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logBackKafkaVo;
    }




    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
