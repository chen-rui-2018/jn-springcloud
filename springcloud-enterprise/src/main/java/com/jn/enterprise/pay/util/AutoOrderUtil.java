package com.jn.enterprise.pay.util;

import jdk.internal.dynalink.beans.StaticClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 生成流水号工具类
 *
 * @author： wzy
 * @date： Created on 2019/6/6 14:29
 * @version： v1.0
 * @modified By:
 */
public class AutoOrderUtil {

    /**
     * 生成唯一编号  时间戳+5位整数
     * @return
     */
    public static String autoOrderId(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        Date orderId = null;
        Random rand = new Random();
        //[900]：900个    100：从100
        int x = rand.nextInt(90000) + 100;
        try {
            orderId = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(orderId.getTime()) + x;
    }
}
