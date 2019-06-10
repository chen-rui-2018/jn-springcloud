package com.jn.miniprogram.base.model.qrcode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 小程序码接口B.
 *
 * @Author： cm
 * @Date： Created on 2019/3/18 15:44
 * @Version： v1.0
 * @Modified By:
 */
public class WxaCodeUnlimit implements Serializable {

    private static final long serialVersionUID = 861754110865270695L;
    /**
     * scene场景值，是一个标识符，主要作用是区分从哪个渠道扫码进到小程序的
     * 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，
     * 其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     */
    @NotNull(message = "scene场景值不能为空")
    @Size(max = 32, message = "scene场景值不能为空长度不能超过32")
    private String scene;
    /**
     * 必须是已经发布的小程序存在的页面（否则报错）
     */
    private String page;
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

    @Override
    public String toString() {
        return "WxaCodeUnlimit{" +
                "scene='" + scene + '\'' +
                ", page='" + page + '\'' +
                ", width=" + width +
                ", auto_color=" + auto_color +
                ", is_hyaline=" + is_hyaline +
                ", line_color=" + line_color +
                '}';
    }
}
