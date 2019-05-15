package com.jn.hardware.security.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： chenr
 * @date： Created on 2019/5/9 11:27
 * @version： v1.0
 * @modified By:
 */
public enum SecurityEnum implements CodeAndMsg {
    SECURITY_RESULT_NORMAL("0","安防视频返回正常编码"),
    ARTEMIS_PATH("/artemis","能力开放平台的网站路径"),
    MONITORING_POINT("/api/resource/v1/camera/advance/cameraList","监控点列表获取路径"),
    PLAY_BACK_URL("/api/video/v1/cameras/playbackURLs","回放路径url获取路径"),
    APPLICATION_JSON("application/json","数据传输格式"),
    ARTEMIS_CONFIG_HOST("192.168.30.2:80","代理API网关nginx服务器ip端口"),
    ARTEMIS_CONFIG_APP_KEY("26640530","秘钥appkey"),
    ARTEMIS_CONFIG_APP_SECRET("9Y1ITedfNdM61so4ile5"," 秘钥appSecret"),
    HTTP_PROTOCOL_TYPE("http://","http协议")

    ;
    private String code;
    private String message;
    SecurityEnum(String code, String message){
        this.code= code;
        this.message = message;
    }
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
