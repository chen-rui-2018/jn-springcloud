package com.jn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * TODO：未添加类描述
 *
 * @Author： hey
 * @Date： Created on 2019/05/23 11:08
 * @Version： v1.0
 * @Modified By:
 */

@Component
@ConfigurationProperties(prefix = "reconciliation.alipay")
@RefreshScope
public class AlipayConfig {

    /**
     * 合作身份者ID，签约账号
     */
    private String partner;

    /**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    private  String url;

    /**
     * 文件存放路径
     */
    private  String dir;

    /**
     * MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    * */
    private  String key;

    /**
     * 加密方式
     * */
    private  String signType;
    /**
     *  调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
    * */
    private  String logPath;
    /**
     * 字符编码格式
     * */
    private  String charset ;

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
