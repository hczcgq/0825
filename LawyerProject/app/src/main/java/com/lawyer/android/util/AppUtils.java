package com.lawyer.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by hm-soft on 2015/8/27.
 */
public class AppUtils {

    public static String getAppName(Context context) {
        String appName = context.getPackageManager()
                .getApplicationLabel(context.getApplicationInfo()).toString();
        return appName;
    }


    public static String getVersionName(Context context) {
        String currentVersionName = null;
        PackageManager pkgManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = pkgManager.getPackageInfo(
                    context.getPackageName(), 0);
            currentVersionName = packageInfo.versionName + "";
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return currentVersionName;
    }
}
