package com.lawyer.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hm-soft on 2015/8/27.
 */
public class NetworkUtils {

    /**
     * 检查网络是否存在
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        boolean value = false;
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            value = true;
        }
        return value;
    }

    /**
     * 监测网络是否存在wifi状态
     *
     * @param context
     * @return
     */
    public static boolean isNetworkWifi(Context context) {
        boolean flag = false;
        ConnectivityManager cwjManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cwjManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()
                .name().equals("CONNECTED")) {
            flag = true;
        }
        return flag;
    }


}
