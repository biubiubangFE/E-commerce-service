package com.mhdss.shop.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptUtil {

	/**
	 * 对输入的内容使用AES加密
	 * 
	 * @param content
	 *            要加密的内容
	 * @param password
	 *            加密的密钥
	 * @return
	 */
	public static byte[] encrypt(String content, String password) {
		try {
			// KeyGenerator提供（对称）密钥生成器的功能。使用getInstance
			KeyGenerator kgen = KeyGenerator.getInstance("AES");

			// 类方法构造密钥生成器。
			// 使用用户提供的随机源初始化此密钥生成器，使其具有确定的密钥大小
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();

			// 使用SecretKeySpec类来根据一个字节数组构造一个SecretKey,，而无须通过一个（基于provider的）SecretKeyFactory.
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

			// 创建密码器 //为创建 Cipher对象，应用程序调用 Cipher 的getInstance
			// 方法并将所请求转换的名称传递给它。还可以指定提供者的名称（可选）。
			Cipher cipher = Cipher.getInstance("AES");
			byte[] byteContent = content.getBytes("utf-8");

			// 初始化
			cipher.init(Cipher.ENCRYPT_MODE, key);

			// 按单部分操作加密或解密数据，或者结束一个多部分操作。数据将被加密或解密（具体取决于此Cipher的初始化方式）。
			byte[] result = cipher.doFinal(byteContent);
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 对输入的内容使用AES解密
	 * 
	 * @param content
	 *            要解密的内容
	 * @param password
	 *            密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 对AES过后的内容BASE64编码
	 * 
	 * @param content
	 * @param password
	 * @return
	 */
	public static String encodeBase64FromAes(String content, String password) {
		byte[] result = encrypt(content, password);
		String str = Base64.getUrlEncoder().encodeToString(result);
		return str;
	}

	/**
	 * BASE64解码后再使用AES解密
	 * 
	 * @param content
	 * @param password
	 * @return
	 */
	private static String decodeBase64FromAes(String content, String password) {
		byte[] result = Base64.getUrlDecoder().decode(content);
		result = decrypt(result, password);
		return new String(result);
	}

}
