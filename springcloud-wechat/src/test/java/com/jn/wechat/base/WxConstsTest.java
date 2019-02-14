package com.jn.wechat.base;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WxConstsTest {

    @Test
    @Ignore
    public void test() {
        Field[] fields = WxConsts.XmlMsgType.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if(field.getType().toString().endsWith("java.lang.String") && Modifier.isStatic(field.getModifiers()))
                    System.out.println(field.getName() + " , " + field.get(WxConsts.XmlMsgType.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}