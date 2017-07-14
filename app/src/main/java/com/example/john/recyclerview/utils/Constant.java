package com.example.john.recyclerview.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Penghy on 2017/7/13.
 */


public  class Constant {

    //每个item数值方向偏移量
    public static int TRANSLATE ;

    //默认展示数量
    public static final int SHOWCOUNT = 4;

    //设置缩放比
    public static float SCALE;

    public static void  initConstant(Context context){

        TRANSLATE = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,context.getResources().getDisplayMetrics());

        SCALE = 0.040f;
    }
}
