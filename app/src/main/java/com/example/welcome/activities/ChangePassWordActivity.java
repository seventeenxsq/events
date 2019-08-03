package com.example.welcome.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.welcome.BaseActivity;
import com.example.welcome.R;

public class ChangePassWordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass_word);

        initView();
    }

    private  void initView(){
        initNavBar(true,"修改密码",false);

    }
}
