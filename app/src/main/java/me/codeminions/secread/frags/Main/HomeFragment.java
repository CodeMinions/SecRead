package me.codeminions.secread.frags.Main;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import me.codeminions.common.Fragment;
import me.codeminions.common.adapter.FragmentAdapter;
import me.codeminions.secread.R;
import me.codeminions.common.view.HorizontalViewPager;
import me.codeminions.secread.frags.Home.HotListFrament;
import me.codeminions.secread.frags.Home.RecommendFragment;

public class HomeFragment extends Fragment {

    HorizontalViewPager viewPager;
    FragmentAdapter adapter;
    TabLayout tabLayout;
    ActionMenuView menuView;

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        menuView = root.findViewById(R.id.tab_menu);

        initToolbar((Toolbar) root.findViewById(R.id.bar_home));

        viewPager = root.findViewById(R.id.pager_home);
        tabLayout = root.findViewById(R.id.tab_home);
        adapter = new FragmentAdapter(getChildFragmentManager(), new String[]{"推荐", "热榜"}) {
            @Override
            public android.support.v4.app.Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return new RecommendFragment();
                    case 1:
                        return new HotListFrament();
                    default:
                        return new RecommendFragment();
                }
            }
        };

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(0);

    }

    @Override
    public int getContentId() {
        return R.layout.fragment_homepage;
    }

    /**
     * Fragment中初始化Toolbar
     */
    public void initToolbar(Toolbar toolbar) {
        AppCompatActivity activity= (AppCompatActivity) getActivity();
        if (activity != null){
            activity.getMenuInflater().inflate(R.menu.tab_menu, menuView.getMenu());
            activity.setSupportActionBar(toolbar);
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowTitleEnabled(false);
            }
        }
    }
}
