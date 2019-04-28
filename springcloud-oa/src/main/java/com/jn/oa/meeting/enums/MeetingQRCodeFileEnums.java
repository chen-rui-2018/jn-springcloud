package com.jn.oa.meeting.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 会议预约签到二维码数据字典
 * @author： yuanyy
 * @date： Created on 2019/4/24 17:03
 * @version： v1.0
 * @modified By:
 */
public enum MeetingQRCodeFileEnums implements CodeAndMsg {

    MEETING_UPLOAD_MODULE_CODE("springcloud-oa", "模块编码"),
    MEETING_UPLOAD_PARENT_GROUP_CODE("meeting_upload_file", "父分组编码"),
    MEETING_UPLOAD_GROUP_CODE("meeting_upload_sign_in_QR", "分组编码"),
    MEETING_UPLOAD_KEY("sign_in_QR_code", "数据字典的键");

    private String code;

    private String message;

    MeetingQRCodeFileEnums(String key, String message) {
        this.code = key;
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
