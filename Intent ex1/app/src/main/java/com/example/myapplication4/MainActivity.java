package com.example.myapplication4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;

// stack 생성
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext=MainActivity.this;
    private FloatingActionButton fabRoute;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabRoute=findViewById(R.id.fab_route);
        mainLayout=findViewById(R.id.main_layout);
        fabRoute.setOnClickListener(v -> {
            // 1. 현재 내 화면, 이동할 화면
            // 2. 현재 내 화면, 내부 앱의 이동할 화면
            //Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022227777"));
            // 인텐트 = 트럭(현재 내 위치, 이동할 위치 정보, 이동할 때 가져갈 박스)
            // 다른 앱으로 이동 = 트럭(상대방 앱의 키, 데이터)
            User user=new User();
            user.setId(1);
            user.setUsername("cos");
            user.setPassword("1234");

            // Bundle (택배 박스)
//            Bundle bundle=new Bundle();
//            bundle.putSerializable("user",user);
//            getIntent().putExtra("userBundle","bundle");

            // gson으로 json 변환 putExtra로 넘기고 gson으로 자바 오브젝트 변환\


            // serializable
            Intent intent=new Intent(MainActivity.this, SubActivity.class);
            intent.putExtra("username","ssar");
            intent.putExtra("user",user);
            
            startActivityForResult(intent,300);
        });
    }

    // finish() 될 때 콜백되는 함수
    // setResult() 함수의 파라미터가 전달됨.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: 실행됨");
        Log.d(TAG, "requestCode: " + requestCode);
        Log.d(TAG, "resultCode: "+resultCode);

        if (requestCode == 300) { // 서브 액티비티에서 돌아왔다.
            if (resultCode == 1) {   // 로직 성공
                //Toast.makeText(mContext, "인증 성공함 : "+data.getStringExtra("auth"), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout,"인증성공함", BaseTransientBottomBar.LENGTH_LONG).show();
            } else {                // 로직 실패
                Toast.makeText(mContext, "인증 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }
}