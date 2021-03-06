package org.marketing.util;

import java.security.MessageDigest;

public class MD5Util {
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
	    "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public static String byteArrayToHexString(byte[] b) {
	StringBuffer resultSb = new StringBuffer();
	for (int i = 0; i < b.length; i++) {
	    resultSb.append(byteToHexString(b[i]));
	}
	return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
	int n = b;
	if (n < 0)
	    n = 256 + n;
	int d1 = n / 16;
	int d2 = n % 16;
	return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 
     * 方法名称：MD5Encode 方法描述：传入字符串返回MD5 创建人：孙良涛 创建时间：2014-3-24 上午9:49:50 修改人：
     * 修改时间： 修改备注：
     */
    public static String MD5Encode(String origin) {
	String resultString = null;

	try {
	    resultString = new String(origin);
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    resultString = byteArrayToHexString(md.digest(resultString
		    .getBytes()));
	} catch (Exception ex) {

	}
	return resultString;
    }
}
