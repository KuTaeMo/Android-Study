package com.cos.a0225test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StroyViewHolder>{


    @NonNull
    @Override
    public StroyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.story_item,parent,false);
        return new StroyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StroyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class StroyViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView v2;
        private TextView tv1;

        public StroyViewHolder(@NonNull View itemView) {
            super(itemView);
            v2=itemView.findViewById(R.id.story_pf);
            tv1=itemView.findViewById(R.id.textView2);
        }
    }
}
