package com.jn.wechat.base.controller;

import com.jn.system.log.annotation.ControllerLog;
import com.jn.wechat.base.WxConsts;
import com.jn.wechat.base.model.menu.WxMenu;
import com.jn.wechat.base.model.menu.WxMenuButton;
import com.jn.wechat.base.service.WxMenuService;
import com.jn.wechat.base.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 菜单控制类
 *
 * @Author： cm
 * @Date： Created on 2019/1/21 17:24
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/guest/wechat/menu")
public class WxMenuController {

    @Autowired
    private WxMenuService wxMenuService;

    @Autowired
    private WxService wxService;

    /**
     * 创建菜单
     * @param menu
     * @return
     */
    @ControllerLog(doAction = "POST请求，自定义创建菜单")
    @PostMapping("/create")
    public String menuCreate(@RequestBody WxMenu menu) {
        return wxMenuService.menuCreate(menu);
    }

    @ControllerLog(doAction = "GET请求，初始化菜单")
    @GetMapping("/create")
    public String menuCreateSample() {
        WxMenu menu = new WxMenu();

        WxMenuButton button1 = new WxMenuButton();
        button1.setType(WxConsts.MenuButtonType.CLICK);
        button1.setName("今日歌曲");
        button1.setKey("V1001_TODAY_MUSIC");
        menu.getButton().add(button1);

        WxMenuButton button2 = new WxMenuButton();
        button2.setName("菜单");
        menu.getButton().add(button2);

        WxMenuButton button21 = new WxMenuButton();
        button21.setType(WxConsts.MenuButtonType.VIEW);
        button21.setName("搜索");
        button21.setUrl("http://www.soso.com/");

        WxMenuButton button22 = new WxMenuButton();
        button22.setType(WxConsts.MenuButtonType.VIEW);
        button22.setName("视频");
        button22.setUrl("http://v.qq.com/");

        WxMenuButton button23 = new WxMenuButton();
        button23.setType(WxConsts.MenuButtonType.CLICK);
        button23.setName("赞一下我们");
        button23.setKey("V1001_GOOD");

        WxMenuButton button24 = new WxMenuButton();
        button24.setType(WxConsts.MenuButtonType.VIEW);
        button24.setName("获取用户信息");
        String url = wxService.oauth2buildAuthorizationUrl(
                "http://iwhcv8.natappfree.cc/springcloud-wechat/guest/wechat/redirect/greet",
                WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        button24.setUrl(url);

        button2.getSub_button().add(button21);
        button2.getSub_button().add(button22);
        button2.getSub_button().add(button23);
        button2.getSub_button().add(button24);

        return wxMenuService.menuCreate(menu);
    }

}
