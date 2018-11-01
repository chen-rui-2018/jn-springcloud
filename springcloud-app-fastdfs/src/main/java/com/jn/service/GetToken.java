package com.jn.service;

import com.jn.model.Token;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 获取token
 *
 * @author： fengxh
 * @date： Created on 2018/11/1 15:13
 * @version： v1.0
 * @modified By:
 */
public interface GetToken {
    /**
     * 获取访问的token
     * @param fileName      文件名字
     * @return 返回Token实体
     */
    Token getToken(String fileName ) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
