package com.jn.miniprogram.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.miniprogram.base.api.WechatMiniProgramClient;
import com.jn.miniprogram.base.model.qrcode.WxaCode;
import com.jn.miniprogram.base.model.qrcode.WxaCodeUnlimit;
import com.jn.miniprogram.base.service.WxMiniQrcodeService;
import com.jn.miniprogram.base.service.WxMiniService;
import com.jn.system.log.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供内部调用的小程序接口
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 15:38
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class WechatMiniprogramController extends BaseController implements WechatMiniProgramClient {

    @Autowired
    private WxMiniService wxMiniService;

    @Autowired
    private WxMiniQrcodeService wxMiniQrcodeService;

    /**
     * 强制获取access_token
     */
    @Override
    @ControllerLog(doAction = "强制获取access_token")
    public void refreshAccessToken() {
        wxMiniService.getAccessToken();
    }

    @Override
    public Result<String> createWxaCode(WxaCode wxaCode) {
        return null;
    }

    @Override
    public Result<String> createWxaCodeUnlimit(WxaCodeUnlimit wxaCodeUnlimit) {
        return null;
    }

    @Override
    public Result<String> createQrcode(WxaCode wxaCode) {
        return null;
    }
}
