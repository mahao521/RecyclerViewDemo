package com.example.john.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.john.recyclerview.R;

import java.util.ArrayList;

/**
 * Created by John on 2016/2/18.
 */
public class RecyclerItemAdapter  extends RecyclerView.Adapter<RecyclerItemAdapter.TestViewHolder> {

    private Context mContext;
    private ArrayList<String> mList;

    public RecyclerItemAdapter(Context mContext,ArrayList<String> list){

        this.mContext = mContext;
        this.mList = list;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View inflate = LayoutInflater.from(mContext).inflate(R.layout.main_item_item,parent,false);
        return new TestViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

          holder.txtView.setText(mList.get(position)+"");

    }

    @Override
    public int getItemCount() {

        int len = 0;
        if(mList != null){

            len = mList.size();
        }
        return len ;
    }

    class TestViewHolder extends RecyclerView.ViewHolder{

        private TextView txtView;

        public TestViewHolder(View itemView) {

            super(itemView);
            txtView = (TextView) itemView.findViewById(R.id.txt);
        }
    }
}

