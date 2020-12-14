package com.androidmaterialdesign.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidmaterialdesign.R;

public class AMTabViewActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amtab_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        initTabLayout();
        viewPager.setAdapter(new MyAdapter());
    }


    /**
     * 初始化选项卡的数据
     */
    private void initTabLayout() {
        for (int i = 0; i < 10; i++) {
            tabLayout.addTab(tabLayout.newTab().setText("卡片" + i));//添加选项
        }
        //选项卡的切换监听,都在主线程中运行的
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("tag", "点击的第" + tab.getPosition() + "个卡片");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.i("tag", "取消了第" + tab.getPosition() + "个卡片的显示");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //当前选中的选项被再次点击的时候调用
                Log.i("tag", "第" + tab.getPosition() + "个卡片重新被点击");
            }
        });
        //将标题头与ViewPager进行绑定
        tabLayout.setupWithViewPager(viewPager);
    }


    /**
     * ViewPager适配器,这里写几个死数据了
     */
    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(AMTabViewActivity.this);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            textView.setText("Pager - " + position);
            container.addView(textView);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //tabLayout.getTabAt(position)会为空
            return "tab - " + position;//返回标题头对应的标题
        }
    }
}
