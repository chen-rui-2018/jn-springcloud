package com.jn.common.util.encryption;


import java.util.regex.Pattern;

/**
 * 根据密码规则校验密码
 *
 * @author： yuanyy
 * @date： Created on 2019/6/29 17:34
 * @version： v1.0
 * @modified By:
 */
public class CustomValidUtil {
    public static Pattern NUM=Pattern.compile(".*[0-9].*");
    public static Pattern LOWERCASE=Pattern.compile(".*[a-z]+.*");
    public static Pattern CAPITAL=Pattern.compile(".*[A-Z]+.*");
    public static String SPECIAL = "^.*[(/) | (\\\\) | (:) | (\\*) | (\\?) | (\\.) | (\\%) | (\\@) | (\\&) | (\") | (<) | (>)].*$";


    public  static boolean valid(String validStr,String isUseComp,int minLength,int maxLength,String complexity){
        boolean flag=true;
        //只判断长度
        if(minLength>=validStr.length()||validStr.length()>=maxLength){
            return false;
        }
        if("Y".equals(isUseComp)){
            if(complexity.contains("1")&&!LOWERCASE.matcher(validStr).matches()){
                //必须包含小写字母;
                return false;
            }
            if(complexity.contains("2")&&!CAPITAL.matcher(validStr).matches()){
                //必须包含大写字母;
                return false;
            }
            if(complexity.contains("3")&&!NUM.matcher(validStr).matches()){
                //必须包含数字;
                return false;
            }
            if(complexity.contains("4")&&!validStr.matches(SPECIAL)){
               // 必须包含（^%&@*?!$）特殊字符;
                return false;
            }

        }
        return flag;
    }
    public static void main(String args[]) throws Exception {
        //{"state":200,"message":"格式：最大长度20;最小长度6;必须包含小写字母;必须包含数字;","cause":"","variables":{},"data":{"pk":"","id":"593455186756763648","isUseComp":"Y","complexity":"1,3","minLength":6,"maxLength":20,"updTlimit":180,"timeLimit":1,"isDefault":"Y"}}'
       String isUseComp="Y";
       int minLength=1;
       int maxLength=12;
       String complexity="1,3,4";
       String validStr="a123456&";
       System.out.println(CustomValidUtil.valid(validStr, isUseComp,minLength,maxLength,complexity));

    }
}
