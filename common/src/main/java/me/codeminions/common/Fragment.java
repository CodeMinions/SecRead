package me.codeminions.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class Fragment extends android.support.v4.app.Fragment {

    protected View mRoot;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRoot == null){
            int layId = getContentId();
            mRoot = inflater.inflate(layId, container, false);
            initWidget(mRoot);
        }else{
            if(mRoot.getParent() != null){
                ((ViewGroup)mRoot.getParent()).removeView(mRoot);
            }
        }

        return mRoot;
    }
    protected void initArgs(Bundle bundle){}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        initData();
    }

    public abstract int getContentId();

    protected void initWidget(View root){}

    protected void initData(){}
}
