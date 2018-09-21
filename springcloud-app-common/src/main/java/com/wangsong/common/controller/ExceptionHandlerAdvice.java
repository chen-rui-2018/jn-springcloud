package com.wangsong.common.controller;

import com.wangsong.common.enums.CommonExceptionEnum;
import com.wangsong.common.exception.JnSpringCloudException;
import com.wangsong.common.model.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * 异常处理增强器
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 11:24
 * @version： v1.0
 * @modified By:
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    /**
     * 鉴权失败
     * @param e
     * @return
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public Result unAuth(UnauthorizedException e) {
        logger.error("鉴权失败:{}",e.getMessage());
        return new Result(CommonExceptionEnum.UN_AUTH.getCode(), CommonExceptionEnum.UN_AUTH.getMessage());
    }
    /**
     * 业务异常处理
     */
    @ExceptionHandler(JnSpringCloudException.class)
    public Result handleJnSpringCloudException(JnSpringCloudException e) {
        logger.error("JnSpringCloudException异常:{}:{}", e.getCode(), e.getMsg());
        return new Result(e.getCode(), e.getMsg());
    }
    /**
     * valid的参数异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuffer resultBuffer = new StringBuffer();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            for(ObjectError objectError :errors) {
                resultBuffer.append(objectError.getDefaultMessage()).append(",");
            }
        }else {
            resultBuffer.append(tips) ;
        }
        return new Result(CommonExceptionEnum.VALID_ERROR.getCode(),resultBuffer.toString());
    }
    /**
     * 断言判断参数的异常处理
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handelIllegalArgumentException(IllegalArgumentException e) {
        logger.error("IllegalArgumentException异常", e);
        return new Result(CommonExceptionEnum.NOT_NULL.getCode(), e.getMessage());
    }
    /**
     * Exception的异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        logger.error("Exception异常", e);
        return new Result(CommonExceptionEnum.UN_KNOW.getCode(), e.getMessage());
    }
    /**
     * 最顶层的异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public Result handleThrowable(Throwable e) {
        logger.error("Throwable异常", e);
        return new Result(CommonExceptionEnum.UN_KNOW.getCode(), e.getMessage());
    }


}
