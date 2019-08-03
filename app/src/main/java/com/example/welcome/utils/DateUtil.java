package com.example.welcome.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtil {

    //unix time->11:11

    public static String getFormattedTime(long timeStamp){
        SimpleDateFormat formatter=new SimpleDateFormat("HH:mm");
        return formatter.format(new Date(timeStamp));
    }

    //得到日期
    public static String getFormattedDate(){
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(new Date());
    }
}
