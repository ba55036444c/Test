package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;

public class TestFragment1 extends SupportFragment {

    public static TestFragment1 newInstance() {
        return new TestFragment1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_test1, container, false);
//        动态改动 当前Fragment的动画
//        setFragmentAnimator(fragmentAnimator);
        initEvent(view);
        return view;
    }

    private void initEvent(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(TestFragment2.newInstance());
            }
        });
    }
}
