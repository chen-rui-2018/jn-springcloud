package com.jn.test.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件域
 *
 * @author： fengxh
 * @date： Created on 2018/11/29 20:47
 * @version： v1.0
 * @modified By:
 */
@Component
@RefreshScope
public class TestDomain {

    @Value("${test.test}")
    private String test;

    @Value("${test.mis}")
    private Integer mis;


    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Integer getMis() {
        return mis;
    }

    public void setMis(Integer mis) {
        this.mis = mis;
    }
}
