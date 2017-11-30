package com.androidmaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.androidmaterialdesign.activity.AMTabViewActivity;
import com.androidmaterialdesign.activity.AMtabActivity;
import com.androidmaterialdesign.activity.CilckEffextActivity;
import com.androidmaterialdesign.activity.Fab_RecycleViewActivity;
import com.androidmaterialdesign.activity.ScroViewNoTitleActivity;
import com.androidmaterialdesign.activity.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_ANtab)
    Button tvANtab;
    @BindView(R.id.tv_ANtab1)
    Button tvANtab1;
    @BindView(R.id.bt_scroviewnotitle)
    Button btScroviewnotitle;
    @BindView(R.id.bt_TextInputLayout)
    Button btTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_ANtab, R.id.tv_ANtab1, R.id.bt_scroviewnotitle,R.id.bt_TextInputLayout,R.id.bt_clickeffect,R.id.bt_fab_recycleview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_ANtab:

                startActivity(new Intent(MainActivity.this, AMtabActivity.class));


                break;
            case R.id.tv_ANtab1:

                startActivity(new Intent(MainActivity.this, AMTabViewActivity.class));
                break;


            case R.id.bt_scroviewnotitle:

                startActivity(new Intent(MainActivity.this, ScroViewNoTitleActivity.class));
                break;
            case R.id.bt_TextInputLayout:

                startActivity(new Intent(MainActivity.this, TextInputLayout.class));
                break;
            case R.id.bt_clickeffect:

                startActivity(new Intent(MainActivity.this, CilckEffextActivity.class));
                break;
            case R.id.bt_fab_recycleview:

                startActivity(new Intent(MainActivity.this, Fab_RecycleViewActivity.class));
                break;
        }
    }


}
