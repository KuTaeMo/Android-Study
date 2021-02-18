package com.example.myapplication5;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>{

    private static final String TAG = "NoteAdapter";
    private final List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public void additem(Note note){
        notes.add(note);
        notifyDataSetChanged();
    }

    public void removeitem(int position){
        notes.remove(position);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.note_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(notes.get(position));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;
        private TextView tvSubTitle;
        private TextView tvMin;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle=itemView.findViewById(R.id.tv_Title);
            tvSubTitle=itemView.findViewById(R.id.tv_SubTitle);
            tvMin=itemView.findViewById(R.id.tv_Min);

            itemView.setOnClickListener(v -> {
                Log.d(TAG, "MyViewHolder: 삭제됨"+getAdapterPosition());
                
            });


        }

        public void setItem(Note note){
            tvTitle.setText(note.getTitle());
            tvSubTitle.setText(note.getSubTitle());
            tvMin.setText(note.getMin().toString()+"min");
        }
    }
}
