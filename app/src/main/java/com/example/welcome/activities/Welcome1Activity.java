package com.example.welcome.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.welcome.BaseActivity;
import com.example.welcome.MainActivity;
import com.example.welcome.R;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

//1.延迟3秒
//2.跳转页面
public class Welcome1Activity extends BaseActivity {//继承自baseactivity

    private Timer mTimer;//延迟时间类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);
        init();
    }

    private  void  init(){//这个方法帮我们去初始化一些类
        mTimer=new Timer();//时间管理对象
        mTimer.schedule(new TimerTask() {//时间任务
            @Override
            public void run() {
                toLogin();
            }
        },3*1000);//第二参数数时延迟时间，，3秒
    }

    /**
     * 跳转到mainactivity
     */
    private  void toMain(){
        Intent intent=new Intent(this, MainActivity.class);
       startActivity(intent);
       finish();
    }

    private  void toLogin(){
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
