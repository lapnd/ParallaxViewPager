package com.luxsyp.DirectionalPager.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.luxsyp.DirectionalPager.Adapter.HorizontalPagerAdapter;
import com.luxsyp.DirectionalPager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luxsypher
 * Date: 06/04/14
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class VerticalFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

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

        HorizontalPagerAdapter pageAdapter;
        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(HorizontalFragment.newInstance("Fragment 1"));
        fList.add(HorizontalFragment.newInstance("Fragment 2"));
        fList.add(HorizontalFragment.newInstance("Fragment 3"));

        pageAdapter = new HorizontalPagerAdapter(getChildFragmentManager(), fList);
        ViewPager pager = (ViewPager)rootView.findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);

        return rootView;
    }


}