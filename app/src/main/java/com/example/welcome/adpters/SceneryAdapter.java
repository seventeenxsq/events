package com.example.welcome.adpters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.welcome.R;
import com.example.welcome.activities.SceneryActivity;
import com.example.welcome.models.Scenery;

import java.util.List;

public class SceneryAdapter extends RecyclerView.Adapter<SceneryAdapter.ViewHolder>{

    private Context mContext;

    private List<Scenery> mSceneryList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {//在构造方法里找到三个控件
            super(view);
            cardView = (CardView) view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public SceneryAdapter(List<Scenery> sceneryList) {
        mSceneryList = sceneryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.scenery_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Scenery scenery = mSceneryList.get(position);//获得位置
                Intent intent = new Intent(mContext, SceneryActivity.class);
                intent.putExtra(SceneryActivity.FRUIT_NAME, scenery.getName());
                intent.putExtra(SceneryActivity.FRUIT_IMAGE_ID, scenery.getImageId());
                intent.putExtra(SceneryActivity.FRUIT_CONTENT, scenery.getContent());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Scenery scenery = mSceneryList.get(position);
        holder.fruitName.setText(scenery.getName());
        Glide.with(mContext).load(scenery.getImageId()).into(holder.fruitImage);
    }

    @Override
    public int getItemCount() {
        return mSceneryList.size();
    }

}
