package com.lawyer.android.util;

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
}
