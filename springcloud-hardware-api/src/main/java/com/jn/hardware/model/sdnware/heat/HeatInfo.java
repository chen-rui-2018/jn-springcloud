package com.jn.hardware.model.sdnware.heat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @ClassName：无线AP ：区域人数统计（热力）详情信息
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/26 10:52
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeatInfo implements Serializable {

    private static final long serialVersionUID = 520407239427319227L;

    /**
     * 在线人数
    * */
    private String count;
    /**
     * ap mac地址
     * */
    private String device;
    /**
     * 经度
     * */
    private String lat;
    /**
     * 纬度
     * */
    private String lng;
    /**
     * ap名
     * */
    private String name;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "heatInfo{" +
                "count='" + count + '\'' +
                ", device='" + device + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
