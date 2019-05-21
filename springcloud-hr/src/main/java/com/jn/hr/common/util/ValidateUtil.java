package com.jn.hr.common.util;

import com.jn.common.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @author dt
 * @create 2019-04-16 下午 12:48
 */
public class ValidateUtil {

    public static boolean isMobile(String phoneNumber){
        if(StringUtils.isBlank(phoneNumber)){
            return false;
        }
        String regexp="^1[34578]\\d{9}$";
        return Pattern.compile(regexp).matcher(phoneNumber).matches();
    }
    public static boolean isEmail(String email){
        if(StringUtils.isBlank(email)){
            return false;
        }
        String regexp="^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
        return Pattern.compile(regexp).matcher(email).matches();
    }

    public static boolean isQQ(String qq){
        if(StringUtils.isBlank(qq)){
            return false;
        }
        String regexp="^[1-9][0-9]{4,14}$";
        return Pattern.compile(regexp).matcher(qq).matches();
    }
}
