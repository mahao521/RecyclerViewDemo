package com.example.john.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.john.recyclerview.adapter.CardRecyclerAdapter;
import com.example.john.recyclerview.utils.CardItemTouchCallBack;
import com.example.john.recyclerview.utils.Constant;
import com.example.john.recyclerview.utils.SwipLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        List<String> imglist = getImgList();
        RecyclerView recyView = (RecyclerView) findViewById(R.id.recy_card_view);

        //初始常量
        Constant.initConstant(this);

        //设置显示布局
        SwipLayoutManager layoutManager = new SwipLayoutManager();
        recyView.setLayoutManager(layoutManager);

        //设置数据源
        CardRecyclerAdapter adapter = new CardRecyclerAdapter(imglist);
        recyView.setAdapter(adapter);

        //设置拖拽事件
        CardItemTouchCallBack callBack = new CardItemTouchCallBack(0,0,imglist,adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callBack);
        itemTouchHelper.attachToRecyclerView(recyView);
    }

    /**
     *   获取图片数据源
     */
    protected List<String> getImgList(){

        List<String> list = new ArrayList<>();
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489308136466&di=d3df0660b6cad8055ced40f081ff08ef&imgtype=0&src=http%3A%2F%2Fi5.3conline.com%2Fimages%2Fpiclib%2F201201%2F04%2Fbatch%2F1%2F123590%2F1325657824467t6txnk6u78.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489308136462&di=7a3427a1a7e1f529c7d95da7d6f405ee&imgtype=0&src=http%3A%2F%2Fimage91.360doc.com%2FDownloadImg%2F2015%2F12%2F0813%2F62615249_1.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489308469766&di=8568983d815a5160cded71746fc7a9ca&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2Fallimg%2F160327%2F16-16032G21928.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489309860698&di=dc7644f463453eaa0850b5ef0aa38b25&imgtype=0&src=http%3A%2F%2Fimage95.360doc.com%2FDownloadImg%2F2016%2F02%2F2622%2F66721351_2.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1489299944&di=951c3ae0db72084b0fbfb9d8c51eb241&src=http://kantongxiao.com/upload/aHR0cDovL2cxLnlraW1nLmNvbS8wNTExNkY0OTUzRDJCMTdGNjcwODRDNzBCMzI2MjhGOA==.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1489300090&di=736e965dbc8651b962dd87c0a717adb1&src=http://imgchr.com/images/343691.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489310297792&di=634fe961ee23769e83937f0b48170772&imgtype=0&src=http%3A%2F%2Fimg.qqai.net%2Fuploads%2Fi_0_4035598123x1084105545_21.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489310726121&di=6e965108e646e728c2b0cd42a3bcba72&imgtype=0&src=http%3A%2F%2Fi1.17173.itc.cn%2F2014%2Fuploads%2Fvfz01%2Fvlog%2Fimages%2Fvideo%2F20140415%2F12727166_0.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489310802270&di=b6efe180acb9fbd6ac94c7f3d943241f&imgtype=0&src=http%3A%2F%2Fvi3.ku6img.com%2Fdata1%2Fp12%2Fku6video%2F2014%2F1%2F6%2F13%2F1394313850193_93233402_93233402%2F106.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489310844360&di=4fd247ce56a810672e8a8f49c8c53c00&imgtype=0&src=http%3A%2F%2Fimg.sc115.com%2Fhb%2Fyl2%2F19%2F881606270133806.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489310844359&di=abfc2266288fd3600d18bfd53536a99d&imgtype=0&src=http%3A%2F%2Fi.dimg.cc%2Fdc%2Fd8%2Fa3%2F56%2Ff8%2Fc9%2F66%2Fd7%2Fa0%2F8d%2F98%2Fdb%2F84%2F8d%2F71%2F26.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489310844357&di=5b232c6e28d488a493505e18e97613c3&imgtype=0&src=http%3A%2F%2Fimg0.pconline.com.cn%2Fpconline%2F1609%2F22%2F8394940_19_thumb.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489311045886&di=a4d52e143d533288a95221a0b972ab7b&imgtype=0&src=http%3A%2F%2Fdimg05.c-ctrip.com%2Fimages%2Ftg%2F076%2F253%2F885%2F59af24cce33e46748111ca3b682909ea.jpg");
        list.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=970337886,1355285319&fm=23&gp=0.jpg");
        return list;
    }
}
