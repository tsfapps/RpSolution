package com.rpsolution.utils;

import android.util.Log;

public class CustomLog {
    public static void d(String tag,String msg){
        Log.d(tag,msg);
    }

    public static void i(String tag, String msg){
        Log.i(tag,msg);
    }

    public static void e(String tag, String msg){
        Log.e(tag,msg);
    }
}
