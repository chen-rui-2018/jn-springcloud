package com.jn.hardware.model.parking.door;

import java.io.Serializable;

/**
 * 道尔统一返回对象
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 16:50
 * @Version： v1.0
 * @Modified By:
 */
public class DoorHeadResult<T> implements Serializable {

    private static final long serialVersionUID = 2781143545628231967L;

    /**
     * 0 失败 1 成功
     */
    private String status="1";
    /**
     * 说明信息
     */
    private String message="成功";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DoorHeadResult{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
