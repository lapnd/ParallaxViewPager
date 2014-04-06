package com.luxsyp.DirectionalPager.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luxsypher
 * Date: 07/04/14
 * Time: 00:03
 * To change this template use File | Settings | File Templates.
 */
public class HorizontalPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public HorizontalPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}

