package com.jn.common.model;

import com.jn.common.util.GlobalConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统一结果
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Result", description = "返回结果实体")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "返回结果描述",notes = "成功默认为ok",dataType = "String")
    private String result = "OK";
    @ApiModelProperty(value = "返回结果编码",notes = "成功统一编码为0000",dataType = "String")
    private String code = GlobalConstants.SUCCESS_CODE;
    @ApiModelProperty(value = "返回具体实体",dataType = "object")
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
