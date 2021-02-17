package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetailTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailTitle=findViewById(R.id.tv_detail_titlle);
        Intent mainintent=getIntent();
        String title=mainintent.getStringExtra("title");
        tvDetailTitle.setText(title);
    }
}