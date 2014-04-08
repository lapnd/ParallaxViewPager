package com.luxsyp.ParallaxViewPager.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.luxsyp.ParallaxViewPager.R;
import com.luxsyp.ParallaxViewPager.Adapter.VerticalPagerAdapter;
import com.luxsyp.ParallaxViewPager.Util.DisplayUtil;
import com.luxsyp.ParallaxViewPager.VerticalPager.VerticalViewPager;


public class HomeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialization
        DisplayUtil.getInstance().initDisplay(getApplicationContext());

        setContentView(R.layout.main_activity_layout);
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.verticalviewpager);
        verticalViewPager.setAdapter(new VerticalPagerAdapter(getSupportFragmentManager()));
    }

}
