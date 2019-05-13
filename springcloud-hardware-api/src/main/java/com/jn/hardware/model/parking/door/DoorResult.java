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
public class DoorResult<T> implements Serializable {
    private static final long serialVersionUID = 4562373721879102371L;

    public static final String SUCCESS_CODE = "1";

    /**
     * 头部
     */
    private DoorHeadResult head = new DoorHeadResult();

    /**
     * 内容实体
     */
    private T body;

    public DoorHeadResult getHead() {
        return head;
    }

    public void setHead(DoorHeadResult head) {
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
        return "DoorResult{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }
}
