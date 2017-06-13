package com.portal.banner_milaoshu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;

import com.milaoshu.convenientbanner.ConvenientBanner;
import com.milaoshu.convenientbanner.listener.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    private ConvenientBanner convenientBanner,convenientBanner1,convenientBanner2,convenientBanner3,convenientBanner4,convenientBanner5,convenientBanner6,convenientBanner7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

         convenientBanner = (ConvenientBanner)findViewById(R.id.convenientBanner);
         convenientBanner1 = (ConvenientBanner)findViewById(R.id.convenientBanner1);
         convenientBanner2 = (ConvenientBanner)findViewById(R.id.convenientBanner2);
         convenientBanner3 = (ConvenientBanner)findViewById(R.id.convenientBanner3);
         convenientBanner4 = (ConvenientBanner)findViewById(R.id.convenientBanner4);
         convenientBanner5 = (ConvenientBanner)findViewById(R.id.convenientBanner5);
         convenientBanner6 = (ConvenientBanner)findViewById(R.id.convenientBanner6);
         convenientBanner7 = (ConvenientBanner)findViewById(R.id.convenientBanner7);
        //滚动图
        new TakeTurns(this, null, convenientBanner,"RotateDown", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
        //滚动图
        new TakeTurns(this, null, convenientBanner1,"RotateUp", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
        //滚动图
        new TakeTurns(this, null, convenientBanner2,"RotateY", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
        //滚动图
        new TakeTurns(this, null, convenientBanner3,"Standard", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
        //滚动图
        new TakeTurns(this, null, convenientBanner4,"Alpha", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
        //滚动图
        new TakeTurns(this, null, convenientBanner5,"ScaleIn", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
        //滚动图
        new TakeTurns(this, null, convenientBanner6,"RotateDown and Alpha", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
        //滚动图
        new TakeTurns(this, null, convenientBanner7,"RotateDown and Alpha And ScaleIn", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(1000);
    }


    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }
}
