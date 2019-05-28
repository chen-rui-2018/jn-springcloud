package com.jn.miniprogram.base.model.qrcode;

/**
 * 使用 rgb 设置颜色
 * 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
 *
 * @Author： cm
 * @Date： Created on 2019/3/15 19:23
 * @Version： v1.0
 * @Modified By:
 */
public class WxMiniCodeLineColor {

    private String r = "0";
    private String g = "0";
    private String b = "0";

    public WxMiniCodeLineColor() {

    }

    public WxMiniCodeLineColor(String r, String g, String b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "WxMiniCodeLineColor{" +
                "r='" + r + '\'' +
                ", g='" + g + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
