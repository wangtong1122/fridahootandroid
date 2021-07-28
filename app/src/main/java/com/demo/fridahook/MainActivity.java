package com.demo.fridahook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText p1, p2;
    private Button b1, b2, b3;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        result = findViewById(R.id.result);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(p1.getText().toString()) & !TextUtils.isEmpty(p2.getText().toString())) {
                    int re = add(Integer.parseInt(String.valueOf(p1.getText())), Integer.parseInt(String.valueOf(p2.getText())));
                    result.setText("计算结果为：" + re);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private int add(int a, int b) {
        return a + b;
    }
//    private static int add(int a,int b){
//        return a+b;
//    }
//    private double add(double a, double b){
//        return a+b;
//    }
}