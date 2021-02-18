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

    private RecyclerView rvNoteList;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Note> notes = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            notes.add(new Note(i,"Title"+i,"SubTitle"+i,i+10));
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

        rvNoteList=findViewById(R.id.rv_note_list);
        rvNoteList.setLayoutManager(manager);

        noteAdapter=new NoteAdapter(notes);

        rvNoteList.setAdapter(noteAdapter);
    }
}