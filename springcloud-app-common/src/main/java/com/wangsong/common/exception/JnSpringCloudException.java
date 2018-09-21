package com.wangsong.common.exception;


import com.wangsong.common.api.CodeAndMsg;

/**
 * 统一接口对外的异常包装类，用于业务抛异常
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
public class JnSpringCloudException extends RuntimeException {
    /**
     * 错误编码
     */
    protected String code;
    /**
     * 错误信息
     */
    protected String msg;
    /**
     * 通过接口实例类
     * @param codeAndMsg 状态业务方法
     */
    public JnSpringCloudException(CodeAndMsg codeAndMsg) {
        super(codeAndMsg.getMessage());
        this.msg = codeAndMsg.getMessage();
        this.code = codeAndMsg.getCode();
    }
    /**
     * 通过接口实例类
     * @param codeAndMsg
     * @param msg 动态信息
     */
    public JnSpringCloudException(CodeAndMsg codeAndMsg, String msg) {
        super(msg);
        this.msg = msg;
        this.code = codeAndMsg.getCode();
    }
    /**
     * 通过接口实例类
     * @param codeAndMsg
     * @param throwable 抛出的异常
     */
    public JnSpringCloudException(CodeAndMsg codeAndMsg, Throwable throwable) {
        super(codeAndMsg.getMessage(),throwable);
        this.msg = codeAndMsg.getMessage();
        this.code = codeAndMsg.getCode();
    }
    /**
     * 实例
     * @param codeAndMsg 编码与信息业务方法
     * @param throwable
     * @param msg  动态信息
     */
    public JnSpringCloudException(CodeAndMsg codeAndMsg, Throwable throwable, String msg) {
        super(msg,throwable);
        this.msg = msg;
        this.code = codeAndMsg.getCode();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
