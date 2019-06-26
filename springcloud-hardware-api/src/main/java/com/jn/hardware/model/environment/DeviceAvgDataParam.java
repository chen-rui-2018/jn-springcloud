package com.jn.hardware.model.environment;

import com.jn.hardware.enums.environment.DeviceAvgTypeEnum;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 获取环境监测，每个设备指标平均的入参bean
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 15:12
 * @Version： v1.0
 * @Modified By:
 */
public class DeviceAvgDataParam implements Serializable {
    private static final long serialVersionUID = 3184918446063798103L;
    /**
     * 默认小时；指定返回数据的统计时段类型   day|hour
     */
    private DeviceAvgTypeEnum type = DeviceAvgTypeEnum.DEVICE_AVG_HOUR_TYPE;
    /**
     * 统计时段起始点， 时间格式yyyyMMddHHmmssSS
     */
    @NotBlank(message = "统计开始时间不能为空！")
    private String time;
    /**
     * 指定返回统计时段的个数，整数型
     */
    @NotBlank(message = "统计时段的个数不能为空！")
    private String num;

    public DeviceAvgTypeEnum getType() {
        return type;
    }

    public void setType(DeviceAvgTypeEnum type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "DeviceAvgDataParam{" +
                "type=" + type +
                ", time='" + time + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
