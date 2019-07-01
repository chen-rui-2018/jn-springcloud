package com.jn.hardware.model.parking.door;

import java.io.Serializable;

/**
 * 道尔出入车辆信息头部参数
 *
 * @Author： cm
 * @Date： Created on 2019/6/29 20:01
 * @Version： v1.0
 * @Modified By:
 */
public class DoorHeadParam<T> implements Serializable {
    private static final long serialVersionUID = 7232097467082586186L;

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
        return "DoorHeadParam{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
