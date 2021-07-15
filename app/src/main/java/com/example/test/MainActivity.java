package com.example.test;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {
    private static final String TAG = "MainActivity";
    Button anr_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        anr_btn = findViewById(R.id.btn1);
    }

    public void initData() {
        String date = "20210430";
        String s = timeStringToMsgDisplayTime(date);
        anr_btn.setText(s);

        String s1 = TimeUtils.millis2String(1619532000, "HH:mm:ss");
        long l = TimeUtils.string2Millis("20210427 22:00:00", "yyyyMMdd HH:mm:ss");
        long l2 = TimeUtils.string2Millis("20210427 23:00:00", "yyyyMMdd HH:mm:ss");
        long l3 = TimeUtils.string2Millis("20210428 21:00:00", "yyyyMMdd HH:mm:ss");
        long l4 = TimeUtils.string2Millis("20211128 21:00:00", "yyyyMMdd HH:mm:ss");
        LogUtils.i(TAG, "millis2String：" + s1 + "  string2Millis：" + l + "  " + l2 + "  " + l3 + "  " + l4);

    }

    public static String timeStringToMsgDisplayTime(String timeString) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        StringBuilder builder = new StringBuilder();
        try {
            Date date = sdf.parse(timeString);
            calendar.setTime(date);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1;

            Date today = new Date();
            calendar.setTime(today);
            int dayToday = calendar.get(calendar.DAY_OF_MONTH);
            if (dayToday - day == 0) {
                builder.append(" 今天");
            } else if (dayToday - day == -1) {
                builder.append(" 明天");
            } else if (dayToday - day == -2) {
                builder.append(" 后天");
            } else {
                builder.append(month);
                builder.append("月");
                builder.append(day);
                builder.append("日");
            }
            return builder.toString();
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void initEvent() {

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}