package com.jn.hardware.model.sdnware.heat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：无线AP ：区域人数统计（热力）实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/26 11:07
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeatMessage implements Serializable {

    private static final long serialVersionUID = -6836014367870618550L;

    /**
     * 区域人数统计（热力）信息
    * */
    private List<HeatInfo> positions;
    /**
     * 总连接数
     * */
    private String total;
    /**
     * 用户名
     * */
    private String area;

    public List<HeatInfo> getPositions() {
        return positions;
    }

    public void setPositions(List<HeatInfo> positions) {
        this.positions = positions;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "HeatResult{" +
                "positions=" + positions +
                ", total='" + total + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
