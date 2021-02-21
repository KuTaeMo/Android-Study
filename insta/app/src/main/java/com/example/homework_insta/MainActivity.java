package com.example.homework_insta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_navigation);



        bottomNavigationView.getMenu().getItem(4).setChecked(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PersonFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment=null;

            switch (item.getItemId()){
                case R.id.bottom_home:
                    selectedFragment=new HomeFragment();
                    break;
                case R.id.bottom_serach:
                    selectedFragment=new SearchFragment();
                    break;
                case R.id.bottom_add:
                    selectedFragment=new AddFragment();
                    break;
                case R.id.bottom_fav:
                    selectedFragment=new FavFragment();
                    break;
                case R.id.bottom_person:
                    selectedFragment=new PersonFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return true;
        });
    }
}