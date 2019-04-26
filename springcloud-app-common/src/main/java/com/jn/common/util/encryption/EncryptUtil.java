package com.jn.common.util.encryption;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.MessageDigest;

/**
 * 加密工具类
 *
 * @author： yuanyy
 * @date： Created on 2019/4/24 17:42
 * @version： v1.0
 * @modified By:
 */
public class EncryptUtil {
    private static final String DEFAULT_KEY = "@#$%^6a7";
    private static final String KEY_ALGORITHM = "DES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";

    private EncryptUtil() {
    }

    public static String encryptMd5(String var0) {
        return encryptMd5(var0.getBytes());
    }

    public static String encryptMd5(byte[] var0) {
        return DigestUtils.md5Hex(var0);
    }


    public static String encryptMd5(InputStream var0) throws Exception {
        return DigestUtils.md5Hex(var0);
    }

    public static String encryptFileMd5(InputStream var0) throws IOException {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        IOUtils.copy(var0, var1);
        return encryptMd5(var1.toByteArray());
    }

    public static synchronized String encryptSha256(String var0) {
        try {
            byte[] var3 = MessageDigest.getInstance("SHA-256").digest(var0.getBytes("UTF-8"));
            return new String(Base64.encodeBase64(var3));
        } catch (Exception var2) {
            return null;
        }
    }

    public static String byte2hex(byte[] var0) {
        StringBuilder var1 = new StringBuilder();

        for(int var3 = 0; var3 < var0.length; ++var3) {
            String var2;
            if ((var2 = Integer.toHexString(var0[var3] & 255)).length() == 1) {
                var1.append("0").append(var2);
            } else {
                var1.append(var2);
            }
        }

        return var1.toString().toLowerCase();
    }

    public static String decrypt(String var0, String var1) throws Exception {
            byte[] var6 = stringToBytes(var0);
            Cipher var2 = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec var3 = new DESKeySpec(var1.getBytes("UTF-8"));
            SecretKey var8 = SecretKeyFactory.getInstance("DES").generateSecret(var3);
            IvParameterSpec var7 = new IvParameterSpec(var1.getBytes("UTF-8"));
            var2.init(2, var8, var7);
            var6 = var2.doFinal(var6);
            var0 = new String(var6, "UTF-8");
            return var0;

    }

    public static String decrypt(String var0) throws Exception{
        return decrypt(var0, "@#$%^6a7");
    }

    public static String encrypt(String var0, String var1) throws Exception {
        byte[] var6;

            Cipher var2 = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec var3 = new DESKeySpec(var1.getBytes("UTF-8"));
            SecretKey var8 = SecretKeyFactory.getInstance("DES").generateSecret(var3);
            IvParameterSpec var7 = new IvParameterSpec(var1.getBytes("UTF-8"));
            var2.init(1, var8, var7);
            var6 = var2.doFinal(var0.getBytes("UTF-8"));


        return bytesToString(var6);
    }

    public static String encrypt(String var0) throws Exception{
        return encrypt(var0, "@#$%^6a7");
    }

    public static byte[] stringToBytes(String var0) {
        byte[] var1 = new byte[var0.length() / 2];

        for(int var2 = 0; var2 < var1.length; ++var2) {
            int var3 = Integer.parseInt(var0.substring(2 * var2, 2 * var2 + 2), 16);
            var1[var2] = (byte)var3;
        }

        return var1;
    }

    public static String bytesToString(byte[] var0) {
        StringBuilder var1 = new StringBuilder();

        for(int var2 = 0; var2 < var0.length; ++var2) {
            String var3;
            if ((var3 = Integer.toHexString(255 & var0[var2])).length() < 2) {
                var3 = "0" + var3;
            }

            var1.append(var3);
        }

        return var1.toString();
    }
}
