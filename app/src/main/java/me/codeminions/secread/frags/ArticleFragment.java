package me.codeminions.secread.frags;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.codeminions.common.Fragment;
import me.codeminions.secread.R;

// TODO: 19-4-13 显示一屏，点击进入详情，查看全部 
public class ArticleFragment extends Fragment {

    TextView textView;
    OnInitContent onInitContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        onInitContent.onInitContent();
        return view;
    }

    public void setOnInitContent(OnInitContent onInitContent) {
        this.onInitContent = onInitContent;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        textView = root.findViewById(R.id.txt_article);
    }

    public void setText(String txt) {
        textView.setText(txt);
    }

    @Override
    public int getContentId() {
        return R.layout.fragment_article;
    }

    public interface OnInitContent {
        void onInitContent();
    }
}
