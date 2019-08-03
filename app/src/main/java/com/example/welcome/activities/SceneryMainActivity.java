package com.example.welcome.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.welcome.BaseActivity;
import com.example.welcome.R;
import com.example.welcome.adpters.SceneryAdapter;
import com.example.welcome.models.Scenery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SceneryMainActivity extends BaseActivity {


    private Scenery[] sceneries = {
            new Scenery("黄山",R.drawable.huangshan1 ,"1"),
            new Scenery("芜湖方特",R.drawable.wuhufangta1,"你好"),
            new Scenery("宏村",R.drawable.hongcun1,"222"),
            new Scenery("天柱山",R.drawable.tianzhushan,"33333"),
            new Scenery("西递",R.drawable.xidi1,"4444"),
            new Scenery("中江塔",R.drawable.zhongjiangta,"5555"),
            new Scenery("芜湖方特",R.drawable.wuhufanfte2,"6666"),
            new Scenery("九华山",R.drawable.jiuhuashan1,"7777"),
            new Scenery("黄山",R.drawable.huangshan2,"33333"),
            new Scenery("宏村",R.drawable.hongcun2,"77777"),
            new Scenery("徽州古城",R.drawable.huizhougucheng,"88888"),
            new Scenery("天堂寨",R.drawable.tiantangzhai,"9999"),
            new Scenery("芜湖方特",R.drawable.wuhufanfte2,"00000")
                            };

    private List<Scenery> sceneryList = new ArrayList<>();

    private SceneryAdapter adapter;

    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secenery_main);
        initNavBar(true,"不能错过的风景",false);


        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SceneryAdapter(sceneryList);
        recyclerView.setAdapter(adapter);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
    }

    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initFruits() {
        sceneryList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(sceneries.length);
            sceneryList.add(sceneries[index]);
        }
    }




}
