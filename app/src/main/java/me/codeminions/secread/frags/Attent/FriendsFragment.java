package me.codeminions.secread.frags.Attent;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.codeminions.common.Fragment;
import me.codeminions.common.adapter.RecyclerAdapter;
import me.codeminions.secread.R;
import me.codeminions.secread.view.SpacesItemDecoration;

public class FriendsFragment extends Fragment {

    RecyclerView listView;
    RecyclerAdapter<String> adapter;
    List<String> list;

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        init();
        listView = root.findViewById(R.id.list_friendspace);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.addItemDecoration(new SpacesItemDecoration(2));

        adapter = new RecyclerAdapter<String>() {
            @Override
            public int getItemViewType(int position) {
                    return R.layout.item_friendlist;
            }

            @Override
            public MyHolder<String> onCreateViewHolder(View root, int resId) {
                return new ViewHolder(root);
            }
        };
        adapter.setList(list);
        listView.setAdapter(adapter);
    }

    @Override
    public int getContentId() {
        return R.layout.fragment_friends;
    }

    class ViewHolder extends RecyclerAdapter.MyHolder<String>{
        TextView textView;
        ViewHolder(View v){
            super(v);
            textView = v.findViewById(R.id.txt_usespace);
        }

        @Override
        protected void onBind(String data) {
            textView.setText(data);
        }
    }

    void init(){
        list = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            list.add("我失去了一只臂膀，就睁开了一只眼睛。");
        }
    }
}
