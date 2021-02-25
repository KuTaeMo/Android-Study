package com.cos.a0225test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvStory,rvPost;
    private StoryAdapter storyAdapter;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager StoryManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager PostManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        rvStory=findViewById(R.id.rv_story);
        rvPost=findViewById(R.id.rv_post);

        rvStory.setLayoutManager(StoryManager);
        rvPost.setLayoutManager(PostManager);

        storyAdapter=new StoryAdapter();
        postAdapter=new PostAdapter();

        rvStory.setAdapter(storyAdapter);
        rvPost.setAdapter(postAdapter);
    }
}