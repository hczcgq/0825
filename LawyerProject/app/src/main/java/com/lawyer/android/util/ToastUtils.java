package com.lawyer.android.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast消息提示统一管理类
 * 
 * @author 陈国权
 *
 */
public class ToastUtils {

    /**
     * 短消息
     * @param context
     * @param message
     */
    public static void showToastShort(Context context,String message) {
        Toast toast = Toast.makeText(context, message,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showToastShort(Context context,int message) {
        Toast toast = Toast.makeText(context, message,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    
    /**
     * 长消息
     * @param context
     * @param message
     */
    public static void showToastLong(Context context,String message) {
        Toast toast = Toast.makeText(context, message,
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showToastLong(Context context,int message) {
        Toast toast = Toast.makeText(context, message,
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
