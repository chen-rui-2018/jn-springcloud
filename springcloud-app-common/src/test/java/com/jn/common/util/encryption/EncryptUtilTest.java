package com.jn.common.util.encryption;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author： shenph
 * @date： Created on 2019/6/5 16:12
 * @version： v1.0
 * @modified By:
 */
public class EncryptUtilTest {

    @Test
    public void test1(){
        System.out.println(EncryptUtil.encryptSha256("wangsong"));
    }

}