package com.luxsyp.ParallaxViewPager.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created with IntelliJ IDEA.
 * User: damienlocque
 * Date: 2014-03-19
 * Time: 18:35
 * To change this template use File | Settings | File Templates.
 */
public class DisplayUtil {
    private static final String TAG = "com.gofindit.Util.DisplayUtil";

    private static DisplayUtil  instance;
    private Context _context;
    private WindowManager _windowManager;
    private Display _display;
    private DisplayMetrics _displaymetrics;

    // private _ctor
    private DisplayUtil() {}
    public void initDisplay(Context context)
    {
        Log.d(TAG, "Initializing DisplayUtil");
        _context = context;
        _windowManager = (WindowManager) _context.getSystemService(Context.WINDOW_SERVICE);
        _display = _windowManager.getDefaultDisplay();
        _displaymetrics = context.getResources().getDisplayMetrics();
        _display.getMetrics(_displaymetrics);
    }

    public static DisplayUtil getInstance()
    {
        if (instance == null)
            instance = new DisplayUtil();
        return instance;
    }

    public DisplayMetrics getDisplayMetrics()
    {
        return _displaymetrics;
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public int getScreenHeight() {
        if (_windowManager != null)
        {
            Display display = _windowManager.getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                Point size = new Point();
                display.getSize(size);
                return size.y;
            }
            return display.getHeight();
        }
        return 0;
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public int getScreenWidth() {
        if (_windowManager != null)
        {
            Display display = _windowManager.getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                Point size = new Point();
                display.getSize(size);
                return size.x;
            }
            return display.getWidth();
        }
        return 0;
    }

}
