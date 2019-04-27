package me.codeminions.common.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public abstract class FragmentAdapter extends FragmentPagerAdapter {
    protected String[] data;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(FragmentManager fm, String[] data) {
        this(fm);
        this.data = data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getDataItem(int p){
        return data[p];
    }

    @Override
    abstract public Fragment getItem(int i);

    @Override
    public int getCount() {
        return data.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data[position];
    }
}
