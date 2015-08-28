package com.lawyer.android.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hm-soft on 2015/8/27.
 */
public class StringUtils {
    /**
     * 判断指定的字符串是否为null
     *
     * @param str  指定的字符串
     * @return 结果
     */
    public static boolean isEmpty(String str) {
        if(str==null||str.trim().equals("")||str.trim().equals("null")|| str.length() == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 获取当前时间－毫秒
     * @return
     */
    public static String getCurrentTimes(){
        return String.valueOf(System.currentTimeMillis());
    }


    /**
     * SHA1加密
     * @param str 加密字符串
     * @return
     */
    public static String getSHA1(String str) {
        MessageDigest md = null;
        StringBuffer sb=null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes("UTF-8"));
            byte[] result = md.digest();
            sb = new StringBuffer();
            for (byte b : result) {
                int i = b & 0xff;
                if (i < 0xf) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString().toUpperCase();
    }

}
