package com.jn.wechat.base.model.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.wechat.base.enums.WxErrorMsgEnum;
import com.jn.wechat.base.model.security.AccessToken;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * 微信错误码
 *
 * @Author： cm
 * @Date： Created on 2019/2/28 16:12
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WxError implements Serializable {

    private static final long serialVersionUID = 5917441716227154123L;
    /**
     * 微信错误代码.
     */
    private String errcode;

    /**
     * 微信错误信息.
     */
    private String errmsg;

    public static WxError fromJson(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        WxError wxError = null;
        try {
            wxError = objectMapper.readValue(json, WxError.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (StringUtils.isNotEmpty(wxError.getErrcode())) {
            wxError.setErrcode(wxError.getErrcode());
        }
        final String msg = WxErrorMsgEnum.findMsgByCode(wxError.getErrcode());
        if (msg != null) {
            wxError.setErrmsg(msg);
        }
        return wxError;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "错误: Code=" + this.errcode + ", Msg=" + this.errmsg;
    }
}
