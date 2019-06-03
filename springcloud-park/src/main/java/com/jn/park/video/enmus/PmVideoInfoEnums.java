package com.jn.park.video.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 录像播放信息枚举
 * @Author: yangph
 * @Date: 2019/3/27 20:38
 * @Version v1.0
 * @modified By:
 */
public enum PmVideoInfoEnums implements CodeAndMsg {
    VIDEO_PLAY_INFO("安防录像权限已过期","安防录像权限已过期")
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PmVideoInfoEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
