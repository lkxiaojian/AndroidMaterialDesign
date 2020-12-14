package com.androidmaterialdesign.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidmaterialdesign.R;
import com.androidmaterialdesign.view.MyTextWatch;

public class TextInputLayout extends AppCompatActivity {
    private android.support.design.widget.TextInputLayout mTextInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        mTextInputLayout = (android.support.design.widget.TextInputLayout) findViewById(R.id.textInputLayout);

        //开启计数
        mTextInputLayout.setCounterEnabled(true);
        mTextInputLayout.setCounterMaxLength(6);

        //定义错误提示
        mTextInputLayout.getEditText().addTextChangedListener(new MyTextWatch(mTextInputLayout, "长度不能超过6个字符"));
    }

}
