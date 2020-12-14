package com.androidmaterialdesign.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.androidmaterialdesign.R;
import com.androidmaterialdesign.adapter.MyFragmentStatePagerAdapter;

import butterknife.ButterKnife;

public class AMtabActivity extends AppCompatActivity {


    /**
     * 替换活动条的工具条
     */
    private Toolbar toolbar;

    /**
     * 选型卡布局
     */
    private TabLayout tabLayout;

    private ViewPager viewPager;
    /**
     * 能够折叠工具条的布局
     */
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String[] tabTitle = {"第一页面", "第二页面", "第三页面"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amtab_2);
        ButterKnife.bind(this);


        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);

        initToolbar();

        initData();


    }

    private void initData() {

        for (int i = 0; i < tabTitle.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabTitle[i]));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
//        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#7CCD7C"));
        tabLayout.setTabTextColors(Color.GRAY, Color.parseColor("#FF4081"));


        viewPager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager(), tabTitle));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }



    /**
     * 对Toolbar与折叠Toobar布局进行设置
     */
    private void initToolbar() {
        //也可以在布局中设置这些属性,具体见布局文件
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置最左侧图标
        //toolbar.setLogo(R.mipmap.ic_launcher);//设置程序logo图标
        toolbar.setTitle("toolbar标题");
        //toolbar.setSubtitle("子标题");
        toolbar.setTitleTextColor(Color.parseColor("#000000"));//设置标题的字体颜色
        //toolbar.setSubtitleTextColor(Color.parseColor("#00ff00"));//设置子标题的字体颜色
        setSupportActionBar(toolbar); //取代原本的actionbar,继承activity可以不设置,不替换显示不了菜单
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按钮的图标
        //单击事件需要在setSupportActionBar方法后,因为原本的actionbar也有这个单击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AMtabActivity.this, "点击了最左边的图标", Toast.LENGTH_SHORT).show();
            }
        });

        //对折叠布局的设置
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置折叠布局扩张时的标题颜色
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);//设置折叠布局收缩时的标题颜色
        collapsingToolbarLayout.setTitle("在折叠中设置的标题");//这样就会把toolbar的标题覆盖掉
    }





}