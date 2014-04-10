package com.luxsyp.ParallaxViewPager.Fragment;

import android.view.View;
import android.support.v4.app.Fragment;
import com.luxsyp.ParallaxViewPager.Util.DisplayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: damienlocque
 * Date: 2014-03-31
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */
public class ParallaxFragment extends Fragment {
    private static final String TAG = "com.gofindit.hal.Fragment.ParralaxFragment";

    private HashMap<View, ParallaxInfo> _mapView = null;

    public void addViewToParallax(final View view, int xPosition, float speed)
    {
        if (_mapView == null)
            _mapView = new HashMap<View, ParallaxInfo>();

        if (!_mapView.containsKey(view))
        {
            ParallaxInfo info = new ParallaxInfo();
            info.xPosition = xPosition;
            info.speed = speed;
            _mapView.put(view, info);
        }
    }

    public void resetParallaxViews()
    {
        if (_mapView != null)
            _mapView.clear();
    }

    private class ParallaxInfo {
        public      int     xPosition;
        public      float   speed;
    }

    public void applyParallaxOnItems(boolean direction, float offset, int offsetPixels, int screenOffset) {
        if (!direction && offset > 0.0) // swipe right to left
        {
            if (_mapView != null)
            {
                for (Map.Entry<View, ParallaxInfo> entry : _mapView.entrySet())
                {
                    View view = entry.getKey();
                    ParallaxInfo info= entry.getValue();
                    view.setX((info.xPosition - offsetPixels * info.speed ) + screenOffset * info.speed);
                }
            }
        }
        else if (direction && offset > 0.0) // swipe left to right
        {
            if (_mapView != null)
            {
                if (_mapView != null)
                {
                    for (Map.Entry<View, ParallaxInfo> entry : _mapView.entrySet())
                    {
                        View view = entry.getKey();
                        ParallaxInfo info= entry.getValue();
                        view.setX((info.xPosition + (DisplayUtil.getInstance().getScreenWidth() - offsetPixels) * info.speed) - screenOffset * info.speed);
                    }
                }
            }
        }
        else if (offset == 0.0)
        {
            if (_mapView != null)
            {
                for (Map.Entry<View, ParallaxInfo> entry : _mapView.entrySet())
                {
                    View view = entry.getKey();
                    ParallaxInfo info= entry.getValue();
                    view.setX(info.xPosition);
                }
            }
        }
    }

}
