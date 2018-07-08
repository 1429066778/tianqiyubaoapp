package utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import net.sf.json.JSONArray;
 
public class httpGet {
	
	    public static String result = null;
	    public  static String meessage = null;
	    public static String LoginByPost(final String city) throws IOException
	    {
	                	//String LOGIN_URL = "http://v.juhe.cn/weather/index?cityname="+city+"&key=***a7558b2e0bedaa19673f74a6809ce";
	                    String baseUrl = "https://xxx.com/getUsers?";
	                    StringBuilder tempParams = new StringBuilder();
	                    int pos = 0;
	                    String requestUrl = "http://v.juhe.cn/weather/index?cityname="+city+"&key=fca2c31ad078f660fb9588bde81d5569";
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
	                        //下面对获取到的输入流进行读
	                    	InputStream is = urlConn.getInputStream();
	                        String charset = "UTF-8";
	                        Pattern pattern = Pattern.compile("charset=\\S*");
	                        Matcher matcher = pattern.matcher(urlConn.getContentType());
	                        if (matcher.find()) {
	                            charset = matcher.group().replace("charset=", "");
	                        }
	                        BufferedReader reader = new BufferedReader(new InputStreamReader(is, charset));
	         
	                        StringBuilder sb = new StringBuilder();
	                        String line;
	                        while ((line = reader.readLine()) != null) {
	                            sb.append(line + "\n");
	                        }
	                        is.close();
	                        result = sb.toString();

	                     /*BufferedReader  reader = new BufferedReader(new
	                                InputStreamReader(urlConn.getInputStream()));
	                        
	                        
	                        StringBuilder response = new StringBuilder();
	                        String line;
	                        while ((line = reader.readLine()) != null) {
	                            response.append(line);
	                        }
	                        // 将服务器返回的结果存放到Message中
	                       result = response.toString();*/
	                        
	                    } else {
	                      
	                    }
	                    // 关闭连接
	                   urlConn.disconnect();
	        return result;
	    }
}