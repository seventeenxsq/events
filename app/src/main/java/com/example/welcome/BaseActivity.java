package com.example.welcome;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welcome.activities.MeActivity;

public class BaseActivity extends Activity {//baseactivity作为所有项目的共性

    private ImageView mIvback,mIvme;
    private TextView mTvTitle;

    /**
     * findViewbyId
     *
     */
    protected <T extends View>T fd(@IdRes int id){
        return  findViewById(id);
    }

    /**
     * 初始化NavigationBar
     * @param isShowBack
     * @param title
     */

  public  void initNavBar(boolean isShowBack,String title,boolean isShowMe){//用来初始化NavBar

        mIvback=fd(R.id.iv_back);
        mTvTitle=fd(R.id.tv_title);
        mIvme=fd(R.id.iv_me);

        mIvback.setVisibility(isShowBack ? View.VISIBLE : View.GONE);//显示与隐藏
        mTvTitle.setText(title);
        mIvme.setVisibility( isShowMe ? View.VISIBLE : View.GONE);

        mIvback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              onBackPressed(); //后退操作
            }
        });

        mIvme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BaseActivity.this,MeActivity.class);
                startActivity(intent);


//                finish();
            }
        });
    }


}
