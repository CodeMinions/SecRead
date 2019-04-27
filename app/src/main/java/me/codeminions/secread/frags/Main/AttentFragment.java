package me.codeminions.secread.frags.Main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import me.codeminions.common.Fragment;
import me.codeminions.common.adapter.FragmentAdapter;
import me.codeminions.secread.R;
import me.codeminions.secread.frags.Attent.FriendsFragment;

public class AttentFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    FragmentAdapter adapter;

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        viewPager = root.findViewById(R.id.pager_att);
        tabLayout = root.findViewById(R.id.tab_att);

        adapter = new FragmentAdapter(getChildFragmentManager(), new String[]{"好友", "关注"}) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return new FriendsFragment();
                    case 1:
                        return new FriendsFragment();
                }
                return new FriendsFragment();
            }
        };

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public int getContentId() {
        return R.layout.fragment_attent;
    }
}
