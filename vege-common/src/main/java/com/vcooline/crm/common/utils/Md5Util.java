package com.vcooline.crm.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	/**
	 * @Description:md5加密
	 * @param plainText
	 *            要加密的明文
	 * @return String 加密后的秘文
	 * @throws
	 * @author caohuan
	 * @date 2015年7月3日 上午10:19:37 上海微客来软件技术有限公司
	 */
	public static String Md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// System.out.println("result: " + buf.toString());//32位的加密
			// System.out.println("result: " +
			// buf.toString().substring(8,24));//16位的加密
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.getMessage();
		}
		return null;
	}
}
