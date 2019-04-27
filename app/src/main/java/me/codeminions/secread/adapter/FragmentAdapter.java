package me.codeminions.secread.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.codeminions.secread.frags.Home.HotListFrament;
import me.codeminions.secread.frags.Home.RecommendFragment;

// 可清除
public class FragmentAdapter extends FragmentPagerAdapter {

    private String[] titles = {"推荐", "热榜"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new RecommendFragment();
            case 1:
                return new HotListFrament();
            default:
                return new RecommendFragment();
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
