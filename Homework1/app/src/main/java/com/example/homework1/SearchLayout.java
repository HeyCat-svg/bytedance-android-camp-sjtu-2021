package com.example.homework1;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SearchLayout extends LinearLayout {

    private EditText mEditView;
    private TextView mCancel;

    /* 接口库 其中有事件触发后需要执行的自定义函数接口
       接收外部对象的实现 对内只需要调用接口即可 */
    private OnSearchTextChangedListener mListener;

    public SearchLayout(Context context) {
        super(context);
        initView();
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.layout_search, this);

        mEditView = findViewById(R.id.edit);
        mCancel = findViewById(R.id.cancel);
        ImageView mImageView = findViewById(R.id.image);
        // 为什么这边还要再设一边 在xml中的src不是已经设了吗
        mImageView.setImageResource(R.drawable.icon_search);

        // 为输入控件加入事件
        mEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // do nothing
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 调用外部实现的方法
                if (mListener != null) {
                    mListener.afterChanged(s.toString());
                }
            }
        });

        // 为取消按钮添加事件
        mCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }

    /* 外部传入已经实现好的方法 */
    public void setOnSearchTextChangedListener(OnSearchTextChangedListener listener) {
        mListener = listener;
    }

    public interface OnSearchTextChangedListener {
        void afterChanged(String text);
    }
}
