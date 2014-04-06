package com.luxsyp.DirectionalPager.Activity;

import VerticalPager.VerticalViewPager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.luxsyp.DirectionalPager.Adapter.VerticalPagerAdapter;
import com.luxsyp.DirectionalPager.R;


public class HomeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.verticalviewpager);
        verticalViewPager.setAdapter(new VerticalPagerAdapter(getSupportFragmentManager()));
    }

}
