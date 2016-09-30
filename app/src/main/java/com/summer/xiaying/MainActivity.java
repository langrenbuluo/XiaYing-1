package com.summer.xiaying;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.summer.xiaying.activity.guideActivity;
import com.summer.xiaying.activity.work_Activity;

public class MainActivity extends AppCompatActivity {
    Intent it=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
        init();
    }

    private void initView() {
        WebView wv= (WebView) findViewById(R.id.start_gif);
        wv.loadUrl("file:///android_asset/start_gif.gif");
    }

    private void init() {
        SharedPreferences sp=getSharedPreferences("args", Context.MODE_PRIVATE);
        boolean isShow=sp.getBoolean("isShow", false);
        if (isShow) {
            it=new Intent(this,work_Activity.class);
        }else {
            it=new Intent(this,guideActivity.class);
        }
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startActivity(it);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
