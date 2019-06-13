package com.jn.oa.goods.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 通讯录配置类
 *
 * @author： shaobao
 * @date： Created on 2019/3/14 16:48
 * @version： v1.0
 * @modified By:
 **/
@ConfigurationProperties(
        prefix = "jn.oa.goods.information"
)
@Component
@RefreshScope
public class GoodsProperties {

    /**
     * 角色ID，用于物品数量为0时,为指定用户发送邮件
     */
    private String goodsManagerRolesId;

    public String getGoodsManagerRolesId() {
        return goodsManagerRolesId;
    }

    public void setGoodsManagerRolesId(String goodsManagerRolesId) {
        this.goodsManagerRolesId = goodsManagerRolesId;
    }
}
