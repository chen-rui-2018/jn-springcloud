package com.jn.wechat.base.service;

import com.jn.wechat.base.model.menu.WxMenu;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/1/21 16:37
 * @Version： v1.0
 * @Modified By:
 */
public interface WxMenuService {

    /**
     * <pre>
     * 自定义菜单创建接口
     * 详情请见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013&token=&lang=zh_CN
     * 如果要创建个性化菜单，请设置matchrule属性
     * 详情请见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455782296&token=&lang=zh_CN
     * </pre>
     * @return 如果是个性化菜单，则返回menuid，否则返回null
     * @param menu
     */
    String menuCreate(WxMenu menu) ;

}
