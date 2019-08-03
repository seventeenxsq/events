package com.example.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.welcome.activities.SceneryMainActivity;
import com.example.welcome.adpters.SceneryGridAdapter;
import com.example.welcome.adpters.CultureListAdapter;
import com.example.welcome.adpters.FoodAdapter;
import com.example.welcome.models.Culture;
import com.example.welcome.models.Scenery;
import com.example.welcome.views.GridSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity {

        private RecyclerView mRvGrid,mRvList,mRvGrid2;
        private SceneryGridAdapter mAdapter;
       private CultureListAdapter mListAdapter;
       private FoodAdapter mMeishiSdapter;

    private Scenery[] sceneries = {
            new Scenery("黄山",R.drawable.huangshan1 ,"1"),
            new Scenery("芜湖方特",R.drawable.wuhufangta1,"你好"),
            new Scenery("宏村",R.drawable.hongcun1,"222"),
            new Scenery("天柱山",R.drawable.tianzhushan,"33333"),
            new Scenery("西递",R.drawable.xidi1,"4444"),
            new Scenery("中江塔",R.drawable.zhongjiangta,"5555"),
            new Scenery("芜湖方特",R.drawable.wuhufanfte2,"6666"),
            new Scenery("九华山",R.drawable.jiuhuashan1,"7777")
    };

    private Culture[] cultures={
            new Culture("曹操",R.drawable.hongcun1,"三国时期魏国人","https://baike.baidu.com/"),
            new Culture("曹操",R.drawable.hongcun1,"三国时期魏国人","https://baike.baidu.com/"),
            new Culture("曹操",R.drawable.hongcun1,"三国时期魏国人","https://baike.baidu.com/"),
            new Culture("曹操",R.drawable.hongcun1,"三国时期魏国人","https://baike.baidu.com/"),
            new Culture("曹操",R.drawable.hongcun1,"三国时期魏国人","https://baike.baidu.com/"),
            new Culture("曹操",R.drawable.hongcun1,"三国时期魏国人","https://baike.baidu.com/")


    };

    private List<Scenery> sceneryList = new ArrayList<>();
    private List<Culture> cultureList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
           initView();
        }
        private void initView(){
            initNavBar(false,"徽畅游",true);
            initFruits();
            initCulture();

            mRvGrid=fd(R.id.ry_grid);
            mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.pictureMarginSize)));
            mRvGrid.setLayoutManager(new GridLayoutManager(this,3));
            mAdapter=new SceneryGridAdapter(sceneryList);
            mRvGrid.setAdapter(mAdapter);



            mRvList=fd(R.id.rv_list);
            mRvList.setLayoutManager(new LinearLayoutManager(this));
            mRvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
            mListAdapter=new CultureListAdapter(this,cultureList);
            mRvList.setNestedScrollingEnabled(false);
            mRvList.setAdapter(mListAdapter);


            mRvGrid2=fd(R.id.ry_scence);
            mRvGrid2.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.pictureMarginSize)));
            mRvGrid2.setLayoutManager(new GridLayoutManager(this,3));
            mMeishiSdapter=new FoodAdapter(this);
            mRvGrid2.setNestedScrollingEnabled(false);
            mRvGrid2.setAdapter(mMeishiSdapter);
        }


    private void initFruits() {
        sceneryList.clear();
        for (int i = 0; i < 6; i++) {
            sceneryList.add(sceneries[i]);
        }
    }

    private void initCulture(){
            cultureList.clear();
        for (int i = 0; i < 6; i++) {
            cultureList.add(cultures[i]);
        }
    }
}

