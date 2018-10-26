package com.hlhlo.hlhlocloudframeworkwx.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CheckUtil {
	private static final String token ="lunmei";
	public static boolean checkSignature(String signature,String timestamp,String nonce) throws NoSuchAlgorithmException{
		String[] arr = new String[]{token,timestamp,nonce};
		
		//加密/校验流程如下：
		//1. 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);
		//2. 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		//sha1加密
		String temp = getSha1(sb.toString());
		
		//3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		return temp.equals(signature);
	}
	//下面四个import放在类名前面 包名后面
	//import java.io.UnsupportedEncodingException;
	//import java.security.MessageDigest;
	//import java.security.NoSuchAlgorithmException;
	//import java.util.Arrays;
	 
	public static String getSha1(String str){
	    if (null == str || 0 == str.length()){
	        return null;
	    }
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	            'a', 'b', 'c', 'd', 'e', 'f'};
	    try {
	        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	        mdTemp.update(str.getBytes("UTF-8"));
	         
	        byte[] md = mdTemp.digest();
	        int j = md.length;
	        char[] buf = new char[j * 2];
	        int k = 0;
	        for (int i = 0; i < j; i++) {
	            byte byte0 = md[i];
	            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	            buf[k++] = hexDigits[byte0 & 0xf];
	        }
	        return new String(buf);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    return str;
	}
	
	
}
