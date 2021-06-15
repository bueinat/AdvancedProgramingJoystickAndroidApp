package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.testapp.databinding.ActivityJoystickBinding;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {

    AbstractViewModel VM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        VM = new ConcreteViewModel();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, JoystickActivity.class);
        intent.putExtra("ViewModel", (Serializable) VM);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, JoystickActivity.class);
        intent.putExtra("ViewModel", (Serializable) VM);
        startActivity(intent);
    }


}