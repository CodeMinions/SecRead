package me.codeminions.secread.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.codeminions.icontxtview.IconTxtView;
import me.codeminions.secread.R;
import me.codeminions.secread.frags.Main.AttentFragment;
import me.codeminions.secread.frags.Main.HomeFragment;
import me.codeminions.secread.frags.Main.IncreaseFragment;
import me.codeminions.secread.frags.Main.MeFragment;
import me.codeminions.secread.frags.Main.MsgFragment;

public class BottomPagerAdapter extends FragmentPagerAdapter {

    private String[] title = {"首页", "关注", "新建", "消息", "个人"};

    private List<View> tabViewList = new ArrayList<>();

    protected int[] icon = {R.drawable.ic_home,
            R.drawable.ic_attent,
            R.drawable.ic_add,
            R.drawable.ic_msg,
            R.drawable.ic_me};

    private Context context;

    public BottomPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;

        for(int i = 0; i < 5; i++){
            IconTxtView iconTxtView = new IconTxtView(context);
            iconTxtView.setText(title[i]);
            iconTxtView.setTextSize(14);
            iconTxtView.setTint(ContextCompat.getColor(context, R.color.colorAccent));
            tabViewList.add(iconTxtView);
        }
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
            case 4:
                return new MeFragment();
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
    // 其实由于手动设置了tab的View，所以这个方法不是一定要被实现了
    public CharSequence getPageTitle(int position) {
        return title[position];
    }


    public View getTabView(int position) {
        return tabViewList.get(position);
    }

//    public View getTabView() {
//
//        ImageView image = new ImageView(context);
//        image.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_add));
//        image.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent));
//
//        return image;
//    }

}
