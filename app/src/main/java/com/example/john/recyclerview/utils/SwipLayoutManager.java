package com.example.john.recyclerview.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Penghy on 2017/7/13.
 */


public class SwipLayoutManager extends RecyclerView.LayoutManager {


    /**
     *  Create a default <code>LayoutParams</code> object for a child of the RecyclerView.
     * @return
     */
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {

        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {


        //Recycler to scrap views into
        detachAndScrapAttachedViews(recycler);

        //Number of attached children
        int count = getChildCount();

        //The number of items in the bound adapter
        int itemCount = getItemCount();

        int initPosition ;

        if(itemCount <= Constant.SHOWCOUNT){

            initPosition = 0;
        }else {

            initPosition = itemCount - Constant.SHOWCOUNT;
        }

        //只展示4个，并且每一个位移一定dp
        for(int i = initPosition ; i < itemCount; i++){

             View view = recycler.getViewForPosition(i);
             addView(view);
             measureChild(view,0,0);

            //设置偏移量
            int moveT =  Constant.TRANSLATE * (itemCount - i);

            //计算view的位置
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();

            //计算屏幕的位置---居中
            int width = getWidth();
            int height = getHeight();

            //居上的margin
            int topMargin = (height - measuredHeight)/2;
            int leftMargin = (width - measuredWidth)/2;

            //获取margin
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();

            //Calculates the item decor insets applied to the given child and updates the provided
            // Rect instance with the inset values.
            Rect outRect = new Rect();
            calculateItemDecorationsForChild(view,outRect);

            int left = leftMargin + layoutParams.leftMargin;
            int top = topMargin + layoutParams.topMargin;
            int right = left + measuredWidth - layoutParams.rightMargin;
            int bottom = top + measuredHeight - layoutParams.bottomMargin;

            view.layout(left,top ,right,bottom );

           // Log.i("mahao",left + "..." + right +"..." + bottom + "..." + top);

            //做一个层次效果
            int level = itemCount - i; // 4 3 2 1
            if(level > 0){ // 6 7 8 9

                //图片---小---大
                view.setScaleX(1-Constant.SCALE*level); //0.2 0.4 0.6 0.8
                view.setScaleY(1-Constant.SCALE*level);

                if(level < Constant.SHOWCOUNT ){
                  view.setTranslationY(Constant.TRANSLATE * level);
                }else {
                    view.setTranslationY(Constant.TRANSLATE * (level-1));
                }
            }
        }
    }
}
