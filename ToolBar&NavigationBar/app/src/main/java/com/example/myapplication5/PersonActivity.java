package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class PersonActivity extends AppCompatActivity {

    private ImageView ivBackPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        ivBackPerson=findViewById(R.id.iv_back_person);

        ivBackPerson.setOnClickListener(v -> {
            finish();
        });
    }
}