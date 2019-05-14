package com.jn.hardware.model.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/9 14:43
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SecurityPlayBackUrlParam", description = "获取监控点回放取流URL入参实体")
public class SecurityPlayBackUrlParam implements Serializable {

    private static final long serialVersionUID = 3694692032488380074L;
    @ApiModelProperty(value = "监控点唯一标识",required = true,example = "90ad77d8057c43dab140b77361606927")
    private String   cameraIndexCode;
    @ApiModelProperty(value = "存储类型,0：中心存储 1：设备存储 默认为中心存储",example = "1")
    private String   recordLocation;
    @ApiModelProperty(value = "取流协议（应用层协议) “rtsp”:RTSP协议 “ws”: webSocket协议 “rtmp”:RTMP协议 “hls”:HLS协议 参数不填，默认为RTSP协议",example = "RTSP")
    private String   protocol;
    @ApiModelProperty(value = "传输协议（传输层协议）0:UDP 1:TCP 默认为tcp，在protocol设置为rtsp或者rtmp时有效 注：EHOME设备回放只支持TCP传输 GB28181 2011及以前版本只支持UDP传输",example = "1")
    private String   transmode;
    @ApiModelProperty(value = "开始查询时间（IOS8601格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX） 例如北京时间： 2017-06-14T00:00:00.000+08:00",example = "2017-06-14T00:00:00.000+08:00")
    private String   beginTime;
    @ApiModelProperty(value = "结束查询时间，开始时间和结束时间相差不超过三天； （IOS8601格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX）例如北京时间： 2017-06-15T00:00:00.000+08:00",example = "2017-06-14T00:00:00.000+08:00")
    private String   endTime;
    @ApiModelProperty(value = "分页查询id，上一次查询返回的uuid，用于继续查询剩余片段，默认为空字符串",example = "4750e3a4a5bbad3cda5bbad3cd4af9ed5101")
    private String   uuid;
    @ApiModelProperty(value = "扩展内容，格式：key=value， 调用方根据其播放控件支持的解码格式选择相应的封装类型； 支持的内容详见附录F expand扩展内容说明",example = "streamform=rtp")
    private String   expand;

    public String getCameraIndexCode() {
        return cameraIndexCode;
    }

    public void setCameraIndexCode(String cameraIndexCode) {
        this.cameraIndexCode = cameraIndexCode;
    }

    public String getRecordLocation() {
        return recordLocation;
    }

    public void setRecordLocation(String recordLocation) {
        this.recordLocation = recordLocation;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getTransmode() {
        return transmode;
    }

    public void setTransmode(String transmode) {
        this.transmode = transmode;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    @Override
    public String toString() {
        return "SecurityPlayBackUrlParam{" +
                "cameraIndexCode='" + cameraIndexCode + '\'' +
                ", recordLocation='" + recordLocation + '\'' +
                ", protocol='" + protocol + '\'' +
                ", transmode='" + transmode + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", uuid='" + uuid + '\'' +
                ", expand='" + expand + '\'' +
                '}';
    }

}
