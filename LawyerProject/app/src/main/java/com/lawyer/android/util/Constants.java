package com.lawyer.android.util;

import android.os.Environment;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class Constants {

    public static final String ISFIRST="ISFIRST";  //是否第一次登录

    public static final String APP_KEY="ios01";

    public static final String APP_SECRET="fdsh4vrFDSvjfds94";

    public static final String PRE_MOBILE="PRE_MOBILE";  //用户名

    public static final String PRE_PASSWORD="PRE_PASSWORD";  //密码

    public static final String PRE_LAWYERID="PRE_LAWYERID"; //律师ID

    public static final String PRE_MAC="PER_MAC"; //信息校验

    public static final int WHEEL_SEX=10;
    public static final int WHEEL_EDU=11;



    public static final int TAKE_PHOTO=100;
    public static final int TAKE_ALBUM=101;

    // 拍照地址
    public static final String TAKE_PHOTO_PATH = Environment
            .getExternalStorageDirectory() + "/DCIM/Camera/";
    // 发送图片地址
    public static final String SEND_IMAGE_PATH = Environment
            .getExternalStorageDirectory()
            + "/lawyer/avater/";
}
