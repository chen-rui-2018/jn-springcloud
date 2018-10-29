package com.jn.common.controller;

import com.jn.common.model.Result;
import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import java.util.List;

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
        return this.handleBindResult(e.getBindingResult()) ;
    }
    /**
     * Bind数据异常
     */
    @ExceptionHandler(value = BindException.class)
    public Result handelIllegalArgumentException(BindException e) {
        return this.handleBindResult(e);
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
     * 文件上传异常
     */
    @ExceptionHandler(value = MultipartException.class)
    public Result handelIllegalArgumentException(MultipartException e) {
        logger.error("文件流异常", e);
        return new Result(CommonExceptionEnum.FILE_ERROR.getCode(),CommonExceptionEnum.FILE_ERROR.getMessage());
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


    /**
     * 封装绑定参数的异常
     * @param bindingResult
     * @return
     */
    private Result handleBindResult(BindingResult bindingResult){
        StringBuffer resultBuffer = new StringBuffer();
        List<ObjectError> errors = bindingResult.getAllErrors();
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


}
