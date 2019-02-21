package com.jn.wechat.base.model.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单（公众号和企业号共用的）
 *
 * @Author： cm
 * @Date： Created on 2019/1/21 16:08
 * @Version： v1.0
 * @Modified By:
 */
public class WxMenu implements Serializable {

    private static final long serialVersionUID = 6521043456007301532L;

    private List<WxMenuButton> button = new ArrayList<>();

    public List<WxMenuButton> getButton() {
        return button;
    }

    public void setButton(List<WxMenuButton> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "WxMenu{" +
                "button=" + button +
                '}';
    }
}
