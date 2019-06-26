package com.jn.hardware.model.sdnware.heat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jn.hardware.model.sdnware.BaseResult;

import java.io.Serializable;

/**
 * @ClassName：无线AP ：区域人数统计（热力）出参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/26 11:15
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeatResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = -6836014367870618550L;

    /**
     * 区域人数统计（热力）实体类
    * */
    private HeatMessage message;

    public HeatMessage getMessage() {
        return message;
    }

    public void setMessage(HeatMessage message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HeatResult{" +
                "message=" + message +
                '}';
    }
}
