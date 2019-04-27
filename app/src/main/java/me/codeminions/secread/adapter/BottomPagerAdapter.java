package me.codeminions.secread.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import me.codeminions.secread.R;
import me.codeminions.secread.frags.Main.AttentFragment;
import me.codeminions.secread.frags.Main.HomeFragment;
import me.codeminions.secread.frags.Main.IncreaseFragment;
import me.codeminions.secread.frags.Main.MsgFragment;

public class BottomPagerAdapter extends FragmentPagerAdapter {

    protected String[] title = {"首页", "关注", "新建", "消息", "个人"};
    protected int[] icon = { R.drawable.ic_home,
            R.drawable.ic_atten,
            R.drawable.ic_add,
            R.drawable.ic_msg,
            R.drawable.ic_me };

    private Context context;

    public BottomPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        if (position == 4)
            position = 3;
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new HomeFragment();
            case 1:
                return new AttentFragment();
            case 2:
                return new IncreaseFragment();
            case 3:
                return new MsgFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    public View getTabView() {

        ImageView image = new ImageView(context);
        image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_add));
        image.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent));



        return image;
    }


}
