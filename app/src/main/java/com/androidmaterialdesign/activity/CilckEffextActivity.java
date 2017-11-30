package com.androidmaterialdesign.activity;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.androidmaterialdesign.R;

public class CilckEffextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            Toast.makeText(getApplicationContext(), "版本必须是5.0以上", Toast.LENGTH_SHORT).show();
            return;
        }
        setContentView(R.layout.activity_cilck_effext);
        button();
        revealEffect();
    }

    private void button() {

        /**
         * Android5.0以上，默认按钮就有水波纹效果。
         * 如果需要让人其他控件也有水波纹效果，可以设置控件的backgroun为?attr/selectableItemBackground（方形）或?attr/selectableItemBackgroundBorderless（圆形）。
         * 一旦其他控件设置了水波纹效果，则background则被占用，如果需要修改控件的水波纹颜色，则需要在style.xml中设置Activity的样式主题两个不同的属性：
         *      <item name="colorButtonNormal">#fff</item> 未点击时颜色
         *      <item name="colorControlHighlight">#D33A31</item> 点击时颜色
         */
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void revealEffect() {
        final Button btnReveal1 = (Button) findViewById(R.id.btn_reveal_1);
        btnReveal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(btnReveal1, btnReveal1.getWidth() / 2, btnReveal1.getHeight() / 2, 0, (float) Math.hypot(btnReveal1.getWidth(), btnReveal1.getHeight()));
                circularReveal.setDuration(1000);
                circularReveal.setInterpolator(new AccelerateInterpolator());
                circularReveal.start();
            }
        });

        final Button btnReveal2 = (Button) findViewById(R.id.btn_reveal_2);
        btnReveal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(btnReveal2, 0, 0, 0, (float) Math.hypot(btnReveal2.getWidth(), btnReveal2.getHeight()));
                circularReveal.setDuration(1000);
                circularReveal.setInterpolator(new AccelerateInterpolator());
                circularReveal.start();
            }
        });
    }
}
