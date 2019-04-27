package me.codeminions.common.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class HorizontalViewPager extends ViewPager {

    float downX;
    float downY;
    float touchSlop;

    public HorizontalViewPager(@NonNull Context context) {
        this(context, null);
    }

    public HorizontalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTouchSlop(context);
    }

    void setTouchSlop(Context context){
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        boolean intercept =  super.onInterceptHoverEvent(event);
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX = x;
                downY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - downX);
                float dy = Math.abs(y - downY);
                if(!intercept && dx > touchSlop && dy < dx*0.5f)
                    intercept = true;
                break;
            default:
                break;
        }
        return intercept;
    }
}
