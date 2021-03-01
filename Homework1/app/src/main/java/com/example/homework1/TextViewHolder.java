package com.example.homework1;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* RecyclerView中的一个个小格子 同时实现view的点击事件
 * 妙啊 一个holder同时处理view的内容和view的点击事件 */
public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mTextView;

    public TextViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.text);
        // 注册listener
        itemView.setOnClickListener(this);
    }

    public void bind(String text) {
        mTextView.setText(text);
    }

    @Override
    public void onClick(View v) {
        // jump to ShowItemActivity
        Intent intent = new Intent(v.getContext(), ShowItemActivity.class);
        // 这里的mTextView实际上是传进来的参数v的一个控件 即 mTextView = v.findViewById(R.id.text)
        intent.putExtra("extra", mTextView.getText().toString());

        v.getContext().startActivity(intent);
    }
}
