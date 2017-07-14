package com.example.john.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.john.recyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Penghy on 2017/7/13.
 */


public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder> implements View.OnClickListener {


    private List<String> list;
    private Context mContext;

    public CardRecyclerAdapter(List<String> list){

        this.list = list;
    }

    /**
     *   Called when RecyclerView needs a new {@link RecyclerView.ViewHolder} of the given type to represent
     *   an item.
     * @param parent
     * @param viewType  The view type of the new View.
     * @return
     */
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        CardViewHolder holder = new CardViewHolder(view);
        return holder;
    }


    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link RecyclerView.ViewHolder#itemView} to refle
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {

        String imgUrl = list.get(position);
        Picasso.with(mContext).load(imgUrl).fit()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgShow);
        holder.btnLove.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_love: // 喜欢


                break;
        }

    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        private Button btnLove;
        private ImageView imgShow;

        public CardViewHolder(View itemView) {
            super(itemView);

            btnLove = (Button) itemView.findViewById(R.id.btn_love);
            imgShow = (ImageView) itemView.findViewById(R.id.img_show);
        }
    }
}
