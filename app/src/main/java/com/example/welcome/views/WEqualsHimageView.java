package com.example.welcome.views;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WEqualsHimageView extends AppCompatImageView {

    public WEqualsHimageView(Context context) {
        super(context);
    }

    public WEqualsHimageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WEqualsHimageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

       int width= MeasureSpec.getSize(widthMeasureSpec);

        int mode=MeasureSpec.getMode(widthMeasureSpec);
    }
}
