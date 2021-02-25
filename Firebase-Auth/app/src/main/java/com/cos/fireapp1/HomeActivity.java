package com.cos.fireapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private Button btnLogout;
    private FirebaseAuth mAuth;
    private TextView tvDisName,tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth=FirebaseAuth.getInstance();

        FirebaseUser user=mAuth.getCurrentUser();

        tvDisName=findViewById(R.id.tv_displayname);
        tvEmail=findViewById(R.id.tv_email);


        tvDisName.setText(user.getDisplayName());
        tvEmail.setText(user.getEmail()+" 님 환영합니다.");

        btnLogout=findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        });
    }
}