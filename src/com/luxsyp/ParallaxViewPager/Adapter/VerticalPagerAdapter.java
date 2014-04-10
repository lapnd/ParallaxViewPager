package com.luxsyp.ParallaxViewPager.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.luxsyp.ParallaxViewPager.Fragment.HalfSizedFragment;
import com.luxsyp.ParallaxViewPager.Fragment.VerticalFragment;

/**
 * Created with IntelliJ IDEA.
 * User: luxsypher
 * Date: 06/04/14
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class VerticalPagerAdapter extends FragmentPagerAdapter {
    private final static int    NB_FRAGMENT= 5;

    public VerticalPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if (position == NB_FRAGMENT - 1)
            return HalfSizedFragment.newInstance("Fragment[" + position + 1 + "]");
        return VerticalFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return NB_FRAGMENT;
    }

    @Override
    public float getPageWidth(int position) {
        if (position == NB_FRAGMENT -1)
            return (0.5f);
        return super.getPageWidth(position);
    }
}