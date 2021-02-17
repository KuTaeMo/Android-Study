package com.example.moviegrid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity2";
    private Context mContext=MainActivity.this;
    private GridView GvMoive;

    private int getId(String type, String name){
        int picId=getResources().getIdentifier("com.example.moviegrid:"+type+"/"+name,null,null);
        return picId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GvMoive=findViewById(R.id.gv_movie);

        List<Movie> movies=new ArrayList<>();

        int a[]={};

        for(int i=1;i<13;i++){
            a[i-1]=getId("drawable","mov0"+i);
        }

        for(int i=0;i<12;i++){
            movies.add(new Movie(i,"제목"+(i+1),getId("drawable","mov0"+(i+1))));
        }

        ItemAdapter adapter=new ItemAdapter(movies);

        GvMoive.setAdapter(adapter);
    }
}