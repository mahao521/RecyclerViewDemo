package com.example.john.testrecycler_in_recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by John on 2016/2/18.
 */

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.TestViewHolder> {

    private Context mContext;
    private ArrayList<String> mList;



    public RecyclerAdapter(Context mContext,ArrayList<String> list){

        this.mContext = mContext;

        mList = list;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View inflate = LayoutInflater.from(mContext).inflate(R.layout.test_item,parent,false);
        return new TestViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

      //  holder.txtView.setText(mList.get(position)+"");
/*      LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(mContext);
        linearLayoutManager4.setOrientation(LinearLayoutManager.VERTICAL);
        holder.recyclerview.setLayoutManager(linearLayoutManager4);*/


/*        GridLayoutManager gridLayout = new GridLayoutManager(mContext,4);
        holder.recyclerview.setLayoutManager(gridLayout); */

 /*      MyLinearLayoutManager linearLayoutManager = new MyLinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        holder.recyclerview.setLayoutManager(linearLayoutManager);*/

        MyGridLinearLayoutManager gridLayoutMan = new MyGridLinearLayoutManager(mContext,4);
        holder.recyclerview.setLayoutManager(gridLayoutMan);
        holder.recyclerview.setAdapter(new RecyclerItemAdapter(mContext,mList));

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

        //private TextView txtView;
        private RecyclerView recyclerview;
        public TestViewHolder(View itemView) {
            super(itemView);
          //  txtView = (TextView) itemView.findViewById(R.id.txt);
            recyclerview = (RecyclerView) itemView.findViewById(R.id.recyclerview_item_1);
        }
    }
}
