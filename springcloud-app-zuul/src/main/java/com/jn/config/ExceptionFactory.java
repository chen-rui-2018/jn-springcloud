package com.jn.config;

import com.jn.enums.ZuulExceptionEnum;
import org.apache.catalina.Host;
import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 通过 throwable来定异常
 *
 * @author： fengxh
 * @date： Created on 2018/11/26 15:42
 * @version： v1.0
 * @modified By:
 */
@Component
public class ExceptionFactory {
    private static Logger logger = LoggerFactory.getLogger(ExceptionFactory.class);


    /**
     * 通过 throwable来定异常接口
     * @param e
     * @return
     */
    public CodeAndMsg create (Throwable e) {
        if (e == null) {
            logger.error("Zuul 没有实际的异常发生，默认返回服务暂时不可用") ;
            return ZuulExceptionEnum.COMMON_EXCEPTION;
        }
        //Read timed out
        if (e instanceof java.net.SocketTimeoutException) {
            logger.error("Zuul 链接服务超时：{}",e.getMessage()) ;
            return ZuulExceptionEnum.TIME_OUT_EXCEPTION;
        }
        //connect timed out
        if (e instanceof org.apache.http.conn.ConnectTimeoutException) {
            HttpHost host = ((ConnectTimeoutException) e).getHost();
            logger.error("Zuul 链接服务不可用,链接地址：【{}】，具体异常：【{}】",host.getHostName()+":"+host.getPort(),e.getMessage());
            return ZuulExceptionEnum.COMMON_EXCEPTION;
        }
        // TODO: 2018/11/26 炮哥，这个是Zuul对异常处理的封装，我只对read time out 进行了封装，后面如果业务需要其他异常的封装，你来补充一下。
        logger.error("Zuul 发生了异常：{}",e.getMessage(), e) ;
        return ZuulExceptionEnum.COMMON_EXCEPTION;
    }
}
