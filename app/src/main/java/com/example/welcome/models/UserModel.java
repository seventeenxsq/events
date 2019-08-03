package com.example.welcome.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * 介个里放的是数据库存储信息时的字段
 * UserModel是数据库的词条的实例
 * 每一个Model中主键都是不可重复的。
 */
public class UserModel extends RealmObject {//Realm模型类


    @PrimaryKey//声明主键
    private String phone;//用户手机
    @Required//表示每个用户需要一个密码
    private String password;//用户密码


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
