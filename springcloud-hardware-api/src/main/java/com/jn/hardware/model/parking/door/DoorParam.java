package com.jn.hardware.model.parking.door;

import java.io.Serializable;

/**
 * 出入场车辆信息推送返回参数至道尔
 *
 * @Author： cm
 * @Date： Created on 2019/6/29 20:05
 * @Version： v1.0
 * @Modified By:
 */
public class DoorParam<T> implements Serializable {
    private static final long serialVersionUID = -3119410348585089982L;

    public static final String SUCCESS_CODE = "1";
    public static final String FAIL_CODE = "0";
    /**
     * 返回道尔的失败提示，统一为下面描述
     */
    public static final String FAIL_MSG = "业务处理失败";

    /**
     * 头部
     */
    private DoorHeadParam head = new DoorHeadParam();

    /**
     * 内容实体
     */
    private T body;

    public DoorHeadParam getHead() {
        return head;
    }

    public void setHead(DoorHeadParam head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "DoorParam{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }
}
