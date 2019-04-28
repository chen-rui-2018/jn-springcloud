package com.jn.hardware.model.electricmeter;

import com.jn.common.util.GlobalConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/23 17:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricResult",description = "电表统一返回对象实体")
public class ElectricResult<T> implements Serializable {
    @ApiModelProperty(value = "返回结果描述",notes = "成功默认为ok",dataType = "String")
    private String msg = "OK";
    @ApiModelProperty(value = "返回结果编码",notes = "成功统一编码为0000",dataType = "String")
    private String code = GlobalConstants.SUCCESS_CODE;
    private T data;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public ElectricResult(String msg, String code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
    public ElectricResult(String code, String msg){
        this.msg = msg;
        this.code = code;
    }
    public ElectricResult(T data) {
        this.data = data;
    }
    public ElectricResult(){}

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
