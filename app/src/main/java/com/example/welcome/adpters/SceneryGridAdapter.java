package com.example.welcome.adpters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.welcome.MainActivity;
import com.example.welcome.R;
import com.example.welcome.activities.SceneryActivity;
import com.example.welcome.activities.SceneryMainActivity;
import com.example.welcome.models.Scenery;

import java.util.List;

import static android.view.LayoutInflater.from;
import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class SceneryGridAdapter extends RecyclerView.Adapter<SceneryGridAdapter.ViewHolder> {

    private List<Scenery> mSceneryList;
    private Context mContext;

    class ViewHolder extends RecyclerView.ViewHolder {
        View sceneryView;
        ImageView ivIcon;
        TextView tv_sceneryname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sceneryView = itemView;
            tv_sceneryname = itemView.findViewById(R.id.tv_name);
            ivIcon = itemView.findViewById(R.id.iv_icon);
        }
    }
    public SceneryGridAdapter(List<Scenery> sceneryList) {
        mSceneryList = sceneryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_secnery, viewGroup, false);
        ;
        final ViewHolder holder = new ViewHolder(view);
        holder.sceneryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  int position = holder.getAdapterPosition();
               // Scenery scenery = mSceneryList.get(position);
                Intent intent = new Intent(mContext, SceneryMainActivity.class);
                startActivity(intent);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Scenery scenery = mSceneryList.get(i);
        viewHolder.tv_sceneryname.setText(scenery.getName());
        Glide.with(mContext).load(scenery.getImageId()).into(viewHolder.ivIcon);

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
