package com.lawyer.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    /**
     * 获取年月日
     *
     * @return
     */
    public static String getSimpleDate() {
        Calendar c = Calendar.getInstance();
        int m_year = c.get(Calendar.YEAR); // 获得年份
        int m_month = c.get(Calendar.MONTH); // 获得月份
        int m_day = c.get(Calendar.DAY_OF_MONTH);// 获得天
        String data = m_year + "-" + (m_month + 1) + "-" + m_day;
        return data;
    }

    /**
     * 将date long型转换成字符串型，如20140910105934
     *
     * @param date
     * @return
     */
    public static String formatLongToDate(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:dd");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        java.util.Date dt = new Date(date);
        String sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006 21:08:00
        return sDateTime;
    }
    public static String formatValidLongToDate(long date,int index) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        java.util.Date dt = new Date(date);
        dt.setYear(dt.getYear()+index);
        String sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006 21:08:00
        return sDateTime;
    }


    /**
     * 将date字符串型型转换成long
     *
     * @param date
     * @return
     */
    public static long formatDateToLong(String date) {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dt2 = null;
        try {
            dt2 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //继续转换得到秒数的long型
        return  dt2.getTime() / 1000;
    }
}
