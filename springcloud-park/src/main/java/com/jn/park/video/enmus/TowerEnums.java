package com.jn.park.video.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 园区楼宇枚举
 * @Author: yangph
 * @Date: 2019/3/27 20:38
 * @Version v1.0
 * @modified By:
 */
public enum TowerEnums implements CodeAndMsg {
    FIRST_TOWER("0001","1号楼国际人才孵化器"),
    SECOND_TOWER("0002","2号楼金融中心"),
    THIRD_TOWER("0003","3号软件信息大厦"),
    FOURTH_TOWER("0004","4号楼云计算创新基地"),
    FIFTH_TOWER("0005","孵化大楼"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    TowerEnums(String code, String message) {
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
