package com.jn.wechat.base.service.impl.wxmessagehandleserviceimpl;

import com.jn.wechat.base.WxConsts;
import com.jn.wechat.base.model.message.WxXmlMessage;
import com.jn.wechat.base.model.message.WxXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 菜单点击事件业务处理
 *
 * @Author： cm
 * @Date： Created on 2019/6/20 15:47
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class MenuClickHandle extends AbstractHandler {
    @Override
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context) {
        //如有菜单点击事件业务处理可以在此实现
        return null;
    }

    @Override
    public String getWxMessHandleCode() {
        return WxConsts.EventType.MENU_VIEW;
    }
}
