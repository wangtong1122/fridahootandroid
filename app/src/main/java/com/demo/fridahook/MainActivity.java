package com.demo.fridahook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.HookCla1;
import com.demo.HoolActiity;

import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {
    private EditText p1,p2;
    private Button b1,b2,b3;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1= findViewById(R.id.p1);
        p2= findViewById(R.id.p2);
        b1= findViewById(R.id.b1);
        b2= findViewById(R.id.b2);
        b3= findViewById(R.id.b3);
        result = findViewById(R.id.result);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                test();
                HoolActiity a = new HoolActiity();
                a.ttt();
                if (!TextUtils.isEmpty(p1.getText().toString()) & !TextUtils.isEmpty(p2.getText().toString())){
                   int re=add(Integer.parseInt(String.valueOf(p1.getText())),Integer.parseInt(String.valueOf(p2.getText())));
                    result.setText("计算结果为："+re);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoolActiity a = new HoolActiity();
                a.ttt();
                HookCla2 cla2 = new HookCla2();
                cla2.add(11,11);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkInterface ni = null;
                try {
                    Enumeration<NetworkInterface> networks=NetworkInterface.getNetworkInterfaces ();
                    String name ;
                    while(networks != null && networks.hasMoreElements()){
                        ni = networks.nextElement();
                        if (!ni.isUp()){
                            continue;
                        }
                        name = ni.getName();
                        if (name != null && name.startsWith("wlan")){
                            break;
                        }
                    }
                    if (ni == null){
                        ni= NetworkInterface.getByName("wlan0");
                    }
                    if(ni!=null){
                        byte[] hw = (byte[]) callDeclaredMethod(ni, "getHardwareAddress", null, null);
                        //					ni.getHardwareAddress();
                        StringBuilder sb = new StringBuilder();
                        if (hw != null) {
                            int val = 0;
                            for (int b : hw) {
                                if (sb.length() > 0)
                                    sb.append(':');
                                val = b ;
                                val &= 0x000000ff;
                                sb.append(String.format("%02X", val));
                            }
                        }
                    }
                } catch (SocketException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    private int add(int a,int b){
        HookCla1 hookCla1=new HookCla1();
        hookCla1.add(a,b);
        HookCla2 hookCla2 = new HookCla2();
        hookCla2.add(a,b);

        return a+b;
    }
    private void  test(){
        Log.d("Main","tes");
    }
//    private static int add(int a,int b){
//        return a+b;
//    }
//    private double add(double a, double b){
//        return a+b;
//    }
public static Object callDeclaredMethod(Object obj, String methodname, Class<?> types[], Object values[]) {
    if(obj==null){
        return null;
    }
    Class<?> classz = obj.getClass();
    Method method = null;
    Object retValue = null;
    try {
        method = classz.getDeclaredMethod(methodname, types);
        method.setAccessible(true);// 设置安全检查，设为true使得可以访问私有方法
        retValue = method.invoke(obj, values);
    } catch (NoSuchMethodException ex) {
//	    AspLog.e(TAG, "callDeclaredMethod "+methodname+" reason=" +  ex +" "+ ex.getMessage());
    } catch (Exception ex) {
//        AspLog.e(TAG, "callDeclaredMethod "+methodname+" reason=" +  ex +" "+ ex.getMessage());
    }
    return retValue;
}

}