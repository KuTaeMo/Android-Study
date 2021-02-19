package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rvTalkList;
    private TalkAdapter talkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ChatFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment=null;

            switch (item.getItemId()){
                case R.id.bottom_person:
                    selectedFragment=new PersonFragment();
                    break;
                case R.id.bottom_chat:
                    selectedFragment=new ChatFragment();
                    break;
                case R.id.bottom_tag:
                    selectedFragment=new TagFragment();
                    break;
                case R.id.bottom_more:
                    selectedFragment=new MoreFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return true;
        });
    }
}