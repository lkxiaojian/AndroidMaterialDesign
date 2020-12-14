package com.androidmaterialdesign.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.androidmaterialdesign.R;
import com.androidmaterialdesign.adapter.FabRecycleViewAdapter;
import com.androidmaterialdesign.listener.FakeFabActionListner;
import com.androidmaterialdesign.listener.FakeFabScrollListener;

import java.util.ArrayList;
import java.util.List;

public class Fab_RecycleViewActivity extends AppCompatActivity implements FakeFabActionListner{

    private List<String> mData = new ArrayList<>();
    private Toolbar mToolbar;
    private RecyclerView mRv;

    private int mToolbarBottomMargin;
    private int mFabBottomMargin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab__recycle_view);
        for (int i=0;i<50;i++){
            mData.add("android"+i);
        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mToolbarBottomMargin = ((ViewGroup.MarginLayoutParams) mToolbar.getLayoutParams()).bottomMargin;


        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(new FabRecycleViewAdapter(mData));
        mRv.addOnScrollListener(new FakeFabScrollListener(this));


    }

    @Override
    public void hide() {
//        mRv.setPadding(0,0,0,0);
        mToolbar.animate().translationY(-(mToolbar.getHeight() + mToolbarBottomMargin)).setInterpolator(new AccelerateInterpolator(3));

    }

    @Override
    public void show() {
//        mRv.setPadding(0,600,0,0);
        mToolbar.animate().translationY(0).setInterpolator(new AccelerateInterpolator(3));
    }
}
