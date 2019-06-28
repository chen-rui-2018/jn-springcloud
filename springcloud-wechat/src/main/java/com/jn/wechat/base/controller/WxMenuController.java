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

        /*WxMenuButton button1 = new WxMenuButton();
        button1.setType(WxConsts.MenuButtonType.CLICK);
        button1.setName("今日歌曲");
        button1.setKey("V1001_TODAY_MUSIC");
        menu.getButton().add(button1);*/

        WxMenuButton button2 = new WxMenuButton();
        button2.setName("园区简介");
        menu.getButton().add(button2);

        WxMenuButton button21 = new WxMenuButton();
        button21.setType(WxConsts.MenuButtonType.VIEW);
        button21.setName("园区简介");
        String url = wxService.oauth2buildAuthorizationUrl(
                "http://2j676w.natappfree.cc/h5/meeting",
                WxConsts.OAuth2Scope.SNSAPI_BASE, null);
        button21.setUrl(url);
        /*button21.setUrl("https://screan.bxgxq.com/#/investment");*/

        WxMenuButton button3 = new WxMenuButton();
        button3.setName("园区资讯");
        menu.getButton().add(button3);

        WxMenuButton button31 = new WxMenuButton();
        button31.setType(WxConsts.MenuButtonType.VIEW);
        button31.setName("园区政策");
        String url2 = wxService.oauth2buildAuthorizationUrl(
                "http://2j676w.natappfree.cc/h5/meeting",
                WxConsts.OAuth2Scope.SNSAPI_BASE, null);
        button31.setUrl(url2);
        /*button31.setUrl("https://screan.bxgxq.com/#/policyGuide");*/

        WxMenuButton button32 = new WxMenuButton();
        button32.setType(WxConsts.MenuButtonType.VIEW);
        button32.setName("园区公告");
        /*String url2 = wxService.oauth2buildAuthorizationUrl(
                "http://92a52v.natappfree.cc/h5/meeting/css/media.css",
                WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        button23.setUrl(url2);*/
        button32.setUrl("http://screan.bxgxq.com/#/parkNotice");
        WxMenuButton button33 = new WxMenuButton();
        button33.setType(WxConsts.MenuButtonType.VIEW);
        button33.setName("企业资讯");
        /*String url2 = wxService.oauth2buildAuthorizationUrl(
                "http://92a52v.natappfree.cc/h5/meeting/css/media.css",
                WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        button23.setUrl(url2);*/
        button33.setUrl("http://screan.bxgxq.com/#/enterpriseInformationList");

        /*WxMenuButton button22 = new WxMenuButton();
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
        button24.setUrl(url);*/

        button2.getSub_button().add(button21);
        button3.getSub_button().add(button31);
        button3.getSub_button().add(button32);
        button3.getSub_button().add(button33);
        return wxMenuService.menuCreate(menu);
    }

}
