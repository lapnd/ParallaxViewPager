package com.luxsyp.ParallaxViewPager.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.luxsyp.ParallaxViewPager.R;

/**
 * Created with IntelliJ IDEA.
 * User: luxsypher
 * Date: 07/04/14
 * Time: 00:04
 * To change this template use File | Settings | File Templates.
 */
public class HorizontalFragment extends ParallaxFragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final HorizontalFragment newInstance(String message) {
        HorizontalFragment f = new HorizontalFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.horizontal_fragment_layout, container, false);

        // register view for Parralax
        final TextView messageTextView = (TextView) v.findViewById(R.id.textView);
        messageTextView.setText(message);
        messageTextView.post(new Runnable() {
            @Override
            public void run() {
               addViewToParallax(messageTextView, (int) messageTextView.getX(), 1.5f);
            }
        });

        // register view for Parralax
        final TextView textView2 = (TextView) v.findViewById(R.id.textView2);
        textView2.setText("To infinite and beyond");
        textView2.post(new Runnable() {
            @Override
            public void run() {
                addViewToParallax(textView2, (int) textView2.getX(), 0.5f);
            }
        });

        return v;
    }
}
