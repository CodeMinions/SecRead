package me.codeminions.secread;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import me.codeminions.common.adapter.RecyclerAdapter;
import me.codeminions.common.bean.SettingItem;
import me.codeminions.icontxtview.IconTxtView;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView account_listView;
    RecyclerView general_listView;
    RecyclerView wallet_listView;
    RecyclerView about_listView;

    Button btn_Back;

    List<SettingItem> account_list = new ArrayList<>();
    List<SettingItem> general_list = new ArrayList<>();
    List<SettingItem> wallet_list = new ArrayList<>();
    List<SettingItem> about_list = new ArrayList<>();

    RecyclerAdapter<SettingItem> adapterA;
    RecyclerAdapter<SettingItem> adapterG;
    RecyclerAdapter<SettingItem> adapterW;
    RecyclerAdapter<SettingItem> adapterB;

    public static void actionStart(Context context){
        context.startActivity(new Intent(context, SettingActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initWeiget();
        initData();
    }

    void initWeiget(){
        account_listView = findViewById(R.id.list_account);
        general_listView = findViewById(R.id.list_general);
        wallet_listView = findViewById(R.id.list_wallet);
        about_listView = findViewById(R.id.list_about);

        btn_Back = findViewById(R.id.btn_setting_back);

        account_listView.setLayoutManager(new LinearLayoutManager(this));
        general_listView.setLayoutManager(new LinearLayoutManager(this));
        wallet_listView.setLayoutManager(new LinearLayoutManager(this));
        about_listView.setLayoutManager(new LinearLayoutManager(this));

        adapterA = new SettingAdapter();
        adapterG = new SettingAdapter();
        adapterW = new SettingAdapter();
        adapterB = new SettingAdapter();
    }

    void initData(){
        initList();

        adapterA.setList(account_list);
        account_listView.setAdapter(adapterA);

        adapterG.setList(general_list);
        general_listView.setAdapter(adapterG);

        adapterW.setList(wallet_list);
        wallet_listView.setAdapter(adapterW);

        adapterB.setList(about_list);
        about_listView.setAdapter(adapterB);

        btn_Back.setOnClickListener(this);
    }

    void initList(){
        account_list.add(new SettingItem(R.drawable.ic_safe, "账号与安全", "系数100"));
        account_list.add(new SettingItem(R.drawable.ic_privacy, "隐私设置"));

        general_list.add(new SettingItem(R.drawable.ic_call, "通知设置"));
        general_list.add(new SettingItem(R.drawable.ic_setting, "通用设置"));

        wallet_list.add(new SettingItem(R.drawable.ic_shop, "书籍商城", "立即开通"));

        about_list.add(new SettingItem(R.drawable.ic_deal, "用户协议"));
        about_list.add(new SettingItem(R.drawable.ic_provacy_deal, "隐私政策"));
        about_list.add(new SettingItem(R.drawable.ic_tip, "关于秒阅"));
        about_list.add(new SettingItem(R.drawable.ic_feedback, "反馈与帮助"));
        about_list.add(new SettingItem(R.drawable.ic_home, "清理缓存", "7.73MB"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_setting_back:
                finish();
                break;
        }
    }

    class SettingAdapter extends RecyclerAdapter<SettingItem> {
        @Override
        public int getItemViewType(int position) {
            return R.layout.item_setting;
        }

        @Override
        public Hold onCreateViewHolder(View root, int resId) {
            return new Hold(root);
        }
    }

    class Hold extends RecyclerAdapter.MyHolder<SettingItem> {
        IconTxtView view_title;
        IconTxtView view_tip;

        Hold(View v){
            super(v);
            view_title = v.findViewById(R.id.icontxt_setting);
            view_tip = v.findViewById(R.id.icontxt_more);
        }

        @Override
        protected void onBind(SettingItem data) {
            int iconId = data.getIconResId();
            String title = data.getTitle();
            String tip = data.getTip();

            view_title.setText(title);
            view_title.setIcon(getDrawable(iconId));

            view_tip.setText(tip);
        }
    }
}
