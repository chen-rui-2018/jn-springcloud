package com.jn.miniprogram.base.model.qrcode;

import java.io.Serializable;

/**
 * 小程序码
 *
 * @Author： cm
 * @Date： Created on 2019/3/18 15:36
 * @Version： v1.0
 * @Modified By:
 */
public class WxaCode implements Serializable {

    private static final long serialVersionUID = 4177402601197192210L;

    private String path;

    private int width = 430;

    private boolean auto_color = true;

    private boolean is_hyaline = false;

    private WxMiniCodeLineColor line_color = new WxMiniCodeLineColor("0", "0", "0");

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
