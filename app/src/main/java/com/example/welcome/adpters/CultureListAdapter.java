package com.example.welcome.adpters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.welcome.R;
import com.example.welcome.activities.IntentnetContentActivity;
import com.example.welcome.activities.SceneryMainActivity;
import com.example.welcome.models.Culture;
import com.example.welcome.models.Scenery;

import java.util.List;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class CultureListAdapter extends RecyclerView.Adapter<CultureListAdapter.ViewHolder> {

    private List<Culture>  mCultureList;
    private Context mContext;
    private RecyclerView mRv;
    private  View mItemView;
    private boolean isCalcaulationRvHeight;


    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivIcon;
        TextView title;
        TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon=itemView.findViewById(R.id.iv_icon1);
            title=itemView.findViewById(R.id.culture_title);
            content=itemView.findViewById(R.id.culture_content);
        }
    }

    public CultureListAdapter(Context context,List<Culture> mList){
        mContext=context;
         mCultureList=mList;
    }//接受上下文

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_culture, viewGroup, false);
        final CultureListAdapter.ViewHolder holder = new CultureListAdapter.ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Culture culture = mCultureList.get(position);
                Intent intent = new Intent(mContext, IntentnetContentActivity.class);
                intent.putExtra(IntentnetContentActivity.CONTENT_URL,culture.getURL());
                startActivity(intent);
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//            setRecycleViewHeight();
           Culture culture=mCultureList.get(i);
        viewHolder.title.setText(culture.getTitle());
        viewHolder.content.setText(culture.getContent());
        Glide.with(mContext).load(culture.getImage()).into(viewHolder.ivIcon);
    }

    @Override
    public int getItemCount() {
        return 6;
    }


//    /**
//     * 使用 itemheighr*itemNUm=RecycleVirw的高度
//     */
//    private  void setRecycleViewHeight(){
//        if (isCalcaulationRvHeight||mRv==null) return;
//        isCalcaulationRvHeight=true;
//        //获取Item View的高度
//       RecyclerView.LayoutParams itemViewLp= (RecyclerView.LayoutParams) mItemView.getLayoutParams();
//       //获取itemView的数量
//        int itemCount=getItemCount();
//        //代入公式
//          int recycleViewHeight=itemViewLp.height * itemCount;
//         //设置Recycle View高度
//        LinearLayout.LayoutParams rvLp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
//        rvLp.height=recycleViewHeight;
//                mRv.setLayoutParams(rvLp);
//    }
}
