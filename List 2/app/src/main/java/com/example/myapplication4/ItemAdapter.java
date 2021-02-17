package com.example.myapplication4;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

// 1. 컬렉션 정보
public class ItemAdapter extends BaseAdapter {

    List<Movie> movies=new ArrayList<>();

    public ItemAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    // 전체크기를 확인하기 위해서 필요(나도, 어댑터도)
    @Override
    public int getCount() {
        return movies.size();
    }

    // 클릭하거나 어떤 이벤트 발생 시에 컬렉션 정보를 확인하기 위해 필요
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // LayoutInflater inflater2=LayoutInflater.from(context);
    // 객체를 생성해서 그림을 그리는 함수
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d(TAG, "getView: "+position);
        if(convertView==null){
            Log.d(TAG, "converView가 null입니다.");
        }else{
            Log.d(TAG, "converView가 null이 아닙니다.");
        }
        // 1. 부모 컨텍스트 가져오기 (context <- MainActivity)
        Context context=parent.getContext();
        MainActivity MainActivityContext=(MainActivity)parent.getContext();

        // 2. 인플레이터 객체 생성 완료 (context가 꼭 있어야 함)
        LayoutInflater inflater=(LayoutInflater)MainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 강제성이 없어서!! 컨버트뷰를 재사용 안함!
        View view=inflater.inflate(R.layout.list_item,parent,false);
        TextView tvTitle=view.findViewById(R.id.tv_title);
        TextView tvSubTitle=view.findViewById(R.id.tv_subtitle);
        tvTitle.setText(movies.get(position).getTitle());
        tvSubTitle.setText(movies.get(position).getTitle());

        view.setOnClickListener(v -> {
            //Toast.makeText(context, "클릭됨"+position, Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivityContext,DetailActivity.class);
            intent.putExtra("title",movies.get(position).getTitle());
            MainActivityContext.startActivity(intent);
        });

        view.setOnLongClickListener(v -> {
            Toast.makeText(MainActivityContext, "롱클릭됨"+position, Toast.LENGTH_SHORT).show();
            movies.remove(position);
            Log.d(TAG, "movies 사이즈 : "+movies.size());
            this.notifyDataSetChanged(); // 데이터 변경 후 UI 동기화 시 호출해야 함 (지우고 다시 그림)
            return true;
        });

        return view;
    }
}
