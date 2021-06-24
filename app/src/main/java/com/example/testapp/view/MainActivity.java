package com.example.testapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;


import com.example.testapp.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, JoystickActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, JoystickActivity.class);
        startActivity(intent);
    }


}