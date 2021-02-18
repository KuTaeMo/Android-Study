package com.example.myapplication5.helper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.myapplication5.MainActivity;
import com.example.myapplication5.PersonActivity;
import com.example.myapplication5.R;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewHelper {

    private static final String TAG = "NavigationViewHelper";

    public static void enable(Context context, NavigationView view){
        view.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if(id == R.id.item1){
                Log.d(TAG, "onCreate: 메뉴1 클릭됨");
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            }else if(id == R.id.item2){
                Log.d(TAG, "onCreate: 메뉴2 클릭됨");
                Intent intent = new Intent(context, PersonActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            }else if(id == R.id.item3){
                Log.d(TAG, "onCreate: 메뉴3 클릭됨");
            }

            return false;
        });
    }
}