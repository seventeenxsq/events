package com.example.welcome.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.example.welcome.R;
import com.example.welcome.activities.LoginActivity;
import com.example.welcome.helps.RealmHelper;
import com.example.welcome.models.UserModel;

import java.util.List;

public class UserUtils {

    /**
     * 验证用户输入合法性
     */
   public static boolean validataLogin(Context context,String phone,String password){

        //  RegexUtils.isMobileSimple(phone);

      if(StringUtils.isEmpty(phone)) {
          Toast.makeText(context,"手机号不能为空",Toast.LENGTH_SHORT).show();
          return false;
      }

      if(! RegexUtils.isMobileExact(phone)){
            Toast.makeText(context,"无效手机号",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT).show();
            return false;
        }

       /**
        * 1、用户当前手机号是否已经被注册了
        * 2、用户输入的手机号和密码是否匹配
        */
       if (!UserUtils.userExistFromPhone(phone)) {
           Toast.makeText(context, "当前手机号未注册", Toast.LENGTH_SHORT).show();
           return false;
       }

       RealmHelper realmHelper=new RealmHelper();
       boolean result=realmHelper.validateUser(phone,EncryptUtils.encryptMD5ToString(password));
       realmHelper.close();
       if (!result) {
           Toast.makeText(context, "手机号或者密码不正确", Toast.LENGTH_SHORT).show();
           return false;
       }
           // login

           return true;
       }

    /**
     * 退出登录
     */
    public static void logout(Context context){
        Intent intent=new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        //定义跳转动画
        ((Activity)context).overridePendingTransition(R.anim.open_enter,R.anim.open_exit);
    }

    /**
     * 注册用户
     * @param context
     * @param phone
     * @param password
     * @param passwardconfirm
     */
    public  static boolean registerUser(Context context,String phone,String password,String passwardconfirm) {
        if(StringUtils.isEmpty(phone)) {
            Toast.makeText(context,"手机号不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(! RegexUtils.isMobileExact(phone)){
            Toast.makeText(context,"无效手机号",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT).show();
            return false;
        }

//          用户当前输入的手机号是否已经被注册
        /**
         * 1、通过Realm获取当前已经注册的所有用户
         * 2、根据用户输入的手机号匹配查询的所有用户，如果可以匹配则证明该手机号已经被注册，否则就表示该手机号还未注册
         */
        if (UserUtils.userExistFromPhone(phone)) {
            Toast.makeText(context, "该手机号已存在", Toast.LENGTH_SHORT).show();
            return false;
        }

        /**
         * 添加用户内容
         */
        UserModel userModel = new UserModel();
        userModel.setPhone(phone);
        userModel.setPassword(EncryptUtils.encryptMD5ToString(password));

        saveUser(userModel);
        return true;
    }
    /**
     * 保存用户到数据库
     */
    public static void saveUser(UserModel userModel){
            RealmHelper realmHelper =new RealmHelper();
            realmHelper.saveUser(userModel);
            realmHelper.close();//最后要关闭数据库
    }

    /**
     * 根据手机号判断用户是否存在
     */
    public static boolean userExistFromPhone (String phone) {
        boolean result = false;

        RealmHelper realmHelper = new RealmHelper();
        List<UserModel> allUser = realmHelper.getAllUser();

        for (UserModel userModel : allUser) {
            if (userModel.getPhone().equals(phone)) {
//                当前手机号已经存在于数据库中了
                result = true;
                break;
            }
        }

        realmHelper.close();

        return result;
    }


    }


