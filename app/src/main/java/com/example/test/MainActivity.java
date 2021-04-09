package com.example.test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initEvent();
//        loadRootFragment(R.id.ll_container, TestFragment1.newInstance());
//        start(TestFragment2.newInstance());
    }

    public void initData() {
    }

    private void initEvent() {
        Button anr_btn = findViewById(R.id.btn1);
        anr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                new Handler().post(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                String str = "anr test";
//                                for (int i = 0; i <= 150000; i++) {
//                                    str = str + i;
//                                    if (i == 0 || i == 15000) {
//                                        Log.d("MainActivity", "" + i);
//                                    }
//                                }
//                            }
//                        }).start();
//
//
//                    }
//                });

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        String str = "anr test";
//                        for (int i = 0; i <= 150000; i++) {
//                            str = str + i;
//                            if (i == 0 || i == 15000) {
//                                Log.d("MainActivity", "" + i);
//                            }
//                        }
//                    }
//                }).start();

                new Thread() {
                    @Override
                    public void run() {
                        String str = "anr test";
                        for (int i = 0; i <= 150000; i++) {
                            str = str + i;
                            if (i == 0 || i == 15000) {
                                Log.d("MainActivity", "" + i);
                            }
                        }
                    }
                }.start();

            }
        });
    }
}