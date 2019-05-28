package me.codeminions.secread.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import me.codeminions.common.app.Application;
import me.codeminions.common.view.UnScrollViewPager;
import me.codeminions.icontxtview.IconTxtView;
import me.codeminions.secread.R;
import me.codeminions.secread.adapter.BottomPagerAdapter;

public class MainActivity extends AppCompatActivity {

    UnScrollViewPager viewPager;
    TabLayout tabLayout;

    BottomPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
    }

    void initWidget() {
        viewPager = findViewById(R.id.lay_container);
        tabLayout = findViewById(R.id.tab_bottomNav);

        adapter = new BottomPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(onPageChangeListener);


        for (int i = 0; i < adapter.getCount(); i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setCustomView(adapter.getTabView(i));
            if (tab.getCustomView() != null) {
                View tabView = (View) tab.getCustomView().getParent();
                tabView.setTag(i);
                tabView.setOnClickListener(tabListener);
            }
            tabLayout.addTab(tab, i);
        }
        setTabSelected(tabLayout.getTabAt(0), 0, true);

    }

    View.OnClickListener tabListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            int pos = (int) v.getTag();
            if (Application.getCurrentUser() == null && pos != 0) {
                Log.i("登录检测", "未登录");
//                viewPager.setCurrentItem(0);

//                new AlertDialog.Builder(MainActivity.this)
//                        .setMessage("你还未登录，立即登录？").setTitle("提示").show();

                LoginActivity.startAction(MainActivity.this);
            } else {
                Log.i("登录检测", "已登录");
                TabLayout.Tab tab = tabLayout.getTabAt(pos);
                if (tab != null) {
                    tab.select();
                }
                viewPager.setCurrentItem(pos);
            }
        }
    };

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int p) {

            setTabSelected(tabLayout.getTabAt(p), p, true);
            int count = tabLayout.getTabCount();
            for (int i = 0; i < count; i++) {
                if (i != p) {
                    setTabSelected(tabLayout.getTabAt(i), i, false);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void setTabSelected(TabLayout.Tab tabAt, int position, boolean b) {
        IconTxtView view = ((IconTxtView) tabAt.getCustomView());

        if (view != null)
            if (b)
                view.setTint(Color.RED);
            else
                view.setTint(ContextCompat.getColor(this, R.color.colorAccent));
    }
}
