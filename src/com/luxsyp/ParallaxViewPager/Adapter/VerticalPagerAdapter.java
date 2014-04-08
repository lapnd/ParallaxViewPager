package com.luxsyp.ParallaxViewPager.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.luxsyp.ParallaxViewPager.Fragment.VerticalFragment;

/**
 * Created with IntelliJ IDEA.
 * User: luxsypher
 * Date: 06/04/14
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
public class VerticalPagerAdapter extends FragmentPagerAdapter {

    public VerticalPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return VerticalFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}