package me.codeminions.common.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerAdapter.MyHolder<T>> {

    private List<T> list;

    protected RecyclerAdapter(List<T> list){
        this.list = list;
    }

    protected RecyclerAdapter(){
        this(null);
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public abstract int getItemViewType(int position);

    @NonNull
    @Override
    public MyHolder<T> onCreateViewHolder(@NonNull ViewGroup viewGroup, int resId) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(resId, viewGroup, false);
        return onCreateViewHolder(view, resId);
    }

    public abstract MyHolder<T> onCreateViewHolder(View root, int resId);

    @Override
    public void onBindViewHolder(@NonNull MyHolder<T> holder, int i) {
        T data = list.get(i);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static abstract class MyHolder<T> extends RecyclerView.ViewHolder {
        T data;

        public MyHolder(View v){
            super(v);
        }

        void bind(T data){
            this.data = data;
            onBind(data);
        }

        protected abstract void onBind(T data);

    }
}
