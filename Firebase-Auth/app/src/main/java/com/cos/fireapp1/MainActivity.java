package com.cos.fireapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser!=null){
            Log.d(TAG, "onStart: email : "+currentUser.getEmail());
            Log.d(TAG, "onStart: Uid : "+currentUser.getUid());

            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{
            Log.d(TAG, "onStart: 로그인되지 않음");
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        
        
    }
}