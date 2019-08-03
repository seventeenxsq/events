package com.example.welcome.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.welcome.R;

/**
 * 输入手机号和密码等的适配
 * 1、input_icon:输入框前面的图标
 * 2、input_hint:输入框的提示提示内容
 * 3、is_password:输入的内容是否需要一秘文的形式展示
 */
public class InputView extends FrameLayout {

    private  int inputIcon;
    private String inputHint;
    private  Boolean isPassword;

    private View mView;
    private ImageView mIvIcon;
    private EditText mEtInput;

    public InputView( @NonNull Context context) {
        super(context);
        init(context,null);
    }
    public InputView( @NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }
    public InputView(@NonNull Context context,@NonNull AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputView(@NonNull Context context,@NonNull AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }
    /**
     * 初始化方法
     * @param context
     * @param
     */
    private void init(Context context, AttributeSet attrs ){
        if(attrs==null) return;
        //获取自定义属性
       TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.inputView);
      inputIcon = typedArray.getResourceId(R.styleable.inputView_input_icon,1);//###############################
      inputHint=typedArray.getString(R.styleable.inputView_input_hint);
      isPassword=typedArray.getBoolean(R.styleable.inputView_is_password,false);
       typedArray.recycle();

       // 绑定layout布局
        mView=LayoutInflater.from(context).inflate(R.layout.input_view,this,false);
        mIvIcon=mView.findViewById(R.id.iv_icon);
        mEtInput=mView.findViewById(R.id.et_input);

        //布局关联属性
        mIvIcon.setImageResource(inputIcon);
        mEtInput.setHint(inputHint);
        mEtInput.setInputType(isPassword ? InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD:InputType.TYPE_CLASS_PHONE);

        addView(mView);
    }

    /**
     * 返回输入的内容
     * @return
     */
    public  String getInputStr(){
        return  mEtInput.getText().toString().trim();//trim表示清除空格
    }
}
