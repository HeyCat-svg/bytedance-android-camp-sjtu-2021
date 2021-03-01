package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        // get content of a specified item
        String extra = getIntent().getStringExtra("extra");

        // get text holder
        TextView textView = findViewById(R.id.item_content);
        textView.setText(extra);
    }
}