package me.codeminions.secread.frags.Main;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import me.codeminions.common.Fragment;
import me.codeminions.icontxtview.IconTxtView;
import me.codeminions.secread.R;
import me.codeminions.secread.SettingActivity;

public class MeFragment extends Fragment implements View.OnClickListener {

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        FrameLayout layout = root.findViewById(R.id.item_me_setting);
        IconTxtView view = layout.findViewById(R.id.icontxt_setting);

        view.setText("设置");
        layout.setOnClickListener(this);
    }

    @Override
    public int getContentId() {
        return R.layout.fragment_me;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_me_setting:
                SettingActivity.actionStart(mRoot.getContext());
                Toast.makeText(mRoot.getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
