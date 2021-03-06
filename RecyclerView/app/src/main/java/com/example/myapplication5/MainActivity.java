package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.fontawesome.FontDrawable;
import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUserList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            users.add(new User(i, "user" + i));
        }

//        //그리드 레이아웃
//        GridLayoutManager gridLayoutManager
//                = new GridLayoutManager(this, 2);
//
//        //가로 레이아웃
//        LinearLayoutManager horizonalLayoutManager
//                = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
//
//        //세로 레이아웃
//        LinearLayoutManager linearLayoutManager
//                = new LinearLayoutManager(this);


        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvUserList = findViewById(R.id.rv_user_list);
        rvUserList.setLayoutManager(manager);

        userAdapter = new UserAdapter(users);

        rvUserList.setAdapter(userAdapter);
    }
}