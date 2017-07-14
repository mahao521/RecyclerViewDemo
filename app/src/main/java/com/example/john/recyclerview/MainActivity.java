package com.example.john.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.john.recyclerview.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

       findViewById(R.id.btn_enter).setOnClickListener(this);
        findViewById(R.id.btn_enter_1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_enter: //card

                Intent intent = new Intent(this,CardActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_enter_1:


                break;
        }
    }
}
