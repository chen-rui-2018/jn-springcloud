package com.jn.miniprogram.base.model.qrcode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    private static final long serialVersionUID = -1742618326691829410L;

    @NotNull(message = "扫码进入的小程序页面路径不能为空")
    @Size(max = 128, message = "扫码进入的小程序页面路径长度不能超过128")
    private String path;
    /**
     * 二维码的宽度，单位 px
     */
    private int width = 430;
    /**
     * 自动配置线条颜色
     */
    private boolean auto_color = true;
    /**
     * 是否需要透明底色
     */
    private boolean is_hyaline = false;
    /**
     * auto_color为false时生效，使用rgb设置颜色
     */
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

    @Override
    public String toString() {
        return "WxaCode{" +
                "path='" + path + '\'' +
                ", width=" + width +
                ", auto_color=" + auto_color +
                ", is_hyaline=" + is_hyaline +
                ", line_color=" + line_color +
                '}';
    }
}
