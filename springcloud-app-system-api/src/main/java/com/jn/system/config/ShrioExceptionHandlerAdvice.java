package com.jn.system.config;

import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.model.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author： shenph
 * @date： Created on 2018/12/5 14:18
 * @version： v1.0
 * @modified By:
 */
@RestControllerAdvice
public class ShrioExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ShrioExceptionHandlerAdvice.class);

    /**
     * 鉴权失败
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public Result unAuth(UnauthorizedException e) {
        logger.error("鉴权失败:{}", e.getMessage());
        return new Result(CommonExceptionEnum.UN_AUTH.getCode(), CommonExceptionEnum.UN_AUTH.getMessage());
    }


}
