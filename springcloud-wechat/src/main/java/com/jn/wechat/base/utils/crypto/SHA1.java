package com.jn.wechat.base.utils.crypto;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * 生成sha1 digest
 *
 * @Author： cm
 * @Date： Created on 2019/1/3 10:18
 * @Version： v1.0
 * @Modified By:
 */
public class SHA1 {

    /**
     * 串接arr参数，生成sha1 digest
     */
    public static String gen(String... arr) {
        if (isAnyEmpty(arr)) {
            throw new IllegalArgumentException("非法请求参数，有部分参数为空 : " + Arrays.toString(arr));
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String a : arr) {
            sb.append(a);
        }
        return DigestUtils.sha1Hex(sb.toString());
    }


    public static boolean isAnyEmpty(final CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return false;
        }
        for (final CharSequence cs : css){
            if (isEmpty(cs)) {
                return true;
            }
        }
        return false;
    }

}
