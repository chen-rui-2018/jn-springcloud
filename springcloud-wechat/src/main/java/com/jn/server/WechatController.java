package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.wechat.api.WechatClient;
import com.jn.wechat.base.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 强制刷新access_token
 * <p>
 *     目前Access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值。
 *     中控服务器需要根据这个有效时间提前去刷新新access_token。在刷新过程中，
 *     中控服务器可对外继续输出的老access_token，此时公众平台后台会保证在5分钟内，
 *     新老access_token都可用，这保证了第三方业务的平滑过渡
 * </p>
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 15:38
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class WechatController extends BaseController implements WechatClient {

    @Autowired
    private WxService wxService;

    @Override
    public void refreshAccessToken() {
        wxService.getAccessToken();
    }
}
