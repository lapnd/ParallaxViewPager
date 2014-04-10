package com.luxsyp.ParallaxViewPager.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.luxsyp.ParallaxViewPager.Adapter.HorizontalPagerAdapter;
import com.luxsyp.ParallaxViewPager.R;
import com.luxsyp.ParallaxViewPager.Util.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luxsypher
 * Date: 06/04/14
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class VerticalFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private ViewPager                   _viewPager;
    private HorizontalPagerAdapter      _pageAdapter;

    public static VerticalFragment newInstance(int sectionNumber) {
        VerticalFragment fragment = new VerticalFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public VerticalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vertical_fragment_layout, container, false);

        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(HorizontalFragment.newInstance("Fragment 1"));
        fList.add(HorizontalFragment.newInstance("Fragment 2"));
        fList.add(HorizontalFragment.newInstance("Fragment 3"));

        _pageAdapter = new HorizontalPagerAdapter(getChildFragmentManager(), fList);
        _viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        _viewPager.setAdapter(_pageAdapter);

        _viewPager.setOnPageChangeListener(this);

        return rootView;
    }

    // Fragment current - left - right for Parallax effect
    private ParallaxFragment            leftFrag;
    private ParallaxFragment            currentFrag;
    private ParallaxFragment            rightFrag;

    private void setFragments()
    {
        int current = _viewPager.getCurrentItem();
        if (current == 0)
            leftFrag = null;
        else
            leftFrag = (ParallaxFragment) getChildFragmentManager().getFragments().get(current - 1);
        if ((_viewPager.getCurrentItem() + 1) == _pageAdapter.getCount())
            rightFrag = null;
        else if (getChildFragmentManager().getFragments().size() > current + 1)
            rightFrag = (ParallaxFragment) getChildFragmentManager().getFragments().get(current + 1);
        if (getChildFragmentManager().getFragments().size() > current)
            currentFrag = (ParallaxFragment) getChildFragmentManager().getFragments().get(current);
    }

    @Override
    public void onPageScrolled(int position, float offset, int offsetPixels) {
        setFragments();
        // Parralax stuff
        if (position == _viewPager.getCurrentItem() && offset > 0) // Move right
        {
            currentFrag.applyParallaxOnItems(false, offset, offsetPixels, 0);
            if (rightFrag != null)
                rightFrag.applyParallaxOnItems(false, offset, offsetPixels, DisplayUtil.getInstance().getScreenWidth());
        }
        if (position < _viewPager.getCurrentItem() && offset > 0) // move left
        {
            currentFrag.applyParallaxOnItems(true, offset, offsetPixels, 0);
            if (leftFrag != null)
                leftFrag.applyParallaxOnItems(true, offset, offsetPixels, DisplayUtil.getInstance().getScreenWidth());
        }
    }

    @Override
    public void onPageSelected(int position) { }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state)
        {
            case ViewPager.SCROLL_STATE_IDLE:
                if (currentFrag != null)
                    currentFrag.applyParallaxOnItems(false, 0, 0, 0);
                break;

            case ViewPager.SCROLL_STATE_DRAGGING:
                break;
        }

    }

}