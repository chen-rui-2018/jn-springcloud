package com.jn.wechat.base.service.impl;

import com.jn.system.log.annotation.ServiceLog;
import com.jn.wechat.base.model.menu.WxMenu;
import com.jn.wechat.base.service.WxHttpClientService;
import com.jn.wechat.base.service.WxMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信公众号菜单实现类
 *
 * @Author： cm
 * @Date： Created on 2019/1/21 16:40
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class WxMenuServiceImpl implements WxMenuService {
    private static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/menu/create";
    private static Logger logger = LoggerFactory.getLogger(WxMenuServiceImpl.class);

    @Autowired
    private WxHttpClientService wxHttpClientService;

    @Override
    @ServiceLog(doAction = "创建菜单")
    public String menuCreate(WxMenu menu) {
        logger.debug("开始创建菜单：{}", menu);
        String result = wxHttpClientService.post(API_URL_PREFIX,menu);
        logger.debug("创建菜单：{},结果：{}", menu, result);

        return null;
    }
}
