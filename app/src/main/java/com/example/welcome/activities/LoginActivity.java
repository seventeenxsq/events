package com.example.welcome.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.welcome.BaseActivity;
import com.example.welcome.MainActivity;
import com.example.welcome.R;
import com.example.welcome.utils.UserUtils;
import com.example.welcome.views.InputView;

public class LoginActivity extends BaseActivity {

    private InputView mInputPhone,mInputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }
    private void initView(){
        initNavBar(false,"登录",false);
        mInputPhone=findViewById(R.id.input_phone);
        mInputPassword=findViewById(R.id.input_passward);
    }

    /**
     * 跳转注册页面
     * @param
     */
    public void onRegisterClick(View v){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    /**
     * 登录
     */
    public void onCommitClick(View v){

        String phone=mInputPhone.getInputStr();

        String password=mInputPassword.getInputStr();

//        //验证是否合法
//        if(!UserUtils.validataLogin(this,phone,password)){
//            return;
//        }
//        else
        {
           Intent intent = new Intent(this, MainActivity.class);
           startActivity(intent);
           finish();
        }
    }

}

