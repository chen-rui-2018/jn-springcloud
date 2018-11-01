package com.jn.service.impl;

import com.jn.model.Token;
import com.jn.service.GetToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 获取token
 *
 * @author： fengxh
 * @date： Created on 2018/11/1 15:28
 * @version： v1.0
 * @modified By:
 */
@Component
public class GeneratorGetToken implements GetToken {

    @Value("${fdfs.secret_key}")
    private String secretKey;


    /**
     * 默认编码
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    @Override
    public Token getToken(String fileName) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Integer ts = handleTs();
        byte[] bsFilename = fileName.getBytes(DEFAULT_CHARSET);
        byte[] bsKey = secretKey.getBytes(DEFAULT_CHARSET);
        byte[] bsTimestamp = ts.toString().getBytes(DEFAULT_CHARSET);
        byte[] buff = new byte[bsFilename.length + bsKey.length + bsTimestamp.length];
        System.arraycopy(bsFilename, 0, buff, 0, bsFilename.length);
        System.arraycopy(bsKey, 0, buff, bsFilename.length, bsKey.length);
        System.arraycopy(bsTimestamp, 0, buff, bsFilename.length + bsKey.length, bsTimestamp.length);
        String token = md5(buff);
        return new Token(token,ts);
    }

    /**
     * 设置超时时间
     * @return
     */
    private Integer handleTs(){
        int ts = (int)(System.currentTimeMillis()/1000);
        return Integer.valueOf(ts);
    }


    /**
     * md5 function
     *
     * @param source the input buffer
     * @return md5 string
     */
    private  String md5(byte[] source) throws NoSuchAlgorithmException {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        md.update(source);
        byte[] tmp = md.digest();
        char[] str = new char[32];
        int k = 0;
        for (int i = 0; i < 16; i++) {
            str[k++] = hexDigits[tmp[i] >>> 4 & 0xf];
            str[k++] = hexDigits[tmp[i] & 0xf];
        }
        return new String(str);
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
