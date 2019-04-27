package me.codeminions.secread;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import me.codeminions.common.view.UnScrollViewPager;
import me.codeminions.icontxtview.IconTxtView;
import me.codeminions.secread.adapter.BottomPagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    UnScrollViewPager viewPager;
    TabLayout tabLayout;

    BottomPagerAdapter adapter;
    DrawerLayout layout;

    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
    }

    void initWidget() {
        viewPager = findViewById(R.id.lay_container);
        tabLayout = findViewById(R.id.tab_bottomNav);
        layout = findViewById(R.id.drawer_setting);
        navView = findViewById(R.id.nav_draw_msg);

        adapter = new BottomPagerAdapter(this, getSupportFragmentManager());

        layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(2).setCustomView(adapter.getTabView());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 4) {
                    viewPager.setCurrentItem(3);
                    layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                    layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                } else {
                    layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                SettingActivity.actionStart(MainActivity.this);
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_me_setting:
                SettingActivity.actionStart(MainActivity.this);
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
