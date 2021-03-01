package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SearchAdapter mSearchAdapter = new SearchAdapter();

    // 头顶上的搜索框
    private SearchLayout mSearchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mRecyclerView = findViewById(R.id.rv);
        // 这步是干什么用的
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置RecyclerView组织数据的方法 只有在adapter中执行notifyDataSetChanged()才会开始绘制
        mRecyclerView.setAdapter(mSearchAdapter);

        // 这里设置final的意义在哪
        final List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add("这是第 " + i + " 行");
        }
        // 绑定数据 执行notifyDataSetChanged() 开始绘制
        mSearchAdapter.notifyItems(items);

        mSearchLayout = findViewById(R.id.search);
        // 实现search中的回调接口   吐槽：有点像react上层将函数指针下传 下层执行间接实现数据逆流
        mSearchLayout.setOnSearchTextChangedListener(new SearchLayout.OnSearchTextChangedListener() {
            @Override
            public void afterChanged(String text) {
                List<String> filters = new ArrayList<>();
                for (String item : items) {
                    if (item.contains(text)) {
                        filters.add(item);
                    }
                }
                mSearchAdapter.notifyItems(filters);
            }
        });
    }
}