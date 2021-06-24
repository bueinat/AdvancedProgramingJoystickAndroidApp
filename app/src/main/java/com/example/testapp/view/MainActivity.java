package com.example.testapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;


import java.io.Serializable;
import java.net.Inet6Address;
import java.net.InetAddress;

import com.example.testapp.R;
import com.example.testapp.model.ConcreteModel;
import com.example.testapp.viewModel.AbstractViewModel;
import com.example.testapp.viewModel.ConcreteViewModel;


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