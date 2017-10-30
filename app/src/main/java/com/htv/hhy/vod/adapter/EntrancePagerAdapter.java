package com.htv.hhy.vod.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */

public class EntrancePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public EntrancePagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public void addFragment(Fragment f) {
        fragmentList.add(f);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }
}
