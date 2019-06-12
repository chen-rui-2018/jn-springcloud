package com.jn.oa.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 会议预约签到二维码数据字典
 * @author： yuanyy
 * @date： Created on 2019/4/24 17:03
 * @version： v1.0
 * @modified By:
 */
public enum OaAttachmentEnums implements CodeAndMsg {

    COMMON_UPLOAD_MODULE_CODE("springcloud-oa", "模块编码"),
    COMMON_UPLOAD_PARENT_GROUP_CODE("common", "父分组编码"),
    COMMON_UPLOAD_GROUP_CODE("attachment", "分组编码"),
    COMMON_UPLOAD_KEY("attachment_file_group", "数据字典的键");

    private String code;

    private String message;

    OaAttachmentEnums(String key, String message) {
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
