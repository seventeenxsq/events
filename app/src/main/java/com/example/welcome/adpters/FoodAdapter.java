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
import com.example.welcome.R;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{


    private Context mContext;

    public FoodAdapter(Context context){
        mContext=context;
    }


    class ViewHolder extends  RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodname;


        public  ViewHolder(@NonNull View itemView){
            super((itemView));
            foodImage=itemView.findViewById(R.id.meishi_Image);
            foodname=itemView.findViewById(R.id.meishi_tv);
        }
    }



    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FoodAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_meishi,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        switch (i){
            case 1:
                Glide.with(mContext)
                        .load(R.mipmap.diguoji)
                        .into(viewHolder.foodImage);
                viewHolder.foodname.setText("地锅鸡");
                break;
            case 2:
                Glide.with(mContext)
                        .load("http://t10.baidu.com/it/u=1538453934,2437674844&fm=173&app=25&f=JPEG?w=419&h=283&s=15A6C4B643AAAEE01E0FDD2B0300B04B4")
                        .into(viewHolder.foodImage);
                viewHolder.foodname.setText("臭鳜鱼");
                break;
        }
    }


    @Override
    public int getItemCount() {
        return 3;
    }


}


