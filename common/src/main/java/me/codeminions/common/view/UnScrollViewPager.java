package me.codeminions.common.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 设置一个不能滑动的ViewPager
 */
public class UnScrollViewPager extends ViewPager {

    boolean scrollable = false;

    public UnScrollViewPager(@NonNull Context context) {
        this(context, null);
    }

    public UnScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }

    // 不拦截事件，即传到子控件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return scrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return scrollable;
    }
}
