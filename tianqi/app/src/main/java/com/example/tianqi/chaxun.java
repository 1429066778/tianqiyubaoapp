package com.example.tianqi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Thread.sleep;

public class chaxun extends AppCompatActivity {
public static  String CCC="CCC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaxun);
        Button btn = (Button)findViewById(R.id.buttotn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText city = (EditText)findViewById(R.id.editText);
                CCC=city.getText().toString();
                getinfo weatherinfo = new getinfo();
                String info = weatherinfo.LoginByPost();


                    Intent zhuce = new Intent(chaxun.this, MainActivity.class);
                    startActivity(zhuce);
                    //CCC="CCC";
                    finish();

            }
        });

    }
}
