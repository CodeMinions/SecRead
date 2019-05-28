package me.codeminions.secread.frags.Main;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import me.codeminions.common.Fragment;
import me.codeminions.common.adapter.FragmentAdapter;
import me.codeminions.common.app.Application;
import me.codeminions.factory.bean.db.User;
import me.codeminions.secread.R;

public class MeFragment extends Fragment implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private User user = Application.getCurrentUser();

    ViewPager viewPager;
    TabLayout tabLayout;

    CircleImageView btn_Draw;

    DrawerLayout draw;
    NavigationView navView;

    CollapsingToolbarLayout toolbarLayout;

    Button btn_edit;
    Button btn_add;
    TextView txt_UserId;
    TextView txt_signature;

    private String[] list = {"作品", "动态", "喜欢"};

    @Override
    protected void initWidget(View root) {

        super.initWidget(root);

        toolbarLayout = root.findViewById(R.id.collapse_me);
        viewPager = root.findViewById(R.id.vp_me);
        tabLayout = root.findViewById(R.id.tab_me);

        draw = root.findViewById(R.id.me_draw);
        navView = root.findViewById(R.id.nav_draw_msg);


        btn_Draw = root.findViewById(R.id.btn_me_draw);
        btn_Draw.setOnClickListener(this);

        btn_edit = root.findViewById(R.id.btn_me_edit);
        btn_edit.setOnClickListener(this);

        btn_add = root.findViewById(R.id.btn_me_add);
        btn_add.setOnClickListener(this);

        txt_UserId = root.findViewById(R.id.txt_me_userId);
        txt_signature = root.findViewById(R.id.txt_me_signature);


        navView.setNavigationItemSelectedListener(this);

        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), list) {
            @Override
            public Fragment getItem(int i) {
                return new IncreaseFragment();
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initData() {
        if (Application.getCurrentUser() == null)
            return;

        toolbarLayout.setTitle(user.getName());

        String id = getResources().getString(R.string.me_userId) + user.getId();
        txt_UserId.setText(id);

        if (user.getSignature() != null)
            if (user.getSignature().isEmpty())
                txt_signature.setText("填写个性签名更容易获得别人的关注哦～");
            else
                txt_signature.setText(user.getSignature());
    }


    @Override
    public int getContentId() {
        return R.layout.fragment_me;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_me_draw:
                draw.openDrawer(GravityCompat.END);
                break;
            case R.id.btn_me_edit:
                // 资料编辑
                break;
            case R.id.btn_me_add:
                // 添加文字
                break;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.draw_logout:
                Toast.makeText(mRoot.getContext(), "退出登录", Toast.LENGTH_SHORT).show();
                user = null;
                Application.setCurrentUser(null);
                initWidget(mRoot);
                break;
        }
        return true;
    }
}
