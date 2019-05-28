package me.codeminions.secread.frags.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.codeminions.common.Fragment;
import me.codeminions.common.adapter.RecyclerAdapter;
import me.codeminions.common.app.Application;
import me.codeminions.factory.bean.db.User;
import me.codeminions.secread.R;

public class MsgFragment extends Fragment {

    RecyclerView recyclerView;
    List<User> userList;

    @Override
    public int getContentId() {
        return R.layout.fragment_msg;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        recyclerView = root.findViewById(R.id.list_msg_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
    }

    @Override
    protected void initData() {

        userList = new ArrayList<>();
        initList();

        recyclerView.setAdapter(new RecyclerAdapter<User>(userList) {
            @Override
            public int getItemViewType(int position) {
                return R.layout.item_msglist;
            }

            @Override
            public MsgHolder onCreateViewHolder(View root, int resId) {
                return new MsgHolder(root);
            }
        });
    }

    class MsgHolder extends RecyclerAdapter.MyHolder<User> {

        TextView tv_name;
        TextView tv_signature;

        MsgHolder(View v){
            super(v);

            tv_name = v.findViewById(R.id.txt_msg_name);
            tv_signature = v.findViewById(R.id.txt_msg_signature);
        }

        @Override
        protected void onBind(User data) {
            tv_name.setText(data.getName());
            tv_signature.setText(data.getSignature());
        }
    }

        void initList(){
        userList.add(new User("消息助手", "小助手图书馆"));
        userList.add(new User("雨声", "开始聊天"));
        userList.add(new User("阿屎", "开始聊天"));
        userList.add(new User("紫皮糖", "开始聊天"));
        userList.add(new User("大雅", "开始聊天"));
        userList.add(new User("鸡鸣", "开始聊天"));
        userList.add(new User("柏舟", "开始聊天"));
        userList.add(new User("昊天", "开始聊天"));
    }
}
