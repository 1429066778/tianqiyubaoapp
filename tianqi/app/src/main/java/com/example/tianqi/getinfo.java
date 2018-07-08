package com.example.tianqi;

/**
 * Created by 田培贤 on 2018/7/4.
 */
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

public class getinfo {
    public static String LOGIN_URL = "http://47.95.114.213:8080/YIJIAIOT_WEB/localcity"; //后台地址，后台会解析访问者的IP地址所在的城市，然后调用聚合天气API获取天气信息回传回来。
    public static String result = null;
    public  static String meessage = null;
    public static String LoginByPost()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String requestUrl="";
                try {
                    String baseUrl = "https://xxx.com/getUsers?";
                    StringBuilder tempParams = new StringBuilder();
                    int pos = 0;
                    if (chaxun.CCC!="CCC")
                    {
                        requestUrl = LOGIN_URL + "?city=" + chaxun.CCC;
                    }else {
                        requestUrl = LOGIN_URL + "?city=" + MainActivity.cityy;
                    }
                    Log.d("url:",requestUrl);
                    // 新建一个URL对象
                    URL url = new URL(requestUrl);
                    // 打开一个HttpURLConnection连接
                    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                    // 设置连接主机超时时间
                    urlConn.setConnectTimeout(5 * 1000);
                    //设置从主机读取数据超时
                    urlConn.setReadTimeout(5 * 1000);
                    // 设置是否使用缓存  默认是true
                    urlConn.setUseCaches(true);
                    // 设置为Post请求
                    urlConn.setRequestMethod("GET");
                    //urlConn设置请求头信息
                    //设置请求中的媒体类型信息。
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    //设置客户端与服务连接类型
                    urlConn.addRequestProperty("Connection", "Keep-Alive");
                    // 开始连接
                    urlConn.connect();
                    // 判断请求是否成功
                    if (urlConn.getResponseCode() == 200) {
                        // 获取返回的数据
                        //下面对获取到的输入流进行读取
                        BufferedReader  reader = new BufferedReader(new
                                InputStreamReader(urlConn.getInputStream()));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        // 将服务器返回的结果存放到Message中
                         result = response.toString();
                        MainActivity.infow=result;
                    } else {
                        Log.e("result", "Get方式请求失败");
                    }
                    // 关闭连接
                    urlConn.disconnect();
                } catch (Exception e) {
                    Log.e("catch", e.toString());
                }
            }
        }).start();
        return result;
    }
}
