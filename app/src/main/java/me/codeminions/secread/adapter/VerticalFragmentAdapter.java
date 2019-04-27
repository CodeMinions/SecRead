package me.codeminions.secread.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.codeminions.common.Fragment;
import me.codeminions.secread.frags.ArticleFragment;

//可清除
public class VerticalFragmentAdapter extends FragmentPagerAdapter {
    private String[] data;

    public VerticalFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public VerticalFragmentAdapter(FragmentManager fm, String[] data) {
        this(fm);
        this.data = data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    @Override
    public Fragment getItem(final int i) {

        final ArticleFragment currentFrag = new ArticleFragment();

        currentFrag.setOnInitContent(new ArticleFragment.OnInitContent() {
            @Override
            public void onInitContent() {
                currentFrag.setText(data[i]);
            }
        });
        return currentFrag;

    }

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
