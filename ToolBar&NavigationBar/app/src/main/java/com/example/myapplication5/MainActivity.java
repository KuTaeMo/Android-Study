package com.example.myapplication5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.myapplication5.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.fontawesome.FontDrawable;
import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private ImageView ivPerson,ivMenu;
    private DrawerLayout drawer;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain=findViewById(R.id.toolbar_main);
        ivPerson=findViewById(R.id.iv_person);
        ivMenu=findViewById(R.id.iv_menu);
        drawer=findViewById(R.id.drawer);
        nv=findViewById(R.id.nv);

        setSupportActionBar(toolbarMain);

        ivMenu.setOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });

        ivPerson.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,PersonActivity.class);
            startActivity(intent);
        });

        NavigationViewHelper.enable(MainActivity.this,nv);
    }
}