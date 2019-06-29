package com.jn.common.util.encryption;

import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
	public static final String DEFAULT_KEY = "123!@#avrd59aNJA";
	private static final String ADD = "/add/";

	/**
	 * 加密
	 * @param str
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String str, String key)  {
		if (StringUtils.isBlank(str)||StringUtils.isBlank(key)){
			return null;
		}
		String result;
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE,
					new SecretKeySpec(key.getBytes("utf-8"), "AES"));
			byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
			//+加号替换成/and/，避免url传递后丢失或者转变成空格。
			result =  new BASE64Encoder().encode(bytes).replaceAll("\r\n", "").replaceAll("\\+", ADD);
		}catch (Exception e){
			throw new JnSpringCloudException(CommonExceptionEnum.ENCRYPT_FAIL);
		}


		return result;
	}

	/**
	 * 解密
	 * @param str
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String str, String key) {
		if (StringUtils.isBlank(str)||StringUtils.isBlank(key)){
			return null;
		}
		byte[] bytes;
		try {
			//把/and/还原成+加号
			str = str.replaceAll(ADD, "+");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE,
					new SecretKeySpec(key.getBytes("utf-8"), "AES"));
			bytes = new BASE64Decoder().decodeBuffer(str);
			bytes = cipher.doFinal(bytes);
		}catch (Exception e){
			throw new JnSpringCloudException(CommonExceptionEnum.DECRYPT_FAIL);
		}
		return new String(bytes, "utf-8");
	}

	public static void main(String args[]) throws Exception {
		//密文（加密） req=R8ck6sMWWCgjCZPdpK/add/8Pw==
		//明文（解密） req=123456
		String key = DEFAULT_KEY;
		String str="123456";
		str =AESUtil.encrypt(str,key);
		System.out.println("密文（加密） req=" + str);
		System.out.println("明文（解密） req=" + AESUtil.decrypt(str, key));
	}

}
