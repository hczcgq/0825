package com.lawyer.android.http;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by hm-soft on 2015/8/27.
 */
public class httpUtils {

    /**
     * 生成签名
     *
     * @param params    请求参数
     * @param appSecret 加密字符串
     * @return
     */
    public static String sign(Map<String, String> params, String appSecret) {
        String[] arr = params.keySet().toArray(new String[]{});
        // 将参数做字母序排序
        Arrays.sort(arr);
        // 参数拼接
        StringBuilder pa = new StringBuilder(100);
        for (String name : arr) {
            if (params.containsKey(name)) {
                pa.append(name).append(params.get(name));
            }
        }
        // 字符串末尾添加appSecret
        pa.append(appSecret);
        try {
            byte[] sha1Digest = getSHA1Digest(pa.toString());
            String sign = byte2hex(sha1Digest);
            return sign;
        } catch (IOException e) {
        }
        return null;
    }

    public static byte[] getSHA1Digest(String data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            bytes = md.digest(data.getBytes("UTF-8"));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.getMessage());
        }
        return bytes;
    }

    /**
     * 二进制转十六进制字符串
     *
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }


    /**
     * SHA1加密的二进制转十六进制字符串
     * @param str
     * @return
     */
    public static String hexSHA1(String str) {
        String hexsha1 = null;
        try {
            hexsha1 = byte2hex(getSHA1Digest(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hexsha1;
    }
}
