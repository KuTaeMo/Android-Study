package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication4.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "SubActivity";
    private FloatingActionButton fabPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // intent 값 받기
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        Log.d(TAG, "<intent> username : "+username);

        // 1. serialize 로 넘긴 값 받기
        Log.d(TAG, "<1. Serialize> user: "+intent.getSerializableExtra("user"));

        // 2. Bundle 로 넘긴 값 받기
        Bundle bundle = intent.getBundleExtra("userBundle");
        Log.d(TAG, "<2. Bundle> userBundle: "+bundle.getSerializable("user"));

        // 3. Gson 으로 넘긴 값 받기
        Gson gson=new Gson();
        String juser=intent.getStringExtra("GsonUser");
        User JConvertUser=gson.fromJson(juser,User.class);
        Log.d(TAG, "<3. Gson> Gsonuser :"+JConvertUser);

        fabPop = findViewById(R.id.fab_pop);
        fabPop.setOnClickListener(v -> {
            // 인증이 성공함
            Intent newIntent = new Intent();
            newIntent.putExtra("auth", "ok");
            setResult(1, newIntent);
            finish(); // pop
        });
    }
}