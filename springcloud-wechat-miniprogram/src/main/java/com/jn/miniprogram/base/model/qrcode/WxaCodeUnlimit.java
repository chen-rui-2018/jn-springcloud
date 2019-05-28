package com.jn.miniprogram.base.model.qrcode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/3/18 15:44
 * @Version： v1.0
 * @Modified By:
 */
public class WxaCodeUnlimit implements Serializable {

    private static final long serialVersionUID = 5139063684982421673L;

    private String scene;

    private String page;

    private int width = 430;

    private boolean auto_color = true;

    private boolean is_hyaline = false;

    private WxMiniCodeLineColor line_color = new WxMiniCodeLineColor("0", "0", "0");

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isAuto_color() {
        return auto_color;
    }

    public void setAuto_color(boolean auto_color) {
        this.auto_color = auto_color;
    }

    public boolean isIs_hyaline() {
        return is_hyaline;
    }

    public void setIs_hyaline(boolean is_hyaline) {
        this.is_hyaline = is_hyaline;
    }

    public WxMiniCodeLineColor getLine_color() {
        return line_color;
    }

    public void setLine_color(WxMiniCodeLineColor line_color) {
        this.line_color = line_color;
    }
}
