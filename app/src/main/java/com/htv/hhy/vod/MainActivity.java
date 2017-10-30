package com.htv.hhy.vod;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.htv.hhy.vod.adapter.EntrancePagerAdapter;
import com.htv.hhy.vod.adapter.PlayListAdapter;
import com.htv.hhy.vod.fragment.HotFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ListView mListView;
    private List<String> names = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    public static int pageCurrent;
    private Context mContext;
    private PlayListAdapter mAdapter;
    private ViewPager mViewPager;
    private LinearLayout back_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        loadNames();
        loadFragment();
        initView();
        inject();

    }

    private void loadFragment() {
        Fragment hot1 = new HotFragment();
        Fragment hot2 = new HotFragment();
        Fragment hot3 = new HotFragment();
        fragments.add(hot1);
        fragments.add(hot2);
        fragments.add(hot3);
    }

    private void initView() {
        back_layout = (LinearLayout) findViewById(R.id.back_layout);

        mViewPager = (ViewPager) findViewById(R.id.entrance_view_pager);
        mViewPager.setAdapter(new EntrancePagerAdapter(getSupportFragmentManager(),fragments));
        mListView = (ListView) findViewById(R.id.movie_list_view);
        mListView.requestFocus();
        mAdapter = new PlayListAdapter(names, mContext);
        mListView.setAdapter(mAdapter);
    }

    private void inject() {
        back_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageCurrent = position;
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pageCurrent = position;
                mAdapter.notifyDataSetChanged();
                mViewPager.setCurrentItem(pageCurrent);

            }
        });
    }

    private void loadNames() {
        for (int i = 0; i < 3; i++) {
            names.add("热门推荐"+i);
        }
    }

    /**
     * 强制横屏
     */
    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

}
