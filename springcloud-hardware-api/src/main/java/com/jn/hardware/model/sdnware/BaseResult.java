package com.jn.hardware.model.sdnware;

import java.io.Serializable;

/**
 * @ClassName：sdnware(无线AP) ：响应基础参数
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/26 10:29
 * @Version： v1.0
 * @Modified By:
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 5482761400799275915L;

    public static final String SUCCESS_CODE = "200";

    /**
     * 响应码
     * 200 查询成功
     * 403 超时
     * 500 查询失败
    * */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
