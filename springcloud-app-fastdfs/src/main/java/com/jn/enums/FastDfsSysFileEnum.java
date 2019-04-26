package com.jn.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 访客文件组数据字典枚举
 *
 * @author： yuanyy
 * @date： Created on 2019/4/23 15:28
 * @version： v1.0
 * @modified By:
 */
public enum FastDfsSysFileEnum implements CodeAndMsg {

    VISITOR_UPLOAD_MODULE_CODE("springcloud_fastdfs", "模块编码"),
    VISITOR_UPLOAD_PARENT_GROUP_CODE("guest_upload_fastUpload", "父分组编码"),
    VISITOR_UPLOAD_GROUP_CODE("visitor_upload_fastUpload", "分组编码"),
    VISITOR_UPLOAD_KEY("visitor_fileGroup_id", "数据字典的键");

    private String code;
    private String message;

    FastDfsSysFileEnum(String code, String message) {
        this.code = code;
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
