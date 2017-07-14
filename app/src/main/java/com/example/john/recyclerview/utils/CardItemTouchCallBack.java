package com.example.john.recyclerview.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.ImageView;

import com.example.john.recyclerview.R;
import com.example.john.recyclerview.adapter.CardRecyclerAdapter;

import java.util.List;

/**
 * Created by Penghy on 2017/7/13.
 */


public class CardItemTouchCallBack extends  ItemTouchHelper.SimpleCallback {


    private List<String> list;
    private CardRecyclerAdapter mAdapter;

    /**
     * Creates a Callback for the given drag and swipe allowance. These values serve as
     * defaults
     * and if you want to customize behavior per ViewHolder, you can override
     * {@link #getSwipeDirs(RecyclerView, ViewHolder)}
     * and / or {@link #getDragDirs(RecyclerView, ViewHolder)}.
     *
     * @param dragDirs  Binary OR of direction flags in which the Views can be dragged. Must be
     *                  composed of {@link #LEFT}, {@link #RIGHT}, {@link #START}, {@link
     *                  #END},
     *                  {@link #UP} and {@link #DOWN}.
     * @param swipeDirs Binary OR of direction flags in which the Views can be swiped. Must be
     *                  composed of {@link #LEFT}, {@link #RIGHT}, {@link #START}, {@link
     *                  #END},
     *                  {@link #UP} and {@link #DOWN}.
     */
    public CardItemTouchCallBack(int dragDirs, int swipeDirs,List<String> listImg,CardRecyclerAdapter adapter) {
        super(dragDirs, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT|ItemTouchHelper.DOWN|ItemTouchHelper.UP);

        this.list = listImg;
        this.mAdapter = adapter;
    }

    /**If you don't support drag & drop, this method will never be called.
     * Called when ItemTouchHelper wants to move the dragged item from its old position to
     * the new position.
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        return true;
    }

    /**
     *  If you don't support swiping, this method will never be called.
     * @param viewHolder
     * @param direction  Called when a ViewHolder is swiped by the user.
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {


        int position = viewHolder.getAdapterPosition();
        list.remove(position);
        mAdapter.notifyDataSetChanged();

    }


    /**
     *
     * @param c                 The canvas which RecyclerView is drawing its children
     * @param recyclerView      The RecyclerView to which ItemTouchHelper is attached to
     * @param viewHolder        The ViewHolder which is being interacted by the User or it was
     *                          interacted and simply animating to its original position
     * @param dX                The amount of horizontal displacement caused by user's action
     * @param dY                The amount of vertical displacement caused by user's action
     * @param actionState       The type of interaction on the View. Is either {@link
     *                          #ACTION_STATE_DRAG} or {@link #ACTION_STATE_SWIPE}.
     * @param isCurrentlyActive True if this view is currently being controlled by the user or
     *                          false it is simply animating back to its original state.
     * @see #onChildDrawOver(Canvas, RecyclerView, RecyclerView.ViewHolder, float, float, int,
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

        float  max = recyclerView.getWidth() * 0.5f;

        if(viewHolder instanceof CardRecyclerAdapter.CardViewHolder){

            CardRecyclerAdapter.CardViewHolder holder = (CardRecyclerAdapter.CardViewHolder) viewHolder;
            ImageView imgShow = (ImageView) holder.itemView.findViewById(R.id.img_show);
            c.rotate(180,imgShow.getWidth()/2,imgShow.getHeight()/2);
      /*      imgShow.draw(c);
            imgShow.getDrawable().draw(c);
            Bitmap bitmap = Bitmap.createBitmap(((BitmapDrawable)imgShow.getDrawable()).getBitmap());
            rotaingImageView(180,bitmap);
            imgShow.setScaleX(dX / max);
            imgShow.setScaleY(dY / max);*/


        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {


        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return 100;
    }

    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return .5f;
    }

    public static Bitmap rotaingImageView(int angle, Bitmap bitmap)
    {
        // 旋转图片 动作
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        // 创建新的图片
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (resizedBitmap != bitmap && bitmap != null && !bitmap.isRecycled()){
            bitmap.recycle();
            bitmap = null;
        }
        return resizedBitmap;
    }
}
