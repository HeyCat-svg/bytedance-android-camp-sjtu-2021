package com.example.homework1;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/* 告诉RecyclerView怎么组织数组为列表视图 相当于js中的map()*/
public class SearchAdapter extends RecyclerView.Adapter<TextViewHolder> {
    @NonNull
    private List<String> mItems = new ArrayList<>();

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建列表中的单元格 返回的就是最终呈现的单元格
        return new TextViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_text, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void notifyItems(@NonNull List<String> items) {
        mItems.clear();
        mItems.addAll(items);
        // 源数据变动 通知RecyclerView刷新视图
        notifyDataSetChanged();
    }
}
