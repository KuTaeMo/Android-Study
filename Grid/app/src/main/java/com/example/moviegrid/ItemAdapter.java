package com.example.moviegrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends BaseAdapter {

    List<Movie> movies=new ArrayList<>();

    public ItemAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MainActivity MainActivityContext=(MainActivity)parent.getContext();

        LayoutInflater inflater=(LayoutInflater)MainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.list_item,parent,false);
        TextView tvTitle=view.findViewById(R.id.tv_Title);
        ImageView imageView=view.findViewById(R.id.img_movie);

        tvTitle.setText(movies.get(position).getTitle());
        imageView.setBackgroundResource(movies.get(position).getPic());
        return view;
    }
}
