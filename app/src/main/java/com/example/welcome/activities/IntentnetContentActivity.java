package com.example.welcome.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.welcome.BaseActivity;
import com.example.welcome.R;

public class IntentnetContentActivity extends BaseActivity {

    private WebView mWvMain;

    public static final String CONTENT_URL="IntentUrl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentnet_content);
        initNavBar(true,"文化详情",false);
        mWvMain=fd(R.id.wv_content);
        mWvMain.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();//获得意图
        String intent_url= intent.getStringExtra(CONTENT_URL);//获得意图的网址
        mWvMain.loadUrl(intent_url);
    }
}
