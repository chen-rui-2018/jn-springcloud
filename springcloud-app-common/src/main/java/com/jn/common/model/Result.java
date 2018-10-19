package com.jn.common.model;

import java.io.Serializable;

/**
 * 统一结果
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
public class Result<T> implements Serializable {
    private String result = "OK";
    private String code = "0000";
    private T data;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Result(String result, String code, T data) {
        this.result = result;
        this.code = code;
        this.data = data;
    }
    public Result(String code, String result){
        this.result = result;
        this.code = code;
    }
    public Result(T data) {
        this.data = data;
    }
    public Result(){}
}
