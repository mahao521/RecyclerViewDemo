package com.example.john.testrecycler_in_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView1,mRecyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView1 = (RecyclerView) this.findViewById(R.id.recyclerview_1);
     //   mRecyclerView2 = (RecyclerView) this.findViewById(R.id.recyclerview_2);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView1.setLayoutManager(linearLayoutManager1);


      /*  MyLinearLayoutManager linearLayoutManager = new MyLinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView1.setLayoutManager(linearLayoutManager);*/
      /*  LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView2.setLayoutManager(linearLayoutManager2);
      */

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            list.add("i="+i);
        }
        RecyclerAdapter adapter = new RecyclerAdapter(this,list);
        mRecyclerView1.setAdapter(adapter);


        //mRecyclerView2.setAdapter(adapter);
    }
}
