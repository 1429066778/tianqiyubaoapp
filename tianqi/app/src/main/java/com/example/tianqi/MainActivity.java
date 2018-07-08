package com.example.tianqi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;

import static java.lang.Thread.sleep;
public class MainActivity extends Activity {
    public static String infow="";
    public  static String cityy="local";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ImageView imageview = (ImageView) findViewById(R.id.iv_now_cond_code);
        TextView citys = (TextView)findViewById(R.id.citys);
        TextView now_temp = (TextView)findViewById(R.id.now_temp);
        TextView now_weather= (TextView)findViewById(R.id.weather);
        TextView now_hum = (TextView)findViewById(R.id.now_hum);
        TextView now_wind = (TextView)findViewById(R.id.fengxiang);
        TextView now_wind_f=(TextView)findViewById(R.id.fengsu);
        TextView feel = (TextView)findViewById(R.id.feel);
        TextView advice = (TextView)findViewById(R.id.advice);
        TextView sport = (TextView)findViewById(R.id.sport);
        TextView cv_index = (TextView)findViewById(R.id.cv_index);
        TextView travell = (TextView)findViewById(R.id.travell);
        TextView kongqi = (TextView)findViewById(R.id.kongqi);
        TextView now_time = (TextView)findViewById(R.id.time);
        TextView DIERTIAN = (TextView)findViewById(R.id.diertian);
        TextView DISANTIAN = (TextView)findViewById(R.id.disantian);
        TextView DISITIAN = (TextView)findViewById(R.id.disitian);
        TextView DIWUTIAN = (TextView)findViewById(R.id.diwutian);
        TextView DILIUTIAN = (TextView)findViewById(R.id.diliutian);
        TextView DIQITIAN = (TextView)findViewById(R.id.diqitian);
        Button button = (Button)findViewById(R.id.button);
        getinfo weatherinfo = new getinfo();
        String info = weatherinfo.LoginByPost();
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent zhuce = new Intent(MainActivity.this, chaxun.class);
                startActivity(zhuce);

            }
        });
        try {
            sleep(1000); // 线程休眠1秒，等待网络回传数据同步完成
            JSONObject Result = null;
            try {
                Result = new JSONObject(infow).getJSONObject("result");
                String sk = Result.getString("sk");
                String today = Result.getString("today");
                String future = Result.getString("future");
                //解析当前天气信息
                JSONObject SK = new JSONObject("{\"sk\":"+sk+"}").getJSONObject("sk"); //截取后的sk不符合json对象格式，所以"{\"sk\":"+sk+"}"手动拼接成json对象的格式，下同
                String sk_temp = SK.getString("temp");
                String sk_wind_direction = SK.getString("wind_direction");
                String sk_wind_strength = SK.getString("wind_strength");
                String sk_humidity = SK.getString("humidity");
                String sk_time = SK.getString("time");
                Log.e("当前时间-->",sk_time);
                Log.e("当前温度-->",sk_temp);
                Log.e("当前湿度-->",sk_humidity);
                Log.e("当前风向-->",sk_wind_direction);
                Log.e("当前风俗-->",sk_wind_strength);
                //解析当天的天气信息
                JSONObject TODAY = new JSONObject("{\"today\":"+today+"}").getJSONObject("today");
                String temperature = TODAY.getString("temperature");
                String weather = TODAY.getString("weather");
                String wind = TODAY.getString("wind");
                String week = TODAY.getString("week");
                String city =TODAY.getString("city");
                String date_y = TODAY.getString("date_y");
                String dressing_index = TODAY.getString("dressing_index");
                String  dressing_advice= TODAY.getString("dressing_advice");
                String uv_index = TODAY.getString("uv_index");
                String comfort_index = TODAY.getString("comfort_index");
                String  wash_index= TODAY.getString("wash_index");
                String  travel_index= TODAY.getString("travel_index");
                String  exercise_index= TODAY.getString("exercise_index");
                String  drying_index= TODAY.getString("drying_index");
                String weather_id = TODAY.getString("weather_id");
                JSONObject WID = new JSONObject("{\"weather_id\":"+weather_id+"}").getJSONObject("weather_id");
                String  fa = WID.getString("fa");
                Log.e("fa--》",fa);
                Log.e("当天温度-->",temperature);
                Log.e("当天天气-->",weather);
                Log.e("当天日期-->",date_y);
                Log.e("星期几-->",week);
                Log.e("当天风向-->",wind);
                Log.e("城市-->",city);
                Log.e("体表感觉-->",dressing_index);
                Log.e("建议",dressing_advice);
                Log.e("紫外线-->",uv_index);
                Log.e("洗衣-->",wash_index);
                Log.e("出行-->",travel_index);
                Log.e("运动-->",exercise_index);
                Log.e("干燥-->",drying_index);
                int j=0;
                //从json字符串中截取未来几天的日期字符串
                String future_one="";
                String future_two="";
                String future_three="";
                String future_four="";
                String future_five="";
                String future_six="";
                String future_senven="";
                for (int i =0 ;i<future.length();i++) {
                    if (future.charAt(i) == '{') {
                        if (j==0){//第一次出现‘{’的位置往后第二到第十四的字符串为未来第一天的key，根据日期改变的所以手动截取
                            future_one = future.substring(i + 2, i+ 14);
                        }
                        if (j==3){//第4次出现‘{’的位置往前第二到第十四的字符串为未来第2天的key，根据日期改变的所以手动截取
                            future_two = future.substring(i - 14, i - 2);
                        }
                        if (j==5){//第6次出现‘{’的位置往前第二到第十四的字符串为未来第3天的key，根据日期改变的所以手动截取
                            future_three = future.substring(i - 14, i- 2);
                        }
                        if (j==7){//第8次出现‘{’的位置往前第二到第十四的字符串为未来第4天的key，根据日期改变的所以手动截取
                            future_four = future.substring(i - 14, i- 2);
                        }
                        if (j==9){//第10次出现‘{’的位置往前第二到第十四的字符串为未来第5天的key，根据日期改变的所以手动截取
                            future_five = future.substring(i - 14, i- 2);
                        }
                        if (j==11){//第12次出现‘{’的位置往前第二到第十四的字符串为未来第6天的key，根据日期改变的所以手动截取
                            future_six = future.substring(i - 14, i- 2);
                        }
                        if (j==13){////第14次出现‘{’的位置往前第二到第十四的字符串为未来第7天的key，根据日期改变的所以手动截取
                            future_senven = future.substring(i - 14, i- 2);
                            break;
                        }
                        j++;
                    }
                }
                //解析未来的天气
                JSONObject FUTURE = new JSONObject("{\"future\":"+future+"}").getJSONObject("future");
                String Future_one = FUTURE.getString(future_one);
                String Future_two = FUTURE.getString(future_two);
                String Future_three = FUTURE.getString(future_three);
                String Future_four = FUTURE.getString(future_four);
                String Future_five = FUTURE.getString(future_five);
                String Future_six = FUTURE.getString(future_six);
                String Future_senven = FUTURE.getString(future_senven);
                JSONObject DAY_ONE = new JSONObject("{\""+future_one+"\":"+Future_one+"}").getJSONObject(future_one);
                String day_one_temperature = DAY_ONE.getString("temperature");
                //解析第2天
                JSONObject DAY_TWO = new JSONObject("{\""+future_two+"\":"+Future_two+"}").getJSONObject(future_two);
                String day_two_temperature = DAY_TWO.getString("temperature");
                String day_two_weather = DAY_TWO.getString("weather");
                String  day_two_wind = DAY_TWO.getString("wind");
                String day_two_week = DAY_TWO.getString("week");
                String day_two_date = DAY_TWO.getString("date");
                //解析第3天
                JSONObject DAY_THREE = new JSONObject("{\""+future_three+"\":"+Future_three+"}").getJSONObject(future_three);
                String day_three_temperature = DAY_THREE.getString("temperature");
                String day_three_weather = DAY_THREE.getString("weather");
                String  day_three_wind = DAY_THREE.getString("wind");
                String day_three_week = DAY_THREE.getString("week");
                String day_three_date = DAY_THREE.getString("date");
                //解析第4天
                JSONObject DAY_FOUR = new JSONObject("{\""+future_four+"\":"+Future_four+"}").getJSONObject(future_four);
                String day_four_temperature = DAY_FOUR.getString("temperature");
                String day_four_weather = DAY_FOUR.getString("weather");
                String  day_four_wind = DAY_FOUR.getString("wind");
                String day_four_week = DAY_FOUR.getString("week");
                String day_four_date = DAY_FOUR.getString("date");
                //解析第5天
                JSONObject DAY_FIVE = new JSONObject("{\""+future_five+"\":"+Future_five+"}").getJSONObject(future_five);
                String day_five_temperature = DAY_FIVE.getString("temperature");
                String day_five_weather = DAY_FIVE.getString("weather");
                String  day_five_wind = DAY_FIVE.getString("wind");
                String day_five_week = DAY_FIVE.getString("week");
                String day_five_date = DAY_FIVE.getString("date");
                //解析第6天
                JSONObject DAY_SIX = new JSONObject("{\""+future_six+"\":"+Future_six+"}").getJSONObject(future_six);
                String day_six_temperature = DAY_SIX.getString("temperature");
                String day_six_weather = DAY_SIX.getString("weather");
                String  day_six_wind = DAY_SIX.getString("wind");
                String day_six_week = DAY_SIX.getString("week");
                String day_six_date = DAY_SIX.getString("date");
                //解析第7天
                JSONObject DAY_SENVEN = new JSONObject("{\""+future_senven+"\":"+Future_senven+"}").getJSONObject(future_senven);
                String day_senven_temperature = DAY_SENVEN.getString("temperature");
                String day_senven_weather = DAY_SENVEN.getString("weather");
                String  day_senven_wind = DAY_SENVEN.getString("wind");
                String day_senven_week = DAY_SENVEN.getString("week");
                String day_senven_date = DAY_SENVEN.getString("date");
                Log.e("未来第二天天的天气状况-->","  温度："+day_two_temperature+"  天气："+day_two_weather+"  风："+day_two_wind+"  星期几："+day_two_week+"  日期："+day_two_date);
               /* Calendar mCalendar=Calendar.getInstance();
                mCalendar.setTimeInMillis(time);
                int mHour=mCalendar.get(Calendar.HOUR);
                int mMinuts=mCalendar.get(Calendar.MINUTE);*/
                int id=getDrawableIdByCode(fa);
                imageview.setImageResource(id);

                citys.setText(city+" ");
                now_temp.setText(sk_temp+"°c\t");
                now_weather.setText(weather+"\t");
                now_hum.setText("湿度:"+sk_humidity+"\t");
                now_wind.setText("风向:"+sk_wind_direction+"\t\t");
                now_wind_f.setText("等级:"+sk_wind_strength);
                advice.setText(" "+dressing_advice+"\n");
                sport.setText(" "+exercise_index+"\n");
                travell.setText(" "+travel_index+"\n");
                cv_index.setText(" "+uv_index+"\n");
                feel.setText(" "+dressing_index+"\n");
                now_time.setText("温度："+day_one_temperature+"\n");
                kongqi.setText(" 良"+"\n");
                String bu="";
                bu=kongge(day_two_weather);
                DIERTIAN.setText(day_two_week+"    "+day_two_weather+bu+"  "+day_two_temperature+"    "+day_two_wind+"\n");
                bu=kongge(day_three_weather);
                DISANTIAN.setText(day_three_week+"    "+day_three_weather+bu+"  "+day_three_temperature+"    "+day_three_wind+"\n");
                bu=kongge(day_four_weather);
                DISITIAN.setText(day_four_week+"    "+day_four_weather+bu+"  "+day_four_temperature+"    "+day_four_wind+"\n");
                bu=kongge(day_five_weather);
                DIWUTIAN.setText(day_five_week+"    "+day_five_weather+bu+"  "+day_five_temperature+"    "+day_five_wind+"\n");
                bu=kongge(day_six_weather);
                DILIUTIAN.setText(day_six_week+"    "+day_six_weather+bu+"  "+day_six_temperature+"    "+day_six_wind+"\n");
                bu=kongge(day_senven_weather);
                DIQITIAN.setText(day_senven_week+"    "+day_senven_weather+bu+"  "+day_senven_temperature+"    "+day_senven_wind+"\n");
                chaxun.CCC="CCC";
            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, "请连接网络或者输入正确的城市！", Toast.LENGTH_SHORT).show();
                Intent zhuce = new Intent(MainActivity.this, chaxun.class);
                startActivity(zhuce);
                finish();
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static int getDrawableIdByCode(String code) {
        int i = Integer.parseInt(code);
        int id = 0;
        Class clazz = R.drawable.class;
        try {
            Field field = clazz.getField("b_" + code);
            id = field.getInt(field);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public String kongge(String a){
        String bu="";
        if(a.length()==1)
            bu="                  ";
        if(a.length()==2)
            bu="              ";
        if(a.length()==3)
            bu="          ";
        if(a.length()==4)
            bu="      ";
        if(a.length()==5)
            bu="  ";
        return bu;
    }
}