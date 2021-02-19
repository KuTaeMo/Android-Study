package com.example.myapplication7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView rvTalkList;
    private TalkAdapter talkAdapter;
    // 강제성은 없지만 만들어줘야 함
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_chat,container,false);
        rvTalkList=view.findViewById(R.id.rv_talk_list);

        List<Talk> talks=new ArrayList<>();


        for (int i=0;i<30;i++){
            talks.add(new Talk(i,"안녕","유저"+i,i+"min ago"));
        }
//        talks.add(new Talk(1,"안녕1","유저1",R.drawable.mov01,"10"));
//        talks.add(new Talk(2,"안녕2","유저2",R.drawable.mov02,"10"));
//        talks.add(new Talk(3,"안녕3","유저3",R.drawable.mov03,"10"));
//        talks.add(new Talk(4,"안녕4","유저4",R.drawable.mov04,"10"));
//        talks.add(new Talk(5,"안녕5","유저5",R.drawable.mov05,"10"));
//        talks.add(new Talk(6,"안녕6","유저6",R.drawable.mov06,"10"));
//        talks.add(new Talk(7,"안녕7","유저7",R.drawable.mov07,"10"));
//        talks.add(new Talk(8,"안녕8","유저8",R.drawable.mov08,"10"));
//        talks.add(new Talk(9,"안녕9","유저9",R.drawable.mov09,"10"));
//        talks.add(new Talk(10,"안녕10","유저10",R.drawable.mov10,"10"));
//        talks.add(new Talk(11,"안녕11","유저11",R.drawable.mov11,"10"));
//        talks.add(new Talk(12,"안녕12","유저12",R.drawable.mov12,"10"));

        LinearLayoutManager manager = new LinearLayoutManager(container.getContext(), RecyclerView.VERTICAL, false);

        rvTalkList.setLayoutManager(manager);

        talkAdapter=new TalkAdapter(talks);

        rvTalkList.setAdapter(talkAdapter);
        return view;
    }
}
