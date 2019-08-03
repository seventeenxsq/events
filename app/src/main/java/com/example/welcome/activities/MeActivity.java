package com.example.welcome.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.welcome.BaseActivity;
import com.example.welcome.R;
import com.example.welcome.utils.UserUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        initView();
    }

    private  void initView(){
        initNavBar(true,"个人中心",false);
    }

    /**
     * 修改密码点击事件
     */
    public void onChangeClick(View v){
        startActivity(new Intent(this,ChangePassWordActivity.class));
    }

    /**
     * 退出登录
     */
    public void onLogoutClick(View v){
        UserUtils.logout(this);
    }

}
