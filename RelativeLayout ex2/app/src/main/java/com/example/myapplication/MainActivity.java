package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

//최초에 적어도 쓰레드 2개 돌아감 - 메인쓰레드, 이벤트 감지 쓰레드
// 메인 쓰레드 => onCreate실행 => 메인 쓰레드 종료	=> ui쓰레드 실행 (무한 루프[a버튼, b버튼])
//						=> 이벤트 스레드 확인
//						=> 이벤트 리스너(os) [a버튼, b버튼]
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    //매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행되는 함수 - 메인 메서드 (onCreate())
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //그림그리는 함수 (안에 액티비티 메인을 그림)=> 자바

        // onCreate 종료 시에 그림 그려짐.
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

        // 1. 파일(그림 사진= 카메라로 찍은 사진)
        // 2. 내부 DB = (SQL Lite) (주소록, 메모장, 달력(
        // 3. 외부 서버 = 외부 DB ( 인스타그램 사진 업로드)
        // 4. 메모리 엑세스 저장소 (제일 많이 씀) = 앱마다 달려있음 = 실제로는 한개 (키로 구분) = Shared Preference)
        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("title", "바람과 함께 사라지다.");
        editor.commit();
    }
}
