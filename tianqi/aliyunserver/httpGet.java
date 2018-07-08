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
	                    // �½�һ��URL����
	                    URL url = new URL(requestUrl);
	                    // ��һ��HttpURLConnection����
	                    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	                    // ��������������ʱʱ��
	                    urlConn.setConnectTimeout(5 * 1000);
	                    //���ô�������ȡ���ݳ�ʱ
	                    urlConn.setReadTimeout(5 * 1000);
	                    // �����Ƿ�ʹ�û���  Ĭ����true
	                    urlConn.setUseCaches(true);
	                    // ����ΪPost����
	                    urlConn.setRequestMethod("GET");
	                    //urlConn��������ͷ��Ϣ
	                    //���������е�ý��������Ϣ��
	                    urlConn.setRequestProperty("Content-Type", "application/json");
	                    //���ÿͻ����������������
	                    urlConn.addRequestProperty("Connection", "Keep-Alive");
	                
	                    // ��ʼ����
	                    urlConn.connect();
	                    // �ж������Ƿ�ɹ�
	                    if (urlConn.getResponseCode() == 200) {
	                        // ��ȡ���ص�����
	                        //����Ի�ȡ�������������ж�
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
	                        // �����������صĽ����ŵ�Message��
	                       result = response.toString();*/
	                        
	                    } else {
	                      
	                    }
	                    // �ر�����
	                   urlConn.disconnect();
	        return result;
	    }
}