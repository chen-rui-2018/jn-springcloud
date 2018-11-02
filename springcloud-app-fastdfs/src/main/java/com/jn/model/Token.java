package com.jn.model;

import java.util.Objects;

/**
 * token的领域对象
 *
 * @author： fengxh
 * @date： Created on 2018/11/1 15:36
 * @version： v1.0
 * @modified By:
 */
public class Token {

    /**
     * token
     */
    private String token;

    /**
     * 时间戳
     */
    private Integer ts;

    public Token(String token, Integer ts) {
        this.token = token;
        this.ts = ts;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", ts='" + ts + '\'' +
                '}';
    }
}
