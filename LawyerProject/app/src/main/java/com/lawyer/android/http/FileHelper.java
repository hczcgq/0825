package com.lawyer.android.http;

import android.content.Context;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by hm-soft on 2015/8/27.
 */
public class FileHelper {

    private static final int DEFAULT_MAX_CONNECTIONS = 30;

    private static final int DEFAULT_SOCKET_TIMEOUT = 30 * 1000;

    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;

    private static DefaultHttpClient sHttpClient;

    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";

    private static int readTimeOut = 10 * 1000; // 读取超时
    private static int connectTimeout = 10 * 1000; // 超时时间
    private static int requestTime = 0; //请求使用多长时间
    private static final String CHARSET = "UTF-8"; // 设置编码
    private static final String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
    private static final String PREFIX = "--";
    private static final String LINE_END = "\r\n";
    private static final String CONTENT_TYPE = "multipart/form-data"; // 内容类型


    /**
     * 上传文件
     * @param context
     * @param url
     * @param map
     * @param filepath
     * @return
     */
    public static String uploadHttpClient(Context context, String url,
                                          Map<String, String> map, String filepath) {
        String result = null;
        HttpClient client = getHttpClient(context);
        HttpPost post = new HttpPost(url);
        File file = new File(filepath);
        FileBody fileBody = new FileBody(file);
        MultipartEntity entity = new MultipartEntity(
                HttpMultipartMode.BROWSER_COMPATIBLE);
        @SuppressWarnings("rawtypes")
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry items = (Map.Entry) iterator.next();
            try {
                entity.addPart((String) items.getKey(), new StringBody(
                        (String) items.getValue()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        entity.addPart("photo", fileBody);
        post.setEntity(entity);
        try {
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(),
                        DEFAULT_PARAMS_ENCODING);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ConnectTimeoutException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 设置http头信息
     *
     * @return
     */
    public static Map<String, String> getHeader() {
        Map<String, String> heads = new HashMap<String, String>();
        heads.put("Accept", "application/json, application/json");
        heads.put("Content_Type", "application/json; charset=utf-8");
        heads.put("Expect", "100-continue");
        return heads;
    }

    /**
     *
     * 创建httpClient实例
     *
     * @param context
     * @return
     */
    private static synchronized HttpClient getHttpClient(Context context) {
        final HttpParams httpParams = new BasicHttpParams();
        httpParams.setParameter(AllClientPNames.HANDLE_REDIRECTS, false);
        // 超时设置
        /* 从连接池中取连接的超时时间 */
        ConnManagerParams.setTimeout(httpParams, 1000);
        ConnManagerParams.setMaxConnectionsPerRoute(httpParams,
                new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(httpParams,
                DEFAULT_MAX_CONNECTIONS);
        // 设置组件参数, HTTP协议的版本
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(httpParams, "UTF-8");
        HttpConnectionParams.setStaleCheckingEnabled(httpParams, false);
        HttpClientParams.setRedirecting(httpParams, false);
        HttpProtocolParams.setUserAgent(httpParams, "Android client");
        /* 请求超时 */
        HttpConnectionParams.setSoTimeout(httpParams, DEFAULT_SOCKET_TIMEOUT);
        /* 连接超时 */
        HttpConnectionParams.setConnectionTimeout(httpParams,
                DEFAULT_SOCKET_TIMEOUT);
        HttpConnectionParams.setTcpNoDelay(httpParams, true);
        HttpConnectionParams.setSocketBufferSize(httpParams,
                DEFAULT_SOCKET_BUFFER_SIZE);
        // 设置我们的HttpClient支持HTTP和HTTPS两种模式
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory
                .getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", PlainSocketFactory
                .getSocketFactory(), 443));
        // 使用线程安全的连接管理来创建HttpClient
        ClientConnectionManager manager = new ThreadSafeClientConnManager(
                httpParams, schemeRegistry);
        sHttpClient = new DefaultHttpClient(manager, httpParams);
        return sHttpClient;
    }

    /**
     * 下载文件
     * @param context
     * @param url
     * @param hashParams
     * @param file
     * @return
     */
    public static String DowmloadHttpClient(Context context, String url,
                                            HashMap<String, String> hashParams, File file) {
        String result = null;
        HttpClient client = getHttpClient(context);

        if (hashParams != null) {
            for (Map.Entry<String, String> entry : hashParams.entrySet()) {
                if (!url.contains("?"))
                    url += "?" + entry.getKey() + "=" + entry.getValue();
                else
                    url += "&" + entry.getKey() + "=" + entry.getValue();
            }
        }
        url = url.replaceAll(" ", "");
        HttpGet get = new HttpGet(url);
        // 设置头文件
        Map<String, String> headers = getHeader();
        Set<String> setHead = headers.keySet();
        Iterator<String> iteratorHead = setHead.iterator();
        while (iteratorHead.hasNext()) {
            String headName = iteratorHead.next();
            String headValue = (String) headers.get(headName);
            get.setHeader(headName, headValue);
        }
        try {
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                if(!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(file);
                // 得到网络资源并写入文件
                InputStream input = response.getEntity().getContent();
                byte b[] = new byte[1024];
                int j = 0;
                while ((j = input.read(b)) != -1) {
                    fos.write(b, 0, j);
                }
                fos.flush();
                fos.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ConnectTimeoutException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 读取字符流
     * @param is
     * @return
     */
    public static String readInputStream(InputStream is) {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        try {
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
                buffer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * android上传文件到服务器
     *
     * @param filePath   需要上传的文件的路径
     * @param fileKey    在网页上<input type=file name=xxx/> xxx就是这里的fileKey
     * @param RequestURL 请求的URL
     */
    public static String uploadFile(String filePath, String fileKey, String RequestURL,
                             Map<String, String> param) {
        String result = "";
        if (filePath == null) {
            result = "文件不存在";
        }
        try {
            File file = new File(filePath);
            result = uploadFile(file, fileKey, RequestURL, param);
        } catch (Exception e) {
            result = "文件不存在";
            e.printStackTrace();
        }
        return result;
    }

    /**
     * android上传文件到服务器
     *
     * @param file       需要上传的文件
     * @param fileKey    在网页上<input type=file name=xxx/> xxx就是这里的fileKey
     * @param RequestURL 请求的URL
     */
    public static String uploadFile(final File file, final String fileKey,
                             final String RequestURL, final Map<String, String> param) {
        String result;
        if (file == null || (!file.exists())) {
            result = "文件不存在";
        }

        Log.i("---", "请求的URL=" + RequestURL);
        Log.i("---", "请求的fileName=" + file.getName());
        Log.i("---", "请求的fileKey=" + fileKey);

        result = toUploadFile(file, fileKey, RequestURL, param);
        return result;


    }

    public static String toUploadFile(File file, String fileKey, String RequestURL,
                                Map<String, String> param) {

        String result = null;
        requestTime = 0;

        long requestTime = System.currentTimeMillis();
        long responseTime = 0;

        try {
            URL url = new URL(RequestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(readTimeOut);
            conn.setConnectTimeout(connectTimeout);
            conn.setDoInput(true); // 允许输入流
            conn.setDoOutput(true); // 允许输出流
            conn.setUseCaches(false); // 不允许使用缓存
            conn.setRequestMethod("POST"); // 请求方式
            conn.setRequestProperty("Charset", CHARSET); // 设置编码
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
//          conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            /**
             * 当文件不为空，把文件包装并且上传
             */
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            StringBuffer sb = null;
            String params = "";

            /***
             * 以下是用于上传参数
             */
            if (param != null && param.size() > 0) {
                Iterator<String> it = param.keySet().iterator();
                while (it.hasNext()) {
                    sb = null;
                    sb = new StringBuffer();
                    String key = it.next();
                    String value = param.get(key);
                    sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
                    sb.append("Content-Disposition: form-data; name=\"").append(key).append("\"").append(LINE_END).append(LINE_END);
                    sb.append(value).append(LINE_END);
                    params = sb.toString();
                    Log.i("---", key + "=" + params + "##");
                    dos.write(params.getBytes());
//                  dos.flush();
                }
            }

            sb = null;
            params = null;
            sb = new StringBuffer();
            /**
             * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
             * filename是文件的名字，包含后缀名的 比如:abc.png
             */
            sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
            sb.append("Content-Disposition:form-data; name=\"" + fileKey
                    + "\"; filename=\"" + file.getName() + "\"" + LINE_END);
            sb.append("Content-Type:image/pjpeg" + LINE_END); // 这里配置的Content-type很重要的 ，用于服务器端辨别文件的类型的
            sb.append(LINE_END);
            params = sb.toString();
            sb = null;

            Log.i("---", file.getName() + "=" + params + "##");
            dos.write(params.getBytes());
            /**上传文件*/
            InputStream is = new FileInputStream(file);
//            onUploadProcessListener.initUpload((int) file.length());
            byte[] bytes = new byte[1024];
            int len = 0;
            int curLen = 0;
            while ((len = is.read(bytes)) != -1) {
                curLen += len;
                dos.write(bytes, 0, len);
//                onUploadProcessListener.onUploadProcess(curLen);
            }
            is.close();

            dos.write(LINE_END.getBytes());
            byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
            dos.write(end_data);
            dos.flush();
//
//          dos.write(tempOutputStream.toByteArray());
            /**
             * 获取响应码 200=成功 当响应成功，获取响应的流
             */
            int res = conn.getResponseCode();
            responseTime = System.currentTimeMillis();
            requestTime = (int) ((responseTime - requestTime) / 1000);
            Log.e("---", "response code:" + res);
            if (res == 200) {
                Log.e("---", "request success");
                InputStream input = conn.getInputStream();
                StringBuffer sb1 = new StringBuffer();
                int ss;
                while ((ss = input.read()) != -1) {
                    sb1.append((char) ss);
                }
                result = sb1.toString();
                Log.e("---", "result : " + result);
            } else {
                result = "上传失败！";
            }
        } catch (MalformedURLException e) {
            result = e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }
}
