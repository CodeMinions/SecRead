package me.codeminions.secread;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import me.codeminions.secread.frags.Main.AttentFragment;
import me.codeminions.secread.frags.Main.HomeFragment;
import me.codeminions.secread.frags.Main.IncreaseFragment;
import me.codeminions.secread.frags.Main.MeFragment;
import me.codeminions.secread.helper.NavHelper;

public class Main2Activity extends AppCompatActivity implements NavHelper.OnTabChangeListen, BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navigation;
    NavHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        navigation = findViewById(R.id.bottomview);

        helper = new NavHelper(this, R.id.lay_container, getSupportFragmentManager(), this);
        helper.add(R.id.nav_home, new NavHelper.Tab(HomeFragment.class))
                .add(R.id.nav_attent, new NavHelper.Tab(AttentFragment.class))
                .add(R.id.nav_increase, new NavHelper.Tab(IncreaseFragment.class))
                .add(R.id.nav_msg, new NavHelper.Tab(HomeFragment.class))
                .add(R.id.nav_me, new NavHelper.Tab(MeFragment.class));

        navigation.setOnNavigationItemSelectedListener(this);

        initData();
    }

    void initData(){
        Menu m = navigation.getMenu();
        m.performIdentifierAction(R.id.nav_increase, 3);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return helper.performClickMenu(menuItem.getItemId());
    }

    @Override
    public void onTabChange(NavHelper.Tab newF, NavHelper.Tab oldF) {

    }
}
